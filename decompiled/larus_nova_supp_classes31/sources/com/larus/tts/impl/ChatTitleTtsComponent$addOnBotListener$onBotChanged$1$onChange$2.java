package com.larus.tts.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.platform.service.z2;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2", f = "ChatTitleTtsComponent.kt", i = {0, 1}, l = {311, 331}, m = "invokeSuspend", n = {"title", "title"}, s = {"L$0", "L$0"})
final class ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $new;
    Object L$0;
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    /* JADX INFO: renamed from: com.larus.tts.impl.ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ ChatTitleTtsComponent this$0;

        public AnonymousClass1(ChatTitleTtsComponent r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r46) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r46);
            Object r3 = r46;
        L12:
            return Boxing.boxBoolean(((Boolean) r3).booleanValue());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r46);
            ChatTitleTtsComponent r5 = this.this$0;
            int r6 = ChatTitleTtsComponent.v;
            e r4 = new e(r5.P2(), null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -258, 63);
            IConversationRepoService r7 = RepoDispatcherDelegate.b.f();
            String r8 = r4.a;
            boolean r9 = r4.i;
            this.label = 1;
            r3 = r7.p(r8, r9, this);
            if (r3 != r1) goto L12;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.larus.tts.impl.ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
    @DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2$3", f = "ChatTitleTtsComponent.kt", i = {}, l = {336}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;
        final /* synthetic */ ChatTitleTtsComponent this$0;

        public AnonymousClass3(ChatTitleTtsComponent r1, Continuation<? super AnonymousClass3> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass3(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r46) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r46);
            Object r3 = r46;
        L18:
            return Boxing.boxBoolean(((Boolean) r3).booleanValue());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r46);
            ChatTitleTtsComponent r4 = this.this$0;
            int r5 = ChatTitleTtsComponent.v;
            String r6 = r4.P2();
            com.larus.platform.api.g0 r7 = this.this$0.Y2();
            if (r7 != null) goto L11;
        L13:
            boolean r13 = false;
        L14:
            e r8 = new e(r6, null, null, null, null, null, null, null, r13, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 0, 0, null, null, 0, -258, 63);
            IConversationRepoService r9 = RepoDispatcherDelegate.b.f();
            String r10 = r8.a;
            boolean r11 = r8.i;
            this.label = 1;
            r3 = r9.p(r10, r11, this);
            if (r3 != r1) goto L18;
            return r1;
        L11:
            if (r7.getTtsChecked() != true) goto L13;
            r13 = true;
            goto L14
        }
    }

    public ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2(ChatTitleTtsComponent r1, BotModel r2, Continuation<? super ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2> r3) {
        this.this$0 = r1;
        this.$new = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatTitleTtsComponent$addOnBotListener$onBotChanged$1$onChange$2(this.this$0, this.$new, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        final com.larus.platform.api.g0 r2 = (com.larus.platform.api.g0) this.L$0;
        ResultKt.throwOnFailure(r8);
    L36:
        ((Boolean) r8).booleanValue();
    L60:
        final ChatTitleTtsComponent r9 = this.this$0;
        final BotModel r3 = this.$new;
        r2.setOnTtsCheckedListener(new o(r9, r2, r3));
        if (z2.a.ttsSwitchLongPressConfig().a() == false) goto L64;
        final ChatTitleTtsComponent r10 = this.this$0;
        r2.setOnTtsLongPressAction(new p(r10));
    L64:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r2 = (com.larus.platform.api.g0) this.L$0;
        ResultKt.throwOnFailure(r8);
    L59:
        ((Boolean) r8).booleanValue();
        goto L60
    L10:
        ResultKt.throwOnFailure(r8);
        ChatTitleTtsComponent r11 = this.this$0;
        int r4 = ChatTitleTtsComponent.v;
        com.larus.platform.api.g0 r12 = r11.Y2();
        if (r12 != null) goto L15;
        return Unit.INSTANCE;
    L15:
        if (o0.d(this.$new.getBotId()) == false) goto L64;
        if (this.$new.getMuted() == true) goto L37;
        SpeakerVoice r5 = this.$new.getVoiceType();
        if (r5 == null) goto L21;
        String r6 = r5.getId();
    L23:
        if (Intrinsics.areEqual(r6, "0") == true) goto L37;
        com.larus.platform.api.g0 r7 = this.this$0.Y2();
        if (r7 == null) goto L32;
        SpeakerVoice r13 = this.$new.getVoiceType();
        if (r13 == null) goto L30;
        String r14 = r13.getId();
    L31:
        r7.setTtsBanned(Intrinsics.areEqual(r14, "0"));
        goto L32
    L30:
        r14 = null;
    L32:
        LiveData r15 = AuthModelDelegate.b.y();
        final ChatTitleTtsComponent r16 = this.this$0;
        r15.observe(r16, new ChatTitleTtsComponent$b(new n(r16)));
        ExecutorCoroutineDispatcher r17 = RepoDispatcherDelegate.b.g();
        AnonymousClass3 r18 = new AnonymousClass3(this.this$0, null);
        this.L$0 = r12;
        this.label = 2;
        Object r19 = BuildersKt.withContext(r17, r18, this);
        if (r19 != r0) goto L35;
        return r0;
    L35:
        r2 = r12;
        r8 = r19;
        goto L36
    L21:
        r6 = null;
    L37:
        com.larus.platform.api.g0 r20 = this.this$0.Y2();
        if (r20 == null) goto L40;
        r20.setTtsBanned(true);
    L40:
        ChatTitleTtsComponent r21 = this.this$0;
        MutableLiveData r22 = r21.j;
        com.larus.platform.api.g0 r23 = r21.Y2();
        boolean r24 = false;
        if (r23 != null) goto L43;
    L45:
        boolean r25 = false;
    L46:
        if (r25 == false) goto L55;
        com.larus.platform.api.g0 r26 = this.this$0.Y2();
        if (r26 != null) goto L50;
    L52:
        boolean r27 = false;
    L53:
        if (r27 == false) goto L55;
        r24 = true;
        goto L55
    L50:
        if (r26.getTtsChecked() != true) goto L52;
        r27 = true;
    L55:
        r22.setValue(Boxing.boxBoolean(r24));
        ExecutorCoroutineDispatcher r28 = RepoDispatcherDelegate.b.g();
        AnonymousClass1 r29 = new AnonymousClass1(this.this$0, null);
        this.L$0 = r12;
        this.label = 1;
        Object r30 = BuildersKt.withContext(r28, r29, this);
        if (r30 != r0) goto L58;
        return r0;
    L58:
        r2 = r12;
        r8 = r30;
        goto L59
    L43:
        if (r23.getTtsBanned() == true) goto L45;
        r25 = true;
        goto L46
    }
}
