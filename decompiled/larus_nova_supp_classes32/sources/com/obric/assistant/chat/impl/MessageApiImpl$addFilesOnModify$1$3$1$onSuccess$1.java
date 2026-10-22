package com.obric.assistant.chat.impl;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$addFilesOnModify$1$3$1$onSuccess$1", f = "MessageApiImpl.kt", i = {0}, l = {433, 435}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
final class MessageApiImpl$addFilesOnModify$1$3$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    Object L$0;
    Object L$1;
    int label;

    public MessageApiImpl$addFilesOnModify$1$3$1$onSuccess$1(Message r1, Continuation<? super MessageApiImpl$addFilesOnModify$1$3$1$onSuccess$1> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessageApiImpl$addFilesOnModify$1$3$1$onSuccess$1(this.$message, r3);
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
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        String r2 = (String) this.L$1;
        Message r3 = (Message) this.L$0;
        ResultKt.throwOnFailure(r11);
    L10:
        String r5 = r2;
        FLogger.a.i("MessageApiImpl", "oReplaceContentOnModify, modifyMessageContent, success,IV: reportDeleteMessage");
        IChatRepoService r4 = RepoDispatcherDelegate.b.e();
        List r6 = CollectionsKt.listOf(r3);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r4.C1(r5, r6, false, false, this) != r0) goto L21;
        return r0;
    L11:
        ResultKt.throwOnFailure(r11);
        r2 = this.$message.getConversationId();
        if (r2 == null) goto L21;
        Message r12 = this.$message;
        this.L$0 = r12;
        this.L$1 = r2;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L16;
        return r0;
    L16:
        r3 = r12;
        goto L10
    }
}
