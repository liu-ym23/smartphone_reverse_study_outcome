package com.obric.aikernel.res.update;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdaterKt", f = "PackageUpdater.kt", i = {0, 0, 0, 0}, l = {216}, m = "awaitUpdateTargetResult", n = {"biz", "constriction", "source", TypedValues.CycleType.S_WAVE_PHASE}, s = {"L$0", "L$1", "L$2", "L$3"})
final class PackageUpdaterKt$awaitUpdateTargetResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    PackageUpdaterKt$awaitUpdateTargetResult$1(Continuation<? super PackageUpdaterKt$awaitUpdateTargetResult$1> r10) {
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return PackageUpdaterKt.a(null, null, null, null, null, this);
    }
}
