package com.larus.common.mockloading;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.mockloading.ILoadingProgressMocker$DefaultImpls", f = "ILoadingProgressMocker.kt", i = {0, 0, 0}, l = {31}, m = "startProgress", n = {"$this", "duration", "previousProgress"}, s = {"L$0", "D$0", "I$0"})
public final class ILoadingProgressMocker$startProgress$1 extends ContinuationImpl {
    double D$0;
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public ILoadingProgressMocker$startProgress$1(Continuation<? super ILoadingProgressMocker$startProgress$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ILoadingProgressMocker.DefaultImpls.a(null, this);
    }
}
