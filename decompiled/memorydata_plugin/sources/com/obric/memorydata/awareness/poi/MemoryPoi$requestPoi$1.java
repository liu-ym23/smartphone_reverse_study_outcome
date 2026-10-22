package com.obric.memorydata.awareness.poi;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.awareness.poi.MemoryPoi", f = "MemoryPoi.kt", i = {0, 0, 0, 0}, l = {57}, m = "requestPoi", n = {"this", "latitude", "longitude", "radius"}, s = {"L$0", "D$0", "D$1", "I$0"})
final class MemoryPoi$requestPoi$1 extends ContinuationImpl {
    double D$0;
    double D$1;
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    MemoryPoi$requestPoi$1(a r3, Continuation<? super MemoryPoi$requestPoi$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return a.a(this.this$0, 0.0d, 0.0d, 0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
