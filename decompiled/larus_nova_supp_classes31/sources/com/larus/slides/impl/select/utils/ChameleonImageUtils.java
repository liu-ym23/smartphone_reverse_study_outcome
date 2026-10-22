package com.larus.slides.impl.select.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.slides.sdk.api.media.ThumbType;
import com.larus.utils.logger.FLogger;
import java.io.ByteArrayOutputStream;
import java.io.File;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class ChameleonImageUtils {
    public static final ChameleonImageUtils a = null;

    static {
        a = new ChameleonImageUtils();
    }

    public ChameleonImageUtils() {
    }

    public static Pair c(PolarisFileWrapper r5) {
        BitmapFactory.Options r1 = new BitmapFactory.Options();     // Catch: Exception -> L45
        r1.inJustDecodeBounds = true;     // Catch: Exception -> L45
        BitmapFactory.decodeFile(r5.getAbsolutePath(), r1);     // Catch: Exception -> L45
        int r3 = r1.outWidth;     // Catch: Exception -> L45
        if (r3 > 0) goto L6;
    L9:
        BitmapFactory.Options r2 = new BitmapFactory.Options();     // Catch: Exception -> L45
        r2.inJustDecodeBounds = true;     // Catch: Exception -> L45
        PolarisFileInputStreamWrapper r4 = new PolarisFileInputStreamWrapper(r5);     // Catch: Exception -> L45
        BitmapFactory.decodeStream(r4, null, r2);     // Catch: Throwable -> L40
        CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L45
        int r6 = r2.outWidth;     // Catch: Exception -> L45
        if (r6 > 0) goto L14;
    L51:
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L24
        ExifInterface r8 = new ExifInterface(r5.getAbsolutePath());     // Catch: Throwable -> L24
        int r9 = r8.getAttributeInt("ImageWidth", 0);     // Catch: Throwable -> L24
        int r10 = r8.getAttributeInt("ImageLength", 0);     // Catch: Throwable -> L24
        if (r9 <= 0) goto L22;
        if (r10 <= 0) goto L22;
        return new Pair(Integer.valueOf(r9), Integer.valueOf(r10));
    L22:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L28:
        if (Build.VERSION.SDK_INT >= 28) goto L52;
    L47:
        return null;
    L52:
        ImageDecoder.Source r11 = ImageDecoder.createSource(r5);     // Catch: Throwable -> L37
        final Ref.ObjectRef r12 = new Ref.ObjectRef();     // Catch: Throwable -> L37
        ImageDecoder.decodeBitmap(r11, new c(r12)).recycle();     // Catch: Exception -> L48 Throwable -> L37
    L31:
        Object r13 = r12.element;     // Catch: Throwable -> L37
        if (r13 != null) goto L34;
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L37
        goto L47
    L34:
        return (Pair) r13;
    L37:
        th = move-exception;
        Result.Companion r14 = Result.Companion;     // Catch: Exception -> L45
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L45
    L24:
        th = move-exception;
        Result.Companion r15 = Result.Companion;     // Catch: Exception -> L45
        Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Exception -> L45
        goto L28
    L14:
        if (r2.outHeight <= 0) goto L51;
        return new Pair(Integer.valueOf(r6), Integer.valueOf(r2.outHeight));
    L40:
        th = move-exception;
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L45
        throw th;     // Catch: Exception -> L45
    L6:
        if (r1.outHeight <= 0) goto L9;
        return new Pair(Integer.valueOf(r3), Integer.valueOf(r1.outHeight));
    L45:
        e = move-exception;
        FLogger.a.w("ChameleonImageUtils", "getImageSizeSafe error: " + e.getMessage());
        goto L47
    }

    public static final boolean a(ChameleonImageUtils r15, PolarisFileWrapper r16, PolarisFileWrapper r17, long r18) {
        r15.getClass();
    L64:
        e = move-exception;
        FLogger.a.e("ChameleonImageUtils", "copyImageRespectingSizeLimit error", e);
        return false;
    L4:
        if (r16.exists() == false) goto L79;
        Pair r6 = c(r16);     // Catch: Exception -> L64
        if (r6 == null) goto L9;
        int r7 = ((Number) r6.getFirst()).intValue();     // Catch: Exception -> L64
    L10:
        if (r6 == null) goto L12;
        int r8 = ((Number) r6.getSecond()).intValue();     // Catch: Exception -> L64
    L13:
        if (r7 <= 0) goto L62;
        if (r8 <= 0) goto L62;
        final int r0 = RangesKt.coerceAtLeast((int) Math.sqrt(RangesKt.coerceAtLeast(((((long) r7) * ((long) r8)) * 4) / r18, 1.0d)), 1);     // Catch: Exception -> L64
        BitmapFactory.Options r9 = new BitmapFactory.Options();     // Catch: Exception -> L64
        r9.inJustDecodeBounds = false;     // Catch: Exception -> L64
        r9.inSampleSize = r0;     // Catch: Exception -> L64
        r9.inPreferredConfig = Bitmap.Config.ARGB_8888;     // Catch: Exception -> L64
        Bitmap r10 = BitmapFactory.decodeFile(r16.getAbsolutePath(), r9);     // Catch: Exception -> L64
        if (r10 == null) goto L20;
    L25:
        if (r10 == null) goto L80;
        int r1 = 95;
        float r4 = 1.0f;
        Bitmap r11 = r10;
        int r12 = 0;
    L29:
        if (r12 >= 10) goto L40;
        ByteArrayOutputStream r13 = new ByteArrayOutputStream();     // Catch: Exception -> L64
        r10.compress(Bitmap.CompressFormat.JPEG, r1, r13);     // Catch: Exception -> L64
        if (r13.size() <= r18) goto L32;
        r13.close();     // Catch: Exception -> L64
        if (r1 <= 50) goto L36;
        r1 = RangesKt.coerceAtLeast(r1 - 10, 50);     // Catch: Exception -> L64
    L39:
        r12 = r12 + 1;     // Catch: Exception -> L64
        goto L29
    L36:
        r4 = r4 * 0.85f;     // Catch: Exception -> L64
        Bitmap r14 = Bitmap.createScaledBitmap(r10, RangesKt.coerceAtLeast((int) (r10.getWidth() * r4), 1), RangesKt.coerceAtLeast((int) (r10.getHeight() * r4), 1), true);     // Catch: Exception -> L64
        if (r14 == r10) goto L39;
        r10.recycle();     // Catch: Exception -> L64
        r10 = r14;
        r11 = r10;
        goto L39
    L32:
        byte[] r2 = r13.toByteArray();     // Catch: Exception -> L64
        r13.close();     // Catch: Exception -> L64
    L41:
        if (r2 == null) goto L81;
        File r3 = r17.getParentFile();     // Catch: Exception -> L64
        if (r3 != null) goto L46;
    L48:
        PolarisFileOutputStreamWrapper r5 = new PolarisFileOutputStreamWrapper(r17);     // Catch: Exception -> L64
        r5.write(r2);     // Catch: Throwable -> L55
        r5.flush();     // Catch: Throwable -> L55
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L55
        CloseableKt.closeFinally(r5, null);     // Catch: Exception -> L64
        if (r11 == null) goto L53;
        r11.recycle();     // Catch: Exception -> L64
    L53:
        FLogger.a.d("ChameleonImageUtils", "copyImageRespectingSizeLimit success, srcSize=" + r16.length() + " finalSize=" + r17.length() + " finalBytes: " + r2.length);     // Catch: Exception -> L64
        return true;
    L55:
        th = move-exception;
        throw th;     // Catch: Throwable -> L58
    L58:
        th = move-exception;
        CloseableKt.closeFinally(r5, th);     // Catch: Exception -> L64
        throw th;     // Catch: Exception -> L64
    L46:
        if (r3.exists() == true) goto L48;
        r3.mkdirs();     // Catch: Exception -> L64
        goto L48
    L81:
        return false;
    L40:
        r2 = null;
        goto L41
    L80:
        return false;
    L20:
        if (Build.VERSION.SDK_INT < 28) goto L25;
        r10 = ImageDecoder.decodeBitmap(ImageDecoder.createSource(r16), new b(r0));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        FLogger.a.w("ChameleonImageUtils", "ImageDecoder decode failed: " + e.getMessage());     // Catch: Exception -> L64
    L62:
        FLogger.a.w("ChameleonImageUtils", "Get image size failed, width=" + r7 + " height=" + r8 + ", file=" + r16.getCanonicalPath() + " size=" + r16.length());     // Catch: Exception -> L64
        return false;
    L12:
        r8 = 0;
        goto L13
    L9:
        r7 = 0;
        goto L10
    L79:
        return false;
    }

    public static Object b(ThumbType r8, Long r9, Function0 r10, Function1 r11, Continuation r12) {
        Object r13 = BuildersKt.withContext(Dispatchers.getIO(), new ChameleonImageUtils$copyToChameleonDir$2(r8, r11, r10, r9, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }
}
