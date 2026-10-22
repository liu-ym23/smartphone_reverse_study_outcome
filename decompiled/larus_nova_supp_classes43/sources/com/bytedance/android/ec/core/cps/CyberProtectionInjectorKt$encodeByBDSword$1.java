package com.bytedance.android.ec.core.cps;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002H\u0082@"}, d2 = {"", "data", "Lkotlin/coroutines/Continuation;", "continuation", "", "encodeByBDSword"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionInjectorKt", f = "CyberProtectionInjector.kt", i = {}, l = {368}, m = "encodeByBDSword", n = {}, s = {})
final class CyberProtectionInjectorKt$encodeByBDSword$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public CyberProtectionInjectorKt$encodeByBDSword$1(Continuation r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return c.b(null, this);
    }
}
