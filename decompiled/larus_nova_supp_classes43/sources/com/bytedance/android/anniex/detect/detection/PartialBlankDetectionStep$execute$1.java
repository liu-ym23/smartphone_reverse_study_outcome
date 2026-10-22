package com.bytedance.android.anniex.detect.detection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PartialBlankDetectionStep", f = "PartialBlankDetectionStep.kt", i = {0, 0, 0}, l = {41, 119}, m = "execute", n = {"context", "resultDeferred", "start$iv"}, s = {"L$0", "L$1", "J$0"})
public final class PartialBlankDetectionStep$execute$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PartialBlankDetectionStep this$0;

    public PartialBlankDetectionStep$execute$1(PartialBlankDetectionStep r1, Continuation<? super PartialBlankDetectionStep$execute$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
