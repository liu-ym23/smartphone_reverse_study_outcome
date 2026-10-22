package com.larus.tts.impl;

import androidx.collection.LruCache;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.larus.audio.ttsV2.a;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;
import wi8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2", f = "ChatTitleTtsComponent.kt", i = {}, l = {663}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleTtsComponent$initTtsGuideCheck$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    /* JADX INFO: renamed from: com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ ChatTitleTtsComponent a;
        public final /* synthetic */ Message b;

        /* JADX INFO: renamed from: com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
        @DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$2$1$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ a $it;
            final /* synthetic */ boolean $newIsTtsCheck;
            int label;
            final /* synthetic */ ChatTitleTtsComponent this$0;

            public C00361(a r1, boolean r2, ChatTitleTtsComponent r3, Continuation<? super C00361> r4) {
                this.$it = r1;
                this.$newIsTtsCheck = r2;
                this.this$0 = r3;
                super(2, r4);
            }

            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                return new C00361(this.$it, this.$newIsTtsCheck, this.this$0, r5);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r4);
                a r5 = this.$it;
                boolean r0 = r5.a;
                boolean r1 = this.$newIsTtsCheck;
                r5.getClass();
                ChatTitleTtsComponent r6 = this.this$0;
                int r2 = ChatTitleTtsComponent.v;
                com.larus.platform.api.g0 r7 = r6.Y2();
                if (r7 == null) goto L8;
                r7.setEarphoneState(new lq9.q(r0, r1));
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        public AnonymousClass1(ChatTitleTtsComponent r1, Message r2) {
            this.a = r1;
            this.b = r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r2v14 */
        public final Object a(a r23, Continuation<? super Unit> r24) {
            if ((r24 instanceof ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1) == false) goto L7;
            ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1 r3 = (ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1) r24;
            int r4 = r3.label;
            if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
            r3.label = r4 - Integer.MIN_VALUE;
        L8:
            Object r2 = r3.result;
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r6 = r3.label;
            boolean r7 = true;
            if (r6 == 0) goto L14;
            if (r6 != 1) goto L13;
            int r1 = r3.I$0;
            ResultKt.throwOnFailure(r2);
            ?? r8 = r1;
        L97:
            ChatTitleTtsComponent r9 = this.a;
            int r10 = ChatTitleTtsComponent.v;
            u7 r11 = (u7) r9.l.getValue();
            if (r11 == null) goto L115;
            if (Intrinsics.areEqual(this.a.j.getValue(), Boxing.boxBoolean(true)) == true) goto L113;
            com.larus.platform.api.g0 r12 = this.a.Y2();
            if (r12 == null) goto L108;
            lq9.q r13 = r12.getEarphoneState();
            if (r13 == null) goto L108;
            if (r13.a != true) goto L108;
            boolean r14 = true;
        L109:
            if (r14 == false) goto L112;
            if (r8 != 0) goto L113;
        L112:
            r7 = false;
        L108:
            r14 = false;
        L113:
            r11.A5(r7);
        L115:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r2);
            FLogger.a.d("ChatTitleTtsComponent", "getEarphoneState: " + r23);
            if (r23.a == true) goto L17;
        L35:
            boolean r15 = false;
        L36:
            ChatTitleTtsComponent r16 = this.a;
            int r17 = ChatTitleTtsComponent.v;
            com.larus.platform.api.g0 r18 = r16.Y2();
            if (r18 == null) goto L43;
            lq9.q r19 = r18.getEarphoneState();
            if (r19 == null) goto L43;
            if (r19.a != true) goto L43;
            boolean r20 = true;
        L44:
            if (r20 == true) goto L46;
        L57:
            boolean r21 = false;
        L59:
            if (r15 == true) goto L61;
            if (r21 == true) goto L61;
        L86:
            if (r23.b == false) goto L92;
            AudioServiceDelegate r22 = AudioServiceDelegate.a;
            if (r22.q0() == true) goto L92;
            if (r22.D() == true) goto L92;
            ?? r25 = 1;
        L93:
            MainCoroutineDispatcher r26 = Dispatchers.getMain();
            C00361 r27 = new C00361(r23, r25, this.a, null);
            r3.I$0 = r25;
            r3.label = 1;
            if (BuildersKt.withContext(r26, r27, r3) != r5) goto L96;
            return r5;
        L96:
            r8 = r25;
        L92:
            r25 = 0;
        L61:
            int r28 = e.a;
            BotModel r29 = this.a.j0();
            if (r29 == null) goto L65;
            String r30 = r29.getBotId();
            if (r30 == null) goto L65;
        L66:
            String r110 = r30;
            String r111 = this.a.P2();
            LruCache r31 = ko8.a.a;
            wc9.e r32 = this.a.U2();
            if (r32 == null) goto L69;
            Integer r33 = r32.v;
        L70:
            String r112 = ko8.a.f(r33, this.a.N2(), this.a.L2());
            Message r34 = this.b;
            if (r34 == null) goto L73;
            boolean r113 = d.Q0(r34);
        L74:
            Message r35 = this.b;
            if (r35 == null) goto L77;
            boolean r114 = d.f0(r35);
        L78:
            long r115 = 0;
            if (r15 == false) goto L81;
            long r210 = 0;
        L82:
            if (r15 == false) goto L84;
            r115 = 1;
        L84:
            by7.e r36 = s1a.a.c(this.a);
            Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type com.ixigua.lib.track.ITrackNode");
            e.a(false, r110, false, r111, r112, r113, r114, null, "connect_to_earphones", Boxing.boxLong(r210), Boxing.boxLong(r115), r36);
            goto L86
        L81:
            r210 = 1;
            goto L82
        L77:
            r114 = false;
            goto L78
        L73:
            r113 = false;
            goto L74
        L69:
            r33 = null;
        L65:
            r30 = "";
            goto L66
        L46:
            if (r23.a == true) goto L57;
            if (r23.b == false) goto L57;
            com.larus.platform.api.g0 r37 = this.a.Y2();
            if (r37 != null) goto L52;
        L54:
            boolean r38 = false;
        L55:
            if (r38 == true) goto L57;
            r21 = true;
            goto L59
        L52:
            if (r37.getTtsChecked() != true) goto L54;
            r38 = true;
        L43:
            r20 = false;
            goto L44
        L17:
            if (r23.b == false) goto L35;
            ChatTitleTtsComponent r39 = this.a;
            int r40 = ChatTitleTtsComponent.v;
            com.larus.platform.api.g0 r41 = r39.Y2();
            if (r41 != null) goto L21;
        L23:
            boolean r42 = false;
        L24:
            if (r42 == true) goto L35;
            com.larus.platform.api.g0 r43 = this.a.Y2();
            if (r43 == null) goto L32;
            lq9.q r44 = r43.getEarphoneState();
            if (r44 == null) goto L32;
            if (r23.b != r44.b) goto L32;
            boolean r45 = true;
        L33:
            if (r45 == false) goto L35;
            r15 = true;
        L32:
            r45 = false;
            goto L33
        L21:
            if (r41.getTtsChecked() != true) goto L23;
            r42 = true;
        L7:
            r3 = new ChatTitleTtsComponent$initTtsGuideCheck$2$1$emit$1(this, r24);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((a) r1, r2);
        }
    }

    public ChatTitleTtsComponent$initTtsGuideCheck$2(ChatTitleTtsComponent r1, Continuation<? super ChatTitleTtsComponent$initTtsGuideCheck$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatTitleTtsComponent$initTtsGuideCheck$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r6);
    L24:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        if (s1a.a.c(this.this$0).isAdded() == false) goto L11;
        ChatTitleTtsComponent r7 = this.this$0;
        int r2 = ChatTitleTtsComponent.v;
        u7 r8 = (u7) r7.l.getValue();
        if (r8 == null) goto L17;
        List r9 = r8.zj();
        if (r9 == null) goto L17;
        Message r10 = (Message) CollectionsKt.firstOrNull(r9);
    L18:
        i1 r3 = TtsGuideDelegate.b.f();
        if (r3 == null) goto L26;
        AnonymousClass1 r4 = new AnonymousClass1(this.this$0, r10);
        this.label = 1;
        if (r3.collect(r4, this) != r0) goto L24;
        return r0;
    L26:
        return Unit.INSTANCE;
    L17:
        r10 = null;
        goto L18
    L11:
        return Unit.INSTANCE;
    }
}
