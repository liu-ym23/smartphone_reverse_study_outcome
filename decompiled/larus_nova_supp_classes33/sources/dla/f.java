package dla;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.news.common.settings.api.SettingsData;
import com.larus.apm.api.IExtraParams;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Deprecated;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements h37.b {
    public final com.bytedance.ai.api.a a;
    public final Function0<Unit> b;
    public final Context c;
    public int d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        int r0 = this.d + 1;
        this.d = r0;
        if (r0 > 3) goto L5;
        p2.c.e(new e(), 3000);
        return;
    L5:
        Function0<Unit> r1 = this.b;
        if (r1 == null) goto L10;
        r1.invoke();
        return;
    }

    @Deprecated(message = "Deprecated in Java")
    public final h37.c request() {
        com.bytedance.ai.utils.g.a.i("MiniAppSettingsRequestService", "Send request");
        h37.c r8 = new h37.c();
    L63:
        th = move-exception;
        a();
        com.bytedance.ai.utils.g.a.w("MiniAppSettingsRequestService", "fetch settings failed", th);
        return r8;
    L4:
        if (NetworkUtils.isNetworkAvailable(this.c) == true) goto L7;
        a();     // Catch: Throwable -> L63
        return r8;
    L7:
        StringBuilder r10 = new StringBuilder("https://is.snssdk.com/service/settings/v3/?caller_name=obric-mini-app&ai_sdk_version_name=1.15.0-rc.7&ai_sdk_version_code=1150057");     // Catch: Throwable -> L63
        StringBuilder r7 = new StringBuilder("&is_32bit=");     // Catch: Throwable -> L63
        int r6 = com.bytedance.ai.utils.a.a;     // Catch: Throwable -> L63
        boolean r12 = false;
        if (Build.VERSION.SDK_INT >= 23) goto L10;
    L13:
        int r9 = 1;
    L14:
        r7.append(r9);     // Catch: Throwable -> L63
        r10.append(r7.toString());     // Catch: Throwable -> L63
        if (this.a.p == false) goto L17;
        r10.append("&use_ppe=1");     // Catch: Throwable -> L63
        r10.append("&http_env=" + this.a.q);     // Catch: Throwable -> L63
    L17:
        IExtraParams.Companion r5 = IExtraParams.a;     // Catch: Throwable -> L63
        if (r5.b().length() <= 0) goto L20;
        boolean r11 = true;
    L21:
        if (r11 == false) goto L23;
        r10.append("&flow_app_variant=".concat(r5.b()));     // Catch: Throwable -> L63
    L23:
        String r4 = r10.toString();     // Catch: Throwable -> L63
        String r13 = null;
        if (StringsKt.startsWith$default(r4, "https", false, 2, null) == true) goto L67;
        if (StringsKt.startsWith$default(r4, "http", false, 2, null) == false) goto L67;
        r4 = new Regex("http").replaceFirst(r4, "https");     // Catch: Throwable -> L63
    L67:
        String r0 = NetworkClient.getDefault().post(r4, new byte[1], false, "application/json", true);     // Catch: Throwable -> L31
    L33:
        if (r0 != null) goto L35;
    L36:
        r12 = true;
    L37:
        if (r12 == false) goto L40;
        a();     // Catch: Throwable -> L63
        com.bytedance.ai.utils.g.a.w("MiniAppSettingsRequestService", "settings response is null");     // Catch: Throwable -> L63
        return r8;
    L40:
        JSONObject r2 = new JSONObject(r0);     // Catch: Throwable -> L63
        if (Intrinsics.areEqual(WindowEvent.WindowOpenPerfResult.SUCCESS, r2.optString("message")) == true) goto L44;
        a();     // Catch: Throwable -> L63
        com.bytedance.ai.utils.g.a.w("MiniAppSettingsRequestService", "settings response is not success");     // Catch: Throwable -> L63
        return r8;
    L44:
        JSONObject r1 = r2.optJSONObject("data");     // Catch: Throwable -> L63
        if (r1 == null) goto L47;
        JSONObject r3 = r1.optJSONObject("settings");     // Catch: Throwable -> L63
    L48:
        if (r3 == null) goto L50;
        JSONObject r14 = r3.optJSONObject("sdk_key_obric-mini-app");     // Catch: Throwable -> L63
    L51:
        if (r14 == null) goto L53;
        SettingsData r15 = new SettingsData(r14, null);     // Catch: Throwable -> L63
    L54:
        h37.c r16 = new h37.c();     // Catch: Throwable -> L63
        r16.b = r15;     // Catch: Throwable -> L63
        if (r1 == null) goto L57;
        JSONObject r17 = r1.optJSONObject("vid_info");     // Catch: Throwable -> L63
    L58:
        r16.c = r17;     // Catch: Throwable -> L63
        if (r1 == null) goto L61;
        r13 = r1.optString("ctx_infos");     // Catch: Throwable -> L63
    L61:
        r16.d = r13;     // Catch: Throwable -> L63
        r16.a = true;     // Catch: Throwable -> L63
        com.bytedance.ai.utils.g.a.i("MiniAppSettingsRequestService", "settings response: " + r1);     // Catch: Throwable -> L63
        return r16;
    L57:
        r17 = null;
        goto L58
    L53:
        r15 = new SettingsData(r3, null);     // Catch: Throwable -> L63
        goto L54
    L50:
        r14 = null;
        goto L51
    L47:
        r3 = null;
        goto L48
    L35:
        if (r0.length() != 0) goto L37;
    L31:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L63
        r0 = null;
        goto L33
    L20:
        r11 = false;
        goto L21
    L10:
        if (Process.is64Bit() == false) goto L13;
        r9 = 0;
        goto L14
    }

    public final Context getContext() {
        return this.c;
    }

    public f(com.bytedance.ai.api.a r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
        this.b = r3;
        this.c = r2.a;
    }
}
