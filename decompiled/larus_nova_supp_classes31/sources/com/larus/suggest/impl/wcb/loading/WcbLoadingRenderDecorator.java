package com.larus.suggest.impl.wcb.loading;

import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.suggest.impl.wcb.model.WcbSurface;
import com.larus.suggest.impl.wcb.policy.a0;
import com.larus.suggest.impl.wcb.render.i;
import com.larus.suggest.impl.wcb.render.k;
import com.larus.suggest.impl.wcb.render.n;
import com.larus.suggest.impl.wcb.render.p;
import com.larus.suggest.impl.wcb.render.q;
import com.larus.suggest.impl.wcb.render.r;
import com.larus.suggest.impl.wcb.request.WcbRequestTrigger;
import com.larus.suggest.impl.wcb.request.f;
import com.larus.suggest.impl.wcb.scene.WcbMode;
import com.larus.utils.logger.FLogger;
import hx9.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class WcbLoadingRenderDecorator implements r {
    public final r a;
    public final l b;

    public final class LoadingTransaction implements q {
        public final q a;
        public final b b;
        public boolean c;
        public final /* synthetic */ WcbLoadingRenderDecorator d;

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void c() {
            b r0 = this.b;
            boolean r2 = false;
            if (r0.n == false) goto L6;
            r0.n = false;
            r2 = true;
        L6:
            if (r2 == false) goto L9;
            this.d.b.x4();
            return;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final boolean isActive() {
            if (this.a.isActive() == false) goto L7;
            ConcurrentHashMap<Long, b> r0 = c.a;
            if (Intrinsics.areEqual(c.a(this.b.a), this.b) == false) goto L7;
            return true;
        L7:
            return false;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final void cancel() {
            d(this);
            this.a.cancel();
        }

        public static void d(LoadingTransaction r5) {
            r5.getClass();
            ConcurrentHashMap<Long, b> r0 = c.a;
            b r1 = r5.b;
            if (c.b(r1.a, r1.b) == false) goto L6;
            r5.d.b.x4();
            return;
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object b(Continuation<? super Unit> r5) {
            if ((r5 instanceof WcbLoadingRenderDecorator$LoadingTransaction$finish$1) == false) goto L7;
            WcbLoadingRenderDecorator$LoadingTransaction$finish$1 r0 = (WcbLoadingRenderDecorator$LoadingTransaction$finish$1) r5;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r6 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch(r0.label) {
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L17;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                default: goto L11;
            };
        L12:
            Throwable r3 = (Throwable) r0.L$0;
            ResultKt.throwOnFailure(r6);
            throw r3;
        L13:
            ResultKt.throwOnFailure(r6);
        L56:
            return Unit.INSTANCE;
        L14:
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L19
        L51:
            d(this);     // Catch: Throwable -> L19
        L52:
            q r7 = this.a;
            r0.label = 5;
            if (r7.b(r0) != r2) goto L56;
            return r2;
        L16:
            Unit r4 = (Unit) r0.L$0;
            ResultKt.throwOnFailure(r6);
            return r4;
        L17:
            ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L19
        L40:
            if (isActive() == true) goto L47;
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L19
            q r9 = this.a;
            r0.L$0 = r8;
            r0.label = 3;
            if (r9.b(r0) != r2) goto L46;
            return r2;
        L46:
            return r8;
        L47:
            d(this);     // Catch: Throwable -> L19
            goto L52
        L21:
            Unit r10 = (Unit) r0.L$0;
            ResultKt.throwOnFailure(r6);
            return r10;
        L22:
            ResultKt.throwOnFailure(r6);
            if (isActive() == true) goto L32;
            Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L19
            q r12 = this.a;
            r0.L$0 = r11;
            r0.label = 1;
            if (r12.b(r0) != r2) goto L30;
            return r2;
        L30:
            return r11;
        L32:
            if (this.c == false) goto L48;
            b r13 = this.b;     // Catch: Throwable -> L19
            r0.label = 2;     // Catch: Throwable -> L19
            Object r14 = r13.o.await(r0);     // Catch: Throwable -> L19
            if (r14 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
            r14 = Unit.INSTANCE;     // Catch: Throwable -> L19
        L37:
            if (r14 != r2) goto L40;
            return r2;
        L48:
            r0.label = 4;     // Catch: Throwable -> L19
            if (e(r0) != r2) goto L51;
            return r2;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L19:
            th = move-exception;
            q r15 = this.a;
            r0.L$0 = th;
            r0.label = 6;
            if (r15.b(r0) != r2) goto L61;
            return r2;
        L61:
            throw th;
        L7:
            r0 = new WcbLoadingRenderDecorator$LoadingTransaction$finish$1(this, r5);
            goto L8
        }

        public final Object e(Continuation<? super Boolean> r8) {
            if ((r8 instanceof WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1) == false) goto L7;
            WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1 r0 = (WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1) r8;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            ResultKt.throwOnFailure(r9);
        L25:
            n r10 = (n) r9;
            if (isActive() == true) goto L30;
            return Boxing.boxBoolean(false);
        L30:
            if ((r10 instanceof n.a) == false) goto L33;
            FLogger.a.w("WcbLog", ((n.a) r10).a);
        L33:
            return Boxing.boxBoolean(true);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            if (isActive() == false) goto L17;
            String r11 = this.b.f;
            if (r11 == null) goto L21;
            q r4 = this.a;
            com.larus.suggest.impl.wcb.render.l.b r5 = new com.larus.suggest.impl.wcb.render.l.b(new p(r11));
            r0.label = 1;
            r9 = r4.a(r5, r0);
            if (r9 != r2) goto L25;
            return r2;
        L21:
            return Boxing.boxBoolean(true);
        L17:
            return Boxing.boxBoolean(false);
        L7:
            r0 = new WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1(this, r8);
            goto L8
        }

        @Override // com.larus.suggest.impl.wcb.render.q
        public final Object a(com.larus.suggest.impl.wcb.render.l r7, Continuation<? super n> r8) {
            if ((r8 instanceof WcbLoadingRenderDecorator$LoadingTransaction$render$1) == false) goto L7;
            WcbLoadingRenderDecorator$LoadingTransaction$render$1 r0 = (WcbLoadingRenderDecorator$LoadingTransaction$render$1) r8;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            n r10 = (n) r0.L$0;
            ResultKt.throwOnFailure(r9);
        L38:
            if (((Boolean) r9).booleanValue() == true) goto L40;
            return r10;
        L40:
            n r11 = r10;
        L41:
            this.c = true;
            b r12 = this.b;
            n.b r4 = (n.b) r11;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r4, "submission");
            r12.m = r4;
            this.d.b.x4();
        L42:
            return r11;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            r7 = (com.larus.suggest.impl.wcb.render.l) r0.L$0;
            ResultKt.throwOnFailure(r9);
        L26:
            r11 = (n) r9;
            if ((r11 instanceof n.b) == false) goto L42;
            if (isActive() == false) goto L42;
            if ((r7 instanceof com.larus.suggest.impl.wcb.render.l.a) == false) goto L41;
            r0.L$0 = r11;
            r0.label = 2;
            Object r13 = e(r0);
            if (r13 != r2) goto L36;
            return r2;
        L36:
            r9 = r13;
            r10 = r11;
            goto L38
        L16:
            ResultKt.throwOnFailure(r9);
            if (isActive() == true) goto L21;
            return new n.a("wcb render transaction inactive");
        L21:
            if ((r7 instanceof com.larus.suggest.impl.wcb.render.l.a) == false) goto L23;
            String r14 = this.b.g;
            i r15 = ((com.larus.suggest.impl.wcb.render.l.a) r7).a;
            Intrinsics.checkNotNullParameter(r15, "presentation");
            r7 = new com.larus.suggest.impl.wcb.render.l.a(r15, r14);
        L23:
            q r16 = this.a;
            r0.L$0 = r7;
            r0.label = 1;
            r9 = r16.a(r7, r0);
            if (r9 != r2) goto L26;
            return r2;
        L7:
            r0 = new WcbLoadingRenderDecorator$LoadingTransaction$render$1(this, r8);
            goto L8
        }

        public LoadingTransaction(WcbLoadingRenderDecorator r2, q r3, b r4) {
            Intrinsics.checkNotNullParameter(r3, "delegate");
            Intrinsics.checkNotNullParameter(r4, "session");
            this.d = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public static final class a {
    }

    static {
    }

    public static boolean b(f r2) {
        if (r2.f.a.getKey().a != WcbSurface.NEW_CONVERSATION) goto L9;
        com.larus.suggest.impl.wcb.request.c r3 = r2.f;
        if (r3.b != WcbRequestTrigger.INITIAL) goto L9;
        if (r3.a.getKey().b != WcbMode.QUICK_EXPERT) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.larus.suggest.impl.wcb.render.r
    public final q a(k r27) {
        Intrinsics.checkNotNullParameter(r27, "context");
        q r2 = this.a.a(r27);
        com.larus.suggest.impl.wcb.request.c r3 = r27.a.f;
        if (Intrinsics.areEqual(r27.c, a0.c.a) == true) goto L6;
    L45:
        boolean r4 = false;
    L46:
        if (r4 == true) goto L48;
        return r2;
    L48:
        f r1 = r27.a;
        p r5 = r1.f.e;
        if (r5 == null) goto L53;
        String r6 = r5.a;
        if (r6 == null) goto L53;
        String r7 = StringsKt.removeSuffix(r6, ":fake_message:1");
    L54:
        boolean r8 = r1.f.a.e().a(this.b).a;
        if (r7 == null) goto L58;
        if (r8 == false) goto L58;
        String r9 = r7;
    L59:
        if (r7 == null) goto L71;
        Iterator r11 = SequencesKt.flattenSequenceOfIterable(SequencesKt.sequenceOf(new List[]{this.b.c(), this.b.g()})).iterator();
    L62:
        if (r11.hasNext() == false) goto L69;
        Object r12 = r11.next();
        String r13 = ((Message) r12).getLocalMessageId();
        if (r13 != null) goto L67;
        r13 = "";
    L67:
        if (Intrinsics.areEqual(StringsKt.removeSuffix(r13, ":fake_message:1"), r7) == false) goto L62;
    L70:
        Message r14 = (Message) r12;
    L72:
        long r10 = r1.d;
        long r15 = r1.e;
        String r16 = r1.b;
        String r17 = r1.c;
        int r18 = r1.f.f;
        if (Intrinsics.areEqual(r9, r7) == false) goto L84;
        if (r14 == null) goto L78;
        long r20 = r15;
        if (r14.getContentType() != 2) goto L79;
        boolean r19 = true;
    L80:
        if (r19 == false) goto L85;
        String r21 = r14.getLocalMessageId();
        if (r21 != null) goto L86;
        r21 = "";
    L86:
        Iterator r110 = this.b.c().iterator();
    L88:
        if (r110.hasNext() == false) goto L125;
        Object r111 = r110.next();
        Message r112 = (Message) r111;
        if (com.larus.bmhome.chat.bean.d.i0(r112) == false) goto L95;
        if (com.larus.bmhome.chat.bean.d.w(r112) == true) goto L95;
    L115:
        Iterator r22 = r110;
        Object r113 = r111;
    L116:
        boolean r114 = false;
    L117:
        if (r114 == true) goto L119;
    L121:
        boolean r115 = false;
    L122:
        if (r115 == true) goto L126;
        r110 = r22;
    L126:
        Message r116 = (Message) r113;
        if (r116 == null) goto L129;
        String r23 = r116.getLocalMessageId();
    L130:
        e r117 = this.b.O8();
        if (r117 == null) goto L133;
        String r24 = r117.B;
    L134:
        if (r14 == null) goto L136;
        String r118 = com.larus.bmhome.chat.bean.d.x(r14).getWcbTitle();
    L137:
        if (r118 != null) goto L139;
        String r25 = "";
    L141:
        if (b(r1) == false) goto L143;
        int r26 = 1;
    L150:
        b r119 = new b(r10, r20, r16, r17, r18, r7, r9, r21, r23, r24, r25, r26);
        LoadingTransaction r28 = new LoadingTransaction(this, r2, r119);
        ConcurrentHashMap<Long, b> r29 = c.a;
        Intrinsics.checkNotNullParameter(r119, "session");
        b r30 = c.a.put(Long.valueOf(r119.a), r119);
        if (r30 == null) goto L153;
        r30.o.complete(Unit.INSTANCE);
    L153:
        this.b.x4();
        return r28;
    L143:
        if (r14 == null) goto L149;
        String r31 = (String) com.larus.bmhome.chat.bean.d.x(r14).get("wcb_title_style");
        if (r31 == null) goto L149;
        Integer r32 = StringsKt.toIntOrNull(r31);
        if (r32 == null) goto L149;
        r26 = r32.intValue();
    L149:
        r26 = 0;
        goto L150
    L139:
        r25 = r118;
        goto L141
    L136:
        r118 = null;
        goto L137
    L133:
        r24 = null;
        goto L134
    L129:
        r23 = null;
        goto L130
    L119:
        if (b0.f(r112) == true) goto L121;
        r115 = true;
    L95:
        if (com.larus.bmhome.chat.bean.d.T(r112) == true) goto L115;
        if (com.larus.bmhome.chat.bean.d.p0(r112) == true) goto L115;
        if (com.larus.bmhome.chat.bean.d.C0(r112) == true) goto L102;
    L104:
        MessageStatus r120 = r112.getMessageStatus();
        r22 = r110;
        if (r120 == null) goto L109;
        boolean r121 = r120.isVisible();
        r113 = r111;
        if (r121 != true) goto L110;
        boolean r122 = true;
    L111:
        if (r122 == false) goto L113;
    L114:
        r114 = true;
        goto L117
    L113:
        if (b0.f(r112) == false) goto L116;
    L110:
        r122 = false;
        goto L111
    L109:
        r113 = r111;
        goto L110
    L102:
        if (r112.getRegenVisible() == true) goto L104;
    L125:
        r113 = null;
    L85:
        r21 = r9 + ":fake_message:1";
    L79:
        r19 = false;
        goto L80
    L78:
        r20 = r15;
        goto L79
    L84:
        r20 = r15;
        goto L85
    L69:
        r12 = null;
        goto L70
    L71:
        r14 = null;
    L58:
        int r33 = wf9.b.a;
        r9 = com.flow.kmp.common.util.i.a();
    L53:
        r7 = null;
        goto L54
    L6:
        if (b(r27.a) == false) goto L9;
    L44:
        r4 = true;
        goto L46
    L9:
        if (r3.b != WcbRequestTrigger.MODE_SWITCH) goto L45;
        p r34 = r3.e;
        if (r34 == null) goto L45;
        String r35 = r34.a;
        if (r35 == null) goto L45;
        String r36 = StringsKt.removeSuffix(r35, ":fake_message:1");
        if (r36 == null) goto L45;
        Iterator<T> r37 = this.b.g().iterator();
    L20:
        if (r37.hasNext() == false) goto L36;
        Object r123 = r37.next();
        Message r124 = (Message) r123;
        if (Intrinsics.areEqual(r124.getConversationId(), r27.a.b) == false) goto L33;
        String r125 = r124.getLocalMessageId();
        if (r125 != null) goto L27;
        r125 = "";
    L27:
        if (Intrinsics.areEqual(StringsKt.removeSuffix(r125, ":fake_message:1"), r36) == false) goto L33;
        if (r124.getContentType() != 2) goto L33;
        if (gx9.p.a(r124) == false) goto L33;
        boolean r126 = true;
    L34:
        if (r126 == false) goto L20;
    L37:
        Message r127 = (Message) r123;
        if (r127 == null) goto L45;
        PromptContent r38 = com.larus.bmhome.chat.bean.d.i1(r127, null, 3);
        if (r38.isEmpty() == true) goto L45;
        if (Intrinsics.areEqual(r38.getWcbRenderStatus(), "DEPRECATED") == true) goto L45;
    L33:
        r126 = false;
        goto L34
    L36:
        r123 = null;
        goto L37
    }

    public WcbLoadingRenderDecorator(r r2, hx9.a r3) {
        Intrinsics.checkNotNullParameter(r2, "delegate");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a = r2;
        this.b = r3;
    }
}
