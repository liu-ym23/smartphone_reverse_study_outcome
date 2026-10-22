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
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DoraDynamicDataLoader$fetchData$1$1", f = "DoraDynamicDataLoader.kt", i = {}, l = {61}, m = "invokeSuspend", n = {}, s = {})
final class DoraDynamicDataLoader$fetchData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ a.b $callback;
    final /* synthetic */ String $key;
    final /* synthetic */ String $model;
    final /* synthetic */ String $pageKey;
    final /* synthetic */ Integer $productId;
    int label;
    final /* synthetic */ a this$0;

    public DoraDynamicDataLoader$fetchData$1$1(a r1, Integer r2, String r3, String r4, String r5, a.b r6, Continuation<? super DoraDynamicDataLoader$fetchData$1$1> r7) {
        this.this$0 = r1;
        this.$productId = r2;
        this.$model = r3;
        this.$pageKey = r4;
        this.$key = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new DoraDynamicDataLoader$fetchData$1$1(this.this$0, this.$productId, this.$model, this.$pageKey, this.$key, this.$callback, r10);
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
        a r2 = this.this$0;
        Integer r10 = this.$productId;
        String r3 = this.$model;
        String r4 = this.$pageKey;
        String r5 = this.$key;
        a.b r6 = this.$callback;
        this.label = 1;
        if (a.a(r2, r10, r3, r4, r5, r6, this) != r0) goto L12;
        return r0;
    }
}
