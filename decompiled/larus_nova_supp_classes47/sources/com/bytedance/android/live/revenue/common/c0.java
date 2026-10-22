package com.bytedance.android.live.revenue.common;

import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static long a(File r6) {
        Intrinsics.checkNotNullParameter(r6, "fileOrDirectory");
        long r1 = 0;
        if (r6.exists() == true) goto L6;
        return 0;
    L6:
        if (r6.isDirectory() == false) goto L17;
        File[] r7 = r6.listFiles();
        if (r7 == null) goto L21;
        int r0 = r7.length;
        int r3 = 0;
    L10:
        if (r3 >= r0) goto L22;
        File r4 = r7[r3];
        if (r4.isDirectory() == false) goto L14;
        long r5 = a(r4);
    L15:
        r1 = r1 + r5;
        r3 = r3 + 1;
        goto L10
    L14:
        r5 = r4.length();
        goto L15
    L22:
        return r1;
    L21:
        return 0;
    L17:
        return r6.length();
    }

    public static boolean b(File r5) {
        Intrinsics.checkNotNullParameter(r5, "fileOrDirectory");
        if (r5.isDirectory() == false) goto L23;
        File[] r0 = r5.listFiles();
        if (r0 == null) goto L21;
        int r2 = 0;
        if (r0.length != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L21;
        int r3 = r0.length;
    L13:
        if (r2 >= r3) goto L27;
        File r4 = r0[r2];
        if (r4.isDirectory() == false) goto L17;
        b(r4);
    L18:
        r2 = r2 + 1;
        goto L13
    L17:
        r4.delete();
        goto L18
    L27:
        return r5.delete();
    L9:
        r1 = false;
    L21:
        return r5.delete();
    L23:
        return r5.delete();
    }
}
