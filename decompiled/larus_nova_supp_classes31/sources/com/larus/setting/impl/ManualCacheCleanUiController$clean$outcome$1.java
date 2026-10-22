package com.larus.setting.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/setting/impl/ManualCacheCleanUiController$ManualCleanOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController$clean$outcome$1", f = "ManualCacheCleanUiController.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
final class ManualCacheCleanUiController$clean$outcome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManualCacheCleanUiController.a>, Object> {
    final /* synthetic */ Deferred<ManualCacheCleanUiController.a> $terminalTask;
    int label;

    public ManualCacheCleanUiController$clean$outcome$1(Deferred<ManualCacheCleanUiController.a> r1, Continuation<? super ManualCacheCleanUiController$clean$outcome$1> r2) {
        this.$terminalTask = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ManualCacheCleanUiController$clean$outcome$1(this.$terminalTask, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ManualCacheCleanUiController.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        Deferred<ManualCacheCleanUiController.a> r5 = this.$terminalTask;
        this.label = 1;
        r4 = r5.await(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
