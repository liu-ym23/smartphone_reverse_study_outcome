package com.bytedance.android.livesdk.chatroom.utils;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.frame.DropFramesFrameScheduler;
import com.facebook.fresco.animation.frame.FrameScheduler;
import com.facebook.fresco.animation.frame.FrameSchedulerFactory;
import com.facebook.imageformat.ImageFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class n2 implements FrameSchedulerFactory {
    public static final n2 a = null;

    static {
        a = new n2();
    }

    public n2() {
    }

    public final FrameScheduler build(AnimationBackend r1, Object r2, ImageFormat r3, int r4) {
        return new DropFramesFrameScheduler(r1);
    }
}
