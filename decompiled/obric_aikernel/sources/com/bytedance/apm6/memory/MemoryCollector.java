package com.bytedance.apm6.memory;

import android.app.Activity;
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
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import d0.d;
import e0.a;
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

        private MemoryLifecycleListener(MemoryCollector r10) {
            this.this$0 = r10;
        }

        /* synthetic */ MemoryLifecycleListener(MemoryCollector r10, AnonymousClass1 r11) {
            this(r10);
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onBackground(Activity r10) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
            Logger.d("APM-Memory", "isStopWhenBackground:" + MemoryCollector.access$400(this.this$0));
        L6:
            if (MemoryCollector.access$400(this.this$0) == false) goto L9;
            MemoryCollector.access$600(this.this$0);
            return;
        }

        @Override // com.bytedance.apm6.service.lifecycle.DummyLifecycleListener, com.bytedance.apm6.service.lifecycle.IActivityLifecycleObserver
        public final void onFront(Activity r10) {
            if (ApmBaseContext.isDebugMode() == false) goto L6;
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

    /* synthetic */ MemoryCollector(AnonymousClass1 r10) {
        this();
    }

    static /* synthetic */ boolean access$200(MemoryCollector r10) {
        return r10.isPaused;
    }

    static /* synthetic */ void access$300(MemoryCollector r10) {
        r10.collect();
    }

    static /* synthetic */ boolean access$400(MemoryCollector r10) {
        return r10.isStopWhenBackground();
    }

    static /* synthetic */ void access$500(MemoryCollector r10) {
        r10.start();
    }

    static /* synthetic */ void access$600(MemoryCollector r10) {
        r10.stop();
    }

    private void cancelCollectMemory() {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.d("APM-Memory", "cancelCollectMemory");
    L6:
        if (this.memoryCollector == null) goto L9;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.memoryCollector);
        this.memoryCollector = null;
        return;
    }

    private void collect() {
        long r10 = System.currentTimeMillis();
        MemoryPerfDataEvent r11 = MemoryStatistics.getInstance().collectWithConfig(this.config);
        if (r11 == null) goto L5;
        r11.setMmapInfo(this.mmapInfo);
        this.mmapInfo = null;
        if (ApmBaseContext.isDebugMode() == false) goto L12;
        Logger.d("APM-Memory", String.format("collect[isUploadEnable=%s cost=%s]: %s", new Object[]{Boolean.valueOf(this.config.isUploadEnable()), Long.valueOf(System.currentTimeMillis() - r10), r11.toJsonObject().toString()}));
    L12:
        if (this.config.isUploadEnable() == false) goto L15;
        sendPerfData(r11);
    L18:
        if (r11.getJavaUsedMemoryRate() > this.config.memoryTopCheckThreshold()) goto L20;
    L22:
        List<IMemoryDataListener> r12 = this.mList;
        if (r12 != null) goto L25;
        return;
    L25:
        if (r12.size() <= 0) goto L38;
        MemoryCollectInfo r13 = r11.getMemoryCollectInfo();     // Catch: Exception -> L32
        Iterator<IMemoryDataListener> r14 = this.mList.iterator();     // Catch: Exception -> L32
    L28:
        if (r14.hasNext() == false) goto L40;
        r14.next().onMemoryCallback(r13);     // Catch: Exception -> L32
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
        if (a.e() == false) goto L18;
        a.b(TAG, r11.toJsonObject().toString());
        goto L18
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L37;
        Logger.d("APM-Memory", "collectWithConfig return is null");
        return;
    }

    public static MemoryCollector getInstance() {
        return InnerHolder.access$100();
    }

    private boolean isStopWhenBackground() {
        MemoryConfig r10 = this.config;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isStopWhenBackground() == false) goto L7;
        return true;
    }

    private void scheduleCollectMemory() {
        if (this.memoryCollector == null) goto L5;
        return;
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L7;
        Logger.d("APM-Memory", "scheduleCollectMemory");
    L7:
        final long r10 = 0;
        final long r11 = this.pollingIntervalMillis;
        this.memoryCollector = new AnonymousClass1(this, r10, r11);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.memoryCollector);
    }

    private void sendPerfData(Monitorable r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Monitor.record(r10);
    }

    private synchronized void start() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == true) goto L9;
        this.isStart = true;     // Catch: Throwable -> L11
        if (ApmBaseContext.isDebugMode() == false) goto L8;
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

    public void addMapInfo(Map<Object, Object> r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        HashMap r11 = new HashMap();
        this.mmapInfo = r11;
        r11.putAll(r10);
    }

    public void addMemoryCallBackListener(IMemoryDataListener r10) {
        if (r10 == null) goto L5;
        this.mList.add(r10);
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
        updateConfig(((MemoryConfigService) ServiceManager.getService(MemoryConfigService.class)).getConfig());     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public void initGCInfo() {
        MemoryStatistics.getInstance().init();
    }

    public void pause() {
        this.isPaused = true;
    }

    public void registerReachTopListener(d r10) {
        this.listener = r10;
    }

    public void removeMemoryCallBackListener(IMemoryDataListener r10) {
        if (r10 == null) goto L5;
        this.mList.remove(r10);
        return;
    }

    public void resume() {
        this.isPaused = false;
    }

    public void unregisterReachTopListener() {
        this.listener = null;
    }

    public synchronized void updateConfig(MemoryConfig r10) {
        monitor-enter(this);
        if (r10 != null) goto L48;
        monitor-exit(this);
        return;
    L48:
        this.config = r10;     // Catch: Throwable -> L45
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d("APM-Memory", "updateConfig: " + r10);     // Catch: Throwable -> L45
    L11:
        if (r10.isApm6SampleEnable() == true) goto L20;
        stop();     // Catch: Throwable -> L45
        ActivityLifecycleService r11 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L45
        if (r11 == null) goto L16;
        r11.unregister(this.lifecycleListener);     // Catch: Throwable -> L45
    L16:
        if (ApmBaseContext.isDebugMode() == false) goto L18;
        Logger.d("APM-Memory", "isApm6SampleEnable: " + r10.isApm6SampleEnable());     // Catch: Throwable -> L45
    L18:
        monitor-exit(this);
        return;
    L20:
        ActivityLifecycleService r12 = (ActivityLifecycleService) ServiceManager.getService(ActivityLifecycleService.class);     // Catch: Throwable -> L45
        if (r12 != null) goto L23;
    L26:
        long r13 = r10.memoryCollectionInterval() * 1000;     // Catch: Throwable -> L45
        this.pollingIntervalMillis = r13;     // Catch: Throwable -> L45
        if (r13 >= 30000) goto L33;
        if (ApmBaseContext.isDebugMode() == false) goto L31;
        Logger.d("APM-Memory", "pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L45
    L31:
        this.pollingIntervalMillis = 30000;     // Catch: Throwable -> L45
    L33:
        if (ApmBaseContext.isDebugMode() == false) goto L35;
        Logger.d("APM-Memory", "result pollingIntervalMillis: " + this.pollingIntervalMillis);     // Catch: Throwable -> L45
    L35:
        AsyncTask r14 = this.memoryCollector;     // Catch: Throwable -> L45
        if (r14 != null) goto L38;
    L40:
        start();     // Catch: Throwable -> L45
        IMapsCollectService r15 = (IMapsCollectService) ServiceManager.getService(IMapsCollectService.class);     // Catch: Throwable -> L45
        if (r15 == null) goto L43;
        r15.start();     // Catch: Throwable -> L45
    L43:
        monitor-exit(this);
        return;
    L38:
        if (r14.getLoopInterval() == this.pollingIntervalMillis) goto L40;
        stop();     // Catch: Throwable -> L45
        goto L40
    L23:
        if (r10.isStopWhenBackground() == false) goto L25;
        r12.unregister(this.lifecycleListener);     // Catch: Throwable -> L45
        r12.register(this.lifecycleListener);     // Catch: Throwable -> L45
        goto L26
    L25:
        r12.unregister(this.lifecycleListener);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }
}
