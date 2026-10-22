package fub;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public final String a;
    public final String b;
    public final String c;
    public final Long d;
    public final String e;
    public final String f;
    public final String g;
    public final Map<String, String> h;

    public c() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((r4 + r6) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        String r8 = this.g;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((r7 + r2) * 31) + this.h.hashCode();
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecordingUploadFileParam(uri=" + this.a + ", fileName=" + this.b + ", mimeType=" + this.c + ", fileSizeBytes=" + this.d + ", mountPoint=" + this.e + ", mountNodeToken=" + this.f + ", uploadCode=" + this.g + ", extraRust=" + this.h + ')';
    }

    public c(String r3, String r4, Long r5, String r6, Map r7) {
        Intrinsics.checkNotNullParameter(r3, "uri");
        Intrinsics.checkNotNullParameter(r4, "fileName");
        Intrinsics.checkNotNullParameter("minutes_artifact", "mountPoint");
        Intrinsics.checkNotNullParameter(r6, "mountNodeToken");
        Intrinsics.checkNotNullParameter(r7, "extraRust");
        this.a = r3;
        this.b = r4;
        this.c = null;
        this.d = r5;
        this.e = "minutes_artifact";
        this.f = r6;
        this.g = null;
        this.h = r7;
    }
}
