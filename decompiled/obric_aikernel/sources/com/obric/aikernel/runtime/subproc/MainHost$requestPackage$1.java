package com.obric.aikernel.runtime.subproc;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.subproc.MainHost", f = "MainHost.kt", i = {}, l = {65}, m = "requestPackage", n = {}, s = {})
final class MainHost$requestPackage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainHost this$0;

    MainHost$requestPackage$1(MainHost r10, Continuation<? super MainHost$requestPackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, this);
    }
}
