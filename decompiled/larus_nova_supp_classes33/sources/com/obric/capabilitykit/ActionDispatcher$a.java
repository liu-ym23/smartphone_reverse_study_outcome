package com.obric.capabilitykit;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.capabilitykit.ActionDispatcher$launchWithTrace$1", f = "ActionDispatcher.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
public final class ActionDispatcher$a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    private /* synthetic */ Object b;
    public final /* synthetic */ long c;
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> d;

    public ActionDispatcher$a(long r1, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super ActionDispatcher$a> r4) {
        this.c = r1;
        this.d = r3;
        super(2, r4);
    }

    public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        ActionDispatcher$a r0 = new ActionDispatcher$a(this.c, this.d, r6);
        r0.b = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return a((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.a;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        ActionDispatcher.access$markDispatchEnded(ActionDispatcher.INSTANCE, this.c);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.b;
        ActionDispatcher.access$markDispatchStarted(ActionDispatcher.INSTANCE, this.c);
        Function2<CoroutineScope, Continuation<? super Unit>, Object> r2 = this.d;
        this.a = 1;
        if (r2.invoke(r7, this) != r0) goto L11;
        return r0;
    }
}
