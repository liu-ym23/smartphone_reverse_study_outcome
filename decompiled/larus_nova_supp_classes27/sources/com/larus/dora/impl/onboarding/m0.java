package com.larus.dora.impl.onboarding;

import com.larus.dora.impl.DoraBuryPointManager;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class m0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public m0() {
    }

    public static void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "contentType");
        DoraBuryPointManager.a.L("dora_card_show", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "dora_onboarding"), TuplesKt.to("card_content_type", r4)}));
    }

    public static void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r5, "contentType");
        DoraBuryPointManager.a.L("dora_card_click", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "dora_onboarding"), TuplesKt.to("card_content_type", r5), TuplesKt.to("action_type", r4)}));
    }

    public static void c(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "contentType");
        DoraBuryPointManager.a.L("dora_card_stay_time", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "dora_onboarding"), TuplesKt.to("card_content_type", r4), TuplesKt.to("is_over_time", Boolean.FALSE), TuplesKt.to("duration", Long.valueOf(r5))}));
    }

    public static void g(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "page");
        g49.d.d("DoraOnboardingTracker", "reportOnboardingPageShow: " + r4);
        Pair[] r0 = new Pair[3];
        boolean r2 = false;
        r0[0] = TuplesKt.to("card_type", "dora_onboarding");
        r0[1] = TuplesKt.to("card_content_type", r4);
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0[2] = TuplesKt.to("content_source", r5);
        Map r7 = MapsKt.mutableMapOf(r0);
        if (r6 != null) goto L8;
    L15:
        DoraBuryPointManager.a.L("dora_card_show", r7);
        return;
    L8:
        if (r6.length() <= 0) goto L10;
        r2 = true;
    L10:
        if (r2 == true) goto L13;
        r6 = null;
    L13:
        if (r6 == null) goto L15;
        r7.put("card_content_type", r6);
        goto L15
    }

    public static void h(String r4, long r5, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "page");
        g49.d.d("DoraOnboardingTracker", "reportOnboardingPageStay: " + r4 + ", " + r5 + "ms, " + r7);
        DoraBuryPointManager.a.L("dora_card_stay_time", MapsKt.mapOf(new Pair[]{TuplesKt.to("card_type", "dora_onboarding"), TuplesKt.to("card_content_type", r4), TuplesKt.to("duration", Long.valueOf(r5)), TuplesKt.to("is_over_time", Integer.valueOf(r7 ? 1 : 0))}));
    }

    public static void d(boolean r4, a r5, long r6, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r5, "reason");
        DoraBuryPointManager r1 = DoraBuryPointManager.a;
        Pair[] r2 = new Pair[6];
        r2[0] = TuplesKt.to("reason", r5.a);
        if (r4 == false) goto L5;
        int r7 = 1;
    L6:
        r2[1] = TuplesKt.to("result", Integer.valueOf(r7));
        r2[2] = TuplesKt.to("t1", Long.valueOf(r6));
        r2[3] = TuplesKt.to("t2", Long.valueOf(r8));
        r2[4] = TuplesKt.to("t3", Long.valueOf(r10));
        r2[5] = TuplesKt.to("duration", Long.valueOf((r6 + r8) + r10));
        r1.L("d_device_auth", MapsKt.mapOf(r2));
        return;
    L5:
        r7 = 2;
        goto L6
    }

    public static void e(String r4, String r5, String r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r4, "page");
        Intrinsics.checkNotNullParameter(r5, "button");
        g49.d.d("DoraOnboardingTracker", "reportOnboardingBtnClick: " + r4 + ", " + r5);
        Pair[] r0 = new Pair[4];
        boolean r2 = false;
        r0[0] = TuplesKt.to("card_type", "dora_onboarding");
        r0[1] = TuplesKt.to("card_content_type", r4);
        r0[2] = TuplesKt.to("action_type", r5);
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        r0[3] = TuplesKt.to("content_source", r6);
        Map r9 = MapsKt.mutableMapOf(r0);
        if (r7 != null) goto L8;
    L16:
        if (r8 != null) goto L18;
    L25:
        DoraBuryPointManager.a.L("dora_card_click", r9);
        return;
    L18:
        if (r8.length() <= 0) goto L20;
        r2 = true;
    L20:
        if (r2 == true) goto L23;
        r8 = null;
    L23:
        if (r8 == null) goto L25;
        r9.put("click_text", r8);
        goto L25
    L8:
        if (r7.length() <= 0) goto L10;
        boolean r10 = true;
    L11:
        if (r10 == true) goto L14;
        r7 = null;
    L14:
        if (r7 == null) goto L16;
        r9.put("card_content_type", r7);
        goto L16
    L10:
        r10 = false;
        goto L11
    }

    public static /* synthetic */ void f(String r1, String r2, String r3, String r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r3 = "";
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = null;
    L8:
        e(r1, r2, r3, r4, null);
    }
}
