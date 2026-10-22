package com.bytedance.android.live.recharge.balance;

import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a extends BDNetworkTagContextProviderAdapter {
    public final /* synthetic */ f a;

    public final int triggerType() {
        return !Intrinsics.areEqual("enter_room", this.a.b) ? 1 : 0;
    }

    public a(f r1) {
        this.a = r1;
    }
}
