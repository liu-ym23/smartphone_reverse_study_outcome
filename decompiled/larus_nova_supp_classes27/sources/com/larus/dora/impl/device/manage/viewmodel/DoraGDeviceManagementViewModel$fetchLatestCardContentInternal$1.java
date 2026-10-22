package com.larus.dora.impl.device.manage.viewmodel;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel", f = "DoraGDeviceManagementViewModel.kt", i = {0}, l = {837, 874}, m = "fetchLatestCardContentInternal-gIAlu-s", n = {"skipDiaryCard"}, s = {"Z$0"})
public final class DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraGDeviceManagementViewModel this$0;

    public DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$1(DoraGDeviceManagementViewModel r1, Continuation<? super DoraGDeviceManagementViewModel$fetchLatestCardContentInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = DoraGDeviceManagementViewModel.m65access$fetchLatestCardContentInternalgIAlus(this.this$0, false, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
