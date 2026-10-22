package hq9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class u {
    public final boolean a;
    public final String b;
    public final String c;

    public u() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u) == true) goto L8;
        return false;
    L8:
        u r6 = (u) r5;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "AudioThemeConfigModel(bigVideoEnable=" + this.a + ", ballBigVideoUrl=" + this.b + ", ballBigVideoChannel=" + this.c + ')';
    }

    public /* synthetic */ u(int r2) {
        this(false, "", "");
    }

    public u(boolean r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "ballBigVideoUrl");
        Intrinsics.checkNotNullParameter(r4, "ballBigVideoChannel");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
