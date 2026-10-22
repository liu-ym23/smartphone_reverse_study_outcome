package com.larus.video.impl.widget;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.platform.uimodel.MediaEntity;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.model.IVideoModel;
import com.ss.ttvideoengine.model.VideoModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class u implements l4 {
    public final /* synthetic */ VideoView a;
    public final /* synthetic */ TTVideoEngine b;

    public u(VideoView r1, TTVideoEngine r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r3, com.larus.video.impl.sdk.a r4) {
        MediaEntity r0 = this.a.p;
        IVideoModel r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getVideo_model();
    L7:
        if (Intrinsics.areEqual(r3, r2) == false) goto L28;
        if (r4 == null) goto L11;
        VideoModel r5 = r4.a;
        if (r5 == null) goto L11;
    L12:
        if (r5 == null) goto L29;
        IVideoController r6 = this.a.s;
        if (r6 == null) goto L16;
        r6.j(r4, true);
    L16:
        IVideoController r7 = this.a.s;
        if (r7 == null) goto L19;
        r7.E(null);
    L19:
        VideoView r8 = this.a;
        r8.o = r4;
        TTVideoEngine r9 = r8.t;
        if (r9 == null) goto L26;
        IVideoModel r10 = r4.a;
        if (r10 == null) goto L25;
        r1 = r10;
    L25:
        r9.setVideoModel(r1);
    L26:
        this.a.h(this.b);
        return;
    L29:
        return;
    L11:
        r5 = null;
        goto L12
    L28:
        return;
    L5:
        r2 = null;
        goto L7
    }
}
