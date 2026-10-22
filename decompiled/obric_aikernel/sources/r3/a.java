package r3;

import android.text.TextUtils;
import c4.d;
import com.bytedance.apm6.hub.config.internal.SlardarSettingsConstants;
import com.bytedance.services.apm.api.IApmAgent;
import com.bytedance.services.slardar.config.IConfigManager;
import org.json.JSONObject;
import t4.b;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static boolean a(String r10) {
        return b("custom_event_settings", "allow_service_name", r10);
    }

    public static boolean b(String r10, String r11, String r12) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
    L22:
        return false;
    L5:
        if (TextUtils.isEmpty(r11) == true) goto L22;
        if (TextUtils.isEmpty(r12) == true) goto L22;
        IConfigManager r13 = (IConfigManager) d.a(IConfigManager.class);     // Catch: Exception -> L20
        if (r13 == null) goto L25;
        JSONObject r14 = r13.getConfigJSON(r10);     // Catch: Exception -> L20
        if (r14 == null) goto L26;
        JSONObject r15 = r14.optJSONObject(r11);     // Catch: Exception -> L20
        if (r15 == null) goto L27;
        if (r15.optInt(r12, 0) == 1) goto L19;
        return false;
    L19:
        return true;
    L27:
        return false;
    L26:
        return false;
    L25:
        return false;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L22
    }

    public static boolean c(String r10) {
        if (b(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, SlardarSettingsConstants.PERF_KEY_MEMORY, r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (o3.a.j().h() == true) goto L8;
        return false;
    }

    public static boolean d(String r10) {
        return b(SlardarSettingsConstants.SETTING_PERFORMANCE_MODULES, SlardarSettingsConstants.PERF_KEY_MEMORY, r10);
    }

    public static void e(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        IApmAgent r11 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L9
        if (r11 == null) goto L14;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L9
        r12.put(r10, 1);     // Catch: Exception -> L9
        r11.monitorEvent("memory_dump_event", r12, null, null);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void f(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        IApmAgent r11 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L9
        if (r11 == null) goto L14;
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L9
        r12.put(r10, 1);     // Catch: Exception -> L9
        r11.monitorEvent(b.a().j("memory_dump_event").i(r12).h(true).g());     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static void g(String r10, long r11) {
        if (TextUtils.isEmpty(r10) == false) goto L12;
        return;
    L12:
        IApmAgent r12 = (IApmAgent) d.a(IApmAgent.class);     // Catch: Exception -> L9
        if (r12 == null) goto L14;
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L9
        r13.put(r10, r11);     // Catch: Exception -> L9
        r12.monitorEvent("memory_dump_event", null, r13, null);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }
}
