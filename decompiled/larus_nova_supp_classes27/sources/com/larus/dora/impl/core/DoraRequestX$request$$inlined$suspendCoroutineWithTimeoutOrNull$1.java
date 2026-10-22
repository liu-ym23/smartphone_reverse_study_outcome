package com.larus.dora.impl.core;

import android.util.ArrayMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import qk4.e;
import qk4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$suspendCoroutineWithTimeoutOrNull$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1", f = "DoraRequestX.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super v39.b>, Object> {
    final /* synthetic */ AtomicBoolean $isResumed$inlined;
    final /* synthetic */ e $requestEvent$inlined;
    final /* synthetic */ int $requestId$inlined;
    final /* synthetic */ long $startTime$inlined;
    Object L$0;
    int label;

    public DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1(Continuation r1, int r2, e r3, AtomicBoolean r4, long r5) {
        this.$requestId$inlined = r2;
        this.$requestEvent$inlined = r3;
        this.$isResumed$inlined = r4;
        this.$startTime$inlined = r5;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraRequestX$request$$inlined$suspendCoroutineWithTimeoutOrNull$1(r9, this.$requestId$inlined, this.$requestEvent$inlined, this.$isResumed$inlined, this.$startTime$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super v39.b> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L27:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        this.label = 1;
        kotlinx.coroutines.j r14 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r14.C();
        ArrayMap r2 = g.j;
        g r3 = g.a.a;
        q0 r11 = new q0(this.$requestId$inlined, r3, this.$isResumed$inlined, r14, this.$requestEvent$inlined, this.$startTime$inlined);
        ((CopyOnWriteArraySet) r3.e).add(r11);
        s0.c(this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined, "start");
        int r4 = this.$requestId$inlined;
        e r5 = this.$requestEvent$inlined;
        pk4.j.d("DoraVisionCore", "request: requestId=" + r4 + ", requestEvent=" + r5);
        int r6 = r3.b.i(r5.getSid(), r5.getCid(), r5.getData(r4));
        s0.c(this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined, "ret=" + r6);
        if (r6 != 0) goto L11;
    L22:
        r14.i(new p0(r3, r11, this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined));
        r13 = r14.B();
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
        DebugProbesKt.probeCoroutineSuspended(this);
    L25:
        if (r13 != r0) goto L27;
        return r0;
    L11:
        if (r6 == (-3)) goto L22;
        ((CopyOnWriteArraySet) r3.e).remove(r11);
        if (r6 != (-3)) goto L15;
        Object r7 = v39.b.c.b;
    L20:
        if (this.$isResumed$inlined.compareAndSet(false, true) == false) goto L22;
        s0.b(this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined, true, "failed");
        r14.resumeWith(Result.constructor-impl(r7));
        goto L22
    L15:
        if (r6 == (-2)) goto L17;
        r7 = v39.b.d.b;
        goto L20
    L17:
        r7 = v39.b.a.b;
        goto L20
    }
}
