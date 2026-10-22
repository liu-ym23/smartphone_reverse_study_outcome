package com.obric.aiagent.messenger.stub;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n1 {
    public final byte[] a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof n1) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((n1) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        return "Success(bodyBytes=" + Arrays.toString(this.a) + ')';
    }

    public n1(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "bodyBytes");
        this.a = r2;
    }
}
