package com.ss.android.lark.chat.utils;

import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.chat.entity.image.ImageSet;
import com.ss.android.lark.image.entity.Image;
import com.ss.android.lark.image.impl.cache.ImageCacheFinder;
import com.ss.android.lark.image.utils.ChatImageSettings;
import com.ss.android.lark.log.Log;
import java.io.File;
import java.util.ArrayList;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class MessengerImageLoadController {
    static {
    }

    public static int b(Image r2, ImageSet r3) {
        String r4 = r2.getKey();
        Image r0 = r3.getOrigin();
        String r1 = null;
        if (r0 == null) goto L5;
        String r5 = r0.getKey();
    L7:
        if (Intrinsics.areEqual(r4, r5) == false) goto L9;
        return 2;
    L9:
        Image r6 = r3.getMiddle();
        if (r6 == null) goto L12;
        String r7 = r6.getKey();
    L14:
        if (Intrinsics.areEqual(r4, r7) == false) goto L16;
        return 1;
    L16:
        Image r8 = r3.getThumbnail();
        if (r8 == null) goto L20;
        r1 = r8.getKey();
    L20:
        if (Intrinsics.areEqual(r4, r1) == false) goto L22;
        return 0;
    L22:
        return -1;
    L12:
        r7 = null;
        goto L14
    L5:
        r5 = null;
        goto L7
    }

    @JvmStatic
    public static final Image c(String r8, ImageSet r9) {
        Intrinsics.checkNotNullParameter(r8, "scene");
        Image r0 = g.b(r9);
        if (ChatImageSettings.getMessageImageCache().getEnable() == 1) goto L5;
        Log.i("MessengerImageLoadController", "image cache switch is closed");
        return r0;
    L5:
        Image r1 = null;
        if (r0 == null) goto L43;
        if (r9 == null) goto L43;
        Log.i("MessengerImageLoadController", "getTargetShowImageInner start");
        Image r2 = r9.getOrigin();
        if (r2 == null) goto L12;
        String r3 = r2.getKey();
    L13:
        Image r4 = r9.getMiddle();
        if (r4 == null) goto L16;
        String r5 = r4.getKey();
    L17:
        Image r6 = r9.getThumbnail();
        if (r6 == null) goto L20;
        String r7 = r6.getKey();
    L21:
        ArrayList r10 = new ArrayList();
        if (g.c() == false) goto L24;
        r10.add(new com.ss.android.lark.image.entity.e(r5));
        r10.add(new com.ss.android.lark.image.entity.g(r7));
    L25:
        r10.add(new com.ss.android.lark.image.entity.f(r3));
        com.ss.android.lark.image.entity.c r11 = a(r8, r10, r3);
        if (r11 == null) goto L41;
        String r12 = r11.a;
        if (Intrinsics.areEqual(r12, r3) == false) goto L31;
        r1 = r9.getOrigin();
    L36:
        if (r1 == null) goto L41;
        if (b(r1, r9) < b(r0, r9)) goto L40;
        r0 = r1;
        goto L41
    L40:
        r0.setThumbnailCache(r11.b);
        goto L41
    L31:
        if (Intrinsics.areEqual(r12, r5) == false) goto L34;
        r1 = r9.getMiddle();
        goto L36
    L34:
        if (Intrinsics.areEqual(r12, r7) == false) goto L36;
        r1 = r9.getThumbnail();
    L41:
        Log.i("MessengerImageLoadController", "getTargetShowImageInner end, target key:" + r0.getKey() + ", thumbnailCache:" + r0.getThumbnailCache());
        return r0;
    L24:
        r10.add(new com.ss.android.lark.image.entity.g(r7));
        r10.add(new com.ss.android.lark.image.entity.e(r5));
        goto L25
    L20:
        r7 = null;
        goto L21
    L16:
        r5 = null;
        goto L17
    L12:
        r3 = null;
    L43:
        return null;
    }

    @JvmStatic
    public static final com.ss.android.lark.image.entity.c a(final String r10, ArrayList<com.ss.android.lark.image.entity.b> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, "scene");
        Intrinsics.checkNotNullParameter(r11, "keyOrder");
        Log.i("MessengerImageLoadController", "start findImageCache");
        com.ss.android.lark.image.entity.c r13 = ImageCacheFinder.findImageCache(r11, new MessengerImageLoadController$findImageCache$imageCache$1(r10));
        if (r13 == null) goto L5;
        String r2 = r13.a;
    L6:
        if (r13 == null) goto L8;
        File r3 = r13.b;
    L9:
        boolean r4 = true;
        if (r3 != null) goto L12;
    L14:
        boolean r6 = false;
    L15:
        if (r6 == false) goto L28;
        boolean r14 = Intrinsics.areEqual(r2, r12);
        if (Intrinsics.areEqual(MessageImageMonitor.Scene.LOOK_LARGE_IMAGE.getValue(), r10) == true) goto L22;
        if (r14 == false) goto L22;
        if (r3.length() <= ((ChatImageSettings.getMessageImageCache().getOriginMax() * ChameleonContainerUtils.MAX_URL_LENGTH) * ChameleonContainerUtils.MAX_URL_LENGTH)) goto L22;
    L24:
        if (r4 == false) goto L26;
        Log.i("MessengerImageLoadController", "has super large origin cache, no use, key:" + r2 + ", path:" + r3.getPath());
        goto L28
    L26:
        Log.i("MessengerImageLoadController", "has cache, key:" + r2 + ", path:" + r3.getPath());
        return r13;
    L22:
        r4 = false;
    L28:
        Log.i("MessengerImageLoadController", "findImageCache, has no cache");
        return null;
    L12:
        if (r3.exists() != true) goto L14;
        r6 = true;
        goto L15
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
