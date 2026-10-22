package com.bytedance.android.live.liveinteract.voicechat.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class s implements DialogInterface.OnClickListener {
    public static final s a = null;

    static {
        a = new s();
    }

    public s() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
