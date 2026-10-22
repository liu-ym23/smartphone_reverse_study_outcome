package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.DialogInterface;
import com.ss.android.lark.chat.preview.components.view.SpinButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements DialogInterface.OnDismissListener {
    public final /* synthetic */ SpinButton a;

    public k(SpinButton r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r1) {
        this.a.d();
    }
}
