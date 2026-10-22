package com.bytedance.android.ec.adapter.api.state;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class ECEcomData {
    public final Lazy a;
    public final String b;

    public ECEcomData() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ECEcomData) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.b, ((ECEcomData) r10).b) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public final String toString() {
        return "ECEcomData(_ecomData=" + this.b + ")";
    }

    public ECEcomData(String r10) {
        this.b = r10;
        this.a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new ECEcomData$ecomData$2(this));
    }
}
