package com.larus.camera.impl.widget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.widget.EduPreviewLoadingView", f = "EduPreviewLoadingView.kt", i = {0}, l = {142, 131}, m = "ensureViewMeasured", n = {"$this$ensureViewMeasured"}, s = {"L$0"})
public final class EduPreviewLoadingView$ensureViewMeasured$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EduPreviewLoadingView this$0;

    public EduPreviewLoadingView$ensureViewMeasured$1(EduPreviewLoadingView r1, Continuation<? super EduPreviewLoadingView$ensureViewMeasured$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        EduPreviewLoadingView r3 = this.this$0;
        int r0 = EduPreviewLoadingView.d;
        return r3.j(null, this);
    }
}
