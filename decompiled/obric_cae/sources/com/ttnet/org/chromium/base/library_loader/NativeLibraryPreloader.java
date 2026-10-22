package com.ttnet.org.chromium.base.library_loader;

import android.content.pm.ApplicationInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class NativeLibraryPreloader {
    public NativeLibraryPreloader() {
    }

    public abstract int loadLibrary(ApplicationInfo r8);
}
