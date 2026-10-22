package com.larus.platform.api;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class s {
    public final String a;
    public final String b;
    public final long c;
    public final FlowDriveFileType d;
    public final String e;
    public final String f;
    public final float g;
    public final Map<String, String> h;

    public s() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof s) == true) goto L8;
        return false;
    L8:
        s r9 = (s) r8;
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
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r9.g) == 0) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        long r1 = this.c;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.d.hashCode()) * 31;
        String r3 = this.e;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.f;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (((r6 + r8) * 31) + Float.floatToIntBits(this.g)) * 31;
        Map<String, String> r10 = this.h;
        if (r10 == null) goto L15;
        r4 = r10.hashCode();
    L15:
        return r9 + r4;
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowDriveFileItem(fileName=" + this.a + ", fileToken=" + this.b + ", fileSize=" + this.c + ", fileType=" + this.d + ", originImgUrl=" + this.e + ", videoCoverUrl=" + this.f + ", videoDuration=" + this.g + ", extra=" + this.h + ')';
    }

    public s(String r2, String r3, long r4, FlowDriveFileType r6, Map r7, int r8) {
        if ((r8 & 4) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r8 & 8) == 0) goto L9;
        r6 = FlowDriveFileType.FILE;
    L9:
        if ((r8 & 128) == 0) goto L11;
        r7 = null;
    L11:
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "fileToken");
        Intrinsics.checkNotNullParameter(r6, "fileType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = null;
        this.f = null;
        this.g = 0.0f;
        this.h = r7;
    }
}
