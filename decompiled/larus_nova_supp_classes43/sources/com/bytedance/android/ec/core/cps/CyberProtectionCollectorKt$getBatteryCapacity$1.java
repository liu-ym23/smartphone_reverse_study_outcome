package com.bytedance.android.ec.core.cps;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0000H\u0082@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "getBatteryCapacity"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt", f = "CyberProtectionCollector.kt", i = {}, l = {247}, m = "getBatteryCapacity", n = {}, s = {})
final class CyberProtectionCollectorKt$getBatteryCapacity$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public CyberProtectionCollectorKt$getBatteryCapacity$1(Continuation r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return b.d(this);
    }
}
