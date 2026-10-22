package com.bytedance.apm6.memory;

import android.app.Activity;
import com.bytedance.apm.d.d;
import com.bytedance.apm.e.a;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.memory.bean.MemoryCollectInfo;
import com.bytedance.apm6.memory.config.MemoryConfig;
import com.bytedance.apm6.memory.config.MemoryConfigService;
import com.bytedance.apm6.memory.listener.IMemoryDataListener;
import com.bytedance.apm6.memory.monitorable.MemoryPerfDataEvent;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.service.lifecycle.DummyLifecycleListener;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MemoryCollector {
    private static final long MIN_COLLECT_TIME = 30000;
    private static final String TAG = "MemoryCollector";
    private MemoryConfig config;
    private volatile boolean inited;
    private volatile boolean isPaused;
    private volatile boolean isStart;
    private MemoryLifecycleListener lifecycleListener;
    private volatile d listener;
    private List<IMemoryDataListener> mList;
    private AsyncTask memoryCollector;
    private Map<Object, Object> mmapInfo;
    private long pollingIntervalMillis;

    private static class InnerHolder {
        private static final MemoryCollector instance = null;

        static {
            instance = new MemoryCollector(null);
        }

        private InnerHolder() {
        }

        static /* synthetic */ MemoryCollector access$100() {
            return instance;
        }
    }

    private class MemoryLifecycleListener extends DummyLifecycleListener {
        final /* synthetic */ MemoryCollector this$0;

        private MemoryLifecycleListener(MemoryCollector r1) {
            this.this$0 = r1;
        }

        /* synthetic */ MemoryLifecycleListener(MemoryCollector r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onBackground(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            if (ApmContext.isDebugMode() == false) goto L6;
            Logger.d("APM-Memory", "isStopWhenBackground:" + MemoryCollector.access$400(this.this$0));
        L6:
            if (MemoryCollector.access$400(this.this$0) == false) goto L9;
            MemoryCollector.access$600(this.this$0);
            return;
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onFront(Activity r3) {
            Activity r4 = (Activity) ZeusTransformUtils.wrapperContextForParams(r3, Activity.class, "com.obric.memorydata.plugin");
            if (ApmContext.isDebugMode() == false) goto L6;
            Logger.d("APM-Memory", "isStopWhenBackground:" + MemoryCollector.access$400(this.this$0));
        L6:
            if (MemoryCollector.access$400(this.this$0) == false) goto L9;
            MemoryCollector.access$500(this.this$0);
            return;
        }
    }

    static {
    }

    private MemoryCollector() {
        this.pollingIntervalMillis = 0;
        this.lifecycleListener = new MemoryLifecycleListener(this, null);
        this.mList = new CopyOnWriteArrayList();
    }

    /* synthetic */ MemoryCollector(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ boolean access$200(MemoryCollector r0) {
        return r0.isPaused;
    }

    static /* synthetic */ void access$300(MemoryCollector r0) {
        r0.collect();
    }

    static /* synthetic */ boolean access$400(MemoryCollector r0) {
        return r0.isStopWhenBackground();
    }

    static /* synthetic */ void access$500(MemoryCollector r0) {
        r0.start();
    }

    static /* synthetic */ void access$600(MemoryCollector r0) {
        r0.stop();
    }

    private void cancelCollectMemory() {
        if (ApmContext.isDebugMode() == false) goto L6;
        Logger.d("APM-Memory", "cancelCollectMemory");
    L6:
        if (this.memoryCollector == null) goto L9;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.memoryCollector);
        this.memoryCollector = null;
        return;
    }

    private void collect() {
        long r0 = System.currentTimeMillis();
        MemoryPerfDataEvent r2 = MemoryStatistics.getInstance().collectWithConfig(this.config);
        if (r2 == null) goto L5;
        r2.setMmapInfo(this.mmapInfo);
        this.mmapInfo = null;
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.d("APM-Memory", String.format("collect[isUploadEnable=%s cost=%s]: %s", new Object[]{Boolean.valueOf(this.config.isUploadEnable()), Long.valueOf(System.currentTimeMillis() - r0), r2.toJsonObject().toString()}));
    L12:
        if (this.config.isUploadEnable() == false) goto L15;
        sendPerfData(r2);
    L18:
        if (r2.getJavaUsedMemoryRate() > this.config.memoryTopCheckThreshold()) goto L20;
    L22:
        List<IMemoryDataListener> r1 = this.mList;
        if (r1 != null) goto L25;
        return;
    L25:
        if (r1.size() <= 0) goto L38;
        MemoryCollectInfo r3 = r2.getMemoryCollectInfo();     // Catch: Exception -> L32
        Iterator<IMemoryDataListener> r8 = this.mList.iterator();     // Catch: Exception -> L32
    L28:
        if (r8.hasNext() == false) goto L40;
        ((IMemoryDataListener) ZeusTransformUtils.preCheckCast(r8.next(), IMemoryDataListener.class, "com.obric.memorydata.plugin")).onMemoryCallback(r3);     // Catch: Exception -> L32
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L20:
        if (this.listener == null) goto L22;
        this.listener.a(MemoryConst.REACH_TOP_JAVA);
        goto L22
    L15:
        if (a.a() == false) goto L18;
        a.c(TAG, r2.toJsonObject().toString());
        goto L18
    L5:
        if (ApmContext.isDebugMode() == false) goto L37;
        Logger.d("APM-Memory", "collectWithConfig return is null");
        return;
    }

    public static MemoryCollector getInstance() {
        return InnerHolder.access$100();
    }

    private boolean isStopWhenBackground() {
        MemoryConfig r0 = this.config;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isStopWhenBackground() == false) goto L7;
        return true;
    }

    private void scheduleCollectMemory() {
        if (this.memoryCollector == null) goto L5;
        return;
    L5:
        if (ApmContext.isDebugMode() == false) goto L7;
        Logger.d("APM-Memory", "scheduleCollectMemory");
    L7:
        final long r4 = 0;
        final long r6 = this.pollingIntervalMillis;
        this.memoryCollector = new AnonymousClass1(this, r4, r6);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.memoryCollector);
    }

    private void sendPerfData(Monitorable r2) {
        Monitorable r1 = (Monitorable) ZeusTransformUtils.wrapperContextForParams(r2, Monitorable.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        Monitor.record(r1);
    }

    private synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == true) goto L9;
        this.isStart = true;     // Catch: Throwable -> L11
        if (ApmContext.isDebugMode() == false) goto L8;
        Logger.d("APM-Memory", CommonConsts.APM_INNER_EVENT_COST_START);     // Catch: Throwable -> L11
    L8:
        scheduleCollectMemory();     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
    }

    private synchronized void stop() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L6;
        this.isStart = false;     // Catch: Throwable -> L8
        cancelCollectMemory();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
    }

    public void addMapInfo(Map<Object, Object> r3) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        HashMap r0 = new HashMap();
        this.mmapInfo = r0;
        r0.putAll(r4);
    }

    public void addMemoryCallBackListener(IMemoryDataListener r3) {
        IMemoryDataListener r4 = (IMemoryDataListener) ZeusTransformUtils.wrapperContextForParams(r3, IMemoryDataListener.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mList.add(r4);
        return;
    }

    public final synchronized void init() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.inited = true;     // Catch: Throwable -> L11
        updateConfig(((MemoryConfigService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(MemoryConfigService.class), MemoryConfigService.class, "com.obric.memorydata.plugin")).getConfig());     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void initGCInfo() {
        MemoryStatistics.getInstance().init();
    }

    public void pause() {
        this.isPaused = true;
    }

    public void registerReachTopListener(d r3) {
        this.listener = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
    }

    public void removeMemoryCallBackListener(IMemoryDataListener r3) {
        IMemoryDataListener r4 = (IMemoryDataListener) ZeusTransformUtils.wrapperContextForParams(r3, IMemoryDataListener.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.mList.remove(r4);
        return;
    }

    public void resume() {
        this.isPaused = false;
    }

    public void unregisterReachTopListener() {
        this.listener = null;
    }

    public synchronized void updateConfig(MemoryConfig r7) {
        monitor-enter(this);
        if (r7 != null) goto L47;
        monitor-exit(this);
        return;
    L47:
        this.config = r7;     // Catch: Throwable -> L44
        if (ApmContext.isDebugMode() == false) goto L10;
        Logger.d("APM-Memory", "updateConfig: " + r7);     // Catch: Throwable -> L44
    L10:
        if (r7.isApm6SampleEnable() == true) goto L19;
        stop();     // Catch: Throwable -> L44
        ActivityLifecycleService r0 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r0 == null) goto L15;
        r0.unregister(this.lifecycleListener);     // Catch: Throwable -> L44
    L15:
        if (ApmContext.isDebugMode() == false) goto L17;
        Logger.d("APM-Memory", "isApm6SampleEnable: " + r7.isApm6SampleEnable());     // Catch: Throwable -> L44
    L17:
        monitor-exit(this);
        return;
    L19:
        ActivityLifecycleService r1 = (ActivityLifecycleService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(ActivityLifecycleService.class), ActivityLifecycleService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r1 != null) goto L22;
    L25:
        long r2 = r7.memoryCollectionInterval() * 1000;     // Catch: Throwable -> L44
        this.pollingIntervalMillis = r2;     // Catch: Throwable -> L44
        if (r2 >= MIN_COLLECT_TIME) goto L32;
        if (ApmContext.isDebugMode() == false) goto L30;
        Logger.d("APM-Memory", "pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L44
    L30:
        this.pollingIntervalMillis = MIN_COLLECT_TIME;     // Catch: Throwable -> L44
    L32:
        if (ApmContext.isDebugMode() == false) goto L34;
        Logger.d("APM-Memory", "result pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L44
    L34:
        AsyncTask r8 = this.memoryCollector;     // Catch: Throwable -> L44
        if (r8 != null) goto L37;
    L39:
        start();     // Catch: Throwable -> L44
        IMapsCollectService r9 = (IMapsCollectService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IMapsCollectService.class), IMapsCollectService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r9 == null) goto L42;
        r9.start();     // Catch: Throwable -> L44
    L42:
        monitor-exit(this);
        return;
    L37:
        if (r8.getLoopInterval() == this.pollingIntervalMillis) goto L39;
        stop();     // Catch: Throwable -> L44
        goto L39
    L22:
        if (r7.isStopWhenBackground() == false) goto L24;
        r1.unregister(this.lifecycleListener);     // Catch: Throwable -> L44
        r1.register(this.lifecycleListener);     // Catch: Throwable -> L44
        goto L25
    L24:
        r1.unregister(this.lifecycleListener);     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }
}
