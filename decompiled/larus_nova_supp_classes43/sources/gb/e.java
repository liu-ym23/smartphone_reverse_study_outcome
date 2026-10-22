package gb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public static final boolean a(Object r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(r10, 0) == false) goto L8;
    L20:
        return false;
    L8:
        if (Intrinsics.areEqual(r10, "") == true) goto L20;
        if ((r10 instanceof Number) == false) goto L13;
    L19:
        return true;
    L13:
        if ((r10 instanceof String) == true) goto L19;
        if ((r10 instanceof Boolean) == false) goto L19;
        return ((Boolean) r10).booleanValue();
    }
}
