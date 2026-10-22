package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.AndroidG2OtaRuntime", f = "G2OtaRuntime.kt", i = {0, 0, 1, 1}, l = {505, 519}, m = "connect", n = {"effect", "emit", "effect", "emit"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class AndroidG2OtaRuntime$connect$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidG2OtaRuntime this$0;

    public AndroidG2OtaRuntime$connect$1(AndroidG2OtaRuntime r1, Continuation<? super AndroidG2OtaRuntime$connect$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AndroidG2OtaRuntime r3 = this.this$0;
        String r0 = AndroidG2OtaRuntime.TAG;
        return r3.i(null, null, this);
    }
}
