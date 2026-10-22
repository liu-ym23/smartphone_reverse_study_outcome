package com.bytedance.apm6.frequency;

import android.os.Build;
import android.util.Log;
import android.util.Pair;
import com.bytedance.apm.l.b;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.bdlocation.trace.TraceCons;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FrequencyMonitor {
    private static final String COMMAND_CHANGE_TO_BACKGROUND = "command_change_to_background";
    private static final String COMMAND_CHANGE_TO_FRONT = "command_change_to_front";
    private static final String COMMAND_CHECK_BACKGROUND_EXCEPTION = "command_check_background_exception";
    private static final String COMMAND_CHECK_FRONT_EXCEPTION = "command_check_front_exception";
    private static final String COMMAND_REPORT_DATA = "command_report_data";
    private static final int MAX_ERROR_COUNT = 5;
    private static final String TAG = "APM-HighFrequency";
    private static final String THREAD_NAME = "APM-FrequencyMonitor";
    private static volatile FrequencyMonitor mIns;
    private long mBackgroundDuration;
    private AsyncTask mBackgroundExceptionCheckTask;
    private final HashMap<String, HashMap<String, Counter>> mBackgroundExceptionRecordingData;
    private final HashMap<String, HashMap<String, Counter>> mBackgroundRecordingData;
    private int mErrorCount;
    private long mFrontDuration;
    private AsyncTask mFrontExceptionCheckTask;
    private final HashMap<String, HashMap<String, Counter>> mFrontExceptionRecordingData;
    private final HashMap<String, HashMap<String, Counter>> mFrontRecordingData;
    private volatile boolean mInitSuccess;
    private volatile boolean mIsQueueWorking;
    private long mLastCheckExceptionTime;
    private long mLastRecordDurationTime;
    private DummyLifecycleListener mLifecycleListener;
    private FrequencyMonitorConfig mMonitorConfig;
    private BlockingQueue<RecordItem> mQueue;
    private AsyncTask mReportTimerTask;
    private HashMap<String, HashMap<String, Counter>> mUsingExceptionRecordingMap;
    private HashMap<String, HashMap<String, Counter>> mUsingRecordingMap;
    private volatile boolean showNotInitRemind;

    private FrequencyMonitor() {
        this.mIsQueueWorking = false;
        this.mInitSuccess = false;
        this.mFrontExceptionRecordingData = new HashMap();
        this.mBackgroundExceptionRecordingData = new HashMap();
        this.mFrontRecordingData = new HashMap();
        this.mBackgroundRecordingData = new HashMap();
        this.mFrontDuration = 0;
        this.mBackgroundDuration = 0;
        this.mLastRecordDurationTime = 0;
        this.mLastCheckExceptionTime = 0;
        this.mErrorCount = 0;
        this.showNotInitRemind = true;
    }

    static /* synthetic */ void access$000(FrequencyMonitor r0) {
        r0.onFront();
    }

    static /* synthetic */ void access$100(FrequencyMonitor r0) {
        r0.onBackground();
    }

    static /* synthetic */ void access$200(FrequencyMonitor r0) {
        r0.checkReport();
    }

    static /* synthetic */ void access$300(FrequencyMonitor r0, boolean r1) {
        r0.checkHasException(r1);
    }

    static /* synthetic */ void access$400(FrequencyMonitor r0) {
        r0.dispatchMessage();
    }

    static /* synthetic */ int access$500(FrequencyMonitor r0) {
        return r0.mErrorCount;
    }

    static /* synthetic */ int access$508(FrequencyMonitor r2) {
        int r0 = r2.mErrorCount;
        r2.mErrorCount = r0 + 1;
        return r0;
    }

    private boolean appendJsonArray(HashMap<String, HashMap<String, Counter>> r11, long r12, JSONObject r14, boolean r15) {
        JSONArray r0 = new JSONArray();
        Iterator<Map.Entry<String, HashMap<String, Counter>>> r13 = r11.entrySet().iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r13.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        Iterator r3 = ((HashMap) ZeusTransformUtils.preCheckCast(r1.getValue(), HashMap.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin");
        int r6 = ((Counter) ZeusTransformUtils.preCheckCast(r4.getValue(), Counter.class, "com.obric.memorydata.plugin")).getCount();
        float r7 = r6 / (r12 * 1.6666667E-5f);
        float r8 = (10000.0f * r7) / this.mMonitorConfig.getEventSamplingRate();
        if (r8 <= this.mMonitorConfig.getReportThresholdOfCategory(r2, r15)) goto L7;
        JSONObject r9 = new JSONObject();
        r9.putOpt(EventBody.KEY_CATEGORY, r2);
        r9.putOpt("key", r5);
        r9.putOpt(CommonConsts.COUNT_TYPE, Integer.valueOf(r6));
        r9.putOpt("frequency_per_min", Float.valueOf(Math.round(r7 * 100.0f) / 100.0f));
        r9.putOpt("frequency_reduction", Float.valueOf(Math.round(r8 * 100.0f) / 100.0f));
        r0.put(r9);
        goto L7
    L11:
        r14.putOpt("details", r0);
        if (r0.length() <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    private void changeState(boolean r3, long r4) {
        this.mFrontExceptionRecordingData.clear();
        this.mBackgroundExceptionRecordingData.clear();
        if (r3 == false) goto L5;
        this.mBackgroundDuration += r4;
        this.mUsingRecordingMap = this.mFrontRecordingData;
        HashMap<String, HashMap<String, Counter>> r5 = this.mFrontExceptionRecordingData;
    L6:
        this.mUsingExceptionRecordingMap = r5;
        return;
    L5:
        this.mFrontDuration += r4;
        this.mUsingRecordingMap = this.mBackgroundRecordingData;
        r5 = this.mBackgroundExceptionRecordingData;
        goto L6
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void checkAndReportException(boolean r20, long r21) {
        boolean r1 = r20 ? 1 : 0;
        if (r1 == false) goto L5;
        HashMap<String, HashMap<String, Counter>> r2 = this.mFrontExceptionRecordingData;
    L7:
        if (r2.isEmpty() == false) goto L9;
        return;
    L9:
        int r3 = this.mMonitorConfig.getExceptionReportTopCount();
        if (r3 > 0) goto L12;
        return;
    L12:
        HashMap r4 = new HashMap();
        HashMap r5 = new HashMap();
        Iterator<Map.Entry<String, HashMap<String, Counter>>> r6 = r2.entrySet().iterator();
    L14:
        if (r6.hasNext() == false) goto L25;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r7.getKey(), String.class, "com.obric.memorydata.plugin");
        List r10 = (List) ZeusTransformUtils.preCheckCast(r5.get(r9), List.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L18;
        r10 = new ArrayList();
        r5.put(r9, r10);
    L18:
        Iterator r8 = ((HashMap) ZeusTransformUtils.preCheckCast(r7.getValue(), HashMap.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L20:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r11 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.getKey(), String.class, "com.obric.memorydata.plugin");
        int r13 = ((Counter) ZeusTransformUtils.preCheckCast(r11.getValue(), Counter.class, "com.obric.memorydata.plugin")).getCount();
        r10.add(new Pair(r12, Integer.valueOf(r13)));
        Counter r14 = (Counter) ZeusTransformUtils.preCheckCast(r4.get(r9), Counter.class, "com.obric.memorydata.plugin");
        if (r14 == null) goto L23;
        r14.addCount(r13);
        goto L20
    L23:
        r4.put(r9, new Counter(r13));
        goto L20
    L25:
        Iterator r15 = r4.entrySet().iterator();
    L27:
        if (r15.hasNext() == false) goto L43;
        Map.Entry r16 = (Map.Entry) ZeusTransformUtils.preCheckCast(r15.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        float r17 = ((Counter) ZeusTransformUtils.preCheckCast(r16.getValue(), Counter.class, "com.obric.memorydata.plugin")).getCount() / (r21 * 1.6666667E-5f);
        float r18 = (10000.0f * r17) / this.mMonitorConfig.getEventSamplingRate();
        if (r18 <= this.mMonitorConfig.getExceptionThresholdOfCategory((String) ZeusTransformUtils.preCheckCast(r16.getKey(), String.class, "com.obric.memorydata.plugin"), r1)) goto L41;
        List r19 = (List) ZeusTransformUtils.preCheckCast(r5.get(r16.getKey()), List.class, "com.obric.memorydata.plugin");
        Collections.sort(r19, new AnonymousClass6(this));
        final JSONObject r110 = new JSONObject();
        JSONArray r111 = new JSONArray();
        int r112 = 0;
    L32:
        if (r112 >= Math.min(r3, r19.size())) goto L38;
        JSONObject r22 = new JSONObject();
        int r113 = r3;
        Iterator r114 = r15;
        Pair r23 = (Pair) ZeusTransformUtils.preCheckCast(r19.get(r112), Pair.class, "com.obric.memorydata.plugin");
        if (r112 != 0) goto L37;
        r110.putOpt("exception_reason", r23.first);
    L37:
        r22.putOpt("key", r23.first);
        r22.putOpt(CommonConsts.COUNT_TYPE, r23.second);
        r111.put(r22);
        r112 = r112 + 1;
        r3 = r113;
        r15 = r114;
        r5 = r5;
        goto L32
    L38:
        int r115 = r3;
        Iterator r116 = r15;
        HashMap r117 = r5;
        r110.putOpt("is_front", Integer.valueOf(r20 ? 1 : 0));
        r110.putOpt(EventBody.KEY_CATEGORY, r16.getKey());
        r110.putOpt("total_count", Integer.valueOf(((Counter) ZeusTransformUtils.preCheckCast(r16.getValue(), Counter.class, "com.obric.memorydata.plugin")).getCount()));
        r110.putOpt("duration", Long.valueOf(r21));
        r110.putOpt("frequency_per_min", Float.valueOf(Math.round(r17 * 100.0f) / 100.0f));
        r110.putOpt("frequency_reduction", Float.valueOf(Math.round(r18 * 100.0f) / 100.0f));
        r110.putOpt("sampling_rate", Integer.valueOf(this.mMonitorConfig.getEventSamplingRate()));
        r110.putOpt("top_data", r111);
        r110.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        b.a().a(new AnonymousClass7(this, r110));
        if (com.bytedance.apm.b.k() == false) goto L42;
        Log.i(TAG, "Report Exception:" + r110);
    L42:
        r1 = r20 ? 1 : 0;
        r3 = r115;
        r15 = r116;
        r5 = r117;
        goto L27
    L41:
        r115 = r3;
        r116 = r15;
        r117 = r5;
        goto L42
    L43:
        r2.clear();
        return;
    L5:
        r2 = this.mBackgroundExceptionRecordingData;
        goto L7
    }

    private void checkHasException(boolean r5) {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.mLastCheckExceptionTime;
        this.mLastCheckExceptionTime = r0;
        if (r5 == false) goto L5;
        String r6 = COMMAND_CHECK_FRONT_EXCEPTION;
    L6:
        enqueue(new RecordItem(r6, r2));
        return;
    L5:
        r6 = COMMAND_CHECK_BACKGROUND_EXCEPTION;
        goto L6
    }

    private void checkReport() {
        long r0 = System.currentTimeMillis();
        enqueue(new RecordItem(COMMAND_REPORT_DATA, r0 - this.mLastRecordDurationTime));
        this.mLastRecordDurationTime = r0;
    }

    private void dispatchMessage() {
        RecordItem r0 = (RecordItem) ZeusTransformUtils.preCheckCast(this.mQueue.take(), RecordItem.class, "com.obric.memorydata.plugin");
        if (r0.getCommand() == null) goto L19;
        long r3 = r0.getDuration();
        if (r0.getCommand().startsWith(COMMAND_CHANGE_TO_FRONT) == false) goto L8;
        changeState(true, r3);
    L20:
        r0.setUsing(false);
        return;
    L8:
        if (r0.getCommand().startsWith(COMMAND_CHANGE_TO_BACKGROUND) == false) goto L11;
        changeState(false, r3);
        goto L20
    L11:
        if (r0.getCommand().startsWith(COMMAND_CHECK_FRONT_EXCEPTION) == false) goto L14;
        checkAndReportException(true, r3);
        goto L20
    L14:
        if (r0.getCommand().startsWith(COMMAND_CHECK_BACKGROUND_EXCEPTION) == false) goto L17;
        checkAndReportException(false, r3);
        goto L20
    L17:
        if (r0.getCommand().startsWith(COMMAND_REPORT_DATA) == false) goto L20;
        reportDataInner(r3);
        goto L20
    L19:
        saveDataToRecoding(r0.getCategory(), r0.getKey());
        goto L20
    }

    private void enqueue(RecordItem r3) {
        if (this.mQueue.offer(r3) == true) goto L8;
        if (com.bytedance.apm.b.k() == false) goto L8;
        Log.i(TAG, "enqueue error,data:" + r3 + " size:" + this.mQueue.size());
    L8:
        if (this.mIsQueueWorking == true) goto L11;
        startWork();
        return;
    }

    public static FrequencyMonitor getInstance() {
        if (mIns != null) goto L15;
        monitor-enter(FrequencyMonitor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mIns != null) goto L9;
        mIns = new FrequencyMonitor();     // Catch: Throwable -> L11
    L9:
        monitor-exit(FrequencyMonitor.class);     // Catch: Throwable -> L11
    L15:
        return mIns;
    }

    private void onBackground() {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.mLastRecordDurationTime;
        this.mLastRecordDurationTime = r0;
        if (this.mMonitorConfig.enableExceptionMonitor() == false) goto L5;
        sendCheckExceptionTask(false);
    L5:
        enqueue(new RecordItem(COMMAND_CHANGE_TO_BACKGROUND, r2));
    }

    private void onFront() {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.mLastRecordDurationTime;
        this.mLastRecordDurationTime = r0;
        if (this.mMonitorConfig.enableExceptionMonitor() == false) goto L5;
        sendCheckExceptionTask(true);
    L5:
        enqueue(new RecordItem(COMMAND_CHANGE_TO_FRONT, r2));
    }

    private void reportDataInner(long r10) {
        HashMap<String, HashMap<String, Counter>> r0 = this.mUsingRecordingMap;
        HashMap<String, HashMap<String, Counter>> r1 = this.mFrontRecordingData;
        if (r0 != r1) goto L5;
        this.mFrontDuration += r10;
    L7:
        if (r1.isEmpty() == true) goto L9;
    L11:
        final JSONObject r11 = new JSONObject();
        boolean r12 = false;
        boolean r2 = true;
        if (this.mFrontRecordingData.isEmpty() == true) goto L17;
        JSONObject r3 = new JSONObject();
        if (appendJsonArray(this.mFrontRecordingData, this.mFrontDuration, r3, true) == false) goto L17;
        r3.putOpt("duration", Long.valueOf(this.mFrontDuration));
        r11.putOpt(CpuReportEvent.VALUE_FRONT, r3);
        r12 = true;
    L17:
        if (this.mBackgroundRecordingData.isEmpty() == true) goto L21;
        JSONObject r4 = new JSONObject();
        if (appendJsonArray(this.mBackgroundRecordingData, this.mBackgroundDuration, r4, false) == false) goto L21;
        r4.putOpt("duration", Long.valueOf(this.mBackgroundDuration));
        r11.putOpt(TraceCons.METRIC_BACKGROUND, r4);
    L22:
        if (r2 == false) goto L26;
        r11.putOpt("sampling_rate", Integer.valueOf(this.mMonitorConfig.getEventSamplingRate()));
        r11.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        b.a().a(new AnonymousClass8(this, r11));
        if (com.bytedance.apm.b.k() == false) goto L26;
        Log.i(TAG, "Report Data:" + r11);
    L26:
        this.mFrontRecordingData.clear();
        this.mBackgroundRecordingData.clear();
        this.mFrontDuration = 0;
        this.mBackgroundDuration = 0;
        return;
    L21:
        r2 = r12;
        goto L22
    L9:
        if (this.mBackgroundRecordingData.isEmpty() == false) goto L11;
        return;
    L5:
        this.mBackgroundDuration += r10;
        goto L7
    }

    private void saveDataToRecoding(String r6, String r7) {
        if (this.mMonitorConfig.enableFrequencyMonitor() == false) goto L13;
        HashMap<String, Counter> r0 = (HashMap) ZeusTransformUtils.preCheckCast(this.mUsingRecordingMap.get(r6), HashMap.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        r0 = new HashMap();
        this.mUsingRecordingMap.put(r6, r0);
        Counter r3 = new Counter(1);
    L7:
        r0.put(r7, r3);
        goto L13
    L8:
        Counter r4 = (Counter) ZeusTransformUtils.preCheckCast(r0.get(r7), Counter.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L11;
        r3 = new Counter(1);
        goto L7
    L11:
        r4.addCount(1);
    L13:
        if (this.mMonitorConfig.enableExceptionMonitor() == false) goto L23;
        HashMap<String, Counter> r1 = (HashMap) ZeusTransformUtils.preCheckCast(this.mUsingExceptionRecordingMap.get(r6), HashMap.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L18;
        r1 = new HashMap();
        this.mUsingExceptionRecordingMap.put(r6, r1);
        Counter r5 = new Counter(1);
    L17:
        r1.put(r7, r5);
        return;
    L18:
        Counter r8 = (Counter) ZeusTransformUtils.preCheckCast(r1.get(r7), Counter.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L21;
        r5 = new Counter(1);
        goto L17
    L21:
        r8.addCount(1);
        return;
    }

    private void sendCheckExceptionTask(boolean r15) {
        if (this.mBackgroundExceptionCheckTask != null) goto L5;
    L12:
        final long r4 = this.mMonitorConfig.getExceptionCheckInterval(false);
        final long r6 = this.mMonitorConfig.getExceptionCheckInterval(false);
        this.mBackgroundExceptionCheckTask = new AnonymousClass3(this, r4, r6);
        final long r10 = this.mMonitorConfig.getExceptionCheckInterval(true);
        final long r12 = this.mMonitorConfig.getExceptionCheckInterval(true);
        this.mFrontExceptionCheckTask = new AnonymousClass4(this, r10, r12);
    L13:
        this.mLastCheckExceptionTime = System.currentTimeMillis();
        AsyncTaskManager r0 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);
        if (r15 == false) goto L16;
        AsyncTask r14 = this.mFrontExceptionCheckTask;
    L17:
        r0.sendTask(r14);
        return;
    L16:
        r14 = this.mBackgroundExceptionCheckTask;
        goto L17
    L5:
        if (this.mFrontExceptionCheckTask == null) goto L12;
        AsyncTaskManager r1 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);
        if (r15 == false) goto L10;
        AsyncTask r2 = this.mBackgroundExceptionCheckTask;
    L11:
        r1.removeTask(r2);
        goto L13
    L10:
        r2 = this.mFrontExceptionCheckTask;
        goto L11
    }

    private void sendReportTask() {
        if (this.mReportTimerTask != null) goto L5;
        final long r3 = this.mMonitorConfig.getReportInterval();
        final long r5 = this.mMonitorConfig.getReportInterval();
        this.mReportTimerTask = new AnonymousClass2(this, r3, r5);
    L5:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.mReportTimerTask);
    }

    private synchronized void startMonitor(FrequencyMonitorConfig r4) {
        monitor-enter(this);
        if (r4 != null) goto L48;
    L46:
        monitor-exit(this);
        return;
    L48:
    L43:
        th = move-exception;
        throw th;
    L5:
        if (r4.enableFrequencyMonitor() == true) goto L9;
        if (r4.enableFrequencyMonitor() == false) goto L46;
    L9:
        if (this.mInitSuccess == true) goto L46;
        if (com.bytedance.apm.b.k() == false) goto L14;
        Log.i(TAG, "init:" + r4);     // Catch: Throwable -> L43
    L14:
        this.mMonitorConfig = r4;     // Catch: Throwable -> L43
        if (Build.VERSION.SDK_INT < 21) goto L18;
        BlockingQueue<RecordItem> r0 = new LinkedTransferQueue();     // Catch: Throwable -> L43
    L17:
        this.mQueue = r0;     // Catch: Throwable -> L43
        if (r4.enableFrequencyMonitor() == false) goto L22;
        sendReportTask();     // Catch: Throwable -> L43
    L22:
        this.mLastRecordDurationTime = System.currentTimeMillis();     // Catch: Throwable -> L43
        ActivityLifecycleService r1 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L43
        if (r1 == null) goto L39;
        boolean r2 = r1.isForeground();     // Catch: Throwable -> L43
        if (r2 == false) goto L27;
        HashMap<String, HashMap<String, Counter>> r3 = this.mFrontRecordingData;     // Catch: Throwable -> L43
    L28:
        this.mUsingRecordingMap = r3;     // Catch: Throwable -> L43
        if (r2 == false) goto L31;
        HashMap<String, HashMap<String, Counter>> r5 = this.mFrontExceptionRecordingData;     // Catch: Throwable -> L43
    L32:
        this.mUsingExceptionRecordingMap = r5;     // Catch: Throwable -> L43
        DummyLifecycleListener r6 = new AnonymousClass1(this);     // Catch: Throwable -> L43
        this.mLifecycleListener = r6;     // Catch: Throwable -> L43
        r1.register(r6);     // Catch: Throwable -> L43
        if (r4.enableExceptionMonitor() == false) goto L35;
        sendCheckExceptionTask(r2);     // Catch: Throwable -> L43
    L35:
        this.mInitSuccess = true;     // Catch: Throwable -> L43
        monitor-exit(this);
        return;
    L31:
        r5 = this.mBackgroundExceptionRecordingData;     // Catch: Throwable -> L43
        goto L32
    L27:
        r3 = this.mBackgroundRecordingData;     // Catch: Throwable -> L43
        goto L28
    L39:
        if (com.bytedance.apm.b.k() == false) goto L41;
        Log.i(TAG, "init error");     // Catch: Throwable -> L43
    L41:
        monitor-exit(this);
        return;
    L18:
        r0 = new LinkedBlockingQueue();     // Catch: Throwable -> L43
        goto L17
    }

    private synchronized void startWork() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsQueueWorking == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mIsQueueWorking = true;     // Catch: Throwable -> L11
        new Thread(new AnonymousClass5(this), THREAD_NAME).start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void init() {
        ServiceManager.getService(FrequencyMonitorConfigService.class);
    }

    public void monitorFrequency(String r5, String r6) {
        if (r5 == null) goto L26;
        if (r6 != null) goto L6;
        return;
    L6:
        if (this.mInitSuccess == true) goto L14;
        if (com.bytedance.apm.b.k() == true) goto L10;
        return;
    L10:
        if (this.showNotInitRemind == false) goto L25;
        this.showNotInitRemind = false;
        Log.i(TAG, "Not init finished,will not record");
        return;
    L25:
        return;
    L14:
        if (this.mMonitorConfig.getEventSamplingRate() < 10000) goto L16;
    L18:
        RecordItem r0 = RecordItemCache.getCacheItem();
        if (r0 != null) goto L21;
        r0 = new RecordItem(r5, r6);
    L22:
        r0.setUsing(true);
        enqueue(r0);
        return;
    L21:
        r0.setCategory(r5);
        r0.setKey(r6);
        goto L22
    L16:
        if ((System.nanoTime() % 10000) < this.mMonitorConfig.getEventSamplingRate()) goto L18;
        return;
    }

    public synchronized void stopMonitor() {
        monitor-enter(this);
        this.mInitSuccess = false;     // Catch: Throwable -> L23
        if (this.mReportTimerTask == null) goto L8;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.mReportTimerTask);     // Catch: Throwable -> L23
    L8:
        if (this.mFrontExceptionCheckTask == null) goto L11;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.mFrontExceptionCheckTask);     // Catch: Throwable -> L23
    L11:
        if (this.mBackgroundExceptionCheckTask == null) goto L13;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.mBackgroundExceptionCheckTask);     // Catch: Throwable -> L23
    L13:
        ActivityLifecycleService r0 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (r0 == null) goto L18;
        DummyLifecycleListener r1 = this.mLifecycleListener;     // Catch: Throwable -> L23
        if (r1 == null) goto L18;
        r0.unregister(r1);     // Catch: Throwable -> L23
    L18:
        BlockingQueue<RecordItem> r2 = this.mQueue;     // Catch: Throwable -> L23
        if (r2 == null) goto L21;
        r2.clear();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void updateConfig(FrequencyMonitorConfig r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mMonitorConfig == r2) goto L9;
        stopMonitor();
        startMonitor(r2);
        return;
    }
}
