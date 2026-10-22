package com.larus.xbridge.custom;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.xbridge.custom.AppSaveMsgExportFileMethod", f = "AppSaveMsgExportFileMethod.kt", i = {0}, l = {156}, m = "applyDownloadFileWatermark", n = {"perf"}, s = {"L$0"})
final class AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ y this$0;

    public AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1(y r1, Continuation<? super AppSaveMsgExportFileMethod$applyDownloadFileWatermark$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return y.f(this.this$0, null, this);
    }
}
