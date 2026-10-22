package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationImageRemoteDownloadHandler", f = "CreationImageNodeHandlers.kt", i = {0, 0}, l = {408, 421}, m = "resolveRemoteFallbackLocalPath", n = {"url", "fallbackLocalPath"}, s = {"L$0", "L$1"})
public final class CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationImageRemoteDownloadHandler this$0;

    public CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1(CreationImageRemoteDownloadHandler r1, Continuation<? super CreationImageRemoteDownloadHandler$resolveRemoteFallbackLocalPath$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, null, this);
    }
}
