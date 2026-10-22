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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/setting/impl/ManualCacheCleanUiController$ManualCleanOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.setting.impl.ManualCacheCleanUiController$clean$terminalTask$1", f = "ManualCacheCleanUiController.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
final class ManualCacheCleanUiController$clean$terminalTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ManualCacheCleanUiController.a>, Object> {
    final /* synthetic */ long $beforeBytes;
    final /* synthetic */ String $currentPage;
    final /* synthetic */ String $operationId;
    final /* synthetic */ long $startTime;
    int label;

    public ManualCacheCleanUiController$clean$terminalTask$1(long r1, String r3, String r4, long r5, Continuation<? super ManualCacheCleanUiController$clean$terminalTask$1> r7) {
        this.$beforeBytes = r1;
        this.$operationId = r3;
        this.$currentPage = r4;
        this.$startTime = r5;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ManualCacheCleanUiController$clean$terminalTask$1(this.$beforeBytes, this.$operationId, this.$currentPage, this.$startTime, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ManualCacheCleanUiController.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ManualCacheCleanUiController r2 = ManualCacheCleanUiController.a;
        long r3 = this.$beforeBytes;
        String r11 = this.$operationId;
        String r5 = this.$currentPage;
        long r6 = this.$startTime;
        this.label = 1;
        r10 = ManualCacheCleanUiController.b(r2, r3, r11, r5, r6, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
