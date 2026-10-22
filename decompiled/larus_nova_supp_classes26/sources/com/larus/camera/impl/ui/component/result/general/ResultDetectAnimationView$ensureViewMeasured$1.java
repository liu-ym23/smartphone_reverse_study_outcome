package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultDetectAnimationView", f = "ResultDetectAnimationView.kt", i = {0}, l = {148, 137}, m = "ensureViewMeasured", n = {"$this$ensureViewMeasured"}, s = {"L$0"})
public final class ResultDetectAnimationView$ensureViewMeasured$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResultDetectAnimationView this$0;

    public ResultDetectAnimationView$ensureViewMeasured$1(ResultDetectAnimationView r1, Continuation<? super ResultDetectAnimationView$ensureViewMeasured$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ResultDetectAnimationView r3 = this.this$0;
        int r0 = ResultDetectAnimationView.d;
        return r3.j(null, this);
    }
}
