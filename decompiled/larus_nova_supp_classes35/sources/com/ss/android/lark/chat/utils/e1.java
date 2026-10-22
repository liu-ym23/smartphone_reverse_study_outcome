package com.ss.android.lark.chat.utils;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e1 extends h7b.n {
    public final /* synthetic */ f1.a c;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r1) {
        f1.a r2 = this.c;
        if (r2 == null) goto L6;
        r2.o1();
        return;
    }

    public e1(Context r1, com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.y r2) {
        this.c = r2;
        super(r1);
    }
}
