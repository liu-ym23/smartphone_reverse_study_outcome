package com.ss.android.lark.image.impl.compress2;

import android.graphics.Bitmap;
import com.ss.android.lark.image.uploader.utils.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public interface ICompressStrategy {
    int calcExpectShortSize(ImageInfo r1);

    int calcSampleSize(ImageInfo r1);

    int calcTargetQuality(ImageInfo r1);

    Bitmap.CompressFormat getCompressFormat(String r1);

    boolean shouldSkipCompress(ImageInfo r1, int r2, int r3);
}
