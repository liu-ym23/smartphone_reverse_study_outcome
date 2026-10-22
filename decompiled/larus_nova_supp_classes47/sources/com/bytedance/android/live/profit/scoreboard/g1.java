package com.bytedance.android.live.profit.scoreboard;

import com.bytedance.android.livesdk.message.model.k7;
import io.reactivex.SingleSource;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g1<V> implements Callable {
    public final /* synthetic */ r0 a;
    public final /* synthetic */ k7 b;

    public g1(r0 r1, k7 r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final SingleSource<? extends Boolean> call() {
        k7 r0 = this.b;
        xp2.e r7 = new xp2.e((int) r0.getInteractType(), r0.getTitle(), r0.getDesc(), r0.getIcon(), r0.getExtra());
        com.bytedance.android.livesdk.revenue.service.broadcast.a r1 = this.a.d;
        xp2.g r2 = r1.X6(r7);
        return r1.od(this.a.b.getContext(), this.a.b.getDataCenter(), r2);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
