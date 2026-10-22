package com.bytedance.android.livesdk.coupon.customview;

import android.content.DialogInterface;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n implements DialogInterface.OnCancelListener {
    public final /* synthetic */ h a;

    public n(h r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r2) {
        this.a.d.onClose();
        h r3 = this.a;
        Disposable r0 = r3.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        r3.b = null;
    }
}
