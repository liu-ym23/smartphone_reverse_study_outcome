package c3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static final boolean a(String r10) {
        if (r10 == null) goto L12;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        a r1 = new a(r10);
        if (r1.b > 0) goto L11;
        if (r1.c > 0) goto L11;
        if (r1.d > 0) goto L11;
        return false;
    L11:
        return true;
    L12:
        return false;
    }
}
