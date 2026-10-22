package com.bytedance.android.livesdk.chatroom.viewmodule;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements DialogInterface.OnDismissListener {
    public final /* synthetic */ AnchorStickerWrapperWidget.c a;

    public a(AnchorStickerWrapperWidget.c r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        AnchorStickerWrapperWidget r3 = this.a.b;
        r3.x = false;
        if (r3.y == false) goto L5;
        r3.vd();
        AnchorStickerWrapperWidget r4 = this.a.b;
        com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.a(r4.i, r4.z);
        AnchorStickerWrapperWidget r5 = this.a.b;
        com.bytedance.android.livesdk.chatroom.ui.livesticker.utils.a.a(r5.i, r5.A);
    L5:
        AnchorStickerWrapperWidget r6 = this.a.b;
        r6.z = null;
        r6.A = null;
    }
}
