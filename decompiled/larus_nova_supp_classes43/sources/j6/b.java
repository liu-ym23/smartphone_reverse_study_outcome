package j6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public final String a;
    public final boolean b;

    public b() {
        this(null, true);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof b) == false) goto L10;
        b r11 = (b) r10;
        if (Intrinsics.areEqual(this.a, r11.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        String r0 = this.a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L6:
        int r10 = r1 * 31;
        boolean r11 = this.b;
        ?? r12 = r11;
        if (r11 == false) goto L10;
        r12 = 1;
    L10:
        return r10 + r12;
    L5:
        r1 = 0;
        goto L6
    }

    public final String toString() {
        return "RemoteConfigResult(config=" + this.a + ", needUpdate=" + this.b + ")";
    }

    public b(String r1, boolean r10) {
        this.a = r1;
        this.b = r10;
    }
}
