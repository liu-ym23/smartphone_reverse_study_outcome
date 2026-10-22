package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import com.bytedance.android.live.liveinteract.plantform.utils.OpenPanelSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public e(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "store");
        if (r3 != null) goto L5;
        return;
    L5:
        mi0.b r4 = (mi0.b) r3;
        if ((!Intrinsics.areEqual(r4.b, OpenPanelSource.LINK_PLAYMODE_PANEL.getValue())) == false) goto L8;
        li0.b r5 = li0.b.b;
        li0.b.g(r4.a, r4.b);
    L8:
        this.a.d3(r4.a);
    }
}
