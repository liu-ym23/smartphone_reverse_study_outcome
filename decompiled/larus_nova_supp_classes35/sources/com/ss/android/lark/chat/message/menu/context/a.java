package com.ss.android.lark.chat.message.menu.context;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.blueprint.BlueprintCell;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.e;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.n;
import yya.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements n, o {
    public final h3b.b a;
    public final y6b.a<?> b;
    public final Point c;

    public final LKUILightTextView e() {
        if (CollectionsKt.listOf(new Message.Type[]{Message.Type.TEXT, Message.Type.POST, Message.Type.DOUBAO, Message.Type.AUDIO}).contains(this.b.getType()) == true) goto L5;
        return null;
    L5:
        View r0 = ((BlueprintCell) this.a).g;
        if (r0 != null) goto L8;
        return null;
    L8:
        return g(r0);
    }

    public final View a() {
        View r0 = ((BlueprintCell) this.a).g;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalStateException("rootView is null".toString());
    }

    public final int b() {
        xza.a r0 = this.a;
        BlueprintCellViewHolder r2 = null;
        if ((r0 instanceof xza.a) == true) goto L6;
        r0 = null;
    L6:
        if (r0 == null) goto L8;
        r2 = r0.i();
    L8:
        if (r2 == null) goto L12;
        return r2.getLayoutPosition();
    L12:
        throw new IllegalStateException("ViewHolder is null".toString());
    }

    public final void d() {
        e r0 = this.a.l();
        if ((r0 instanceof e) == false) goto L5;
        e r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.h();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void f() {
        e r0 = this.a.l();
        if ((r0 instanceof e) == false) goto L5;
        e r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.e();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final View o0() {
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c r0 = this.a.l();
        if ((r0 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c r1 = r0;
    L6:
        if (r1 == null) goto L11;
        ViewGroup r2 = r1.k();
        if (r2 == null) goto L11;
        return r2;
    L11:
        return a();
    L5:
        r1 = null;
        goto L6
    }

    public final Point c() {
        return this.c;
    }

    public static LKUILightTextView g(View r3) {
        if ((r3 instanceof LKUILightTextView) == false) goto L7;
        return (LKUILightTextView) r3;
    L7:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        ViewGroup r4 = (ViewGroup) r3;
        int r0 = r4.getChildCount();
        int r1 = 0;
    L9:
        if (r1 >= r0) goto L18;
        LKUILightTextView r2 = g(r4.getChildAt(r1));
        if (r2 != null) goto L12;
        r1 = r1 + 1;
        goto L9
    L12:
        return r2;
    L18:
        return null;
    L14:
        return null;
    }

    public a(h3b.b r2, y6b.a<?> r3, Point r4) {
        Intrinsics.checkNotNullParameter(r2, "cell");
        Intrinsics.checkNotNullParameter(r3, "item");
        Intrinsics.checkNotNullParameter(r4, "touchEventOnWindow");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
