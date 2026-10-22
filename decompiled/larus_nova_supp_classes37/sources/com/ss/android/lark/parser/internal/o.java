package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.Image;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class o {
    public static ImageSet a(com.bytedance.lark.pb.basic.v1.ImageSet r3, String r4) {
        if (r3 != null) goto L5;
        Log.w("ModelParserImage", "pbImageSet is null, messageId is " + r4);
    L11:
        ImageSet r5 = new ImageSet();
        b(r3, r5, null);
        return r5;
    L5:
        Image r1 = r3.thumbnail;
        if (r1 != null) goto L9;
        Log.w("ModelParserImage", "thumbnail is null, messageId is " + r4);
        goto L11
    L9:
        if (CollectionUtils.isEmpty(r1.urls) == false) goto L11;
        Log.w("ModelParserImage", "thumbnail urls is null, messageId is " + r4);
        goto L11
    }

    public static com.ss.android.lark.image.entity.Image c(com.ss.android.lark.image.entity.Image r1, ResourceCleanScene r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == null) goto L7;
        boolean r0 = true;
    L8:
        r1.setResourceIsCleaned(r0);
        r1.setResourceCleanScene(r2);
        return r1;
    L7:
        r0 = false;
        goto L8
    }

    public static void b(com.bytedance.lark.pb.basic.v1.ImageSet r2, ImageSet r3, ResourceCleanScene r4) {
        okb.c r0 = (okb.c) ImSdkProxy.e.getValue();
        if (r2 == null) goto L9;
        Image r1 = r2.intact;
        if (r1 == null) goto L9;
        if (r1.exif_orientation.intValue() < 0) goto L9;
        r3.setIntact(c(r0.d(r2.intact), r4));
    L9:
        if (r2 == null) goto L11;
        Image r5 = r2.origin;
    L12:
        r3.setOrigin(c(r0.d(r5), r4));
        if (r2 == null) goto L15;
        String r6 = r2.key;
    L16:
        r3.setKey(r6);
        r3.setThumbnail(c(r0.a(r2), r4));
        r3.setMiddle(c(r0.c(r2), r4));
        r3.setInlinePreview(r0.b(r2));
        return;
    L15:
        r6 = "";
        goto L16
    L11:
        r5 = null;
        goto L12
    }
}
