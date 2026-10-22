package com.bytedance.apm.util;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1488a = "f";

    static {
    }

    public f() {
    }

    public static long a(File r7) {
        if (r7.exists() == true) goto L6;
        return -1;
    L6:
        if (r7.isFile() == true) goto L8;
        long r3 = 0;
        if (r7.isDirectory() == false) goto L15;
        File[] r8 = r7.listFiles();
        int r0 = r8.length;
        int r1 = 0;
    L12:
        if (r1 >= r0) goto L14;
        r3 = r3 + a(r8[r1]);
        r1 = r1 + 1;
        goto L12
    L14:
        return r3;
    L15:
        return -1;
    L8:
        return r7.length();
    }

    public static File a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        File r0 = null;
        if (r3 != null) goto L10;
        return null;
    L10:
        r0 = r3.getExternalFilesDir(null);     // Catch: Throwable -> L9
    L6:
        r0 = r0.getParentFile();     // Catch: Throwable -> L9
        if (r0.getAbsolutePath().contains("/Android") == true) goto L6;
    L8:
        return r0;
    }
}
