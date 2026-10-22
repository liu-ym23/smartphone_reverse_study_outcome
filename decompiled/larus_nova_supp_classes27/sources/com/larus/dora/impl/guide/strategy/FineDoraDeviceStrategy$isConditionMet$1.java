package com.larus.dora.impl.guide.strategy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.strategy.FineDoraDeviceStrategy", f = "FineDoraDeviceStrategy.kt", i = {}, l = {36}, m = "isConditionMet", n = {}, s = {})
public final class FineDoraDeviceStrategy$isConditionMet$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FineDoraDeviceStrategy this$0;

    public FineDoraDeviceStrategy$isConditionMet$1(FineDoraDeviceStrategy r1, Continuation<? super FineDoraDeviceStrategy$isConditionMet$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
