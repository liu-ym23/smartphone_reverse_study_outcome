package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import com.larksuite.component.ui.toast.LKUIToast;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements Runnable {
    public final /* synthetic */ MediaContentBlock a;

    public r(MediaContentBlock r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        LKUIToast.show(this.a.c.getContext(), 2131891433);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
