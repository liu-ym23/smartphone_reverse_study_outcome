package com.ss.android.lark.image.impl.service;

import com.ss.android.lark.image.impl.compress2.IParamsProvider;
import com.ss.android.lark.image.uploader.utils.ImageInfo;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CompressParamsProvider implements IParamsProvider {
    int[] lastCompressParams;
    ImageInfo lastImageInfo;
    private final int preferQuality;
    private final int preferShortSize;

    @Override // com.ss.android.lark.image.impl.compress2.IParamsProvider
    public int[] getPreferParams(ImageInfo r11) {
        int r5 = Math.min(r11.a, r11.b);
        int r6 = Math.max(r11.a, r11.b);
        int r0 = this.preferShortSize;
        if (r0 <= 0) goto L9;
        if (this.preferQuality <= 0) goto L9;
        return new int[]{Math.min(r5, r0), Math.min(this.preferQuality, 100)};
    L9:
        if (this.lastCompressParams != null) goto L11;
    L12:
        this.lastCompressParams = ImageService.inst().getImageCompressParams(r11.c, r5, r6, r11.d, -1, -1);
        this.lastImageInfo = r11;
    L13:
        int[] r12 = this.lastCompressParams;
        if (r12 != null) goto L16;
    L17:
        this.lastCompressParams = new int[]{1080, 50};
    L19:
        return this.lastCompressParams;
    L16:
        if (r12.length >= 2) goto L19;
    L11:
        if (this.lastImageInfo == r11) goto L13;
        goto L12
    }

    public CompressParamsProvider(int r1, int r2) {
        this.preferShortSize = r1;
        this.preferQuality = r2;
    }
}
