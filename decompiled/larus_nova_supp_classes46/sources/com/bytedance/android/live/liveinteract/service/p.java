package com.bytedance.android.live.liveinteract.service;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p implements DialogInterface.OnClickListener {
    public static final p a = null;

    static {
        a = new p();
    }

    public p() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        com.bytedance.android.live.liveinteract.linkpanel.util.o.E(null, "cancel");
    }
}
