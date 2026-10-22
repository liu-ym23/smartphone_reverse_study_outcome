package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.internal.legacy.NativeMessageServiceImpl;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1", f = "RealtimeFirstMetStrategy.kt", i = {2}, l = {56, 66, 81}, m = "invokeSuspend", n = {"realtimeOnboarding"}, s = {"L$0"})
public final class RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Ref.ObjectRef<List<Message>> $newOnBoardingMsgList;
    final /* synthetic */ BotOnBoarding $onBoarding;
    Object L$0;
    int label;
    final /* synthetic */ RealtimeFirstMetStrategy this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.model.strategy.RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1$1", f = "RealtimeFirstMetStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BotModel $bot;
        final /* synthetic */ String $conversationId;
        final /* synthetic */ Ref.ObjectRef<List<Message>> $newOnBoardingMsgList;
        int label;
        final /* synthetic */ RealtimeFirstMetStrategy this$0;

        public AnonymousClass1(RealtimeFirstMetStrategy r1, String r2, Ref.ObjectRef<List<Message>> r3, BotModel r4, Continuation<? super AnonymousClass1> r5) {
            this.this$0 = r1;
            this.$conversationId = r2;
            this.$newOnBoardingMsgList = r3;
            this.$bot = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.this$0, this.$conversationId, this.$newOnBoardingMsgList, this.$bot, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r31) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L24;
            ResultKt.throwOnFailure(r31);
            this.this$0.a.remove(this.$conversationId);
            RealtimeFirstMetStrategy r1 = this.this$0;
            String r5 = this.$conversationId;
            List r2 = (List) this.$newOnBoardingMsgList.element;
            String r3 = this.$bot.getBotId();
            if (r3 != null) goto L7;
            r3 = "";
        L7:
            r1.getClass();
            int r4 = 0;
            if (r2 == null) goto L12;
            boolean r6 = true;
            if ((!r2.isEmpty()) != true) goto L12;
        L13:
            if (r6 == false) goto L22;
            Iterator r25 = r2.iterator();
        L16:
            if (r25.hasNext() == false) goto L22;
            Object r7 = r25.next();
            int r26 = r4 + 1;
            if (r4 >= 0) goto L20;
            CollectionsKt.throwIndexOverflow();
        L20:
            Message r8 = (Message) r7;
            String r9 = com.larus.im.j.a(r3, r4);
            NativeMessageServiceImpl r10 = com.larus.im.d.e();
            int r11 = r8.getContentType();
            String r12 = r8.getContent();
            List r18 = CollectionsKt.listOf(Integer.valueOf(MessageTag.MessageTag_Onboarding_FIRSTMEG.value));
            String r28 = r3;
            String r13 = r5;
            r10.addMessage(new yc9.f0(r13, null, r28, 2, r11, r12, r9, null, 21, null, false, null, r8.getExt(), null, r8.getSuggestQuestions(), r18, null, null, null, r28, null, 518388418), null);
            r4 = r26;
            r3 = r28;
            r5 = r5;
        L22:
            return Unit.INSTANCE;
        L12:
            r6 = false;
            goto L13
        L24:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1(String r1, RealtimeFirstMetStrategy r2, BotModel r3, BotOnBoarding r4, Ref.ObjectRef<List<Message>> r5, Continuation<? super RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1> r6) {
        this.$conversationId = r1;
        this.this$0 = r2;
        this.$bot = r3;
        this.$onBoarding = r4;
        this.$newOnBoardingMsgList = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1(this.$conversationId, this.this$0, this.$bot, this.$onBoarding, this.$newOnBoardingMsgList, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r5 = true;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        BotOnBoarding r2 = (BotOnBoarding) this.L$0;
        ResultKt.throwOnFailure(r11);
    L60:
        RealtimeFirstMetStrategy r12 = this.this$0;
        BotModel r3 = this.$bot;
        String r4 = this.$conversationId;
        BotOnBoarding r6 = this.$onBoarding;
        r12.getClass();
        RealtimeFirstMetStrategy.c(r3, r4, r6, r2);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r11);
    L25:
        BotOnBoarding r13 = (BotOnBoarding) r11;
        if (r13 == null) goto L28;
        List r7 = r13.getMessageList();
    L29:
        List r8 = r7;
        if (r8 != null) goto L32;
    L35:
        boolean r9 = true;
    L36:
        if (r9 == false) goto L55;
        BotOnBoarding r10 = this.$onBoarding;
        if (r10 == null) goto L51;
        List r14 = r10.getMessageList();
        if (r14 != null) goto L42;
    L45:
        boolean r15 = true;
    L46:
        if (r15 == true) goto L51;
        if (r10.getCallMode() != 1) goto L51;
    L52:
        if (r5 == false) goto L54;
        Ref.ObjectRef<List<Message>> r16 = this.$newOnBoardingMsgList;
        r16.element = this.$onBoarding.getMessageList();
        FLogger.a.d("RealtimeFirstMetStrategy", "updateLocalOnboarding called, use content pool");
    L56:
        RepoDispatcher.a.getClass();
        ExecutorCoroutineDispatcher r17 = RepoDispatcher.b;
        AnonymousClass1 r18 = new AnonymousClass1(this.this$0, this.$conversationId, this.$newOnBoardingMsgList, this.$bot, null);
        this.L$0 = r13;
        this.label = 3;
        if (BuildersKt.withContext(r17, r18, this) != r0) goto L59;
        return r0;
    L59:
        r2 = r13;
        goto L60
    L54:
        FLogger.a.d("RealtimeFirstMetStrategy", "updateLocalOnboarding called, don't use content pool, empty");
        goto L56
    L42:
        if (r14.isEmpty() == true) goto L45;
        r15 = false;
    L51:
        r5 = false;
        goto L52
    L55:
        this.$newOnBoardingMsgList.element = r7;
        FLogger.a.d("RealtimeFirstMetStrategy", "updateLocalOnboarding called, use realtime");
        goto L56
    L32:
        if (r8.isEmpty() == true) goto L35;
        r9 = false;
        goto L36
    L28:
        r7 = null;
        goto L29
    L11:
        ResultKt.throwOnFailure(r11);
    L16:
        if (((Message) CollectionsKt.firstOrNull((List) r11)) == null) goto L19;
        FLogger.a.d("RealtimeFirstMetStrategy", "updateLocalOnboarding called, latestMsg is onBoarding msg, don't need fetch first met to update");
        this.this$0.a.remove(this.$conversationId);
        return Unit.INSTANCE;
    L19:
        RealtimeFirstMetStrategy r19 = this.this$0;
        String r20 = this.$bot.getBotId();
        if (r20 != null) goto L22;
        r20 = "";
    L22:
        this.label = 2;
        r11 = RealtimeFirstMetStrategy.a(r19, r20, this);
        if (r11 != r0) goto L25;
        return r0;
    L12:
        ResultKt.throwOnFailure(r11);
        RepoDispatcher.a.getClass();
        ChatRepo r110 = RepoDispatcher.d;
        String r21 = this.$conversationId;
        this.label = 1;
        r11 = r110.o1(r21, 1, this);
        if (r11 != r0) goto L16;
        return r0;
    }
}
