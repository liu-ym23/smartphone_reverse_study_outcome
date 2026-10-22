package com.bytedance.android.live.openplatform.impl.miniappanchor.coupon;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a implements Action {
    public final /* synthetic */ AnchorCouponContextService a;
    public final /* synthetic */ Disposable b;
    public final /* synthetic */ int c;

    public a(AnchorCouponContextService r1, Disposable r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void run() {
        this.b.dispose();
        this.a.a.put(Integer.valueOf(this.c), null);
    }
}
