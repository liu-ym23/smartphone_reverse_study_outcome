package com.larus.uaigc.nowatermark;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.nowatermark.CreationNoWatermarkManager", f = "CreationNoWatermarkManager.kt", i = {0}, l = {261}, m = "ensureImageDataList", n = {"keys"}, s = {"L$0"})
public final class CreationNoWatermarkManager$ensureImageDataList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationNoWatermarkManager this$0;

    public CreationNoWatermarkManager$ensureImageDataList$1(CreationNoWatermarkManager r1, Continuation<? super CreationNoWatermarkManager$ensureImageDataList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.q(null, null, this);
    }
}
