package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class h<K extends m, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f758b;

    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a<K, V> f760b;
        a<K, V> c;
        private List<V> d;

        a() {
            this(null);
        }

        a(K r1) {
            this.c = this;
            this.f760b = this;
            this.f759a = r1;
        }

        public V a() {
            int r0 = b();
            if (r0 > 0) goto L7;
            return null;
        L7:
            return this.d.remove(r0 - 1);
        }

        public void a(V r2) {
            if (this.d != null) goto L5;
            this.d = new ArrayList();
        L5:
            this.d.add(r2);
        }

        public int b() {
            List<V> r0 = this.d;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }
    }

    h() {
        this.f757a = new a();
        this.f758b = new HashMap();
    }

    private void a(a<K, V> r2) {
        d(r2);
        r2.c = this.f757a;
        r2.f760b = this.f757a.f760b;
        c(r2);
    }

    private void b(a<K, V> r2) {
        d(r2);
        r2.c = this.f757a.c;
        r2.f760b = this.f757a;
        c(r2);
    }

    private static <K, V> void c(a<K, V> r1) {
        r1.f760b.c = r1;
        r1.c.f760b = r1;
    }

    private static <K, V> void d(a<K, V> r2) {
        a<K, V> r0 = r2.c;
        r0.f760b = r2.f760b;
        a<K, V> r1 = r2.f760b;
        r1.c = r2.c;
    }

    public V a() {
        a r0 = this.f757a;
    L3:
        r0 = r0.c;
        if (r0.equals(this.f757a) == true) goto L9;
        V r1 = (V) r0.a();
        if (r1 != null) goto L7;
        d(r0);
        this.f758b.remove(r0.f759a);
        ((m) ZeusTransformUtils.preCheckCast(r0.f759a, m.class, "com.obric.memorydata.plugin")).a();
        goto L3
    L7:
        return r1;
    L9:
        return null;
    }

    public V a(K r4) {
        m r5 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        a<K, V> r0 = (a) ZeusTransformUtils.preCheckCast(this.f758b.get(r5), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new a(r5);
        this.f758b.put((K) r5, r0);
    L6:
        a(r0);
        return r0.a();
    L5:
        r5.a();
        goto L6
    }

    public void a(K r4, V r5) {
        m r6 = (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.memorydata.plugin");
        a<K, V> r0 = (a) ZeusTransformUtils.preCheckCast(this.f758b.get(r6), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new a(r6);
        b(r0);
        this.f758b.put((K) r6, r0);
    L6:
        r0.a(r5);
        return;
    L5:
        r6.a();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("GroupedLinkedMap( ");
        a r1 = this.f757a.f760b;
        boolean r2 = false;
    L4:
        if (r1.equals(this.f757a) == true) goto L6;
        r2 = true;
        r0.append('{').append(r1.f759a).append(':').append(r1.b()).append("}, ");
        r1 = r1.f760b;
        goto L4
    L6:
        if (r2 == false) goto L9;
        r0.delete(r0.length() - 2, r0.length());
    L9:
        return r0.append(" )").toString();
    }
}
