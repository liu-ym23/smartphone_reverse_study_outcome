package com.larus.doc.impl;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/im/bean/conversation/Conversation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1", f = "DocServiceImpl.kt", i = {}, l = {439}, m = "invokeSuspend", n = {}, s = {})
public final class DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super wc9.e>, Object> {
    final /* synthetic */ String $remoteConvId;
    int label;

    public DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1(String r1, Continuation<? super DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1> r2) {
        this.$remoteConvId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DocServiceImpl$refreshFloatChatRemoteBinding$2$remoteConv$1(this.$remoteConvId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super wc9.e> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L14:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        IConversationRepoService r3 = RepoDispatcherDelegate.b.f();
        String r11 = this.$remoteConvId;
        if (r11 != null) goto L11;
        r11 = "";
    L11:
        this.label = 1;
        r10 = IConversationRepoService.a.c(r3, r11, false, null, this, 6);
        if (r10 != r0) goto L14;
        return r0;
    }
}
