package com.ss.android.lark.imageqrcode.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.p;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.lark.android.encryption.CipherManager;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Bitmap a(String r4) {
        VFSFiles r0 = VFSFiles.b;     // Catch: Throwable -> L8
        if (r4 != null) goto L5;
        String r1 = "";
    L6:
        CipherManager.e(r0.i(r1), true).getPath();     // Catch: Throwable -> L8
        Bitmap r2 = p.d(r4);     // Catch: Throwable -> L8
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L8
        Intrinsics.checkNotNullParameter(r2, "bitmap");     // Catch: Throwable -> L8
        Lazy r3 = ImageQRCodeSettings.b;     // Catch: Throwable -> L8
        return p.b(r2, ((ImageQRCodeSettings.ImageQRCodeConfig) r3.getValue()).getSuperSizeSmallSide(), ((ImageQRCodeSettings.ImageQRCodeConfig) r3.getValue()).getSuperSizeBigSide());
    L5:
        r1 = r4;
    L8:
        th = move-exception;
        Log.e("ImageQRCodeUtils", "decodeBitmap failed, path:" + r4 + ", msg:" + th.getMessage());
        StringBuilder r5 = new StringBuilder("decodeBitmap failed, path:");
        r5.append(r4);
        Log.e("ImageQRCodeUtils", r5.toString());
        return null;
    }

    public static boolean b(Activity r2) {
        if (r2 != null) goto L4;
    L9:
        boolean r3 = true;
    L10:
        Log.i("ImageQRCodeUtils", "is activity inValid:" + r3);
        return r3;
    L4:
        if (r2.isDestroyed() == true) goto L9;
        if (r2.isFinishing() == true) goto L9;
        r3 = false;
        goto L10
    }

    public static boolean c(Bitmap r2) {
        if (r2 != null) goto L4;
    L11:
        boolean r3 = true;
    L12:
        Log.i("ImageQRCodeUtils", "is bitmap inValid:" + r3);
        return r3;
    L4:
        if (r2.isRecycled() == true) goto L11;
        if (r2.getWidth() == 0) goto L11;
        if (r2.getHeight() == 0) goto L11;
        r3 = false;
        goto L12
    }
}
