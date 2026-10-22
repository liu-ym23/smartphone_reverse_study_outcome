package com.larus.bmhome.view.actionbar.gaokao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.gaokao.GaokaoRankCalculator", f = "GaokaoRankCalculator.kt", i = {0}, l = {17}, m = "calculateRank", n = {"context"}, s = {"L$0"})
public final class GaokaoRankCalculator$calculateRank$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GaokaoRankCalculator this$0;

    public GaokaoRankCalculator$calculateRank$1(GaokaoRankCalculator r1, Continuation<? super GaokaoRankCalculator$calculateRank$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, this);
    }
}
