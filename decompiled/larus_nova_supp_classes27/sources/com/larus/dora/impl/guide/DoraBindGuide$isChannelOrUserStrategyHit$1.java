package com.larus.dora.impl.guide;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.DoraBindGuide", f = "DoraBindGuide.kt", i = {}, l = {221, 229, 236}, m = "isChannelOrUserStrategyHit", n = {}, s = {})
public final class DoraBindGuide$isChannelOrUserStrategyHit$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraBindGuide this$0;

    public DoraBindGuide$isChannelOrUserStrategyHit$1(DoraBindGuide r1, Continuation<? super DoraBindGuide$isChannelOrUserStrategyHit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DoraBindGuide r3 = this.this$0;
        int r0 = DoraBindGuide.p;
        return r3.k(this);
    }
}
