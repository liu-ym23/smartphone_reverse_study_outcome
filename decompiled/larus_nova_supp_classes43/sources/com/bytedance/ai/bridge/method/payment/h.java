package com.bytedance.ai.bridge.method.payment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h {
    public final String a;

    public h() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((h) r10).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "PaymentMessageParams(messageId=" + this.a + ')';
    }

    public h(String r1) {
        this.a = r1;
    }
}
