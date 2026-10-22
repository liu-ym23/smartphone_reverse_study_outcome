package z98;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class f {
    public final String a;
    public final String b;
    public final String c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
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
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public final String toString() {
        return "DoraOnboardingMusicModel(coverUrl=" + this.a + ", songName=" + this.b + ", artistName=" + this.c + ')';
    }

    public f(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "coverUrl");
        Intrinsics.checkNotNullParameter(r3, "songName");
        Intrinsics.checkNotNullParameter(r4, "artistName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
