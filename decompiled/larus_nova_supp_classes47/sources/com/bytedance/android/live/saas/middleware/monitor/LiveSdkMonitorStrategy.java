package com.bytedance.android.live.saas.middleware.monitor;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.android.live.saas.middleware.BDLiveSdk;
import com.bytedance.android.live.saas.middleware.IAppInfo;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.bytedance.services.apm.api.EnsureManager;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public class LiveSdkMonitorStrategy extends IMonitorReport {
    private static final String LIVE_SDK_AID = "1730";
    private static final String REPORT_URL = "https://mon.snssdk.com/monitor/collect/";
    private String hostAid;
    private SDKMonitor mSDKMonitor;

    private List<String> getConfigUrls() {
        LinkedList r0 = new LinkedList();
        r0.add("https://mon.snssdk.com/monitor/appmonitor/v2/settings");
        r0.add("https://monsetting.toutiao.com/monitor/appmonitor/v2/settings");
        return r0;
    }

    private List<String> getReportUrls() {
        LinkedList r0 = new LinkedList();
        r0.add(REPORT_URL);
        return r0;
    }

    public LiveSdkMonitorStrategy(String r1) {
        this.hostAid = r1;
    }

    public static /* synthetic */ String access$000(LiveSdkMonitorStrategy r0) {
        return r0.hostAid;
    }

    private void addHostId(JSONObject r5) {
        if (r5 != null) goto L10;
        r5 = new JSONObject();
    L10:
        r5.put("webcast_app_id", "" + BDLiveSdk.getAppInfo().appId());     // Catch: JSONException -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void init(Application r5) {
        super.init(r5);
        JSONObject r0 = new JSONObject();
        IAppInfo r1 = BDLiveSdk.getAppInfo();     // Catch: JSONException -> L9
        if (TextUtils.isEmpty(this.hostAid) == false) goto L6;
        this.hostAid = r1.hostAppId();     // Catch: JSONException -> L9
    L6:
        r0.put("device_id", r1.devicesId());     // Catch: JSONException -> L9
        r0.put("host_aid", this.hostAid);     // Catch: JSONException -> L9
        r0.put("sdk_version", r1.sdkVersion());     // Catch: JSONException -> L9
        r0.put("channel", r1.channel());     // Catch: JSONException -> L9
        r0.put("app_version", r1.versionName());     // Catch: JSONException -> L9
        r0.put("update_version_code", r1.updateVersionCode());     // Catch: JSONException -> L9
        SDKMonitorUtils.setDefaultReportUrl(LIVE_SDK_AID, getReportUrls());
        SDKMonitorUtils.setConfigUrl(LIVE_SDK_AID, getConfigUrls());
        SDKMonitorUtils.initMonitor(r5, LIVE_SDK_AID, r0, new AnonymousClass1(this));
        this.mSDKMonitor = SDKMonitorUtils.getInstance(LIVE_SDK_AID);
        return;
    L9:
        e = move-exception;
        throw new IllegalStateException("bad json error", e);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r2) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void ensureNotReachHere(Throwable r1, String r2) {
        EnsureManager.ensureNotReachHere(r1, r2);
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r2, JSONObject r3) {
        addHostId(r3);
        SDKMonitor r0 = this.mSDKMonitor;
        if (r0 == null) goto L6;
        r0.monitorCommonLog(r2, r3);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDebugReal(String r1, String r2) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r1, String r2) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorCommonLog(String r2, String r3, JSONObject r4) {
        addHostId(r4);
        if (r4 != null) goto L13;
        r4 = new JSONObject();
    L13:
    L9:
        e = move-exception;
        e.printStackTrace();
    L11:
        monitorCommonLog(r2, r4);
        return;
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L11;
        r4.put("service", r3);     // Catch: JSONException -> L9
        goto L11
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnCount(String r1, String r2, float r3) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDirectOnTimer(String r1, String r2, float r3) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorDuration(String r2, JSONObject r3, JSONObject r4) {
        addHostId(r4);
        SDKMonitor r0 = this.mSDKMonitor;
        if (r0 == null) goto L6;
        r0.monitorDuration(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnCount(String r1, String r2, float r3) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnStore(String r1, String r2, float r3) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorOnTimer(String r1, String r2, float r3) {
        if (BDLiveSdk.getAppInfo().isDebug() == true) goto L6;
        return;
    L6:
        throw new RuntimeException("sdkmonitor unsupport this api");
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusRate(String r2, int r3, JSONObject r4) {
        addHostId(r4);
        SDKMonitor r0 = this.mSDKMonitor;
        if (r0 == null) goto L6;
        r0.monitorStatusRate(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorEvent(String r2, JSONObject r3, JSONObject r4, JSONObject r5) {
        SDKMonitor r0 = this.mSDKMonitor;
        if (r0 == null) goto L6;
        r0.monitorEvent(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorStatusAndDuration(String r2, int r3, JSONObject r4, JSONObject r5) {
        addHostId(r5);
        SDKMonitor r0 = this.mSDKMonitor;
        if (r0 == null) goto L6;
        r0.monitorStatusAndDuration(r2, r3, r4, r5);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorApiError(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        addHostId(r20);
        SDKMonitor r1 = this.mSDKMonitor;
        if (r1 == null) goto L6;
        r1.monitorApiError(r12, r14, r16, r17, r18, r19, r20);
        return;
    }

    @Override // com.bytedance.android.live.saas.middleware.monitor.IMonitorReport
    public void monitorSLA(long r12, long r14, String r16, String r17, String r18, int r19, JSONObject r20) {
        addHostId(r20);
        SDKMonitor r1 = this.mSDKMonitor;
        if (r1 == null) goto L6;
        r1.monitorSLA(r12, r14, r16, r17, r18, r19, r20);
        return;
    }
}
