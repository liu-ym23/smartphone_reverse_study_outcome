package com.obric.aikernel.runtime.subproc;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.subproc.MainHost$Proxy", f = "MainHost.kt", i = {0, 0}, l = {217}, m = "requestPackage", n = {"biz", "lora"}, s = {"L$0", "L$1"})
final class MainHost$Proxy$requestPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainHost.Proxy this$0;

    MainHost$Proxy$requestPackage$1(MainHost.Proxy r10, Continuation<? super MainHost$Proxy$requestPackage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, this);
    }
}
