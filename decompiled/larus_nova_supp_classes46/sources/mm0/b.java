package mm0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final boolean a(Integer r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.intValue() == 0) goto L7;
        return false;
    }

    public static final boolean b(Long r4) {
        if (r4 != null) goto L4;
    L7:
        return true;
    L4:
        if (r4.longValue() == 0) goto L7;
        return false;
    }

    public static final String c(Boolean r1, Object r2, Object r3) {
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L6;
        return String.valueOf(r2);
    L6:
        return String.valueOf(r3);
    }
}
