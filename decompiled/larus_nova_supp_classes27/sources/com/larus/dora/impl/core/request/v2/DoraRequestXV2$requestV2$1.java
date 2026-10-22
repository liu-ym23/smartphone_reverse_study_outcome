package com.larus.dora.impl.core.request.v2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.request.v2.DoraRequestXV2", f = "DoraRequestXV2.kt", i = {}, l = {178}, m = "requestV2", n = {}, s = {})
public final class DoraRequestXV2$requestV2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraRequestXV2 this$0;

    public DoraRequestXV2$requestV2$1(DoraRequestXV2 r1, Continuation<? super DoraRequestXV2$requestV2$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, this);
    }
}
