package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.view.View;
import g3b.u;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ TextClickListenerProviderV2 a;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;

    public a(TextClickListenerProviderV2 r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        u r0 = (u) this.a.a.d0(u.class);
        if (r0 == null) goto L7;
        Function1<? super View, Unit> r1 = r0.d.a;
        if (r1 == null) goto L7;
        Intrinsics.checkNotNull(r3);
        r1.invoke(r3);
        return;
    L7:
        TextClickListenerProviderV2 r4 = this.a;
        y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2 = this.b;
        TextClickListenerProviderV2.a r5 = r4.c;
        if (r5 == null) goto L12;
        r5.b(r2);
        return;
    }
}
