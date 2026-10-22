package com.larus.dora.impl.ota;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTAManager", f = "DoraOTAManager.kt", i = {0, 0, 0}, l = {320}, m = "downloadLegacyWithOwner$impl_mainlandRelease", n = {"device", "responseWrapper", "onlyWifi"}, s = {"L$0", "L$1", "Z$0"})
public final class DoraOTAManager$downloadLegacyWithOwner$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTAManager this$0;

    public DoraOTAManager$downloadLegacyWithOwner$1(DoraOTAManager r1, Continuation<? super DoraOTAManager$downloadLegacyWithOwner$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, false, this);
    }
}
