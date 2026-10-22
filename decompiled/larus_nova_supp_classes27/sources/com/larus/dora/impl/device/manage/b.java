package com.larus.dora.impl.device.manage;

import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    static {
    }

    public static void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "cardType");
        Intrinsics.checkNotNullParameter(r4, "cardContentType");
        g49.d.d("DoraDeviceManagementTracker", "reportCardShow: cardType=" + r3 + ", cardContentType=" + r4);
        DoraBuryPointManager.a.L("dora_card_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", r3), TuplesKt.to("card_content_type", r4)}));
    }

    public static void a(String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "cardType");
        Intrinsics.checkNotNullParameter(r4, "cardContentType");
        Intrinsics.checkNotNullParameter(r5, "actionType");
        g49.d.d("DoraDeviceManagementTracker", "reportCardClick: cardType=" + r3 + ", cardContentType=" + r4 + ", actionType=" + r5);
        DoraBuryPointManager.a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", r3), TuplesKt.to("card_content_type", r4), TuplesKt.to("button_type", r5)}));
    }
}
