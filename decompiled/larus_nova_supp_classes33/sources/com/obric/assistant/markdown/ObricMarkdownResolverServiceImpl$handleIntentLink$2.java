package com.obric.assistant.markdown;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.markdown.ObricMarkdownResolverServiceImpl$handleIntentLink$2", f = "ObricMarkdownResolverServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ObricMarkdownResolverServiceImpl$handleIntentLink$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $uri;
    private /* synthetic */ Object L$0;
    int label;

    public ObricMarkdownResolverServiceImpl$handleIntentLink$2(String r1, Continuation<? super ObricMarkdownResolverServiceImpl$handleIntentLink$2> r2) {
        this.$uri = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricMarkdownResolverServiceImpl$handleIntentLink$2 r0 = new ObricMarkdownResolverServiceImpl$handleIntentLink$2(this.$uri, r4);
        r0.L$0 = r3;
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
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        String r7 = this.$uri;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        Unit r2 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L12
        if (r2 == null) goto L8;
        r2.showProxyCallHistory(r7);     // Catch: Throwable -> L12
    L8:
        if (r2 != null) goto L10;
        FLogger.a.w("ObricMarkdownResolverServiceImpl", "handleIntentLink: IAgentAppIntentIDL is null");     // Catch: Throwable -> L12
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r8 = Result.constructor-impl(r2);     // Catch: Throwable -> L12
    L14:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L18;
        FLogger.a.w("ObricMarkdownResolverServiceImpl", "handleIntentLink: showProxyCallHistory failed: " + r9.getMessage(), r9);
    L18:
        return Unit.INSTANCE;
    L12:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
