package com.larus.platform.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.platform.service.DownloadWatermarkService", f = "DownloadWatermarkService.kt", i = {}, l = {98}, m = "exchangeWatermarkUrl", n = {}, s = {})
public final class DownloadWatermarkService$exchangeWatermarkUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DownloadWatermarkService this$0;

    public DownloadWatermarkService$exchangeWatermarkUrl$1(DownloadWatermarkService r1, Continuation<? super DownloadWatermarkService$exchangeWatermarkUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
