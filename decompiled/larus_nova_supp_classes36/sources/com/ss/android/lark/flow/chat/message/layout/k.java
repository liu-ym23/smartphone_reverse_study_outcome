package com.ss.android.lark.flow.chat.message.layout;

import android.graphics.Point;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements View.OnLongClickListener {
    public final /* synthetic */ i a;
    public final /* synthetic */ y6b.a<?> b;

    public k(i r1, y6b.a<?> r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        Point r5 = this.a.i();
        i3b.a r0 = ((com.ss.android.lark.blueprint.a) this.a).a.c.a(i3b.a.class);
        if (r0 == null) goto L5;
        h3b.b r1 = ((com.ss.android.lark.blueprint.a) this.a).b;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.message.cellv2.cell.IMBlueprintCell");
        return r0.c(r1, this.b, r5);
    L5:
        return false;
    }
}
