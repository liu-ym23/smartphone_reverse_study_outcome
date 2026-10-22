package com.obric.aikernel.res.downloader;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.downloader.GeneralDownloadTask", f = "GeneralDownloadTask.kt", i = {0}, l = {158}, m = "getDownloadInfos", n = {"$this$getDownloadInfos_u24lambda_u243"}, s = {"L$1"})
final class GeneralDownloadTask$getDownloadInfos$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GeneralDownloadTask this$0;

    GeneralDownloadTask$getDownloadInfos$1(GeneralDownloadTask r10, Continuation<? super GeneralDownloadTask$getDownloadInfos$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
