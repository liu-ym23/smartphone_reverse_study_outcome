package com.larus.suggest.impl.wcb.loading;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.loading.WcbLoadingRenderDecorator$LoadingTransaction", f = "WcbLoadingRenderDecorator.kt", i = {}, l = {135}, m = "deprecatePreviousTarget", n = {}, s = {})
public final class WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbLoadingRenderDecorator.LoadingTransaction this$0;

    public WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1(WcbLoadingRenderDecorator.LoadingTransaction r1, Continuation<? super WcbLoadingRenderDecorator$LoadingTransaction$deprecatePreviousTarget$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
