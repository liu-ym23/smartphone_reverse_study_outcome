package com.larus.dora.impl.log;

import com.larus.dora.impl.DoraBuryPointManager;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p {
    public static long a;
    public static String b;
    public static String c;
    public static int d;
    public static int e;
    public static int f;
    public static int g;
    public static long h;
    public static boolean i;

    public static String a(int r1) {
        if (r1 != 1) goto L5;
        return "assert";
    L5:
        if (r1 != 2) goto L7;
        return "point";
    L7:
        if (r1 == 3) goto L9;
        return "unknown";
    L9:
        return "key";
    }

    static {
        b = "";
        c = "";
    }

    public static void c(int r5) {
        DoraBuryPointManager r0 = DoraBuryPointManager.a;
        Pair[] r1 = new Pair[5];
        r1[0] = TuplesKt.to("result", Integer.valueOf(r5));
        r1[1] = TuplesKt.to("type", a(f));
        if (d != 0) goto L5;
        String r6 = "R";
    L6:
        r1[2] = TuplesKt.to("side", r6);
        r1[3] = TuplesKt.to("total_size", Integer.valueOf(e));
        r1[4] = TuplesKt.to("offset_size", Long.valueOf(h));
        DoraBuryPointManager.J(r0, "log_get_log_info_result", MapsKt.mapOf(r1), false, 12);
        return;
    L5:
        r6 = "L";
        goto L6
    }

    public static void e(int r4) {
        if (i == true) goto L5;
        return;
    L5:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_switch_buds_role_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r4)), TuplesKt.to("switch_type", c)}), false, 12);
        i = false;
    }

    public static void d(int r9, int r10) {
        long r0 = System.currentTimeMillis() - a;     // Catch: Exception -> L8
        long r2 = ((long) g) - h;     // Catch: Exception -> L8
        String r4 = String.format("%.1f", Arrays.copyOf(new Object[]{Double.valueOf(((Math.abs(r2) * ((double) 1000)) / r0) / ((double) 1024))}, 1));     // Catch: Exception -> L8
        Pair[] r6 = new Pair[11];     // Catch: Exception -> L8
        r6[0] = TuplesKt.to("result", Integer.valueOf(r9));     // Catch: Exception -> L8
        r6[1] = TuplesKt.to("type", a(f));     // Catch: Exception -> L8
        if (d != 0) goto L5;
        String r7 = "R";
    L6:
        r6[2] = TuplesKt.to("side", r7);     // Catch: Exception -> L8
        r6[3] = TuplesKt.to("trigger_type", b);     // Catch: Exception -> L8
        r6[4] = TuplesKt.to("duration", Long.valueOf(r0));     // Catch: Exception -> L8
        r6[5] = TuplesKt.to("total_size", Integer.valueOf(e));     // Catch: Exception -> L8
        r6[6] = TuplesKt.to("get_size", Integer.valueOf(g));     // Catch: Exception -> L8
        r6[7] = TuplesKt.to("retry", Integer.valueOf(r10));     // Catch: Exception -> L8
        r6[8] = TuplesKt.to("offset_size", Long.valueOf(h));     // Catch: Exception -> L8
        r6[9] = TuplesKt.to("append_size", Long.valueOf(r2));     // Catch: Exception -> L8
        r6[10] = TuplesKt.to("pull_rate", r4);     // Catch: Exception -> L8
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_get_result", MapsKt.mapOf(r6), false, 12);     // Catch: Exception -> L8
        return;
    L5:
        r7 = "L";
    L8:
        e = move-exception;
        g49.d.b("LogEventReporter", "onGetLogResult error " + e);
    }

    public static void b(int r3, int r4, int r5) {
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_clear_log_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r3)), TuplesKt.to("side", Integer.valueOf(r4)), TuplesKt.to("type", a(r5))}), false, 12);
    }

    public static void f(int r3, int r4, long r5) {
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_upload_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r3)), TuplesKt.to("size", Integer.valueOf(r4)), TuplesKt.to("duration", Long.valueOf(r5))}), false, 12);
    }
}
