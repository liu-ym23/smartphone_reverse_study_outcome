package com.bytedance.android.livesdk.interactivity.api.chatchannel.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v implements DialogInterface.OnClickListener {
    public static final v a = null;

    static {
        a = new v();
    }

    public v() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
