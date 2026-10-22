package com.larus.dora.obric.onboarding;

import com.larus.dora.impl.DoraBuryPointManager;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void b(String r6) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.length() <= 0) goto L6;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L10;
        r6 = null;
    L10:
        if (r6 == null) goto L15;
        g49.d.d("ObricDoraOnboardingTracker", "trackQueryInterrupt: conversationId=".concat(r6));
        DoraBuryPointManager.a.L("obric_onboarding_query_interrupt", MapsKt.mapOf(new Pair[]{TuplesKt.to("interrupt_method", "single_click"), TuplesKt.to("conversation_id", r6)}));
        return;
    L15:
        return;
    L6:
        r0 = false;
        goto L7
    }

    public static void a(String r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "cardContentType");
        Intrinsics.checkNotNullParameter(r7, "actionType");
        if (r6.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r7.length() != 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L16;
        g49.d.d("ObricDoraOnboardingTracker", "trackCardClick: cardContentType=" + r6 + ", actionType=" + r7);
        DoraBuryPointManager.a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "dora_onboarding"), TuplesKt.to("card_content_type", r6), TuplesKt.to("action_type", r7)}));
        return;
    L16:
        return;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }
}
