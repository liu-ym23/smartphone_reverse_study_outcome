package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ h0 a;

    public g0(h0 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        h0 r3 = this.a;
        if (r3.b == true) goto L6;
        h0.j(r3);
        return;
    }
}
