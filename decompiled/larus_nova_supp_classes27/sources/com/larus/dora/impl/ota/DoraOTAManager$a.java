package com.larus.dora.impl.ota;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTAManager$a {
    public final String a;
    public final e49.a b;
    public final boolean c;
    public int d;
    public long e;
    public boolean f;
    public long g;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof DoraOTAManager$a) == true) goto L8;
        return false;
    L8:
        DoraOTAManager$a r9 = (DoraOTAManager$a) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        int r2 = 1231;
        if (this.c == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (((r0 + r1) * 31) + this.d) * 31;
        long r4 = this.e;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        if (this.f == true) goto L10;
        r2 = 1237;
    L10:
        int r6 = (r5 + r2) * 31;
        long r7 = this.g;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "DownloadResumeContext(sn=" + this.a + ", responseWrapper=" + this.b + ", onlyWifi=" + this.c + ", progress=" + this.d + ", progressUpdateTimeMillis=" + this.e + ", waitingWifiResume=" + this.f + ", lastAutoResumeTimeMillis=" + this.g + ')';
    }

    public DoraOTAManager$a(String r2, e49.a r3, boolean r4, int r5, long r6, boolean r8, long r9) {
        Intrinsics.checkNotNullParameter(r2, "sn");
        Intrinsics.checkNotNullParameter(r3, "responseWrapper");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
        this.g = r9;
    }
}
