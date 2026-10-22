package com.obric.aikernel.utils;

import android.os.SystemClock;
import android.util.Log;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.utils.OScDSPUsageUtils$startTrackJob$1$1", f = "OScDSPUsageUtils.kt", i = {0}, l = {60}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class OScDSPUsageUtils$startTrackJob$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    OScDSPUsageUtils$startTrackJob$1$1(Continuation<? super OScDSPUsageUtils$startTrackJob$1$1> r10) {
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        OScDSPUsageUtils$startTrackJob$1$1 r12 = new OScDSPUsageUtils$startTrackJob$1$1(r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((OScDSPUsageUtils$startTrackJob$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        l0 r13 = (l0) this.L$0;
        ResultKt.throwOnFailure(r10);
    L18:
        m0.e(r13);
    L10:
        if (m0.f(r13) == false) goto L20;
        long r14 = SystemClock.elapsedRealtime();
        OScDSPUsageUtils r15 = OScDSPUsageUtils.f5582a;
        if ((r14 - r15.e()) <= 50000) goto L15;
        Log.d("OScDSPUsageUtils", "Job stopped: lastRunTimeStamp is too old (interval > 50s)");
        OScDSPUsageUtils.b().set(null);
        return Unit.INSTANCE;
    L15:
        OScDSPUsageUtils.d(r15);
        this.L$0 = r13;
        this.label = 1;
        if (DelayKt.b(5000, this) != r11) goto L18;
        return r11;
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r13 = (l0) this.L$0;
        goto L10
    }
}
