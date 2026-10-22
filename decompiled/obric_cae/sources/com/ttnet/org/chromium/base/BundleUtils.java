package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: classes2.dex */
public class BundleUtils {
    private static final boolean sIsBundle = false;

    static {
        Class.forName("org.chromium.base.BundleCanary");     // Catch: ClassNotFoundException -> L4
        boolean r8 = true;
    L5:
        sIsBundle = r8;
        return;
    L4:
        r8 = false;
        goto L5
    }

    public BundleUtils() {
    }

    @CalledByNative
    private static String getNativeLibraryPath(String r8) {
        StrictModeContext r10 = StrictModeContext.allowDiskReads();
        String r11 = ((BaseDexClassLoader) ContextUtils.getApplicationContext().getClassLoader()).findLibrary(r8);     // Catch: Throwable -> L7
        if (r10 == null) goto L6;
        r10.close();
    L6:
        return r11;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r10 != null) goto L16;
    L15:
        throw th;
    L16:
        r10.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    @CalledByNative
    public static boolean isBundle() {
        return sIsBundle;
    }
}
