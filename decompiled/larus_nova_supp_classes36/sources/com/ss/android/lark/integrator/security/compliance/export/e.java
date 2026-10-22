package com.ss.android.lark.integrator.security.compliance.export;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final String a;
    public final boolean b;
    public final long c;
    public final Integer d;
    public final String e;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Integer r5 = this.d;
        int r6 = 0;
        if (r5 != null) goto L9;
        int r7 = 0;
    L10:
        int r8 = (r4 + r7) * 31;
        String r9 = this.e;
        if (r9 == null) goto L15;
        r6 = r9.hashCode();
    L15:
        return r8 + r6;
    L9:
        r7 = r5.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "OfficeSDKFileCryptoMonitorEvent(operation=" + this.a + ", result=" + this.b + ", durationMs=" + this.c + ", errorCode=" + this.d + ", failureReason=" + this.e + ')';
    }

    public e(boolean r3, long r4, Integer r6, String r7) {
        Intrinsics.checkNotNullParameter("encrypt_file", "operation");
        this.a = "encrypt_file";
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
    }
}
