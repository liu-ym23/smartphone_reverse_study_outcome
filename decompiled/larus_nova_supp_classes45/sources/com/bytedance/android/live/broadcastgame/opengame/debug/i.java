package com.bytedance.android.live.broadcastgame.opengame.debug;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements DialogInterface.OnClickListener {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
