package com.google.common.cache;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a<K, V> implements com.google.common.cache.b<K, V> {

    /* JADX INFO: renamed from: com.google.common.cache.a$a, reason: collision with other inner class name */
    public static final class C0193a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f4354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final f f4355b;
        private final f c;
        private final f d;
        private final f e;
        private final f f;

        public C0193a() {
            this.f4354a = LongAddables.a();
            this.f4355b = LongAddables.a();
            this.c = LongAddables.a();
            this.d = LongAddables.a();
            this.e = LongAddables.a();
            this.f = LongAddables.a();
        }

        private static long c(long r2) {
            if (r2 >= 0) goto L7;
            return Long.MAX_VALUE;
        L7:
            return r2;
        }

        @Override // com.google.common.cache.a.b
        public void a() {
            this.f.increment();
        }

        @Override // com.google.common.cache.a.b
        public void a(int r3) {
            this.f4354a.add(r3);
        }

        @Override // com.google.common.cache.a.b
        public void a(long r2) {
            this.c.increment();
            this.e.add(r2);
        }

        public void a(b r4) {
            c r5 = ((b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.memorydata.plugin")).b();
            this.f4354a.add(r5.a());
            this.f4355b.add(r5.b());
            this.c.add(r5.c());
            this.d.add(r5.d());
            this.e.add(r5.e());
            this.f.add(r5.f());
        }

        @Override // com.google.common.cache.a.b
        public c b() {
            return new c(c(this.f4354a.sum()), c(this.f4355b.sum()), c(this.c.sum()), c(this.d.sum()), c(this.e.sum()), c(this.f.sum()));
        }

        @Override // com.google.common.cache.a.b
        public void b(int r3) {
            this.f4355b.add(r3);
        }

        @Override // com.google.common.cache.a.b
        public void b(long r2) {
            this.d.increment();
            this.e.add(r2);
        }
    }

    public interface b {
        void a();

        void a(int r1);

        void a(long r1);

        c b();

        void b(int r1);

        void b(long r1);
    }
}
