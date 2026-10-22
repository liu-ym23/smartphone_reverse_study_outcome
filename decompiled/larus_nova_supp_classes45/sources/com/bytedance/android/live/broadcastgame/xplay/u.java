package com.bytedance.android.live.broadcastgame.xplay;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class u {
    public static final /* synthetic */ int c = 0;
    public final e0 a;
    public final com.bytedance.android.live.broadcastgame.api.xplay.p b;

    public static final class a {
    }

    static {
    }

    public u(com.bytedance.android.live.broadcastgame.api.xplay.p r2) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        this.b = r2;
        this.a = new e0();
    }

    public final void a(boolean r3) {
        Object r0 = null;
        if (r3 == false) goto L10;
        t1 r4 = this.a.b;
        if (r4 == null) goto L7;
        r0 = com.bytedance.android.scope.m.e.d(r4, IXplayCoreService.class);
    L7:
        IXplayCoreService r1 = (IXplayCoreService) r0;
        if (r1 == null) goto L17;
        r1.pauseGame();
        return;
    L17:
        return;
    L10:
        t1 r5 = this.a.b;
        if (r5 == null) goto L13;
        r0 = com.bytedance.android.scope.m.e.d(r5, IXplayCoreService.class);
    L13:
        IXplayCoreService r2 = (IXplayCoreService) r0;
        if (r2 == null) goto L19;
        r2.resumeGame();
        return;
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, "stopReason");
        t1 r0 = this.a.b;
        if (r0 == null) goto L5;
        Object r1 = com.bytedance.android.scope.m.e.d(r0, k20.b.class);
    L6:
        k20.b r2 = (k20.b) r1;
        if (r2 == null) goto L10;
        r2.a(r4);
        return;
    L10:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
