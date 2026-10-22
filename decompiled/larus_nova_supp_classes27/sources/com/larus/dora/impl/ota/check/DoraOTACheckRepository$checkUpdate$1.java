package com.larus.dora.impl.ota.check;

import com.larus.dora.impl.ota.g2.j0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository", f = "DoraOTACheckRepository.kt", i = {}, l = {j0.G2_OTA_GLASSES_BATTERY_MIN}, m = "checkUpdate-LiYkppA", n = {}, s = {})
public final class DoraOTACheckRepository$checkUpdate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTACheckRepository this$0;

    public DoraOTACheckRepository$checkUpdate$1(DoraOTACheckRepository r1, Continuation<? super DoraOTACheckRepository$checkUpdate$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        Object r13 = this.this$0.b(null, null, null, null, null, null, null, null, false, this);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Result.box-impl(r13);
    }
}
