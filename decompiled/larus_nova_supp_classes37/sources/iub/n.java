package iub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class n {
    public final String a;
    public final String b;

    public n() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n) == true) goto L8;
        return false;
    L8:
        n r6 = (n) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "MmRecordingLanguageItem(language=" + this.a + ", description=" + this.b + ')';
    }

    public /* synthetic */ n(int r1) {
        this("", "");
    }

    public n(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "language");
        Intrinsics.checkNotNullParameter(r3, "description");
        this.a = r2;
        this.b = r3;
    }
}
