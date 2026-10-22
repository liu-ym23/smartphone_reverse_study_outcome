package com.larus.dora.impl.log.g;

import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static int a;
    public static long b;
    public static long c;
    public static long d;
    public static long e;
    public static long f;

    static {
    }

    public static void a(int r4) {
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_stop_fetch", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r4)), TuplesKt.to("type", Integer.valueOf(a))}), false, 12);
    }

    public static void b(int r5, long r6) {
        DoraBuryPointManager.J(DoraBuryPointManager.a, "log_upload_result", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r5)), TuplesKt.to("size", Long.valueOf(b)), TuplesKt.to("duration", Long.valueOf(r6))}), false, 12);
    }
}
