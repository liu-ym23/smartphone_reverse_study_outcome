package com.larus.bmhome.chat.layout.holder.helper;

import com.larus.bmhome.chat.layout.holder.image.bean.ImageEntity;
import com.larus.bmhome.chat.layout.holder.video.bean.CoverImageEntity;
import com.larus.im.bean.message.ImageObj;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p {
    public static final ImageEntity a(ImageObj r9) {
        if (r9 != null) goto L6;
        return null;
    L6:
        return new ImageEntity(r9.url, r9.getHeicUrl(), r9.width, r9.height, null, 16, null);
    }

    public static final CoverImageEntity b(ImageObj r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        return new CoverImageEntity(r4.url, r4.getHeicUrl(), r4.width, r4.height);
    }
}
