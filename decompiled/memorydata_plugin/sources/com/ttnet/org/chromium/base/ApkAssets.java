package com.ttnet.org.chromium.base;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("base::android")
public class ApkAssets {
    private static final String LOGTAG = "ApkAssets";

    public ApkAssets() {
    }

    public static long[] open(String r10, String r11) {
        AssetFileDescriptor r7 = null;
        Context r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ContextUtils.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 IOException -> L17
        if (TextUtils.isEmpty(r11) == false) goto L6;
    L8:
        r7 = r8.getAssets().openNonAssetFd(r10);     // Catch: Throwable -> L15 IOException -> L17
        long[] r12 = {r7.getParcelFileDescriptor().detachFd(), r7.getStartOffset(), r7.getLength()};     // Catch: Throwable -> L15 IOException -> L17
        if (r7 != null) goto L40;
    L14:
        return r12;
    L40:
        r7.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L14
    L6:
        if (BundleUtils.isIsolatedSplitInstalled(r8, r11) == false) goto L8;
        r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BundleUtils.createIsolatedSplitContext(r8, r11), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15 IOException -> L17
    L15:
        th = move-exception;
        if (r7 != null) goto L36;
    L35:
        throw th;
    L36:
        r7.close();     // Catch: IOException -> L33
    L33:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
    L17:
        e = move-exception;
        if (e.getMessage().equals("") == false) goto L21;
    L23:
        long[] r13 = {-1, -1, -1};     // Catch: Throwable -> L15
        if (r7 != null) goto L42;
    L29:
        return r13;
    L42:
        r7.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        android.util.Log.e(LOGTAG, "Unable to close AssetFileDescriptor", e);
        goto L29
    L21:
        if (e.getMessage().equals(r10) == true) goto L23;
        android.util.Log.e(LOGTAG, "Error while loading asset " + r10 + ": " + e);     // Catch: Throwable -> L15
        goto L23
    }
}
