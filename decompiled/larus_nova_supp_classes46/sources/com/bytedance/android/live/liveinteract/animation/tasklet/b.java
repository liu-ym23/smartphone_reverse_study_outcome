package com.bytedance.android.live.liveinteract.animation.tasklet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class b implements d {
    public final com.bytedance.android.live.liveinteract.videotalk.emoji.model.p a;
    public final com.bytedance.android.live.liveinteract.videotalk.emoji.model.f b;

    public void a() {
    }

    public b(com.bytedance.android.live.liveinteract.videotalk.emoji.model.p r2, com.bytedance.android.live.liveinteract.videotalk.emoji.model.f r3) {
        Intrinsics.checkNotNullParameter(r2, "mData");
        Intrinsics.checkNotNullParameter(r3, "mAnimationData");
        this.a = r2;
        this.b = r3;
    }
}
