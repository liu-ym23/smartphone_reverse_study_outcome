package ns9;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class f {
    public final Integer a;
    public final String b;
    public final String c;
    public final String d;
    public final List<b> e;
    public final List<d> f;

    public f() {
        this(null, null, null, null, null, 63);
    }

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
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return ((((r9 + r1) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "ReachContent(layout=" + this.a + ", title=" + this.b + ", icon=" + this.c + ", subtitle=" + this.d + ", actions=" + this.e + ", buttons=" + this.f + ')';
    }

    public /* synthetic */ f(String r8, String r9, String r10, List r11, List r12, int r13) {
        if ((r13 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        String r3 = null;
    L10:
        if ((r13 & 8) == 0) goto L12;
        String r4 = null;
    L14:
        if ((r13 & 16) == 0) goto L16;
        r11 = CollectionsKt.emptyList();
    L16:
        List r5 = r11;
        if ((r13 & 32) == 0) goto L19;
        r12 = CollectionsKt.emptyList();
    L19:
        this(null, r8, r3, r4, r5, r12);
        return;
    L12:
        r4 = r10;
        goto L14
    L8:
        r3 = r9;
        goto L10
    }

    public f(Integer r2, String r3, String r4, String r5, List<b> r6, List<d> r7) {
        Intrinsics.checkNotNullParameter(r6, "actions");
        Intrinsics.checkNotNullParameter(r7, "buttons");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
