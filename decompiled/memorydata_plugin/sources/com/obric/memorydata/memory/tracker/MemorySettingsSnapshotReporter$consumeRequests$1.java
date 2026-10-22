package com.obric.memorydata.memory.tracker;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.tracker.MemorySettingsSnapshotReporter", f = "MemorySettingsSnapshotReporter.kt", i = {0, 1}, l = {140, 142}, m = "consumeRequests", n = {"this", "this"}, s = {"L$0", "L$0"})
final class MemorySettingsSnapshotReporter$consumeRequests$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemorySettingsSnapshotReporter this$0;

    MemorySettingsSnapshotReporter$consumeRequests$1(MemorySettingsSnapshotReporter r3, Continuation<? super MemorySettingsSnapshotReporter$consumeRequests$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return MemorySettingsSnapshotReporter.a(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
