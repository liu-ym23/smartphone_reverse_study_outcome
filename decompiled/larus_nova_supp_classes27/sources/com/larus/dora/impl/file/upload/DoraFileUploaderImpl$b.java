package com.larus.dora.impl.file.upload;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraFileUploaderImpl$b {
    public final boolean a;
    public final String b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraFileUploaderImpl$b) == true) goto L8;
        return false;
    L8:
        DoraFileUploaderImpl$b r6 = (DoraFileUploaderImpl$b) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "UploadResult(isSuccess=" + this.a + ", reason=" + this.b + ')';
    }

    public DoraFileUploaderImpl$b(boolean r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        this.a = r2;
        this.b = r3;
    }
}
