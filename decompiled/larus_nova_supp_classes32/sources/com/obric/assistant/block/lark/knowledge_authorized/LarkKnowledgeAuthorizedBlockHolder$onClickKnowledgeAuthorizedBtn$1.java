package com.obric.assistant.block.lark.knowledge_authorized;

import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.block.lark.knowledge_authorized.LarkKnowledgeAuthorizedBlockHolder$onClickKnowledgeAuthorizedBtn$1", f = "LarkKnowledgeAuthorizedBlockHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LarkKnowledgeAuthorizedBlockHolder$onClickKnowledgeAuthorizedBtn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clarifyContent;
    final /* synthetic */ Map<String, String> $extra;
    final /* synthetic */ Message $message;
    private /* synthetic */ Object L$0;
    int label;

    public LarkKnowledgeAuthorizedBlockHolder$onClickKnowledgeAuthorizedBtn$1(Message r1, String r2, Map<String, String> r3, Continuation<? super LarkKnowledgeAuthorizedBlockHolder$onClickKnowledgeAuthorizedBtn$1> r4) {
        this.$message = r1;
        this.$clarifyContent = r2;
        this.$extra = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        LarkKnowledgeAuthorizedBlockHolder$onClickKnowledgeAuthorizedBtn$1 r0 = new LarkKnowledgeAuthorizedBlockHolder$onClickKnowledgeAuthorizedBtn$1(this.$message, this.$clarifyContent, this.$extra, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        Message r7 = this.$message;
        String r0 = this.$clarifyContent;
        Map<String, String> r1 = this.$extra;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L13
        IAgentAppIntentIDL r3 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L13
        String r4 = null;
        if (r3 == null) goto L11;
        Map r8 = r7.getExt();     // Catch: Throwable -> L13
        if (r8 == null) goto L10;
        r4 = (String) r8.get("o_reference_msg_id");     // Catch: Throwable -> L13
    L10:
        r3.replyAskUser(r4, r0, "飞书知识问答同意授权", r1);     // Catch: Throwable -> L13
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L13
    L11:
        Object r9 = Result.constructor-impl(r4);     // Catch: Throwable -> L13
    L15:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L19;
        FLogger.a.w("KnowledgeAuthorizedBlockHolder", "replyAskUser failed: " + r10.getMessage(), r10);
    L19:
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
