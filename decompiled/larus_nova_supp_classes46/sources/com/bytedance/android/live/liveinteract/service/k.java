package com.bytedance.android.live.liveinteract.service;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k implements DialogInterface.OnClickListener {
    public static final k a = null;

    static {
        a = new k();
    }

    public k() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
