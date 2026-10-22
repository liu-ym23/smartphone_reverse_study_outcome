package com.bytedance.bdinstall.util;

import android.text.TextUtils;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.callback.event.Monitor;
import com.bytedance.bdinstall.event.ActivateMonitor;
import com.bytedance.bdinstall.event.ParamsMonitor;
import com.bytedance.bdinstall.event.RegisterMonitor;
import com.bytedance.bdinstall.loader.SstLoader;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdinstall.oaid.OaidMonitor;
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

    public static void onActiveResult(InstallOptions r10) {
        getInstance().getActivateMonitor(r10.getAid()).onEvent(r10, LocalConstants.Events.DR_ACTIVATE_RESULT);
    }

    public static void onDidFetchResult(InstallOptions r10, JSONObject r11, JSONObject r12) {
        JSONObject r13 = new JSONObject();
        if (r12 != null) goto L5;
    L7:
        boolean r14 = false;
    L8:
        JSONObject r15 = r11.optJSONObject(Oaid.KEY_OAID_ID);
        String r16 = null;
        if (r15 == null) goto L11;
        OaidModel r17 = OaidModel.create(r15.toString());
    L12:
        boolean r18 = TextUtils.isEmpty(r11.optString("install_id"));
        boolean r19 = TextUtils.isEmpty(r11.optString("device_id"));
        r13.put("reqeust_did_success", r14);     // Catch: JSONException -> L19
        r13.put("empty_iid", r18);     // Catch: JSONException -> L19
        r13.put("empty_did", r19);     // Catch: JSONException -> L19
        if (r17 == null) goto L17;
        r16 = r17.oaid;     // Catch: JSONException -> L19
    L17:
        r13.put("dr_oaid", r16);     // Catch: JSONException -> L19
        r13.put("oaid_thread_switch_ts", OaidMonitor.getReadStartInitTs() - OaidMonitor.getInitTs());     // Catch: JSONException -> L19
        r13.put("oaid_file_load_ts", OaidMonitor.getStartSystemCall() - OaidMonitor.getReadStartInitTs());     // Catch: JSONException -> L19
        r13.put("oaid_sys_call_ts", OaidMonitor.getSystemCallFinished() - OaidMonitor.getStartSystemCall());     // Catch: JSONException -> L19
        r13.put("oaid_save_ts", OaidMonitor.getOnFinishFetchOaid() - OaidMonitor.getSystemCallFinished());     // Catch: JSONException -> L19
        r13.put("dr_wait_oaid_realtime", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());     // Catch: JSONException -> L19
        r13.put("dr_wait_oaid_estimate_time", OaidMonitor.getRegisterWaitFinish() - OaidMonitor.getRegisterWaitOaid());     // Catch: JSONException -> L19
        r13.put("support_oaid", r11.optBoolean(SstLoader.KEY_OAID_SUPPORT));     // Catch: JSONException -> L19
        r13.put("oaid_impl", Oaid.instance(r10.getContext()).getImplName());     // Catch: JSONException -> L19
    L21:
        if (r10 != null) goto L23;
    L25:
        DrLog.d("did_fetch_result, " + r13);
        return;
    L23:
        if (r10.getEventDepend() == null) goto L25;
        r10.getEventDepend().onEvent("did_fetch_result", r13);
    L19:
        e = move-exception;
        e.printStackTrace();
        goto L21
    L11:
        r17 = null;
        goto L12
    L5:
        if (TextUtils.isEmpty(r12.optString("device_id_str")) == true) goto L7;
        r14 = true;
        goto L8
    }

    public static void onRegisterParams(InstallOptions r10) {
        getInstance().getParamsMonitor(r10.getAid()).onEvent(r10, LocalConstants.Events.DR_REGISTER_PARAM);
    }

    public static void onRegisterResult(InstallOptions r10) {
        getInstance().getRegisterMonitor(r10.getAid()).onEvent(r10, LocalConstants.Events.DR_REGISTER_RESULT);
    }

    public ActivateMonitor getActivateMonitor(int r10) {
        Map<String, Monitor> r11 = this.monitorMap.get(String.valueOf(r10));
        if (r11 != null) goto L6;
        r11 = new ConcurrentHashMap();
    L6:
        if (r11.get(LocalConstants.Events.KEY_ACTIVATE) != null) goto L9;
        r11.put(LocalConstants.Events.KEY_ACTIVATE, new ActivateMonitor());
        this.monitorMap.put(String.valueOf(r10), r11);
    L9:
        return (ActivateMonitor) r11.get(LocalConstants.Events.KEY_ACTIVATE);
    }

    public ParamsMonitor getParamsMonitor(int r10) {
        Map<String, Monitor> r11 = this.monitorMap.get(String.valueOf(r10));
        if (r11 != null) goto L6;
        r11 = new ConcurrentHashMap();
    L6:
        if (r11.get(LocalConstants.Events.KEY_PARAMS) != null) goto L9;
        r11.put(LocalConstants.Events.KEY_PARAMS, new ParamsMonitor());
        this.monitorMap.put(String.valueOf(r10), r11);
    L9:
        return (ParamsMonitor) r11.get(LocalConstants.Events.KEY_PARAMS);
    }

    public RegisterMonitor getRegisterMonitor(int r10) {
        Map<String, Monitor> r11 = this.monitorMap.get(String.valueOf(r10));
        if (r11 != null) goto L6;
        r11 = new ConcurrentHashMap();
    L6:
        if (r11.get(LocalConstants.Events.KEY_REGISTER) != null) goto L9;
        r11.put(LocalConstants.Events.KEY_REGISTER, new RegisterMonitor());
        this.monitorMap.put(String.valueOf(r10), r11);
    L9:
        return (RegisterMonitor) r11.get(LocalConstants.Events.KEY_REGISTER);
    }

    public void setMonitors(int r10) {
        ConcurrentHashMap r11 = new ConcurrentHashMap();
        r11.put(LocalConstants.Events.KEY_REGISTER, new RegisterMonitor());
        r11.put(LocalConstants.Events.KEY_ACTIVATE, new ActivateMonitor());
        r11.put(LocalConstants.Events.KEY_PARAMS, new ParamsMonitor());
        this.monitorMap.put(String.valueOf(r10), r11);
    }
}
