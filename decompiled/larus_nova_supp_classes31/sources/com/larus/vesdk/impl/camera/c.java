package com.larus.vesdk.impl.camera;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import com.larus.utils.z0;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;
import kotlin.KotlinNothingValueException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final c a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public static String b() {
        StringBuilder r0 = new StringBuilder();
        pq9.k.a.getClass();
        r0.append(pq9.k.f);
        r0.append('/');
        r0.append(System.currentTimeMillis());
        r0.append('_');
        r0.append(UUID.randomUUID().toString().substring(0, 8));
        r0.append(".jpg");
        return r0.toString();
    }

    public static boolean c(Bitmap r8, String r9, pq9.h r10) {
        Intrinsics.checkNotNullParameter(r9, "path");
        if (r8 != null) goto L5;
        return false;
    L5:
        FileOutputStream r5 = null;
        PolarisFileWrapper r6 = new PolarisFileWrapper(r9);     // Catch: Throwable -> L31 Exception -> L33
        File r7 = r6.getParentFile();     // Catch: Throwable -> L31 Exception -> L33
        if (r7 == null) goto L10;
        r7.mkdirs();     // Catch: Throwable -> L31 Exception -> L33
    L10:
        if (r6.exists() == true) goto L12;
        r6.createNewFile();     // Catch: Throwable -> L31 Exception -> L33
    L12:
        FileOutputStream r11 = new PolarisFileOutputStreamWrapper(r6);     // Catch: Throwable -> L31 Exception -> L33
    L29:
        e = e;
        r5 = r11;
    L34:
        FLogger.a.e("VeCameraHelper", "saveBitMapToFile failed:" + e + " path:" + r9);     // Catch: Throwable -> L31
        if (r10 == null) goto L37;
        r10.a(1002, e.getMessage());     // Catch: Throwable -> L31
    L37:
        if (r5 != null) goto L53;
    L42:
        return false;
    L53:
        r5.close();     // Catch: Exception -> L40
    L40:
        e = move-exception;
        FLogger.a.e("VeCameraHelper", "close failed:" + e);
    L27:
        th = th;
    L44:
        if (r11 != null) goto L57;
    L49:
        throw th;
    L57:
        r11.close();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        FLogger.a.e("VeCameraHelper", "close failed:" + e);
        goto L49
    L14:
        if (r8.compress(Bitmap.CompressFormat.JPEG, 100, r11) == false) goto L55;
        r11.flush();     // Catch: Throwable -> L27 Exception -> L29
        FLogger.a.i("VeCameraHelper", "saveBitMapToFile success, path:" + r9);     // Catch: Throwable -> L27 Exception -> L29
        r11.close();     // Catch: Exception -> L18
        return true;
    L18:
        e = move-exception;
        FLogger.a.e("VeCameraHelper", "close failed:" + e);
        return true;
    L55:
        r11.close();     // Catch: Exception -> L24
    L26:
        return false;
    L24:
        e = move-exception;
        FLogger.a.e("VeCameraHelper", "close failed:" + e);
    L31:
        th = th;
        r11 = null;
    L33:
        e = e;
        goto L34
    }

    public static Bitmap a(Bitmap r10, int r11, int r12, pq9.h r13) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        FLogger.a.i("VeCameraHelper", "[bitmap] width:" + r10.getWidth() + " height:" + r10.getHeight());     // Catch: Throwable -> L12
        Bitmap r3 = r10.copy(z0.b(r10.getConfig()), true);     // Catch: Throwable -> L12
        Matrix r8 = new Matrix();     // Catch: Throwable -> L12
        r8.postRotate((float) r11);     // Catch: Throwable -> L12
        if (r12 >= 0) goto L6;
    L9:
        int r5 = 0;
    L10:
        return Bitmap.createBitmap(r3, 0, r5, r3.getWidth(), r3.getHeight() - r5, r8, true);
    L6:
        if ((r10.getWidth() * 4) == (r10.getHeight() * 3)) goto L9;
        r5 = r12;
    L12:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        Throwable r15 = Result.exceptionOrNull-impl(Result.constructor-impl(ResultKt.createFailure(th)));
        if (r15 == null) goto L21;
        FLogger.a.e("VeCameraHelper", "cropBitmap failed:" + r15);
        if (r13 == null) goto L24;
        r13.a(1001, r15.getMessage());
        return null;
    L24:
        return null;
    L21:
        throw new KotlinNothingValueException();
    }
}
