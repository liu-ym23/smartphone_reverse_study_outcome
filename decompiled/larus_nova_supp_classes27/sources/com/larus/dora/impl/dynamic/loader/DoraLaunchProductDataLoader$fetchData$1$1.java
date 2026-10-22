package com.larus.dora.impl.dynamic.loader;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DoraLaunchProductDataLoader$fetchData$1$1", f = "DoraLaunchProductDataLoader.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
final class DoraLaunchProductDataLoader$fetchData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b.InterfaceC0065b $callback;
    final /* synthetic */ String $key;
    int label;
    final /* synthetic */ b this$0;

    public DoraLaunchProductDataLoader$fetchData$1$1(b r1, String r2, b.InterfaceC0065b r3, Continuation<? super DoraLaunchProductDataLoader$fetchData$1$1> r4) {
        this.this$0 = r1;
        this.$key = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraLaunchProductDataLoader$fetchData$1$1(this.this$0, this.$key, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        b r6 = this.this$0;
        String r2 = this.$key;
        b.InterfaceC0065b r3 = this.$callback;
        this.label = 1;
        if (b.a(r6, r2, r3, this) != r0) goto L12;
        return r0;
    }
}
