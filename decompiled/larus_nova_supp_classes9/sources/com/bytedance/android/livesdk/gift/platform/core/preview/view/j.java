package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j implements DialogInterface.OnClickListener {
    public static final j a = null;

    static {
        a = new j();
    }

    public j() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
