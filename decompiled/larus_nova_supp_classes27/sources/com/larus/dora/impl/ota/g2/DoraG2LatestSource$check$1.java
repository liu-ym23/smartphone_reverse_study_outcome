package com.larus.dora.impl.ota.g2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g2.DoraG2LatestSource", f = "G2OtaRuntime.kt", i = {0}, l = {699}, m = "check", n = {"effect"}, s = {"L$0"})
public final class DoraG2LatestSource$check$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraG2LatestSource this$0;

    public DoraG2LatestSource$check$1(DoraG2LatestSource r1, Continuation<? super DoraG2LatestSource$check$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
