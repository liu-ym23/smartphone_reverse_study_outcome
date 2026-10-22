package com.obric.cae.location.util;

import android.location.Location;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f7287a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f7288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7289b;
        public final int c;

        public a(b r1, double r2, int r4) {
            this.f7288a = r1;
            this.f7289b = r2;
            this.c = r4;
        }

        public double a() {
            return this.f7288a.a();
        }

        public double b() {
            return this.f7288a.b();
        }

        public double c() {
            return this.f7289b;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f7290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7291b;

        public b(double r1, double r3) {
            this.f7290a = r1;
            this.f7291b = r3;
        }

        public static boolean a(b r4, b r5) {
            if (Double.compare(r4.f7290a, r5.f7290a) == 0) goto L5;
        L7:
            return false;
        L5:
            if (Double.compare(r4.f7291b, r5.f7291b) != 0) goto L7;
            return true;
        }

        public double a() {
            return this.f7290a;
        }

        public double b() {
            return this.f7291b;
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.util.c$c, reason: collision with other inner class name */
    public static final class C0361c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f7292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7293b;
        public final double c;

        public C0361c(double r1, double r3, double r5) {
            this.f7292a = r1;
            this.f7293b = r3;
            this.c = r5;
        }

        public static boolean a(C0361c r8, d r9) {
            double r0 = r8.f7292a;
            double r2 = r8.f7293b;
            double r4 = r9.f7294a;
            double r6 = r9.f7295b;
            ConcurrentHashMap r10 = c.f7287a;
            if (Math.hypot(r0 - r4, r2 - r6) > (r8.c + 1.0E-7d)) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f7294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7295b;

        public d(double r1, double r3) {
            this.f7294a = r1;
            this.f7295b = r3;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f7296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7297b;
        public final double c;

        public e(double r1, double r3, double r5) {
            this.f7296a = r1;
            this.f7297b = r3;
            this.c = r5;
        }

        public static e a(List<b> r13) {
            List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
            Iterator r0 = r14.iterator();
            double r2 = 0.0d;
            double r4 = 0.0d;
        L4:
            if (r0.hasNext() == false) goto L6;
            b r6 = (b) ZeusTransformUtils.preCheckCast(r0.next(), b.class, "com.obric.memorydata.plugin");
            r4 = r4 + r6.a();
            r2 = r2 + r6.b();
            goto L4
        L6:
            double r7 = r4 / ((double) r14.size());
            double r9 = r2 / ((double) r14.size());
            double r1 = Math.cos(Math.toRadians(r9));
            if (Math.abs(r1) > 1.0E-7d) goto L9;
            double r11 = 1.0E-7d;
        L11:
            return new e(r7, r9, r11);
        L9:
            r11 = r1;
            goto L11
        }

        public final d a(b r9) {
            double r0 = this.c * 6378137.0d;
            return new d(Math.toRadians(r9.a() - this.f7296a) * r0, Math.toRadians(r9.b() - this.f7297b) * 6378137.0d);
        }
    }

    static {
        f7287a = new ConcurrentHashMap();
    }

    public static double a(b r40, b r41) {
        double r0 = r40.b();
        double r2 = r40.a();
        double r4 = r41.b();
        double r6 = r41.a();
        double r1 = Math.toRadians(r0);
        double r5 = Math.toRadians(r4);
        double r3 = Math.toRadians(r6 - r2);
        double r7 = Math.atan(Math.tan(r1) * 0.996647189328169d);
        double r8 = Math.atan(Math.tan(r5) * 0.996647189328169d);
        double r9 = Math.sin(r7);
        double r10 = Math.cos(r7);
        double r11 = Math.sin(r8);
        double r12 = Math.cos(r8);
        int r13 = 0;
        double r14 = r3;
        double r15 = 0.0d;
        double r17 = 0.0d;
        double r19 = 0.0d;
        double r21 = 0.0d;
        double r23 = 0.0d;
    L4:
        if (r13 >= 20) goto L16;
        double r16 = Math.sin(r14);
        double r18 = Math.cos(r14);
        int r33 = r13;
        double r34 = r14;
        double r36 = r3;
        double r20 = Math.hypot(r12 * r16, (r10 * r11) - ((r9 * r12) * r18));
        if (r20 <= 1.0E-7d) goto L7;
        double r110 = r10 * r12;
        double r111 = (r18 * r110) + (r9 * r11);
        r23 = Math.atan2(r20, r111);
        double r112 = (r110 * r16) / r20;
        double r113 = 1.0d - (r112 * r112);
        double r114 = (r9 * 2.0d) * r11;
        if (r113 > 1.0E-7d) goto L11;
        double r115 = 1.0d;
    L12:
        r17 = r111 - (r114 / r115);
        double r22 = (((4.0d - (3.0d * r113)) * 0.0033528106718309896d) + 4.0d) * (2.0955066698943685E-4d * r113);
        double r38 = ((((((((r17 * 2.0d) * r17) - 1.0d) * (r22 * r111)) + r17) * (r22 * r20)) + r23) * (((1.0d - r22) * 0.0033528106718309896d) * r112)) + r36;
        if (Math.abs(r38 - r34) < 1.0E-12d) goto L14;
        r13 = r33 + 1;
        r19 = r20;
        r21 = r111;
        r3 = r36;
        r14 = r38;
        r15 = r113;
        goto L4
    L14:
        r19 = r20;
        r21 = r111;
        r15 = r113;
        goto L16
    L11:
        r115 = r113;
        goto L12
    L7:
        return 0.0d;
    L16:
        double r116 = (r15 * 2.723316066819453E11d) / 4.0408299984087055E13d;
        double r24 = (((((74.0d - (47.0d * r116)) * r116) - 128.0d) * r116) + 256.0d) * (r116 / 1024.0d);
        double r31 = ((4.0d * r17) * r17) - 3.0d;
        return (r23 - ((((((((2.0d * r17) * r17) - 1.0d) * r21) - (r31 * ((((r19 * 4.0d) * r19) - 3.0d) * ((r24 / 6.0d) * r17)))) * (r24 / 4.0d)) + r17) * (r24 * r19))) * ((((((((320.0d - (175.0d * r116)) * r116) - 768.0d) * r116) + 4096.0d) * (r116 / 16384.0d)) + 1.0d) * 6356752.3142d);
    }

    public static double a(d r6, d r7, double r8, double r10) {
        double r0 = r7.f7294a;
        double r2 = r6.f7294a;
        double r4 = r6.f7295b;
        double r11 = r10 - r4;
        double r9 = r8 - r2;
        return (r11 * (r0 - r2)) - (r9 * (r7.f7295b - r4));
    }

    public static double a(d r10, d r11, d r12) {
        double r0 = r12.f7294a - r11.f7294a;
        double r2 = r12.f7295b - r11.f7295b;
        if (Math.abs(r0) <= 1.0E-7d) goto L5;
    L8:
        double r4 = (r10.f7294a - r11.f7294a) * r0;
        double r6 = ((r10.f7295b - r11.f7295b) * r2) + r4;
        double r8 = r2 * r2;
        double r5 = Math.max(0.0d, Math.min(1.0d, r6 / (r8 + (r0 * r0))));
        double r1 = r0 * r5;
        double r3 = r1 + r11.f7294a;
        double r7 = r5 * r2;
        double r9 = r7 + r11.f7295b;
        double r13 = r10.f7294a;
        return Math.hypot(r13 - r3, r10.f7295b - r9);
    L5:
        if (Math.abs(r2) > 1.0E-7d) goto L8;
        double r14 = r10.f7294a;
        double r15 = r10.f7295b;
        double r16 = r11.f7294a;
        return Math.hypot(r14 - r16, r15 - r11.f7295b);
    }

    public static a a(List<b> r50) {
        String r1 = "com.obric.memorydata.plugin";
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r50, List.class, "com.obric.memorydata.plugin");
        C0361c r3 = null;
        if (r0.isEmpty() == false) goto L5;
        return null;
    L5:
        e r2 = e.a(r0);
        ArrayList r4 = new ArrayList(r0.size());
        Iterator r5 = r0.iterator();
    L7:
        if (r5.hasNext() == false) goto L10;
        r4.add(r2.a((b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin")));
        goto L7
    L10:
        if (r4.isEmpty() == false) goto L12;
        List r30 = r0;
        C0361c r9 = null;
    L83:
        if (r9 != null) goto L86;
        return null;
    L86:
        double r6 = r9.f7292a;
        double r7 = r9.f7293b;
        return new a(new b(Math.toDegrees(r6 / (r2.c * 6378137.0d)) + r2.f7296a, Math.toDegrees(r7 / 6378137.0d) + r2.f7297b), Math.max(r9.c, 0.0d), r30.size());
    L12:
        ArrayList r8 = new ArrayList(r4);
        Collections.shuffle(r8, new Random(0));
        int r10 = 0;
        r9 = null;
        int r11 = 0;
    L14:
        if (r11 >= r8.size()) goto L82;
        d r12 = (d) ZeusTransformUtils.preCheckCast(r8.get(r11), d.class, r1);
        if (r9 != null) goto L18;
    L21:
        List r13 = r8.subList(r10, r11 + 1);
        C0361c r14 = new C0361c(r12.f7294a, r12.f7295b, 0.0d);
        int r15 = r10;
    L23:
        if (r15 >= r13.size()) goto L80;
        d r16 = (d) ZeusTransformUtils.preCheckCast(r13.get(r15), d.class, r1);
        if (C0361c.a(r14, r16) == false) goto L27;
    L78:
        List r31 = r0;
        String r25 = r1;
        ArrayList r51 = r8;
        int r28 = r11;
        List r26 = r13;
        d r24 = r12;
        int r23 = r15;
    L79:
        r15 = r23 + 1;
        r8 = r51;
        r12 = r24;
        r1 = r25;
        r13 = r26;
        r11 = r28;
        r0 = r31;
        r3 = null;
        r10 = 0;
        goto L23
    L27:
        if (r14.c > 1.0E-7d) goto L29;
        double r17 = r12.f7294a;
        double r22 = (r16.f7294a + r17) / 2.0d;
        double r18 = r12.f7295b;
        double r27 = (r16.f7295b + r18) / 2.0d;
        r14 = new C0361c(r22, r27, Math.hypot(r22 - r17, r27 - r18));
        goto L78
    L29:
        List r19 = r13.subList(r10, r15 + 1);
        double r110 = r12.f7294a;
        r51 = r8;
        double r29 = (r16.f7294a + r110) / 2.0d;
        double r20 = r12.f7295b;
        r28 = r11;
        double r210 = (r16.f7295b + r20) / 2.0d;
        C0361c r21 = new C0361c(r29, r210, Math.hypot(r29 - r110, r210 - r20));
        Iterator r32 = r19.iterator();
    L31:
        if (r32.hasNext() == false) goto L35;
        if (C0361c.a(r21, (d) ZeusTransformUtils.preCheckCast(r32.next(), d.class, r1)) == true) goto L31;
        boolean r33 = false;
    L36:
        if (r33 == false) goto L38;
        r31 = r0;
        r25 = r1;
        C0361c r211 = r21;
        r26 = r13;
        r24 = r12;
        r23 = r15;
    L69:
        r14 = r211;
        goto L79
    L38:
        Iterator r34 = r19.iterator();
        C0361c r35 = r3;
        C0361c r36 = r35;
    L40:
        if (r34.hasNext() == false) goto L66;
        d r37 = (d) ZeusTransformUtils.preCheckCast(r34.next(), d.class, r1);
        r21 = r21;
        r1 = r1;
        d r38 = r16;
        r15 = r15;
        double r39 = a(r12, r16, r37.f7294a, r37.f7295b);
        if (Math.abs(r39) > 1.0E-7d) goto L44;
        List r310 = r0;
        d r311 = r38;
        Iterator r212 = r34;
        C0361c r40 = r35;
        C0361c r41 = r36;
        List r213 = r13;
        d r214 = r12;
    L62:
        r35 = r40;
        r36 = r41;
    L63:
        r12 = r214;
        r13 = r213;
        r34 = r212;
        r0 = r310;
        r16 = r311;
        goto L40
    L44:
        double r111 = r12.f7294a;
        double r112 = r12.f7295b;
        r213 = r13;
        r214 = r12;
        double r42 = r38.f7294a;
        r212 = r34;
        C0361c r215 = r35;
        double r43 = r38.f7295b;
        r310 = r0;
        r311 = r38;
        double r44 = r37.f7294a;
        C0361c r312 = r36;
        double r45 = r37.f7295b;
        double r113 = r43 - r45;
        double r313 = r45 - r112;
        double r314 = r112 - r43;
        double r315 = ((r44 * r314) + ((r42 * r313) + (r111 * r113))) * 2.0d;
        if (Math.abs(r315) > 1.0E-7d) goto L47;
        C0361c r46 = null;
    L48:
        if (r46 != null) goto L52;
        r40 = r215;
    L50:
        r41 = r312;
        goto L62
    L52:
        if (r39 <= 0.0d) goto L57;
        if (r215 == null) goto L56;
        r40 = r215;
        if (a(r214, r311, r46.f7292a, r46.f7293b) <= a(r214, r311, r40.f7292a, r40.f7293b)) goto L50;
    L56:
        r35 = r46;
        r12 = r214;
        r13 = r213;
        r34 = r212;
        r0 = r310;
        r16 = r311;
        r36 = r312;
        goto L40
    L57:
        r40 = r215;
        if (r312 == null) goto L65;
        r41 = r312;
        if (a(r214, r311, r46.f7292a, r46.f7293b) >= a(r214, r311, r41.f7292a, r41.f7293b)) goto L62;
    L65:
        r36 = r46;
        r35 = r40;
        goto L63
    L47:
        double r47 = (r112 * r112) + (r111 * r111);
        double r48 = (r43 * r43) + (r42 * r42);
        double r49 = (r45 * r45) + (r44 * r44);
        double r316 = r314 * r49;
        double r410 = (r316 + ((r313 * r48) + (r113 * r47))) / r315;
        double r114 = (r44 - r42) * r47;
        double r411 = (((r42 - r111) * r49) + (((r111 - r44) * r48) + r114)) / r315;
        r46 = new C0361c(r410, r411, Math.hypot(r410 - r111, r411 - r112));
        goto L48
    L66:
        r31 = r0;
        r25 = r1;
        r211 = r21;
        C0361c r52 = r35;
        C0361c r53 = r36;
        r26 = r13;
        r24 = r12;
        r23 = r15;
        if (r52 != null) goto L70;
        if (r53 == null) goto L69;
    L70:
        if (r52 == null) goto L77;
        if (r53 != null) goto L75;
    L76:
        r14 = r52;
        goto L79
    L75:
        if (r52.c <= r53.c) goto L76;
    L77:
        r14 = r53;
        goto L79
    L35:
        r33 = true;
        goto L36
    L80:
        List r317 = r0;
        String r216 = r1;
        ArrayList r54 = r8;
        int r217 = r11;
        r9 = r14;
    L81:
        r11 = r217 + 1;
        r8 = r54;
        r1 = r216;
        r0 = r317;
        r3 = null;
        r10 = 0;
        goto L14
    L18:
        if (C0361c.a(r9, r12) == false) goto L21;
        r317 = r0;
        r216 = r1;
        r54 = r8;
        r217 = r11;
        goto L81
    L82:
        r30 = r0;
        goto L83
    }

    public static String a(JsonElement r4) {
        JsonObject r0 = null;
        if (r4 == null) goto L23;
        if (r4.isJsonNull() == true) goto L23;
        if (r4.isJsonPrimitive() == false) goto L17;
        String r5 = r4.getAsString();
        if (r5 != null) goto L12;
    L16:
        r4 = null;
        goto L17
    L12:
        if (r5.trim().isEmpty() == true) goto L16;
        JsonReader r2 = new JsonReader(new StringReader(r5));     // Catch: Exception -> L39
        r2.setLenient(true);     // Catch: Exception -> L39
        r4 = JsonParser.parseReader(r2);     // Catch: Exception -> L39
    L17:
        if (r4 == null) goto L23;
        if (r4.isJsonObject() == false) goto L23;
        r0 = r4.getAsJsonObject();
    L23:
        if (r0 != null) goto L25;
        return "";
    L25:
        if (r0.has("coordinates") == false) goto L44;
        JsonElement r1 = r0.get("coordinates");
        if (r1 != null) goto L30;
        return "";
    L30:
        if (r1.isJsonArray() == false) goto L45;
        StringBuilder r6 = new StringBuilder();
        a(r1.getAsJsonArray(), r6);
        if (r6.length() <= 0) goto L38;
        if (r6.charAt(r6.length() - 1) != ';') goto L38;
        r6.deleteCharAt(r6.length() - 1);
    L38:
        return r6.toString();
    L45:
        return "";
    L44:
        return "";
    }

    public static String a(String r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.trim().isEmpty() == false) goto L7;
        return "";
    L7:
        if (r2.trim().isEmpty() == false) goto L17;
    L11:
        JsonElement r3 = null;
    L13:
        return a(r3);
    L17:
        JsonReader r0 = new JsonReader(new StringReader(r2));     // Catch: Exception -> L16
        r0.setLenient(true);     // Catch: Exception -> L16
        r3 = JsonParser.parseReader(r0);     // Catch: Exception -> L16
        goto L13
    }

    public static void a(JsonArray r7, StringBuilder r8) {
        if (r7 != null) goto L4;
        return;
    L4:
        if (r7.isEmpty() == true) goto L92;
        JsonElement r1 = r7.get(0);
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.isJsonNull() == false) goto L11;
        return;
    L11:
        if (r1.isJsonArray() == false) goto L93;
        JsonArray r2 = r1.getAsJsonArray();
        if (r2.isEmpty() == true) goto L16;
        JsonElement r3 = r2.get(0);
    L18:
        if (r3 != null) goto L20;
    L49:
        Iterator<JsonElement> r9 = r7.iterator();
    L51:
        if (r9.hasNext() == false) goto L94;
        JsonElement r0 = (JsonElement) ZeusTransformUtils.preCheckCast(r9.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L51;
        if (r0.isJsonNull() == true) goto L51;
        if (r0.isJsonArray() == false) goto L51;
        a(r0.getAsJsonArray(), r8);
        goto L51
    L94:
        return;
    L20:
        if (r3.isJsonPrimitive() == false) goto L49;
        if (r3.getAsJsonPrimitive().isNumber() == false) goto L49;
        Iterator<JsonElement> r10 = r7.iterator();
    L25:
        if (r10.hasNext() == false) goto L48;
        JsonElement r4 = (JsonElement) ZeusTransformUtils.preCheckCast(r10.next(), JsonElement.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L25;
        if (r4.isJsonNull() == true) goto L25;
        if (r4.isJsonArray() == false) goto L25;
        JsonArray r5 = r4.getAsJsonArray();
        if (r5.size() < 2) goto L25;
        JsonElement r6 = r5.get(0);
        JsonElement r11 = r5.get(1);
        if (r6 == null) goto L25;
        if (r11 == null) goto L25;
        if (r6.isJsonPrimitive() == false) goto L25;
        if (r11.isJsonPrimitive() == false) goto L25;
        Location r12 = new Location("");
        r12.setLongitude(r6.getAsDouble());
        r12.setLatitude(r11.getAsDouble());
        Location r13 = CoordinateTransformUtils.a(CoordinateTransformUtils.CoordinateSystem.GCJ02, CoordinateTransformUtils.CoordinateSystem.WGS84, r12);
        if (r13 == null) goto L25;
        r8.append(r13.getLongitude()).append(",").append(r13.getLatitude()).append(";");
        goto L25
    L48:
        return;
    L16:
        r3 = null;
        goto L18
    L93:
        return;
    }

    public static boolean a(double r2, double r4) {
        if (Double.isNaN(r2) == false) goto L5;
    L15:
        return false;
    L5:
        if (Double.isNaN(r4) == true) goto L15;
        if (r2 < (-90.0d)) goto L15;
        if (r2 > 90.0d) goto L15;
        if (r4 < (-180.0d)) goto L15;
        if (r4 > 180.0d) goto L15;
        return true;
    }

    public static boolean a(String r2, double r3, double r5) {
        if (a(r3, r5) == true) goto L5;
        return false;
    L5:
        List<b> r4 = b(r2);
        if (r4.isEmpty() == false) goto L9;
        return false;
    L9:
        return a(r4, new b(r5, r3));
    }

    public static boolean a(String r4, double r5, double r7, double r9) {
        if (a(r5, r7) == true) goto L5;
    L18:
        return false;
    L5:
        if (r9 < 0.0d) goto L18;
        List<b> r6 = b(r4);
        if (r6.isEmpty() == false) goto L10;
        return false;
    L10:
        b r0 = new b(r7, r5);
        Iterator<b> r8 = r6.iterator();
    L12:
        if (r8.hasNext() == false) goto L16;
        if (a(r0, (b) ZeusTransformUtils.preCheckCast(r8.next(), b.class, "com.obric.memorydata.plugin")) <= (0.01d + r9)) goto L12;
        return false;
    L16:
        return true;
    }

    public static boolean a(List<b> r18, b r19) {
        String r2 = "com.obric.memorydata.plugin";
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.memorydata.plugin");
        double r4 = 0.01d;
        boolean r6 = false;
        boolean r7 = true;
        if (r1.size() == 1) goto L5;
        ArrayList r3 = new ArrayList(r1.size() + 1);
        r3.addAll(r1);
        r3.add(r19);
        e r5 = e.a(r3);
        ArrayList r8 = new ArrayList(r1.size());
        Iterator r9 = r1.iterator();
    L10:
        if (r9.hasNext() == false) goto L12;
        r8.add(r5.a((b) ZeusTransformUtils.preCheckCast(r9.next(), b.class, "com.obric.memorydata.plugin")));
        goto L10
    L12:
        d r0 = r5.a(r19);
        if (r1.size() == 2) goto L15;
        int r10 = r8.size() - 1;
        int r11 = 0;
        boolean r12 = false;
    L20:
        if (r11 >= r8.size()) goto L40;
        d r13 = (d) ZeusTransformUtils.preCheckCast(r8.get(r11), d.class, r2);
        d r14 = (d) ZeusTransformUtils.preCheckCast(r8.get(r10), d.class, r2);
        if (a(r0, r14, r13) <= r4) goto L23;
        double r15 = r13.f7295b;
        double r16 = r0.f7295b;
        if (r15 <= r16) goto L27;
        boolean r17 = r7;
    L28:
        double r20 = r14.f7295b;
        if (r20 <= r16) goto L31;
        r6 = r7;
    L31:
        if (r17 == r6) goto L35;
        ArrayList r21 = r8;
        double r22 = r0.f7294a;
        String r110 = r2;
        double r23 = r14.f7294a;
        d r111 = r0;
        int r112 = r11;
        double r24 = r13.f7294a;
        if (r22 >= ((((r16 - r15) * (r23 - r24)) / (r20 - r15)) + r24)) goto L36;
        boolean r25 = true;
    L37:
        if (r25 == false) goto L39;
        r12 = !r12;
    L39:
        r11 = r112 + 1;
        r0 = r111;
        r8 = r21;
        r2 = r110;
        r10 = r112;
        r4 = 0.01d;
        r6 = false;
        r7 = true;
    L36:
        r25 = false;
        goto L37
    L35:
        r111 = r0;
        r112 = r11;
        r110 = r2;
        r21 = r8;
        goto L36
    L27:
        r17 = r6;
        goto L28
    L23:
        return r7;
    L40:
        return r12;
    L15:
        if (a(r0, (d) ZeusTransformUtils.preCheckCast(r8.get(0), d.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.preCheckCast(r8.get(1), d.class, "com.obric.memorydata.plugin")) <= 0.01d) goto L17;
        return false;
    L17:
        return true;
    L5:
        if (a((b) ZeusTransformUtils.preCheckCast(r1.get(0), b.class, "com.obric.memorydata.plugin"), r19) <= 0.01d) goto L7;
        return false;
    L7:
        return true;
    }

    public static float b(String r7, double r8, double r10) {
        if (a(r8, r10) == true) goto L5;
        return Float.MAX_VALUE;
    L5:
        List<b> r9 = b(r7);
        if (r9.isEmpty() == false) goto L8;
        return Float.MAX_VALUE;
    L8:
        b r0 = new b(r10, r8);
        if (a(r9, r0) == false) goto L12;
        return 0.0f;
    L12:
        int r11 = 0;
        if (r9.size() != 1) goto L15;
        double r12 = a((b) ZeusTransformUtils.preCheckCast(r9.get(0), b.class, "com.obric.memorydata.plugin"), r0);
    L28:
        return (float) r12;
    L15:
        ArrayList r13 = new ArrayList(r9.size() + 1);
        r13.addAll(r9);
        r13.add(r0);
        e r14 = e.a(r13);
        ArrayList r1 = new ArrayList(r9.size());
        Iterator<b> r2 = r9.iterator();
    L17:
        if (r2.hasNext() == false) goto L19;
        r1.add(r14.a((b) ZeusTransformUtils.preCheckCast(r2.next(), b.class, "com.obric.memorydata.plugin")));
        goto L17
    L19:
        d r15 = r14.a(r0);
        double r3 = Double.MAX_VALUE;
        if (r9.size() != 2) goto L22;
        r12 = a(r15, (d) ZeusTransformUtils.preCheckCast(r1.get(0), d.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.preCheckCast(r1.get(1), d.class, "com.obric.memorydata.plugin"));
        goto L28
    L22:
        int r16 = r1.size() - 1;
    L24:
        if (r11 >= r1.size()) goto L26;
        r3 = Math.min(r3, a(r15, (d) ZeusTransformUtils.preCheckCast(r1.get(r16), d.class, "com.obric.memorydata.plugin"), (d) ZeusTransformUtils.preCheckCast(r1.get(r11), d.class, "com.obric.memorydata.plugin")));
        int r6 = r11;
        r11 = r11 + 1;
        r16 = r6;
        goto L24
    L26:
        r12 = r3;
        goto L28
    }

    public static List<b> b(String r2) {
        if (r2 == null) goto L9;
        if (r2.trim().isEmpty() == true) goto L9;
        String r3 = r2.trim();
        return (List) ZeusTransformUtils.preCheckCast(f7287a.computeIfAbsent(r3, $$Lambda$AC2cS51SRL__8zZJ4L1JMg1Z6o.INSTANCE), List.class, "com.obric.memorydata.plugin");
    L9:
        return Collections.emptyList();
    }

    public static a c(String r1) {
        List<b> r2 = b(r1);
        if (r2.isEmpty() == false) goto L7;
        return null;
    L7:
        return a(r2);
    }

    public static List<b> d(String r10) {
        ArrayList r0 = new ArrayList();
        String[] r11 = r10.split(";");
        int r1 = r11.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L36;
        String r6 = r11[r3];
        if (r6 == null) goto L34;
        String r7 = r6.trim();
        if (r7.isEmpty() == true) goto L34;
        String[] r8 = r7.split(",");
        if (r8.length != 2) goto L34;
        String r4 = r8[0];
        Double r9 = null;
        if (r4 != null) goto L49;
    L21:
        Double r5 = null;
    L22:
        String r12 = r8[1];
        if (r12 != null) goto L51;
    L28:
        if (r5 == null) goto L34;
        if (r9 == null) goto L34;
        if (a(r9.doubleValue(), r5.doubleValue()) == false) goto L34;
        r0.add(new b(r5.doubleValue(), r9.doubleValue()));
        goto L34
    L51:
        double r13 = Double.parseDouble(r12.trim());     // Catch: NumberFormatException -> L47
        if (Double.isFinite(r13) == false) goto L28;
        r9 = Double.valueOf(r13);     // Catch: NumberFormatException -> L47
        goto L28
    L49:
        double r14 = Double.parseDouble(r4.trim());     // Catch: NumberFormatException -> L48
        if (Double.isFinite(r14) == false) goto L21;
        r5 = Double.valueOf(r14);     // Catch: NumberFormatException -> L48
    L34:
        r3 = r3 + 1;
        goto L4
    L36:
        if (r0.size() < 2) goto L42;
        if (b.a((b) ZeusTransformUtils.preCheckCast(r0.get(0), b.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), b.class, "com.obric.memorydata.plugin")) == false) goto L42;
        r0.remove(r0.size() - 1);
    L42:
        if (r0.isEmpty() == false) goto L46;
        return Collections.emptyList();
    L46:
        return Collections.unmodifiableList(r0);
    }
}
