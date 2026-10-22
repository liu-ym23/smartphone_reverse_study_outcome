package com.obric.aikernel.service.res;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.DecryptFeature", f = "DecryptFeature.kt", i = {0, 0, 0}, l = {40, 42}, m = "decrypt", n = {"installPath", "srcPath", "targetPath"}, s = {"L$0", "L$1", "L$2"})
final class DecryptFeature$decrypt$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DecryptFeature this$0;

    DecryptFeature$decrypt$1(DecryptFeature r10, Continuation<? super DecryptFeature$decrypt$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, this);
    }
}
