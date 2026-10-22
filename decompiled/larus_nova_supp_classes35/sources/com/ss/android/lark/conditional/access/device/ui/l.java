package com.ss.android.lark.conditional.access.device.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements DialogInterface.OnClickListener {
    public static final l a = null;

    static {
        a = new l();
    }

    public l() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L5;
        r1.dismiss();
        return;
    }
}
