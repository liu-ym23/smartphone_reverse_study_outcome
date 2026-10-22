package com.larus.dora.impl.bridge;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.bridge.DoraNetworkRequestMethod", f = "DoraNetworkRequestMethod.kt", i = {}, l = {109, 127}, m = "executeRequest", n = {}, s = {})
final class DoraNetworkRequestMethod$executeRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ r this$0;

    public DoraNetworkRequestMethod$executeRequest$1(r r1, Continuation<? super DoraNetworkRequestMethod$executeRequest$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return r.a(this.this$0, null, null, null, null, false, null, this);
    }
}
