package com.bumptech.glide.load.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class b<Data> implements o<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0060b<Data> f586a;

    public static class a implements p<byte[], ByteBuffer> {
        public a() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<byte[], ByteBuffer> a(s r2) {
            return new b(new AnonymousClass1(this));
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0060b<Data> {
        Class<Data> a();

        Data b(byte[] r1);
    }

    private static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0060b<Data> f589b;

        c(byte[] r3, InterfaceC0060b<Data> r4) {
            InterfaceC0060b<Data> r5 = (InterfaceC0060b) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0060b.class, "com.obric.memorydata.plugin");
            this.f588a = r3;
            this.f589b = r5;
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f589b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority r2, com.bumptech.glide.load.data.d.a<? super Data> r3) {
            ((com.bumptech.glide.load.data.d.a) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.data.d.a.class, "com.obric.memorydata.plugin")).a(this.f589b.b(this.f588a));
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

    public static class d implements p<byte[], InputStream> {
        public d() {
        }

        @Override // com.bumptech.glide.load.a.p
        public o<byte[], InputStream> a(s r2) {
            return new b(new AnonymousClass1(this));
        }
    }

    public b(InterfaceC0060b<Data> r3) {
        this.f586a = (InterfaceC0060b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0060b.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ o.a a(byte[] r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public o.a<Data> a2(byte[] r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new o.a(new com.bumptech.glide.e.d(r1), new c(r1, this.f586a));
    }

    @Override // com.bumptech.glide.load.a.o
    public /* synthetic */ boolean a(byte[] r3) {
        return a2((byte[]) ZeusTransformUtils.preCheckCast(r3, byte[].class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(byte[] r1) {
        return true;
    }
}
