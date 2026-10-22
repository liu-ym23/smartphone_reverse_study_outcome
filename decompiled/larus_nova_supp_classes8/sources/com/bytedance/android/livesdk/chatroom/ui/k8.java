package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k8 implements View.OnClickListener {
    public final /* synthetic */ j8 a;

    public k8(j8 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        j8 r2 = this.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    }
}
