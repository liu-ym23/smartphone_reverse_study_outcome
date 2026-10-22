package s5;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.keva.Keva;
import com.bytedance.news.common.settings.api.SettingsData;
import java.net.URI;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements h37.b {
    public static final a d = null;
    public final Context a;
    public final Keva b;
    public int c;

    public static final class a {
        public a() {
        }

        public static String a(String r10) {
            if (r10 == null) goto L73;
            String r11 = StringsKt.trim(r10).toString();
            if (r11 == null) goto L73;
            if (r11.length() <= 0) goto L9;
            boolean r12 = true;
        L10:
            if (r12 == true) goto L13;
            r11 = null;
        L13:
            if (r11 == null) goto L73;
            if (StringsKt.startsWith(r11, "https://", true) == false) goto L19;
        L20:
            String r13 = r11;
        L77:
            Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L30
            Object r15 = Result.constructor-impl(new URI(r13));     // Catch: Throwable -> L30
        L33:
            if (Result.isFailure-impl(r15) == false) goto L35;
            r15 = null;
        L35:
            URI r16 = (URI) r15;
            if (r16 != null) goto L38;
            String r17 = b(r11);
        L74:
            if (r17 != null) goto L76;
            return null;
        L76:
            return StringsKt.trimEnd(r17, new char[]{'/'}) + "/service/settings/v3/";
        L38:
            String r18 = r16.getScheme();
            if (r18 == null) goto L41;
            String r19 = r18.toLowerCase(Locale.ROOT);
        L42:
            String r20 = r16.getRawAuthority();
            String r21 = r16.getRawPath();
            if (r21 != null) goto L45;
        L48:
            boolean r22 = true;
        L49:
            if (r22 == false) goto L51;
        L53:
            boolean r23 = false;
        L55:
            if (CollectionsKt.contains(SetsKt.setOf(new String[]{"https", "http"}), r19) == false) goto L72;
            if (r20 != null) goto L58;
        L61:
            boolean r24 = true;
        L62:
            if (r24 == true) goto L72;
            if (r16.getRawUserInfo() != null) goto L72;
            if (r23 == true) goto L72;
            if (r16.getRawQuery() != null) goto L72;
            if (r16.getRawFragment() != null) goto L72;
            r17 = r19 + "://" + r20;
            goto L74
        L58:
            if (r20.length() == 0) goto L61;
            r24 = false;
        L72:
            r17 = b(r11);
            goto L74
        L51:
            if (Intrinsics.areEqual(r16.getRawPath(), "/") == true) goto L53;
            r23 = true;
            goto L55
        L45:
            if (r21.length() == 0) goto L48;
            r22 = false;
            goto L49
        L41:
            r19 = null;
        L30:
            th = move-exception;
            Result.Companion r25 = Result.Companion;
            r15 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L33
        L19:
            if (StringsKt.startsWith(r11, "http://", true) == true) goto L20;
            if (StringsKt.startsWith$default(r11, "//", false, 2, null) == false) goto L25;
            r13 = "https:".concat(r11);
            goto L77
        L25:
            if (StringsKt.contains$default(r11, "://", false, 2, null) == false) goto L27;
            r17 = b(r11);
            goto L74
        L27:
            r13 = "https://".concat(r11);
            goto L77
        L9:
            r12 = false;
        L73:
            r17 = b(r10);
            goto L74
        }

        public static String b(String r10) {
            h2.a r0 = f2.b.c;
            if (r0 == null) goto L7;
            boolean r1 = true;
            if (r0.j != true) goto L7;
        L9:
            if (r1 == false) goto L12;
            com.bytedance.ai.utils.g.a.w("SettingsRequestServiceImpl", "invalid settingsHost: " + r10 + " for oversea host");
            return null;
        L12:
            com.bytedance.ai.utils.g.a.w("SettingsRequestServiceImpl", "invalid settingsHost: " + r10 + ", fallback to default host");
            return "https://is.snssdk.com";
        L7:
            r1 = false;
            goto L9
        }
    }

    static {
        d = new a();
    }

    public final void b() {
        int r0 = this.c + 1;
        this.c = r0;
        if (r0 > 3) goto L6;
        p2.c.e(new b(), 3000);
        return;
    }

    public final h37.c request() {
        h37.c r10 = new h37.c();
    L88:
        th = move-exception;
        b();
        com.bytedance.ai.utils.g.a.w("SettingsRequestServiceImpl", "fetch settings failed", th);
        return r10;
    L4:
        if (NetworkUtils.isNetworkAvailable(this.a) == true) goto L7;
        b();     // Catch: Throwable -> L88
        return r10;
    L7:
        StringBuilder r11 = new StringBuilder();     // Catch: Throwable -> L88
        a r12 = d;     // Catch: Throwable -> L88
        h2.a r13 = f2.b.c;     // Catch: Throwable -> L88
        String r14 = null;
        if (r13 == null) goto L10;
        String r15 = r13.u;     // Catch: Throwable -> L88
    L11:
        r12.getClass();     // Catch: Throwable -> L88
        String r16 = a.a(r15);     // Catch: Throwable -> L88
        if (r16 != null) goto L15;
        com.bytedance.ai.utils.g.a.e("SettingsRequestServiceImpl", "settings url is null, skip request");     // Catch: Throwable -> L88
        return r10;
    L15:
        r11.append(r16);     // Catch: Throwable -> L88
        r11.append("?caller_name=flow_ai_sdk");     // Catch: Throwable -> L88
        r11.append("&ai_sdk_version_name=1.15.0-rc.7");     // Catch: Throwable -> L88
        r11.append("&ai_sdk_version_code=1150057");     // Catch: Throwable -> L88
        StringBuilder r17 = new StringBuilder("&is_32bit=");     // Catch: Throwable -> L88
        int r18 = com.bytedance.ai.utils.a.a;     // Catch: Throwable -> L88
        boolean r19 = false;
        if (Build.VERSION.SDK_INT >= 23) goto L18;
    L21:
        int r20 = 1;
    L22:
        r17.append(r20);     // Catch: Throwable -> L88
        r11.append(r17.toString());     // Catch: Throwable -> L88
        h2.a r21 = f2.b.c;     // Catch: Throwable -> L88
        if (r21 != null) goto L25;
    L27:
        boolean r22 = false;
    L28:
        if (r22 == false) goto L39;
        r11.append("&use_ppe=1");     // Catch: Throwable -> L88
        h2.a r23 = f2.b.c;     // Catch: Throwable -> L88
        if (r23 == null) goto L32;
        String r24 = r23.q;     // Catch: Throwable -> L88
    L33:
        if (r24 == null) goto L39;
        StringBuilder r25 = new StringBuilder("&http_env=");     // Catch: Throwable -> L88
        h2.a r26 = f2.b.c;     // Catch: Throwable -> L88
        if (r26 == null) goto L37;
        String r27 = r26.q;     // Catch: Throwable -> L88
    L38:
        r25.append(r27);     // Catch: Throwable -> L88
        r11.append(r25.toString());     // Catch: Throwable -> L88
        goto L39
    L37:
        r27 = null;
        goto L38
    L32:
        r24 = null;
    L39:
        AppletRuntimeManager.INSTANCE.getClass();     // Catch: Throwable -> L88
        g2.b r28 = AppletRuntimeManager.d;     // Catch: Throwable -> L88
        if (r28 == null) goto L47;
        Map<String, Object> r29 = r28.P();     // Catch: Throwable -> L88
        if (r29 == null) goto L47;
        Iterator<Map.Entry<String, Object>> r30 = r29.entrySet().iterator();     // Catch: Throwable -> L88
    L45:
        if (r30.hasNext() == false) goto L47;
        Map.Entry<String, Object> r31 = r30.next();     // Catch: Throwable -> L88
        r11.append('&' + r31.getKey() + '=' + r31.getValue());     // Catch: Throwable -> L88
    L47:
        String r32 = r11.toString();     // Catch: Throwable -> L88
        if (r32.length() <= 0) goto L50;
        boolean r33 = true;
    L51:
        if (r33 == true) goto L53;
    L57:
        String r0 = a(r32);     // Catch: Throwable -> L88
        if (r0 != null) goto L60;
    L61:
        r19 = true;
    L62:
        if (r19 == false) goto L65;
        b();     // Catch: Throwable -> L88
        com.bytedance.ai.utils.g.a.w("SettingsRequestServiceImpl", "settings response is null");     // Catch: Throwable -> L88
        return r10;
    L65:
        JSONObject r1 = new JSONObject(r0);     // Catch: Throwable -> L88
        if (Intrinsics.areEqual("success", r1.optString(com.bytedance.android.ec.core.event.a.KEY_MSG)) == true) goto L69;
        b();     // Catch: Throwable -> L88
        com.bytedance.ai.utils.g.a.w("SettingsRequestServiceImpl", "settings response is not success");     // Catch: Throwable -> L88
        return r10;
    L69:
        JSONObject r34 = r1.optJSONObject("data");     // Catch: Throwable -> L88
        if (r34 == null) goto L72;
        JSONObject r35 = r34.optJSONObject("settings");     // Catch: Throwable -> L88
    L73:
        if (r35 == null) goto L75;
        JSONObject r36 = r35.optJSONObject("sdk_key_flow_ai_sdk");     // Catch: Throwable -> L88
    L76:
        if (r36 == null) goto L78;
        SettingsData r37 = new SettingsData(r36, null);     // Catch: Throwable -> L88
    L79:
        h37.c r38 = new h37.c();     // Catch: Throwable -> L88
        r38.b = r37;     // Catch: Throwable -> L88
        if (r34 == null) goto L82;
        JSONObject r39 = r34.optJSONObject("vid_info");     // Catch: Throwable -> L88
    L83:
        r38.c = r39;     // Catch: Throwable -> L88
        if (r34 == null) goto L86;
        r14 = r34.optString("ctx_infos");     // Catch: Throwable -> L88
    L86:
        r38.d = r14;     // Catch: Throwable -> L88
        r38.a = true;     // Catch: Throwable -> L88
        com.bytedance.ai.utils.g.a.i("SettingsRequestServiceImpl", "settings response: " + r34);     // Catch: Throwable -> L88
        return r38;
    L82:
        r39 = null;
        goto L83
    L78:
        r37 = new SettingsData(r35, null);     // Catch: Throwable -> L88
        goto L79
    L75:
        r36 = null;
        goto L76
    L72:
        r35 = null;
        goto L73
    L60:
        if (r0.length() != 0) goto L62;
    L53:
        if (StringsKt.startsWith$default(r32, "https", false, 2, null) == true) goto L57;
        if (StringsKt.startsWith$default(r32, "http", false, 2, null) == false) goto L57;
        r32 = new Regex("http").replaceFirst(r32, "https");     // Catch: Throwable -> L88
        goto L57
    L50:
        r33 = false;
        goto L51
    L25:
        if (r21.p != true) goto L27;
        r22 = true;
        goto L28
    L18:
        if (Process.is64Bit() == false) goto L21;
        r20 = 0;
        goto L22
    L10:
        r15 = null;
        goto L11
    }

    public c() {
        this.a = o2.a.a();
        this.b = Keva.getRepo(c.class.getName());
    }

    public final Context getContext() {
        return this.a;
    }

    public final String a(String r10) {
        byte[] r11 = new byte[1];
        NetworkClient.ReqContext r12 = new NetworkClient.ReqContext();     // Catch: Throwable -> L11
        r12.addCommonParams = true;     // Catch: Throwable -> L11
        boolean r13 = this.b.getBoolean("first_request", true);     // Catch: Throwable -> L11
        if (r13 == false) goto L6;
        this.b.storeBoolean("first_request", false);     // Catch: Throwable -> L11
    L6:
        if (r13 == false) goto L8;
        int r14 = 1;
    L9:
        return NetworkClient.getDefault().post(r10, r11, MapsKt.mapOf(new Pair[]{TuplesKt.to("Content-Type", "application/json"), TuplesKt.to("X-Tt-Request-Tag", "t=0;n=" + r14)}), r12);
    L8:
        r14 = 0;
    L11:
        th = move-exception;
        th.printStackTrace();
        return null;
    }
}
