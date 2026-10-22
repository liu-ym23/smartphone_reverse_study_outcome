package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.view.View;
import com.ss.android.lark.chatbase.view.TextChatView2;
import g3b.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnLongClickListener {
    public final /* synthetic */ u a;
    public final /* synthetic */ BaseTextContentRender b;

    public c(u r1, BaseTextContentRender r2, TextChatView2 r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r6) {
        u r0 = this.a;
        if (r0 == null) goto L5;
        Function1<? super View, Unit> r1 = r0.d.b;
    L7:
        if (r1 == null) goto L12;
        Function1<? super View, Unit> r2 = r0.d.b;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNull(r6);
        r2.invoke(r6);
    L11:
        return true;
    L12:
        BaseTextContentRender r3 = this.b;
        BaseTextContentRender.b r4 = r3.d;
        if (r4 == null) goto L18;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.b r5 = r4.c(r3.b, r3.h(), this.b.i());
        if (r5 == null) goto L20;
        r5.onLongClick(r6);
        return true;
    L20:
        return false;
    L18:
        return false;
    L5:
        r1 = null;
        goto L7
    }
}
