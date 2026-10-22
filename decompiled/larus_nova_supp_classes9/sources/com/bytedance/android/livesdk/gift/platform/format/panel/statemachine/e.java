package com.bytedance.android.livesdk.gift.platform.format.panel.statemachine;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements DialogInterface.OnClickListener {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
