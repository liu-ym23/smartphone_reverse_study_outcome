package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class o implements pw8.a {
    public final /* synthetic */ l a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ Message d;
    public final /* synthetic */ BotModel e;
    public final /* synthetic */ Map<String, Object> f;
    public final /* synthetic */ lw8.l g;
    public final /* synthetic */ Ref.ObjectRef<lw8.m> h;
    public final /* synthetic */ Ref.BooleanRef i;
    public final /* synthetic */ Ref.ObjectRef<String> j;

    public final void a(final ViewGroup r12) {
        Intrinsics.checkNotNullParameter(r12, "parent");
        long r4 = System.currentTimeMillis();
        l r0 = this.a;
        Context r1 = this.b;
        Boolean r2 = this.c;
        r0.getClass();
        w r3 = w.a;
        if (r0.a.x == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        Boolean r6 = Boolean.valueOf(r5);
        hf8.a r7 = r0.a;
        Boolean r8 = r7.g;
        com.larus.bmhome.chat.layout.widget.handler.q r9 = r7.u;
        HashMap r10 = null;
        if (r9 == null) goto L11;
        RectF r11 = r9.d;
    L12:
        r3.getClass();
        View r13 = w.b(r1, r6, r8, r11);
        l.d(this.a, r13);
        l.e(this.a, r13, this.d, this.e, this.f);
        final FrameLayout r14 = new FrameLayout(this.b);
        lw8.l r15 = this.g;
        if (r15 == null) goto L15;
        r10 = r15.a();
    L15:
        r14.setTag(2131379590, r10);
        r14.addView(r13, new LinearLayout.LayoutParams(-2, -2));
        l.f(this.a, false, this.b, r4, this.d, (lw8.m) this.h.element, r13, this.g, new m(r12, r14));
        return;
    L11:
        r11 = null;
        goto L12
    L5:
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L7;
        r5 = true;
        goto L8
    }

    public final void b(int r18, ViewGroup r19) {
        Intrinsics.checkNotNullParameter(r19, "currentViewGroup");
        if (this.i.element == true) goto L5;
    L7:
        long r6 = System.currentTimeMillis();
        View r1 = r19.getChildAt(r18);
        HashMap r3 = null;
        if ((r1 instanceof FrameLayout) == false) goto L10;
        FrameLayout r2 = (FrameLayout) r1;
    L11:
        if (r2 == null) goto L13;
        View r4 = r2.getChildAt(0);
    L15:
        if ((r4 instanceof CustomMarkdownTextView) == false) goto L17;
        CustomMarkdownTextView r5 = (CustomMarkdownTextView) r4;
    L18:
        if (r5 != null) goto L20;
        return;
    L20:
        l.d(this.a, r5);
        l.e(this.a, r5, this.d, this.e, this.f);
        Object r7 = r5.getParent();
        if ((r7 instanceof View) == false) goto L23;
        View r8 = (View) r7;
    L24:
        if (r8 == null) goto L29;
        lw8.l r9 = this.g;
        if (r9 == null) goto L28;
        r3 = r9.a();
    L28:
        r8.setTag(2131379590, r3);
    L29:
        final l r10 = this.a;
        Context r11 = this.b;
        final Message r12 = this.d;
        lw8.m r14 = (lw8.m) this.h.element;
        lw8.l r15 = this.g;
        final BotModel r13 = this.e;
        final Ref.ObjectRef<String> r16 = this.j;
        final CustomMarkdownTextView r17 = r5;
        l.f(r10, true, r11, r6, r12, r14, r5, r15, new n(r13, r12, r10, r17, r16));
        return;
    L23:
        r8 = null;
        goto L24
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = null;
        goto L15
    L10:
        r2 = null;
        goto L11
    L5:
        if (this.a.a.r == true) goto L7;
    }

    public o(l r1, Context r2, Boolean r3, Message r4, BotModel r5, Map<String, Object> r6, lw8.l r7, Ref.ObjectRef<lw8.m> r8, Ref.BooleanRef r9, Ref.ObjectRef<String> r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
