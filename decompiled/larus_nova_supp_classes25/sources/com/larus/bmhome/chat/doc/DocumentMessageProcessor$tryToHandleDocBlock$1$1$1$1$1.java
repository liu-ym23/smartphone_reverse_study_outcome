package com.larus.bmhome.chat.doc;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.doc.DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1", f = "DocumentMessageProcessor.kt", i = {}, l = {103, 107}, m = "invokeSuspend", n = {}, s = {})
final class DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isCurrentChatOnResume;
    final /* synthetic */ boolean $isDocList;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $token;
    int label;

    public DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1(Message r1, String r2, boolean r3, Context r4, boolean r5, Continuation<? super DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1> r6) {
        this.$message = r1;
        this.$token = r2;
        this.$isDocList = r3;
        this.$context = r4;
        this.$isCurrentChatOnResume = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1(this.$message, this.$token, this.$isDocList, this.$context, this.$isCurrentChatOnResume, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L16:
        Message r13 = (Message) r12;
        if (r13 == null) goto L24;
        Message r6 = this.$message;
        String r5 = this.$token;
        boolean r4 = this.$isDocList;
        Context r7 = this.$context;
        boolean r8 = this.$isCurrentChatOnResume;
        FLogger r2 = FLogger.a;
        String r3 = DocumentMessageProcessor.c;
        r2.i(r3, "find last message: " + r13.getMessageId());
        if (Intrinsics.areEqual(r13.getMessageId(), r6.getMessageId()) == false) goto L24;
        r2.i(r3, "jump it" + r5);
        MainCoroutineDispatcher r14 = Dispatchers.getMain();
        DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1$1$1 r9 = new DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1$1$1(r4, r5, r6, r7, r8, null);
        this.label = 2;
        if (BuildersKt.withContext(r14, r9, this) != r0) goto L24;
        return r0;
    L10:
        ResultKt.throwOnFailure(r12);
        IChatRepoService r15 = zh8.a.a;
        IChatRepoService r16 = zh8.a.a;
        String r10 = this.$message.getConversationId();
        if (r10 != null) goto L13;
        r10 = "";
    L13:
        this.label = 1;
        r12 = r16.D1(r10, this);
        if (r12 != r0) goto L16;
        return r0;
    }
}
