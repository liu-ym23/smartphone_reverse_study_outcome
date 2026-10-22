package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g extends r22.a<com.bytedance.android.livesdk.interactivity.zdanmaku.d> {
    public final Deque<com.bytedance.android.livesdk.interactivity.zdanmaku.d> c;

    @Override // r22.a
    public final com.bytedance.android.livesdk.interactivity.zdanmaku.d j() {
        return (com.bytedance.android.livesdk.interactivity.zdanmaku.d) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public final Queue<com.bytedance.android.livesdk.interactivity.zdanmaku.d> h() {
        return this.c;
    }

    public g(LandscapeDanmakuPresenterV2.j r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.c = new LinkedList();
    }
}
