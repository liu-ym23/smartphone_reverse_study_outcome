package com.larus.dora.impl.ota.check;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository", f = "DoraOTACheckRepository.kt", i = {}, l = {58}, m = "checkUpdate-5p_uFSQ", n = {}, s = {})
public final class DoraOTACheckRepository$checkUpdate$2 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraOTACheckRepository this$0;

    public DoraOTACheckRepository$checkUpdate$2(DoraOTACheckRepository r1, Continuation<? super DoraOTACheckRepository$checkUpdate$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= Integer.MIN_VALUE;
        Object r14 = this.this$0.a(null, null, null, null, null, null, null, null, false, false, this);
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r14;
    L6:
        return Result.box-impl(r14);
    }
}
