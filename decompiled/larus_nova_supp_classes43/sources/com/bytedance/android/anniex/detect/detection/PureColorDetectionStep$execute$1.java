package com.bytedance.android.anniex.detect.detection;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
@DebugMetadata(c = "com.bytedance.android.anniex.detect.detection.PureColorDetectionStep", f = "PureColorDetectionStep.kt", i = {0, 0, 0}, l = {34}, m = "execute", n = {"context", com.bytedance.android.ec.core.event.a.KEY_RESULT, "start$iv"}, s = {"L$0", "L$1", "J$0"})
public final class PureColorDetectionStep$execute$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PureColorDetectionStep this$0;

    public PureColorDetectionStep$execute$1(PureColorDetectionStep r1, Continuation<? super PureColorDetectionStep$execute$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
