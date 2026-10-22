package com.bytedance.android.live.liveinteract.revenue.fight.dynamic;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements ne0.a {
    public final /* synthetic */ DynamicTeamFightWidget a;

    public d(DynamicTeamFightWidget r1) {
        this.a = r1;
    }

    @Override // ne0.a
    public final void a(ne0.e r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "store");
        this.a.getStore().onDestory();
    }
}
