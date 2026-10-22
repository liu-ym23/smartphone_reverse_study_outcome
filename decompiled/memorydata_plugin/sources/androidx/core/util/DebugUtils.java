package androidx.core.util;

/* JADX INFO: loaded from: classes.dex */
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object r2, StringBuilder r3) {
        if (r2 != null) goto L5;
        String r4 = "null";
    L4:
        r3.append(r4);
        return;
    L5:
        String r0 = r2.getClass().getSimpleName();
        if (r0 != null) goto L8;
    L9:
        r0 = r2.getClass().getName();
        int r1 = r0.lastIndexOf(46);
        if (r1 <= 0) goto L12;
        r0 = r0.substring(r1 + 1);
    L12:
        r3.append(r0);
        r3.append('{');
        r4 = Integer.toHexString(System.identityHashCode(r2));
        goto L4
    L8:
        if (r0.length() > 0) goto L12;
        goto L9
    }
}
