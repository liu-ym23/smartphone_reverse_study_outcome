package com.larus.dora.impl.feature;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feature.DoraFeature", f = "DoraFeature.kt", i = {}, l = {39, 61, 61, 61}, m = "requestFeature", n = {}, s = {})
public final class DoraFeature$requestFeature$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraFeature this$0;

    public DoraFeature$requestFeature$1(DoraFeature r1, Continuation<? super DoraFeature$requestFeature$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
