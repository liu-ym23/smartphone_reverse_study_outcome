package com.larus.common.mockloading;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.mockloading.IMessageLoadingProgressMocker$DefaultImpls", f = "IMessageLoadingProgressMocker.kt", i = {0, 0, 0, 1, 1, 1, 1, 1}, l = {14, 37}, m = "startProgress", n = {"$this", "loadingTaskId", "progressStep", "$this", "loadingTaskId", "previousProgress", "progressStep", "duration"}, s = {"L$0", "L$1", "D$0", "L$0", "L$1", "L$2", "D$0", "D$1"})
final class IMessageLoadingProgressMocker$startProgress$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public IMessageLoadingProgressMocker$startProgress$1(Continuation<? super IMessageLoadingProgressMocker$startProgress$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return a$a.a(null, null, 0, 0.0d, this);
    }
}
