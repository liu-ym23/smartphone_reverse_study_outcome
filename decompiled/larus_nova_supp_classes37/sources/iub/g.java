package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final c e;

    public g() {
        this(null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        if (this.d == true) goto L15;
        r2 = 1237;
    L15:
        return ((r5 + r2) * 31) + this.e.hashCode();
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MmRecordingAIInterpretationData(recordingId=" + this.a + ", entryVisible=" + this.b + ", enabled=" + this.c + ", loading=" + this.d + ", languageState=" + this.e + ')';
    }

    public /* synthetic */ g(String r7, int r8) {
        if ((r8 & 1) == 0) goto L5;
        r7 = "";
    L5:
        String r1 = r7;
        if ((r8 & 16) == 0) goto L8;
        c r9 = new c(0);
    L9:
        this(r1, false, false, false, r9);
        return;
    L8:
        r9 = null;
        goto L9
    }

    public g(String r2, boolean r3, boolean r4, boolean r5, c r6) {
        Intrinsics.checkNotNullParameter(r2, "recordingId");
        Intrinsics.checkNotNullParameter(r6, "languageState");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
