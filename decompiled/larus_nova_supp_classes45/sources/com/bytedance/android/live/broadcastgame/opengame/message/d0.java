package com.bytedance.android.live.broadcastgame.opengame.message;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d0 {
    public final long a;
    public final AtomicLong b;

    public d0() {
        long r0 = System.currentTimeMillis();
        this.a = r0;
        this.b = new AtomicLong(r0 + 1);
    }
}
