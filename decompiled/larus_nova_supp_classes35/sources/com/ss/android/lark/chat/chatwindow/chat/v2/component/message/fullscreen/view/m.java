package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.view.ViewGroup;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class m implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ MessageFullScreenRichTextSetup a;

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        MessageFullScreenRichTextSetup r0 = this.a;
        if (r0.b == true) goto L5;
        r0.b = true;
    L5:
        MessageFullScreenRichTextSetup.c r1 = r0.d;
        if (r1 == null) goto L12;
        ViewGroup r2 = r1.e;
        if (r2 == null) goto L12;
        ViewTreeObserver r3 = r2.getViewTreeObserver();
        if (r3 == null) goto L12;
        r3.removeOnPreDrawListener(this);
    L12:
        return true;
    }

    public m(MessageFullScreenRichTextSetup r1) {
        this.a = r1;
    }
}
