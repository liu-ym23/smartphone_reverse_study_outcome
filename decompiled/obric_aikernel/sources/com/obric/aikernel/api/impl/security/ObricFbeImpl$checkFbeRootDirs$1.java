package com.obric.aikernel.api.impl.security;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.api.impl.security.ObricFbeImpl", f = "ObricFbeImpl.kt", i = {}, l = {31, 32, 35}, m = "checkFbeRootDirs", n = {}, s = {})
final class ObricFbeImpl$checkFbeRootDirs$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricFbeImpl this$0;

    ObricFbeImpl$checkFbeRootDirs$1(ObricFbeImpl r10, Continuation<? super ObricFbeImpl$checkFbeRootDirs$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return ObricFbeImpl.b(this.this$0, this);
    }
}
