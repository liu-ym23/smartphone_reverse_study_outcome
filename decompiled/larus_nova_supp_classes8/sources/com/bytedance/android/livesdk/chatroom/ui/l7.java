package com.bytedance.android.livesdk.chatroom.ui;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l7 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ LiveProfileManageDialogV2 a;

    public l7(LiveProfileManageDialogV2 r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        if (this.a.f == null) goto L6;
        com.bytedance.android.livesdk.f.d().f();
        this.a.f = null;
        return;
    }
}
