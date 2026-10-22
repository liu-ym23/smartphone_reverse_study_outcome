package com.larus.dora.impl.core.request.v2;

import com.larus.dora.impl.frameassembler.DoraAggregateFrameAssembler;
import com.larus.dora.impl.frameassembler.e;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.j;
import vj4.c;
import vj4.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/util/DoraExtKt$suspendCoroutineWithTimeoutOrNull$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.request.v2.DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1", f = "DoraRequestXV2.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a>, Object> {
    final /* synthetic */ AtomicBoolean $isResumed$inlined;
    final /* synthetic */ c $requestEvent$inlined;
    final /* synthetic */ int $requestId$inlined;
    final /* synthetic */ long $startTime$inlined;
    Object L$0;
    int label;

    public DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1(Continuation r1, int r2, c r3, AtomicBoolean r4, long r5) {
        this.$requestId$inlined = r2;
        this.$requestEvent$inlined = r3;
        this.$isResumed$inlined = r4;
        this.$startTime$inlined = r5;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraRequestXV2$requestV2$$inlined$suspendCoroutineWithTimeoutOrNull$1(r9, this.$requestId$inlined, this.$requestEvent$inlined, this.$isResumed$inlined, this.$startTime$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L20:
        return r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        this.label = 1;
        j r15 = new j(IntrinsicsKt.intercepted(this), 1);
        r15.C();
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        DoraRequestXV2.c r11 = new DoraRequestXV2.c(this.$isResumed$inlined, r2, r15, this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined);
        int r3 = e.m;
        e.a r4 = new e.a();
        r4.a = 10000;
        DoraAggregateFrameAssembler r5 = new DoraAggregateFrameAssembler(new e(r4), r11);
        DoraRequestXV2.a r6 = new DoraRequestXV2.a(this.$requestId$inlined, r5);
        r2.element = r6;
        vj4.b r7 = vj4.b.a.a;
        ((CopyOnWriteArraySet) r7.a).add(r6);
        DoraRequestXV2.b(this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined, false, "start");
        int r8 = r7.b(this.$requestId$inlined, this.$requestEvent$inlined);
        DoraRequestXV2.b(this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined, false, "ret=" + r8);
        if (r8 != 0) goto L11;
    L15:
        r15.i(new DoraRequestXV2.b(r5, r2, this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined));
        r14 = r15.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(this);
    L18:
        if (r14 != r0) goto L20;
        return r0;
    L11:
        if (r8 == (-3)) goto L15;
        r7.c((d) r2.element);
        if (this.$isResumed$inlined.compareAndSet(false, true) == false) goto L15;
        DoraRequestXV2.b(this.$requestId$inlined, this.$requestEvent$inlined, this.$startTime$inlined, true, "failed");
        Result.Companion r9 = Result.Companion;
        r15.resumeWith(Result.constructor-impl(new a.C0030a(new RuntimeException("exception, reason: " + r8))));
        goto L15
    }
}
