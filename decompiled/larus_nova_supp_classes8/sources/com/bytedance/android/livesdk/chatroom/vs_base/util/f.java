package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f implements DialogInterface.OnClickListener {
    public f() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
    }
}
