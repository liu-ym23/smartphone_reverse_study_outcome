package com.bytedance.android.live.effect.avadjust;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j implements DialogInterface.OnClickListener {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L5;
        r1.dismiss();
        return;
    }
}
