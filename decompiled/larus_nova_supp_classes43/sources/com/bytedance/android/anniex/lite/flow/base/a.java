package com.bytedance.android.anniex.lite.flow.base;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import w26.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final LruCache<String, b> b = null;

    public a() {
    }

    static {
        a = new a();
        Map r0 = x26.a.a;
        g r1 = (g) x26.a.a(g.class);
        if (r1 == null) goto L9;
        w26.e r10 = (w26.e) r1.n0(w26.e.class);
        if (r10 == null) goto L9;
        Integer r11 = r10.d();
        if (r11 == null) goto L9;
        int r12 = r11.intValue();
    L10:
        b = new LruCache(r12);
        return;
    L9:
        r12 = 5;
        goto L10
    }

    public final synchronized b a(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "sessionId");     // Catch: Throwable -> L6
        b r11 = b.get(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r11;
    L6:
        th = move-exception;
        throw th;
    }
}
