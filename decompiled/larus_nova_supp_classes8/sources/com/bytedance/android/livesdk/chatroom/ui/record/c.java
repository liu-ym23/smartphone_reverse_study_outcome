package com.bytedance.android.livesdk.chatroom.ui.record;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        b r2 = this.a;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
    }
}
