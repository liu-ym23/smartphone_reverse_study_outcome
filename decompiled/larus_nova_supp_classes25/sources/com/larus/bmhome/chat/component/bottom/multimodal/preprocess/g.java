package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.image.loader.v;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import ic8.m0;
import ic8.n0;
import java.io.IOException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.Regex;
import v19.m5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class g extends e {
    public final LocalTakePictureImpl d;

    public static final class a {
    }

    static {
    }

    public g() {
        this.d = new LocalTakePictureImpl();
    }

    public static boolean j(String r3) {
        PolarisFileInputStreamWrapper r0 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r3));
        int r4 = r0.available();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        r0.close();     // Catch: Throwable -> L5
    L6:
        FLogger.a.i("SendResourcePreprocessManager_CameraImgProcessor", "[checkFileSize] size:" + r4);
        if (r4 < 204800) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean k(String r3) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r3, r0);
        String r4 = r0.outMimeType;
        FLogger.a.i("SendResourcePreprocessManager_CameraImgProcessor", "[checkImageType] type:" + r4);
        Intrinsics.checkNotNull(r4);
        return x.a(r4);
    }

    public static m0 m(String r13) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r13);
        PolarisFileInputStreamWrapper r1 = new PolarisFileInputStreamWrapper(r0);
        long r6 = r1.available();     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r1, null);
        BitmapFactory.Options r2 = new BitmapFactory.Options();
        r2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(r13, r2);
        String r8 = r2.outMimeType;
        String r5 = r0.getName();
        Regex r3 = j.a;
        return new m0(r13, r5, r6, r8, null, null, j.a(r0.getName(), r8), 12272);
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    }

    public final Float n(String r5) {
        int r0 = 1;
        ExifInterface r1 = new ExifInterface(r5);     // Catch: Throwable -> L5
        this.c = r1;     // Catch: Throwable -> L5
        r0 = r1.getAttributeInt("Orientation", 1);     // Catch: Throwable -> L5
    L8:
        if (r0 == 3) goto L17;
        if (r0 == 6) goto L22;
        if (r0 == 8) goto L21;
        return null;
    L21:
        return Float.valueOf(270.0f);
    L22:
        return Float.valueOf(90.0f);
    L17:
        return Float.valueOf(180.0f);
    L5:
        th = move-exception;
        FLogger.a.e("SendResourcePreprocessManager_CameraImgProcessor", "[getImgOrientation] err: " + th);
        goto L8
    }

    public final String q(String r14, ns8.b r15) {
        String r16 = SendResourcePreprocessManager.h(false, "jpeg", false, r15, null, r14, 20);
        x.b(r16);
        FLogger r2 = FLogger.a;
        r2.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryRenameOriginalTmpImg] outPath:".concat(r16));
        Float r3 = n(r14);
        if (r3 != null) goto L36;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r14);
        PolarisFileWrapper r17 = new PolarisFileWrapper(r16);
        boolean r1 = r0.renameTo(r17);
        r2.i("SendResourcePreprocessManager_CameraImgProcessor", "[renameFile] renameFile, renamed:" + r1);
        if (r1 == true) goto L30;
        boolean r4 = false;
        PolarisFileInputStreamWrapper r5 = new PolarisFileInputStreamWrapper(r0);     // Catch: IOException -> L28
        PolarisFileOutputStreamWrapper r6 = new PolarisFileOutputStreamWrapper(r17);     // Catch: Throwable -> L23
        byte[] r18 = new byte[1024];     // Catch: Throwable -> L18
    L11:
        int r7 = r5.read(r18);     // Catch: Throwable -> L18
        if (r7 <= 0) goto L14;
        r6.write(r18, 0, r7);     // Catch: Throwable -> L18
        goto L11
    L14:
        r0.delete();     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r6, null);     // Catch: Throwable -> L23
        CloseableKt.closeFinally(r5, null);     // Catch: IOException -> L28
        goto L30
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: IOException -> L28
        throw th;     // Catch: IOException -> L28
    L28:
        e = move-exception;
        FLogger.a.e("SendResourcePreprocessManager_CameraImgProcessor", "[renameFile] " + e);
    L31:
        FLogger.a.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryRenameOriginalTmpImg] tryRenameOriginalTmpImg just rename, result:" + r4);
        if (r4 == true) goto L82;
        m5.b(r16);
        return null;
    L82:
        return r16;
    L30:
        r4 = true;
        goto L31
    L36:
        Matrix r11 = new Matrix();
        r11.postRotate(r3.floatValue());
        r2.i("SendResourcePreprocessManager_CameraImgProcessor", " [tryRenameOriginalTmpImg] tryRenameOriginalTmpImg not to rotate degree:" + r3);
        Bitmap r8 = BitmapFactory.decodeFile(r14);     // Catch: Throwable -> L44
        Bitmap r9 = Bitmap.createBitmap(r8, 0, 0, r8.getWidth(), r8.getHeight(), r11, true);     // Catch: Throwable -> L44
        PolarisFileOutputStreamWrapper r10 = new PolarisFileOutputStreamWrapper(r16);     // Catch: Throwable -> L44
        r9.compress(Bitmap.CompressFormat.JPEG, 100, r10);     // Catch: Throwable -> L42
        r10.flush();     // Catch: Throwable -> L42
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.close();     // Catch: Throwable -> L58
    L41:
        m5.b(r14);
        return r16;
    L42:
        th = th;
    L76:
        FLogger.a.e("SendResourcePreprocessManager_CameraImgProcessor", "[tryRenameOriginalTmpImg] tryRenameOriginalTmpImg fix degree er: " + th);     // Catch: Throwable -> L52
        m5.b(r16);     // Catch: Throwable -> L52
        if (r10 == null) goto L50;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.close();     // Catch: Throwable -> L59
    L50:
        m5.b(r14);
        return null;
    L52:
        th = move-exception;
        if (r10 == null) goto L56;
        Intrinsics.checkNotNullParameter(r10, "<this>");
        r10.close();     // Catch: Throwable -> L60
    L56:
        m5.b(r14);
        throw th;
    L44:
        th = th;
        r10 = null;
        goto L76
    }

    public final String o(String r21, ns8.a r22, ns8.b r23) {
        Object r5 = null;
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L47
        if (j(r21) == true) goto L6;
    L44:
        String r8 = null;
    L45:
        Object r0 = Result.constructor-impl(r8);     // Catch: Throwable -> L47
    L49:
        Throwable r2 = Result.exceptionOrNull-impl(r0);
        if (r2 == null) goto L53;
        FLogger.a.e("SendResourcePreprocessManager_CameraImgProcessor", "[tryCompress] err: " + r2);
    L53:
        if (Result.isFailure-impl(r0) == true) goto L57;
        r5 = r0;
    L57:
        return (String) r5;
    L6:
        if (k(r21) == false) goto L44;
        if (r22 == null) goto L11;
        Bitmap.CompressFormat r7 = r22.d;     // Catch: Throwable -> L47
        if (r7 == null) goto L11;
    L12:
        Bitmap r9 = p(r21, r22, r23);     // Catch: Throwable -> L47
        boolean r10 = true;
        int r11 = 100;
        IntRange r12 = new IntRange(1, 100);     // Catch: Throwable -> L47
        if (r22 == null) goto L15;
        Integer r13 = r22.c;     // Catch: Throwable -> L47
    L17:
        if (r13 != null) goto L19;
    L21:
        boolean r14 = false;
    L22:
        if (r14 == false) goto L27;
        if (r22 == null) goto L35;
        Integer r1 = r22.c;     // Catch: Throwable -> L47
        if (r1 == null) goto L35;
        r11 = r1.intValue();     // Catch: Throwable -> L47
    L35:
        String r3 = i.a(r7);     // Catch: Throwable -> L47
        r8 = SendResourcePreprocessManager.h(false, r3, false, r23, null, r21, 20);     // Catch: Throwable -> L47
        x.b(r8);     // Catch: Throwable -> L47
        FLogger r15 = FLogger.a;     // Catch: Throwable -> L47
        r15.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryCompress] outPath:".concat(r8));     // Catch: Throwable -> L47
        if (r(r9, r8, r11, r7) == true) goto L45;
        if (z2.a.enableImagePreprocessCacheFallback() == false) goto L44;
        r8 = SendResourcePreprocessManager.g(false, r3);     // Catch: Throwable -> L47
        x.b(r8);     // Catch: Throwable -> L47
        r15.w("SendResourcePreprocessManager_CameraImgProcessor", "[tryCompress] retry compress to cache outPath:".concat(r8));     // Catch: Throwable -> L47
        if (r(r9, r8, r11, r7) == false) goto L44;
    L27:
        z2 r4 = z2.a;     // Catch: Throwable -> L47
        int r16 = r4.imageUploadOptConfig().d;     // Catch: Throwable -> L47
        if (1 <= r16) goto L30;
    L32:
        r10 = false;
    L33:
        if (r10 == false) goto L35;
        r11 = r4.imageUploadOptConfig().d;     // Catch: Throwable -> L47
        goto L35
    L30:
        if (r16 >= 101) goto L32;
    L19:
        if (r12.contains(r13.intValue()) == false) goto L21;
        r14 = true;
        goto L22
    L15:
        r13 = null;
    L11:
        r7 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L49
    }

    public final Bitmap p(String r8, ns8.a r9, ns8.b r10) {
        Bitmap r0 = BitmapFactory.decodeFile(r8);
        Float r11 = n(r8);
        if (r11 == null) goto L5;
        float r12 = r11.floatValue();
    L6:
        boolean r2 = false;
        if (r9 == null) goto L11;
        Integer r3 = r9.a;
        if (r3 == null) goto L11;
        int r4 = r3.intValue();
    L13:
        if (r4 > 0) goto L15;
        float r5 = 1.0f;
    L30:
        float r13 = f.a(r5, r10);
        if (r12 != 0.0f) goto L33;
        boolean r1 = true;
    L35:
        if (r1 == true) goto L37;
    L42:
        Matrix r6 = new Matrix();
        r6.postRotate(r12);
        r6.postScale(r13, r13);
        FLogger r14 = FLogger.a;
        StringBuilder r7 = new StringBuilder("[tryFixImgDegreeForCompress] not to rotate degree:");
        r7.append(r12);
        r7.append(", optShortSize: ");
        if (r9 == null) goto L45;
        Integer r15 = r9.a;
    L46:
        r7.append(r15);
        r14.i("SendResourcePreprocessManager_CameraImgProcessor", r7.toString());
        return Bitmap.createBitmap(r0, 0, 0, r0.getWidth(), r0.getHeight(), r6, true);
    L45:
        r15 = null;
        goto L46
    L37:
        if (r13 != 1.0f) goto L39;
        r2 = true;
    L39:
        if (r2 == false) goto L42;
        FLogger.a.i("SendResourcePreprocessManager_CameraImgProcessor", "[tryFixImgDegreeForCompress] not to rotate");
        Intrinsics.checkNotNull(r0);
        return r0;
    L33:
        r1 = false;
        goto L35
    L15:
        if (r0.getWidth() >= r0.getHeight()) goto L22;
        if (r9 == null) goto L20;
        Integer r16 = r9.a;
        if (r16 == null) goto L20;
        int r17 = r16.intValue();
    L21:
        float r18 = r17;
        int r19 = r0.getWidth();
    L28:
        r5 = r18 / r19;
    L20:
        r17 = 0;
        goto L21
    L22:
        if (r9 == null) goto L26;
        Integer r20 = r9.a;
        if (r20 == null) goto L26;
        int r21 = r20.intValue();
    L27:
        r18 = r21;
        r19 = r0.getHeight();
    L26:
        r21 = 0;
    L11:
        r4 = 0;
        goto L13
    L5:
        r12 = 0.0f;
        goto L6
    }

    public final n0 l(String r11, boolean r12, ns8.a r13, ns8.b r14) {
        Intrinsics.checkNotNullParameter(r11, "tmpSrcPath");
        m0 r4 = m(r11);     // Catch: Exception -> L41
        boolean r5 = false;
        if (r14 != null) goto L6;
    L8:
        boolean r7 = false;
    L9:
        if (r7 == false) goto L11;
        String r8 = null;
    L12:
        r4.e = r8;     // Catch: Exception -> L41
        this.d.k(r11, r8);     // Catch: Exception -> L41
        FLogger r9 = FLogger.a;     // Catch: Exception -> L41
        r9.i("SendResourcePreprocessManager_CameraImgProcessor", "[execIncludeClone] exec compressPath:" + r8);     // Catch: Exception -> L41
        if (r8 != null) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == true) goto L31;
        m5.b(r11);     // Catch: Exception -> L41
        if (r12 == false) goto L23;
        ImFileUtil r15 = ImFileUtil.a;     // Catch: Exception -> L41
        PolarisFileWrapper r16 = new PolarisFileWrapper(r8);     // Catch: Exception -> L41
        r15.getClass();     // Catch: Exception -> L41
        r4.f = ImFileUtil.g(r16);     // Catch: Exception -> L41
    L23:
        if (r13 != null) goto L25;
    L27:
        if (r5 == false) goto L30;
        e.d(this.c, r8);     // Catch: Exception -> L41
    L30:
        return new n0(r4, ProcessFileResultCode.PREPARE_COMPRESSED_SUCCESS);
    L25:
        if (r13.e != true) goto L27;
        r5 = true;
        goto L27
    L31:
        String r17 = q(r11, r14);     // Catch: Exception -> L41
        r4.e = r17;     // Catch: Exception -> L41
        this.d.k(r11, r17);     // Catch: Exception -> L41
        if (o0.d(r17) == false) goto L35;
        if (r12 == false) goto L35;
        ImFileUtil r18 = ImFileUtil.a;     // Catch: Exception -> L41
        PolarisFileWrapper r19 = new PolarisFileWrapper(r17);     // Catch: Exception -> L41
        r18.getClass();     // Catch: Exception -> L41
        r4.f = ImFileUtil.g(r19);     // Catch: Exception -> L41
    L35:
        r9.i("SendResourcePreprocessManager_CameraImgProcessor", "[execIncludeClone] exec renamePath:" + r17);     // Catch: Exception -> L41
        if (o0.d(r17) == false) goto L38;
        ProcessFileResultCode r110 = ProcessFileResultCode.PREPARE_CLONE_SUCCESS;     // Catch: Exception -> L41
    L40:
        return new n0(r4, r110);
    L38:
        r110 = ProcessFileResultCode.PREPARE_CLONE_FAILED;     // Catch: Exception -> L41
        goto L40
    L15:
        if (r8.length() == 0) goto L18;
        r2 = false;
        goto L19
    L11:
        r8 = o(r11, r13, r14);     // Catch: Exception -> L41
        goto L12
    L6:
        if (r14.a != true) goto L8;
        r7 = true;
    L41:
        e = move-exception;
        FLogger.a.e("SendResourcePreprocessManager_CameraImgProcessor", "[execIncludeClone] exec error, msg: " + e.getMessage());
        return new n0(null, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    }

    public final boolean r(Bitmap r7, String r8, int r9, Bitmap.CompressFormat r10) {
        boolean r2 = true;
        boolean r3 = false;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L18
        e.b(r8);     // Catch: Throwable -> L18
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r8);     // Catch: Throwable -> L18
        boolean r6 = g(r10);     // Catch: Throwable -> L16
        int r11 = i.b(r10, r9, r6);     // Catch: Throwable -> L16
        if (r6 == false) goto L7;
        int r12 = v.a;     // Catch: Throwable -> L16
        boolean r13 = v.a(r7, r11, r5, f().g());     // Catch: Throwable -> L16
    L8:
        if (r13 == true) goto L10;
        FLogger.a.e("SendResourcePreprocessManager_CameraImgProcessor", "[writeCompressedBitmap] compress failed, outPath:".concat(r8));     // Catch: Throwable -> L16
        boolean r14 = true;
    L39:
        Object r15 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L14
    L21:
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L24;
        FLogger.a.e("SendResourcePreprocessManager_CameraImgProcessor", "[writeCompressedBitmap] failed, outPath:" + r8 + ", err:" + r16);
    L25:
        if (r5 == null) goto L30;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        r5.close();     // Catch: Throwable -> L29
    L30:
        if (r2 == false) goto L32;
        m5.b(r8);
    L32:
        Boolean r17 = Boolean.FALSE;
        if (Result.isFailure-impl(r15) == false) goto L36;
        r15 = r17;
    L36:
        return ((Boolean) r15).booleanValue();
    L24:
        r2 = r14;
    L14:
        Throwable th = th;
        r3 = r14;
    L20:
        Result.Companion r18 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        r14 = r3;
        goto L21
    L10:
        r5.flush();     // Catch: Throwable -> L16
        r14 = false;
        r3 = true;
        goto L39
    L7:
        r13 = r7.compress(r10, r11, r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th = th;
    L18:
        th = move-exception;
        th = th;
        r5 = null;
        goto L20
    }
}
