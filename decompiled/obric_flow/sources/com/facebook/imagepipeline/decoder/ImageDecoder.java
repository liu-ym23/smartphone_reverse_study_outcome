package com.facebook.imagepipeline.decoder;

import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface ImageDecoder {
    CloseableImage a(EncodedImage r5, int r10, QualityInfo r11, ImageDecodeOptions r12);
}
