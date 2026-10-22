package com.obric.aikernel.res.downloader;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadTask", f = "DownloadTask.kt", i = {0, 1, 2}, l = {238, 242, 243}, m = "run", n = {"this", "this", "this"}, s = {"L$0", "L$0", "L$0"})
final class DownloadTask$run$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadTask this$0;

    DownloadTask$run$1(DownloadTask r10, Continuation<? super DownloadTask$run$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.J(this);
    }
}
