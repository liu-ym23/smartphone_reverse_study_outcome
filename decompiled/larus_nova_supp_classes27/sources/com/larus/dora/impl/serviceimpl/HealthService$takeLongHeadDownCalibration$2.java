package com.larus.dora.impl.serviceimpl;

import com.larus.utils.logger.FLogger;
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
import zj4.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.serviceimpl.HealthService$takeLongHeadDownCalibration$2", f = "HealthService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HealthService$takeLongHeadDownCalibration$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ HealthService this$0;

    public HealthService$takeLongHeadDownCalibration$2(HealthService r1, Continuation<? super HealthService$takeLongHeadDownCalibration$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new HealthService$takeLongHeadDownCalibration$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        HealthService r6 = this.this$0;     // Catch: Throwable -> L9
        int r1 = HealthService.d;     // Catch: Throwable -> L9
        r6.getClass();     // Catch: Throwable -> L9
        a r7 = HealthService.h();     // Catch: Throwable -> L9
        if (r7 == null) goto L11;
        Integer r8 = Boxing.boxInt(r7.i());     // Catch: Throwable -> L9
    L12:
        FLogger.a.i("HealthService", "takeLongHeadDownCalibration: status=" + r8);
        return r8;
    L11:
        r8 = null;
    L9:
        th = move-exception;
        FLogger.a.e("HealthService", "takeLongHeadDownCalibration failed", th);
        goto L11
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
