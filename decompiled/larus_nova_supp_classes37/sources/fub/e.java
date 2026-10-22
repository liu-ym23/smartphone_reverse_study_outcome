package fub;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class e {
    public final String a;
    public final String b;
    public final Map<String, String> c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
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
        return "RecordingUploadResult(uploadedFileToken=" + this.a + ", fileUrl=" + this.b + ", extra=" + this.c + ')';
    }

    public e(String r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r2, "uploadedFileToken");
        Intrinsics.checkNotNullParameter(r4, "extra");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
