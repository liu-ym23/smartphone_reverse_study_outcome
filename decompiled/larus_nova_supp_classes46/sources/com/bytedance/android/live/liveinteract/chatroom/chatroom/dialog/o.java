package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ LinkResultDialogFragment a;

    public o(LinkResultDialogFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((hk0.b) r2).a == true) goto L5;
        return;
    L5:
        if (this.a.isShowing() == true) goto L14;
        return;
    L14:
        this.a.dismiss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r3 = DialogFragmentLancet.sLastShowStack;
        if (r3 == null) goto L18;
        com.bytedance.crash.d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
