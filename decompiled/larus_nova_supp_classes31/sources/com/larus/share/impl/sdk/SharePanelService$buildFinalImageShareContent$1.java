package com.larus.share.impl.sdk;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.sdk.SharePanelService", f = "SharePanelService.kt", i = {0, 0, 0, 1, 1}, l = {320, 341}, m = "buildFinalImageShareContent", n = {"context", "shareContent", "shouldWriteManualMetadata", "materializedShareContent", "finalImageUrl"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1"})
final class SharePanelService$buildFinalImageShareContent$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharePanelService this$0;

    public SharePanelService$buildFinalImageShareContent$1(SharePanelService r1, Continuation<? super SharePanelService$buildFinalImageShareContent$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SharePanelService.f(this.this$0, null, null, null, this);
    }
}
