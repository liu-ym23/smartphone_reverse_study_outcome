package com.obric.aikernel.res.downloader.obric;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.obric.ObricDownloadTask", f = "ObricDownloadTask.kt", i = {0}, l = {116}, m = "getCachedDownloadInfo", n = {"this"}, s = {"L$0"})
final class ObricDownloadTask$getCachedDownloadInfo$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricDownloadTask this$0;

    ObricDownloadTask$getCachedDownloadInfo$1(ObricDownloadTask r10, Continuation<? super ObricDownloadTask$getCachedDownloadInfo$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return ObricDownloadTask.j(this.this$0, this);
    }
}
