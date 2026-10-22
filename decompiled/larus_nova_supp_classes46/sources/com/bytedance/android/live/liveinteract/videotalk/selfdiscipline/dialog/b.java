package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements DialogInterface.OnClickListener {
    public static final b a = null;

    static {
        a = new b();
    }

    public b() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
