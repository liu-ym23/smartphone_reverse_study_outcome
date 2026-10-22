package com.bytedance.android.annie.util;

import android.content.Context;
import android.graphics.Bitmap;
import bytedance.io.BdFileSystem;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedOutputStream;
import java.io.File;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final q a(Context r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "sourceFilePath");
        PolarisFileWrapper r1 = new PolarisFileWrapper(r11);
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r1, "sourceFile");
        if (r1.exists() == true) goto L6;
        return new q(false, "source file not exists");
    L6:
        if (r1.isFile() == false) goto L11;
        r10.getCacheDir().getCanonicalPath();
        String r12 = r10.getCacheDir().getAbsolutePath() + File.separator + r1.getName();
        BdFileSystem.copyFile(r1, new PolarisFileWrapper(r12));
        return new q(true, r12);
    L11:
        return new q(false, "source file is not a file");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.Bitmap, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v8 */
    public static final boolean b(Bitmap r10, PolarisFileWrapper r11, int r12, Bitmap.CompressFormat r13) {
        Intrinsics.checkNotNullParameter(r10, "bitmap");
        Intrinsics.checkNotNullParameter(r13, "format");
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L22
        if (r10.isRecycled() == false) goto L30;
        return false;
    L30:
        BufferedOutputStream r15 = new BufferedOutputStream(new PolarisFileOutputStreamWrapper(r11));     // Catch: Throwable -> L22
        r10.compress(r13, r12, r15);     // Catch: Throwable -> L16
        r15.flush();     // Catch: Throwable -> L16
        r10 = 1;
        ?? r16 = 1;
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L12
        Object r18 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L25:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L29;
        HybridLogger r20 = HybridLogger.a;
        HybridLogger.i("FileUtil", "saveImageBitmap error:" + r19.getMessage(), null, 12);
        return false;
    L29:
        return r16;
    L14:
        Throwable th2 = th;
    L35:
        throw th2;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r15, th2);     // Catch: Throwable -> L12
        throw th;     // Catch: Throwable -> L12
    L16:
        th = move-exception;
        th2 = th;
        r10 = 0;
    L12:
        Throwable th3 = th;
    L24:
        Result.Companion r21 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th3));
        r16 = r10;
    L22:
        th = move-exception;
        th3 = th;
        r10 = 0;
        goto L24
    }
}
