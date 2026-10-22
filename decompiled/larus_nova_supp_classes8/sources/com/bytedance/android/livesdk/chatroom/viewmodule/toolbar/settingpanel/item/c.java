package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.settingpanel.item;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.SmallWindowQuestionCircleDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c implements View.OnClickListener {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        SmallWindowQuestionCircleDialog r0 = new SmallWindowQuestionCircleDialog(r2.getContext());
        if (DialogLancet.shouldBlockDialogShow(r0) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r0);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r0);
        r0.show();
        DialogLancet.afterDialogShow(r0);
    }
}
