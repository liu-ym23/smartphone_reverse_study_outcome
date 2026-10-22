package com.obric.aee.impl;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.Keep;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.function.Function;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public final class DataHelper {
    public static final DataHelper INSTANCE = null;
    private static final String TAG = null;

    static {
        INSTANCE = new DataHelper();
        TAG = "Aee-DataHelper";
    }

    private DataHelper() {
    }

    public static /* synthetic */ void a(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        decodeByteAraryImageFast$lambda$7(r10, r11, r12, r13, r14, r15);
    }

    public static /* synthetic */ void b(Function r10, ImageDecoder r11, ImageDecoder.ImageInfo r12, ImageDecoder.Source r13) {
        decodeByteAraryImageFastCb$lambda$6(r10, r11, r12, r13);
    }

    public static /* synthetic */ void c(Function r10, ImageDecoder r11, ImageDecoder.ImageInfo r12, ImageDecoder.Source r13) {
        decodeUriImageFastCb$lambda$2(r10, r11, r12, r13);
    }

    public static /* synthetic */ void d(Function r10, ImageDecoder r11, ImageDecoder.ImageInfo r12, ImageDecoder.Source r13) {
        decodePathImageFastCb$lambda$4(r10, r11, r12, r13);
    }

    public static /* synthetic */ Bitmap decodeByteAraryImageFast$default(DataHelper r10, byte[] r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = -1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = -1;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = -1;
    L12:
        return r10.decodeByteAraryImageFast(r11, r12, r13, r14);
    }

    private static final void decodeByteAraryImageFast$lambda$7(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        Intrinsics.checkNotNullParameter(r13, "decoder");
        Intrinsics.checkNotNullParameter(r14, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(r15, "<anonymous parameter 2>");
        r13.setMutableRequired(true);
        if (r10 <= 0) goto L5;
        r13.setTargetSampleSize(r10);
        return;
    L5:
        if (r11 <= 0) goto L10;
        if (r12 <= 0) goto L11;
        r13.setTargetSize(r11, r12);
        return;
    L11:
        return;
    }

    private static final void decodeByteAraryImageFastCb$lambda$6(Function r10, ImageDecoder r11, ImageDecoder.ImageInfo r12, ImageDecoder.Source r13) {
        Intrinsics.checkNotNullParameter(r10, "$cb");
        Intrinsics.checkNotNullParameter(r11, "decoder");
        Intrinsics.checkNotNullParameter(r12, "info");
        Intrinsics.checkNotNullParameter(r13, "<anonymous parameter 2>");
        Object r14 = r10.apply(new int[]{r12.getSize().getWidth(), r12.getSize().getHeight()});
        Intrinsics.checkNotNullExpressionValue(r14, "cb.apply(intArrayOf(info…width, info.size.height))");
        int[] r15 = (int[]) r14;
        r11.setMutableRequired(true);
        r11.setTargetSize(r15[0], r15[1]);
    }

    public static /* synthetic */ Bitmap decodeFdImageFast$default(DataHelper r10, ParcelFileDescriptor r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = -1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = -1;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = -1;
    L12:
        return r10.decodeFdImageFast(r11, r12, r13, r14);
    }

    public static /* synthetic */ Bitmap decodePathImageFast$default(DataHelper r10, String r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = -1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = -1;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = -1;
    L12:
        return r10.decodePathImageFast(r11, r12, r13, r14);
    }

    private static final void decodePathImageFast$lambda$5(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        Intrinsics.checkNotNullParameter(r13, "decoder");
        Intrinsics.checkNotNullParameter(r14, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(r15, "<anonymous parameter 2>");
        r13.setMutableRequired(true);
        if (r10 <= 0) goto L5;
        r13.setTargetSampleSize(r10);
        return;
    L5:
        if (r11 <= 0) goto L10;
        if (r12 <= 0) goto L11;
        r13.setTargetSize(r11, r12);
        return;
    L11:
        return;
    }

    private static final void decodePathImageFastCb$lambda$4(Function r10, ImageDecoder r11, ImageDecoder.ImageInfo r12, ImageDecoder.Source r13) {
        Intrinsics.checkNotNullParameter(r10, "$cb");
        Intrinsics.checkNotNullParameter(r11, "decoder");
        Intrinsics.checkNotNullParameter(r12, "info");
        Intrinsics.checkNotNullParameter(r13, "<anonymous parameter 2>");
        Object r14 = r10.apply(new int[]{r12.getSize().getWidth(), r12.getSize().getHeight()});
        Intrinsics.checkNotNullExpressionValue(r14, "cb.apply(intArrayOf(info…width, info.size.height))");
        int[] r15 = (int[]) r14;
        r11.setMutableRequired(true);
        r11.setTargetSize(r15[0], r15[1]);
    }

    public static /* synthetic */ Bitmap decodeUriImageFast$default(DataHelper r10, String r11, int r12, int r13, int r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = -1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = -1;
    L9:
        if ((r15 & 8) == 0) goto L12;
        r14 = -1;
    L12:
        return r10.decodeUriImageFast(r11, r12, r13, r14);
    }

    private static final void decodeUriImageFast$lambda$3(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        Intrinsics.checkNotNullParameter(r13, "decoder");
        Intrinsics.checkNotNullParameter(r14, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(r15, "<anonymous parameter 2>");
        r13.setMutableRequired(true);
        if (r10 <= 0) goto L5;
        r13.setTargetSampleSize(r10);
        return;
    L5:
        if (r11 <= 0) goto L10;
        if (r12 <= 0) goto L11;
        r13.setTargetSize(r11, r12);
        return;
    L11:
        return;
    }

    private static final void decodeUriImageFastCb$lambda$2(Function r10, ImageDecoder r11, ImageDecoder.ImageInfo r12, ImageDecoder.Source r13) {
        Intrinsics.checkNotNullParameter(r10, "$cb");
        Intrinsics.checkNotNullParameter(r11, "decoder");
        Intrinsics.checkNotNullParameter(r12, "info");
        Intrinsics.checkNotNullParameter(r13, "<anonymous parameter 2>");
        Object r14 = r10.apply(new int[]{r12.getSize().getWidth(), r12.getSize().getHeight()});
        Intrinsics.checkNotNullExpressionValue(r14, "cb.apply(intArrayOf(info…width, info.size.height))");
        int[] r15 = (int[]) r14;
        r11.setMutableRequired(true);
        r11.setTargetSize(r15[0], r15[1]);
    }

    public static /* synthetic */ void e(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        decodeUriImageFast$lambda$3(r10, r11, r12, r13, r14, r15);
    }

    private final Bitmap ensureRGBA(Bitmap r10) {
        Bitmap.Config r11 = r10.getConfig();
        Bitmap.Config r12 = Bitmap.Config.ARGB_8888;
        if (r11 == r12) goto L6;
        Bitmap r13 = r10.copy(r12, true);
        Intrinsics.checkNotNullExpressionValue(r13, "bitmap.copy(Bitmap.Config.ARGB_8888, true)");
        return r13;
    L6:
        return r10;
    }

    public static /* synthetic */ void f(int r10, int r11, int r12, ImageDecoder r13, ImageDecoder.ImageInfo r14, ImageDecoder.Source r15) {
        decodePathImageFast$lambda$5(r10, r11, r12, r13, r14, r15);
    }

    private final byte[] readUri(String r10) {
        InputStream r11 = EngineBridge.INSTANCE.getAndroidContext().getContentResolver().openInputStream(Uri.parse(r10));
        if (r11 != null) goto L16;
        byte[] r12 = null;
    L12:
        CloseableKt.closeFinally(r11, null);
        return r12;
    L16:
        Intrinsics.checkNotNullExpressionValue(r11, "it");     // Catch: Throwable -> L6
        r12 = ByteStreamsKt.readBytes(r11);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public final Bitmap decodeByteAraryImageFast(byte[] r10, final int r11, final int r12, final int r13) {
        Intrinsics.checkNotNullParameter(r10, "data");
        ImageDecoder.Source r14 = ImageDecoder.createSource(r10);
        Intrinsics.checkNotNullExpressionValue(r14, "createSource(data)");
        Bitmap r15 = ImageDecoder.decodeBitmap(r14, new a(r13, r11, r12));
        Intrinsics.checkNotNullExpressionValue(r15, "decodeBitmap(src) { deco…)\n            }\n        }");
        return ensureRGBA(r15);
    }

    public final Bitmap decodeByteAraryImageFastCb(byte[] r10, final Function<int[], int[]> r11) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Intrinsics.checkNotNullParameter(r11, "cb");
        ImageDecoder.Source r12 = ImageDecoder.createSource(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "createSource(data)");
        Bitmap r13 = ImageDecoder.decodeBitmap(r12, new d(r11));
        Intrinsics.checkNotNullExpressionValue(r13, "decodeBitmap(src) { deco…0], resized[1])\n        }");
        return ensureRGBA(r13);
    }

    public final Bitmap decodeFdImageFast(ParcelFileDescriptor r10, int r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "fd");
        FileInputStream r14 = new FileInputStream(r10.getFileDescriptor());
        Bitmap r15 = INSTANCE.decodeByteAraryImageFast(ByteStreamsKt.readBytes(r14), r11, r12, r13);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return r15;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public final Bitmap decodeFdImageFastCb(ParcelFileDescriptor r10, Function<int[], int[]> r11) {
        Intrinsics.checkNotNullParameter(r10, "fd");
        Intrinsics.checkNotNullParameter(r11, "cb");
        FileInputStream r12 = new FileInputStream(r10.getFileDescriptor());
        Bitmap r13 = INSTANCE.decodeByteAraryImageFastCb(ByteStreamsKt.readBytes(r12), r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r12, null);
        return r13;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public final Bitmap decodePathImageFast(String r10, final int r11, final int r12, final int r13) {
        Intrinsics.checkNotNullParameter(r10, "path");
        ImageDecoder.Source r14 = ImageDecoder.createSource(new File(r10));
        Intrinsics.checkNotNullExpressionValue(r14, "createSource(File(path))");
        Bitmap r15 = ImageDecoder.decodeBitmap(r14, new c(r13, r11, r12));
        Intrinsics.checkNotNullExpressionValue(r15, "decodeBitmap(src) { deco…)\n            }\n        }");
        return ensureRGBA(r15);
    }

    public final Bitmap decodePathImageFastCb(String r10, final Function<int[], int[]> r11) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "cb");
        ImageDecoder.Source r12 = ImageDecoder.createSource(new File(r10));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r12, "createSource(File(path))");     // Catch: Exception -> L5
        Bitmap r13 = ImageDecoder.decodeBitmap(r12, new f(r11));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r13, "decodeBitmap(src) { deco…resized[1])\n            }");     // Catch: Exception -> L5
        return ensureRGBA(r13);
    L5:
        e = move-exception;
        Log.e(TAG, "decodePathImageFast failed, uri: " + r10 + ", e: " + e);
        throw e;
    }

    public final Bitmap decodeUriImageFast(String r10, final int r11, final int r12, final int r13) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        ImageDecoder.Source r14 = ImageDecoder.createSource(EngineBridge.INSTANCE.getAndroidContext().getContentResolver(), Uri.parse(r10));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r14, "createSource(EngineBridg…Resolver, Uri.parse(uri))");     // Catch: Exception -> L5
        Bitmap r15 = ImageDecoder.decodeBitmap(r14, new b(r13, r11, r12));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r15, "decodeBitmap(src) { deco…          }\n            }");     // Catch: Exception -> L5
        return ensureRGBA(r15);
    L5:
        e = move-exception;
        Log.e(TAG, "decodeUriImageFast failed, uri: " + r10 + ", e: " + e);
        throw e;
    }

    public final Bitmap decodeUriImageFastCb(String r10, final Function<int[], int[]> r11) {
        Intrinsics.checkNotNullParameter(r10, "uri");
        Intrinsics.checkNotNullParameter(r11, "cb");
        ImageDecoder.Source r12 = ImageDecoder.createSource(EngineBridge.INSTANCE.getAndroidContext().getContentResolver(), Uri.parse(r10));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r12, "createSource(EngineBridg…Resolver, Uri.parse(uri))");     // Catch: Exception -> L5
        Bitmap r13 = ImageDecoder.decodeBitmap(r12, new e(r11));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r13, "decodeBitmap(src) { deco…resized[1])\n            }");     // Catch: Exception -> L5
        return ensureRGBA(r13);
    L5:
        e = move-exception;
        Log.e(TAG, "decodeUriImageFast failed, uri: " + r10 + ", e: " + e);
        throw e;
    }

    public final byte[] getFdContent(ParcelFileDescriptor r10) {
        Intrinsics.checkNotNullParameter(r10, "fd");
        FileInputStream r11 = new FileInputStream(r10.getFileDescriptor());
        byte[] r12 = INSTANCE.readStreamDataAll(r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r11, null);
        return r12;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }

    public final String getTAG() {
        return TAG;
    }

    public final byte[] readFile(String r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        return FilesKt.readBytes(new File(r10));
    }

    public final byte[] readStreamDataAll(InputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "stream");
        return ByteStreamsKt.readBytes(r10);
    }
}
