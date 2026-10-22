package com.bumptech.glide.load.a;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class r<Model, Data> implements o<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<o<Model, Data>> f628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f629b;

    static class a<Data> implements com.bumptech.glide.load.data.d<Data>, com.bumptech.glide.load.data.d.a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<com.bumptech.glide.load.data.d<Data>> f630a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Pools.Pool<List<Throwable>> f631b;
        private int c;
        private Priority d;
        private com.bumptech.glide.load.data.d.a<? super Data> e;
        private List<Throwable> f;
        private boolean g;

        a(List<com.bumptech.glide.load.data.d<Data>> r3, Pools.Pool<List<Throwable>> r4) {
            List<com.bumptech.glide.load.data.d<Data>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            this.f631b = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r4, Pools.Pool.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.util.j.a(r5);
            this.f630a = r5;
            this.c = 0;
        }

        private void e() {
            if (this.g == false) goto L6;
            return;
        L6:
            if (this.c >= (this.f630a.size() - 1)) goto L8;
            this.c++;
            a(this.d, this.e);
            return;
        L8:
            com.bumptech.glide.util.j.a(this.f);
            this.e.a(new GlideException("Fetch failed", new ArrayList(this.f)));
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return ((com.bumptech.glide.load.data.d) ZeusTransformUtils.preCheckCast(this.f630a.get(0), com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin")).a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r3, com.bumptech.glide.load.data.d.a<? super Data> r4) {
            com.bumptech.glide.load.data.d.a<? super Data> r5 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
            this.d = r3;
            this.e = r5;
            this.f = (List) ZeusTransformUtils.preCheckCast(this.f631b.acquire(), List.class, "com.obric.memorydata.plugin");
            ((com.bumptech.glide.load.data.d) ZeusTransformUtils.preCheckCast(this.f630a.get(this.c), com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin")).a(r3, this);
            if (this.g == false) goto L6;
            c();
            return;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(Exception r4) {
            ((List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(this.f), List.class, "com.obric.memorydata.plugin")).add(r4);
            e();
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void a(Data r1) {
            if (r1 == null) goto L4;
            this.e.a(r1);
            return;
        L4:
            e();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            List<Throwable> r0 = this.f;
            if (r0 == null) goto L5;
            this.f631b.release(r0);
        L5:
            this.f = null;
            Iterator<com.bumptech.glide.load.data.d<Data>> r3 = this.f630a.iterator();
        L7:
            if (r3.hasNext() == false) goto L9;
            ((com.bumptech.glide.load.data.d) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin")).b();
            goto L7
        }

        @Override // com.bumptech.glide.load.data.d
        public void c() {
            this.g = true;
            Iterator<com.bumptech.glide.load.data.d<Data>> r3 = this.f630a.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            ((com.bumptech.glide.load.data.d) ZeusTransformUtils.preCheckCast(r3.next(), com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin")).c();
            goto L4
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return ((com.bumptech.glide.load.data.d) ZeusTransformUtils.preCheckCast(this.f630a.get(0), com.bumptech.glide.load.data.d.class, "com.obric.memorydata.plugin")).d();
        }
    }

    r(List<o<Model, Data>> r3, Pools.Pool<List<Throwable>> r4) {
        List<o<Model, Data>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Pools.Pool<List<Throwable>> r6 = (Pools.Pool) ZeusTransformUtils.wrapperContextForParams(r4, Pools.Pool.class, "com.obric.memorydata.plugin");
        this.f628a = r5;
        this.f629b = r6;
    }

    @Override // com.bumptech.glide.load.a.o
    public o.a<Data> a(Model r9, int r10, int r11, com.bumptech.glide.load.e r12) {
        int r0 = this.f628a.size();
        ArrayList r1 = new ArrayList(r0);
        int r3 = 0;
        com.bumptech.glide.load.c r4 = null;
    L3:
        if (r3 >= r0) goto L11;
        o r5 = (o) ZeusTransformUtils.preCheckCast(this.f628a.get(r3), o.class, "com.obric.memorydata.plugin");
        if (r5.a(r9) == false) goto L9;
        o.a<Data> r6 = r5.a(r9, r10, r11, r12);
        if (r6 == null) goto L9;
        r4 = r6.f622a;
        r1.add(r6.c);
    L9:
        r3 = r3 + 1;
        goto L3
    L11:
        if (r1.isEmpty() == true) goto L19;
        if (r4 != null) goto L14;
        return null;
    L14:
        return new o.a(r4, new a(r1, this.f629b));
    L19:
        return null;
    }

    @Override // com.bumptech.glide.load.a.o
    public boolean a(Model r4) {
        Iterator<o<Model, Data>> r3 = this.f628a.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (((o) ZeusTransformUtils.preCheckCast(r3.next(), o.class, "com.obric.memorydata.plugin")).a(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f628a.toArray()) + '}';
    }
}
