package com.obric.memorydata.memory.tracker;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.tracker.MemorySettingsSnapshotReporter", f = "MemorySettingsSnapshotReporter.kt", i = {}, l = {170}, m = "awaitSnapshotRequest", n = {}, s = {})
final class MemorySettingsSnapshotReporter$awaitSnapshotRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MemorySettingsSnapshotReporter this$0;

    MemorySettingsSnapshotReporter$awaitSnapshotRequest$1(MemorySettingsSnapshotReporter r3, Continuation<? super MemorySettingsSnapshotReporter$awaitSnapshotRequest$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return MemorySettingsSnapshotReporter.b(this.this$0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
