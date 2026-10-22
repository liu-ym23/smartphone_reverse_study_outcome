package com.bytedance.iesgurd.meta;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements FileFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f6647a = null;

    static {
        f6647a = new c();
    }

    @Override // java.io.FileFilter
    public final boolean accept(File r5) {
        return r5.isDirectory();
    }
}
