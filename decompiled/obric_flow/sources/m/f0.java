package m;

import android.text.TextUtils;
import android.util.Log;
import androidx.room.solver.CodeGenScope;
import com.bytedance.android.monitorV2.hybridSetting.Switches;
import com.bytedance.android.monitorV2.hybridSetting.entity.BidInfo$BidConfig;
import com.bytedance.android.monitorV2.hybridSetting.entity.CheckFilter;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.ss.ttvideoengine.TTVideoEngine;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.koin.core.error.KoinAppAlreadyStartedException;
import qo.a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile e f19875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f19876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f19877c;
    public static ArrayList d;
    public static String e;

    public static a5.d b(String r10) {
        JSONObject r11 = a.c(r10);
        a5.d r5 = new a5.d();
        JSONObject r12 = r11.optJSONObject("data");     // Catch: Throwable -> L22
        long r13 = 0;
        if (r12 != null) goto L6;
        long r14 = 0;
    L7:
        r5.f108c = r14;     // Catch: Throwable -> L22
        int r15 = 0;
        if (r12 != null) goto L10;
        int r16 = 0;
    L11:
        r5.d = r16;     // Catch: Throwable -> L22
        if (r12 != null) goto L14;
        long r17 = 0;
    L15:
        r5.e = r17;     // Catch: Throwable -> L22
        if (r12 == null) goto L19;
        r13 = r12.optLong("enable_switch", 0);     // Catch: Throwable -> L22
    L19:
        f9.a r18 = new f9.a(1);     // Catch: Throwable -> L22
        Switches.a(r13);     // Catch: Throwable -> L22
        r5.f107b = r18;     // Catch: Throwable -> L22
        r5.f = l(a.d(r12, "all_event_sample"));     // Catch: Throwable -> L22
        if (r12 != null) goto L24;
        JSONArray r19 = new JSONArray();     // Catch: Throwable -> L22
    L25:
        HashSet r20 = new HashSet();     // Catch: Throwable -> L22
        if (r19 != null) goto L41;
    L35:
        r5.g = r20;     // Catch: Throwable -> L22
        r5.f109h = d(a.d(r12, "check_filter"));     // Catch: Throwable -> L22
        return r5;
    L41:
    L33:
        th = move-exception;
        mn.h.g("default_handle", th);     // Catch: Throwable -> L22
        goto L35
    L28:
        if (r19.length() <= 0) goto L35;
    L30:
        if (r15 >= r19.length()) goto L35;
        r20.add(r19.optString(r15));     // Catch: Throwable -> L33
        r15 = r15 + 1;
        goto L30
    L24:
        r19 = r12.optJSONArray("host_list");     // Catch: Throwable -> L22
        goto L25
    L14:
        r17 = r12.optLong("setting_id", 0);     // Catch: Throwable -> L22
        goto L15
    L10:
        r16 = r12.optInt("duration", 0);     // Catch: Throwable -> L22
        goto L11
    L6:
        r14 = r12.optLong("update_time", 0);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        mn.h.g("startup_handle", th);
        return r5;
    }

    public static ai.p c(long r10, JSONObject r12) {
        ai.p r5 = new ai.p(1);
        if (r12 != null) goto L5;
        return r5;
    L5:
        Iterator<String> r11 = r12.keys();
    L6:
        boolean r13 = r11.hasNext();
        ArrayList r14 = (ArrayList) r5.f288c;
        if (r13 == false) goto L26;
        String r15 = r11.next();     // Catch: Throwable -> L24
        JSONObject r16 = r12.optJSONObject(r15);     // Catch: Throwable -> L24
        long r17 = 0;
        if (r16 == null) goto L12;
        r17 = r16.optLong("hit_sample", 0);     // Catch: Throwable -> L24
    L12:
        BidInfo$BidConfig r18 = new BidInfo$BidConfig(r15);     // Catch: Throwable -> L24
        r18.hitSample = r17;     // Catch: Throwable -> L24
        r18.settingId = r10;     // Catch: Throwable -> L24
        r18.eventNameSample = l(a.d(r16, "event_name_sample"));     // Catch: Throwable -> L24
        HashMap r19 = (HashMap) r5.f287b;     // Catch: Throwable -> L24
        g(r18, r17);     // Catch: Throwable -> L24
        r19.put(r15, r18);     // Catch: Throwable -> L24
        JSONArray r20 = r16.optJSONArray("regex_list");     // Catch: Throwable -> L24
        if (r20 == null) goto L6;
        if (r20.length() <= 0) goto L6;
        int r21 = 0;
    L18:
        if (r21 >= r20.length()) goto L6;
        r14.add(new a5.a(r15, new Regex(r20.optString(r21))));     // Catch: Throwable -> L21
    L23:
        r21 = r21 + 1;
    L21:
        th = move-exception;
        mn.h.g("startup_handle", th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        mn.h.g("startup_handle", th);
        goto L6
    L26:
        Collections.sort(r14);
        return r5;
    }

    public static CheckFilter d(JSONObject r10) {
        CheckFilter r5 = new CheckFilter();
        JSONObject r11 = a.d(r10, "filter");     // Catch: Throwable -> L9
        HashMap r12 = new HashMap();     // Catch: Throwable -> L9
        Iterator r13 = com.bytedance.android.monitorV2.constant.b.f3524a.iterator();     // Catch: Throwable -> L9
    L5:
        if (r13.hasNext() == false) goto L14;
        String r14 = (String) r13.next();     // Catch: Throwable -> L9
        if (r11 != null) goto L11;
        JSONArray r15 = new JSONArray();     // Catch: Throwable -> L9
    L12:
        r12.put(r14, a.b(r15));     // Catch: Throwable -> L9
        goto L5
    L11:
        r15 = r11.optJSONArray(r14);     // Catch: Throwable -> L9
        goto L12
    L14:
        if (r10 != null) goto L16;
        JSONArray r16 = new JSONArray();     // Catch: Throwable -> L9
    L17:
        return new CheckFilter(r12, a.b(r16), a.p("id", r10));
    L16:
        r16 = r10.optJSONArray("category");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        mn.h.g("default_handle", th);
        return r5;
    }

    public static Boolean e(String r5) {
        String r10 = StringsKt.trim(r5).toString().toLowerCase(Locale.ROOT);
        int r11 = r10.hashCode();
        if (r11 == 48) goto L23;
        if (r11 == 49) goto L18;
        if (r11 == 3569038) goto L15;
        if (r11 == 97196323) goto L12;
        return null;
    L12:
        if (r10.equals("false") == true) goto L27;
        return null;
    L27:
        return Boolean.FALSE;
    L15:
        if (r10.equals("true") == true) goto L21;
        return null;
    L21:
        return Boolean.TRUE;
    L18:
        if (r10.equals(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == true) goto L21;
        return null;
    L23:
        if (r10.equals("0") == true) goto L27;
        return null;
    }

    public static Pattern f(int r5, String r10) {
        e0 r11 = new e0();
        r11.f19873a = r10;
        r11.f19874b = r5;
        d0 r12 = new d0(r10, r5);
        if (f19875a != null) goto L16;
        monitor-enter(f0.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f19875a != null) goto L11;
        f19875a = new e();     // Catch: Throwable -> L9
    L11:
        monitor-exit(f0.class);     // Catch: Throwable -> L9
    L16:
        return (Pattern) f19875a.a(r11, r12);
    }

    public static void g(BidInfo$BidConfig r10, long r11) {
        int r5 = 0;
    L4:
        if (r5 >= 46) goto L59;
        if (r5 == 0) goto L9;
        r11 = r11 >> 1;
    L9:
        if ((r11 % 2) != 1) goto L58;
        switch(r5) {
            case 0: goto L57;
            case 1: goto L56;
            case 2: goto L55;
            case 3: goto L54;
            case 4: goto L53;
            case 5: goto L52;
            case 6: goto L51;
            case 7: goto L50;
            case 8: goto L49;
            case 9: goto L48;
            case 10: goto L47;
            case 11: goto L46;
            case 12: goto L45;
            case 13: goto L44;
            case 14: goto L43;
            case 15: goto L42;
            case 16: goto L41;
            case 17: goto L40;
            case 18: goto L39;
            case 19: goto L38;
            case 20: goto L37;
            case 21: goto L36;
            case 22: goto L35;
            case 23: goto L34;
            case 24: goto L33;
            case 25: goto L32;
            case 26: goto L31;
            case 27: goto L30;
            case 28: goto L29;
            case 29: goto L28;
            case 30: goto L27;
            case 31: goto L26;
            case 32: goto L25;
            case 33: goto L24;
            case 34: goto L23;
            case 35: goto L22;
            case 36: goto L21;
            case 37: goto L20;
            case 38: goto L19;
            case 39: goto L18;
            case 40: goto L17;
            case 41: goto L16;
            case 42: goto L15;
            case 43: goto L14;
            case 44: goto L13;
            case 45: goto L12;
            default: goto L58;
        };
    L12:
        r10.res_loader_error_template_lynx = true;
        goto L58
    L13:
        r10.res_loader_error_lynx = true;
        goto L58
    L14:
        r10.res_loader_perf_template_lynx = true;
        goto L58
    L15:
        r10.res_loader_perf_lynx = true;
        goto L58
    L16:
        r10.res_loader_error_template_web = true;
        goto L58
    L17:
        r10.res_loader_error_web = true;
        goto L58
    L18:
        r10.res_loader_perf_template_web = true;
        goto L58
    L19:
        r10.res_loader_perf_web = true;
        goto L58
    L20:
        r10.tea_switch = true;
        goto L58
    L21:
        r10.static_error_lynx = true;
        goto L58
    L22:
        r10.js_exception_lynx = true;
        goto L58
    L23:
        r10.container_error = true;
        goto L58
    L24:
        r10.native_error_reactnative = true;
        goto L58
    L25:
        r10.jsb_error_reactnative = true;
        goto L58
    L26:
        r10.fetch_error_reactnative = true;
        goto L58
    L27:
        r10.blank_reactnative = true;
        goto L58
    L28:
        r10.performance_reactnative = true;
        goto L58
    L29:
        r10.navigation_start_lynx = true;
        goto L58
    L30:
        r10.native_error_lynx = true;
        goto L58
    L31:
        r10.jsb_perf_lynx = true;
        goto L58
    L32:
        r10.jsb_error_lynx = true;
        goto L58
    L33:
        r10.fetch_error_lynx = true;
        goto L58
    L34:
        r10.blank_lynx = true;
        goto L58
    L35:
        r10.performance_lynx = true;
        goto L58
    L36:
        r10.static_sri_web = true;
        goto L58
    L37:
        r10.navigation_start_web = true;
        goto L58
    L38:
        r10.native_error_web = true;
        goto L58
    L39:
        r10.falcon_perf_web = true;
        goto L58
    L40:
        r10.jsb_perf_web = true;
        goto L58
    L41:
        r10.jsb_error_web = true;
        goto L58
    L42:
        r10.fetch_error_web = true;
        goto L58
    L43:
        r10.blank_web = true;
        goto L58
    L44:
        r10.js_exception_web = true;
        goto L58
    L45:
        r10.static_error_web = true;
        goto L58
    L46:
        r10.static_perf_web = true;
        goto L58
    L47:
        r10.ajax_web = true;
        goto L58
    L48:
        r10.perf_web = true;
        goto L58
    L49:
        r10.custom_p8 = true;
        goto L58
    L50:
        r10.custom_p7 = true;
        goto L58
    L51:
        r10.custom_p6 = true;
        goto L58
    L52:
        r10.custom_p5 = true;
        goto L58
    L53:
        r10.custom_p4 = true;
        goto L58
    L54:
        r10.custom_p3 = true;
        goto L58
    L55:
        r10.custom_p2 = true;
        goto L58
    L56:
        r10.custom_p1 = true;
        goto L58
    L57:
        r10.custom_p0 = true;
    L58:
        r5 = r5 + 1;
        goto L4
    }

    public static void i(Exception r5, StringBuilder r10, String r11) {
        r10.append(r5.getMessage());
        Log.i(r11, r10.toString());
    }

    public static void j(String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        com.bytedance.ies.web.jsbridge2.l r10 = new com.bytedance.ies.web.jsbridge2.l("bdx_anniex_card_props_error", 1);
        r10.f6291c = "bullet_custom_bid";
        r10.b(0);
        JSONObject r11 = new JSONObject();
        r11.put("scene", "anniex_card");
        r11.put("error_msg", r5);
        r10.f6292h = r11;
        x4.c r12 = r10.a();
        com.bytedance.android.monitorV2.h.e().getClass();
        com.bytedance.android.monitorV2.h.d(r12);
    }

    public static a5.d k(String r10) {
        long r5 = System.currentTimeMillis();
        a5.d r11 = new a5.d();
        JSONObject r12 = a.c(r10).optJSONObject("data");     // Catch: Throwable -> L9
        JSONObject r13 = a.d(r12, "bid_info");     // Catch: Throwable -> L9
        long r14 = 0;
        if (r12 == null) goto L7;
        r14 = r12.optLong("setting_id", 0);     // Catch: Throwable -> L9
    L7:
        r11.f106a = c(r14, r13);     // Catch: Throwable -> L9
        d5.b.c("HybridMonitor", "monitor setting parse bid cost: " + (System.currentTimeMillis() - r5));     // Catch: Throwable -> L9
        HashMap r15 = new HashMap();     // Catch: Throwable -> L9
        r15.put("bid_count", Long.valueOf((long) ((HashMap) r11.f106a.f287b).size()));     // Catch: Throwable -> L9
        r15.put("regex_count", Long.valueOf(((ArrayList) r11.f106a.f288c).size()));     // Catch: Throwable -> L9
        r15.put("setting_parse_time", Long.valueOf(System.currentTimeMillis() - r5));     // Catch: Throwable -> L9
        HashMap r16 = new HashMap();     // Catch: Throwable -> L9
        r16.put("setting_parse_type", "json");     // Catch: Throwable -> L9
        com.bytedance.android.monitorV2.i.b(r16, r15, "setting_parse_perf");     // Catch: Throwable -> L9
        return r11;
    L9:
        th = move-exception;
        mn.h.g("startup_handle", th);
        return r11;
    }

    public static HashMap l(JSONObject r5) {
        HashMap r10 = new HashMap();
        if (r5 != null) goto L13;
    L12:
        return r10;
    L13:
        Iterator<String> r11 = r5.keys();     // Catch: Throwable -> L10
    L7:
        if (r11.hasNext() == false) goto L12;
        String r12 = r11.next();     // Catch: Throwable -> L10
        r10.put(r12, Integer.valueOf(r5.optInt(r12, 0)));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        mn.h.g("startup_handle", th);
        goto L12
    }

    public static File[] m(String r10, String r11, String r12, long r13, long r14) {
        f19876b = r13;
        f19877c = r14;
        e = null;
        d = null;
        if (r13 <= r14) goto L6;
        e = "time interval is invalid";
        return new File[0];
    L6:
        File r5 = new File(r10);
        if (r5.exists() == true) goto L9;
    L30:
        e = "log dir not exists";
        return new File[0];
    L9:
        if (r5.isDirectory() == false) goto L30;
        if (TextUtils.isEmpty(r11) == true) goto L14;
        r11 = r11.replace(':', '-');
    L14:
        StringBuilder r15 = new StringBuilder("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__");
        String r16 = "\\S+";
        if (TextUtils.isEmpty(r11) == false) goto L17;
        String r17 = "\\S+";
    L18:
        r15.append(r17);
        r15.append(CodeGenScope.CLASS_PROPERTY_PREFIX);
        if (TextUtils.isEmpty(r12) == true) goto L22;
        r16 = Pattern.quote(r12);
    L22:
        r15.append(r16);
        r15.append("\\.alog\\.hot$");
        Pattern r18 = Pattern.compile(r15.toString());
        ArrayList r19 = new ArrayList();
        File[] r110 = r5.listFiles(new com.obric.android.alog.c(r19, r18, r14, r13));
        if (r110 != null) goto L25;
    L26:
        e = "log file not found";
        d = r19;
    L27:
        if (r110 == null) goto L29;
        return r110;
    L29:
        return new File[0];
    L25:
        if (r110.length != 0) goto L27;
    L17:
        r17 = Pattern.quote(r11);
        goto L18
    }

    public static final void n(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "appDeclaration");
        su.a r10 = su.a.f22012a;
        Intrinsics.checkNotNullParameter(r5, "appDeclaration");
        monitor-enter(r10);
        org.koin.core.b r11 = new org.koin.core.b();     // Catch: Throwable -> L9
        if (su.a.f22013b != null) goto L12;
        su.a.f22013b = r11.f21002a;     // Catch: Throwable -> L9
        r5.invoke(r11);     // Catch: Throwable -> L9
        r11.f21002a.a();     // Catch: Throwable -> L9
        monitor-exit(r10);
        return;
    L12:
        throw new KoinAppAlreadyStartedException("A Koin Application has already been started");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public abstract int a();

    public abstract void h(TTVideoEngine r5, pf.b r10);
}
