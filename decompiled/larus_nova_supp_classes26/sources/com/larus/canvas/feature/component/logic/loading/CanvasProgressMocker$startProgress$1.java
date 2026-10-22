package com.larus.canvas.feature.component.logic.loading;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.loading.CanvasProgressMocker$startProgress$1", f = "CanvasProgressMocker.kt", i = {1, 1}, l = {33, 55}, m = "invokeSuspend", n = {"previousProgress", "duration"}, s = {"L$0", "D$0"})
final class CanvasProgressMocker$startProgress$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $startDelay;
    double D$0;
    Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public CanvasProgressMocker$startProgress$1(long r1, a r3, Continuation<? super CanvasProgressMocker$startProgress$1> r4) {
        this.$startDelay = r1;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CanvasProgressMocker$startProgress$1(this.$startDelay, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x0136 -> B:45:0x0137). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r17) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        double r3 = 100.0d;
        boolean r8 = true;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        double r9 = this.D$0;
        Ref.IntRef r1 = (Ref.IntRef) this.L$0;
        ResultKt.throwOnFailure(r17);
        double r10 = r9;
        CanvasProgressMocker$startProgress$1 r11 = this;
    L45:
        r3 = 100.0d;
    L35:
        int r12 = ((Number) r11.this$0.f.getValue()).intValue();
        a r13 = r11.this$0;
        if (r12 >= r13.b) goto L47;
        int r14 = (int) Math.floor(Math.pow(1.0d - (1.0d / ((r13.c * r10) + 1.0d)), 2.0d) * r3);
        if (r14 < r1.element) goto L40;
        r11.this$0.e.setValue(Boxing.boxInt(r14));
        r1.element = r14;
        FLogger.a.i("CanvasProgressMocker", "newProgress: " + r14 + ", duration: " + r10);
    L41:
        double r4 = 0.1d + r10;
        r11.L$0 = r1;
        r11.D$0 = r4;
        r11.label = 2;
        if (DelayKt.delay(100, r11) != r2) goto L44;
        return r2;
    L44:
        r10 = r4;
        goto L45
    L40:
        FLogger.a.i("CanvasProgressMocker", "skip newProgress: " + r14 + ", duration: " + r10 + ", previous: " + r1.element);
        goto L41
    L47:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r17);
    L13:
        Ref.IntRef r15 = new Ref.IntRef();
        a r5 = this.this$0;
        int r6 = RangesKt.coerceIn((int) r5.d, 0, r5.b);
        r15.element = r6;
        if (r6 <= 0) goto L16;
        this.this$0.e.setValue(Boxing.boxInt(r6));
    L16:
        a r7 = this.this$0;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L28
        int r18 = r15.element;     // Catch: Throwable -> L28
        if (1 <= r18) goto L20;
    L22:
        r8 = false;
    L23:
        if (r8 == false) goto L25;
        double r19 = ((1.0d / (1.0d - Math.sqrt(((double) r18) / 100.0d))) - 1.0d) / r7.c;     // Catch: Throwable -> L28
    L26:
        Object r20 = Result.constructor-impl(Boxing.boxDouble(r19));     // Catch: Throwable -> L28
    L31:
        if (Result.exceptionOrNull-impl(r20) == null) goto L34;
        r20 = Boxing.boxDouble(0.0d);
    L34:
        r10 = ((Number) r20).doubleValue();
        r11 = this;
        r1 = r15;
        goto L35
    L25:
        r19 = 0.0d;
        goto L26
    L20:
        if (r18 >= r7.b) goto L22;
    L28:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L10:
        ResultKt.throwOnFailure(r17);
        long r22 = this.$startDelay;
        this.label = 1;
        if (DelayKt.delay(r22, this) != r2) goto L13;
        return r2;
    }
}
