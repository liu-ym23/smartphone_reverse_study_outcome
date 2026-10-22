package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class r3 implements DialogInterface.OnClickListener {
    public static final r3 a = null;

    static {
        a = new r3();
    }

    public r3() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.cancel();
    }
}
