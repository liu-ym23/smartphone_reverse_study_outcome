package cib;

import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public static final String a(Fragment r2) {
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L5;
        String r1 = r2.getClass().getSimpleName();
    L6:
        r0.append(r1);
        if (r2 == null) goto L9;
        int r3 = r2.hashCode();
    L10:
        r0.append(r3);
        return r0.toString();
    L9:
        r3 = 0;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
