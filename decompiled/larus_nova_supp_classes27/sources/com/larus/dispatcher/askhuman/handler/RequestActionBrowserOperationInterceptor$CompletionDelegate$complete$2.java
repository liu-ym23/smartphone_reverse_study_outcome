package com.larus.dispatcher.askhuman.handler;

import java.lang.ref.WeakReference;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.askhuman.handler.RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2", f = "RequestActionBrowserOperationInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ hv8.a $request;
    int label;
    final /* synthetic */ RequestActionBrowserOperationInterceptor.CompletionDelegate this$0;

    public RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2(RequestActionBrowserOperationInterceptor.CompletionDelegate r1, hv8.a r2, Continuation<? super RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new RequestActionBrowserOperationInterceptor$CompletionDelegate$complete$2(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r5);
        WeakReference<Function1<com.larus.bmhome.taskskill.service.k, Unit>> r6 = this.this$0.b;
        if (r6 == null) goto L9;
        Function1<com.larus.bmhome.taskskill.service.k, Unit> r7 = r6.get();
        if (r7 == null) goto L9;
        r7.invoke(com.larus.bmhome.taskskill.service.k.g.a);
    L9:
        Set<Integer> r8 = n.a;
        hv8.a r9 = this.$request;
        String r0 = r9.b;
        String r1 = r9.c;
        int r10 = r9.d;
        Intrinsics.checkNotNullParameter(r0, "messageId");
        zh8.a.a.r1(r0, new l(r1, r10));
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
