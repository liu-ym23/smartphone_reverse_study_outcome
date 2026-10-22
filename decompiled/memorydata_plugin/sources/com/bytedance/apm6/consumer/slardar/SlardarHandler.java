package com.bytedance.apm6.consumer.slardar;

import android.app.Application;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.apm.e.a;
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
import com.bytedance.apm6.util.NetUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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

    private void addExtension(JSONObject r7, boolean r8) {
    L27:
        e = move-exception;
        Log.e(Constants.TAG, "addExtension", e);
        return;
    L4:
        if (TextUtils.isEmpty(ApmContext.getSessionId()) == true) goto L7;
        r7.put("session_id", ApmContext.getSessionId());     // Catch: Exception -> L27
    L7:
        if (r7.isNull(Constants.KEY_NET_TYPE) == false) goto L16;
        NetworkUtils.NetworkType r3 = NetworkUtils.c((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L27
        r7.put(Constants.KEY_NET_TYPE, r3.getValue());     // Catch: Exception -> L27
        if (r3.is2G() == false) goto L11;
    L12:
        int r0 = NetUtils.getMobileNetworkType((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L27
        if (r0 == (-10000)) goto L16;
        r7.put(Constants.KEY_NET_TYPE_CODE, r0);     // Catch: Exception -> L27
        goto L16
    L11:
        if (r3.is3GOrHigher() == true) goto L12;
    L16:
        if (r7.isNull("timestamp") == false) goto L18;
    L19:
        r7.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L27
    L21:
        if (r7.isNull("sid") == false) goto L23;
        r7.put("sid", ApmContext.getStartId());     // Catch: Exception -> L27
    L23:
        r7.put("process_name", ApmContext.getCurrentProcessName());     // Catch: Exception -> L27
        if (r8 == false) goto L32;
        r7.put(Constants.KEY_SEQ_NO, SeqNumGenerator.getInstance().next());     // Catch: Exception -> L27
        return;
    L32:
        return;
    L18:
        if (r7.optLong("timestamp") > 0) goto L21;
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
        if (ApmContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "Initializing SlardarHandler...");     // Catch: Throwable -> L19
    L11:
        if (a.c() == null) goto L13;
        a.c().b(Constants.TAG, "ensureInited");     // Catch: Throwable -> L19
    L13:
        HeaderManager.getInstance().init();     // Catch: Throwable -> L19
        DowngradeController.getInstance().init((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ApmContext.getContext(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L19
        SlardarHandlerConfigService r0 = (SlardarHandlerConfigService) ZeusTransformUtils.preCheckCast(ServiceManager.getService(SlardarHandlerConfigService.class), SlardarHandlerConfigService.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r0 == null) goto L16;
        setSlardarHandlerConfig(r0.getConfig());     // Catch: Throwable -> L19
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
    public void handle(Monitorable r5) {
        Monitorable r6 = (Monitorable) ZeusTransformUtils.wrapperContextForParams(r5, Monitorable.class, "com.obric.memorydata.plugin");
        if (this.inited == true) goto L5;
        ensureInited();
    L5:
        JSONObject r0 = r6.toJsonObject();
        if (Constants.EXCEPTION_TYPE.contains(r6.getLogType()) == false) goto L8;
    L17:
        addExtension(r0, false);
    L19:
        if (ApmContext.isDebugMode() == false) goto L21;
        com.bytedance.apm.doctor.a.a(r6.getLogType(), r0, true);
    L21:
        this.persistentBuffer.push(r0);
        return;
    L8:
        if ("tracing".equals(r6.getLogType()) == true) goto L17;
        if (DowngradeController.getInstance().uploadEnabled(r0, ApmContext.getAid()) == false) goto L13;
        addExtension(r0, true);
        goto L19
    L13:
        if (ApmContext.isDebugMode() == false) goto L23;
        com.bytedance.apm.doctor.a.a(r6.getLogType(), r0);
        Logger.d(Constants.TAG, "push failed: event(aid=" + ApmContext.getAid() + " is downgraded: " + r0.toString());
        return;
    }

    public void pause() {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "pause");
    L5:
        LogReporter.getInstance().pause();
        LogSender.getInstance().pause();
    }

    public void resume() {
        if (ApmContext.isDebugMode() == false) goto L5;
        Logger.d(Constants.TAG, "resume");
    L5:
        LogReporter.getInstance().resume();
        LogSender.getInstance().resume();
    }

    public synchronized void setSlardarHandlerConfig(SlardarHandlerConfig r5) {
        monitor-enter(this);
        this.mSlardarHandlerConfig = r5;     // Catch: Throwable -> L11
        if (r5 == null) goto L7;
        LogReportController.getInstance().updateConfig(r5);     // Catch: Throwable -> L11
        LogReporter.getInstance().setLoopInterval(r5.getReportInterval());     // Catch: Throwable -> L11
        LogReporter.getInstance().setOnceReportMaxSizeBytes(r5.getOnceReportMaxSizeBytes());     // Catch: Throwable -> L11
        WeedOutManager.getInstance().setWeedOutConfig(r5.getMaxSizeMB(), r5.getKeepDays(), r5.getMaxSizeMBToday());     // Catch: Throwable -> L11
        NetworkSender.setCompressType(r5.getCompressType());     // Catch: Throwable -> L11
    L7:
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "setSlardarHandlerConfig:" + r5);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
