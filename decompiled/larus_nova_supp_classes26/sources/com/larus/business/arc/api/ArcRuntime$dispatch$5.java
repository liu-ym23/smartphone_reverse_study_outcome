package com.larus.business.arc.api;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.business.arc.api.ArcRuntime$dispatch$5", f = "ArcRuntime.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ArcRuntime$dispatch$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArcCallLifecycle $lifecycle;
    int label;

    public ArcRuntime$dispatch$5(ArcCallLifecycle r1, Continuation<? super ArcRuntime$dispatch$5> r2) {
        this.$lifecycle = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ArcRuntime$dispatch$5(this.$lifecycle, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L34;
        ResultKt.throwOnFailure(r3);
        u r4 = u.a;
        ArcCallLifecycle r0 = this.$lifecycle;
        r4.getClass();
        g r5 = r0.i();     // Catch: Throwable -> L7
    L8:
        boolean r1 = false;
        if (r5 != null) goto L41;
        r0.getClass();
        if (r0.c.c() == false) goto L17;
        if (r0.d.a(false, true) == false) goto L17;
        r1 = true;
    L17:
        if (r1 == false) goto L32;
        u.d("ARC_OBSERVABILITY_OBSERVATION_INVALID");
    L32:
        return Unit.INSTANCE;
    L41:
        r1 = Intrinsics.areEqual(r5.c.b().c, "UNCLASSIFIED");     // Catch: Throwable -> L21
    L22:
        if (r1 == false) goto L35;
        u.d("ARC_OBSERVABILITY_BIZ_CODE_REDACTED");
    L35:
        pd6.b r6 = pd6.c.a;     // Catch: Throwable -> L30
        a0 r7 = (a0) pd6.c.a(Reflection.getOrCreateKotlinClass(a0.class));     // Catch: Throwable -> L30
        if (r7 != null) goto L43;
        u.d("ARC_OBSERVABILITY_REPORTER_UNAVAILABLE");
        goto L32
    L43:
        r7.report();     // Catch: Throwable -> L29
    L29:
        u.d("ARC_OBSERVABILITY_REPORT_FAILURE");
    L30:
        u.d("ARC_OBSERVABILITY_REPORTER_LOOKUP_FAILURE");
    L7:
        r0.k();
        r5 = null;
        goto L8
    L34:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
