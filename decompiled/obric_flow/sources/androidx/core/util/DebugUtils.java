package androidx.core.util;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DebugUtils {
    private DebugUtils() {
    }

    public static void buildShortClassTag(Object r5, StringBuilder r10) {
        if (r5 != null) goto L4;
        r10.append("null");
        return;
    L4:
        String r11 = r5.getClass().getSimpleName();
        if (r11.length() > 0) goto L9;
        r11 = r5.getClass().getName();
        int r12 = r11.lastIndexOf(46);
        if (r12 <= 0) goto L9;
        r11 = r11.substring(r12 + 1);
    L9:
        r10.append(r11);
        r10.append('{');
        r10.append(Integer.toHexString(System.identityHashCode(r5)));
    }
}
