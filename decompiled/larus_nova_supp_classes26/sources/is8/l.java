package is8;

import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class l {
    public final Integer a;
    public final Integer b;
    public final Long c;
    public final Map<String, String> d;

    public l() {
        Integer r0 = null;
        this(r0, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof l) == true) goto L8;
        return false;
    L8:
        l r6 = (l) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.c;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.d.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadedMediaMeta(width=" + this.a + ", height=" + this.b + ", durationMs=" + this.c + ", extra=" + this.d + ')';
    }

    public /* synthetic */ l(Integer r3, Integer r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r5 & 8) == 0) goto L11;
        Map r6 = MapsKt.emptyMap();
    L12:
        this(r3, r4, null, r6);
        return;
    L11:
        r6 = null;
        goto L12
    }

    public l(Integer r2, Integer r3, Long r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r5, "extra");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
