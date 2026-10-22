package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h implements DialogInterface.OnClickListener {
    public final /* synthetic */ i a;

    public h(i r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        r1.dismiss();
        i r3 = this.a;
        if (r3 == null) goto L6;
        r3.onCancelClick();
        return;
    }
}
