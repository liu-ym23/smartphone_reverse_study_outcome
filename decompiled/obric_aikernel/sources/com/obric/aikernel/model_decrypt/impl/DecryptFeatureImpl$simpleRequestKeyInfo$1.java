package com.obric.aikernel.model_decrypt.impl;

import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.model_decrypt.impl.DecryptFeatureImpl", f = "DecryptFeatureImpl.kt", i = {}, l = {180}, m = "simpleRequestKeyInfo-BWLJW6A", n = {}, s = {})
final class DecryptFeatureImpl$simpleRequestKeyInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DecryptFeatureImpl this$0;

    DecryptFeatureImpl$simpleRequestKeyInfo$1(DecryptFeatureImpl r10, Continuation<? super DecryptFeatureImpl$simpleRequestKeyInfo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        Object r11 = this.this$0.mo19simpleRequestKeyInfoBWLJW6A(null, null, null, this);
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r11;
    L6:
        return Result.m31boximpl(r11);
    }
}
