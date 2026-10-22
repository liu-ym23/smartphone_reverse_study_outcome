package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.online;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.larus.bmhome.chat.adapter.j0;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lsc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class m implements pw8.a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ k b;
    public final /* synthetic */ Boolean c;
    public final /* synthetic */ Message d;
    public final /* synthetic */ BotModel e;
    public final /* synthetic */ Map<String, Object> f;
    public final /* synthetic */ lw8.l g;
    public final /* synthetic */ Ref.ObjectRef<lw8.m> h;

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

    public final void a(ViewGroup r21) {
        Intrinsics.checkNotNullParameter(r21, "parent");
        final long r8 = System.currentTimeMillis();
        w r2 = w.a;
        Context r3 = this.a;
        if (this.b.a.x == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        Boolean r5 = Boolean.valueOf(r4);
        hf8.a r6 = this.b.a;
        Boolean r7 = r6.g;
        com.larus.bmhome.chat.layout.widget.handler.q r9 = r6.u;
        if (r9 == null) goto L11;
        RectF r10 = r9.d;
    L12:
        r2.getClass();
        View r11 = w.b(r3, r5, r7, r10);
        k.d(this.b, r11);
        k.h(this.b, r11, this.d, this.e, this.f);
        FrameLayout r12 = new FrameLayout(this.a);
        lw8.l r13 = this.g;
        if (r13 == null) goto L15;
        HashMap r14 = r13.a();
    L16:
        r12.setTag(2131379590, r14);
        r12.addView(r11, new LinearLayout.LayoutParams(-2, -2));
        final long r17 = System.currentTimeMillis();
        k.g(this.b, r11, this.g, this.d);
        k r15 = this.b;
        k.i(r15, r15.a.z, r11, this.g, this.e, this.d, this.a);
        k.j(this.b, this.a, r11);
        final long r16 = System.currentTimeMillis();
        final Ref.LongRef r18 = new Ref.LongRef();
        final Ref.LongRef r19 = new Ref.LongRef();
        final Ref.LongRef r110 = new Ref.LongRef();
        lw8.l r20 = this.g;
        Message r22 = this.d;
        WeakHashMap<Object, e2a.a> r23 = j0.a;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        Intrinsics.areEqual(r22.getMessageId(), null);
        r11.C(r20, null, com.larus.bmhome.chat.bean.d.F(this.d), new a(r18, r19, r110));
        FLogger.a.i("MarkdownTextViewWidgetHandler", "generateMarkdownWidgetFromNode, msg id " + this.d.getMessageId());
        final long r111 = System.currentTimeMillis();
        r21.addView(r12);
        Function1<CustomMarkdownTextView, Unit> r1 = this.b.a.w;
        if (r1 == null) goto L19;
        r1.invoke(r11);
    L19:
        final long r24 = System.currentTimeMillis();
        if (this.b.a.r == true) goto L23;
        final lw8.l r25 = this.g;
        final Ref.ObjectRef<lw8.m> r26 = this.h;
        t0.a(new l(r25, r26, r17, r8, r16, r18, r19, r110, r111, r24));
        return;
    L23:
        return;
    L15:
        r14 = null;
        goto L16
    L11:
        r10 = null;
        goto L12
    L5:
        if (Intrinsics.areEqual(this.c, Boolean.TRUE) == false) goto L7;
        r4 = true;
        goto L8
    }

    public final void b(int r1, ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, "currentViewGroup");
    }

    public m(Context r1, k r2, Boolean r3, Message r4, BotModel r5, Map<String, Object> r6, lw8.l r7, Ref.ObjectRef<lw8.m> r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}
