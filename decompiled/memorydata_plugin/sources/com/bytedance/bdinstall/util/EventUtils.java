package com.bytedance.bdinstall.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.callback.event.Monitor;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.event.ParamsMonitor;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.event.VerifyMonitor;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdinstall.oaid.OaidMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventUtils {
    public static final String TAG = "EventTracking#";
    private static volatile EventUtils instance;
    private final Map<String, Map<String, Monitor>> monitorMap;

    private EventUtils() {
        this.monitorMap = new ConcurrentHashMap();
    }

    public static EventUtils getInstance() {
        if (instance != null) goto L15;
        monitor-enter(EventUtils.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new EventUtils();     // Catch: Throwable -> L11
    L9:
        monitor-exit(EventUtils.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    public static void onActiveResult(InstallOptions r2) {
        getInstance().getActivateMonitor(r2.getAid()).onEvent(r2, Constants.Events.DR_ACTIVATE_RESULT);
    }

    public static void onDidFetchResult(InstallOptions r7, JSONObject r8, JSONObject r9) {
        JSONObject r1 = new JSONObject();
        if (r9 != null) goto L5;
    L7:
        boolean r10 = false;
    L8:
        JSONObject r2 = r8.optJSONObject(Oaid.KEY_OAID_ID);
        String r3 = null;
        if (r2 == null) goto L11;
        OaidModel r4 = OaidModel.create(r2.toString());
    L12:
        boolean r5 = TextUtils.isEmpty(r8.optString("install_id"));
        boolean r6 = TextUtils.isEmpty(r8.optString("device_id"));
        r1.put("reqeust_did_success", r10);     // Catch: JSONException -> L19
        r1.put("empty_iid", r5);     // Catch: JSONException -> L19
        r1.put("empty_did", r6);     // Catch: JSONException -> L19
        if (r4 == null) goto L17;
        r3 = r4.oaid;     // Catch: JSONException -> L19
    L17:
        r1.put("dr_oaid", r3);     // Catch: JSONException -> L19
        r1.put("oaid_thread_switch_ts", OaidMonitor.getReadStartInitTs() - OaidMonitor.getInitTs());     // Catch: JSONException -> L19
        r1.put("oaid_file_load_ts", OaidMonitor.getStartSystemCall() - OaidMonitor.getReadStartInitTs());     // Catch: JSONException -> L19
        r1.put("oaid_sys_call_ts", OaidMonitor.getSystemCallFinished() - OaidMonitor.getStartSystemCall());     // Catch: JSONException -> L19
        r1.put("oaid_save_ts", OaidMonitor.getOnFinishFetchOaid() - OaidMonitor.getSystemCallFinished());     // Catch: JSONException -> L19
        r1.put("dr_wait_oaid_realtime", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());     // Catch: JSONException -> L19
        r1.put("dr_wait_oaid_estimate_time", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());     // Catch: JSONException -> L19
        r1.put("support_oaid", r8.optBoolean(SstLoader.KEY_OAID_SUPPORT));     // Catch: JSONException -> L19
        r1.put("oaid_impl", Oaid.instance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r7.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getImplName());     // Catch: JSONException -> L19
    L21:
        if (r7 != null) goto L23;
    L25:
        DrLog.d("did_fetch_result, " + r1);
        return;
    L23:
        if (r7.getEventDepend() == null) goto L25;
        r7.getEventDepend().onEvent("did_fetch_result", r1);
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L11:
        r4 = null;
        goto L12
    L5:
        if (TextUtils.isEmpty(r9.optString("device_id_str")) == true) goto L7;
        r10 = true;
        goto L8
    }

    public static void onRegisterParams(InstallOptions r2) {
        getInstance().getParamsMonitor(r2.getAid()).onEvent(r2, Constants.Events.DR_REGISTER_PARAM);
    }

    public static void onRegisterResult(InstallOptions r2) {
        getInstance().getRegisterMonitor(r2.getAid()).onEvent(r2, Constants.Events.DR_REGISTER_RESULT);
    }

    public static void onVerifyResult(InstallOptions r2) {
        if (BDInstall.getBDInstallConfig().isEnableDidGuard() == false) goto L6;
        getInstance().getVerifyMonitor(r2.getAid()).onEvent(r2, Constants.Events.DR_VERIFY_RESULT);
        return;
    }

    public ActivateMonitor getActivateMonitor(int r4) {
        Map<String, Monitor> r0 = (Map) ZeusTransformUtils.preCheckCast(this.monitorMap.get(String.valueOf(r4)), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.monitorMap.put(String.valueOf(r4), r0);
    L5:
        ActivateMonitor r3 = (ActivateMonitor) ZeusTransformUtils.preCheckCast(r0.get(Constants.Events.KEY_ACTIVATE), ActivateMonitor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        ActivateMonitor r5 = new ActivateMonitor();
        r0.put(Constants.Events.KEY_ACTIVATE, r5);
        return r5;
    L9:
        return r3;
    }

    public ParamsMonitor getParamsMonitor(int r4) {
        Map<String, Monitor> r0 = (Map) ZeusTransformUtils.preCheckCast(this.monitorMap.get(String.valueOf(r4)), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.monitorMap.put(String.valueOf(r4), r0);
    L5:
        ParamsMonitor r3 = (ParamsMonitor) ZeusTransformUtils.preCheckCast(r0.get(Constants.Events.KEY_PARAMS), ParamsMonitor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        ParamsMonitor r5 = new ParamsMonitor();
        r0.put(Constants.Events.KEY_PARAMS, r5);
        return r5;
    L9:
        return r3;
    }

    public RegisterMonitor getRegisterMonitor(int r4) {
        Map<String, Monitor> r0 = (Map) ZeusTransformUtils.preCheckCast(this.monitorMap.get(String.valueOf(r4)), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.monitorMap.put(String.valueOf(r4), r0);
    L5:
        RegisterMonitor r3 = (RegisterMonitor) ZeusTransformUtils.preCheckCast(r0.get(Constants.Events.KEY_REGISTER), RegisterMonitor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        RegisterMonitor r5 = new RegisterMonitor();
        r0.put(Constants.Events.KEY_REGISTER, r5);
        return r5;
    L9:
        return r3;
    }

    public VerifyMonitor getVerifyMonitor(int r4) {
        Map<String, Monitor> r0 = (Map) ZeusTransformUtils.preCheckCast(this.monitorMap.get(String.valueOf(r4)), Map.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new ConcurrentHashMap();
        this.monitorMap.put(String.valueOf(r4), r0);
    L5:
        VerifyMonitor r3 = (VerifyMonitor) ZeusTransformUtils.preCheckCast(r0.get(Constants.Events.KEY_VERIFY), VerifyMonitor.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        VerifyMonitor r5 = new VerifyMonitor();
        r0.put(Constants.Events.KEY_VERIFY, r5);
        return r5;
    L9:
        return r3;
    }

    public void setMonitors(int r4) {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        r0.put(Constants.Events.KEY_REGISTER, new RegisterMonitor());
        r0.put(Constants.Events.KEY_ACTIVATE, new ActivateMonitor());
        r0.put(Constants.Events.KEY_PARAMS, new ParamsMonitor());
        this.monitorMap.put(String.valueOf(r4), r0);
    }
}
