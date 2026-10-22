package com.bytedance.android.anniex.lite;

import android.util.LruCache;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final a a = null;
    public static final LruCache<String, com.bytedance.android.anniex.base.lifecycle.a> b = null;
    public static final LruCache<String, Map<String, Object>> c = null;

    public a() {
    }

    static {
        a = new a();
        b = new LruCache(2);
        c = new LruCache(2);
    }

    public final synchronized void a(String r10) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r10, "sessionId");     // Catch: Throwable -> L6
        b.remove(r10);     // Catch: Throwable -> L6
        c.remove(r10);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
