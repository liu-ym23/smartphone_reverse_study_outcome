package com.ss.android.lark.image.impl.compress2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.h;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.uploader.utils.ImageInfo;
import com.ss.android.lark.image.uploader.utils.b;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class CompressEngine {
    private final CompressImageCache imageCache;
    private final ICompressStrategy strategy;

    public CompressResult compress(CompressRequest r19) throws IOException, IllegalStateException {
        IImageSource r3 = r19.iImageSource;
        boolean r5 = false;
        ImageInfo r6 = b.d(r3.getPath(), true, false);
        if (r6 == null) goto L70;
        long r7 = r6.c;
        int r9 = this.strategy.calcExpectShortSize(r6);
        int r10 = this.strategy.calcTargetQuality(r6);
        String r11 = ImageCacheKey.newBuilder().fileKey(r3.uniqueKey()).expectShortSize(r9).expectQuality(r10).toKey();
        File r12 = this.imageCache.getCacheFile(r11);
        if (r12 == null) goto L27;
        if (r12.exists() == false) goto L27;
        PolarisFileInputStreamWrapper r15 = new PolarisFileInputStreamWrapper(r12);     // Catch: Throwable -> L13 IOException -> L15
        ImageInfo r0 = b.d(r12.getPath(), true, false);     // Catch: IOException -> L11 Throwable -> L22
        IOUtils.closeSafety(r15);
    L19:
        if (r0 == null) goto L27;
        Log.i("ImageCompressor", "image cache hit, skip compress");
        return CompressResult.newBuilder().compressImageFile(r12).outWidth(r0.a).outHeight(r0.b).outSize(r12.length()).originWidth(r6.a).originHeight(r6.b).originSize(r7).build();
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L22
        IOUtils.closeSafety(r15);
        r0 = null;
        goto L19
    L15:
        e = e;
        r15 = null;
    L13:
        th = th;
        PolarisFileInputStreamWrapper r14 = null;
    L24:
        IOUtils.closeSafety(r14);
        throw th;
    L22:
        th = th;
        r14 = r15;
    L27:
        if (this.strategy.shouldSkipCompress(r6, r9, r10) == false) goto L30;
        Log.i("ImageCompressor", "not need compress, skipped, " + r6.toString() + " expect: " + r9 + "," + r10);
        return CompressResult.newBuilder().compressImageFile(new PolarisFileWrapper(r3.getPath())).outWidth(r6.a).outHeight(r6.b).outSize(r7).originWidth(r6.a).originHeight(r6.b).originSize(r7).build();
    L30:
        int r1 = this.strategy.calcSampleSize(r6);
        InputStream r4 = r3.open();     // Catch: Throwable -> L50 OutOfMemoryError -> L52
        Bitmap r13 = baseScaleBitmap(r4, r1);     // Catch: Throwable -> L46 OutOfMemoryError -> L48
        IOUtils.closeSafety(r4);     // Catch: OutOfMemoryError -> L44 Throwable -> L46
        Bitmap r2 = TransformationUtilsKt.rotateImageExif(r13, r6.f);     // Catch: OutOfMemoryError -> L44 Throwable -> L46
        if (r13 == r2) goto L75;
        r13.recycle();     // Catch: OutOfMemoryError -> L44 Throwable -> L46
        r13 = r2;
    L75:
    L42:
        e = e;
        r5 = true;
    L55:
        Log.e("ImageCompressor", "image compress out of memory :" + e.getMessage());     // Catch: Throwable -> L46
        if (r5 == true) goto L59;
        if (r13 == null) goto L59;
        r13.recycle();     // Catch: Throwable -> L46
        Bitmap r16 = null;
    L60:
        h.b("image_compress_oom", FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.crash.disable_oppo_android15_explicit_gc_guard"), true);     // Catch: Throwable -> L46
        IOUtils.closeSafety(r4);
        r13 = r16;
    L62:
        if (r13 == null) goto L66;
        int r8 = r13.getWidth();
        int r17 = r13.getHeight();
        File r18 = this.imageCache.createCacheFile(r11);
        Bitmap.CompressFormat r20 = this.strategy.getCompressFormat(r6.e);
        PolarisFileOutputStreamWrapper r21 = new PolarisFileOutputStreamWrapper(r18);
        r13.compress(r20, r10, r21);
        r13.recycle();
        IOUtils.closeSafety(r21);
        return CompressResult.newBuilder().compressImageFile(r18).outWidth(r8).outHeight(r17).outSize(r18.length()).originWidth(r6.a).originHeight(r6.b).originSize(r7).build();
    L66:
        throw new IllegalStateException("image compress failed");
    L59:
        r16 = r13;
        goto L60
    L38:
        if (Math.min(r13.getWidth(), r13.getHeight()) <= (((double) r9) * 1.1d)) goto L41;
        Bitmap r22 = twiceScaleBitmap(r13, r9);     // Catch: OutOfMemoryError -> L42 Throwable -> L46
        r13.recycle();     // Catch: OutOfMemoryError -> L42 Throwable -> L46
        r13 = r22;
    L41:
        IOUtils.closeSafety(r4);
    L44:
        e = e;
    L48:
        e = e;
    L54:
        r13 = null;
    L46:
        th = th;
        InputStream r110 = r4;
    L67:
        IOUtils.closeSafety(r110);
        throw th;
    L52:
        e = e;
        r4 = null;
    L50:
        th = th;
        r110 = null;
        goto L67
    L70:
        throw new IllegalStateException("parse image file failed");
    }

    public CompressEngine(CompressImageCache r1, ICompressStrategy r2) {
        this.imageCache = r1;
        this.strategy = r2;
    }

    private Bitmap baseScaleBitmap(InputStream r2, int r3) {
        BitmapFactory.Options r0 = new BitmapFactory.Options();
        r0.inSampleSize = r3;
        return BitmapFactory.decodeStream(r2, null, r0);
    }

    private Bitmap twiceScaleBitmap(Bitmap r4, int r5) {
        int r0 = r4.getWidth();
        int r1 = r4.getHeight();
        float r6 = (r5 * 1.0f) / Math.min(r0, r1);
        return Bitmap.createScaledBitmap(r4, (int) (r0 * r6), (int) (r1 * r6), false);
    }
}
