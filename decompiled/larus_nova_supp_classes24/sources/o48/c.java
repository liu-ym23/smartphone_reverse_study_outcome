package o48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c {
    public static final u64.b a(n38.e r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        String r1 = r9.a;
        if (r1 != null) goto L5;
        String r3 = "";
    L6:
        String r2 = r9.b;
        if (r2 != null) goto L9;
        String r4 = "";
    L10:
        String r5 = r3;
        String r6 = r4;
        return new u64.b(r5, r6, "", "", r9.d);
    L9:
        r4 = r2;
        goto L10
    L5:
        r3 = r1;
        goto L6
    }
}
