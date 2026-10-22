package com.bumptech.glide.load.data;

import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class k implements e<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclableBufferedInputStream f691a;

    public static final class a implements e.a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.bitmap_recycle.b f692a;

        public a(com.bumptech.glide.load.engine.bitmap_recycle.b r3) {
            this.f692a = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public e<InputStream> a2(InputStream r2) {
            return new k(r2, this.f692a);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public /* synthetic */ e<InputStream> a(InputStream r3) {
            return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        RecyclableBufferedInputStream r0 = new RecyclableBufferedInputStream(r3, (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin"));
        this.f691a = r0;
        r0.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public /* synthetic */ InputStream a() {
        return c();
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f691a.b();
    }

    public InputStream c() {
        this.f691a.reset();
        return this.f691a;
    }

    public void d() {
        this.f691a.a();
    }
}
