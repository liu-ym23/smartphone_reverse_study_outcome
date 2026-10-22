package com.obric.aikernel.res.downloader;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadSlot", f = "DownloadSlot.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {45, 47, 64}, m = "runTask", n = {"this", "task", "this", "task", "finished", "this", "task"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
final class DownloadSlot$runTask$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadSlot this$0;

    DownloadSlot$runTask$1(DownloadSlot r10, Continuation<? super DownloadSlot$runTask$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return DownloadSlot.a(this.this$0, null, this);
    }
}
