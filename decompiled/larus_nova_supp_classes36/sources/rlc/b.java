package rlc;

import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public static String a(String r2) {
        if (r2 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == true) goto L14;
        String r1 = File.separator;
        if (r2.endsWith(r1) == false) goto L13;
        return r2;
    L13:
        return r2 + r1;
    L14:
        return r2;
    L4:
        if (r2.isEmpty() == true) goto L7;
        r0 = false;
        goto L8
    }
}
