package com.larus.bmhome.chat.component.bottom;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.ChatMessageComponent$resendMessage$2", f = "ChatMessageComponent.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
final class ChatMessageComponent$resendMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $conversation;
    final /* synthetic */ Message $replyMessage;
    final /* synthetic */ String $resendScene;
    final /* synthetic */ String $traceScene;
    int label;
    final /* synthetic */ ChatMessageComponent this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.ChatMessageComponent$resendMessage$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.ChatMessageComponent$resendMessage$2$1", f = "ChatMessageComponent.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ e $conversation;
        final /* synthetic */ Message $replyMessage;
        final /* synthetic */ String $resendScene;
        final /* synthetic */ String $traceScene;
        int label;
        final /* synthetic */ ChatMessageComponent this$0;

        public AnonymousClass1(ChatMessageComponent r1, e r2, Message r3, String r4, String r5, Continuation<? super AnonymousClass1> r6) {
            this.this$0 = r1;
            this.$conversation = r2;
            this.$replyMessage = r3;
            this.$traceScene = r4;
            this.$resendScene = r5;
            super(1, r6);
        }

        public final Continuation<Unit> create(Continuation<?> r9) {
            return new AnonymousClass1(this.this$0, this.$conversation, this.$replyMessage, this.$traceScene, this.$resendScene, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((Continuation) r1);
        }

        public final Object invoke(Continuation<? super Unit> r2) {
            return create(r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            ChatMessageComponent r12 = this.this$0;
            int r2 = ChatMessageComponent.j;
            ChatMessageViewModel r3 = r12.L2();
            e r4 = this.$conversation;
            Message r5 = this.$replyMessage;
            String r6 = this.$traceScene;
            String r7 = this.$resendScene;
            ChatPageContext r8 = this.this$0.F2();
            this.label = 1;
            if (r3.resendMessage(r4, r5, r6, r7, r8, this) != r0) goto L12;
            return r0;
        }
    }

    public ChatMessageComponent$resendMessage$2(ChatMessageComponent r1, e r2, Message r3, String r4, String r5, Continuation<? super ChatMessageComponent$resendMessage$2> r6) {
        this.this$0 = r1;
        this.$conversation = r2;
        this.$replyMessage = r3;
        this.$traceScene = r4;
        this.$resendScene = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatMessageComponent$resendMessage$2(this.this$0, this.$conversation, this.$replyMessage, this.$traceScene, this.$resendScene, r9);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        ChatMessageComponent r12 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(r12, this.$conversation, this.$replyMessage, this.$traceScene, this.$resendScene, null);
        this.label = 1;
        int r3 = ChatMessageComponent.j;
        if (r12.P2("resendMessage", r2, this) != r0) goto L12;
        return r0;
    }
}
