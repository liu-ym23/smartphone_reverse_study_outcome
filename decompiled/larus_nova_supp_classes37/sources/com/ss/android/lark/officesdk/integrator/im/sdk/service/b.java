package com.ss.android.lark.officesdk.integrator.im.sdk.service;

import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.impl.service.ModelParserImage;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements okb.c {
    public b() {
    }

    public final Image a(ImageSet r2) {
        return ModelParserImage.getThumbnailFromPb(r2);
    }

    public final ByteString b(ImageSet r2) {
        return ModelParserImage.getInlinePreviewFromPb(r2);
    }

    public final Image c(ImageSet r2) {
        return ModelParserImage.getMiddleFromPb(r2);
    }

    public final Image d(com.bytedance.lark.pb.basic.v1.Image r2) {
        return ModelParserImage.getImage(r2);
    }
}
