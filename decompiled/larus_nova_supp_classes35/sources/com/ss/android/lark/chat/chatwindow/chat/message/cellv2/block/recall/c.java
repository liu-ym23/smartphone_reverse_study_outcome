package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.recall;

import android.content.Context;
import android.view.View;
import b3b.d;
import b3b.f;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import h7b.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends n {
    public final /* synthetic */ RecalledSystemContentBlock c;
    public final /* synthetic */ v5b.a<?> d;
    public final /* synthetic */ y6b.a<v5b.a<?>> e;

    @Override // android.text.style.ClickableSpan
    public final void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "widget");
        f r3 = this.c.d;
        if ((r3 instanceof d) == true) goto L7;
        r3 = null;
    L7:
        if ((this.d instanceof BaseTextContentVO) == false) goto L11;
        if (r3 == null) goto L12;
        r3.K6(this.e);
        return;
    L12:
        return;
    }

    public c(RecalledSystemContentBlock r1, v5b.a r2, y6b.a r3, Context r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        super(r4, 2131106620);
    }
}
