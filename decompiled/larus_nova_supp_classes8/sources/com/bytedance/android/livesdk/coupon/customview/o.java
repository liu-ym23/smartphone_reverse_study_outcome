package com.bytedance.android.livesdk.coupon.customview;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements DialogInterface.OnDismissListener {
    public final /* synthetic */ h a;

    public o(h r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        h r3 = this.a;
        Disposable r0 = r3.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        r3.b = null;
    }
}
