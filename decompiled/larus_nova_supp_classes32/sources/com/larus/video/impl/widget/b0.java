package com.larus.video.impl.widget;

import com.larus.platform.api.IVideoController;
import com.larus.platform.api.l4;
import com.larus.platform.uimodel.MediaEntity;
import com.larus.video.impl.TikTokVideoViewHolder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b0 implements l4 {
    public final /* synthetic */ MediaEntity a;
    public final /* synthetic */ VideoViewHolder b;

    public b0(MediaEntity r1, TikTokVideoViewHolder r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(String r4, com.larus.video.impl.sdk.a r5) {
        MediaEntity r0 = this.a;
        if (r0 == null) goto L5;
        String r1 = r0.getVideo_model();
    L7:
        if (Intrinsics.areEqual(r1, r4) == false) goto L10;
        IVideoController.a.a(this.b.b, r5, 0, 30);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
