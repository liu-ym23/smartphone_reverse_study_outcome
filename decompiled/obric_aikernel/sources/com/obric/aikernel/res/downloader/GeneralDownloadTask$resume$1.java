package com.obric.aikernel.res.downloader;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.GeneralDownloadTask", f = "GeneralDownloadTask.kt", i = {0}, l = {119}, m = "resume", n = {"this"}, s = {"L$0"})
final class GeneralDownloadTask$resume$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GeneralDownloadTask this$0;

    GeneralDownloadTask$resume$1(GeneralDownloadTask r10, Continuation<? super GeneralDownloadTask$resume$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(this);
    }
}
