package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.auth.OnboardingActionCardData;
import com.larus.bmhome.bot.utils.a;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.extension.offline_message.api.OfflineMessageServiceDelegate;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$init$3", f = "ChatListComponentViewModel.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$init$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $currentChatSession;
    final /* synthetic */ Function0<wc9.e> $getConversation;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponentViewModel$init$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$init$3$1", f = "ChatListComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $currentChatSession;
        final /* synthetic */ Function0<wc9.e> $getConversation;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChatListComponentViewModel this$0;

        public AnonymousClass1(Function0<wc9.e> r1, ChatListComponentViewModel r2, long r3, Continuation<? super AnonymousClass1> r5) {
            this.$getConversation = r1;
            this.this$0 = r2;
            this.$currentChatSession = r3;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$getConversation, this.this$0, this.$currentChatSession, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((wc9.e) r1, (Continuation) r2);
        }

        public final Object invoke(wc9.e r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L22;
            ResultKt.throwOnFailure(r5);
            wc9.e r6 = (wc9.e) this.L$0;
            Function0<wc9.e> r0 = this.$getConversation;
            if (r0 == null) goto L7;
            wc9.e r1 = (wc9.e) r0.invoke();
        L8:
            if (r1 == null) goto L19;
            if (r6 == null) goto L11;
            String r7 = r6.a;
        L13:
            if (Intrinsics.areEqual(r7, r1.a) == false) goto L19;
            if (ic8.n.v(r1) == false) goto L17;
        L18:
            ChatListComponentViewModel.access$getOnBoardingActionCardData$p(this.this$0).put(OnboardingActionCardData.CardScene.FirstMet, new Pair(Boxing.boxBoolean(false), null));
            goto L19
        L17:
            if (ic8.n.D(r1) != true) goto L19;
        L11:
            r7 = null;
        L19:
            OfflineMessageServiceDelegate.b.f(this.$currentChatSession);
            return Unit.INSTANCE;
        L7:
            r1 = null;
            goto L8
        L22:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatListComponentViewModel$init$3(Function0<wc9.e> r1, ChatListComponentViewModel r2, long r3, Continuation<? super ChatListComponentViewModel$init$3> r5) {
        this.$getConversation = r1;
        this.this$0 = r2;
        this.$currentChatSession = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ChatListComponentViewModel$init$3(this.$getConversation, this.this$0, this.$currentChatSession, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        MutableSharedFlow<wc9.e> r11 = a.a;
        MutableSharedFlow<wc9.e> r12 = a.a;
        AnonymousClass1 r2 = new AnonymousClass1(this.$getConversation, this.this$0, this.$currentChatSession, null);
        this.label = 1;
        if (kotlinx.coroutines.flow.e.i(r12, r2, this) != r0) goto L12;
        return r0;
    }
}
