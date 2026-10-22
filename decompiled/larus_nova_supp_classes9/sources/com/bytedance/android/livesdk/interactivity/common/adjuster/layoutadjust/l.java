package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust;

import com.bytedance.android.livesdk.config.nl0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.gamelive.PadGameAudienceHeightPublicScreenAdjustStrategy;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.VideoChorusHeightStateManager;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.p3;
import r52.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements f {
    public l() {
        g.a r0 = g.a;
        com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.f r1 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.f.i;
        String r2 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.f.class.getSimpleName();
        r0.getClass();
        g.a.a(r2, r1);
        com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.g r3 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.g.g;
        g.a.a(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.g.class.getSimpleName(), r3);
        com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.e r4 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.e.i;
        g.a.a(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.e.class.getSimpleName(), r4);
        if (((Boolean) nl0.a.getValue()).booleanValue() == false) goto L6;
        com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.a r5 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.a.g;
        g.a.a(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.a.class.getSimpleName(), r5);
    L6:
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L9;
        VideoChorusHeightStateManager r6 = VideoChorusHeightStateManager.e;
        g.a.a(VideoChorusHeightStateManager.class.getSimpleName(), r6);
    L9:
        if (((Boolean) p3.a.getValue()).booleanValue() == false) goto L12;
        h.a r7 = h.b;
        int r8 = g72.a.c;
        r7.getClass();
        g72.a r9 = g72.a.h;
        Intrinsics.checkNotNullParameter("BottomMarginPostProcessor", "key");
        Intrinsics.checkNotNullParameter(r9, "postHeightProcessor");
        ((HashMap) h.a.a).put("BottomMarginPostProcessor", r9);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.f
    public final List a(LiveRoomEnvStateHolder r2, LiveRoomEnvStateHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "userIdentityProvider");
        Intrinsics.checkNotNullParameter(r3, "roomType");
        if (r2.isAnchor() == false) goto L9;
        if (r3.x() == false) goto L17;
        return CollectionsKt.listOf(new i[]{h72.c.d, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.b.f});
    L17:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.e.c);
    L9:
        if (r3.V() == false) goto L12;
        return CollectionsKt.listOf(l72.c.c);
    L12:
        if (PadConfigUtils.c() == false) goto L15;
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.f.c);
    L15:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.e.c);
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.f
    public final List b(LiveRoomEnvStateHolder r2, LiveRoomEnvStateHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "userIdentityProvider");
        Intrinsics.checkNotNullParameter(r3, "roomType");
        if (r2.isAnchor() == false) goto L15;
        if (r3.x() == false) goto L8;
        return CollectionsKt.listOf(new h72.a());
    L8:
        if (r3.j0() == false) goto L31;
        if (PublicScreenStyleHelper.n == false) goto L30;
        return CollectionsKt.listOf(k72.b.d);
    L30:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.e);
    L31:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.e);
    L15:
        if (r3.V() == false) goto L18;
        return CollectionsKt.listOf(l72.b.f);
    L18:
        if (r3.isMediaRoom() == false) goto L21;
        return CollectionsKt.listOf(j72.b.d);
    L21:
        if (r3.J() == false) goto L24;
        return CollectionsKt.listOf(PadGameAudienceHeightPublicScreenAdjustStrategy.h);
    L24:
        if (r3.x() == false) goto L27;
        return CollectionsKt.listOf(new h72.a());
    L27:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.d.e);
    }
}
