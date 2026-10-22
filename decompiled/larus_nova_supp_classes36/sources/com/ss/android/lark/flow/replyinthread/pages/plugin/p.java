package com.ss.android.lark.flow.replyinthread.pages.plugin;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class p implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ ReplyInThreadTitleBarPlugin b;
    public final /* synthetic */ int c;

    public p(String r1, ReplyInThreadTitleBarPlugin r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        String r0 = this.a;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r2 = null;
        if (r1 == false) goto L15;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r3 = this.b.g;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L13:
        Context r4 = r2.getContext();
        String r5 = this.a;
        Intrinsics.checkNotNull(r5);
        FlowToast.d(r4, r5);
        return;
    L12:
        r2 = r3;
        goto L13
    L15:
        if (this.c == 0) goto L23;
        com.ss.android.lark.chat.chatwindow.chat.v2.component.c r6 = this.b.g;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mChatApp");
    L20:
        FlowToast.c(r2.getContext(), this.c);
        return;
    L19:
        r2 = r6;
        goto L20
    L23:
        return;
    L5:
        if (r0.length() <= 0) goto L7;
        r1 = true;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
