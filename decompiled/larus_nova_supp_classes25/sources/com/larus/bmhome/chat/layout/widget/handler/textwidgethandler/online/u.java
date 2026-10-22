package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.adapter.j0;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.t0;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import lsc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u implements pw8.a {
    public final /* synthetic */ Ref.BooleanRef a;
    public final /* synthetic */ k b;
    public final /* synthetic */ Message c;
    public final /* synthetic */ BotModel d;
    public final /* synthetic */ Map<String, Object> e;
    public final /* synthetic */ lw8.l f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ Ref.ObjectRef<String> h;
    public final /* synthetic */ Ref.ObjectRef<lw8.m> i;

    public static final class a implements v {
        public final /* synthetic */ Ref.LongRef a;
        public final /* synthetic */ Ref.LongRef b;
        public final /* synthetic */ Ref.LongRef c;

        public a(Ref.LongRef r1, Ref.LongRef r2, Ref.LongRef r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void a(long r2, long r4, long r6) {
            this.a.element = r2;
            this.b.element = r4;
            this.c.element = r6;
        }
    }

    public final void a(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "parent");
    }

    public final void b(int r24, ViewGroup r25) {
        Intrinsics.checkNotNullParameter(r25, "currentViewGroup");
        if (this.a.element == true) goto L5;
    L7:
        final long r8 = System.currentTimeMillis();
        View r1 = r25.getChildAt(r24);
        if ((r1 instanceof FrameLayout) == false) goto L10;
        FrameLayout r2 = (FrameLayout) r1;
    L11:
        if (r2 == null) goto L13;
        View r3 = r2.getChildAt(0);
    L15:
        if ((r3 instanceof CustomMarkdownTextView) == false) goto L17;
        CustomMarkdownTextView r4 = (CustomMarkdownTextView) r3;
    L18:
        if (r4 != null) goto L20;
        return;
    L20:
        k.d(this.b, r4);
        k.h(this.b, r4, this.c, this.d, this.e);
        Object r5 = r4.getParent();
        if ((r5 instanceof View) == false) goto L23;
        View r6 = (View) r5;
    L24:
        if (r6 == null) goto L30;
        lw8.l r7 = this.f;
        if (r7 == null) goto L28;
        HashMap r9 = r7.a();
    L29:
        r6.setTag(2131379590, r9);
        goto L30
    L28:
        r9 = null;
    L30:
        final long r10 = System.currentTimeMillis();
        k.g(this.b, r4, this.f, this.c);
        k r11 = this.b;
        k.i(r11, r11.a.z, r4, this.f, this.d, this.c, this.g);
        k.j(this.b, this.g, r4);
        final long r16 = System.currentTimeMillis();
        final Ref.LongRef r12 = new Ref.LongRef();
        final Ref.LongRef r13 = new Ref.LongRef();
        final Ref.LongRef r14 = new Ref.LongRef();
        lw8.l r15 = this.f;
        Message r17 = this.c;
        WeakHashMap<Object, e2a.a> r18 = j0.a;
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.areEqual(r17.getMessageId(), null);
        r4.C(r15, null, com.larus.bmhome.chat.bean.d.F(this.c), new a(r12, r13, r14));
        final long r19 = System.currentTimeMillis();
        CoroutineScope r20 = com.larus.bmhome.chat.layout.widget.handler.p.a;
        Integer r110 = this.d.getBotType();
        String r21 = this.c.getMessageId();
        if (r21 != null) goto L33;
        r21 = "";
    L33:
        com.larus.bmhome.chat.layout.widget.handler.p.c(r110, r21, this.b.a.q, r4.getText(), (String) this.h.element, r4);
        Function1<CustomMarkdownTextView, Unit> r22 = this.b.a.w;
        if (r22 == null) goto L36;
        r22.invoke(r4);
    L36:
        final long r23 = System.currentTimeMillis();
        if (this.b.a.r == true) goto L40;
        final lw8.l r26 = this.f;
        final Ref.ObjectRef<lw8.m> r111 = this.i;
        t0.a(new t(r26, r111, r10, r8, r16, r12, r13, r14, r19, r23));
        return;
    L40:
        return;
    L23:
        r6 = null;
        goto L24
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L15
    L10:
        r2 = null;
        goto L11
    L5:
        if (this.b.a.r == true) goto L7;
    }

    public u(Ref.BooleanRef r1, k r2, Message r3, BotModel r4, Map<String, Object> r5, lw8.l r6, Context r7, Ref.ObjectRef<String> r8, Ref.ObjectRef<lw8.m> r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
