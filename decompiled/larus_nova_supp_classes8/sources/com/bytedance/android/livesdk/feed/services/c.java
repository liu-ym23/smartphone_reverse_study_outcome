package com.bytedance.android.livesdk.feed.services;

import com.bytedance.android.livesdk.feed.f;
import com.bytedance.android.livesdk.feed.network.GsonProvider;
import com.google.gson.Gson;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c {
    public static volatile c b;
    public final Map<Class<?>, a<?>> a;

    public static final class a<T> {
        public final b<T> a;
        public Object b;

        public a() {
            throw null;
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    public interface b<T> {

        public static final class a<R> {
            public R a;
            public boolean b;

            public a() {
            }
        }

        a<T> a(a<T> r1);
    }

    public c() {
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        this.a = r0;
        r0.put(f.class, new a(new com.bytedance.android.livesdk.feed.services.a()));
        r0.put(hw1.a.class, new a(new e()));
        r0.put(Gson.class, new a(new GsonProvider()));
    }

    public static <T> T b(Class<T> r2) {
        if (b != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new c();     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return (T) b.a(r2);
    }

    public final <T> T a(final Class<T> r4) {
        a r0 = (a) ((ConcurrentHashMap) this.a).get(r4);
        if (r0 != null) goto L5;
        a r1 = new a(new com.bytedance.android.livesdk.feed.services.b(r4));
        ((ConcurrentHashMap) this.a).put(r4, r1);
        r0 = r1;
    L5:
        b.a<T> r5 = r0.a.a(new b.a());
        if (r5.b == false) goto L21;
        if (r0.b != null) goto L24;
        monitor-enter(c.class);
    L16:
        th = move-exception;
        throw th;
    L12:
        if (r0.b != null) goto L14;
        r0.b = r5.a;     // Catch: Throwable -> L16
    L14:
        monitor-exit(c.class);     // Catch: Throwable -> L16
    L24:
        return (T) r0.b;
    L21:
        return r5.a;
    }
}
