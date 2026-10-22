package com.facebook.common.file;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FileTree {
    public static void a(File r5, FileTreeVisitor r10) {
        r10.a(r5);
        File[] r11 = r5.listFiles();
        if (r11 == null) goto L11;
        int r12 = r11.length;
        int r13 = 0;
    L5:
        if (r13 >= r12) goto L11;
        File r14 = r11[r13];
        if (r14.isDirectory() == false) goto L9;
        a(r14, r10);
    L10:
        r13 = r13 + 1;
        goto L5
    L9:
        r10.c(r14);
    L11:
        r10.b(r5);
    }

    public static boolean a(File r5) {
        if (r5.isDirectory() == false) goto L10;
        File[] r10 = r5.listFiles();
        if (r10 == null) goto L10;
        int r11 = r10.length;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L10;
        a(r10[r12]);
        r12 = r12 + 1;
    L10:
        return r5.delete();
    }
}
