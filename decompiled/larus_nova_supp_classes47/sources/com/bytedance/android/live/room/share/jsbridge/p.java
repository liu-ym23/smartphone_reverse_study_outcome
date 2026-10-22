package com.bytedance.android.live.room.share.jsbridge;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class p implements DialogInterface.OnClickListener {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L5;
        r1.dismiss();
        return;
    }
}
