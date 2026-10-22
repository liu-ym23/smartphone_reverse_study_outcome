package com.ss.android.lark.conditional.access.device.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements DialogInterface.OnClickListener {
    public static final i a = null;

    static {
        a = new i();
    }

    public i() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L5;
        r1.dismiss();
        return;
    }
}
