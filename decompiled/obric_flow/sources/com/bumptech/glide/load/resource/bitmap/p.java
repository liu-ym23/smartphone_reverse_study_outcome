package com.bumptech.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class p implements z.b {
    @Override // z.b
    public final int a(InputStream r5, com.bumptech.glide.load.engine.bitmap_recycle.f r10) {
        int r11 = new ExifInterface(r5).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (r11 != 0) goto L6;
        return -1;
    L6:
        return r11;
    }

    @Override // z.b
    public final ImageHeaderParser$ImageType b(ByteBuffer r5) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    @Override // z.b
    public final ImageHeaderParser$ImageType c(InputStream r5) {
        return ImageHeaderParser$ImageType.UNKNOWN;
    }
}
