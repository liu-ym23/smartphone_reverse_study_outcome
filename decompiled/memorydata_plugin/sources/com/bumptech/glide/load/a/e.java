package com.bumptech.glide.load.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class e<Model, Data> implements o<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<Data> f592a;

    public interface a<Data> {
        Class<Data> a();

        Data a(String r1);

        void a(Data r1);
    }

    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f593a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a<Data> f594b;
        private Data c;

        b(String r3, a<Data> r4) {
            a<Data> r5 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.memorydata.plugin");
            this.f593a = r3;
            this.f594b = r5;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f594b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r2, com.bumptech.glide.load.data.d.a<? super Data> r3) {
            com.bumptech.glide.load.data.d.a r4 = (com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin");
            Data r5 = this.f594b.a(this.f593a);     // Catch: IllegalArgumentException -> L5
            this.c = r5;     // Catch: IllegalArgumentException -> L5
            r4.a(r5);     // Catch: IllegalArgumentException -> L5
            return;
        L5:
            e = move-exception;
            r4.a(e);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            this.f594b.a(this.c);     // Catch: IOException -> L4
            return;
        }

        @Override // com.bumptech.glide.load.data.d
        public void c() {
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public static final class c<Model> implements p<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<InputStream> f595a;

        public c() {
            this.f595a = new AnonymousClass1(this);
        }

        @Override // com.bumptech.glide.load.a.p
        public o<Model, InputStream> a(s r1) {
            return new e(this.f595a);
        }
    }

    public e(a<Data> r3) {
        this.f592a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.a.o
    public o.a<Data> a(Model r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new o.a(new com.bumptech.glide.e.d(r1), new b(r1.toString(), this.f592a));
    }

    @Override // com.bumptech.glide.load.a.o
    public boolean a(Model r1) {
        return r1.toString().startsWith("data:image");
    }
}
