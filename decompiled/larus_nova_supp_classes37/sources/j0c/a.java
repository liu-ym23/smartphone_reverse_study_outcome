package j0c;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public final boolean a;
    public final String b;
    public final List<c> c;
    public final List<c> d;
    public final c e;

    public a() {
        this(false, null, null, null, 31);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
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
        int r5 = (((((r1 + r4) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        c r6 = this.e;
        if (r6 == null) goto L15;
        r3 = r6.hashCode();
    L15:
        return r5 + r3;
    L9:
        r4 = r2.hashCode();
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "ExecuteTaskResult(isSuccess=" + this.a + ", errorMessage=" + this.b + ", successTaskResults=" + this.c + ", errorTaskResults=" + this.d + ", blockTaskResult=" + this.e + ')';
    }

    public final a a(a r8) {
        Intrinsics.checkNotNullParameter(r8, "result");
        if (this.a == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = this.b + r8.b;
        List r4 = CollectionsKt.plus(this.c, r8.c);
        List r5 = CollectionsKt.plus(this.d, r8.d);
        c r0 = this.e;
        if (r0 == null) goto L13;
        if (r0 == null) goto L13;
        c r6 = r0;
    L15:
        return new a(r2, r3, r4, r5, r6);
    L13:
        r6 = r8.e;
        goto L15
    L5:
        if (r8.a == false) goto L7;
        r2 = true;
        goto L8
    }

    public /* synthetic */ a(boolean r7, String r8, List r9, List r10, int r11) {
        if ((r11 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r11 & 2) == 0) goto L9;
        r8 = "";
    L9:
        String r2 = r8;
        if ((r11 & 4) == 0) goto L12;
        r9 = CollectionsKt.emptyList();
    L12:
        List r3 = r9;
        if ((r11 & 8) == 0) goto L15;
        r10 = CollectionsKt.emptyList();
    L15:
        this(r1, r2, r3, r10, null);
        return;
    L5:
        r1 = r7;
        goto L7
    }

    public a(boolean r2, String r3, List<c> r4, List<c> r5, c r6) {
        Intrinsics.checkNotNullParameter(r4, "successTaskResults");
        Intrinsics.checkNotNullParameter(r5, "errorTaskResults");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
