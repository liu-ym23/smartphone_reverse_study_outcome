package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FactoryPools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c<Object> f992a = null;

    private static final class FactoryPool<T> implements Pools.Pool<T> {
        private final a<T> factory;
        private final Pools.Pool<T> pool;
        private final c<T> resetter;

        FactoryPool(Pools.Pool<T> r3, a<T> r4, c<T> r5) {
            Pools.Pool<T> r6 = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r3, Pools.Pool.class, "com.obric.memorydata.plugin");
            a<T> r7 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
            c<T> r8 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
            this.pool = r6;
            this.factory = r7;
            this.resetter = r8;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T r0 = this.pool.acquire();
            if (r0 != null) goto L8;
            r0 = this.factory.b();
            if (Log.isLoggable("FactoryPools", 2) == false) goto L8;
            Log.v("FactoryPools", "Created new " + r0.getClass());
        L8:
            if (ZeusTransformUtils.instanceOf(r0, b.class) == false) goto L10;
            ((b) ZeusTransformUtils.preCheckCast(r0, b.class, "com.obric.memorydata.plugin")).a_().a(false);
        L10:
            return r0;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(T r3) {
            if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin")).a_().a(true);
        L5:
            this.resetter.a(r3);
            return this.pool.release(r3);
        }
    }

    public interface a<T> {
        T b();
    }

    public interface b {
        com.bumptech.glide.util.pool.b a_();
    }

    public interface c<T> {
        void a(T r1);
    }

    static {
        f992a = new AnonymousClass1();
    }

    public static <T> Pools.Pool<List<T>> a() {
        return a(20);
    }

    public static <T> Pools.Pool<List<T>> a(int r2) {
        return a(new Pools.SynchronizedPool(r2), new AnonymousClass2(), new AnonymousClass3());
    }

    public static <T extends b> Pools.Pool<T> a(int r2, a<T> r3) {
        a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
        return a(new Pools.SynchronizedPool(r2), r4);
    }

    private static <T extends b> Pools.Pool<T> a(Pools.Pool<T> r2, a<T> r3) {
        return a((Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r2, Pools.Pool.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), b());
    }

    private static <T> Pools.Pool<T> a(Pools.Pool<T> r2, a<T> r3, c<T> r4) {
        return new FactoryPool((Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r2, Pools.Pool.class, "com.obric.memorydata.plugin"), (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin"), (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.memorydata.plugin"));
    }

    private static <T> c<T> b() {
        return (c<T>) f992a;
    }
}
