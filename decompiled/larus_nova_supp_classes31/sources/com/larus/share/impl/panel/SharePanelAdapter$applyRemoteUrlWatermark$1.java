package com.larus.share.impl.panel;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.share.impl.panel.SharePanelAdapter", f = "SharePanelAdapter.kt", i = {0, 0}, l = {800}, m = "applyRemoteUrlWatermark", n = {"shareContent", "perf"}, s = {"L$0", "L$1"})
public final class SharePanelAdapter$applyRemoteUrlWatermark$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SharePanelAdapter this$0;

    public SharePanelAdapter$applyRemoteUrlWatermark$1(SharePanelAdapter r1, Continuation<? super SharePanelAdapter$applyRemoteUrlWatermark$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        SharePanelAdapter r3 = this.this$0;
        Set<String> r0 = SharePanelAdapter.n;
        return r3.z2(null, null, this);
    }
}
