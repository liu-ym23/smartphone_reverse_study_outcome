package com.bytedance.android.live.lynx;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final ConcurrentHashMap<Class, a> a = null;

    public interface a<T> {
        void provide();
    }

    static {
        ConcurrentHashMap<Class, a> r0 = new ConcurrentHashMap();
        a = r0;
        r0.put(com.bytedance.android.live.lynx.a.class, new b.a());
    }

    public static <T> T a(Class<T> r1) {
        a r2 = a.get(r1);
        if (r2 == null) goto L6;
        r2.provide();
        return (T) b.a.C0121a.a;
    L6:
        return null;
    }
}
