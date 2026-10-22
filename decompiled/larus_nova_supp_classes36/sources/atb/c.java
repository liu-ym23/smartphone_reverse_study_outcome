package atb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final String a;
    public final String b;

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
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "CustomSpeechInfo(fileKey=" + this.a + ", fsUnit=" + this.b + ')';
    }

    public c(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileKey");
        Intrinsics.checkNotNullParameter(r3, "fsUnit");
        this.a = r2;
        this.b = r3;
    }
}
