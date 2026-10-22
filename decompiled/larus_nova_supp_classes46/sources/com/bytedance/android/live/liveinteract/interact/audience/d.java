package com.bytedance.android.live.liveinteract.interact.audience;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements DialogInterface.OnClickListener {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
