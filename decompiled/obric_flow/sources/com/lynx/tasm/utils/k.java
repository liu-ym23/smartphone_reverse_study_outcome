package com.lynx.tasm.utils;

import ai.j0;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.ies.xbridge.model.idl.IDLXDynamic;
import com.lynx.animax.util.AnimaXLog;
import com.lynx.base.log.LynxLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static z4.a f11181a;

    public static double a(File r5) {
        Intrinsics.checkNotNullParameter(r5, "f");
        int r10 = 0;
        if (r5.exists() == false) goto L36;
        if (r5.isDirectory() == true) goto L36;
        FileInputStream r11 = null;
        FileInputStream r12 = new FileInputStream(r5);     // Catch: Throwable -> L18 Exception -> L20
        r10 = r12.available();     // Catch: Throwable -> L14 Exception -> L16
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r12.close();     // Catch: Exception -> L12
    L41:
        goto L36
    L16:
        e = e;
        r11 = r12;
    L21:
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r11 == null) goto L36;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        r11.close();     // Catch: Exception -> L12
    L14:
        th = th;
    L28:
        if (r12 == null) goto L34;
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r12.close();     // Catch: Exception -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L34:
        throw th;
    L20:
        e = e;
    L18:
        th = th;
        r12 = r11;
    L12:
        e = move-exception;
        e.printStackTrace();
    L36:
        return ((double) MathKt.roundToInt((((double) r10) / 1024.0d) * ((double) 100))) / 100.0d;
    }

    public static float b(String r10) {
        return c(r10, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, DisplayMetricsHolder.a());
    }

    public static float c(String r10, float r11, float r12, float r13, float r14, float r15, DisplayMetrics r16) {
        if (android.text.TextUtils.isEmpty(r10) == false) goto L5;
        int r5 = 0;
    L7:
        if (r5 > 3) goto L54;
    L12:
        if (r5 <= 3) goto L18;
        if (r10.endsWith("ppx") == false) goto L18;
        return Float.parseFloat(r10.substring(0, r5 - 3));
    L18:
        if (r5 <= 2) goto L24;
        if (r10.endsWith("px") == false) goto L24;
        return g.a(Float.parseFloat(r10.substring(0, r5 - 2)), 0.0f);
    L24:
        if (r5 > 1) goto L26;
    L29:
        if (r5 > 3) goto L31;
    L34:
        if (r5 > 2) goto L36;
    L39:
        if (r5 > 2) goto L41;
    L44:
        if (r5 > 2) goto L46;
    L49:
        if (r5 > 0) goto L51;
    L53:
        return r15;
    L51:
        return Float.parseFloat(r10);
    L46:
        if (r10.endsWith("vh") == false) goto L49;
        return (r14 * Float.parseFloat(r10.substring(0, r5 - 2))) / 100.0f;
    L41:
        if (r10.endsWith("vw") == false) goto L44;
        return (r13 * Float.parseFloat(r10.substring(0, r5 - 2))) / 100.0f;
    L36:
        if (r10.endsWith("em") == false) goto L39;
        return r12 * Float.parseFloat(r10.substring(0, r5 - 2));
    L31:
        if (r10.endsWith("rem") == false) goto L34;
        return r11 * Float.parseFloat(r10.substring(0, r5 - 3));
    L26:
        if (r10.endsWith("%") == false) goto L29;
        return Float.parseFloat(r10.substring(0, r5 - 1)) / 100.0f;
    L54:
    L52:
        LynxLog.b(3, "lynx", "Number parse error from value = " + r10 + " to px!");
        goto L53
    L9:
        if (r10.endsWith("rpx") == false) goto L12;
        return (r16.widthPixels * Float.parseFloat(r10.substring(0, r5 - 3))) / 750.0f;
    L5:
        r5 = r10.length();
        goto L7
    }

    public static float d(String r10, float r11, float r12, DisplayMetrics r13) {
        if (android.text.TextUtils.isEmpty(r10) == false) goto L5;
        int r5 = 0;
    L7:
        if (r5 <= 1) goto L13;
    L14:
        LynxLog.b(3, "lynx", "Number parse error from value = " + r10 + " to px!");
        return r12;
    L9:
        if (r10.endsWith("%") == false) goto L13;
        return (Float.parseFloat(r10.substring(0, r5 - 1)) * r11) / 100.0f;
    L13:
        return c(r10, 0.0f, 0.0f, 0.0f, 0.0f, r12, r13);
    L5:
        r5 = r10.length();
        goto L7
    }

    public static float e(String r11, float r12, DisplayMetrics r13) {
        if (android.text.TextUtils.isEmpty(r11) == false) goto L5;
        int r5 = 0;
    L7:
        if (r5 <= 1) goto L13;
    L14:
        LynxLog.b(3, "lynx", "Number parse error from value = " + r11 + " to px!");
        return 0.0f;
    L9:
        if (r11.endsWith("%") == false) goto L13;
        return (Float.parseFloat(r11.substring(0, r5 - 1)) * r12) / 100.0f;
    L13:
        return c(r11, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, r13);
    L5:
        r5 = r11.length();
        goto L7
    }

    public static int f(float r5) {
        if (r5 >= 0.0f) goto L7;
        return 0;
    L7:
        if (r5 <= 255.0f) goto L11;
        return 255;
    L11:
        return Math.round(r5);
    }

    public static int g(float r5, float r10, float r11) {
        float r12 = 0.0f;
        float r13 = r5 % 360.0f;
        if (r5 >= 0.0f) goto L6;
        r13 = r13 + 360.0f;
    L6:
        float r14 = r13 / 60.0f;
        float r15 = r10 / 100.0f;
        float r16 = r11 / 100.0f;
        if (r15 >= 0.0f) goto L10;
        r15 = 0.0f;
    L13:
        if (r16 < 0.0f) goto L20;
        if (r16 <= 1.0f) goto L18;
        r12 = 1.0f;
        goto L20
    L18:
        r12 = r16;
    L20:
        if (r12 > 0.5f) goto L22;
        float r17 = (r15 + 1.0f) * r12;
    L23:
        float r18 = (r12 * 2.0f) - r17;
        float r19 = p(r18, r17, r14 + 2.0f);
        float r20 = p(r18, r17, r14);
        float r21 = p(r18, r17, r14 - 2.0f);
        return f(r21 * 256.0f) | ((f(r19 * 256.0f) << 16) | (f(r20 * 256.0f) << 8));
    L22:
        r17 = (r12 + r15) - (r15 * r12);
        goto L23
    L10:
        if (r15 <= 1.0f) goto L13;
        r15 = 1.0f;
        goto L13
    }

    public static int h(String r14) {
        Intrinsics.checkNotNullParameter(r14, "value");
        if (r14.length() != 0) goto L5;
        return ViewCompat.MEASURED_STATE_MASK;
    L5:
        int r5 = 4;
        if (r14.charAt(0) != '#') goto L54;
        int r10 = r14.length();
        Intrinsics.checkNotNullParameter(r14, "input");
        if (1 >= r10) goto L34;
        long r11 = 0;
        int r12 = 1;
    L11:
        if (r12 >= r10) goto L33;
        char r13 = r14.charAt(r12);
        if (Intrinsics.compare(r13, 48) < 0) goto L19;
        if (Intrinsics.compare(r13, 57) > 0) goto L19;
        long r15 = r11 * ((long) 16);
        long r16 = r13 - '0';
    L17:
        r11 = r15 + r16;
        if (r11 > 4294967295L) goto L34;
        r12 = r12 + 1;
    L19:
        if (Intrinsics.compare(r13, 65) < 0) goto L25;
        if (Intrinsics.compare(r13, 70) > 0) goto L25;
        long r17 = r11 * ((long) 16);
        int r18 = r13 - 'A';
    L23:
        r15 = r17 + ((long) r18);
        r16 = 10;
    L25:
        if (Intrinsics.compare(r13, 97) < 0) goto L33;
        if (Intrinsics.compare(r13, 102) > 0) goto L33;
        r17 = r11 * ((long) 16);
        r18 = r13 - 'a';
    L33:
        if (r12 == 1) goto L34;
        Pair r19 = new Pair(Integer.valueOf((int) r11), Integer.valueOf(r12));
    L36:
        if (r19 != null) goto L38;
        return ViewCompat.MEASURED_STATE_MASK;
    L38:
        int r20 = ((Number) r19.getFirst()).intValue();
        int r110 = ((Number) r19.getSecond()).intValue();
        if (r110 == 4) goto L52;
        if (r110 != 5) goto L42;
        int r111 = 61440 & r20;
        int r21 = r20 & 3840;
        int r22 = r20 & 240;
        int r23 = r20 & 15;
        return (((((r111 << 4) | (((r23 << 24) | (r23 << 28)) | (r111 << 8))) | (r21 << 4)) | r21) | r22) | (r22 >> 4);
    L42:
        if (r110 == 7) goto L49;
        if (r110 == 9) goto L47;
        return ViewCompat.MEASURED_STATE_MASK;
    L47:
        return ((r20 << 24) | r20) >>> 8;
    L49:
        return r20 | ViewCompat.MEASURED_STATE_MASK;
    L52:
        int r112 = r20 & 3840;
        int r24 = r20 & 240;
        int r25 = r20 & 15;
        return (((((r112 << 8) | ((-16777216) | (r112 << 12))) | (r24 << 8)) | (r24 << 4)) | (r25 << 4)) | r25;
    L34:
        r19 = null;
        goto L36
    L54:
        String r26 = r14.toLowerCase(Locale.US);
        boolean r27 = StringsKt.P(r26, "rgba(");
        boolean r28 = StringsKt.P(r26, "rgb(");
        boolean r29 = StringsKt.P(r26, "hsla(");
        boolean r30 = StringsKt.P(r26, "hsl");
        if (r27 == true) goto L93;
        if (r28 == true) goto L93;
        if (r30 == true) goto L67;
        if (r29 == true) goto L67;
        Integer r113 = (Integer) s4.a.f21814a.get(r14);
        if (r113 != null) goto L64;
        return ViewCompat.MEASURED_STATE_MASK;
    L64:
        return r113.intValue();
    L67:
        if (r29 == false) goto L69;
        r5 = 5;
    L69:
        l9.g r114 = new l9.g(r26.substring(r5));
        r114.i();
        float r31 = r114.a();
        float r32 = r114.b(r31);
        if (Float.isNaN(r32) == true) goto L72;
        r114.f('%');
    L72:
        float r33 = r114.b(r32);
        if (Float.isNaN(r33) == true) goto L75;
        r114.f('%');
    L75:
        if (r29 == false) goto L84;
        float r34 = r114.b(r33);
        r114.i();
        if (Float.isNaN(r34) == false) goto L79;
    L83:
        return ViewCompat.MEASURED_STATE_MASK;
    L79:
        if (r114.f(')') == false) goto L83;
        return (f(r34 * 256) << 24) | g(r31, r32, r33);
    L84:
        r114.i();
        if (Float.isNaN(r33) == false) goto L87;
    L91:
        return ViewCompat.MEASURED_STATE_MASK;
    L87:
        if (r114.f(')') == false) goto L91;
        return g(r31, r32, r33) | ViewCompat.MEASURED_STATE_MASK;
    L93:
        if (r27 == false) goto L95;
        r5 = 5;
    L95:
        l9.g r35 = new l9.g(r14.substring(r5));
        r35.i();
        float r115 = r35.a();
        if (Float.isNaN(r115) == false) goto L98;
    L100:
        float r36 = r35.b(r115);
        if (Float.isNaN(r36) == false) goto L103;
    L105:
        float r37 = r35.b(r36);
        if (Float.isNaN(r37) == false) goto L108;
    L110:
        if (r27 == false) goto L118;
        float r38 = r35.b(r37);
        r35.i();
        if (Float.isNaN(r37) == false) goto L114;
    L117:
        return ViewCompat.MEASURED_STATE_MASK;
    L114:
        if (r35.f(')') == false) goto L117;
        return (((f(r115) << 16) | (f(r38 * 256) << 24)) | (f(r36) << 8)) | f(r37);
    L118:
        r35.i();
        if (Float.isNaN(r37) == false) goto L121;
    L125:
        return ViewCompat.MEASURED_STATE_MASK;
    L121:
        if (r35.f(')') == false) goto L125;
        return (((f(r115) << 16) | ViewCompat.MEASURED_STATE_MASK) | (f(r36) << 8)) | f(r37);
    L108:
        if (r35.f('%') == false) goto L110;
        r37 = (r37 * 256) / 100;
        goto L110
    L103:
        if (r35.f('%') == false) goto L105;
        r36 = (r36 * 256) / 100;
        goto L105
    L98:
        if (r35.f('%') == false) goto L100;
        r115 = (r115 * 256) / 100;
        goto L100
    }

    public static String i(Uri r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (r5.isHierarchical() == false) goto L5;
        return r5.buildUpon().clearQuery().toString();
    L9:
        return r5.toString();
    L5:
        return r5.toString();
    }

    public static String j(String r5, String r10, String r11) {
        return j0.D(r5, r10, r11);
    }

    public static JSONArray k(List r5) {
        Intrinsics.checkNotNullParameter(r5, "list");
        JSONArray r10 = new JSONArray();
        Iterator r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L43;
        Object r12 = r11.next();
        if ((r12 instanceof Float) == true) goto L8;
        if ((r12 instanceof Long) == true) goto L13;
        if ((r12 instanceof Integer) == true) goto L16;
        if ((r12 instanceof Double) == true) goto L19;
        if ((r12 instanceof String) == true) goto L22;
        if ((r12 instanceof Boolean) == true) goto L25;
        if ((r12 instanceof Map) == false) goto L31;
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");     // Catch: Exception -> L44 Throwable -> L9
        r10.put(l((Map) r12));     // Catch: Exception -> L44 Throwable -> L9
        goto L4
    L31:
        if ((r12 instanceof List) == true) goto L32;
        if ((r12 instanceof IDLXDynamic) == false) goto L4;
        r10.put(com.bytedance.android.anniex.base.service.f.c((IDLXDynamic) r12));     // Catch: Throwable -> L9
        goto L4
    L32:
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");     // Catch: Exception -> L44 Throwable -> L9
        r10.put(k((List) r12));     // Catch: Exception -> L44 Throwable -> L9
        goto L4
    L25:
        r10.put(((Boolean) r12).booleanValue());     // Catch: Throwable -> L9
        goto L4
    L22:
        r10.put(r12);     // Catch: Throwable -> L9
        goto L4
    L19:
        r10.put(((Number) r12).doubleValue());     // Catch: Throwable -> L9
        goto L4
    L16:
        r10.put(((Number) r12).intValue());     // Catch: Throwable -> L9
        goto L4
    L13:
        r10.put(((Number) r12).longValue());     // Catch: Throwable -> L9
        goto L4
    L8:
        r10.put(((Number) r12).floatValue());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        String r13 = "listToJSON error:" + th.getMessage() + ",entry:" + r12;
        Intrinsics.checkNotNullParameter(r13, "msg");
        LinkedHashMap r14 = ne.b.f20228a;
        Intrinsics.checkNotNullParameter(ne.a.class, NotificationCompat.CATEGORY_SERVICE);
        if (ne.b.f20228a.get(ne.a.class) != null) goto L42;
        Log.e("BDXBridgeKit", r13);
        goto L4
    L42:
        throw new ClassCastException();
    L43:
        return r10;
    }

    public static JSONObject l(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "map");
        JSONObject r10 = new JSONObject();
        Iterator r11 = r5.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L43;
        Map.Entry r12 = (Map.Entry) r11.next();
        String r13 = (String) r12.getKey();     // Catch: Throwable -> L9
        Object r14 = r12.getValue();     // Catch: Throwable -> L9
        if ((r14 instanceof Long) == true) goto L8;
        if ((r14 instanceof Float) == true) goto L13;
        if ((r14 instanceof Integer) == true) goto L16;
        if ((r14 instanceof Double) == true) goto L19;
        if ((r14 instanceof String) == true) goto L22;
        if ((r14 instanceof Boolean) == true) goto L25;
        if ((r14 instanceof Map) == false) goto L31;
        r10.put(r13, l((Map) r14));     // Catch: Exception -> L44 Throwable -> L9
        goto L4
    L31:
        if ((r14 instanceof List) == true) goto L32;
        if ((r14 instanceof IDLXDynamic) == false) goto L4;
        r10.put(r13, com.bytedance.android.anniex.base.service.f.c((IDLXDynamic) r14));     // Catch: Throwable -> L9
        goto L4
    L32:
        r10.put(r13, k((List) r14));     // Catch: Exception -> L44 Throwable -> L9
        goto L4
    L25:
        r10.put(r13, ((Boolean) r14).booleanValue());     // Catch: Throwable -> L9
        goto L4
    L22:
        r10.put(r13, r14);     // Catch: Throwable -> L9
        goto L4
    L19:
        r10.put(r13, ((Number) r14).doubleValue());     // Catch: Throwable -> L9
        goto L4
    L16:
        r10.put(r13, ((Number) r14).intValue());     // Catch: Throwable -> L9
        goto L4
    L13:
        r10.put(r13, ((Number) r14).floatValue());     // Catch: Throwable -> L9
        goto L4
    L8:
        r10.put(r13, ((Number) r14).longValue());     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        String r15 = "mapToJSON error:" + th.getMessage() + ",entry:" + r12;
        Intrinsics.checkNotNullParameter(r15, "msg");
        LinkedHashMap r16 = ne.b.f20228a;
        Intrinsics.checkNotNullParameter(ne.a.class, NotificationCompat.CATEGORY_SERVICE);
        if (ne.b.f20228a.get(ne.a.class) != null) goto L42;
        Log.e("BDXBridgeKit", r15);
        goto L4
    L42:
        throw new ClassCastException();
    L43:
        return r10;
    }

    public static void m(Closeable r5) {
        if (r5 == null) goto L11;
        r5.close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXStreamUtil", "Failed to close resource: " + e);
        return;
    }

    public static boolean n(InputStream r5, OutputStream r10, int r11) {
        if (r5 == null) goto L23;
        if (r10 == null) goto L23;
        int r12 = 1024;
        if (r11 >= 1024) goto L9;
    L8:
        r11 = r12;
    L12:
        byte[] r13 = new byte[r11];     // Catch: Throwable -> L17 IOException -> L19
    L13:
        int r14 = r5.read(r13, 0, r11);     // Catch: Throwable -> L17 IOException -> L19
        if (r14 == (-1)) goto L21;
        r10.write(r13, 0, r14);     // Catch: Throwable -> L17 IOException -> L19
        goto L13
    L21:
        m(r5);
        m(r10);
        return true;
    L9:
        r12 = 8192;
        if (r11 <= 8192) goto L12;
    L23:
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXStreamUtil", "Invalid input stream or output stream");     // Catch: Throwable -> L17 IOException -> L19
        m(r5);
        m(r10);
        return false;
    L17:
        th = move-exception;
        m(r5);
        m(r10);
        throw th;
    L19:
        e = move-exception;
        AnimaXLog.a(AnimaXLog.LogLevel.f9715c, "AnimaXStreamUtil", "Failed to copy input stream to output stream, reason: " + e);     // Catch: Throwable -> L17
        m(r5);
        m(r10);
        return false;
    }

    public static boolean o(String r5) {
        if (r5 != null) goto L4;
        return false;
    L4:
        if (r5.length() <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static float p(float r5, float r10, float r11) {
        if (r11 >= 0.0f) goto L6;
        r11 = r11 + 6.0f;
    L6:
        if (r11 < 6.0f) goto L9;
        r11 = r11 - 6.0f;
    L9:
        if (r11 >= 1.0f) goto L13;
        return j0.b(r10, r5, r11, r5);
    L13:
        if (r11 >= 3.0f) goto L16;
        return r10;
    L16:
        if (r11 < 4.0f) goto L18;
        return r5;
    L18:
        return j0.b(4.0f, r11, r10 - r5, r5);
    }

    public static void q(Closeable r5) {
        if (r5 == null) goto L8;
        r5.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static eq.b r() {
        Object r5 = eq.b.f16855c;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (eq.b.d != null) goto L13;
        Intrinsics.checkNotNullParameter("MetricsHandler", "tag");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter("get new MetricsHandler", "msg");     // Catch: Throwable -> L9
        org.koin.core.a r10 = su.a.f22013b;     // Catch: Throwable -> L9
        if (r10 == null) goto L12;
        ((ju.b) r10.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("MetricsHandler", "get new MetricsHandler");     // Catch: Throwable -> L9
        eq.b.d = new eq.b();     // Catch: Throwable -> L9
        goto L13
    L12:
        throw new IllegalStateException("KoinApplication has not been started");     // Catch: Throwable -> L9
    L13:
        eq.b r11 = eq.b.d;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r11);     // Catch: Throwable -> L9
        monitor-exit(r5);
        return r11;
    }
}
