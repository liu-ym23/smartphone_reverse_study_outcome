package com.larus.voicecall.impl.component.denoise;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e0 {
    public final DenoiseUploadStatus a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e0) == true) goto L8;
        return false;
    L8:
        e0 r6 = (e0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "ReportDenoiseStatusPayload(uploadStatus=" + this.a + ", botId=" + this.b + ", roomId=" + this.c + ')';
    }

    public e0(DenoiseUploadStatus r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "uploadStatus");
        Intrinsics.checkNotNullParameter(r3, "botId");
        Intrinsics.checkNotNullParameter(r4, "roomId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
