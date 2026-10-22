package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view;

import android.view.View;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnLayoutChangeListener {
    public final /* synthetic */ Function0<MessageFullScreenRichTextSetup.c> a;

    public l(Function0<MessageFullScreenRichTextSetup.c> r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if ((r5 - r3) == (r9 - r7)) goto L6;
        this.a.invoke();
        return;
    }
}
