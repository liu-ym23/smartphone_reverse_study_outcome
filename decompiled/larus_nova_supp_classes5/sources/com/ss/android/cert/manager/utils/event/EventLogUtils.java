package com.ss.android.cert.manager.utils.event;

import android.text.TextUtils;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.ablity.ICertMonitorConfig;
import com.ss.android.cert.manager.ablity.IEventParamsInterceptor;
import com.ss.android.cert.manager.ablity.IExceptionCallback;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.utils.CertLog;
import com.ss.android.cert.manager.utils.net.CertResponse;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class EventLogUtils {
    public static String lastModule = "";
    public static String module = "";

    public EventLogUtils() {
    }

    public static void eventSdkSessionLaunch() {
        JSONObject r0 = new JSONObject();
        r0.put("sdk_aid", 7374);     // Catch: Exception -> L5
        r0.put(EffectConfiguration.KEY_SDK_VERSION, BytedCertConstant.VERSION);     // Catch: Exception -> L5
    L7:
        onEvent("sdk_session_launch", r0);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void onEvent(String r1) {
        onEvent(r1, null);
    }

    private static void removeSensitiveKey(JSONObject r5) {
        Iterator<String> r6 = r5.keys();
    L4:
        if (r6.hasNext() == false) goto L11;
        String r0 = r6.next();
        String[] r1 = BytedCertConstant.SENSITIVE_KEY_SETS;
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L4;
        if (r1[r3].equalsIgnoreCase(r0) == false) goto L10;
        r6.remove();
    L10:
        r3 = r3 + 1;
        goto L6
    }

    private static JSONObject appendParams(String r2, JSONObject r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Collection<IEventParamsInterceptor> r0 = CertManager.getInstance().getEventParamsInterceptors();
        if (r0 != null) goto L8;
    L15:
        return r3;
    L8:
        if (r0.size() <= 0) goto L15;
        Iterator<IEventParamsInterceptor> r1 = r0.iterator();
    L11:
        if (r1.hasNext() == false) goto L15;
        IEventParamsInterceptor r4 = r1.next();
        if (r4 == null) goto L11;
        r3 = r4.intercept(r2, r3);
        goto L11
    }

    public static void onEvent(String r5, JSONObject r6) {
        if (r6 != null) goto L13;
        r6 = new JSONObject();
    L13:
        removeSensitiveKey(r6);     // Catch: Exception -> L10
        r6.put("params_for_special", "uc_login");     // Catch: Exception -> L10
        r6.put("uc_verify_action_time", System.currentTimeMillis());     // Catch: Exception -> L10
        r6.put(EffectConfiguration.KEY_SDK_VERSION, BytedCertConstant.VERSION);     // Catch: Exception -> L10
        ICertMonitorConfig r1 = CertManager.getInstance().getMonitor();     // Catch: Exception -> L10
        if (r1 == null) goto L9;
        r6.put("app_id", r1.getAppId() + "");     // Catch: Exception -> L10
        r6.put("last_module", lastModule);     // Catch: Exception -> L10
        r6.put("module", module);     // Catch: Exception -> L10
        JSONObject r7 = appendParams(r5, r6);     // Catch: Exception -> L10
        r1.onEvent(r5, r7);     // Catch: Exception -> L10
        CertLog.w("bytecert", "event = " + r5 + " obj = " + r7);     // Catch: Exception -> L10
        return;
    L9:
        throw new NullPointerException("cert monitor is null");     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public static void onExceptionEvent(Throwable r3, int r4) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L9
        if (r3 == null) goto L5;
        r0.put("exception_stack_trace", CertLog.getStackTraceString(r3));     // Catch: Exception -> L9
        r0.put("exception_msg", r3.getMessage());     // Catch: Exception -> L9
    L5:
        r0.put("error_code", r4);     // Catch: Exception -> L9
        onEvent("byted_cert_sdk_exception", r0);     // Catch: Exception -> L9
        IExceptionCallback r1 = CertManager.getInstance().getExceptionCallback();     // Catch: Exception -> L9
        if (r1 == null) goto L14;
        r1.onException(r3, r4);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void onEvent(String r3, Map<String, String> r4) {
        JSONObject r0 = new JSONObject();
        if (r4 != null) goto L16;
    L13:
        onEvent(r3, r0);
        return;
    L16:
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();     // Catch: Exception -> L15
    L6:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, String> r1 = r5.next();     // Catch: Exception -> L15
        if (TextUtils.isEmpty(r1.getKey()) == true) goto L6;
        if (TextUtils.isEmpty(r1.getValue()) == true) goto L6;
        r0.put(r1.getKey(), r1.getValue());     // Catch: Exception -> L15
        goto L6
    }

    public static void onEvent(String r1, String r2) {
        JSONObject r0 = new JSONObject(r2);     // Catch: Exception -> L4
    L5:
        onEvent(r1, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void performanceEvent(String r3, CertResponse r4, Integer r5, JSONObject r6, String r7) {
        if (r6 != null) goto L4;
        r6 = new JSONObject();
    L4:
        if (r4 != null) goto L31;
    L25:
        if (r5 == null) goto L29;
        r6.put("duration", r5);     // Catch: Exception -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L29:
        onEvent(r3, r6);
        return;
    L31:
        if (r4.success == false) goto L8;
        String r1 = "1";
    L9:
        r6.put("result", r1);     // Catch: Exception -> L23
        r6.put("error_code", String.valueOf(r4.errorCode));     // Catch: Exception -> L23
        String r2 = "";
        if (TextUtils.isEmpty(r4.errorMsg) == false) goto L13;
        String r8 = "";
    L14:
        r6.put("fail_reason", r8);     // Catch: Exception -> L23
        if (TextUtils.isEmpty(r7) == true) goto L18;
        r6.put("error_stack", r7);     // Catch: Exception -> L23
        goto L25
    L18:
        if (TextUtils.isEmpty(r4.detailErrorMsg) == true) goto L21;
        r2 = r4.detailErrorMsg;     // Catch: Exception -> L23
    L21:
        r6.put("error_stack", r2);     // Catch: Exception -> L23
        goto L25
    L13:
        r8 = r4.errorMsg;     // Catch: Exception -> L23
        goto L14
    L8:
        r1 = "0";
        goto L9
    }
}
