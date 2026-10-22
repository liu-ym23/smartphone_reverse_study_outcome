package com.obric.assistant.block.complex.call_for_me;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.aivoice.core.data.NameKeys;
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
@DebugMetadata(c = "com.obric.assistant.block.complex.call_for_me.ComplexCallForMeBlockHolder$jumpToCallPage$1", f = "ComplexCallForMeBlockHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ComplexCallForMeBlockHolder$jumpToCallPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public ComplexCallForMeBlockHolder$jumpToCallPage$1(Continuation<? super ComplexCallForMeBlockHolder$jumpToCallPage$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ComplexCallForMeBlockHolder$jumpToCallPage$1 r0 = new ComplexCallForMeBlockHolder$jumpToCallPage$1(r3);
        r0.L$0 = r2;
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
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L12
        Unit r8 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));     // Catch: Throwable -> L12
        if (r8 == null) goto L8;
        r8.showProxyCallHistory(NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L12
    L8:
        if (r8 != null) goto L10;
        FLogger.a.w("ComplexCallForMeBlockHolder", "IAgentAppIntentIDL is null");     // Catch: Throwable -> L12
        r8 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L12
    L14:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L18;
        FLogger.a.w("ComplexCallForMeBlockHolder", "showProxyCallHistory failed: " + r10.getMessage(), r10);
    L18:
        return Unit.INSTANCE;
    L12:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L14
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
