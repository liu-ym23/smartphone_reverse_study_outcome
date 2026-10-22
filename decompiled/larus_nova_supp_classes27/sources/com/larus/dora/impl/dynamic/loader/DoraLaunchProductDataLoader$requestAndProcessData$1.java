package com.larus.dora.impl.dynamic.loader;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DoraLaunchProductDataLoader", f = "DoraLaunchProductDataLoader.kt", i = {0, 0}, l = {173}, m = "requestAndProcessData", n = {"key", "callback"}, s = {"L$0", "L$1"})
final class DoraLaunchProductDataLoader$requestAndProcessData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public DoraLaunchProductDataLoader$requestAndProcessData$1(b r1, Continuation<? super DoraLaunchProductDataLoader$requestAndProcessData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return b.a(this.this$0, null, null, this);
    }
}
