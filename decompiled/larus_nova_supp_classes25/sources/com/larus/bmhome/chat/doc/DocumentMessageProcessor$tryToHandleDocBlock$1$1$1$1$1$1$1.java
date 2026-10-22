package com.larus.bmhome.chat.doc;

import android.content.Context;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.doc.DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1$1$1", f = "DocumentMessageProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isCurrentChatOnResume;
    final /* synthetic */ boolean $isDocList;
    final /* synthetic */ Message $message;
    final /* synthetic */ String $token;
    int label;

    public DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1$1$1(boolean r1, String r2, Message r3, Context r4, boolean r5, Continuation<? super DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1$1$1> r6) {
        this.$isDocList = r1;
        this.$token = r2;
        this.$message = r3;
        this.$context = r4;
        this.$isCurrentChatOnResume = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DocumentMessageProcessor$tryToHandleDocBlock$1$1$1$1$1$1$1(this.$isDocList, this.$token, this.$message, this.$context, this.$isCurrentChatOnResume, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        Message r6 = DocumentMessageProcessor.a;
        DocumentMessageProcessor.a(this.$isDocList, this.$token, this.$message, this.$context, this.$isCurrentChatOnResume);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
