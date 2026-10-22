package com.larus.dora.impl.guide.service;

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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.DoraGuideServiceImpl$waitInitReady$2", f = "DoraGuideServiceImpl.kt", i = {}, l = {292}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGuideServiceImpl$waitInitReady$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ long $checkIntervalMs;
    int label;
    final /* synthetic */ DoraGuideServiceImpl this$0;

    public DoraGuideServiceImpl$waitInitReady$2(DoraGuideServiceImpl r1, long r2, Continuation<? super DoraGuideServiceImpl$waitInitReady$2> r4) {
        this.this$0 = r1;
        this.$checkIntervalMs = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraGuideServiceImpl$waitInitReady$2(this.this$0, this.$checkIntervalMs, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
    L10:
        if (this.this$0.b == true) goto L15;
        long r3 = this.$checkIntervalMs;
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L10;
        return r0;
    L15:
        return Boxing.boxBoolean(true);
    }
}
