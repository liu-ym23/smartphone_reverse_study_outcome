package com.obric.aikernel.auto_test.impl.util;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.auto_test.impl.util.AppCPUUsage", f = "AppCPUUsage.kt", i = {0, 0, 0, 0, 0}, l = {101}, m = "getProcessCPUUsage", n = {"this", "pidList", "appCpuTime1", "cpuCores", "sysTime1"}, s = {"L$0", "L$1", "L$2", "I$0", "J$0"})
final class AppCPUUsage$getProcessCPUUsage$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppCPUUsage this$0;

    AppCPUUsage$getProcessCPUUsage$1(AppCPUUsage r10, Continuation<? super AppCPUUsage$getProcessCPUUsage$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AppCPUUsage.a(this.this$0, null, 0, this);
    }
}
