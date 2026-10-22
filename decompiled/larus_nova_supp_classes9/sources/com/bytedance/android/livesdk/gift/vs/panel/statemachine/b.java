package com.bytedance.android.livesdk.gift.vs.panel.statemachine;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements DialogInterface.OnClickListener {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
