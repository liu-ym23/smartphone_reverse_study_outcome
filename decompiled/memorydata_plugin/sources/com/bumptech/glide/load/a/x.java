package com.bumptech.glide.load.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class x<Model> implements o<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final x<?> f647a = null;

    public static class a<Model> implements p<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a<?> f648a = null;

        static {
            f648a = new a();
        }

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) f648a;
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Model, Model> a(s r1) {
            return x.a();
        }
    }

    private static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Model f649a;

        b(Model r1) {
            this.f649a = r1;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Model> a() {
            return (Class<Model>) this.f649a.getClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r2, com.bumptech.glide.load.data.d.a<? super Model> r3) {
            ((com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin")).a(this.f649a);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void c() {
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    static {
        f647a = new x();
    }

    @Deprecated
    public x() {
    }

    public static <T> x<T> a() {
        return (x<T>) f647a;
    }

    @Override // com.bumptech.glide.load.a.o
    public o.a<Model> a(Model r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new o.a(new com.bumptech.glide.e.d(r1), new b(r1));
    }

    @Override // com.bumptech.glide.load.a.o
    public boolean a(Model r1) {
        return true;
    }
}
