package com.larus.canvas.feature.component.logic.canvasGenerator;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.canvasGenerator.CanvasGenerator$startStreamGenerate$1$kmpJob$1", f = "CanvasImageGenerator.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class CanvasGenerator$startStreamGenerate$1$kmpJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CanvasGenerator$startStreamGenerate$1.b $callback;
    final /* synthetic */ ky8.c $requestParam;
    int label;

    public CanvasGenerator$startStreamGenerate$1$kmpJob$1(ky8.c r1, CanvasGenerator$startStreamGenerate$1.b r2, Continuation<? super CanvasGenerator$startStreamGenerate$1$kmpJob$1> r3) {
        this.$requestParam = r1;
        this.$callback = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CanvasGenerator$startStreamGenerate$1$kmpJob$1(this.$requestParam, this.$callback, r4);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L13
    L20:
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        h r5 = h.a;     // Catch: Throwable -> L13
        ky8.c r6 = this.$requestParam;     // Catch: Throwable -> L13
        CanvasGenerator$startStreamGenerate$1.b r2 = this.$callback;     // Catch: Throwable -> L13
        this.label = 1;     // Catch: Throwable -> L13
        if (h.c(r6, r2, this) != r0) goto L20;
        return r0;
    L13:
        th = move-exception;
        FLogger.a.e("CanvasGenerator", "SSE_KMP kmp sse failed localId=" + this.$requestParam.c + " type=" + Reflection.getOrCreateKotlinClass(th.getClass()).getSimpleName() + " msg=" + th.getMessage());
        CanvasGenerator$startStreamGenerate$1.b r3 = this.$callback;
        String r7 = th.getMessage();
        if (r7 != null) goto L17;
        r7 = "";
    L17:
        r3.onError(-90001, r7);
        goto L19
    }
}
