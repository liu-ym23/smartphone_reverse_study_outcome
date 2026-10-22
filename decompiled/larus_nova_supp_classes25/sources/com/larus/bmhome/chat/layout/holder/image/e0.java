package com.larus.bmhome.chat.layout.holder.image;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.platform.api.Image;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e0 {
    public static final ImageEntity a(Image r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        return new ImageEntity(r7.a, r7.b, (int) r7.c, (int) r7.d, r7.e);
    }
}
