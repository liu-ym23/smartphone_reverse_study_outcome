package com.obric.aee.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\"\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011J,\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\"\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011J,\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\"\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011J,\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fJ\"\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u000e\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010 \u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020#J\u0012\u0010$\u001a\u0004\u0018\u00010\n2\u0006\u0010%\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006&"}, d2 = {"Lcom/obric/aee/impl/DataHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "decodeByteAraryImageFast", "Landroid/graphics/Bitmap;", "data", "", "width", "", "height", "sampleSize", "decodeByteAraryImageFastCb", f.c, "Ljava/util/function/Function;", "", "decodeFdImageFast", "fd", "Landroid/os/ParcelFileDescriptor;", "decodeFdImageFastCb", "decodePathImageFast", "path", "decodePathImageFastCb", "decodeUriImageFast", "uri", "decodeUriImageFastCb", "ensureRGBA", "bitmap", "getFdContent", "readFile", "readStreamDataAll", CozeCloudExt.API_KEY_HTTP_STREAM_METHOD, "Ljava/io/InputStream;", "readUri", "key", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DataHelper {
    public static final DataHelper INSTANCE = null;
    private static final String TAG = null;

    static {
        INSTANCE = new DataHelper();
        TAG = "Aee-DataHelper";
    }

    private DataHelper() {
    }

    public static /* synthetic */ Bitmap decodeByteAraryImageFast$default(DataHelper r1, byte[] r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = -1;
    L12:
        return r1.decodeByteAraryImageFast(r2, r3, r4, r5);
    }

    private static final void decodeByteAraryImageFast$lambda$7(int r1, int r2, int r3, ImageDecoder r4, ImageDecoder.ImageInfo r5, ImageDecoder.Source r6) {
        Intrinsics.checkNotNullParameter(r4, "decoder");
        Intrinsics.checkNotNullParameter(r5, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        r4.setMutableRequired(true);
        if (r1 <= 0) goto L5;
        r4.setTargetSampleSize(r1);
        return;
    L5:
        if (r2 <= 0) goto L10;
        if (r3 <= 0) goto L11;
        r4.setTargetSize(r2, r3);
        return;
    L11:
        return;
    }

    private static final void decodeByteAraryImageFastCb$lambda$6(Function r3, ImageDecoder r4, ImageDecoder.ImageInfo r5, ImageDecoder.Source r6) {
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "$cb");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        Object r8 = r7.apply(new int[]{r5.getSize().getWidth(), r5.getSize().getHeight()});
        Intrinsics.checkNotNullExpressionValue(r8, "cb.apply(intArrayOf(info…width, info.size.height))");
        int[] r9 = (int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.memorydata.plugin");
        r4.setMutableRequired(true);
        r4.setTargetSize(r9[0], r9[1]);
    }

    public static /* synthetic */ Bitmap decodeFdImageFast$default(DataHelper r1, ParcelFileDescriptor r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = -1;
    L12:
        return r1.decodeFdImageFast(r2, r3, r4, r5);
    }

    public static /* synthetic */ Bitmap decodePathImageFast$default(DataHelper r1, String r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = -1;
    L12:
        return r1.decodePathImageFast(r2, r3, r4, r5);
    }

    private static final void decodePathImageFast$lambda$5(int r1, int r2, int r3, ImageDecoder r4, ImageDecoder.ImageInfo r5, ImageDecoder.Source r6) {
        Intrinsics.checkNotNullParameter(r4, "decoder");
        Intrinsics.checkNotNullParameter(r5, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        r4.setMutableRequired(true);
        if (r1 <= 0) goto L5;
        r4.setTargetSampleSize(r1);
        return;
    L5:
        if (r2 <= 0) goto L10;
        if (r3 <= 0) goto L11;
        r4.setTargetSize(r2, r3);
        return;
    L11:
        return;
    }

    private static final void decodePathImageFastCb$lambda$4(Function r3, ImageDecoder r4, ImageDecoder.ImageInfo r5, ImageDecoder.Source r6) {
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "$cb");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        Object r8 = r7.apply(new int[]{r5.getSize().getWidth(), r5.getSize().getHeight()});
        Intrinsics.checkNotNullExpressionValue(r8, "cb.apply(intArrayOf(info…width, info.size.height))");
        int[] r9 = (int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.memorydata.plugin");
        r4.setMutableRequired(true);
        r4.setTargetSize(r9[0], r9[1]);
    }

    public static /* synthetic */ Bitmap decodeUriImageFast$default(DataHelper r1, String r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r6 & 8) == 0) goto L12;
        r5 = -1;
    L12:
        return r1.decodeUriImageFast(r2, r3, r4, r5);
    }

    private static final void decodeUriImageFast$lambda$3(int r1, int r2, int r3, ImageDecoder r4, ImageDecoder.ImageInfo r5, ImageDecoder.Source r6) {
        Intrinsics.checkNotNullParameter(r4, "decoder");
        Intrinsics.checkNotNullParameter(r5, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        r4.setMutableRequired(true);
        if (r1 <= 0) goto L5;
        r4.setTargetSampleSize(r1);
        return;
    L5:
        if (r2 <= 0) goto L10;
        if (r3 <= 0) goto L11;
        r4.setTargetSize(r2, r3);
        return;
    L11:
        return;
    }

    private static final void decodeUriImageFastCb$lambda$2(Function r3, ImageDecoder r4, ImageDecoder.ImageInfo r5, ImageDecoder.Source r6) {
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "$cb");
        Intrinsics.checkNotNullParameter(r4, "decoder");
        Intrinsics.checkNotNullParameter(r5, "info");
        Intrinsics.checkNotNullParameter(r6, "<anonymous parameter 2>");
        Object r8 = r7.apply(new int[]{r5.getSize().getWidth(), r5.getSize().getHeight()});
        Intrinsics.checkNotNullExpressionValue(r8, "cb.apply(intArrayOf(info…width, info.size.height))");
        int[] r9 = (int[]) ZeusTransformUtils.preCheckCast(r8, int[].class, "com.obric.memorydata.plugin");
        r4.setMutableRequired(true);
        r4.setTargetSize(r9[0], r9[1]);
    }

    private final Bitmap ensureRGBA(Bitmap r2) {
        if (r2.getConfig() == Bitmap.Config.ARGB_8888) goto L6;
        Bitmap r1 = r2.copy(Bitmap.Config.ARGB_8888, true);
        Intrinsics.checkNotNullExpressionValue(r1, "bitmap.copy(Bitmap.Config.ARGB_8888, true)");
        return r1;
    L6:
        return r2;
    }

    public static /* synthetic */ void lambda$DsvZCyLzNdQi0jiX3lZ6peL82Dg(int r0, int r1, int r2, ImageDecoder r3, ImageDecoder.ImageInfo r4, ImageDecoder.Source r5) {
        decodeByteAraryImageFast$lambda$7(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$FdLdPdf5NFw6Gh1G7h0OkqzHBPA(Function r0, ImageDecoder r1, ImageDecoder.ImageInfo r2, ImageDecoder.Source r3) {
        decodeByteAraryImageFastCb$lambda$6(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$JFFNIuK8nwTiHPt63AP6PR_Bo4I(Function r0, ImageDecoder r1, ImageDecoder.ImageInfo r2, ImageDecoder.Source r3) {
        decodeUriImageFastCb$lambda$2(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$X2Mmz-rR4rtOVg9z8RPHec84Emw, reason: not valid java name */
    public static /* synthetic */ void m145lambda$X2MmzrR4rtOVg9z8RPHec84Emw(Function r0, ImageDecoder r1, ImageDecoder.ImageInfo r2, ImageDecoder.Source r3) {
        decodePathImageFastCb$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$iQaWTQVYwVPRcKKCYo9LZTVAbmA(int r0, int r1, int r2, ImageDecoder r3, ImageDecoder.ImageInfo r4, ImageDecoder.Source r5) {
        decodeUriImageFast$lambda$3(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$ysbKeltxi9SBv36vUVxBBxgNmy8(int r0, int r1, int r2, ImageDecoder r3, ImageDecoder.ImageInfo r4, ImageDecoder.Source r5) {
        decodePathImageFast$lambda$5(r0, r1, r2, r3, r4, r5);
    }

    private final byte[] readUri(String r3) {
        Closeable r2 = (Closeable) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(EngineBridge.INSTANCE.getAndroidContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().openInputStream(Uri.parse(r3)), Closeable.class, "com.obric.memorydata.plugin");
        InputStream r4 = (InputStream) ZeusTransformUtils.preCheckCast(r2, InputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r4 == null) goto L7;
        Intrinsics.checkNotNullExpressionValue(r4, "it");     // Catch: Throwable -> L10
        byte[] r5 = ByteStreamsKt.readBytes(r4);     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r2, null);
        return r5;
    L7:
        r5 = null;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);
        throw th;
    }

    public final Bitmap decodeByteAraryImageFast(byte[] r2, final int r3, final int r4, final int r5) {
        Intrinsics.checkNotNullParameter(r2, "data");
        ImageDecoder.Source r6 = ImageDecoder.createSource(r2);
        Intrinsics.checkNotNullExpressionValue(r6, "createSource(data)");
        Bitmap r7 = ImageDecoder.decodeBitmap(r6, new $$Lambda$DataHelper$DsvZCyLzNdQi0jiX3lZ6peL82Dg(r5, r3, r4));
        Intrinsics.checkNotNullExpressionValue(r7, "decodeBitmap(src) { deco…)\n            }\n        }");
        return ensureRGBA(r7);
    }

    public final Bitmap decodeByteAraryImageFastCb(byte[] r3, Function<int[], int[]> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "data");
        Intrinsics.checkNotNullParameter(r5, f.c);
        ImageDecoder.Source r6 = ImageDecoder.createSource(r3);
        Intrinsics.checkNotNullExpressionValue(r6, "createSource(data)");
        Bitmap r7 = ImageDecoder.decodeBitmap(r6, new $$Lambda$DataHelper$FdLdPdf5NFw6Gh1G7h0OkqzHBPA(r5));
        Intrinsics.checkNotNullExpressionValue(r7, "decodeBitmap(src) { deco…0], resized[1])\n        }");
        return ensureRGBA(r7);
    }

    public final Bitmap decodeFdImageFast(ParcelFileDescriptor r4, int r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r4, "fd");
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r4.getFileDescriptor()), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r8 = (FileInputStream) ZeusTransformUtils.preCheckCast(r3, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Bitmap r9 = INSTANCE.decodeByteAraryImageFast(ByteStreamsKt.readBytes((InputStream) ZeusTransformUtils.preCheckCast(r8, InputStream.class, "com.obric.memorydata.plugin")), r5, r6, r7);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r3, null);
        return r9;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public final Bitmap decodeFdImageFastCb(ParcelFileDescriptor r4, Function<int[], int[]> r5) {
        Function<int[], int[]> r3 = (Function) ZeusTransformUtils.wrapperContextForParams(r5, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "fd");
        Intrinsics.checkNotNullParameter(r3, f.c);
        Closeable r6 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r4.getFileDescriptor()), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r7 = (FileInputStream) ZeusTransformUtils.preCheckCast(r6, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        Bitmap r8 = INSTANCE.decodeByteAraryImageFastCb(ByteStreamsKt.readBytes((InputStream) ZeusTransformUtils.preCheckCast(r7, InputStream.class, "com.obric.memorydata.plugin")), r3);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r6, null);
        return r8;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    }

    public final Bitmap decodePathImageFast(String r2, final int r3, final int r4, final int r5) {
        Intrinsics.checkNotNullParameter(r2, "path");
        ImageDecoder.Source r6 = ImageDecoder.createSource(new File(r2));
        Intrinsics.checkNotNullExpressionValue(r6, "createSource(File(path))");
        Bitmap r7 = ImageDecoder.decodeBitmap(r6, new $$Lambda$DataHelper$ysbKeltxi9SBv36vUVxBBxgNmy8(r5, r3, r4));
        Intrinsics.checkNotNullExpressionValue(r7, "decodeBitmap(src) { deco…)\n            }\n        }");
        return ensureRGBA(r7);
    }

    public final Bitmap decodePathImageFastCb(final String r4, Function<int[], int[]> r5) {
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r5, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "path");
        Intrinsics.checkNotNullParameter(r6, f.c);
        ImageDecoder.Source r0 = ImageDecoder.createSource(new File(r4));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "createSource(File(path))");     // Catch: Exception -> L5
        Bitmap r7 = ImageDecoder.decodeBitmap(r0, new $$Lambda$DataHelper$X2MmzrR4rtOVg9z8RPHec84Emw(r6));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r7, "decodeBitmap(src) { deco…resized[1])\n            }");     // Catch: Exception -> L5
        return ensureRGBA(r7);
    L5:
        e = move-exception;
        EngineBridge.INSTANCE.hostLogE(TAG, (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, e), Function0.class, "com.obric.memorydata.plugin"));
        throw e;
    }

    public final Bitmap decodeUriImageFast(final String r4, final int r5, final int r6, final int r7) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        ImageDecoder.Source r1 = ImageDecoder.createSource(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(EngineBridge.INSTANCE.getAndroidContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse(r4));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r1, "createSource(EngineBridg…Resolver, Uri.parse(uri))");     // Catch: Exception -> L5
        Bitmap r8 = ImageDecoder.decodeBitmap(r1, new $$Lambda$DataHelper$iQaWTQVYwVPRcKKCYo9LZTVAbmA(r7, r5, r6));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r8, "decodeBitmap(src) { deco…          }\n            }");     // Catch: Exception -> L5
        return ensureRGBA(r8);
    L5:
        e = move-exception;
        EngineBridge.INSTANCE.hostLogE(TAG, (Function0) ZeusTransformUtils.preCheckCast(new C09811(r4, e), Function0.class, "com.obric.memorydata.plugin"));
        throw e;
    }

    public final Bitmap decodeUriImageFastCb(final String r4, Function<int[], int[]> r5) {
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r5, Function.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "uri");
        Intrinsics.checkNotNullParameter(r6, f.c);
        ImageDecoder.Source r0 = ImageDecoder.createSource(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(EngineBridge.INSTANCE.getAndroidContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse(r4));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r0, "createSource(EngineBridg…Resolver, Uri.parse(uri))");     // Catch: Exception -> L5
        Bitmap r7 = ImageDecoder.decodeBitmap(r0, new $$Lambda$DataHelper$JFFNIuK8nwTiHPt63AP6PR_Bo4I(r6));     // Catch: Exception -> L5
        Intrinsics.checkNotNullExpressionValue(r7, "decodeBitmap(src) { deco…resized[1])\n            }");     // Catch: Exception -> L5
        return ensureRGBA(r7);
    L5:
        e = move-exception;
        EngineBridge.INSTANCE.hostLogE(TAG, (Function0) ZeusTransformUtils.preCheckCast(new C09821(r4, e), Function0.class, "com.obric.memorydata.plugin"));
        throw e;
    }

    public final byte[] getFdContent(ParcelFileDescriptor r4) {
        Intrinsics.checkNotNullParameter(r4, "fd");
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r4.getFileDescriptor()), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r5 = (FileInputStream) ZeusTransformUtils.preCheckCast(r3, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        byte[] r6 = INSTANCE.readStreamDataAll((InputStream) ZeusTransformUtils.preCheckCast(r5, InputStream.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r3, null);
        return r6;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);
        throw th;
    }

    public final String getTAG() {
        return TAG;
    }

    public final byte[] readFile(String r1) {
        Intrinsics.checkNotNullParameter(r1, "path");
        return FilesKt.readBytes(new File(r1));
    }

    public final byte[] readStreamDataAll(InputStream r1) {
        Intrinsics.checkNotNullParameter(r1, CozeCloudExt.API_KEY_HTTP_STREAM_METHOD);
        return ByteStreamsKt.readBytes(r1);
    }
}
