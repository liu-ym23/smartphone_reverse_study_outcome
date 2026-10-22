package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.livesdk.closeroom.CloseRoomInterceptList;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a4 implements kf1.a {
    public final /* synthetic */ AbsInteractionFragment a;

    public final String tag() {
        return "AbsInteractionFragment_QuitWithTask";
    }

    public final CloseRoomInterceptList config() {
        return CloseRoomInterceptList.DEFAULT;
    }

    public a4(AbsInteractionFragment r1) {
        this.a = r1;
    }

    public final boolean qa(Runnable r3, boolean r4) {
        if (this.a.q != null) goto L5;
        return false;
    L5:
        if (l8.c() == false) goto L20;
        m8 r5 = new m8(this.a.getContext(), this.a.M, r3);
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r5);
        return true;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L16
    L11:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return true;
    L20:
        return false;
    }
}
