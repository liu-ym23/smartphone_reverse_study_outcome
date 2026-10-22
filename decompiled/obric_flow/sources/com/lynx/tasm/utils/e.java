package com.lynx.tasm.utils;

import ai.j0;
import android.util.Log;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.n;
import com.bytedance.crash.upload.s;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import l9.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f11165a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f11166b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f11167c = -1;
    public static int d = -1;
    public static volatile Object e;

    public static e2.a a(double r40, double r42) {
        if (r42 >= 72.004d) goto L5;
    L13:
        e2.a r10 = new e2.a(r40, r42);
    L14:
        double r5 = 2;
        return new e2.a((r40 * r5) - r10.f16741a, (r42 * r5) - r10.f16742b);
    L5:
        if (r42 > 137.8347d) goto L13;
        if (r40 < 0.8293d) goto L13;
        if (r40 > 55.8271d) goto L13;
        double r11 = r42 - 105.0d;
        double r12 = r40 - 35.0d;
        double r18 = r11 * 2.0d;
        double r13 = j0.B(r12, 0.2d, r12, (r12 * 3.0d) + (r18 - 100.0d));
        double r14 = r11 * 0.1d;
        double r15 = r14 * r12;
        double r24 = (Math.sqrt(Math.abs(r11)) * 0.2d) + (r13 + r15);
        double r16 = (6.0d * r11) * 3.141592653589793d;
        double r19 = r18 * 3.141592653589793d;
        double r30 = ((((Math.sin(r19) * 20.0d) + (Math.sin(r16) * 20.0d)) * 2.0d) / 3.0d) + r24;
        double r25 = r12 * 3.141592653589793d;
        double r26 = ((((Math.sin(r25 / 30.0d) * ((double) 320)) + (Math.sin((r12 / 12.0d) * 3.141592653589793d) * 160.0d)) * 2.0d) / 3.0d) + (((((Math.sin((r12 / 3.0d) * 3.141592653589793d) * 40.0d) + (Math.sin(r25) * 20.0d)) * 2.0d) / 3.0d) + r30);
        double r17 = r14 * r11;
        double r20 = ((((Math.sin((r11 / 30.0d) * 3.141592653589793d) * 300.0d) + (Math.sin((r11 / 12.0d) * 3.141592653589793d) * 150.0d)) * 2.0d) / 3.0d) + (((((Math.sin((r11 / 3.0d) * 3.141592653589793d) * 40.0d) + (Math.sin(r11 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + (((((Math.sin(r19) * 20.0d) + (Math.sin(r16) * 20.0d)) * 2.0d) / 3.0d) + ((Math.sqrt(Math.abs(r11)) * 0.1d) + ((r17 + ((r12 * 2.0d) + (r11 + 300.0d))) + r15))));
        double r21 = (r40 / 180.0d) * 3.141592653589793d;
        double r110 = Math.sin(r21);
        double r111 = ((double) 1) - ((0.006693421622965943d * r110) * r110);
        double r112 = Math.sqrt(r111);
        r10 = new e2.a(r40 + ((r26 * 180.0d) / ((6335552.717000426d / (r111 * r112)) * 3.141592653589793d)), ((r20 * 180.0d) / ((Math.cos(r21) * (6378245.0d / r112)) * 3.141592653589793d)) + r42);
        goto L14
    }

    public static StringBuilder b(String r5, String r10, String r11) {
        return j0.x(r5, r10, r11);
    }

    public static ArrayList c(JSONArray r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        ArrayList r10 = new ArrayList();
        int r11 = r5.length();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L27;
        Object r13 = r5.opt(r12);
        if ((r13 instanceof Long) == false) goto L8;
        r10.add(Long.valueOf(r5.optLong(r12)));
    L26:
        r12 = r12 + 1;
        goto L3
    L8:
        if ((r13 instanceof Double) == false) goto L11;
        r10.add(Double.valueOf(r5.optDouble(r12)));
        goto L26
    L11:
        if ((r13 instanceof Integer) == false) goto L14;
        r10.add(Integer.valueOf(r5.getInt(r12)));
        goto L26
    L14:
        if ((r13 instanceof String) == false) goto L17;
        r10.add(r5.optString(r12));
        goto L26
    L17:
        if ((r13 instanceof JSONObject) == false) goto L20;
        r10.add(d(r5.optJSONObject(r12)));
        goto L26
    L20:
        if ((r13 instanceof JSONArray) == false) goto L23;
        r10.add(c(r5.optJSONArray(r12)));
        goto L26
    L23:
        if ((r13 instanceof Boolean) == false) goto L25;
        r10.add(Boolean.valueOf(r5.optBoolean(r12)));
        goto L26
    L25:
        r10.add(null);
        goto L26
    L27:
        return r10;
    }

    public static LinkedHashMap d(JSONObject r5) {
        Intrinsics.checkNotNullParameter(r5, "json");
        LinkedHashMap r10 = new LinkedHashMap();
        Iterator<String> r11 = r5.keys();
    L4:
        if (r11.hasNext() == false) goto L27;
        String r12 = r11.next();
        Object r13 = r5.opt(r12);
        if ((r13 instanceof Long) == true) goto L7;
        if ((r13 instanceof Double) == true) goto L10;
        if ((r13 instanceof Integer) == true) goto L13;
        if ((r13 instanceof String) == true) goto L16;
        if ((r13 instanceof JSONObject) == true) goto L19;
        if ((r13 instanceof JSONArray) == true) goto L22;
        if ((r13 instanceof Boolean) == true) goto L25;
        r10.put(r12, null);
        goto L4
    L25:
        r10.put(r12, Boolean.valueOf(r5.optBoolean(r12)));
        goto L4
    L22:
        r10.put(r12, c(r5.optJSONArray(r12)));
        goto L4
    L19:
        r10.put(r12, d(r5.optJSONObject(r12)));
        goto L4
    L16:
        r10.put(r12, r5.optString(r12));
        goto L4
    L13:
        r10.put(r12, Integer.valueOf(r5.optInt(r12)));
        goto L4
    L10:
        r10.put(r12, Double.valueOf(r5.optDouble(r12)));
        goto L4
    L7:
        r10.put(r12, Long.valueOf(r5.optLong(r12)));
        goto L4
    L27:
        return r10;
    }

    public static void e(String r5) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.e("npth", "NativeHeapTracker " + r5);
        return;
    }

    public static void f(Map r10, Map r11, String r12) {
        long r5 = System.currentTimeMillis();
        if (s.m(null, CrashType.DART) == true) goto L11;
        o.e().b(new xk.a(r5, r12, r10, r11));     // Catch: Throwable -> L8
        return;
    L11:
        return;
    }

    public static void g(String r5) {
        if (n.f4062j.isDebugMode() == false) goto L6;
        Log.i("npth", "NativeHeapTracker " + r5);
        return;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, rj.a] */
    public static void h() {
        if (e != null) goto L6;
        com.bytedance.frameworks.baselib.network.http.ok3.impl.a.f4682a = 9;
        return;
    L6:
        e.b();
    }

    public static boolean i(double r5) {
        if (Math.getExponent(r5) > 1023) goto L5;
        return true;
    L5:
        return false;
    }

    public static URI j(String r5) {
        if (com.bytedance.common.utility.b.b(r5) == false) goto L22;
        return null;
    L22:
        return new URI(r5);
    L8:
        return URI.create(r5.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L11:
        if (com.bytedance.common.utility.b.b(r5) == false) goto L24;
        return null;
    L24:
        int r10 = r5.indexOf("?");     // Catch: Exception -> L16
        if (r10 <= 0) goto L18;
        r5 = r5.substring(0, r10);     // Catch: Exception -> L16
    L18:
        return URI.create(r5);
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
