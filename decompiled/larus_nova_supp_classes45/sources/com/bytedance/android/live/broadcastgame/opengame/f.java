package com.bytedance.android.live.broadcastgame.opengame;

import android.content.Context;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f {
    public volatile int a;
    public volatile vlc.d b;
    public final Context c;
    public final long d;

    public final synchronized void b() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.a <= 0) goto L10;
        this.a--;     // Catch: Throwable -> L12
        if (this.a != 0) goto L10;
        int r0 = q.a;     // Catch: Throwable -> L12
        q.g("停止接收游戏IM", "");     // Catch: Throwable -> L12
        vlc.d r1 = this.b;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        r1.r(true);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public final Context getContext() {
        return this.c;
    }

    public final synchronized vlc.d a(boolean r4) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.b != null) goto L6;
        int r0 = r10.a.a;     // Catch: Throwable -> L9
        vlc.d r5 = r10.a.a(this.c, this.d, r4);     // Catch: Throwable -> L9
        int r1 = q.a;     // Catch: Throwable -> L9
        q.g("游戏IM通道创建", "");     // Catch: Throwable -> L9
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L9
        this.b = r5;     // Catch: Throwable -> L9
    L6:
        vlc.d r6 = this.b;     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r6;
    }

    public f(Context r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r2;
        this.d = r3;
    }
}
