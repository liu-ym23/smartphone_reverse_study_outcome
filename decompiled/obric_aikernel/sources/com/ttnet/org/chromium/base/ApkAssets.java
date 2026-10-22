package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("base::android")
public class ApkAssets {
    private static final String LOGTAG = "ApkAssets";

    public ApkAssets() {
    }

    @CalledByNative
    public static long[] open(String r10, String r11) {
        AssetFileDescriptor r12 = null;
        Context r13 = ContextUtils.getApplicationContext();     // Catch: Throwable -> L14 IOException -> L16
        if (TextUtils.isEmpty(r11) == false) goto L6;
    L8:
        r12 = r13.getAssets().openNonAssetFd(r10);     // Catch: Throwable -> L14 IOException -> L16
        long[] r14 = {r12.getParcelFileDescriptor().detachFd(), r12.getStartOffset(), r12.getLength()};     // Catch: Throwable -> L14 IOException -> L16
    L40:
        r12.close();     // Catch: IOException -> L11
    L13:
        return r14;
    L11:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L13
    L6:
        if (BundleUtils.isIsolatedSplitInstalled(r13, r11) == false) goto L8;
        r13 = BundleUtils.createIsolatedSplitContext(r13, r11);     // Catch: Throwable -> L14 IOException -> L16
    L16:
        e = move-exception;
        if (e.getMessage().equals("") == false) goto L20;
    L22:
        long[] r15 = {-1, -1, -1};     // Catch: Throwable -> L14
        if (r12 != null) goto L42;
    L28:
        return r15;
    L42:
        r12.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L28
    L20:
        if (e.getMessage().equals(r10) == true) goto L22;
        android.util.Log.e(LOGTAG, "Error while loading asset " + r10 + ": " + e);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (r12 != null) goto L37;
    L34:
        throw th;
    L37:
        r12.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L34
    }
}
