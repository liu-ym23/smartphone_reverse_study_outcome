package y50;

import com.bytedance.android.live.core.cache.LruCache;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m {
    public static volatile m b;
    public final LruCache<Object, String> a;

    public static m a() {
        if (b != null) goto L15;
        monitor-enter(m.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new m();     // Catch: Throwable -> L11
    L9:
        monitor-exit(m.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    public m() {
        this.a = new LruCache(50);
    }
}
