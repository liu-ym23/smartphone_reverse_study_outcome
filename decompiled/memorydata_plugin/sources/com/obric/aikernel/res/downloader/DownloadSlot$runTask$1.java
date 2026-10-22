package com.obric.aikernel.res.downloader;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadSlot", f = "DownloadSlot.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {45, 47, 64}, m = "runTask", n = {"this", "task", "this", "task", "finished", "this", "task"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
final class DownloadSlot$runTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ h this$0;

    DownloadSlot$runTask$1(h r3, Continuation<? super DownloadSlot$runTask$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return h.a(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
