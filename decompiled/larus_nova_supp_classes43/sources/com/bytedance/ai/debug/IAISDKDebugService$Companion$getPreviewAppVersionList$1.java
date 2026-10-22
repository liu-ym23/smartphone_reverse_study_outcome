package com.bytedance.ai.debug;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debug.IAISDKDebugService$Companion", f = "IAISDKDebugService.kt", i = {0}, l = {297}, m = "getPreviewAppVersionList", n = {"appKey"}, s = {"L$0"})
public final class IAISDKDebugService$Companion$getPreviewAppVersionList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ IAISDKDebugService.Companion this$0;

    public IAISDKDebugService$Companion$getPreviewAppVersionList$1(IAISDKDebugService.Companion r1, Continuation<? super IAISDKDebugService$Companion$getPreviewAppVersionList$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.k(0, null, null, null, null, 0, this);
    }
}
