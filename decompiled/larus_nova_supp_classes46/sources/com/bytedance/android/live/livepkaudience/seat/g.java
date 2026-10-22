package com.bytedance.android.live.livepkaudience.seat;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g implements b {
    public SeatAnimTaskState a;
    public d b;

    public g() {
        this.a = SeatAnimTaskState.IDLE;
        this.b = new d();
    }

    @Override // com.bytedance.android.live.livepkaudience.seat.b
    public final void a(SeatAnimTaskState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
    }
}
