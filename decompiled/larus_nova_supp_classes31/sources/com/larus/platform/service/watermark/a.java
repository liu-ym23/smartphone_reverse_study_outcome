package com.larus.platform.service.watermark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a extends f {
    public final String a;
    public final String b;
    public final DownloadWatermarkScene c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        String r1 = this.b;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + this.c.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public final String toString() {
        return "FileWatermarkRequest(localFilePath=" + this.a + ", mimeType=" + this.b + ", scene=" + this.c + ')';
    }

    public a(String r2, String r3, DownloadWatermarkScene r4) {
        Intrinsics.checkNotNullParameter(r2, "localFilePath");
        Intrinsics.checkNotNullParameter(r4, "scene");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
