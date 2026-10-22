package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(py.k r9) {
        StringBuilder r0 = new StringBuilder("[smoothEnterRoom] try download ");
        String r1 = null;
        if (r9 == null) goto L5;
        String r2 = r9.getUri();
    L6:
        r0.append(r2);
        ALogger.i("ImagePrefetchHelper", r0.toString());
        ImageRequest[] r3 = a1.b(r9, -1);
        if (r3 == null) goto L15;
        int r5 = r3.length;
        int r6 = 0;
    L10:
        if (r6 >= r5) goto L15;
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r3[r6], null)) == true) goto L13;
        r6 = r6 + 1;
        goto L10
    L13:
        boolean r4 = true;
    L16:
        if (r4 == false) goto L22;
        StringBuilder r7 = new StringBuilder("[smoothEnterRoom] ");
        if (r9 == null) goto L20;
        r1 = r9.getUri();
    L20:
        r7.append(r1);
        r7.append(" has downloaded");
        ALogger.i("ImagePrefetchHelper", r7.toString());
        return;
    L22:
        ImageRequest[] r10 = a1.b(r9, -1);
        if (r10 == null) goto L31;
        ImageRequest r11 = r10[0];
        if (r11 == null) goto L32;
        ImagePipelineFactory.getInstance().getImagePipeline().prefetchToDiskCache(r11, null);
        return;
    L32:
        return;
    L31:
        return;
    L15:
        r4 = false;
        goto L16
    L5:
        r2 = null;
        goto L6
    }
}
