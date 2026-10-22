package com.bytedance.live.artist.utils;

import java.util.HashMap;
import vk6.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final HashMap<String, Long> a;
    public final kf6.a b;

    public static final class a {
    }

    static {
    }

    public b() {
        this.b = g.a;
        this.a = new HashMap();
    }

    public final void a(String r6) {
        long r0 = System.nanoTime();
        Long r2 = this.a.get(r6);
        if (r2 == null) goto L6;
        long r1 = (r0 - r2.longValue()) / 1000000;
        this.b.debug("TimeCost", "method: " + r6 + " use time " + r1 + " ms");
        return;
    }
}
