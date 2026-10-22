package com.ttnet.org.chromium.base;

import android.content.res.AssetFileDescriptor;
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
    public static long[] open(String r10) {
        AssetFileDescriptor r8 = null;
        r8 = ContextUtils.getApplicationContext().getAssets().openNonAssetFd(r10);     // Catch: IOException -> L9 Throwable -> L22
        long[] r11 = {r8.getParcelFileDescriptor().detachFd(), r8.getStartOffset(), r8.getLength()};     // Catch: IOException -> L9 Throwable -> L22
    L31:
        r8.close();     // Catch: IOException -> L6
    L8:
        return r11;
    L6:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
    L9:
        e = move-exception;
        if (e.getMessage().equals("") == false) goto L13;
    L15:
        long[] r12 = {-1, -1, -1};     // Catch: Throwable -> L22
        if (r8 != null) goto L34;
    L21:
        return r12;
    L34:
        r8.close();     // Catch: IOException -> L19
    L19:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L21
    L13:
        if (e.getMessage().equals(r10) == true) goto L15;
        android.util.Log.e(LOGTAG, "Error while loading asset " + r10 + ": " + e);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        if (r8 != null) goto L36;
    L28:
        throw th;
    L36:
        r8.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L28
    }
}
