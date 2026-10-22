package com.bytedance.android.livesdk.gift.platform.core.ui.configuration;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements DialogInterface.OnClickListener {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
