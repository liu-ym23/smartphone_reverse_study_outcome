package com.larus.dora.impl.guide.strategy;

import com.larus.dora.impl.core.t;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1", f = "FineDoraDeviceStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ FineDoraDeviceStrategy $this_runCatching;
    int label;

    public FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1(FineDoraDeviceStrategy r1, Continuation<? super FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1> r2) {
        this.$this_runCatching = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new FineDoraDeviceStrategy$isConditionMet$isSppAvailable$1$1(this.$this_runCatching, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        Lazy r3 = t.a;
        return Boxing.boxBoolean(t.c(this.$this_runCatching.a, UUID.fromString("00101020-4C42-0065-636E-614465747942")));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
