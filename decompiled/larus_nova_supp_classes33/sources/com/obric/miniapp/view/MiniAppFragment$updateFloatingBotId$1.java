package com.obric.miniapp.view;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppFragment", f = "MiniAppFragment.kt", i = {}, l = {855, 859}, m = "updateFloatingBotId", n = {}, s = {})
final class MiniAppFragment$updateFloatingBotId$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MiniAppFragment this$0;

    public MiniAppFragment$updateFloatingBotId$1(MiniAppFragment r1, Continuation<? super MiniAppFragment$updateFloatingBotId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MiniAppFragment.U90(this.this$0, null, this);
    }
}
