package ic8;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t {
    public final boolean a;
    public final String b;
    public final List<String> c;
    public final String d;
    public final Map<String, String> e;
    public final int f;

    public t() {
        this(false, null, null, null, null, 0, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.a == r6.a) goto L12;
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
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = r0 * 31;
        String r2 = this.b;
        int r3 = 0;
        if (r2 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (r1 + r4) * 31;
        List<String> r6 = this.c;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        String r9 = this.d;
        if (r9 != null) goto L17;
        int r10 = 0;
    L18:
        int r11 = (r8 + r10) * 31;
        Map<String, String> r12 = this.e;
        if (r12 == null) goto L23;
        r3 = r12.hashCode();
    L23:
        return ((r11 + r3) * 31) + this.f;
    L17:
        r10 = r9.hashCode();
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "HeadTitleInfoSimplify(startShimmerAnimation=" + this.a + ", headTitle=" + this.b + ", headTitleList=" + this.c + ", headIcon=" + this.d + ", ext=" + this.e + ", headerStatus=" + this.f + ')';
    }

    public static t a(t r7) {
        boolean r1 = r7.a;
        String r2 = r7.b;
        List<String> r3 = r7.c;
        String r4 = r7.d;
        Map<String, String> r5 = r7.e;
        r7.getClass();
        return new t(r1, r2, r3, r4, r5, 3);
    }

    public t(boolean r1, String r2, List<String> r3, String r4, Map<String, String> r5, int r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public /* synthetic */ t(boolean r8, String r9, List r10, String r11, Map r12, int r13, int r14) {
        if ((r14 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r14 & 2) == 0) goto L9;
        String r2 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        List r3 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        String r4 = null;
    L19:
        if ((r14 & 16) == 0) goto L21;
        Map r5 = null;
    L23:
        if ((r14 & 32) == 0) goto L25;
        int r6 = 1;
    L26:
        this(r1, r2, r3, r4, r5, r6);
        return;
    L25:
        r6 = r13;
        goto L26
    L21:
        r5 = r12;
        goto L23
    L17:
        r4 = r11;
        goto L19
    L13:
        r3 = r10;
        goto L15
    L9:
        r2 = r9;
        goto L11
    L5:
        r1 = r8;
        goto L7
    }
}
