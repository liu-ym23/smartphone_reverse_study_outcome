package com.bumptech.glide.load.resource.bitmap;

import androidx.exifinterface.media.ExifInterface;
import com.bumptech.glide.load.ImageHeaderParser;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class m implements ImageHeaderParser {
    public m() {
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream r2, com.bumptech.glide.load.engine.bitmap_recycle.b r3) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r1 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        int r4 = new ExifInterface(r2).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
        if (r4 != 0) goto L6;
        return -1;
    L6:
        return r4;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(ByteBuffer r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r5 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        return a(com.bumptech.glide.util.a.b(r3), r5);
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(InputStream r1) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType getType(ByteBuffer r1) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
