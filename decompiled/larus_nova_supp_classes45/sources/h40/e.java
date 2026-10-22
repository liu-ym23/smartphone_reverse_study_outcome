package h40;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public static final String a(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$errorMsg");
        String r0 = r2.getMessage();
        if (r0 == null) goto L13;
        if (r0.length() <= 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L11;
        r0 = null;
    L11:
        if (r0 == null) goto L13;
        return r0;
    L7:
        r1 = false;
    L13:
        return r2.toString();
    }
}
