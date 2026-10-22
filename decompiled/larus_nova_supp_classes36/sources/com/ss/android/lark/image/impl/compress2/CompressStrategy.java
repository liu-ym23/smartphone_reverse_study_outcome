package com.ss.android.lark.image.impl.compress2;

import android.graphics.Bitmap;
import com.ss.android.lark.image.uploader.utils.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class CompressStrategy implements ICompressStrategy {
    private final IParamsProvider paramsProvider;

    private static long calculateBitmapMemoryUse(int r0, int r1) {
        return (r0 * r1) * 4;
    }

    private int getNearestPow2(int r3) {
        int r0 = 1;
    L3:
        int r1 = r0 << 1;
        if (r1 > r3) goto L6;
        r0 = r1;
        goto L3
    L6:
        return r0;
    }

    public CompressStrategy(IParamsProvider r1) {
        this.paramsProvider = r1;
    }

    private int getPreferShortSize(ImageInfo r2) {
        return this.paramsProvider.getPreferParams(r2)[0];
    }

    private int getTargetQuality(ImageInfo r2) {
        int r3 = this.paramsProvider.getPreferParams(r2)[1];
        if (r3 > 0) goto L6;
        return 100;
    L6:
        return r3;
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public int calcExpectShortSize(ImageInfo r8) {
        int r0 = calcSampleSize(r8);
        float r1 = r0;
        int r2 = (int) ((r8.a * 1.0f) / r1);
        int r3 = (int) ((r8.b * 1.0f) / r1);
        int r4 = Math.min(r2, r3);
        int r9 = getPreferShortSize(r8);
        if (r4 > r9) goto L5;
    L7:
        return r4;
    L5:
        if (calculateBitmapMemoryUse(r2, r3) > (Runtime.getRuntime().maxMemory() / 10)) goto L7;
        return r9;
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public int calcSampleSize(ImageInfo r6) {
        int r0 = Math.min(r6.a, r6.b);
        if ((r0 % 2) != 1) goto L5;
        r0 = r0 + 1;
    L5:
        int r7 = getPreferShortSize(r6);
        if (r0 > r7) goto L8;
    L10:
        int r8 = 1;
    L12:
        return Math.max(r8, 1);
    L8:
        if (r0 < 1944.0f) goto L10;
        r8 = getNearestPow2((int) Math.round((((double) r0) * 1.0d) / ((double) r7)));
        goto L12
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public int calcTargetQuality(ImageInfo r1) {
        return getTargetQuality(r1);
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public Bitmap.CompressFormat getCompressFormat(String r2) {
        if ("image/png".equalsIgnoreCase(r2) == false) goto L7;
        return Bitmap.CompressFormat.JPEG;
    L7:
        if ("image/webp".equalsIgnoreCase(r2) == false) goto L11;
        return Bitmap.CompressFormat.WEBP;
    L11:
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.ss.android.lark.image.impl.compress2.ICompressStrategy
    public boolean shouldSkipCompress(ImageInfo r7, int r8, int r9) {
        boolean r0 = r7.g;
        long r1 = r7.c;
        if (r1 < 10240) goto L13;
        if (r0 == true) goto L8;
        if (r1 < 20480) goto L13;
    L8:
        if (Math.min(r7.a, r7.b) <= r8) goto L10;
    L12:
        return false;
    L10:
        if (r7.d > r9) goto L12;
    L13:
        return true;
    }
}
