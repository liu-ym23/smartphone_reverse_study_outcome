package com.bytedance.android.livesdk.chatroom.ui.record;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ b a;

    public a(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        b r0 = this.a;
        if (r0.n == false) goto L7;
        View.OnClickListener r1 = r0.m;
        if (r1 == null) goto L7;
        r1.onClick(r3);
    L7:
        b r4 = this.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r4);
        r4.dismiss();
    }
}
