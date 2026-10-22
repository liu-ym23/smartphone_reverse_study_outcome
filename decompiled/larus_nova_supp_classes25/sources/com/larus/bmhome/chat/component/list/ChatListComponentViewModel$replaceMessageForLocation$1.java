package com.larus.bmhome.chat.component.list;

import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.chat.stop.PendingAppletActionCancellation;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$replaceMessageForLocation$1", f = "ChatListComponentViewModel.kt", i = {}, l = {1135, 1137}, m = "invokeSuspend", n = {}, s = {})
public final class ChatListComponentViewModel$replaceMessageForLocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.list.ChatListComponentViewModel$replaceMessageForLocation$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$replaceMessageForLocation$1$1", f = "ChatListComponentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $message;
        final /* synthetic */ Message $question;
        int label;
        final /* synthetic */ ChatListComponentViewModel this$0;

        public AnonymousClass1(Message r1, Message r2, ChatListComponentViewModel r3, Continuation<? super AnonymousClass1> r4) {
            this.$message = r1;
            this.$question = r2;
            this.this$0 = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$message, this.$question, this.this$0, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r5);
            if (PendingAppletActionCancellation.a.c(this.$message, this.$question) == true) goto L7;
            FLogger.a.i("need_location", "replaceMsgOnModifySendAfterAck triggered, messageId[" + this.$message.getMessageId() + ']');
            ChatListComponentViewModel r6 = this.this$0;
            Message r0 = this.$question;
            String r1 = d.r(r0);
            if (r1 != null) goto L11;
            r1 = "";
        L11:
            r6.replaceMsgOnModifySendAfterAck(r0, r1, this.$question.getExt(), true);
            return Unit.INSTANCE;
        L7:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public ChatListComponentViewModel$replaceMessageForLocation$1(Message r1, ChatListComponentViewModel r2, Continuation<? super ChatListComponentViewModel$replaceMessageForLocation$1> r3) {
        this.$message = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponentViewModel$replaceMessageForLocation$1(this.$message, this.this$0, r4);
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
        ResultKt.throwOnFailure(r8);
    L29:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L17:
        Message r9 = (Message) r8;
        if (r9 != null) goto L22;
        return Unit.INSTANCE;
    L22:
        if (PendingAppletActionCancellation.a.c(this.$message, r9) == true) goto L24;
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.$message, r9, this.this$0, null);
        this.label = 2;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L29;
        return r0;
    L24:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r8);
        PendingAppletActionCancellation r10 = PendingAppletActionCancellation.a;
        Message r4 = this.$message;
        r10.getClass();
        if (PendingAppletActionCancellation.b(r4) == true) goto L13;
        RepoDispatcher.a.getClass();
        ChatRepo r11 = RepoDispatcher.d;
        Message r5 = this.$message;
        this.label = 1;
        r8 = r11.y1(r5, this);
        if (r8 != r0) goto L17;
        return r0;
    L13:
        return Unit.INSTANCE;
    }
}
