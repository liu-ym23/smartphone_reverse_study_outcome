package com.larus.dora.impl.network;

import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        DoraBuryPointManager.J(DoraBuryPointManager.a, "d_device_replace_bond_request", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r4 ? 1 : 0)), TuplesKt.to("reason", r5)}), false, 12);
    }

    public static void c(boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        DoraBuryPointManager.J(DoraBuryPointManager.a, "d_device_unbond_request", MapsKt.mapOf(new Pair[]{TuplesKt.to("result", Integer.valueOf(r4 ? 1 : 0)), TuplesKt.to("reason", r5)}), false, 12);
    }

    public static void a(boolean r4, String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        DoraBuryPointManager r1 = DoraBuryPointManager.a;
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to("result", Integer.valueOf(r4 ? 1 : 0));
        r2[1] = TuplesKt.to("reason", r5);
        if (r6 == false) goto L5;
        String r7 = "bindCheck";
    L6:
        r2[2] = TuplesKt.to("scene", r7);
        DoraBuryPointManager.J(r1, "d_device_bond_request", MapsKt.mapOf(r2), false, 12);
        return;
    L5:
        r7 = "bind";
        goto L6
    }
}
