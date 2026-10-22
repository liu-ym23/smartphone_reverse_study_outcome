package com.bytedance.android.live;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.animation.frame.FrameSchedulerFactory;
import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final /* synthetic */ class h implements FrameSchedulerFactory {
    public /* synthetic */ h() {
    }

    public final FrameScheduler build(AnimationBackend r1, Object r2, ImageFormat r3, int r4) {
        return new g(r1, r4);
    }
}
