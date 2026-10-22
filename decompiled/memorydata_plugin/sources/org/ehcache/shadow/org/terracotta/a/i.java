package org.ehcache.shadow.org.terracotta.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes7.dex */
public class i<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f18118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<K> f18119b;
    private final ConcurrentHashMap<Reference<K>, V> c;

    public interface a {
        void d();
    }

    static class b<T> extends WeakReference<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18120a;

        public b(T r1, ReferenceQueue<? super T> r2) {
            super(r1, r2);
            this.f18120a = System.identityHashCode(r1);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == false) goto L14;
            Object r4 = get();
            if (r4 == null) goto L13;
            if (r4 != ((b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin")).get()) goto L13;
            return true;
        L13:
            return false;
        L14:
            return false;
        }

        public int hashCode() {
            return this.f18120a;
        }
    }

    static {
        f18118a = org.slf4j.d.a(i.class);
    }

    public i() {
        this.f18119b = new ReferenceQueue();
        this.c = new ConcurrentHashMap();
    }

    private void a() {
    L2:
        Reference<? extends K> r0 = this.f18119b.poll();
        if (r0 == null) goto L10;
        V r1 = this.c.remove(r0);
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L2;
        ((a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin")).d();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        f18118a.warn("Cleaning failed with : {}", th);
        goto L2
    }

    public V a(K r3) {
        a();
        return this.c.get(a(r3, null));
    }

    public V a(K r3, V r4) {
        a();
        return this.c.putIfAbsent(a(r3, this.f18119b), r4);
    }

    public Reference<K> a(K r1, ReferenceQueue<? super K> r2) {
        return new b(r1, r2);
    }
}
