package com.larus.video.impl.sdk;

import com.larus.platform.api.p0;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a implements p0 {
    public final VideoModel a;

    public final float a() {
        List r0 = this.a.getVideoInfoList();
        if (r0 == null) goto L7;
        VideoInfo r1 = (VideoInfo) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L7;
        return r1.mVHeight;
    L7:
        return 0.0f;
    }

    public final float b() {
        List r0 = this.a.getVideoInfoList();
        if (r0 == null) goto L7;
        VideoInfo r1 = (VideoInfo) CollectionsKt.firstOrNull(r0);
        if (r1 == null) goto L7;
        return r1.mVWidth;
    L7:
        return 0.0f;
    }

    public final VideoModel getImpl() {
        VideoModel r0 = this.a;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0;
    }

    public a(VideoModel r2) {
        Intrinsics.checkNotNullParameter(r2, "videoModelImpl");
        this.a = r2;
    }
}
