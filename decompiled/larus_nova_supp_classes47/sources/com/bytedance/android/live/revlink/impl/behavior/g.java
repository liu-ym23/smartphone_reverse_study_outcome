package com.bytedance.android.live.revlink.impl.behavior;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends AnimationBackendDelegate<AnimationBackend> {
    public final int a;

    public final int getLoopCount() {
        return this.a;
    }

    public g(AnimationBackend r1) {
        super(r1);
        this.a = 999;
    }

    public final boolean hasCacheFrame(int r5) {
        if (((Boolean) o.c.getValue(null, o.a[1])).booleanValue() == false) goto L6;
        return true;
    L6:
        return super.hasCacheFrame(r5);
    }
}
