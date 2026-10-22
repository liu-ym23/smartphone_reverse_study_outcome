package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render;

import android.graphics.Point;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements y5b.a {
    public final /* synthetic */ MessageListRendererFeature a;

    public final Class<? extends com.ss.android.lark.blueprint.p> c() {
        return y5b.a.class;
    }

    public d(MessageListRendererFeature r1) {
        this.a = r1;
    }

    @Override // y5b.a
    public final void e(y6b.a<?> r5, com.ss.android.lark.blueprint.m<y6b.a<?>> r6, List<yya.k> r7) {
        Intrinsics.checkNotNullParameter(r5, "messageVO");
        Intrinsics.checkNotNullParameter(r6, "cell");
        Intrinsics.checkNotNullParameter(r7, "messageActionList");
        com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.menu.a r0 = this.a.J();
        if (r0 != null) goto L5;
        return;
    L5:
        y6b.c r2 = null;
        if ((r6 instanceof h3b.b) == false) goto L8;
        h3b.b r1 = (h3b.b) r6;
    L9:
        if (r1 != null) goto L11;
        return;
    L11:
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r3 = r1.l();
        if ((r3 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g) == false) goto L14;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.g r4 = r3;
    L15:
        if (r4 == null) goto L18;
        Point r8 = r4.i();
        if (r8 == null) goto L18;
    L19:
        com.ss.android.lark.chat.message.menu.context.a r9 = new com.ss.android.lark.chat.message.menu.context.a((h3b.b) r6, r5, r8);
        if ((r5 instanceof y6b.c) == false) goto L22;
        r2 = (y6b.c) r5;
    L22:
        if (r2 != null) goto L24;
        return;
    L24:
        r0.u(r2, r9, r7);
        return;
    L18:
        r8 = new Point();
        goto L19
    L14:
        r4 = null;
        goto L15
    L8:
        r1 = null;
        goto L9
    }
}
