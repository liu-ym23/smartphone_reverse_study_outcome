package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class h extends r22.a<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {
    public final Deque<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> c;

    public static final class a {
    }

    static {
    }

    public com.bytedance.android.livesdk.interactivity.api.publicscreen.d m() {
        return (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) ((LinkedList) this.c).pollFirst();
    }

    @Override // r22.a
    public /* bridge */ /* synthetic */ com.bytedance.android.livesdk.interactivity.api.publicscreen.d j() {
        return m();
    }

    @Override // r22.a
    public final Queue<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> h() {
        return this.c;
    }

    public h(r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "danmakuReceiver");
        super(r2);
        this.c = new LinkedList();
    }

    @Override // r22.a
    public /* bridge */ /* synthetic */ void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r1) {
        l(r1);
    }

    public void l(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r3) {
        Intrinsics.checkNotNullParameter(r3, "danmaku");
        if (((LinkedList) this.c).size() < 200) goto L5;
        ((LinkedList) this.c).removeFirst();
    L5:
        ((LinkedList) this.c).add(r3);
        k();
    }
}
