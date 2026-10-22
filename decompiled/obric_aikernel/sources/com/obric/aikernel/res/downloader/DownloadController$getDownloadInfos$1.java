package com.obric.aikernel.res.downloader;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.DownloadController", f = "DownloadController.kt", i = {0}, l = {279}, m = "getDownloadInfos", n = {"destination$iv$iv"}, s = {"L$0"})
final class DownloadController$getDownloadInfos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadController this$0;

    DownloadController$getDownloadInfos$1(DownloadController r10, Continuation<? super DownloadController$getDownloadInfos$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.o(this);
    }
}
