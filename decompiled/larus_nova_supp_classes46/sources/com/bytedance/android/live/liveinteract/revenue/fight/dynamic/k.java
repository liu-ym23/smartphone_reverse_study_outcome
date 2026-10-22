package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.DynamicTeamFightViewManager;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public k(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "store");
        DynamicTeamFightWidget r3 = this.a;
        r3.k = false;
        com.bytedance.android.live.liveinteract.revenue.fight.dynamic.oldteamfight.d r4 = r3.f;
        if (r4 == null) goto L8;
        DynamicTeamFightViewManager r5 = r4.a;
        if (r5 == null) goto L9;
        r5.b("detach");
        r5.k.dispose();
        r5.e.b();
        return;
    L9:
        return;
    }
}
