package com.obric.aiagent.messenger.stub;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IFlowIsMessageInterruptedCallbackIDL;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.MessageIDLStub$isMessageLocalInterrupted$1", f = "MessageIDLStub.kt", i = {0}, l = {1096}, m = "invokeSuspend", n = {"isLocalInterrupted"}, s = {"I$0"})
public final class MessageIDLStub$isMessageLocalInterrupted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFlowIsMessageInterruptedCallbackIDL $callback;
    final /* synthetic */ String $messageId;
    int I$0;
    Object L$0;
    int label;

    public MessageIDLStub$isMessageLocalInterrupted$1(String r1, IFlowIsMessageInterruptedCallbackIDL r2, Continuation<? super MessageIDLStub$isMessageLocalInterrupted$1> r3) {
        this.$messageId = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MessageIDLStub$isMessageLocalInterrupted$1(this.$messageId, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Integer r2 = null;
        boolean r3 = false;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r4 = this.I$0;
        IFlowIsMessageInterruptedCallbackIDL r5 = (IFlowIsMessageInterruptedCallbackIDL) this.L$0;
        ResultKt.throwOnFailure(r9);
    L14:
        Message r10 = (Message) r9;
        if (r10 == null) goto L17;
        r2 = Boxing.boxInt(r10.getMessageStatusLocal());
    L17:
        FLogger r6 = FLogger.a;
        StringBuilder r7 = new StringBuilder("isMessageLocalInterrupted, ");
        if (r4 == 0) goto L20;
        boolean r8 = true;
    L21:
        r7.append(r8);
        r7.append(", ");
        r7.append(r2);
        r7.append(", ");
        r7.append(r10);
        r6.i("IFlowMessageIDLSPI", r7.toString());
        if (r5 == null) goto L39;
        if (r4 != 0) goto L36;
        if (r2 != null) goto L26;
    L28:
        boolean r11 = false;
    L29:
        if (r11 == true) goto L36;
        if (r2 != null) goto L32;
    L34:
        boolean r12 = false;
    L35:
        if (r12 == true) goto L36;
    L37:
        r5.onResult(r3);
        goto L39
    L32:
        if (r2.equals(Boxing.boxInt(12)) != true) goto L34;
        r12 = true;
        goto L35
    L26:
        if (r2.equals(Boxing.boxInt(13)) != true) goto L28;
        r11 = true;
    L36:
        r3 = true;
    L39:
        return Unit.INSTANCE;
    L20:
        r8 = false;
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        String r13 = this.$messageId;
        if (r13 == null) goto L40;
        r5 = this.$callback;
        int r14 = !com.larus.im.internal.core.message.utils.f.a(r13, null) ? 1 : 0;
        IChatRepoService r15 = RepoDispatcherDelegate.b.e();
        this.L$0 = r5;
        this.I$0 = r14;
        this.label = 1;
        r9 = r15.E1(r13, this);
        if (r9 != r0) goto L13;
        return r0;
    L13:
        r4 = r14;
        goto L14
    L40:
        IFlowIsMessageInterruptedCallbackIDL r16 = this.$callback;
        if (r16 == null) goto L44;
        r16.onResult(false);
    L44:
        return Unit.INSTANCE;
    }
}
