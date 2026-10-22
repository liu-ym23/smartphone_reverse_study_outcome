package com.bytedance.apm6.frequency;

import android.os.Build;
import android.util.Log;
import android.util.Pair;
import androidx.work.WorkRequest;
import com.bytedance.apm.d;
import com.bytedance.apm6.cpu.collect.CpuReportEvent;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.crash.entity.EventBody;
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
import q0.b;

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

    static /* synthetic */ void access$000(FrequencyMonitor r10) {
        r10.onFront();
    }

    static /* synthetic */ void access$100(FrequencyMonitor r10) {
        r10.onBackground();
    }

    static /* synthetic */ void access$200(FrequencyMonitor r10) {
        r10.checkReport();
    }

    static /* synthetic */ void access$300(FrequencyMonitor r10, boolean r11) {
        r10.checkHasException(r11);
    }

    static /* synthetic */ void access$400(FrequencyMonitor r10) {
        r10.dispatchMessage();
    }

    static /* synthetic */ int access$500(FrequencyMonitor r10) {
        return r10.mErrorCount;
    }

    static /* synthetic */ int access$508(FrequencyMonitor r10) {
        int r11 = r10.mErrorCount;
        r10.mErrorCount = r11 + 1;
        return r11;
    }

    private boolean appendJsonArray(HashMap<String, HashMap<String, Counter>> r10, long r11, JSONObject r13, boolean r14) {
        JSONArray r12 = new JSONArray();
        Iterator<Map.Entry<String, HashMap<String, Counter>>> r15 = r10.entrySet().iterator();
    L4:
        if (r15.hasNext() == false) goto L11;
        Map.Entry<String, HashMap<String, Counter>> r16 = r15.next();
        String r17 = r16.getKey();
        Iterator<Map.Entry<String, Counter>> r18 = r16.getValue().entrySet().iterator();
    L7:
        if (r18.hasNext() == false) goto L4;
        Map.Entry<String, Counter> r19 = r18.next();
        String r20 = r19.getKey();
        int r21 = r19.getValue().getCount();
        float r22 = r21 / (r11 * 1.6666667E-5f);
        float r23 = (10000.0f * r22) / this.mMonitorConfig.getEventSamplingRate();
        if (r23 <= this.mMonitorConfig.getReportThresholdOfCategory(r17, r14)) goto L7;
        JSONObject r24 = new JSONObject();
        r24.putOpt(EventBody.KEY_CATEGORY, r17);
        r24.putOpt("key", r20);
        r24.putOpt(CommonConsts.COUNT_TYPE, Integer.valueOf(r21));
        r24.putOpt("frequency_per_min", Float.valueOf(Math.round(r22 * 100.0f) / 100.0f));
        r24.putOpt("frequency_reduction", Float.valueOf(Math.round(r23 * 100.0f) / 100.0f));
        r12.put(r24);
        goto L7
    L11:
        r13.putOpt("details", r12);
        if (r12.length() <= 0) goto L14;
        return true;
    L14:
        return false;
    }

    private void changeState(boolean r10, long r11) {
        this.mFrontExceptionRecordingData.clear();
        this.mBackgroundExceptionRecordingData.clear();
        if (r10 == false) goto L5;
        this.mBackgroundDuration += r11;
        this.mUsingRecordingMap = this.mFrontRecordingData;
        HashMap<String, HashMap<String, Counter>> r12 = this.mFrontExceptionRecordingData;
    L6:
        this.mUsingExceptionRecordingMap = r12;
        return;
    L5:
        this.mFrontDuration += r11;
        this.mUsingRecordingMap = this.mBackgroundRecordingData;
        r12 = this.mBackgroundExceptionRecordingData;
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
    private void checkAndReportException(boolean r19, long r20) {
        boolean r10 = r19 ? 1 : 0;
        if (r10 == false) goto L5;
        HashMap<String, HashMap<String, Counter>> r11 = this.mFrontExceptionRecordingData;
    L7:
        if (r11.isEmpty() == false) goto L9;
        return;
    L9:
        int r12 = this.mMonitorConfig.getExceptionReportTopCount();
        if (r12 > 0) goto L12;
        return;
    L12:
        HashMap r13 = new HashMap();
        HashMap r14 = new HashMap();
        Iterator<Map.Entry<String, HashMap<String, Counter>>> r15 = r11.entrySet().iterator();
    L14:
        if (r15.hasNext() == false) goto L25;
        Map.Entry<String, HashMap<String, Counter>> r16 = r15.next();
        String r17 = r16.getKey();
        List r18 = (List) r14.get(r17);
        if (r18 != null) goto L18;
        r18 = new ArrayList();
        r14.put(r17, r18);
    L18:
        Iterator<Map.Entry<String, Counter>> r21 = r16.getValue().entrySet().iterator();
    L20:
        if (r21.hasNext() == false) goto L14;
        Map.Entry<String, Counter> r110 = r21.next();
        String r111 = r110.getKey();
        int r112 = r110.getValue().getCount();
        r18.add(new Pair(r111, Integer.valueOf(r112)));
        Counter r113 = (Counter) r13.get(r17);
        if (r113 == null) goto L23;
        r113.addCount(r112);
        goto L20
    L23:
        r13.put(r17, new Counter(r112));
        goto L20
    L25:
        Iterator r22 = r13.entrySet().iterator();
    L27:
        if (r22.hasNext() == false) goto L43;
        Map.Entry r23 = (Map.Entry) r22.next();
        float r24 = ((Counter) r23.getValue()).getCount() / (r20 * 1.6666667E-5f);
        float r114 = (10000.0f * r24) / this.mMonitorConfig.getEventSamplingRate();
        if (r114 <= this.mMonitorConfig.getExceptionThresholdOfCategory((String) r23.getKey(), r10)) goto L41;
        List r115 = (List) r14.get(r23.getKey());
        Collections.sort(r115, new AnonymousClass6(this));
        final JSONObject r116 = new JSONObject();
        JSONArray r117 = new JSONArray();
        int r118 = 0;
    L32:
        if (r118 >= Math.min(r12, r115.size())) goto L38;
        JSONObject r119 = new JSONObject();
        Pair r25 = (Pair) r115.get(r118);
        int r120 = r12;
        if (r118 != 0) goto L37;
        r116.putOpt("exception_reason", r25.first);
    L37:
        r119.putOpt("key", r25.first);
        r119.putOpt(CommonConsts.COUNT_TYPE, r25.second);
        r117.put(r119);
        r118 = r118 + 1;
        r12 = r120;
        r22 = r22;
        goto L32
    L38:
        int r121 = r12;
        Iterator r122 = r22;
        r116.putOpt("is_front", Integer.valueOf(r19 ? 1 : 0));
        r116.putOpt(EventBody.KEY_CATEGORY, r23.getKey());
        r116.putOpt("total_count", Integer.valueOf(((Counter) r23.getValue()).getCount()));
        r116.putOpt("duration", Long.valueOf(r20));
        r116.putOpt("frequency_per_min", Float.valueOf(Math.round(r24 * 100.0f) / 100.0f));
        r116.putOpt("frequency_reduction", Float.valueOf(Math.round(r114 * 100.0f) / 100.0f));
        r116.putOpt("sampling_rate", Integer.valueOf(this.mMonitorConfig.getEventSamplingRate()));
        r116.putOpt("top_data", r117);
        r116.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        b.f().i(new AnonymousClass7(this, r116));
        if (d.D() == false) goto L42;
        Log.i(TAG, "Report Exception:" + r116);
    L42:
        r10 = r19 ? 1 : 0;
        r12 = r121;
        r22 = r122;
        goto L27
    L41:
        r121 = r12;
        r122 = r22;
        goto L42
    L43:
        r11.clear();
        return;
    L5:
        r11 = this.mBackgroundExceptionRecordingData;
        goto L7
    }

    private void checkHasException(boolean r10) {
        long r11 = System.currentTimeMillis();
        long r12 = r11 - this.mLastCheckExceptionTime;
        this.mLastCheckExceptionTime = r11;
        if (r10 == false) goto L5;
        String r13 = COMMAND_CHECK_FRONT_EXCEPTION;
    L6:
        enqueue(new RecordItem(r13, r12));
        return;
    L5:
        r13 = COMMAND_CHECK_BACKGROUND_EXCEPTION;
        goto L6
    }

    private void checkReport() {
        long r10 = System.currentTimeMillis();
        enqueue(new RecordItem(COMMAND_REPORT_DATA, r10 - this.mLastRecordDurationTime));
        this.mLastRecordDurationTime = r10;
    }

    private void dispatchMessage() {
        RecordItem r10 = this.mQueue.take();
        if (r10.getCommand() == null) goto L19;
        long r11 = r10.getDuration();
        if (r10.getCommand().startsWith(COMMAND_CHANGE_TO_FRONT) == false) goto L8;
        changeState(true, r11);
    L20:
        r10.setUsing(false);
        return;
    L8:
        if (r10.getCommand().startsWith(COMMAND_CHANGE_TO_BACKGROUND) == false) goto L11;
        changeState(false, r11);
        goto L20
    L11:
        if (r10.getCommand().startsWith(COMMAND_CHECK_FRONT_EXCEPTION) == false) goto L14;
        checkAndReportException(true, r11);
        goto L20
    L14:
        if (r10.getCommand().startsWith(COMMAND_CHECK_BACKGROUND_EXCEPTION) == false) goto L17;
        checkAndReportException(false, r11);
        goto L20
    L17:
        if (r10.getCommand().startsWith(COMMAND_REPORT_DATA) == false) goto L20;
        reportDataInner(r11);
        goto L20
    L19:
        saveDataToRecoding(r10.getCategory(), r10.getKey());
        goto L20
    }

    private void enqueue(RecordItem r10) {
        if (this.mQueue.offer(r10) == true) goto L8;
        if (d.D() == false) goto L8;
        Log.i(TAG, "enqueue error,data:" + r10 + " size:" + this.mQueue.size());
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
        long r10 = System.currentTimeMillis();
        long r11 = r10 - this.mLastRecordDurationTime;
        this.mLastRecordDurationTime = r10;
        if (this.mMonitorConfig.enableExceptionMonitor() == false) goto L5;
        sendCheckExceptionTask(false);
    L5:
        enqueue(new RecordItem(COMMAND_CHANGE_TO_BACKGROUND, r11));
    }

    private void onFront() {
        long r10 = System.currentTimeMillis();
        long r11 = r10 - this.mLastRecordDurationTime;
        this.mLastRecordDurationTime = r10;
        if (this.mMonitorConfig.enableExceptionMonitor() == false) goto L5;
        sendCheckExceptionTask(true);
    L5:
        enqueue(new RecordItem(COMMAND_CHANGE_TO_FRONT, r11));
    }

    private void reportDataInner(long r10) {
        HashMap<String, HashMap<String, Counter>> r11 = this.mUsingRecordingMap;
        HashMap<String, HashMap<String, Counter>> r12 = this.mFrontRecordingData;
        if (r11 != r12) goto L5;
        this.mFrontDuration += r10;
    L7:
        if (r12.isEmpty() == true) goto L9;
    L11:
        final JSONObject r13 = new JSONObject();
        boolean r14 = false;
        boolean r15 = true;
        if (this.mFrontRecordingData.isEmpty() == true) goto L17;
        JSONObject r16 = new JSONObject();
        if (appendJsonArray(this.mFrontRecordingData, this.mFrontDuration, r16, true) == false) goto L17;
        r16.putOpt("duration", Long.valueOf(this.mFrontDuration));
        r13.putOpt(CpuReportEvent.VALUE_FRONT, r16);
        r14 = true;
    L17:
        if (this.mBackgroundRecordingData.isEmpty() == true) goto L21;
        JSONObject r17 = new JSONObject();
        if (appendJsonArray(this.mBackgroundRecordingData, this.mBackgroundDuration, r17, false) == false) goto L21;
        r17.putOpt("duration", Long.valueOf(this.mBackgroundDuration));
        r13.putOpt("background", r17);
    L22:
        if (r15 == false) goto L26;
        r13.putOpt("sampling_rate", Integer.valueOf(this.mMonitorConfig.getEventSamplingRate()));
        r13.putOpt("timestamp", Long.valueOf(System.currentTimeMillis()));
        b.f().i(new AnonymousClass8(this, r13));
        if (d.D() == false) goto L26;
        Log.i(TAG, "Report Data:" + r13);
    L26:
        this.mFrontRecordingData.clear();
        this.mBackgroundRecordingData.clear();
        this.mFrontDuration = 0;
        this.mBackgroundDuration = 0;
        return;
    L21:
        r15 = r14;
        goto L22
    L9:
        if (this.mBackgroundRecordingData.isEmpty() == false) goto L11;
        return;
    L5:
        this.mBackgroundDuration += r10;
        goto L7
    }

    private void saveDataToRecoding(String r10, String r11) {
        if (this.mMonitorConfig.enableFrequencyMonitor() == false) goto L13;
        HashMap<String, Counter> r12 = this.mUsingRecordingMap.get(r10);
        if (r12 != null) goto L8;
        r12 = new HashMap();
        this.mUsingRecordingMap.put(r10, r12);
        Counter r13 = new Counter(1);
    L7:
        r12.put(r11, r13);
        goto L13
    L8:
        Counter r14 = r12.get(r11);
        if (r14 != null) goto L11;
        r13 = new Counter(1);
        goto L7
    L11:
        r14.addCount(1);
    L13:
        if (this.mMonitorConfig.enableExceptionMonitor() == false) goto L23;
        HashMap<String, Counter> r15 = this.mUsingExceptionRecordingMap.get(r10);
        if (r15 != null) goto L18;
        r15 = new HashMap();
        this.mUsingExceptionRecordingMap.put(r10, r15);
        Counter r16 = new Counter(1);
    L17:
        r15.put(r11, r16);
        return;
    L18:
        Counter r17 = r15.get(r11);
        if (r17 != null) goto L21;
        r16 = new Counter(1);
        goto L17
    L21:
        r17.addCount(1);
        return;
    }

    private void sendCheckExceptionTask(boolean r15) {
        if (this.mBackgroundExceptionCheckTask != null) goto L5;
    L12:
        final long r10 = this.mMonitorConfig.getExceptionCheckInterval(false);
        final long r11 = this.mMonitorConfig.getExceptionCheckInterval(false);
        this.mBackgroundExceptionCheckTask = new AnonymousClass3(this, r10, r11);
        final long r12 = this.mMonitorConfig.getExceptionCheckInterval(true);
        final long r13 = this.mMonitorConfig.getExceptionCheckInterval(true);
        this.mFrontExceptionCheckTask = new AnonymousClass4(this, r12, r13);
    L13:
        this.mLastCheckExceptionTime = System.currentTimeMillis();
        AsyncTaskManager r14 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);
        if (r15 == false) goto L16;
        AsyncTask r16 = this.mFrontExceptionCheckTask;
    L17:
        r14.sendTask(r16);
        return;
    L16:
        r16 = this.mBackgroundExceptionCheckTask;
        goto L17
    L5:
        if (this.mFrontExceptionCheckTask == null) goto L12;
        AsyncTaskManager r17 = AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT);
        if (r15 == false) goto L10;
        AsyncTask r18 = this.mBackgroundExceptionCheckTask;
    L11:
        r17.removeTask(r18);
        goto L13
    L10:
        r18 = this.mFrontExceptionCheckTask;
        goto L11
    }

    private void sendReportTask() {
        if (this.mReportTimerTask != null) goto L5;
        final long r10 = this.mMonitorConfig.getReportInterval();
        final long r11 = this.mMonitorConfig.getReportInterval();
        this.mReportTimerTask = new AnonymousClass2(this, r10, r11);
    L5:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.mReportTimerTask);
    }

    private synchronized void startMonitor(FrequencyMonitorConfig r10) {
        monitor-enter(this);
        if (r10 != null) goto L48;
    L46:
        monitor-exit(this);
        return;
    L48:
    L43:
        th = move-exception;
        throw th;
    L5:
        if (r10.enableFrequencyMonitor() == true) goto L9;
        if (r10.enableFrequencyMonitor() == false) goto L46;
    L9:
        if (this.mInitSuccess == true) goto L46;
        if (d.D() == false) goto L14;
        Log.i(TAG, "init:" + r10);     // Catch: Throwable -> L43
    L14:
        this.mMonitorConfig = r10;     // Catch: Throwable -> L43
        if (Build.VERSION.SDK_INT < 21) goto L18;
        BlockingQueue<RecordItem> r11 = new LinkedTransferQueue();     // Catch: Throwable -> L43
    L17:
        this.mQueue = r11;     // Catch: Throwable -> L43
        if (r10.enableFrequencyMonitor() == false) goto L22;
        sendReportTask();     // Catch: Throwable -> L43
    L22:
        this.mLastRecordDurationTime = System.currentTimeMillis();     // Catch: Throwable -> L43
        ActivityLifecycleService r12 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L43
        if (r12 == null) goto L39;
        boolean r13 = r12.isForeground();     // Catch: Throwable -> L43
        if (r13 == false) goto L27;
        HashMap<String, HashMap<String, Counter>> r14 = this.mFrontRecordingData;     // Catch: Throwable -> L43
    L28:
        this.mUsingRecordingMap = r14;     // Catch: Throwable -> L43
        if (r13 == false) goto L31;
        HashMap<String, HashMap<String, Counter>> r15 = this.mFrontExceptionRecordingData;     // Catch: Throwable -> L43
    L32:
        this.mUsingExceptionRecordingMap = r15;     // Catch: Throwable -> L43
        DummyLifecycleListener r16 = new AnonymousClass1(this);     // Catch: Throwable -> L43
        this.mLifecycleListener = r16;     // Catch: Throwable -> L43
        r12.register(r16);     // Catch: Throwable -> L43
        if (r10.enableExceptionMonitor() == false) goto L35;
        sendCheckExceptionTask(r13);     // Catch: Throwable -> L43
    L35:
        this.mInitSuccess = true;     // Catch: Throwable -> L43
        monitor-exit(this);
        return;
    L31:
        r15 = this.mBackgroundExceptionRecordingData;     // Catch: Throwable -> L43
        goto L32
    L27:
        r14 = this.mBackgroundRecordingData;     // Catch: Throwable -> L43
        goto L28
    L39:
        if (d.D() == false) goto L41;
        Log.i(TAG, "init error");     // Catch: Throwable -> L43
    L41:
        monitor-exit(this);
        return;
    L18:
        r11 = new LinkedBlockingQueue();     // Catch: Throwable -> L43
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

    public void monitorFrequency(String r10, String r11) {
        if (r10 == null) goto L26;
        if (r11 != null) goto L6;
        return;
    L6:
        if (this.mInitSuccess == true) goto L14;
        if (d.D() == true) goto L10;
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
        RecordItem r12 = RecordItemCache.getCacheItem();
        if (r12 != null) goto L21;
        r12 = new RecordItem(r10, r11);
    L22:
        r12.setUsing(true);
        enqueue(r12);
        return;
    L21:
        r12.setCategory(r10);
        r12.setKey(r11);
        goto L22
    L16:
        if ((System.nanoTime() % WorkRequest.MIN_BACKOFF_MILLIS) < this.mMonitorConfig.getEventSamplingRate()) goto L18;
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
        ActivityLifecycleService r10 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L23
        if (r10 == null) goto L18;
        DummyLifecycleListener r11 = this.mLifecycleListener;     // Catch: Throwable -> L23
        if (r11 == null) goto L18;
        r10.unregister(r11);     // Catch: Throwable -> L23
    L18:
        BlockingQueue<RecordItem> r12 = this.mQueue;     // Catch: Throwable -> L23
        if (r12 == null) goto L21;
        r12.clear();     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public void updateConfig(FrequencyMonitorConfig r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (this.mMonitorConfig == r10) goto L9;
        stopMonitor();
        startMonitor(r10);
        return;
    }
}
