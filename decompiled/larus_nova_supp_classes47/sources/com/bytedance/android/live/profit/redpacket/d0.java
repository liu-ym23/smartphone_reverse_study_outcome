package com.bytedance.android.live.profit.redpacket;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d0 implements Action {
    public final /* synthetic */ xr2.h a;

    public d0(xr2.h r1) {
        this.a = r1;
    }

    public final void run() {
        this.a.clearAnimators();
    }
}
