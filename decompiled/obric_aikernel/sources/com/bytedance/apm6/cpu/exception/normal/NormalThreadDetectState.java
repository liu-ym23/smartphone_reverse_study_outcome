package com.bytedance.apm6.cpu.exception.normal;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import androidx.work.WorkRequest;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionJudgeHelper;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.CpuLoadCollector;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.cpu.exception.ThreadCpuExceptionUtils;
import com.bytedance.apm6.cpu.exception.ThreadExceptionItem;
import com.bytedance.apm6.cpu.service.CurrentCpuDataHolder;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.service.perf.ICpuDataService;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.monitor.collector.k;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
class NormalThreadDetectState extends BaseCpuExceptionState {
    private static final long DETECT_INTERVAL = 1000;
    private static final int LIMIT_STACK_DEPTH = 40;
    private static final int MAX_JUDGE_TIME = 30000;
    private CpuExceptionConfig config;
    private AsyncTask detectTask;
    private boolean isBackground;
    private List<Double> loadList;
    private long startTime;
    private List<ThreadExceptionItem> threadExceptionCacheList;
    private List<ThreadExceptionItem> threadExceptionReportList;

    public NormalThreadDetectState(CpuExceptionStateMachine r10) {
        super(r10);
        this.startTime = 0;
        this.loadList = new CopyOnWriteArrayList();
        this.threadExceptionReportList = new CopyOnWriteArrayList();
        this.threadExceptionCacheList = new CopyOnWriteArrayList();
        final long r11 = 0;
        final long r12 = 1000;
        this.detectTask = new AnonymousClass1(this, r11, r12);
    }

    static /* synthetic */ void access$000(NormalThreadDetectState r10) {
        r10.judge();
    }

