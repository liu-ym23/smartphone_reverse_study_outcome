package com.bytedance.apm6.consumer.slardar;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfig;
import com.bytedance.apm6.consumer.slardar.config.SlardarHandlerConfigService;
import com.bytedance.apm6.consumer.slardar.header.HeaderManager;
import com.bytedance.apm6.consumer.slardar.header.HeaderUtils;
import com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer;
import com.bytedance.apm6.consumer.slardar.send.LogReportController;
import com.bytedance.apm6.consumer.slardar.send.LogSender;
import com.bytedance.apm6.consumer.slardar.send.NetworkSender;
import com.bytedance.apm6.consumer.slardar.send.downgrade.DowngradeController;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutManager;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.monitor.MonitorableHandler;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.NetUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.common.utility.NetworkUtils;
import e0.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class SlardarHandler implements MonitorableHandler {
    private static volatile SlardarHandler sInstance;
    private volatile boolean inited;
    private SlardarHandlerConfig mSlardarHandlerConfig;
    private PersistentBuffer persistentBuffer;

    static {
        sInstance = new SlardarHandler();
    }

    private SlardarHandler() {
        this.inited = false;
    }

    private void addExtension(JSONObject r10, boolean r11) {
    L27:
        e = move-exception;
        Log.e(Constants.TAG, "addExtension", e);
        return;
    L4:
        if (TextUtils.isEmpty(ApmContext.getSessionId()) == true) goto L7;
        r10.put("session_id", ApmContext.getSessionId());     // Catch: Exception -> L27
    L7:
        if (r10.isNull(Constants.KEY_NET_TYPE) == false) goto L16;
        NetworkUtils.NetworkType r12 = NetworkUtils.f(ApmBaseContext.getContext());     // Catch: Exception -> L27
        r10.put(Constants.KEY_NET_TYPE, r12.getValue());     // Catch: Exception -> L27
        if (r12.is2G() == false) goto L11;
    L12:
        int r13 = NetUtils.getMobileNetworkType(ApmBaseContext.getContext());     // Catch: Exception -> L27
        if (r13 == (-10000)) goto L16;
        r10.put(Constants.KEY_NET_TYPE_CODE, r13);     // Catch: Exception -> L27
        goto L16
    L11:
        if (r12.is3GOrHigher() == true) goto L12;
    L16:
        if (r10.isNull("timestamp") == false) goto L18;
    L19:
        r10.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L27
    L21:
        if (r10.isNull("sid") == false) goto L23;
        r10.put("sid", ApmContext.getStartId());     // Catch: Exception -> L27
    L23:
        r10.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Exception -> L27
        if (r11 == false) goto L32;
        r10.put(Constants.KEY_SEQ_NO, SeqNumGenerator.getInstance().next());     // Catch: Exception -> L27
        return;
    L32:
        return;
    L18:
        if (r10.optLong("timestamp") > 0) goto L21;
        goto L19
    }

    private synchronized void ensureInited() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.inited == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "Initializing SlardarHandler...");     // Catch: Throwable -> L19
    L11:
        if (a.c() == null) goto L13;
        a.c().d(Constants.TAG, "ensureInited");     // Catch: Throwable -> L19
    L13:
        HeaderManager.getInstance().init();     // Catch: Throwable -> L19
        DowngradeController.getInstance().init(ApmBaseContext.getContext());     // Catch: Throwable -> L19
        SlardarHandlerConfigService r10 = (SlardarHandlerConfigService) ServiceManager.getService(SlardarHandlerConfigService.class);     // Catch: Throwable -> L19
        if (r10 == null) goto L16;
        setSlardarHandlerConfig(r10.getConfig());     // Catch: Throwable -> L19
    L16:
        this.persistentBuffer = new PersistentBuffer(HeaderUtils.getUniqueHeaderId(), DiskEnvironmentHelper.getPersistentFile(), DiskEnvironmentHelper.getFlushDirectory());     // Catch: Throwable -> L19
        LogReporter.getInstance().setPersistentBuffer(this.persistentBuffer);     // Catch: Throwable -> L19
        WeedOutManager.getInstance().addStrategy(LogReporter.getInstance());     // Catch: Throwable -> L19
        WeedOutManager.getInstance().addStrategy(LogSender.getInstance());     // Catch: Throwable -> L19
        WeedOutManager.getInstance().init();     // Catch: Throwable -> L19
        LogReporter.getInstance().init();     // Catch: Throwable -> L19
        LogSender.getInstance().init();     // Catch: Throwable -> L19
        this.inited = true;     // Catch: Throwable -> L19
        monitor-exit(this);
    }

    public static SlardarHandler getInstance() {
        return sInstance;
    }

    @Override // com.bytedance.apm6.monitor.MonitorableHandler
    public void handle(Monitorable r10) {
        if (this.inited == true) goto L5;
        ensureInited();
    L5:
        JSONObject r11 = r10.toJsonObject();
        if (Constants.EXCEPTION_TYPE.contains(r10.getLogType()) == false) goto L8;
    L17:
        addExtension(r11, false);
    L19:
        if (ApmBaseContext.isDebugMode() == false) goto L21;
        a0.a.b(r10.getLogType(), r11, true);
    L21:
        this.persistentBuffer.push(r11);
        return;
    L8:
        if ("tracing".equals(r10.getLogType()) == true) goto L17;
        if (DowngradeController.getInstance().uploadEnabled(r11, ApmContext.getAid()) == false) goto L13;
        addExtension(r11, true);
        goto L19
    L13:
        if (ApmBaseContext.isDebugMode() == false) goto L23;
        a0.a.a(r10.getLogType(), r11);
        Logger.d(Constants.TAG, "push failed: event(aid=" + ApmContext.getAid() + " is downgraded: " + r11.toString());
        return;
    }

    public void pause() {
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "pause");
    L5:
        LogReporter.getInstance().pause();
        LogSender.getInstance().pause();
    }

    public void resume() {
        if (ApmBaseContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "resume");
    L5:
        LogReporter.getInstance().resume();
        LogSender.getInstance().resume();
    }

    public synchronized void setSlardarHandlerConfig(SlardarHandlerConfig r10) {
        monitor-enter(this);
        this.mSlardarHandlerConfig = r10;     // Catch: Throwable -> L11
        if (r10 == null) goto L7;
        LogReportController.getInstance().updateConfig(r10);     // Catch: Throwable -> L11
        LogReporter.getInstance().setLoopInterval(r10.getReportInterval());     // Catch: Throwable -> L11
        LogReporter.getInstance().setOnceReportMaxSizeBytes(r10.getOnceReportMaxSizeBytes());     // Catch: Throwable -> L11
        WeedOutManager.getInstance().setWeedOutConfig(r10.getMaxSizeMB(), r10.getKeepDays(), r10.getMaxSizeMBToday());     // Catch: Throwable -> L11
        NetworkSender.setCompressType(r10.getCompressType());     // Catch: Throwable -> L11
    L7:
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "setSlardarHandlerConfig:" + r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
