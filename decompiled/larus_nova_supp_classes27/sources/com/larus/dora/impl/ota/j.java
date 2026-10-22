package com.larus.dora.impl.ota;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class j {
    public final String a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof j) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((j) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "DoraOTAParam(otaFileSavePath=" + this.a + ')';
    }

    public j(String r2) {
        Intrinsics.checkNotNullParameter(r2, "otaFileSavePath");
        this.a = r2;
    }
}
