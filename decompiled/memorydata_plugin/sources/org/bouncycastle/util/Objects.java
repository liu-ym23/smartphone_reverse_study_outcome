package org.bouncycastle.util;

/* JADX INFO: loaded from: classes7.dex */
public class Objects {
    public static boolean areEqual(Object r0, Object r1) {
        if (r0 == r1) goto L9;
        if (r0 == null) goto L8;
        if (r1 == null) goto L8;
        if (r0.equals(r1) == true) goto L9;
    L8:
        return false;
    L9:
        return true;
    }

    public static int hashCode(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }
}
