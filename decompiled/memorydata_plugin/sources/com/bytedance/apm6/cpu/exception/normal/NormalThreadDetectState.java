package com.bytedance.apm6.cpu.exception.normal;

import android.os.Looper;
import android.os.Process;
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
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.logging.log4j.message.ParameterizedMessage;

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

    public NormalThreadDetectState(CpuExceptionStateMachine r7) {
        super(r7);
        this.startTime = 0;
        this.loadList = new CopyOnWriteArrayList();
        this.threadExceptionReportList = new CopyOnWriteArrayList();
        this.threadExceptionCacheList = new CopyOnWriteArrayList();
        final long r2 = 0;
        final long r4 = 1000;
        this.detectTask = new AnonymousClass1(this, r2, r4);
    }

    static /* synthetic */ void access$000(NormalThreadDetectState r0) {
        r0.judge();
    }

    private void assembleStackAndAddToReport(ThreadExceptionItem r9, Thread r10, StringBuilder r11) {
        StackTraceElement[] r12 = r10.getStackTrace();
        int r0 = r12.length;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= r0) goto L9;
        StackTraceElement r5 = r12[r2];
        r3 = r3 + 1;
        r11.append("\tat ").append(r5.getClassName()).append(".").append(r5.getMethodName()).append("(").append(r5.getFileName()).append(ParameterizedMessage.ERROR_MSG_SEPARATOR).append(r5.getLineNumber()).append(")\n");
        if (r3 > 40) goto L9;
        r2 = r2 + 1;
    L9:
        r9.setStack(r11.toString());
        r9.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r9.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r9);
        r11.setLength(0);
    }

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
        ThreadGroup r0 = Looper.getMainLooper().getThread().getThreadGroup();
        int r5 = r0.activeCount();
        int r6 = r5 + (r5 / 2);
        Thread[] r7 = new Thread[r6];
        r0.enumerate(r7);
        StringBuilder r1 = new StringBuilder();
        ListIterator<ThreadExceptionItem> r8 = this.threadExceptionCacheList.listIterator();
    L17:
        if (r8.hasNext() == false) goto L61;
        ThreadExceptionItem r9 = (ThreadExceptionItem) ZeusTransformUtils.preCheckCast(r8.next(), ThreadExceptionItem.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        if (r9.getThreadId() == Process.myPid()) goto L24;
        int r10 = 0;
    L27:
        if (r10 >= r6) goto L43;
        Thread r11 = r7[r10];
        if (r11 == null) goto L43;
        if (r9.getThreadName().equals(r11.getName()) == true) goto L40;
        if (r11.getName().length() <= 15) goto L38;
        if (r9.getThreadName().equals(r11.getName().substring(0, 15)) == true) goto L40;
    L38:
        r10 = r10 + 1;
    L40:
        if (r11 == Thread.currentThread()) goto L42;
        assembleStackAndAddToReport(r9, r11, r1);
    L42:
        boolean r12 = true;
    L44:
        if (r12 == true) goto L17;
        if (this.config.isCollectNativeThread() == false) goto L17;
        String r13 = k.a().d(r9.getThreadId());
        if (r13 == null) goto L17;
        r9.setStack(r13);
        r9.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r9.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r9);
    L43:
        r12 = false;
        goto L44
    L24:
        if (this.config.isCollectMainThread() == false) goto L17;
        assembleStackAndAddToReport(r9, Looper.getMainLooper().getThread(), r1);
    L61:
        Collections.sort(this.threadExceptionCacheList, new AnonymousClass2(this));
        LinkedList<ICpuDataService.ThreadCpuItem> r2 = new LinkedList();
        Iterator<ThreadExceptionItem> r3 = this.threadExceptionCacheList.iterator();
    L63:
        if (r3.hasNext() == false) goto L65;
        ThreadExceptionItem r4 = (ThreadExceptionItem) ZeusTransformUtils.preCheckCast(r3.next(), ThreadExceptionItem.class, "com.obric.memorydata.plugin");
        r2.add(new ICpuDataService.ThreadCpuItem(r4.getThreadName(), r4.getCpuUsage(), r4.getThreadId()));
        goto L63
    L65:
        CurrentCpuDataHolder.getInstance().refreshExceptionTopThreadData(r2);
        this.threadExceptionCacheList.clear();
        return;
    L50:
        ListIterator<ThreadExceptionItem> r14 = this.threadExceptionCacheList.listIterator();
    L52:
        if (r14.hasNext() == false) goto L61;
        ThreadExceptionItem r15 = (ThreadExceptionItem) ZeusTransformUtils.preCheckCast(r14.next(), ThreadExceptionItem.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L52;
        if (r15.getThreadId() != Process.myPid()) goto L60;
        if (this.config.isCollectMainThread() == false) goto L52;
    L60:
        r15.setWeight(String.format("%.2f", new Object[]{Double.valueOf(r15.getCpuUsage() / this.config.getMaxThreadCpuRate())}));
        this.threadExceptionReportList.add(r15);
        goto L52
    }

    private long getMaxJudgeInterval() {
        CpuExceptionConfig r4 = this.config;
        if (r4 != null) goto L7;
        return 30000;
    L7:
        return ((long) r4.getThreadDetectInterval()) * 1000;
    }

    private void judge() {
        if (CpuExceptionJudgeHelper.isNeedSkipJudge() == false) goto L6;
        reset();
        this.machine.onProcessDetect();
        return;
    L6:
        boolean r0 = judgeProcessLoad();
        if ((System.currentTimeMillis() - this.startTime) < getMaxJudgeInterval()) goto L10;
        reactOnFinish();
        return;
    L10:
        if (r0 == true) goto L13;
        cpuExceptionLog("not over process threshold");
        this.threadExceptionCacheList.clear();
        return;
    L13:
        collectThreadException();
    }

    private boolean judgeProcessLoad() {
        double r0 = CpuLoadCollector.collectSpeed();
        this.loadList.add(Double.valueOf(r0));
        return CpuExceptionJudgeHelper.judge(this.config, r0, this.isBackground);
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
        Iterator<Double> r1 = this.loadList.iterator();
        double r4 = 0.0d;
        double r9 = 0.0d;
    L9:
        if (r1.hasNext() == false) goto L14;
        double r6 = ((Double) ZeusTransformUtils.preCheckCast(r1.next(), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r9 >= r6) goto L13;
        r9 = r6;
    L13:
        r4 = r4 + r6;
        goto L9
    L14:
        cpuExceptionLog("report exception data, exception thread size is: " + this.threadExceptionReportList.size());
        double r5 = r4 / ((double) this.loadList.size());
        LinkedList r2 = new LinkedList();
        String[] r7 = CpuExceptionJudgeHelper.getCacheScene().split("#");
        String r12 = null;
        if (this.isBackground == false) goto L38;
        if (this.config.getBackSceneMaxSpeedMap().isEmpty() == true) goto L59;
        int r11 = r7.length;
        int r14 = 0;
        double r15 = 0.0d;
    L19:
        if (r14 >= r11) goto L33;
        String r13 = r7[r14];
        if (this.config.getBackSceneMaxSpeedMap().containsKey(r13) == false) goto L32;
        double r3 = ((Double) ZeusTransformUtils.preCheckCast(this.config.getBackSceneMaxSpeedMap().get(r13), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r3 < 0.0d) goto L32;
        if (r15 >= r3) goto L30;
        r15 = r3;
        r12 = r13;
    L30:
        if (r5 <= r3) goto L32;
        r2.add(r13);
    L32:
        r14 = r14 + 1;
        goto L19
    L33:
        if (r12 == null) goto L59;
        if (r2.contains(r12) == false) goto L59;
    L57:
        r2.remove(r12);
        r2.add(0, r12);
    L59:
        if (r2.isEmpty() == true) goto L61;
    L68:
        CpuExceptionManager.getInstance().setLastExceptionTimestamp(System.currentTimeMillis());
        ApmCpuManager.ICpuExceptionListener r8 = CpuExceptionManager.getInstance().getExceptionListener();
        if (r8 == null) goto L72;
        r8.onException(r5);
    L72:
        if (r2.isEmpty() == true) goto L74;
        String r10 = ListUtils.arrayToString(r2.toArray(), "#");
        if (this.isBackground == false) goto L91;
        if (r5 <= this.config.getMaxProcessBackCpuSpeed()) goto L91;
        StringBuilder r16 = new StringBuilder().append(r10).append("#").append(CpuNormalExceptionEvent.KEY_MAX_BACKGROUND);
    L89:
        r10 = r16.toString();
    L95:
        String r17 = r10;
    L96:
        Monitor.record(new CpuNormalExceptionEvent(r5, r9, this.threadExceptionReportList, r17, this.isBackground));
    L97:
        reset();
        this.machine.onCoolDown();
        return;
    L91:
        if (this.isBackground == true) goto L95;
        if (r5 <= this.config.getMaxProcessForeCpuSpeed()) goto L95;
        r16 = new StringBuilder().append(r10).append("#").append(CpuNormalExceptionEvent.KEY_MAX_FOREGROUND);
        goto L89
    L74:
        if (this.isBackground == false) goto L79;
        if (r5 <= this.config.getMaxProcessBackCpuSpeed()) goto L79;
        r17 = CpuNormalExceptionEvent.KEY_MAX_BACKGROUND;
    L79:
        if (this.isBackground == false) goto L81;
    L83:
        r10 = "";
        goto L95
    L81:
        if (r5 <= this.config.getMaxProcessForeCpuSpeed()) goto L83;
        r17 = CpuNormalExceptionEvent.KEY_MAX_FOREGROUND;
        goto L96
    L61:
        if (this.isBackground == false) goto L65;
        if (r5 > this.config.getMaxProcessBackCpuSpeed()) goto L68;
    L65:
        if (this.isBackground == true) goto L97;
        if (r5 <= this.config.getMaxProcessForeCpuSpeed()) goto L97;
    L38:
        if (this.config.getForeSceneMaxSpeedMap().isEmpty() == true) goto L59;
        int r18 = r7.length;
        int r19 = 0;
        double r110 = 0.0d;
    L40:
        if (r19 >= r18) goto L54;
        String r111 = r7[r19];
        if (this.config.getForeSceneMaxSpeedMap().containsKey(r111) == true) goto L44;
        int r112 = r18;
    L53:
        r19 = r19 + 1;
        r18 = r112;
        goto L40
    L44:
        r112 = r18;
        double r113 = ((Double) ZeusTransformUtils.preCheckCast(this.config.getForeSceneMaxSpeedMap().get(r111), Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r113 < 0.0d) goto L53;
        if (r110 >= r113) goto L51;
        r12 = r111;
        r110 = r113;
    L51:
        if (r5 <= r113) goto L53;
        r2.add(r111);
        goto L53
    L54:
        if (r12 == null) goto L59;
        if (r2.contains(r12) == false) goto L59;
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
    public void onEnterThisState(CpuExceptionConfig r3, boolean r4) {
        super.onEnterThisState(r3, r4);
        this.config = r3;
        this.startTime = System.currentTimeMillis();
        this.isBackground = r4;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.detectTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r1) {
        super.onLifeCycleChange(r1);
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
