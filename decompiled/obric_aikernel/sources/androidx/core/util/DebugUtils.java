package androidx.core.util;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object r10, StringBuilder r11) {
        if (r10 != null) goto L5;
        String r12 = "null";
    L4:
        r11.append(r12);
        return;
    L5:
        String r13 = r10.getClass().getSimpleName();
        if (r13.length() > 0) goto L10;
        r13 = r10.getClass().getName();
        int r14 = r13.lastIndexOf(46);
        if (r14 <= 0) goto L10;
        r13 = r13.substring(r14 + 1);
    L10:
        r11.append(r13);
        r11.append('{');
        r12 = Integer.toHexString(System.identityHashCode(r10));
        goto L4
    }
}
