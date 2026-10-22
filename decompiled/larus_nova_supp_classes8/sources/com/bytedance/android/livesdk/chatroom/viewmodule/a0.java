package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a0 implements DialogInterface.OnDismissListener {
    public static final a0 a = null;

    static {
        a = new a0();
    }

    public a0() {
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        com.bytedance.android.livesdk.f.d().f();
    }
}
