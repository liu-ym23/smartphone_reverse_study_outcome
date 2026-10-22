package com.larus.dora.impl.guide.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.BasicDoraDeviceCheckStrategy", f = "BasicDoraDeviceCheckStrategy.kt", i = {0, 0}, l = {102}, m = "isConditionMet", n = {"device", "isH"}, s = {"L$1", "Z$0"})
public final class BasicDoraDeviceCheckStrategy$isConditionMet$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BasicDoraDeviceCheckStrategy this$0;

    public BasicDoraDeviceCheckStrategy$isConditionMet$1(BasicDoraDeviceCheckStrategy r1, Continuation<? super BasicDoraDeviceCheckStrategy$isConditionMet$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(this);
    }
}
