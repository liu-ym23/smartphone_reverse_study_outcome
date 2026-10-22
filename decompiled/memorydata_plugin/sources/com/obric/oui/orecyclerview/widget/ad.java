package com.obric.oui.orecyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final SimpleArrayMap<RecyclerView.v, a> f14129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final LongSparseArray<RecyclerView.v> f14130b;

    static class a {
        static Pools.Pool<a> d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f14131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        RecyclerView.e.c f14132b;
        RecyclerView.e.c c;

        static {
            d = new Pools.SimplePool(20);
        }

        private a() {
        }

        static a a() {
            a r0 = (a) ZeusTransformUtils.preCheckCast(d.acquire(), a.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new a();
        }

        static void a(a r1) {
            r1.f14131a = 0;
            r1.f14132b = null;
            r1.c = null;
            d.release(r1);
        }

        static void b() {
        L3:
            if (d.acquire() != null) goto L3;
        }
    }

    interface b {
        void a(RecyclerView.v r1);

        void a(RecyclerView.v r1, RecyclerView.e.c r2, RecyclerView.e.c r3);

        void b(RecyclerView.v r1, RecyclerView.e.c r2, RecyclerView.e.c r3);

        void c(RecyclerView.v r1, RecyclerView.e.c r2, RecyclerView.e.c r3);
    }

    ad() {
        this.f14129a = new SimpleArrayMap();
        this.f14130b = new LongSparseArray();
    }

    private RecyclerView.e.c a(RecyclerView.v r5, int r6) {
        int r7 = this.f14129a.indexOfKey(r5);
        if (r7 >= 0) goto L5;
        return null;
    L5:
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.valueAt(r7), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L8;
    L21:
        return null;
    L8:
        if ((r1.f14131a & r6) == 0) goto L21;
        r1.f14131a &= ~r6;
        if (r6 != 4) goto L13;
        RecyclerView.e.c r8 = r1.f14132b;
    L16:
        if ((r1.f14131a & 12) != 0) goto L18;
        this.f14129a.removeAt(r7);
        a.a(r1);
    L18:
        return r8;
    L13:
        if (r6 != 8) goto L20;
        r8 = r1.c;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    }

    RecyclerView.v a(long r1) {
        return (RecyclerView.v) ZeusTransformUtils.preCheckCast(this.f14130b.get(r1), RecyclerView.v.class, "com.obric.memorydata.plugin");
    }

    void a() {
        this.f14129a.clear();
        this.f14130b.clear();
    }

    void a(long r1, RecyclerView.v r3) {
        this.f14130b.put(r1, r3);
    }

    void a(RecyclerView.v r4, RecyclerView.e.c r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f14129a.put(r4, r0);
    L5:
        r0.f14132b = r5;
        r0.f14131a |= 4;
    }

    void a(b r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
        int r0 = this.f14129a.size() - 1;
    L3:
        if (r0 < 0) goto L28;
        RecyclerView.v r2 = (RecyclerView.v) ZeusTransformUtils.preCheckCast(this.f14129a.keyAt(r0), RecyclerView.v.class, "com.obric.memorydata.plugin");
        a r3 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.removeAt(r0), a.class, "com.obric.memorydata.plugin");
        if ((r3.f14131a & 3) != 3) goto L8;
    L6:
        r8.a(r2);
    L27:
        a.a(r3);
        r0 = r0 - 1;
        goto L3
    L8:
        if ((r3.f14131a & 1) == 0) goto L15;
        if (r3.f14132b == null) goto L6;
        RecyclerView.e.c r4 = r3.f14132b;
        RecyclerView.e.c r5 = r3.c;
    L13:
        r8.a(r2, r4, r5);
        goto L27
    L15:
        if ((r3.f14131a & 14) != 14) goto L18;
    L16:
        r8.b(r2, r3.f14132b, r3.c);
        goto L27
    L18:
        if ((r3.f14131a & 12) != 12) goto L21;
        r8.c(r2, r3.f14132b, r3.c);
        goto L27
    L21:
        if ((r3.f14131a & 4) == 0) goto L24;
        r4 = r3.f14132b;
        r5 = null;
        goto L13
    L24:
        if ((r3.f14131a & 8) != 0) goto L16;
        int r6 = r3.f14131a;
        goto L27
    }

    boolean a(RecyclerView.v r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.get(r2), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r1.f14131a & 1) == 0) goto L7;
        return true;
    }

    RecyclerView.e.c b(RecyclerView.v r2) {
        return a(r2, 4);
    }

    void b() {
        a.b();
    }

    void b(RecyclerView.v r4, RecyclerView.e.c r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f14129a.put(r4, r0);
    L5:
        r0.f14131a |= 2;
        r0.f14132b = r5;
    }

    RecyclerView.e.c c(RecyclerView.v r2) {
        return a(r2, 8);
    }

    void c(RecyclerView.v r4, RecyclerView.e.c r5) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f14129a.put(r4, r0);
    L5:
        r0.c = r5;
        r0.f14131a |= 8;
    }

    boolean d(RecyclerView.v r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.get(r2), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r1.f14131a & 4) == 0) goto L7;
        return true;
    }

    void e(RecyclerView.v r4) {
        a r0 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.get(r4), a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = a.a();
        this.f14129a.put(r4, r0);
    L5:
        r0.f14131a |= 1;
    }

    void f(RecyclerView.v r2) {
        a r1 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.get(r2), a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return;
    L5:
        r1.f14131a &= -2;
    }

    void g(RecyclerView.v r3) {
        int r0 = this.f14130b.size() - 1;
    L3:
        if (r0 < 0) goto L8;
        if (r3 == this.f14130b.valueAt(r0)) goto L6;
        r0 = r0 - 1;
        goto L3
    L6:
        this.f14130b.removeAt(r0);
    L8:
        a r2 = (a) ZeusTransformUtils.preCheckCast(this.f14129a.remove(r3), a.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L14;
        a.a(r2);
        return;
    }

    public void h(RecyclerView.v r1) {
        f(r1);
    }
}
