package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.facebook.fresco.animation.backend.AnimationBackend;
import com.facebook.fresco.animation.backend.AnimationBackendDelegate;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k extends AnimationBackendDelegate<AnimationBackend> {
    public final int a;

    public final int getLoopCount() {
        return this.a;
    }

    public k(AnimationBackend r1) {
        super(r1);
        this.a = 1;
    }
}
