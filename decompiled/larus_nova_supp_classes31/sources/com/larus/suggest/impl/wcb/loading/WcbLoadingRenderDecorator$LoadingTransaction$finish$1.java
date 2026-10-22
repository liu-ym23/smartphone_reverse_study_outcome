package com.larus.suggest.impl.wcb.loading;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.loading.WcbLoadingRenderDecorator$LoadingTransaction", f = "WcbLoadingRenderDecorator.kt", i = {}, l = {117, 109, 117, 113, 117, 117}, m = "finish", n = {}, s = {})
public final class WcbLoadingRenderDecorator$LoadingTransaction$finish$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WcbLoadingRenderDecorator.LoadingTransaction this$0;

    public WcbLoadingRenderDecorator$LoadingTransaction$finish$1(WcbLoadingRenderDecorator.LoadingTransaction r1, Continuation<? super WcbLoadingRenderDecorator$LoadingTransaction$finish$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
