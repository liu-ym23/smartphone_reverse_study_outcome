package com.bytedance.android.live.liveinteract.revenue.battle;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class q extends com.bytedance.android.live.liveinteract.revenuebase.f {
    @Override // com.bytedance.android.live.liveinteract.revenuebase.f, ne0.e
    public final void f() {
        DataCenter r0 = this.a;
        int r1 = ji0.j.a;
        r0.put("guest_battle_is_showing", Boolean.valueOf(GuestBattleContext.Companion.e()));
    }

    public q(LifecycleOwner r2) {
        Intrinsics.checkNotNullParameter(r2, "lifecycleOwner");
        super(r2);
    }
}
