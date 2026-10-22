package com.bytedance.android.live.broadcastgame.opengame.message;

import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o0 implements com.bytedance.android.live.broadcastgame.a0 {
    public final LinkedList<Long> a;

    public static final class a {
    }

    static {
    }

    public o0() {
        this.a = new LinkedList();
    }

    @Override // com.bytedance.android.live.broadcastgame.a0
    public final boolean a(com.bytedance.android.live.broadcastgame.v r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        if ((r5 instanceof k) == true) goto L5;
        com.bytedance.android.live.broadcastgame.v r0 = null;
    L7:
        if (((k) r0) == null) goto L26;
        long r1 = ((k) r5).d;
        if (r1 == (-1)) goto L26;
        if (r1 == 1) goto L26;
        if (this.a.contains(Long.valueOf(r1)) == false) goto L16;
        return true;
    L16:
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L18:
        if (this.a.size() != 1024) goto L20;
        this.a.removeFirst();     // Catch: Throwable -> L23
    L20:
        this.a.add(Long.valueOf(r1));     // Catch: Throwable -> L23
        monitor-exit(this);
    L26:
        return false;
    L5:
        r0 = r5;
        goto L7
    }
}
