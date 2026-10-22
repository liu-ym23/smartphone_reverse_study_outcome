package com.larus.bmhome.resource.access;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.DetachedResourceNodeDispatcher$launch$1", f = "ResourceAccessPipeline.kt", i = {}, l = {392}, m = "invokeSuspend", n = {}, s = {})
final class DetachedResourceNodeDispatcher$launch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h0 $context;
    final /* synthetic */ l0 $node;
    final /* synthetic */ f $task;
    int label;

    public DetachedResourceNodeDispatcher$launch$1(f r1, h0 r2, l0 r3, Continuation<? super DetachedResourceNodeDispatcher$launch$1> r4) {
        this.$task = r1;
        this.$context = r2;
        this.$node = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DetachedResourceNodeDispatcher$launch$1(this.$task, this.$context, this.$node, r5);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        ResourceNodeRunner r2 = ResourceNodeRunner.a;
        f r10 = this.$task;
        h0 r3 = this.$context;
        l0 r4 = this.$node;
        this.label = 1;
        if (r2.a(r10, r3, r4, false, true, this) != r0) goto L12;
        return r0;
    }
}
