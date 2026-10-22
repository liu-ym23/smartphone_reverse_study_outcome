package com.bytedance.android.live.effect.beauty.smallitem;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 implements DialogInterface.OnClickListener {
    public static final d0 a = null;

    static {
        a = new d0();
    }

    public d0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        if (r1 == null) goto L5;
        r1.dismiss();
        return;
    }
}
