package org.apache.commons.compress.utils;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class FileNameUtils {
    public static String getBaseName(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = new File(r2).getName();
        int r0 = r3.lastIndexOf(46);
        if (r0 >= 0) goto L9;
        return r3;
    L9:
        return r3.substring(0, r0);
    }

    public static String getExtension(String r1) {
        if (r1 != null) goto L5;
        return null;
    L5:
        String r2 = new File(r1).getName();
        int r0 = r2.lastIndexOf(46);
        if (r0 >= 0) goto L10;
        return "";
    L10:
        return r2.substring(r0 + 1);
    }
}
