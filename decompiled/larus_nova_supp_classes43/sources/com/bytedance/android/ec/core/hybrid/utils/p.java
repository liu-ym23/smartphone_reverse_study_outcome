package com.bytedance.android.ec.core.hybrid.utils;

import android.net.Uri;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p {
    public static JSONObject a;
    public static JSONObject b;
    public static Uri c;
    public static final Map<String, l> d = null;
    public static final Map<String, Object> e = null;
    public static final Map<String, l> f = null;
    public static final Map<String, Object> g = null;
    public static final Map<String, l> h = null;
    public static final Map<String, Object> i = null;
    public static final Map<String, q> j = null;
    public static final Map<String, ECBaseBridgeMethod.a> k = null;

    static {
        a = new JSONObject();
        b = new JSONObject();
        c = Uri.EMPTY;
        d = new LinkedHashMap();
        e = new LinkedHashMap();
        f = new LinkedHashMap();
        g = new LinkedHashMap();
        h = new LinkedHashMap();
        i = new LinkedHashMap();
        j = new LinkedHashMap();
        k = new LinkedHashMap();
    }

    public static void a() {
        ((LinkedHashMap) e).clear();
        ((LinkedHashMap) d).clear();
        ((LinkedHashMap) g).clear();
        ((LinkedHashMap) f).clear();
        ((LinkedHashMap) i).clear();
        ((LinkedHashMap) h).clear();
    }

    public static Object c(l r10) {
        String r0 = r10.b;
        boolean r11 = true;
        int r12 = 0;
        switch(r0.hashCode()) {
            case -1613114217: goto L24;
            case -907987551: goto L19;
            case 94844771: goto L16;
            case 794212742: goto L6;
            default: goto L33;
        };
    L33:
        String r1 = r10.d;
    L34:
        String r13 = r10.getType();
        int r14 = r13.hashCode();
        if (r14 == (-1034364087)) goto L43;
        if (r14 != 64711720) goto L47;
        if (r13.equals("boolean") == false) goto L47;
        return Boolean.valueOf(Intrinsics.areEqual(r1, "true"));
    L47:
        if (Intrinsics.areEqual(r1, "null") == true) goto L49;
        return r1;
    L49:
        return JSONObject.NULL;
    L43:
        if (r13.equals("number") == false) goto L47;
        r12 = CastIntegerProtector.parseInt(r1);     // Catch: Throwable -> L50
    L54:
        return Integer.valueOf(r12);
    L6:
        if (r0.equals(com.bytedance.android.ec.core.event.a.KEY_CJ_INFO) == false) goto L33;
        r1 = a.optString(r10.c);
        if (r1 != null) goto L10;
    L13:
        if (r11 == false) goto L34;
        r1 = r10.d;
        goto L34
    L10:
        if (r1.length() == 0) goto L13;
        r11 = false;
        goto L13
    L16:
        if (r0.equals("const") == false) goto L33;
        r1 = r10.d;
        goto L34
    L19:
        if (r0.equals(com.bytedance.android.ec.core.event.a.KEY_SCHEMA) == false) goto L33;
        r1 = UriProtector.getQueryParameter(c, r10.c);
        if (r1 != null) goto L34;
        r1 = r10.d;
        goto L34
    L24:
        if (r0.equals(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO) == false) goto L33;
        r1 = b.optString(r10.c);
        if (r1 != null) goto L28;
    L31:
        if (r11 == false) goto L34;
        r1 = r10.d;
        goto L34
    L28:
        if (r1.length() == 0) goto L31;
        r11 = false;
        goto L31
    }

    public static void b(int r10, ECBaseBridgeMethod.a r11) {
        JSONObject r0 = new JSONObject();
        r0.put("code", 0);
        r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r10);
        Unit r12 = Unit.INSTANCE;
        r11.a(r0);
    }

    public static void d(String r10, JSONObject r11) {
        JSONObject r12 = r11.optJSONObject(r10);
        if (r12 == null) goto L25;
        Iterator<String> r0 = r12.keys();
    L6:
        if (r0.hasNext() == false) goto L45;
        String r1 = r0.next();
        JSONObject r13 = r12.optJSONObject(r1);
        if (r13 == null) goto L6;
        int r14 = r10.hashCode();
        if (r14 != (-42570899)) goto L12;
        if (r10.equals("ec_order_product_request") == false) goto L6;
        h.put(r1, new l(r13.optString("type", ""), r13.optString(com.bytedance.android.ec.core.event.a.KEY_FROM, ""), r13.optString("key", ""), r13.optString("default", "")));
        goto L6
    L12:
        if (r14 != 911923416) goto L14;
        if (r10.equals("ec_order_shop_request") == false) goto L6;
        f.put(r1, new l(r13.optString("type", ""), r13.optString(com.bytedance.android.ec.core.event.a.KEY_FROM, ""), r13.optString("key", ""), r13.optString("default", "")));
        goto L6
    L14:
        if (r14 != 1124837331) goto L6;
        if (r10.equals("ec_order_outside") == false) goto L6;
        d.put(r1, new l(r13.optString("type", ""), r13.optString(com.bytedance.android.ec.core.event.a.KEY_FROM, ""), r13.optString("key", ""), r13.optString("default", "")));
        goto L6
    L45:
        return;
    }

    public static void e(q r10, String r11) {
        ECBaseBridgeMethod.a r0 = k.remove(r11);
        if (r0 != null) goto L5;
        j.put(r11, r10);
        return;
    L5:
        int r12 = r10.b;
        if (r12 != 1) goto L8;
        f(r10, r0);
        return;
    L8:
        b(r12, r0);
    }

    public static void f(q r10, ECBaseBridgeMethod.a r11) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L4
        r0.put("code", 1);     // Catch: Exception -> L4
        r0.put("data", new JSONObject(r10.a));     // Catch: Exception -> L4
        r0.put(com.bytedance.android.ec.core.event.a.KEY_STATUS, r10.b);     // Catch: Exception -> L4
        Unit r12 = Unit.INSTANCE;     // Catch: Exception -> L4
        r11.a(r0);     // Catch: Exception -> L4
        return;
    L4:
        b(3, r11);
    }
}
