package com.obric.aikernel.res.downloader;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadController$slotCallback$1", f = "DownloadController.kt", i = {0}, l = {60}, m = "pickTask", n = {"this"}, s = {"L$0"})
final class DownloadController$slotCallback$1$pickTask$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadController$slotCallback$1 this$0;

    DownloadController$slotCallback$1$pickTask$1(DownloadController$slotCallback$1 r10, Continuation<? super DownloadController$slotCallback$1$pickTask$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
