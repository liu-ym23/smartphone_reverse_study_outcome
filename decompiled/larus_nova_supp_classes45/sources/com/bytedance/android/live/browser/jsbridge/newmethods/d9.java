package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d9 implements DialogInterface.OnClickListener {
    public final /* synthetic */ f9 a;

    public d9(f9 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        this.a.finishWithFailure();
    }
}
