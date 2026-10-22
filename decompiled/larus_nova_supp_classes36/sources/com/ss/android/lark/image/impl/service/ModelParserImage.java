package com.ss.android.lark.image.impl.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.ImageSet;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.image.entity.Image;
import java.util.ArrayList;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ModelParserImage {
    private static boolean isThumbnailWepEnable;

    static {
        isThumbnailWepEnable = FeatureGatingModule.getFeatureGatingService().isEnable("lark.chat.thumbnail.webp.enable");
    }

    public static Image getImage(com.bytedance.lark.pb.basic.v1.Image r3) {
        Image r0 = new Image();
        if (r3 != null) goto L5;
        return r0;
    L5:
        r0.setKey(r3.key);
        if (r3.exif_orientation.intValue() < 5) goto L8;
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        Integer r2 = r3.height;
    L12:
        r0.setWidth(r2.intValue());
        if (r1 == false) goto L15;
        Integer r4 = r3.width;
    L16:
        r0.setHeight(r4.intValue());
        r0.setUrls(new ArrayList(r3.urls));
        r0.setType(Image.Type.forNumber(r3.type.getValue()));
        r0.setCrypto(r3.crypto);
        r0.setFsUnit(r3.fs_unit);
        return r0;
    L15:
        r4 = r3.height;
        goto L16
    L11:
        r2 = r3.width;
        goto L12
    L8:
        r1 = false;
        goto L9
    }

    public static ByteString getInlinePreviewFromPb(ImageSet r2) {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("messenger.picture.placeholder.push") == true) goto L5;
        return null;
    L5:
        if (r2 == null) goto L13;
        ByteString r0 = r2.inline_preview;
        if (r0 == null) goto L13;
        if (r0.size() == 0) goto L13;
        return r2.inline_preview;
    L13:
        return null;
    }

    public static Image getMiddleFromPb(ImageSet r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (isThumbnailWepEnable == false) goto L14;
        com.bytedance.lark.pb.basic.v1.Image r0 = r1.middle_webp;
        if (r0 == null) goto L14;
        if (TextUtils.isEmpty(r0.key) == true) goto L14;
        return getImage(r1.middle_webp);
    L14:
        return getImage(r1.middle);
    }

    public static Image getThumbnailFromPb(ImageSet r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        if (isThumbnailWepEnable == false) goto L14;
        com.bytedance.lark.pb.basic.v1.Image r0 = r1.thumbnail_webp;
        if (r0 == null) goto L14;
        if (TextUtils.isEmpty(r0.key) == true) goto L14;
        return getImage(r1.thumbnail_webp);
    L14:
        return getImage(r1.thumbnail);
    }
}
