package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.text;

import android.view.View;
import com.ss.android.lark.chatbase.view.TextChatView2;
import g3b.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ u a;
    public final /* synthetic */ BaseTextContentRender b;

    public b(u r1, TextChatView2 r2, BaseTextContentRender r3) {
        this.a = r1;
        this.b = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        u r0 = this.a;
        if (r0 == null) goto L7;
        Function1<? super View, Unit> r1 = r0.d.a;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r3);
        r1.invoke(r3);
        return;
    L7:
        BaseTextContentRender r2 = this.b;
        BaseTextContentRender.b r4 = r2.d;
        if (r4 == null) goto L14;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text.a r5 = r4.b(r2.b);
        if (r5 == null) goto L15;
        r5.onClick(r3);
        return;
    L15:
        return;
    }
}
