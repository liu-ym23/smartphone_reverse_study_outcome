package com.larus.dora.impl.guide.strategy;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.BasicDoraDeviceCheckStrategy", f = "BasicDoraDeviceCheckStrategy.kt", i = {0}, l = {188}, m = "isDeviceBound-0E7RQCE", n = {"device"}, s = {"L$0"})
public final class BasicDoraDeviceCheckStrategy$isDeviceBound$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BasicDoraDeviceCheckStrategy this$0;

    public BasicDoraDeviceCheckStrategy$isDeviceBound$1(BasicDoraDeviceCheckStrategy r1, Continuation<? super BasicDoraDeviceCheckStrategy$isDeviceBound$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        BasicDoraDeviceCheckStrategy r4 = this.this$0;
        int r0 = BasicDoraDeviceCheckStrategy.d;
        Object r5 = r4.c(null, 0, this);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Result.box-impl(r5);
    }
}
