package com.larus.crossplatform.card.impl;

import com.larus.utils.cache.DiskCache;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$deletePluginViewCacheData$1", f = "LynxRenderDataRepo.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
final class LynxRenderDataRepo$deletePluginViewCacheData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $key;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public LynxRenderDataRepo$deletePluginViewCacheData$1(String r1, Function1<? super Boolean, Unit> r2, Continuation<? super LynxRenderDataRepo$deletePluginViewCacheData$1> r3) {
        this.$key = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new LynxRenderDataRepo$deletePluginViewCacheData$1(this.$key, this.$callback, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        boolean r5 = ((Boolean) r4).booleanValue();
        Function1<Boolean, Unit> r2 = this.$callback;
        if (r2 == null) goto L15;
        r2.invoke(Boxing.boxBoolean(r5));
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        DiskCache r6 = LynxRenderDataRepo.b;
        String r3 = this.$key;
        this.label = 1;
        r4 = r6.e(r3, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
