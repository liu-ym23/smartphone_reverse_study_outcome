package com.obric.aikernel.res.downloader.obric;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.obric.ObricDownloadTask", f = "ObricDownloadTask.kt", i = {}, l = {95}, m = "getProgress", n = {}, s = {})
final class ObricDownloadTask$getProgress$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricDownloadTask this$0;

    ObricDownloadTask$getProgress$1(ObricDownloadTask r10, Continuation<? super ObricDownloadTask$getProgress$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.h(this);
    }
}
