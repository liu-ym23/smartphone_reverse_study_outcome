package com.ss.android.lark.flow.chat.page.flow;

import android.graphics.Point;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.m;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements e6b.b.a<y6b.a<?>, h3b.b> {
    public final /* synthetic */ h4b.c.a a;

    public b(com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.render.c r1) {
        this.a = r1;
    }

    public final void d(m r2, Object r3) {
        h3b.b r4 = (h3b.b) r2;
        y6b.c r5 = (y6b.a) r3;
        Intrinsics.checkNotNullParameter(r4, "cell");
        Intrinsics.checkNotNullParameter(r5, "data");
        h4b.c.a r0 = this.a;
        y6b.c r6 = r5;
        BlueprintCellViewHolder r7 = ((BlueprintCell) r4).h;
        if (r7 == null) goto L6;
        r0.b(r6, r7.getLayoutPosition());
        return;
    }

    public final boolean c(m r4, Object r5, Point r6) {
        h3b.b r7 = (h3b.b) r4;
        y6b.c r8 = (y6b.a) r5;
        Intrinsics.checkNotNullParameter(r7, "cell");
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r6, "touchEventOnWindow");
        return this.a.a(r8, new com.ss.android.lark.chat.message.menu.context.a(r7, r8, r6));
    }

    public final void h(m r4, Object r5, Point r6) {
        h3b.b r7 = (h3b.b) r4;
        y6b.c r8 = (y6b.a) r5;
        Intrinsics.checkNotNullParameter(r7, "cell");
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r6, "touchEventOnWindow");
        this.a.c(r8, new com.ss.android.lark.chat.message.menu.context.a(r7, r8, r6));
    }
}
