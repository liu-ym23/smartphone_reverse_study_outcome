package bpa;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import com.privacy.azerothprivacy.AzerothPrivacy;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import fpa.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {

    /* JADX INFO: renamed from: bpa.a$a, reason: collision with other inner class name */
    public static class C0000a implements SDKMonitor.IGetExtendParams {
        public C0000a() {
        }

        public final Map<String, String> getCommonParams() {
            return null;
        }

        public final String getSessionId() {
            return null;
        }
    }

    public static synchronized void a(Context r4) {
        monitor-enter(a.class);
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L20
        r1.put(EffectConfiguration.KEY_DEVICE_ID, AzerothPrivacy.getAppInfo().d);     // Catch: JSONException -> L17 Throwable -> L20
        r1.put("host_aid", AzerothPrivacy.getAppInfo().a);     // Catch: JSONException -> L17 Throwable -> L20
        r1.put(EffectConfiguration.KEY_SDK_VERSION, AzerothPrivacy.getVersion());     // Catch: JSONException -> L17 Throwable -> L20
        r1.put(EffectConfiguration.KEY_CHANNEL, AzerothPrivacy.getAppInfo().f);     // Catch: JSONException -> L17 Throwable -> L20
        r1.put(EffectConfiguration.KEY_APP_VERSION, AzerothPrivacy.getAppInfo().b);     // Catch: JSONException -> L17 Throwable -> L20
        r1.put("update_version_code", AzerothPrivacy.getAppInfo().c);     // Catch: JSONException -> L17 Throwable -> L20
        if (TextUtils.isEmpty(AzerothPrivacy.getAppInfo().g) == true) goto L8;
        r1.put("package_name", AzerothPrivacy.getAppInfo().g);     // Catch: JSONException -> L17 Throwable -> L20
    L8:
        AzerothPrivacy.getSdkConfig().a.getClass();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty("https://mon.snssdk.com/monitor/appmonitor/v4/settings") == true) goto L11;
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L20
        r3.add("https://mon.snssdk.com/monitor/appmonitor/v4/settings");     // Catch: Throwable -> L20
        SDKMonitorUtils.setConfigUrl("23330", r3);     // Catch: Throwable -> L20
    L11:
        AzerothPrivacy.getSdkConfig().a.getClass();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty("https://mon.snssdk.com/monitor/collect/") == true) goto L14;
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L20
        r5.add("https://mon.snssdk.com/monitor/collect/");     // Catch: Throwable -> L20
        SDKMonitorUtils.setDefaultReportUrl("23330", r5);     // Catch: Throwable -> L20
    L14:
        SDKMonitorUtils.initMonitor(r4.getApplicationContext(), "23330", r1, new C0000a());     // Catch: Throwable -> L20
        monitor-exit(a.class);
        return;
    L17:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public static void f(b r4) {
    L27:
        e = move-exception;
        apa.a.c("AzerothMonitor", "reportDebugEvent", e);
        return;
    L3:
        if (TextUtils.isEmpty(r4.a) == true) goto L37;
        String r0 = r4.a + "[" + r4.b + "]";     // Catch: Exception -> L27
        Exception r1 = r4.c;     // Catch: Exception -> L27
        if (apa.a.a == null) goto L10;
        apa.a.a.w(r0, r1);     // Catch: Exception -> L27
    L10:
        if (r4.d != null) goto L12;
        r4.d = new HashMap();     // Catch: Exception -> L27
    L12:
        ((HashMap) r4.d).put("tag", r4.a);     // Catch: Exception -> L27
        if (r4.e != null) goto L15;
        r4.e = new HashMap();     // Catch: Exception -> L27
    L15:
        ((HashMap) r4.e).putAll(fpa.a.a());     // Catch: Exception -> L27
        Exception r2 = r4.c;     // Catch: Exception -> L27
        if (r2 == null) goto L25;
        ((HashMap) r4.d).put("exceptionType", r2.getClass().getName());     // Catch: Exception -> L27
        ((HashMap) r4.e).put("errInfo", r4.c.getMessage());     // Catch: Exception -> L27
        Map r3 = b.a(r4.c);     // Catch: Exception -> L27
        if (r3 == null) goto L25;
        Iterator r5 = r3.entrySet().iterator();     // Catch: Exception -> L27
    L21:
        if (r5.hasNext() == false) goto L25;
        Map.Entry r6 = (Map.Entry) r5.next();     // Catch: Exception -> L27
        if (((HashMap) r4.e).get(r6.getKey()) != null) goto L21;
        ((HashMap) r4.e).put(r6.getKey(), r6.getValue());     // Catch: Exception -> L27
    L25:
        c("debug_event", r4.b, new JSONObject(r4.d), null, new JSONObject(r4.e));     // Catch: Exception -> L27
        return;
    }

    public static void g(HashMap r5) {
        JSONObject r1 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r1.put("KexgNetError", "key exchange common http exception");     // Catch: JSONException -> L8
        Iterator r0 = r5.entrySet().iterator();     // Catch: JSONException -> L8
    L5:
        if (r0.hasNext() == false) goto L10;
        Map.Entry r3 = (Map.Entry) r0.next();     // Catch: JSONException -> L8
        r2.put((String) r3.getKey(), r3.getValue());     // Catch: JSONException -> L8
    L10:
        b("crypto", r1, null, r2);
        return;
    L8:
        e = move-exception;
        xoa.a.a(e, "key exchange network event reporter Json exception", r5);
        goto L10
    }

    public static void d(long r3, int r5, JSONObject r6) {
        long r0 = System.currentTimeMillis() - r3;
        JSONObject r4 = new JSONObject();
        r4.put("duration", r0);     // Catch: JSONException -> L5
    L7:
        c("crypto", r5, r6, r4, null);
        return;
    L5:
        e = move-exception;
        xoa.a.a(e, "json exception", null);
        goto L7
    }

    public static void b(String r1, JSONObject r2, JSONObject r3, JSONObject r4) {
        SDKMonitorUtils.getInstance("23330").monitorEvent(r1, r2, r3, r4);
    }

    public static void c(String r7, int r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        SDKMonitorUtils.getInstance("23330").monitorStatusAndEvent(r7, r8, r9, r10, r11);
    }

    public static void e(long r3, int r5, long r6, long r8, JSONObject r10) {
        long r0 = System.currentTimeMillis() - r3;
        JSONObject r4 = new JSONObject();
        JSONObject r7 = new JSONObject();
        r4.put("duration", r0);     // Catch: JSONException -> L5
        epa.a.b(AzerothPrivacy.getAppContext()).getClass();     // Catch: JSONException -> L5
        r7.put("shared_preference", epa.a.a().toString());     // Catch: JSONException -> L5
        r7.put("key_version_in_mem", r6);     // Catch: JSONException -> L5
        r7.put("pre_key_version_in_mem", r8);     // Catch: JSONException -> L5
    L7:
        c("crypto", r5, r10, r4, r7);
        return;
    L5:
        e = move-exception;
        xoa.a.a(e, "json exception", null);
        goto L7
    }
}
