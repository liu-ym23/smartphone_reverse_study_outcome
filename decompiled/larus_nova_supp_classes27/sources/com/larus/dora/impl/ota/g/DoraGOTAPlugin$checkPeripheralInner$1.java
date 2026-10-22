package com.larus.dora.impl.ota.g;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.g.DoraGOTAPlugin", f = "DoraGOTAPlugin.kt", i = {}, l = {64}, m = "checkPeripheralInner-jLovISM", n = {}, s = {})
final class DoraGOTAPlugin$checkPeripheralInner$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGOTAPlugin this$0;

    public DoraGOTAPlugin$checkPeripheralInner$1(DoraGOTAPlugin r1, Continuation<? super DoraGOTAPlugin$checkPeripheralInner$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r17) {
        this.result = r17;
        this.label |= Integer.MIN_VALUE;
        DoraGOTAPlugin r0 = this.this$0;
        int r14 = DoraGOTAPlugin.c;
        Object r1 = r0.f(null, 0, null, null, 0, 0, null, null, 0, null, this);
        if (r1 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r1;
    L6:
        return Result.box-impl(r1);
    }
}
