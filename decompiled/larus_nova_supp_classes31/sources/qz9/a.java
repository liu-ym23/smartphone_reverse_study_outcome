package qz9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final String a(zo8.a r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r0 = r3.b();
        String r1 = "";
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (r0.length() != 0) goto L8;
        boolean r2 = true;
    L9:
        if (r2 == false) goto L16;
        String r4 = r3.a();
        if (r4 == null) goto L15;
        r1 = r4;
    L15:
        return r1;
    L16:
        return r0;
    L8:
        r2 = false;
        goto L9
    }
}
