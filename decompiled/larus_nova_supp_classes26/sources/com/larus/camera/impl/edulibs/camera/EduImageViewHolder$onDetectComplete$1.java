package com.larus.camera.impl.edulibs.camera;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.edulibs.camera.EduImageViewHolder", f = "EduImageViewHolder.kt", i = {0, 1, 2}, l = {532, 534, 538, 545, 549}, m = "onDetectComplete", n = {"result", "result", "result"}, s = {"L$0", "L$0", "L$0"})
final class EduImageViewHolder$onDetectComplete$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c this$0;

    public EduImageViewHolder$onDetectComplete$1(c r1, Continuation<? super EduImageViewHolder$onDetectComplete$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return c.r(this.this$0, null, this);
    }
}