    private void assembleStackAndAddToReport(ThreadExceptionItem r10, Thread r11, StringBuilder r12) {
        StackTraceElement[] r13 = r11.getStackTrace();
        int r14 = r13.length;
        int r15 = 0;
        int r16 = 0;
    L4:
        if (r15 >= r14) goto L9;
        StackTraceElement r17 = r13[r15];
        r16 = r16 + 1;
        r12.append("\tat ");
        r12.append(r17.getClassName());
        r12.append(".");
        r12.append(r17.getMethodName());
        r12.append("(");
        r12.append(r17.getFileName());
        r12.append(":");
        r12.append(r17.getLineNumber());
        r12.append(")\n");
        if (r16 > 40) goto L9;
        r15 = r15 + 1;
    L9:
        r10.setStack(r12.toString());
        r10.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r10.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r10);
        r12.setLength(0);
    }

    @SuppressLint({"CI_DefaultLocale"})
    private void collectThreadException() {
        if (this.threadExceptionCacheList.isEmpty() == false) goto L6;
        ThreadCpuExceptionUtils.getThreadInfo(Process.myPid(), this.threadExceptionCacheList);
        cpuExceptionLog("over process threshold, first collect thread info, list size: " + this.threadExceptionCacheList.size());
        return;
    L6:
        ThreadCpuExceptionUtils.filterThreads(Process.myPid(), this.threadExceptionCacheList, this.config.getMaxThreadCpuRate(), this.config.getMaxThreadCpuRateMap());
        cpuExceptionLog("over process threshold, second collect thread info, list size after filter is: " + this.threadExceptionCacheList.size());
        if (this.threadExceptionCacheList.isEmpty() == false) goto L10;
        return;
    L10:
        if (this.threadExceptionCacheList.size() <= 10) goto L14;
        this.threadExceptionCacheList.clear();
        return;
    L14:
        if (CpuExceptionManager.getInstance().needFetchStack() == false) goto L50;
        ThreadGroup r10 = Looper.getMainLooper().getThread().getThreadGroup();
        int r11 = r10.activeCount();
        int r12 = r11 + (r11 / 2);
        Thread[] r13 = new Thread[r12];
        r10.enumerate(r13);
        StringBuilder r14 = new StringBuilder();
        ListIterator<ThreadExceptionItem> r15 = this.threadExceptionCacheList.listIterator();
    L17:
        if (r15.hasNext() == false) goto L61;
        ThreadExceptionItem r16 = r15.next();
        if (r16 == null) goto L17;
        if (r16.getThreadId() == Process.myPid()) goto L24;
        int r17 = 0;
    L27:
        if (r17 >= r12) goto L43;
        Thread r18 = r13[r17];
        if (r18 == null) goto L43;
        if (r16.getThreadName().equals(r18.getName()) == true) goto L40;
        if (r18.getName().length() <= 15) goto L38;
        if (r16.getThreadName().equals(r18.getName().substring(0, 15)) == true) goto L40;
    L38:
        r17 = r17 + 1;
    L40:
        if (r18 == Thread.currentThread()) goto L42;
        assembleStackAndAddToReport(r16, r18, r14);
    L42:
        boolean r19 = true;
    L44:
        if (r19 == true) goto L17;
        if (this.config.isCollectNativeThread() == false) goto L17;
        String r20 = k.n().h(r16.getThreadId());
        if (r20 == null) goto L17;
        r16.setStack(r20);
        r16.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r16.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r16);
    L43:
        r19 = false;
        goto L44
    L24:
        if (this.config.isCollectMainThread() == false) goto L17;
        assembleStackAndAddToReport(r16, Looper.getMainLooper().getThread(), r14);
    L61:
        Collections.sort(this.threadExceptionCacheList, new AnonymousClass2(this));
        LinkedList<ICpuDataService.ThreadCpuItem> r21 = new LinkedList();
        Iterator<ThreadExceptionItem> r22 = this.threadExceptionCacheList.iterator();
    L63:
        if (r22.hasNext() == false) goto L65;
        ThreadExceptionItem r23 = r22.next();
        r21.add(new ICpuDataService.ThreadCpuItem(r23.getThreadName(), r23.getCpuUsage(), r23.getThreadId()));
        goto L63
    L65:
        CurrentCpuDataHolder.getInstance().refreshExceptionTopThreadData(r21);
        this.threadExceptionCacheList.clear();
        return;
    L50:
        ListIterator<ThreadExceptionItem> r24 = this.threadExceptionCacheList.listIterator();
    L52:
        if (r24.hasNext() == false) goto L61;
        ThreadExceptionItem r25 = r24.next();
        if (r25 == null) goto L52;
        if (r25.getThreadId() != Process.myPid()) goto L60;
        if (this.config.isCollectMainThread() == false) goto L52;
    L60:
        r25.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r25.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r25);
        goto L52
    }

    private long getMaxJudgeInterval() {
        CpuExceptionConfig r10 = this.config;
        if (r10 != null) goto L7;
        return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
    L7:
        return ((long) r10.getThreadDetectInterval()) * 1000;
    }

    private void judge() {
        if (CpuExceptionJudgeHelper.isNeedSkipJudge() == false) goto L6;
        reset();
        this.machine.onProcessDetect();
        return;
    L6:
        boolean r10 = judgeProcessLoad();
        if ((System.currentTimeMillis() - this.startTime) < getMaxJudgeInterval()) goto L10;
        reactOnFinish();
        return;
    L10:
        if (r10 == true) goto L13;
        cpuExceptionLog("not over process threshold");
        this.threadExceptionCacheList.clear();
        return;
    L13:
        collectThreadException();
    }

    private boolean judgeProcessLoad() {
        double r10 = CpuLoadCollector.collectSpeed();
        this.loadList.add(Double.valueOf(r10));
        return CpuExceptionJudgeHelper.judge(this.config, r10, this.isBackground);
    }

    private void reactOnFinish() {
        if (this.loadList.isEmpty() == false) goto L5;
    L99:
        cpuExceptionLog("finish collect, but no exception thread is found");
        reset();
        this.machine.onProcessDetect();
        return;
    L5:
        if (this.threadExceptionReportList.isEmpty() == true) goto L99;
        Iterator<Double> r10 = this.loadList.iterator();
        double r11 = 0.0d;
        double r12 = 0.0d;
    L9:
        if (r10.hasNext() == false) goto L14;
        double r13 = r10.next().doubleValue();
        if (r12 >= r13) goto L13;
        r12 = r13;
    L13:
        r11 = r11 + r13;
        goto L9
    L14:
        cpuExceptionLog("report exception data, exception thread size is: " + this.threadExceptionReportList.size());
        double r14 = r11 / ((double) this.loadList.size());
        LinkedList r15 = new LinkedList();
        String[] r16 = CpuExceptionJudgeHelper.getCacheScene().split("#");
        String r17 = null;
        if (this.isBackground == false) goto L38;
        if (this.config.getBackSceneMaxSpeedMap().isEmpty() == true) goto L59;
        int r18 = r16.length;
        int r19 = 0;
        double r110 = 0.0d;
    L19:
        if (r19 >= r18) goto L33;
        String r111 = r16[r19];
        if (this.config.getBackSceneMaxSpeedMap().containsKey(r111) == false) goto L32;
        double r20 = this.config.getBackSceneMaxSpeedMap().get(r111).doubleValue();
        if (r20 < 0.0d) goto L32;
        if (r110 >= r20) goto L30;
        r110 = r20;
        r17 = r111;
    L30:
        if (r14 <= r20) goto L32;
        r15.add(r111);
    L32:
        r19 = r19 + 1;
        goto L19
    L33:
        if (r17 == null) goto L59;
        if (r15.contains(r17) == false) goto L59;
    L57:
        r15.remove(r17);
        r15.add(0, r17);
    L59:
        if (r15.isEmpty() == true) goto L61;
    L68:
        CpuExceptionManager.getInstance().setLastExceptionTimestamp(System.currentTimeMillis());
        ApmCpuManager.ICpuExceptionListener r21 = CpuExceptionManager.getInstance().getExceptionListener();
        if (r21 == null) goto L72;
        r21.onException(r14);
    L72:
        if (r15.isEmpty() == true) goto L74;
        String r22 = ListUtils.arrayToString(r15.toArray(), "#");
        if (this.isBackground == false) goto L91;
        if (r14 <= this.config.getMaxProcessBackCpuSpeed()) goto L91;
        StringBuilder r23 = new StringBuilder();
        r23.append(r22);
        r23.append("#");
        r23.append(CpuNormalExceptionEvent.KEY_MAX_BACKGROUND);
    L89:
        r22 = r23.toString();
    L95:
        String r112 = r22;
    L96:
        Monitor.record(new CpuNormalExceptionEvent(r14, r12, this.threadExceptionReportList, r112, this.isBackground));
    L97:
        reset();
        this.machine.onCoolDown();
        return;
    L91:
        if (this.isBackground == true) goto L95;
        if (r14 <= this.config.getMaxProcessForeCpuSpeed()) goto L95;
        r23 = new StringBuilder();
        r23.append(r22);
        r23.append("#");
        r23.append(CpuNormalExceptionEvent.KEY_MAX_FOREGROUND);
        goto L89
    L74:
        if (this.isBackground == false) goto L79;
        if (r14 <= this.config.getMaxProcessBackCpuSpeed()) goto L79;
        r112 = CpuNormalExceptionEvent.KEY_MAX_BACKGROUND;
    L79:
        if (this.isBackground == false) goto L81;
    L83:
        r22 = "";
        goto L95
    L81:
        if (r14 <= this.config.getMaxProcessForeCpuSpeed()) goto L83;
        r112 = CpuNormalExceptionEvent.KEY_MAX_FOREGROUND;
        goto L96
    L61:
        if (this.isBackground == false) goto L65;
        if (r14 > this.config.getMaxProcessBackCpuSpeed()) goto L68;
    L65:
        if (this.isBackground == true) goto L97;
        if (r14 <= this.config.getMaxProcessForeCpuSpeed()) goto L97;
    L38:
        if (this.config.getForeSceneMaxSpeedMap().isEmpty() == true) goto L59;
        int r24 = r16.length;
        int r25 = 0;
        double r113 = 0.0d;
    L40:
        if (r25 >= r24) goto L54;
        String r26 = r16[r25];
        if (this.config.getForeSceneMaxSpeedMap().containsKey(r26) == false) goto L53;
        double r114 = this.config.getForeSceneMaxSpeedMap().get(r26).doubleValue();
        if (r114 < 0.0d) goto L53;
        if (r113 >= r114) goto L51;
        r17 = r26;
        r113 = r114;
    L51:
        if (r14 <= r114) goto L53;
        r15.add(r26);
    L53:
        r25 = r25 + 1;
        goto L40
    L54:
        if (r17 == null) goto L59;
        if (r15.contains(r17) == false) goto L59;
        goto L57
    }

    private void reset() {
        this.loadList.clear();
        this.threadExceptionReportList.clear();
        this.threadExceptionCacheList.clear();
        this.startTime = 0;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r10, boolean r11) {
        super.onEnterThisState(r10, r11);
        this.config = r10;
        this.startTime = System.currentTimeMillis();
        this.isBackground = r11;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r10) {
        super.onLifeCycleChange(r10);
        reset();
        this.machine.onIdle();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        reset();
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.THREAD_DETECT;
    }
}
