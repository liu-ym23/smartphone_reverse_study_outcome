package com.bytedance.android.live.saas.middleware.monitor;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.android.live.saas.middleware.console.Console;
import com.bytedance.android.live.saas.middleware.monitor.config.OutApmConfig;
import com.bytedance.android.live.saas.middleware.monitor.config.OutContextInfo;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.a;
import com.bytedance.apm.c;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.config.b;
import com.bytedance.apm.d;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014JH\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020#H\u0016J$\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020#H\u0016J&\u0010&\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J0\u0010'\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00192\b\u0010)\u001a\u0004\u0018\u00010\u00192\b\u0010*\u001a\u0004\u0018\u00010\u0019H\u0016J\u001c\u0010+\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010+\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020#H\u0016J$\u0010,\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020#H\u0016J$\u0010-\u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020#H\u0016JH\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J.\u00100\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0016J$\u00101\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u00172\b\u00102\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/android/live/saas/middleware/monitor/SlardarStrategy;", "Lcom/bytedance/android/live/saas/middleware/monitor/IMonitorReport;", "()V", "tag", "", "urlArray", "", "ensureNotReachHere", "", "t", "", Constants.OperatorKey.MSG, "init", "app", "Landroid/app/Application;", "monitorApiError", Constants.Keys.duration, "", "sendTime", "sendUrl", "sendIp", "traceCode", "status", "", "extJson", "Lorg/json/JSONObject;", "monitorCommonLog", "logType", "serviceName", "extra", "monitorDebugReal", "value", "monitorDirectOnCount", "type", "key", "", "monitorDirectOnTimer", "metricType", "monitorDuration", "monitorEvent", "category", "metric", "extraLog", "monitorOnCount", "monitorOnStore", "monitorOnTimer", "monitorSLA", "sendDuration", "monitorStatusAndDuration", "monitorStatusRate", "logExtra", "middleware_release"}, k = 1, mv = {1, 4, 3})
public final class SlardarStrategy extends IMonitorReport {
    private final String tag;
    private final List<String> urlArray;

    public SlardarStrategy() {
        this.tag = "livesdk/slardarSlardarInitTask";
        this.urlArray = CollectionsKt.mutableListOf(new String[]{"https://mon.snssdk.com/monitor/appmonitor/v2/settings", "https://monsetting.toutiao.com/monitor/appmonitor/v2/settings"});
    }

    public static final /* synthetic */ String access$getTag$p(SlardarStrategy r0) {
        return r0.tag;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void init(Application r13) {
        if (BDLiveSdk.getAppInfo() != null) goto L6;
        Console.e("livesdk/slardar_SlardarConfig", "Slardar init failure, BDLiveSdk.appInfo is null");
        return;
    L6:
        IAppInfo r1 = BDLiveSdk.getAppInfo();
        Intrinsics.checkNotNull(r1);
        int r2 = r1.appId();
        IAppInfo r3 = BDLiveSdk.getAppInfo();
        Intrinsics.checkNotNull(r3);
        String r4 = r3.devicesId();
        IAppInfo r5 = BDLiveSdk.getAppInfo();
        Intrinsics.checkNotNull(r5);
        String r6 = r5.versionName();
        IAppInfo r7 = BDLiveSdk.getAppInfo();
        Intrinsics.checkNotNull(r7);
        OutContextInfo r0 = new OutContextInfo(r2, r4, r6, r7.channel());
        OutApmConfig r8 = new OutApmConfig(false, 0, false, 7, null);
        int r9 = c.b.a;
        ApmDelegate r10 = ApmDelegate.g.a;
        r10.getClass();
        r10.c(r13, new b(new b.a()));
        if (d.c == false) goto L9;
        bt3.c.a().b(new a());
    L9:
        Console.i("livesdk/slardar_SlardarInitTask", "start init");
        c.a(new ApmStartConfig.Builder().aid(r0.getAid()).deviceId(r0.getDeviceId()).appVersion(r0.getAppVersion()).channel(r0.getChannel()).configFetchUrl(this.urlArray).blockDetect(r8.getBatteryDetect()).blockThresholdMs(r8.getBlockThresholdMs()).batteryDetect(r8.getBatteryDetect()).widget(new x8a.d()).apmStartListener(new SlardarStrategy$init$config$1(this)).apmLogListener(new SlardarStrategy$init$config$2(this)).build());
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r1) {
        MonitorUtils.monitorDebugReal(r1);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void ensureNotReachHere(Throwable r1, String r2) {
        com.bytedance.article.common.monitor.stack.a.a(r1, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r1, JSONObject r2) {
        ApmAgent.monitorCommonLog(r1, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r1, String r2) {
        MonitorUtils.monitorDebugReal(r1, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r1, String r2) {
        MonitorUtils.monitorOnCount(r1, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r2, String r3, JSONObject r4) {
        if (r4 != null) goto L12;
        r4 = new JSONObject();
    L12:
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        ApmAgent.monitorCommonLog(r2, r4);
        return;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        r4.put("service", r3);     // Catch: JSONException -> L8
        goto L10
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnCount(String r1, String r2, float r3) {
        MonitorUtils.monitorDirectOnCount(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnTimer(String r1, String r2, float r3) {
        ApmAgent.monitorDirectOnTimer(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDuration(String r1, JSONObject r2, JSONObject r3) {
        ApmAgent.monitorDuration(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r1, String r2, float r3) {
        MonitorUtils.monitorOnCount(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnStore(String r1, String r2, float r3) {
        MonitorUtils.monitorOnStore(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnTimer(String r1, String r2, float r3) {
        MonitorUtils.monitorOnTimer(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusRate(String r1, int r2, JSONObject r3) {
        ApmAgent.monitorStatusRate(r1, r2, r3);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorEvent(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        ApmAgent.monitorEvent(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusAndDuration(String r1, int r2, JSONObject r3, JSONObject r4) {
        ApmAgent.monitorStatusAndDuration(r1, r2, r3, r4);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorApiError(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
        ApmAgent.monitorApiError(r1, r3, r5, r6, r7, r8, r9);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorSLA(long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
        ApmAgent.monitorSLA(r1, r3, r5, r6, r7, r8, r9);
    }
}
