package com.obric.aiagent.messenger.stub;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.IMMessage;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$retryFetchMessage$1", f = "MessageIDLStub.kt", i = {}, l = {1034}, m = "invokeSuspend", n = {}, s = {})
public final class MessageIDLStub$retryFetchMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMMessage $message;
    int label;

    public MessageIDLStub$retryFetchMessage$1(IMMessage r1, Continuation<? super MessageIDLStub$retryFetchMessage$1> r2) {
        this.$message = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MessageIDLStub$retryFetchMessage$1(this.$message, r3);
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
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Message r7 = (Message) r6;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("retryFetchMessage, isSuccess = ");
        if (r7 != null) goto L15;
        r2 = false;
    L15:
        r4.append(r2);
        r3.i("IFlowMessageIDLSPI", r4.toString());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        IChatRepoService r8 = RepoDispatcherDelegate.b.e();
        String r5 = this.$message.getConversationId();
        long r9 = this.$message.getServerIndex();
        this.label = 1;
        r6 = r8.v1(r5, r9, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
