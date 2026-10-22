package f92;

import java.util.Comparator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Comparator {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r8, Object r9) {
        ti6.f r10 = (ti6.f) r8;
        ti6.f r11 = (ti6.f) r9;
        Intrinsics.checkNotNullParameter(r10, "regionL");
        Intrinsics.checkNotNullParameter(r11, "regionR");
        double r0 = r10.e;
        double r2 = r11.e;
        if (r0 == r2) goto L6;
        if (r0 >= r2) goto L12;
    L5:
        return -1;
    L12:
        return 1;
    L6:
        double r1 = r10.d;
        double r13 = r11.d;
        if (r1 == r13) goto L10;
        if (r1 < r13) goto L5;
        return 1;
    L10:
        return 0;
    }
}
