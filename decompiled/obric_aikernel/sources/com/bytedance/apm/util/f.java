package com.bytedance.apm.util;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class f {
    static {
    }

    public static File a(Context r10) {
        File r11 = null;
        if (r10 != null) goto L10;
        return null;
    L10:
        r11 = r10.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L6:
        r11 = r11.getParentFile();     // Catch: Throwable -> L9
        if (r11.getAbsolutePath().contains("/Android") == true) goto L6;
    L8:
        return r11;
    }

    public static long b(File r10) {
        if (r10.exists() == true) goto L6;
        return -1;
    L6:
        if (r10.isFile() == true) goto L8;
        long r11 = 0;
        if (r10.isDirectory() == false) goto L15;
        File[] r12 = r10.listFiles();
        int r13 = r12.length;
        int r14 = 0;
    L12:
        if (r14 >= r13) goto L14;
        r11 = r11 + b(r12[r14]);
        r14 = r14 + 1;
        goto L12
    L14:
        return r11;
    L15:
        return -1;
    L8:
        return r10.length();
    }
}
