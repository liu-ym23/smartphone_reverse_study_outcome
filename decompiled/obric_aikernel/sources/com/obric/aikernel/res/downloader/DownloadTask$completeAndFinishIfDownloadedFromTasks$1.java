package com.obric.aikernel.res.downloader;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadTask", f = "DownloadTask.kt", i = {0}, l = {436}, m = "completeAndFinishIfDownloadedFromTasks", n = {"this"}, s = {"L$0"})
final class DownloadTask$completeAndFinishIfDownloadedFromTasks$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadTask this$0;

    DownloadTask$completeAndFinishIfDownloadedFromTasks$1(DownloadTask r10, Continuation<? super DownloadTask$completeAndFinishIfDownloadedFromTasks$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return DownloadTask.a(this.this$0, this);
    }
}
