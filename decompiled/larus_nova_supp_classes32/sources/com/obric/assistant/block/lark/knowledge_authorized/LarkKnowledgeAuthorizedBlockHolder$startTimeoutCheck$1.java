package com.obric.assistant.block.lark.knowledge_authorized;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.lark.knowledge_authorized.LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1", f = "LarkKnowledgeAuthorizedBlockHolder.kt", i = {0}, l = {345}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ LarkKnowledgeAuthorizedBlockHolder this$0;

    public LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1(LarkKnowledgeAuthorizedBlockHolder r1, Continuation<? super LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1 r0 = new LarkKnowledgeAuthorizedBlockHolder$startTimeoutCheck$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L11:
        if (CoroutineScopeKt.isActive(r2) == false) goto L24;
        Message r3 = this.this$0.g;
        if (r3 == null) goto L17;
        long r5 = r3.getCreateTime();
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "isMessageTimeout: createTime = " + r5 + " , currentTime = " + System.currentTimeMillis());
        if ((System.currentTimeMillis() - (r5 * ((long) 1000))) <= AutoEndConversationTime.AFTER_20_SECONDS) goto L17;
        boolean r4 = true;
    L18:
        if (r4 == true) goto L19;
        this.L$0 = r2;
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    L19:
        FLogger.a.i("KnowledgeAuthorizedBlockHolder", "Message timeout detected, disabling card");
        this.this$0.l();
    L17:
        r4 = false;
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        r2 = (CoroutineScope) this.L$0;
        goto L11
    }
}
