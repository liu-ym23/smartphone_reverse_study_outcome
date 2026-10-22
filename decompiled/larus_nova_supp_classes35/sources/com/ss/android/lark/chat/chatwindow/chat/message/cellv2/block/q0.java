package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q0 implements mcc.l {
    public final /* synthetic */ TextContentBlock a;

    public final void b(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
    }

    public q0(TextContentBlock r1) {
        this.a = r1;
    }

    public final void a(View r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "phoneNumber");
        ((w4b.c.h) this.a.g.getValue()).a(this.a.getContext(), r3);
    }
}
