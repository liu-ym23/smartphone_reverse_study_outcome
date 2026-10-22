package com.bytedance.android.live.core.tetris.widgets.cache;

import com.bytedance.android.live.core.log.ALogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c {
    public static volatile c f;
    public static final C0168c g = null;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final b d;
    public final d e;

    public static final class a {
        public final b a;

        public a() {
            this.a = new b(0);
        }
    }

    public static final class b {
        public final int a;
        public final boolean b;
        public final CachePoolModel c;
        public final boolean d;

        public b() {
            this(0);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L14;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            int r0 = this.a * 31;
            boolean r1 = this.b;
            ?? r2 = 1;
            ?? r3 = r1;
            if (r1 == false) goto L5;
            r3 = 1;
        L5:
            int r4 = (r0 + r3) * 31;
            CachePoolModel r5 = this.c;
            if (r5 == null) goto L8;
            int r6 = r5.hashCode();
        L9:
            int r7 = (r4 + r6) * 31;
            boolean r8 = this.d;
            if (r8 == true) goto L14;
            r2 = r8;
        L14:
            return r7 + r2;
        L8:
            r6 = 0;
            goto L9
        }

        public final String toString() {
            return "CacheConfig(reusableCacheMaxSize=" + this.a + ", enableCache=" + this.b + ", cachePoolModel=" + this.c + ", lowEndDeviceMode=" + this.d + ")";
        }

        public b(int r2) {
            CachePoolModel r3 = CachePoolModel.SINGLE_POOL_MODEL;
            Intrinsics.checkNotNullParameter(r3, "cachePoolModel");
            this.a = 4;
            this.b = true;
            this.c = r3;
            this.d = false;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.core.tetris.widgets.cache.c$c, reason: collision with other inner class name */
    public static final class C0168c {
        public final c a() {
            c r0 = c.f;
            if (r0 != null) goto L15;
            monitor-enter(this);
            r0 = c.f;     // Catch: Throwable -> L9
            if (r0 != null) goto L11;
            c r1 = c.f;     // Catch: Throwable -> L9
            a r2 = new a();     // Catch: Throwable -> L9
            f r3 = new f();     // Catch: Throwable -> L9
            c r4 = new c(r2.a, r3);     // Catch: Throwable -> L9
            c.f = r4;     // Catch: Throwable -> L9
            r0 = r4;
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r0;
        }

        public C0168c() {
        }
    }

    static {
        g = new C0168c();
    }

    public final com.bytedance.android.live.core.tetris.widgets.cache.a a() {
        return (com.bytedance.android.live.core.tetris.widgets.cache.a) this.a.getValue();
    }

    public final e b() {
        return (e) this.b.getValue();
    }

    public final void c() {
        int r0 = com.bytedance.android.live.core.tetris.widgets.cache.b.a;
        Intrinsics.checkNotNullParameter("缓存清理回收", "txt");
        ALogger.i("ComponentCacheLog", "缓存清理回收");
        if (a() == null) goto L6;
        a().a();
    L6:
        if (b() == null) goto L9;
        b().a();
    L9:
        if (((g) this.c.getValue()) == null) goto L26;
        g r1 = (g) this.c.getValue();
        Map<Class<?>, LinkedList<com.bytedance.android.live.core.tetris.widgets.a>> r2 = r1.a;
        if (r2 == null) goto L25;
        Collection r3 = ((LinkedHashMap) r2).values();
        if (r3 == null) goto L25;
        Iterator r4 = r3.iterator();
    L16:
        if (r4.hasNext() == false) goto L25;
        LinkedList r5 = (LinkedList) r4.next();
        if (r5 == null) goto L16;
        Iterator r6 = r5.iterator();
    L21:
        if (r6.hasNext() == false) goto L16;
        com.bytedance.android.live.core.tetris.widgets.a r7 = (com.bytedance.android.live.core.tetris.widgets.a) r6.next();
        if (r7 == null) goto L21;
        r7.clearAfterDestroyed();
    L25:
        ((LinkedHashMap) r1.a).clear();
    L26:
        d r8 = this.e;
        if (r8 == null) goto L39;
        r8.onDestory();
        return;
    }

    public final void d(String r3) {
        Intrinsics.checkNotNullParameter(r3, "uniqueID");
        com.bytedance.android.live.core.tetris.widgets.cache.b.a("onRoomDetached", new String[]{r3});
        com.bytedance.android.live.core.tetris.widgets.cache.a r0 = a();
        if (r0 == null) goto L5;
        r0.b("before onRoomDetached ActiveCache");
    L5:
        e r1 = b();
        if (r1 == null) goto L8;
        r1.b("before onRoomDetached ReusableCache");
    L8:
        this.e.c(this, r3);
        com.bytedance.android.live.core.tetris.widgets.cache.a r4 = a();
        if (r4 == null) goto L11;
        r4.b("after onRoomDetached ActiveCache");
    L11:
        e r5 = b();
        if (r5 == null) goto L15;
        r5.b("after onRoomDetached ReusableCache");
        return;
    }

    public c(b r1, f r2) {
        this.d = r1;
        this.e = r2;
        this.a = LazyKt.lazy(ComponentCacheManager$activeCache$2.INSTANCE);
        this.b = LazyKt.lazy(new ComponentCacheManager$LRUWidgetCache$2(this));
        this.c = LazyKt.lazy(new ComponentCacheManager$sizedWidgetCache$2(this));
    }
}
