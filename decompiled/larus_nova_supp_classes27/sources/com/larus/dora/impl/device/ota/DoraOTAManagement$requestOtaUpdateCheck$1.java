package com.larus.dora.impl.device.ota;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement", f = "DoraOTAManagement.kt", i = {0, 0, 0}, l = {1064}, m = "requestOtaUpdateCheck", n = {"successCallback", "errorCallback", "callBody"}, s = {"L$0", "L$1", "L$2"})
public final class DoraOTAManagement$requestOtaUpdateCheck$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTAManagement this$0;

    public DoraOTAManagement$requestOtaUpdateCheck$1(DoraOTAManagement r1, Continuation<? super DoraOTAManagement$requestOtaUpdateCheck$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        DoraOTAManagement r0 = this.this$0;
        DoraOTAManagement r8 = DoraOTAManagement.a;
        return r0.C(null, null, null, null, this);
    }
}
