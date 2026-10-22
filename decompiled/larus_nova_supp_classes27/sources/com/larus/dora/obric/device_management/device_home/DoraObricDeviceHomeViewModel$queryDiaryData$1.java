package com.larus.dora.obric.device_management.device_home;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel", f = "DoraObricDeviceHomeViewModel.kt", i = {}, l = {675}, m = "queryDiaryData-0E7RQCE", n = {}, s = {})
public final class DoraObricDeviceHomeViewModel$queryDiaryData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraObricDeviceHomeViewModel this$0;

    public DoraObricDeviceHomeViewModel$queryDiaryData$1(DoraObricDeviceHomeViewModel r1, Continuation<? super DoraObricDeviceHomeViewModel$queryDiaryData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        Object r4 = DoraObricDeviceHomeViewModel.m233access$queryDiaryData0E7RQCE(this.this$0, null, false, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
