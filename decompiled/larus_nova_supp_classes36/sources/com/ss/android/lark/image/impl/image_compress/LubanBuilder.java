package com.ss.android.lark.image.impl.image_compress;

import android.graphics.Bitmap;
import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class LubanBuilder {
    File cacheDir;
    Bitmap.CompressFormat compressFormat;
    int gear;
    int maxHeight;
    int maxSize;
    int maxWidth;

    public LubanBuilder(File r2) {
        this.compressFormat = Bitmap.CompressFormat.JPEG;
        this.gear = 3;
        this.cacheDir = r2;
    }
}
