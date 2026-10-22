package com.bytedance.sdk.xbridge.cn.auth;

import ai.j0;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthBridgeAccess;
import com.bytedance.sdk.xbridge.cn.auth.bean.AuthConfigType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import li.k;
import li.l;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f7342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f7343b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f7344c = null;
    public static final ConcurrentHashMap d = null;
    public static final ConcurrentHashMap e = null;
    public static com.lynx.tasm.utils.c f;
    public static String g;

    static {
        f7342a = new ConcurrentHashMap();
        f7343b = new ConcurrentHashMap();
        f7344c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        e = new ConcurrentHashMap();
    }

    public static int a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "namespace");
        ConcurrentHashMap r10 = f7342a;
        li.f r11 = (li.f) r10.get(r5);
        if (r11 != null) goto L5;
        li.f r12 = (li.f) r10.get("");
        if (r12 != null) goto L9;
        return -1;
    L9:
        return r12.d;
    L5:
        return r11.d;
    }

    public static ArrayList b(JSONArray r5, Function1 r10) {
        ArrayList r11 = new ArrayList();
        int r12 = r5.length();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.add(r10.invoke(r5.opt(r13)));
        r13 = r13 + 1;
        goto L3
    L5:
        return r11;
    }

    public static li.a c(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "namespace");
        ConcurrentHashMap r11 = f7342a;
        if (r5 == null) goto L11;
        li.f r12 = (li.f) r11.get(r10);
        if (r12 == null) goto L8;
        li.a r13 = (li.a) r12.f19656b.get(r5);
    L9:
        if (r13 != null) goto L11;
        j0.A(f7343b.get(r10));
        goto L11
    L8:
        r13 = null;
    L11:
        li.f r14 = (li.f) r11.get(r10);
        if (r14 != null) goto L14;
        return null;
    L14:
        return (li.a) r14.f19656b.get(r5);
    }

    public static void d(JSONObject r36, String r37, String r38) {
        if (r37 == null) goto L126;
        JSONObject r5 = r36.optJSONObject("data");
        if (r5 == null) goto L10;
        JSONObject r10 = r5.optJSONObject("packages");
        if (r10 == null) goto L10;
        JSONArray r11 = r10.optJSONArray(r37);
    L11:
        if (r11 == null) goto L148;
        g = r38;
        StringBuilder r12 = com.lynx.tasm.base.a.e("parse config from loader ", r38, ", accessKey: ", r37, ", config size: ");
        r12.append(r11.length());
        String r13 = r12.toString();
        String r14 = "msg";
        Intrinsics.checkNotNullParameter(r13, "msg");
        com.lynx.tasm.utils.c r15 = f;
        String r16 = "PermissionConfigV2Parser";
        if (r15 == null) goto L16;
        r15.a("PermissionConfigV2Parser", r13);
    L16:
        int r17 = r11.length();
        int r18 = 0;
    L17:
        if (r18 >= r17) goto L149;
        JSONObject r19 = r11.optJSONObject(r18);
        String r20 = r19.optString(LynxMonitorService.KEY_CHANNEL);
        String r21 = "";
        if (r20 != null) goto L22;
    L27:
        String r22 = null;
    L28:
        if (r22 == null) goto L124;
        int r110 = r19.optInt("package_version", -1);
        String r111 = "parse namespace: " + r22 + ", package version: " + r110;
        Intrinsics.checkNotNullParameter(r111, r14);
        com.lynx.tasm.utils.c r112 = f;
        if (r112 == null) goto L32;
        r112.a(r16, r111);
    L32:
        JSONObject r113 = r19.optJSONObject("lynx_global_settings");
        if (r113 == null) goto L35;
        int r114 = r113.optInt("sign_verify_mode");
    L37:
        if (r113 != null) goto L39;
    L41:
        boolean r115 = false;
    L42:
        if (r113 != null) goto L44;
    L46:
        boolean r23 = false;
    L47:
        li.j r116 = new li.j(r114, r115, r23);
        ConcurrentHashMap r24 = f7342a;
        LinkedHashMap r117 = new LinkedHashMap();
        JSONObject r118 = r19.optJSONObject("content");
        if (r118 == null) goto L74;
        Iterator<String> r119 = r118.keys();
        if (r119 == null) goto L74;
    L52:
        if (r119.hasNext() == false) goto L74;
        r14 = r14;
        String r25 = r119.next();
        r11 = r11;
        JSONArray r26 = r118.optJSONArray(r25);
        if (r26 == null) goto L52;
        String r27 = r16;
        ArrayList r28 = new ArrayList();
        String r29 = r21;
        int r30 = r26.length();
        JSONObject r210 = r118;
        int r120 = 0;
    L56:
        if (r120 >= r30) goto L72;
        int r211 = r30;
        JSONObject r31 = r26.optJSONObject(r120);
        JSONArray r32 = r26;
        int r33 = r18;
        String r212 = r31.optString("pattern");
        AuthBridgeAccess r213 = com.bytedance.apm.util.a.b(r31.optString("group"));
        JSONArray r34 = r31.optJSONArray("included_methods");
        ConcurrentHashMap r35 = r24;
        if (r34 == null) goto L61;
        List r39 = b(r34, PermissionConfigV2Parser$parseContentPerHost$1$authConfig$1.f7293a);
    L60:
        List r214 = r39;
        JSONArray r40 = r31.optJSONArray("excluded_methods");
        if (r40 == null) goto L66;
        List r41 = b(r40, PermissionConfigV2Parser$parseContentPerHost$1$authConfig$2.f7294a);
    L65:
        List r215 = r41;
        if (r31.has("appid") == false) goto L70;
        Long r216 = Long.valueOf(r31.optLong("appid"));
    L71:
        r28.add(new li.b(r212, r213, r214, r215, r216));
        r120 = r120 + 1;
        r30 = r211;
        r26 = r32;
        r18 = r33;
        r24 = r35;
        goto L56
    L70:
        r216 = null;
        goto L71
    L66:
        r41 = CollectionsKt.emptyList();
        goto L65
    L61:
        r39 = CollectionsKt.emptyList();
        goto L60
    L72:
        r117.put(r25, r28);
        r16 = r27;
        r21 = r29;
        r118 = r210;
    L74:
        String r121 = r14;
        JSONArray r122 = r11;
        ConcurrentHashMap r310 = r24;
        String r217 = r16;
        int r311 = r18;
        String r218 = r21;
        LinkedHashMap r42 = new LinkedHashMap();
        JSONObject r43 = r19.optJSONObject("content_v2");
        if (r43 == null) goto L123;
        Iterator<String> r44 = r43.keys();
        if (r44 == null) goto L123;
    L79:
        if (r44.hasNext() == false) goto L123;
        String r45 = r44.next();
        JSONObject r46 = r43.optJSONObject(r45);
        if (r46 == null) goto L79;
        JSONObject r47 = r46.optJSONObject("method_call_limits");
        LinkedHashMap r48 = new LinkedHashMap();
        Iterator<String> r123 = r47.keys();
    L84:
        if (r123.hasNext() == false) goto L92;
        JSONObject r312 = r43;
        String r49 = r123.next();
        Iterator<String> r124 = r44;
        Iterator<String> r219 = r123;
        String r313 = r22;
        Integer r50 = Integer.valueOf(r47.optJSONObject(r49).optInt("runtime_call_count"));
        int r314 = r110;
        String r125 = r47.optJSONObject(r49).optString("runtime_call_frequency");
        JSONObject r126 = r47.optJSONObject(r49);
        JSONObject r220 = r47;
        if (r126 == null) goto L90;
        JSONArray r51 = r126.optJSONArray("url");
        if (r51 == null) goto L90;
        ArrayList r52 = b(r51, PermissionConfigV2Parser$parseMethodCallLimits$1$1.f7295a);
    L91:
        r48.put(r49, new k(r50, r125, r52));
        r44 = r124;
        r123 = r219;
        r47 = r220;
        r43 = r312;
        r22 = r313;
        r110 = r314;
    L90:
        r52 = null;
        goto L91
    L92:
        JSONObject r315 = r43;
        Iterator<String> r127 = r44;
        String r316 = r22;
        int r317 = r110;
        String r53 = r46.optString("type");
        Intrinsics.checkNotNullParameter(r53, "value");
        if (Intrinsics.areEqual(r53, "h5") == false) goto L97;
        AuthConfigType r54 = AuthConfigType.f7305b;
    L95:
        AuthConfigType r221 = r54;
        JSONArray r55 = r46.optJSONArray("safe_urls");
        if (r55 == null) goto L104;
        List r56 = b(r55, PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$1.f7290a);
    L103:
        List r222 = r56;
        JSONObject r57 = r46.optJSONObject("public_key");
        if (r57 == null) goto L108;
        String r58 = r57.optString("RSA");
    L109:
        if (r58 != null) goto L111;
        r58 = r218;
    L111:
        l r59 = new l(r58);
        AuthBridgeAccess r223 = com.bytedance.apm.util.a.b(r46.optString("group"));
        JSONArray r60 = r46.optJSONArray("included_methods");
        if (r60 == null) goto L115;
        List r61 = b(r60, PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$2.f7291a);
    L114:
        List r224 = r61;
        JSONArray r62 = r46.optJSONArray("excluded_methods");
        if (r62 == null) goto L120;
        List r63 = b(r62, PermissionConfigV2Parser$parseContentPerAppID$lynxAuthConfigBean$3.f7292a);
    L121:
        r42.put(r45, new li.a(r221, r222, r59, r223, r224, r63, r48, r46.optInt("v", 1)));
        r44 = r127;
        r43 = r315;
        r22 = r316;
        r110 = r317;
        goto L79
    L120:
        r63 = CollectionsKt.emptyList();
        goto L121
    L115:
        r61 = CollectionsKt.emptyList();
        goto L114
    L108:
        r58 = null;
        goto L109
    L104:
        r56 = CollectionsKt.emptyList();
        goto L103
    L97:
        if (Intrinsics.areEqual(r53, "lynx") == false) goto L99;
        r54 = AuthConfigType.f7306c;
        goto L95
    L99:
        r54 = AuthConfigType.f7304a;
    L123:
        String r318 = r22;
        li.f r128 = new li.f(r117, r42, r116);
        r128.d = r110;
        r310.put(r318, r128);
        ConcurrentHashMap r64 = f7344c;
        Boolean r65 = Boolean.TRUE;
        r64.put(r318, r65);
        d.put(r318, r65);
        e.put(r318, r65);
    L125:
        r18 = r311 + 1;
        r17 = r17;
        r11 = r122;
        r14 = r121;
        r16 = r217;
        goto L17
    L44:
        if (r113.optInt("enable_jsb_call_limit") != 1) goto L46;
        r23 = true;
        goto L47
    L39:
        if (r113.optInt("enable_jsb_auth") != 1) goto L41;
        r115 = true;
        goto L42
    L35:
        r114 = 0;
        goto L37
    L124:
        r121 = r14;
        r122 = r11;
        r217 = r16;
        r311 = r18;
        goto L125
    L22:
        if (Intrinsics.areEqual(r20, "_jsb_auth") == false) goto L25;
        r22 = "";
        goto L28
    L25:
        if (StringsKt.P(r20, "_jsb_auth.") == false) goto L27;
        r22 = StringsKt.F(r20, "_jsb_auth.", "");
        goto L28
    L149:
        return;
    L148:
        return;
    L10:
        r11 = null;
        goto L11
    }

    public static List e(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "host");
        Intrinsics.checkNotNullParameter(r10, "namespace");
        ConcurrentHashMap r11 = f7342a;
        li.f r12 = (li.f) r11.get(r10);
        if (r12 == null) goto L5;
        List r13 = (List) r12.f19655a.get(r5);
    L6:
        if (r13 == null) goto L8;
    L12:
        li.f r14 = (li.f) r11.get(r10);
        if (r14 == null) goto L19;
        List r15 = (List) r14.f19655a.get(r5);
        if (r15 == null) goto L19;
        return r15;
    L19:
        return CollectionsKt.emptyList();
    L8:
        if (f7343b.get(r10) == null) goto L12;
        throw new ClassCastException();
    L5:
        r13 = null;
        goto L6
    }

    public static Map f() {
        ConcurrentHashMap r5 = d;
        if (r5.get("") == null) goto L7;
        Object r10 = r5.get("");
        Intrinsics.checkNotNull(r10);
        if (((Boolean) r10).booleanValue() == true) goto L7;
        j0.A(f7343b.get(""));
    L7:
        li.f r11 = (li.f) f7342a.get("");
        if (r11 == null) goto L12;
        return r11.f19656b;
    L12:
        return MapsKt.emptyMap();
    }
}
