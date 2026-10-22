package com.larus.avlink.gallery;

import android.graphics.Rect;
import android.graphics.YuvImage;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import java.io.IOException;
import java.util.List;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AlbumUtils {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public AlbumUtils() {
    }

    public static final void a(String r11) {
        PolarisFileWrapper r5 = new PolarisFileWrapper(r11);     // Catch: Exception -> L16 SecurityException -> L18
        if (StringsKt.startsWith$default(r5.getAbsolutePath(), AppHost.a.getApplication().getFilesDir().getAbsolutePath(), false, 2, null) == true) goto L7;
        FLogger.a.w("AlbumUtils", "Reject to delete non-app file: " + r11);     // Catch: Exception -> L16 SecurityException -> L18
    L21:
        return;
    L7:
        if (r5.exists() == true) goto L9;
    L14:
        FLogger.a.w("AlbumUtils", "File not exist or is directory: " + r11);     // Catch: Exception -> L16 SecurityException -> L18
        goto L21
    L9:
        if (r5.isFile() == false) goto L14;
        if (r5.delete() == false) goto L13;
        FLogger.a.i("AlbumUtils", "Successfully deleted: " + r11);     // Catch: Exception -> L16 SecurityException -> L18
        goto L21
    L13:
        FLogger.a.e("AlbumUtils", "Failed to delete file (no exception): " + r11);     // Catch: Exception -> L16 SecurityException -> L18
    L18:
        e = move-exception;
        FLogger.a.e("AlbumUtils", "SecurityException while deleting file: " + e.getMessage());
        return;
    L16:
        e = move-exception;
        FLogger.a.e("AlbumUtils", "Failed to delete file: " + e.getClass().getSimpleName() + ", " + e.getMessage());
    }

    public static String d(long r4) {
        long r0 = 60;
        return (r4 / r0) + ':' + StringsKt.padStart(String.valueOf(r4 % r0), 2, '0');
    }

    public static void b(List r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r7, "filePaths");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new AlbumUtils$batchDelete$1(r7, r8, null), 2, null);
    }

    public static void e(String r5, int r6) {
        ExifInterface r3 = new ExifInterface(r5);     // Catch: IOException -> L18
        if (r6 != 0) goto L6;
    L15:
        int r7 = 1;
    L16:
        r3.setAttribute("Orientation", String.valueOf(r7));     // Catch: IOException -> L18
        r3.saveAttributes();     // Catch: IOException -> L18
        FLogger.a.i("AlbumUtils", "Set EXIF orientation to " + r7 + " for rotation " + r6 + 176);     // Catch: IOException -> L18
        return;
    L6:
        if (r6 != 90) goto L8;
        r7 = 6;
        goto L16
    L8:
        if (r6 != 180) goto L10;
        r7 = 3;
        goto L16
    L10:
        if (r6 == 270) goto L12;
        FLogger.a.w("AlbumUtils", "Unsupported rotation angle: " + r6 + ", using 0°");     // Catch: IOException -> L18
        goto L15
    L12:
        r7 = 8;
    L18:
        e = move-exception;
        FLogger.a.e("AlbumUtils", "Failed to set EXIF orientation: " + e.getMessage());
    }

    public static String c(byte[] r19, int[] r20, PolarisFileWrapper r21) {
        Intrinsics.checkNotNullParameter(r19, "yuvData");
        Intrinsics.checkNotNullParameter(r20, "outputSize");
        Intrinsics.checkNotNullParameter(r21, "jpegFile");
        int r14 = r20[0];     // Catch: Exception -> L10
        int r15 = r20[1];     // Catch: Exception -> L10
        int r0 = r20[2];     // Catch: Exception -> L10
        FLogger r6 = FLogger.a;     // Catch: Exception -> L10
        r6.i("AlbumUtils", "Converting YUV to JPEG - Width: " + r14 + ", Height: " + r15 + ", Format: " + r0 + ", Rotation: 90°");     // Catch: Exception -> L10
        YuvImage r5 = new YuvImage(r19, 17, r14, r15, null);     // Catch: Exception -> L10
        PolarisFileOutputStreamWrapper r1 = new PolarisFileOutputStreamWrapper(r21);     // Catch: Exception -> L10
        boolean r2 = r5.compressToJpeg(new Rect(0, 0, r14, r15), 90, r1);     // Catch: Exception -> L10
        r1.close();     // Catch: Exception -> L10
        if (r2 == true) goto L6;
    L8:
        r6.e("AlbumUtils", "Failed to convert YUV to JPEG");     // Catch: Exception -> L10
    L16:
        return "";
    L6:
        if (r21.exists() == false) goto L8;
        e(r21.getAbsolutePath(), 90);     // Catch: Exception -> L10
        r6.i("AlbumUtils", "Successfully converted YUV to JPEG with rotation 90°: " + r21.getAbsolutePath());     // Catch: Exception -> L10
        StringBuilder r3 = new StringBuilder("JPEG file size: ");     // Catch: Exception -> L10
        r3.append(r21.length());     // Catch: Exception -> L10
        r3.append(" bytes");     // Catch: Exception -> L10
        r6.i("AlbumUtils", r3.toString());     // Catch: Exception -> L10
        return r21.getAbsolutePath();
    L10:
        e = move-exception;
        FLogger r4 = FLogger.a;
        r4.e("AlbumUtils", "Error converting YUV to JPEG: " + e.getMessage(), e);
        PolarisFileWrapper r7 = new PolarisFileWrapper(AppHost.a.getApplication().getFilesDir().getAbsolutePath() + "/output_refined_image_backup.yuv");     // Catch: Exception -> L14
        FilesKt.writeBytes(r7, r19);     // Catch: Exception -> L14
        r4.i("AlbumUtils", "Saved YUV backup: " + r7.getAbsolutePath());     // Catch: Exception -> L14
    L14:
        e = move-exception;
        FLogger.a.e("AlbumUtils", "Failed to save YUV backup: " + e.getMessage());
        goto L16
    }
}
