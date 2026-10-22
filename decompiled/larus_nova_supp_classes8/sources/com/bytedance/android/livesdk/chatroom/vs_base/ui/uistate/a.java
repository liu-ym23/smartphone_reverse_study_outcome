package com.bytedance.android.livesdk.chatroom.vs_base.ui.uistate;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.Window;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements DialogInterface.OnShowListener {
    public final /* synthetic */ Dialog a;
    public final /* synthetic */ b b;

    public a(Dialog r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r2) {
        this.b.r(this.a);
        Window r3 = this.a.getWindow();
        if (r3 == null) goto L6;
        r3.clearFlags(8);
        return;
    }
}
