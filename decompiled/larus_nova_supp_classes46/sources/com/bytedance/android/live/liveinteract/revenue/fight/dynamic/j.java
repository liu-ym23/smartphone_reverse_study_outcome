package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public j(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        DynamicTeamFightWidget r4 = this.a;
        if (r4.k == true) goto L11;
        if (r3 == null) goto L10;
        sh0.l r5 = (sh0.l) r3;
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d r6 = r4.f;
        if (r6 == null) goto L8;
        r6.a(r5);
    L8:
        this.a.k = true;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.plantform.store.TalkRoomActions.CommonPlayModeViewAttachInfo");
    }
}
