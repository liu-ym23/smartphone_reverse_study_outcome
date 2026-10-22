package com.bytedance.geckox;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4746a = null;

    static {
        f4746a = new e();
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r5) {
        return r5.isDirectory();
    }
}
