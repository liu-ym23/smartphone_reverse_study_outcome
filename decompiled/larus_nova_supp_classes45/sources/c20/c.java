package c20;

import f10.f;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public final List<List<f>> a;
    public final List<String> b;
    public final List<a> c;
    public final List<d> d;
    public final long e;
    public final boolean f;

    public final boolean equals(Object r6) {
        if (this != r6) goto L4;
        return true;
    L4:
        if ((r6 instanceof c) == false) goto L18;
        c r7 = (c) r6;
        if (Intrinsics.areEqual(this.a, r7.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r7.d) == true) goto L14;
        return false;
    L14:
        if (this.e == r7.e) goto L16;
        return false;
    L16:
        if (this.f == r7.f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        List<List<f>> r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<a> r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<d> r11 = this.d;
        if (r11 == null) goto L17;
        r1 = r11.hashCode();
    L17:
        int r12 = (r9 + r1) * 31;
        long r13 = this.e;
        int r14 = (r12 + ((int) (r13 ^ (r13 >>> 32)))) * 31;
        boolean r15 = this.f;
        ?? r16 = r15;
        if (r15 == false) goto L21;
        r16 = 1;
    L21:
        return r14 + r16;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TabListData(groupIconList=" + this.a + ", groupNameList=" + this.b + ", tabIconList=" + this.c + ", tabNameList=" + this.d + ", selectedGroupId=" + this.e + ", isFromCache=" + this.f + ")";
    }

    public c(List<List<f>> r2, List<String> r3, List<a> r4, List<d> r5, long r6, boolean r8) {
        Intrinsics.checkNotNullParameter(r2, "groupIconList");
        Intrinsics.checkNotNullParameter(r3, "groupNameList");
        Intrinsics.checkNotNullParameter(r4, "tabIconList");
        Intrinsics.checkNotNullParameter(r5, "tabNameList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r8;
    }
}
