package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import android.content.Context;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.larus.bmhome.chat.adapter.j0;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.chat.layout.widget.ThreeLoadingIndicator;
import com.larus.bmhome.chat.layout.widget.handler.w;
import com.larus.bmhome.chat.layout.widget.v0;
import com.larus.bmhome.utils.u2;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import fh8.x;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class l implements pw8.b {
    public static boolean f;
    public final hf8.a a;
    public long b;
    public final Lazy c;
    public final fh8.r d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public final boolean c(uvc.b r2) {
        Intrinsics.checkNotNullParameter(r2, "node");
        return true;
    }

    public final int priority() {
        return 1;
    }

    public final if8.c h() {
        return (if8.c) this.c.getValue();
    }

    public l(hf8.a r2) {
        Intrinsics.checkNotNullParameter(r2, "markdownTextViewWidgetHandlerParams");
        this.a = r2;
        this.c = LazyKt.lazy(new b(this));
        this.d = r2.A;
        this.e = LazyKt.lazy(new c(this));
    }

    public final void i(v0 r3) {
        if (r3 == null) goto L4;
        Drawable r4 = r3.getDrawable();
    L5:
        int r0 = (int) (i5.r0() * ((Number) this.e.getValue()).floatValue());
        if (r4 == null) goto L9;
        r4.setBounds(0, 0, r0, r0);
        return;
    L9:
        return;
    L4:
        r4 = null;
        goto L5
    }

    public static final void d(l r9, CustomMarkdownTextView r10) {
        com.larus.bmhome.chat.layout.widget.handler.q r0 = r9.a.u;
        if (r0 == null) goto L24;
        int r1 = r0.a;
        if (r1 == 0) goto L7;
        r10.setTextColor(r1);
    L7:
        float r3 = r0.b;
        boolean r8 = false;
        if (r3 <= 0.0f) goto L14;
        Boolean r2 = r9.a.g;
        if (r2 == null) goto L12;
        boolean r4 = r2.booleanValue();
    L13:
        we8.a.b(r10, r3, r4, null, null, 12);
        goto L14
    L12:
        r4 = false;
    L14:
        int r5 = r0.c;
        if (r5 <= 0) goto L20;
        Boolean r11 = r9.a.g;
        if (r11 == null) goto L19;
        r8 = r11.booleanValue();
    L19:
        r10.setLineHeight((int) we8.a.a(r5, r8));
    L20:
        RectF r12 = r0.d;
        if (r12 == null) goto L25;
        r10.setPadding((int) r12.left, (int) r12.top, (int) r12.right, (int) r12.bottom);
        return;
    L25:
        return;
    }

    public static final void e(l r3, CustomMarkdownTextView r4, Message r5, BotModel r6, Map r7) {
        r3.getClass();
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "conversationId", r5.getConversationId());
        q0 r1 = r3.a.f;
        Message r2 = null;
        if (r1 == null) goto L5;
        ChatMessageList r8 = r1.B7();
    L6:
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "chatMessageList", new WeakReference(r8));
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "chatMessage", r5);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, "botId", r6.getBotId());
        q0 r0 = r3.a.f;
        if (r0 == null) goto L9;
        r2 = r0.C7(r5);
    L9:
        hc8.c r9 = hc8.c.a;
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.b(), r6);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.i(), r5);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.l(), new WeakReference(r3.a.i));
        String r10 = r9.c();
        String r11 = r3.a.d.c;
        if (r11 != null) goto L12;
        r11 = "";
    L12:
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r10, r11);
        com.larus.bmhome.chat.layout.widget.handler.e.b(r4, r9.n(), r2);
        r4.setPayload(r7);
        return;
    L5:
        r8 = null;
        goto L6
    }

    public final pw8.a a(Context r13, int r14, uvc.b r15, Boolean r16, lw8.h r17) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r15, "node");
        hf8.a r1 = this.a;
        return g(r13, r14, r15, r16, r1.b, r1.c, r17, false, null, null);
    }

    public final pw8.a b(Context r13, int r14, int r15, ViewGroup r16, uvc.b r17, Boolean r18, lw8.h r19) {
        Intrinsics.checkNotNullParameter(r13, "context");
        Intrinsics.checkNotNullParameter(r16, "currentViewGroup");
        Intrinsics.checkNotNullParameter(r17, "node");
        hf8.a r1 = this.a;
        return g(r13, r14, r17, r18, r1.b, r1.c, r19, true, Integer.valueOf(r15), r16);
    }

    public static final void f(final l r18, final boolean r19, final Context r20, final long r21, Message r23, final lw8.m r24, final CustomMarkdownTextView r25, final lw8.l r26, Function0 r27) {
        r18.getClass();
        final long r9 = System.currentTimeMillis();
        if (r26 == null) goto L5;
        r26.b(new f(r18), new g(r18));
    L5:
        if (r26 == null) goto L7;
        x.a(r26, new k(r18, r25));
    L7:
        if (r26 == null) goto L9;
        r26.g(r25, new p(r18));
    L9:
        if (r26 == null) goto L11;
        r26.d(r25, new q(r18, r20, r25));
    L11:
        if (r26 == null) goto L13;
        r26.h(r25, new r(r18, r20, r25));
    L13:
        q0 r4 = r18.a.f;
        if (r4 == null) goto L23;
        u2 r5 = r4.G7();
        if (r5 == null) goto L23;
        String r6 = r23.getMessageId();
        if (r6 != null) goto L20;
        r6 = "";
    L20:
        Intrinsics.checkNotNullParameter(r6, "msgId");
        boolean r7 = r5.a.contains(r6);
        boolean r8 = true;
        if (r7 != true) goto L23;
    L25:
        if (r8 == true) goto L30;
        if (r18.a.r == true) goto L30;
        by7.e r10 = by7.h.g(r25);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(new t(CoroutineExceptionHandler.Key))), null, null, new MarkdownTextViewWidgetHandlerV2$setupSpanShow$1(r26, r18, r10, null), 3, null);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MarkdownTextViewWidgetHandlerV2$setupSpanShow$2(r26, r18, r25, null), 3, null);
    L30:
        if (r18.a.t == false) goto L32;
        r25.setDownListener(null);
    L35:
        final long r11 = System.currentTimeMillis();
        final Ref.LongRef r13 = new Ref.LongRef();
        final Ref.LongRef r14 = new Ref.LongRef();
        final Ref.LongRef r15 = new Ref.LongRef();
        WeakHashMap<Object, e2a.a> r1 = j0.a;
        Intrinsics.checkNotNullParameter(r23, "<this>");
        Intrinsics.areEqual(r23.getMessageId(), null);
        r25.C(r26, null, com.larus.bmhome.chat.bean.d.F(r23), new s(r13, r14, r15));
        if (r19 == true) goto L38;
        FLogger.a.i("MarkdownTextViewWidgetHandlerV2", "generateMarkdownWidgetFromNode, msg id " + r23.getMessageId());
    L38:
        final long r12 = System.currentTimeMillis();
        r27.invoke();
        Function1<CustomMarkdownTextView, Unit> r2 = r18.a.w;
        if (r2 == null) goto L41;
        r2.invoke(r25);
    L41:
        final long r16 = System.currentTimeMillis();
        if (r18.a.r == true) goto L45;
        t0.a(new e(r26, r24, r12, r11, r16, r9, r21, r13, r14, r15, r19));
        return;
    L45:
        return;
    L32:
        r25.setDownListener(new h(r20));
        r25.setOnClickListener(new i(r18, r25));
        r25.setOnLongClickListener(new j(r18, r25));
        Function1<CustomMarkdownTextView, Unit> r3 = r18.a.v;
        if (r3 == null) goto L35;
        r3.invoke(r25);
    L23:
        r8 = false;
        goto L25
    }

    public final o g(Context r24, int r25, uvc.b r26, Boolean r27, Message r28, BotModel r29, lw8.h r30, boolean r31, Integer r32, ViewGroup r33) {
        if (r31 == true) goto L5;
        ConcurrentHashMap<String, CharSequence> r1 = this.a.a;
        if (r1 == null) goto L32;
        CharSequence r2 = r1.get(r28.getMessageId());
    L31:
        CharSequence r18 = r2;
    L33:
        w r3 = w.a;
        fh8.f r6 = this.a.e;
        if (r6 == null) goto L36;
        fh8.g r7 = fh8.h.a(r6);
        r7.b = r28;
        fh8.f r8 = r7.a();
    L37:
        r3.getClass();
        Map r9 = w.a(r8);
        final Ref.ObjectRef r10 = new Ref.ObjectRef();
        gw8.c.a.getClass();
        gw8.c r12 = gw8.c.a.b();
        if (r12 == null) goto L71;
        hf8.a r13 = this.a;
        boolean r16 = !r13.r;
        lw8.d r15 = r13.h;
        boolean r14 = vg8.e.b();
        View r4 = this.a.D;
        if (vg8.e.b() == false) goto L69;
        if (r31 == false) goto L69;
        hf8.a r5 = this.a;
        if (r5.E == false) goto L69;
        if (r5.x == false) goto L69;
        if (Intrinsics.areEqual(r27, Boolean.TRUE) == false) goto L69;
        hf8.a r11 = this.a;
        if (r11.r == false) goto L69;
        if (r11.s == true) goto L69;
        if (r11.t == true) goto L69;
        Map r17 = r11.b.getExt();
        if (r17 == null) goto L57;
        String r19 = (String) r17.get("text2image_text_finish");
    L59:
        if (Intrinsics.areEqual(r19, "1") == true) goto L69;
        String r20 = this.a.F;
        if (r20 != null) goto L63;
    L66:
        boolean r21 = true;
    L67:
        if (r21 == true) goto L69;
        boolean r22 = true;
    L70:
        lw8.l r110 = r12.createMarkdownContentFromNode(r24, r25, r26, r16, r15, r18, r9, r30, new lw8.i(r14, r4, r22, this.a.F), new d(r10));
    L72:
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        String r23 = "";
        r111.element = "";
        Ref.BooleanRef r112 = new Ref.BooleanRef();
        if (r110 == null) goto L138;
        SpannableStringBuilder r34 = r110.e();
        if (this.a.x == false) goto L82;
        if (Intrinsics.areEqual(r27, Boolean.TRUE) == false) goto L82;
        if (this.a.s == false) goto L82;
        r111.element = "...";
        r34.append("...");
    L133:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L138;
        r112.element = true;
        ConcurrentHashMap<String, CharSequence> r35 = this.a.a;
        if (r35 == null) goto L138;
        CharSequence r0 = r35.put(r28.getMessageId() + '-' + r32, r34);
    L82:
        if (this.a.x == false) goto L106;
        if (Intrinsics.areEqual(r27, Boolean.TRUE) == false) goto L106;
        hf8.a r36 = this.a;
        if (r36.t == false) goto L106;
        ThreeLoadingIndicator r37 = r36.l;
        if (r37 == null) goto L133;
        List<v0> r38 = r37.b;
        if (r38 == null) goto L133;
        Iterator<T> r39 = r38.iterator();
    L93:
        if (r39.hasNext() == false) goto L133;
        v0 r40 = (v0) r39.next();
        i(r40);
        String r41 = r28.getContent();
        if (r41 != null) goto L97;
    L103:
        boolean r42 = false;
    L104:
        r40.f = r42;
        r34.append("⚫", r40, 17);
        goto L93
    L97:
        if (r41.length() != 0) goto L99;
        boolean r43 = true;
    L101:
        if (r43 != true) goto L103;
        r42 = true;
        goto L104
    L99:
        r43 = false;
    L106:
        if (this.a.x == false) goto L133;
        if (Intrinsics.areEqual(r27, Boolean.TRUE) == false) goto L133;
        hf8.a r44 = this.a;
        if (r44.r == false) goto L133;
        Map r45 = r44.b.getExt();
        if (r45 == null) goto L114;
        String r46 = (String) r45.get("text2image_text_finish");
    L116:
        if (Intrinsics.areEqual(r46, "1") == true) goto L133;
        if (r34.length() != 0) goto L120;
        boolean r47 = true;
    L121:
        if (r47 == false) goto L123;
        boolean r48 = false;
    L128:
        if (r48 == true) goto L131;
        i(this.a.k);
        r34.append("⚫", this.a.k, 17);
        r23 = "⚫";
    L131:
        r111.element = r23;
        goto L133
    L123:
        int r49 = r34.length();
        ReplacementSpan[] r50 = (ReplacementSpan[]) r34.getSpans(r49 - 1, r49, ReplacementSpan.class);
        Intrinsics.checkNotNull(r50);
        if (r50.length != 0) goto L126;
        boolean r51 = true;
        boolean r52 = true;
    L127:
        r48 = r52 ^ r51;
        goto L128
    L126:
        r51 = true;
        r52 = false;
        goto L127
    L120:
        r47 = false;
        goto L121
    L114:
        r46 = null;
    L138:
        return new o(this, r24, r27, r28, r29, r9, r110, r10, r112, r111);
    L63:
        if (r20.length() == 0) goto L66;
        r21 = false;
        goto L67
    L57:
        r19 = null;
    L69:
        r22 = false;
        goto L70
    L71:
        r110 = null;
        goto L72
    L36:
        r8 = new fh8.f(0);
    L32:
        r18 = null;
        goto L33
    L5:
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L9;
        ConcurrentHashMap<String, CharSequence> r53 = this.a.a;
        if (r53 == null) goto L32;
        r2 = r53.get(r28.getMessageId() + '-' + r32);
        goto L31
    L9:
        if (r33 == null) goto L14;
        if (r32 == null) goto L12;
        int r54 = r32.intValue();
    L13:
        View r55 = r33.getChildAt(r54);
    L16:
        if ((r55 instanceof FrameLayout) == false) goto L18;
        FrameLayout r56 = (FrameLayout) r55;
    L19:
        if (r56 == null) goto L21;
        View r57 = r56.getChildAt(0);
    L23:
        if ((r57 instanceof CustomMarkdownTextView) == false) goto L25;
        CustomMarkdownTextView r58 = (CustomMarkdownTextView) r57;
    L26:
        if (r58 == null) goto L32;
        r2 = r58.getText();
        goto L31
    L25:
        r58 = null;
        goto L26
    L21:
        r57 = null;
        goto L23
    L18:
        r56 = null;
        goto L19
    L12:
        r54 = 0;
        goto L13
    L14:
        r55 = null;
        goto L16
    }
}
