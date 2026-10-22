package com.bytedance.android.ec.core.cps;

import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class CyberProtectionCollector {
    public static final CyberProtectionCollector a = null;

    public CyberProtectionCollector() {
    }

    static {
        a = new CyberProtectionCollector();
    }

    public final Object a(Continuation<? super String> r10) {
        if ((r10 instanceof CyberProtectionCollector$signHash$1) == false) goto L7;
        CyberProtectionCollector$signHash$1 r0 = (CyberProtectionCollector$signHash$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r0.label;
        if (r13 == 0) goto L14;
        if (r13 != 1) goto L13;
        ResultKt.throwOnFailure(r11);
    L17:
        String r14 = (String) r11;
        if (com.bytedance.android.shopping.extensions.k.c(r14) == true) goto L22;
        return null;
    L22:
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        r0.label = 1;
        r11 = b.i(r0);
        if (r11 != r12) goto L17;
        return r12;
    L7:
        r0 = new CyberProtectionCollector$signHash$1(this, r10);
        goto L8
    }
}
