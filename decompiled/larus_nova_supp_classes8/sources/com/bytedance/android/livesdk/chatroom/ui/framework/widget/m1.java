package com.bytedance.android.livesdk.chatroom.ui.framework.widget;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m1 implements DialogInterface.OnClickListener {
    public static final m1 a = null;

    static {
        a = new m1();
    }

    public m1() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
