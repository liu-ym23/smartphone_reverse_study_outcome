package com.bytedance.android.live.broadcastgame.xplay;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v0 implements DialogInterface.OnClickListener {
    public static final v0 a = null;

    static {
        a = new v0();
    }

    public v0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
