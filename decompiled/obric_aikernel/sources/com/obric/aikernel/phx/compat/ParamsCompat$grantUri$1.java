package com.obric.aikernel.phx.compat;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.compat.ParamsCompat", f = "ParamsCompat.kt", i = {0, 0, 0, 0}, l = {31}, m = "grantUri", n = {"this", "filePath", "fd", "timeoutMs"}, s = {"L$0", "L$1", "L$2", "J$0"})
final class ParamsCompat$grantUri$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ParamsCompat this$0;

    ParamsCompat$grantUri$1(ParamsCompat r10, Continuation<? super ParamsCompat$grantUri$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return ParamsCompat.a(this.this$0, null, null, 0, this);
    }
}
