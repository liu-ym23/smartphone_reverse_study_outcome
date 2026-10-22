package com.larus.suggest.impl.popup.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.popup.model.PopWindowRepo", f = "PopWindowRepo.kt", i = {}, l = {34}, m = "reportShow", n = {}, s = {})
public final class PopWindowRepo$reportShow$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PopWindowRepo this$0;

    public PopWindowRepo$reportShow$1(PopWindowRepo r1, Continuation<? super PopWindowRepo$reportShow$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
