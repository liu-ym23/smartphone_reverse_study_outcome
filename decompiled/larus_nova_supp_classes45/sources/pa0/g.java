package pa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g {
    public static final Long a(k r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$cashBalanceOrNull");
        Long r6 = Long.valueOf(r5.a.getCashBalance());
        if (r6.longValue() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return r6;
    L5:
        r0 = false;
        goto L6
    }

    public static final k b(e r1) {
        Intrinsics.checkNotNullParameter(r1, "$this$dy");
        if ((r1 instanceof k) == true) goto L6;
        r1 = null;
    L6:
        return (k) r1;
    }

    public static final Long c(k r5) {
        Intrinsics.checkNotNullParameter(r5, "$this$goldBalanceOrNull");
        Long r6 = Long.valueOf(r5.a.getGoldBalance());
        if (r6.longValue() < 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L10;
        return null;
    L10:
        return r6;
    L5:
        r0 = false;
        goto L6
    }
}
