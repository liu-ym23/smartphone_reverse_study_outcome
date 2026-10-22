package com.bytedance.android.livesdk.coupon.customview;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements DialogInterface.OnDismissListener {
    public final /* synthetic */ UgCouponGoodsNewDialog a;

    public f(UgCouponGoodsNewDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        UgCouponGoodsNewDialog r3 = this.a;
        Disposable r0 = r3.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        r3.b = null;
    }
}
