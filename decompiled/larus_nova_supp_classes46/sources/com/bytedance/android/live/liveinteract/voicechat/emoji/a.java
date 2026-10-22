package com.bytedance.android.live.liveinteract.voicechat.emoji;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(k r8) {
        Intrinsics.checkNotNullParameter(r8, "imageModel");
        Intrinsics.checkNotNullParameter(r8, "imageModel");
        ImageRequest[] r1 = a1.b(r8, -1);
        if (r1 == null) goto L11;
        int r4 = r1.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L11;
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(r1[r5], null)) == true) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        boolean r2 = true;
    L12:
        if (r2 == false) goto L15;
        ALogger.i("interact_emoji", r8.getUri() + " has downloaded");
        return;
    L15:
        ImageRequest[] r9 = a1.b(r8, -1);
        if (r9 == null) goto L24;
        ImageRequest r10 = r9[0];
        if (r10 == null) goto L25;
        ImagePipelineFactory.getInstance().getImagePipeline().prefetchToDiskCache(r10, null);
        return;
    L25:
        return;
    L24:
        return;
    L11:
        r2 = false;
        goto L12
    }
}
