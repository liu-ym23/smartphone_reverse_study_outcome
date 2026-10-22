package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo;

import com.bytedance.android.live.network.response.ExtraResponse;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class y<T> implements Consumer {
    public final /* synthetic */ c0 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public y(c0 r1, long r2, long r4, int r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }

    public final void accept(Object r14) {
        ExtraResponse r15 = (ExtraResponse) r14;
        c0 r16 = this.a;
        long r1 = this.b;
        int r4 = this.d;
        int r3 = this.e;
        r16.b.N(r1, r3, r4, r16.c.a());
        com.bytedance.android.livesdk.gift.platform.core.b0.a.d(this.b, this.c, this.d, null);
    }
}
