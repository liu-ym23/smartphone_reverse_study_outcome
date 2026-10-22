package com.bytedance.android.livesdk.gift.fastgift;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class s implements DialogInterface.OnDismissListener {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        com.bytedance.android.livesdk.e.b().d();
    }
}
