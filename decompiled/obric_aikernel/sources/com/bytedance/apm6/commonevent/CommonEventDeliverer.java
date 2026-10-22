package com.bytedance.apm6.commonevent;

import a0.a;
import android.text.TextUtils;
import com.bytedance.apm6.commonevent.config.CommonEventConfig;
import com.bytedance.apm6.commonevent.config.CommonEventConfigService;
import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.commonevent.model.CommonLog;
import com.bytedance.apm6.commonevent.model.GeneralLegacyEvent;
import com.bytedance.apm6.commonevent.model.TracingData;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.service.ServiceManager;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.log.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonEventDeliverer {
    public static boolean FAST_MODE = false;
    private static final int MAX_SIZE = 1000;
    private static volatile boolean inited = false;
    private static boolean isEnableException;
    private static LimitedQueue<Monitorable> limitedQueue;
    private static volatile CommonEventConfig sCommonEventConfig;

    static {
        LimitedQueue<Monitorable> r10 = new LimitedQueue(1000);
        limitedQueue = r10;
        isEnableException = true;
        r10.setEvictListener(new AnonymousClass1());
    }

    public CommonEventDeliverer() {
    }

    static /* synthetic */ boolean access$000() {
        return isEnableException;
    }

    private static synchronized void initConfig() {
        monitor-enter(CommonEventDeliverer.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (inited == true) goto L9;
        CommonEventConfigService r10 = (CommonEventConfigService) ServiceManager.getService(CommonEventConfigService.class);     // Catch: Throwable -> L11
        if (r10 == null) goto L9;
        updateConfig(r10.getConfig());     // Catch: Throwable -> L11
        inited = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(CommonEventDeliverer.class);
    }

    public static void monitorCommonLog(CommonLog r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (sCommonEventConfig != null) goto L12;
        limitedQueue.push(r10);
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "Cached CommonLog: " + r10);
    L9:
        initConfig();
        return;
    L12:
        if (sCommonEventConfig.isSampledLogType(r10.getLogType()) == false) goto L18;
        r10.deepCopyJson();
        if (ApmBaseContext.isDebugMode() == false) goto L16;
        Logger.d(Constants.TAG, "Sampled CommonLog:" + r10);
    L16:
        Monitor.record(r10);
        return;
    L18:
        if (ApmBaseContext.isDebugMode() == false) goto L22;
        r10.deepCopyJson();
        a.b(r10.getLogType(), r10.toJsonObject(), false);
        Logger.d(Constants.TAG, "UnSampled CommonLog:" + r10);
        return;
    }

    public static void monitorCommonLog(String r10, JSONObject r11) {
        if (TextUtils.isEmpty(r10) == true) goto L5;
        monitorCommonLog(new CommonLog(r10, r11));
        return;
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L10;
        Logger.d(Constants.TAG, "logType must be not empty");
        return;
    }

    public static void monitorDuration(String r10, JSONObject r11, JSONObject r12) {
        monitorEvent(new CommonEvent(r10, 0, r11, null, null, r12));
    }

    public static void monitorEvent(CommonEvent r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (sCommonEventConfig != null) goto L12;
        limitedQueue.push(r10);
        if (ApmBaseContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "cached CommonEvent:" + r10);
    L9:
        initConfig();
        return;
    L12:
        if (sCommonEventConfig.isSampledService(r10.getServiceName()) == false) goto L17;
        r10.deepCopyJson();
        Monitor.record(r10);
        if (ApmBaseContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "Sampled CommonEvent:" + r10);
        return;
    L23:
        return;
    L17:
        if (ApmBaseContext.isDebugMode() == false) goto L20;
        Logger.d(Constants.TAG, "UnSampled CommonEvent:" + r10);
    L20:
        if (ApmBaseContext.isDebugMode() == false) goto L25;
        r10.deepCopyJson();
        a.b(r10.getLogType(), r10.toJsonObject(), false);
        return;
    }

    public static void monitorEvent(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14, JSONObject r15) {
        monitorEvent(new CommonEvent(r10, r11, r12, r13, r14, r15));
    }

    public static void monitorEvent(String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        monitorStatusAndEvent(r10, 0, r11, r12, r13);
    }

    public static void monitorLegacyEvent(GeneralLegacyEvent r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        Monitor.record(r10);
    }

    public static void monitorStatusAndDuration(String r10, int r11, JSONObject r12, JSONObject r13) {
        monitorEvent(new CommonEvent(r10, r11, r12, null, null, r13));
    }

    public static void monitorStatusAndEvent(String r10, int r11, JSONObject r12, JSONObject r13, JSONObject r14) {
        monitorEvent(r10, r11, null, r12, r13, r14);
    }

    public static void monitorStatusRate(String r10, int r11, JSONObject r12) {
        monitorStatusAndEvent(r10, r11, null, null, r12);
    }

    public static void monitorTrace(TracingData r10) {
        if (r10 != null) goto L5;
        return;
    L5:
        if (ApmBaseContext.isDebugMode() == false) goto L7;
        Logger.d(Constants.TAG, "trace_data:" + r10.toJsonObject());
    L7:
        Monitor.record(r10);
    }

    public static boolean needSkip(String r10, Boolean r11) {
        if (FAST_MODE == true) goto L5;
        return false;
    L5:
        if (sCommonEventConfig != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r10) == false) goto L10;
        return false;
    L10:
        if (r11.booleanValue() == false) goto L15;
        if (sCommonEventConfig.isSampledService(r10) == true) goto L22;
    L16:
        return true;
    L22:
        return false;
    L15:
        if (sCommonEventConfig.isSampledLogType(r10) == false) goto L16;
        return false;
    }

    public static synchronized void setReportFullException(boolean r10) {
        monitor-enter(CommonEventDeliverer.class);
        isEnableException = r10;     // Catch: Throwable -> L7
        monitor-exit(CommonEventDeliverer.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void updateConfig(CommonEventConfig r10) {
        monitor-enter(CommonEventDeliverer.class);
        if (r10 != null) goto L28;
    L26:
        monitor-exit(CommonEventDeliverer.class);
        return;
    L28:
    L23:
        th = move-exception;
        throw th;
    L6:
        if (sCommonEventConfig == r10) goto L26;
        if (ApmBaseContext.isDebugMode() == false) goto L11;
        Logger.d(Constants.TAG, "updateConfig " + r10);     // Catch: Throwable -> L23
    L11:
        sCommonEventConfig = r10;     // Catch: Throwable -> L23
    L12:
        if (limitedQueue.isEmpty() == true) goto L21;
        Monitorable r11 = limitedQueue.pop();     // Catch: Throwable -> L23
        if ((r11 instanceof CommonEvent) == true) goto L16;
        if ((r11 instanceof CommonLog) == false) goto L12;
        monitorCommonLog((CommonLog) r11);     // Catch: Throwable -> L23
        goto L12
    L16:
        monitorEvent((CommonEvent) r11);     // Catch: Throwable -> L23
        goto L12
    L21:
        monitor-exit(CommonEventDeliverer.class);
    }
}
