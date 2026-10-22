package com.bytedance.android.live.broadcastgame.opengame.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements DialogInterface.OnClickListener {
    public static final o a = null;

    static {
        a = new o();
    }

    public o() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
