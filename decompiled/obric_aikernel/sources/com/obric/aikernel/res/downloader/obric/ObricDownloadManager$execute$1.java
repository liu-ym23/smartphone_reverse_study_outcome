package com.obric.aikernel.res.downloader.obric;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.obric.ObricDownloadManager", f = "ObricDownloadManager.kt", i = {0}, l = {110}, m = "execute", n = {"block"}, s = {"L$0"})
final class ObricDownloadManager$execute$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricDownloadManager this$0;

    ObricDownloadManager$execute$1(ObricDownloadManager r10, Continuation<? super ObricDownloadManager$execute$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
