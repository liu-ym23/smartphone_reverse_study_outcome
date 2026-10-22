package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust;

import com.bytedance.android.livesdk.config.nl0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.CommonAudienceWidthAdjustStrategy;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.gamelive.GameAudienceHeightPublicScreenAdjustStrategy;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.VideoChorusHeightStateManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import r52.p3;
import r52.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements f {
    public m(DataCenter r3) {
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        g.a r4 = g.a;
        com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.d r0 = com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.d.d;
        r4.getClass();
        g.a.a("MultiAnchorHeightStateManager", r0);
        g.a.a("PkHeightPublicScreenManager", com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.h.d);
        g.a.a("EqualTalkHeightStateManager", com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.c.i);
        if (((Boolean) nl0.a.getValue()).booleanValue() == false) goto L6;
        g.a.a("DanmuGameHeightStateManager", com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.a.g);
    L6:
        if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L9;
        g.a.a("VideoChorusHeightStateManager", VideoChorusHeightStateManager.e);
    L9:
        if (((Boolean) p3.a.getValue()).booleanValue() == false) goto L12;
        h.a r5 = h.b;
        int r1 = g72.a.c;
        r5.getClass();
        g72.a r6 = g72.a.h;
        Intrinsics.checkNotNullParameter("BottomMarginPostProcessor", "key");
        Intrinsics.checkNotNullParameter(r6, "postHeightProcessor");
        ((HashMap) h.a.a).put("BottomMarginPostProcessor", r6);
    L12:
        if (vm2.d.c0().getEnable() == false) goto L15;
        g.a.a("DynamicCenterHeightStateManager", com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.unversalstate.b.e);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.f
    public final List a(LiveRoomEnvStateHolder r2, LiveRoomEnvStateHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "userIdentityProvider");
        Intrinsics.checkNotNullParameter(r3, "roomType");
        if (r2.isAnchor() == false) goto L9;
        if (r3.x() == false) goto L11;
        return CollectionsKt.listOf(new i[]{h72.c.d, com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.b.f});
    L11:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.b.f);
    L9:
        return CollectionsKt.listOf(new CommonAudienceWidthAdjustStrategy());
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.f
    public final List b(LiveRoomEnvStateHolder r2, LiveRoomEnvStateHolder r3) {
        Intrinsics.checkNotNullParameter(r2, "userIdentityProvider");
        Intrinsics.checkNotNullParameter(r3, "roomType");
        if (r2.isAnchor() == false) goto L15;
        if (r3.x() == false) goto L8;
        return CollectionsKt.listOf(new h72.a());
    L8:
        if (r3.j0() == false) goto L36;
        if (PublicScreenStyleHelper.n == false) goto L35;
        return CollectionsKt.listOf(k72.c.e);
    L35:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.a.c);
    L36:
        return CollectionsKt.listOf(com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.a.c);
    L15:
        if (r3.V() == false) goto L18;
        return CollectionsKt.listOf(new l72.a());
    L18:
        if (r3.isVSRoom() == false) goto L23;
        if (r3.V() == true) goto L23;
        return CollectionsKt.listOf(new l72.d());
    L23:
        if (r3.isMediaRoom() == false) goto L26;
        return CollectionsKt.listOf(new j72.a());
    L26:
        if (r3.x() == false) goto L29;
        return CollectionsKt.listOf(new h72.a());
    L29:
        if (r3.J() == false) goto L32;
        return CollectionsKt.listOf(new c[]{new GameAudienceHeightPublicScreenAdjustStrategy(), new com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.c()});
    L32:
        return CollectionsKt.listOf(new com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common.c());
    }
}
