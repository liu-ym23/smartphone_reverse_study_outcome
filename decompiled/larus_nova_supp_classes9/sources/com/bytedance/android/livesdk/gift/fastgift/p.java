package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p implements DialogInterface.OnDismissListener {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        com.bytedance.android.livesdk.e.b().d();
    }
}
