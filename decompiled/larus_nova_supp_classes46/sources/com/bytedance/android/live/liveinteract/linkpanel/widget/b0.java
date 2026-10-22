package com.bytedance.android.live.liveinteract.linkpanel.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0 implements DialogInterface.OnClickListener {
    public static final b0 a = null;

    static {
        a = new b0();
    }

    public b0() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
