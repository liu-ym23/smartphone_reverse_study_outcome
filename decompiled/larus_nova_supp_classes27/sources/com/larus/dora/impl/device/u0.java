package com.larus.dora.impl.device;

import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class u0 {
    static {
    }

    public static void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "button");
        DoraBuryPointManager.a.L("dora_device_management_click", MapsKt.mapOf(TuplesKt.to("action_type", r2)));
    }
}
