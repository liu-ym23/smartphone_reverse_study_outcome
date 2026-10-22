package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class o0 implements mcc.c {
    public final /* synthetic */ TextContentBlock a;
    public final /* synthetic */ y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> b;

    public o0(TextContentBlock r1, y6b.a<com.ss.android.lark.chat.base.view.vo.message.e> r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void i(View r2, AtUserGroupInfo r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "info");
        com.ss.android.lark.chat.chatwindow.chat.v2.push.w.a(this.a.g()).E().H8(this.a.getContext(), r3);
        int r4 = f3b.c.a;
        f3b.c.b(this.a.g(), this.b, r3);
    }
}
