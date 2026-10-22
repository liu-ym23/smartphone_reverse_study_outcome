package com.bytedance.android.livesdk.chatroom.ui.record;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ e a;

    public d(e r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        e r7 = this.a;
        long r0 = r7.f;
        if (r0 < 4000) goto L5;
    L7:
        r7.g = r0;
        PopupWindowLancet.handleDismissBeforeOrigin(r7);
        r7.dismiss();
        return;
    L5:
        if (r0 == 0) goto L7;
        f2.c(r7.getContext().getString(2131919850, new Object[]{3}), 0);
    }
}
