package com.ss.android.lark.chat.utils;

import android.text.style.ClickableSpan;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d1 extends ClickableSpan {
    public final /* synthetic */ f1.a a;
    public final /* synthetic */ String b;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        f1.a r3 = this.a;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }

    public d1(com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.y r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
