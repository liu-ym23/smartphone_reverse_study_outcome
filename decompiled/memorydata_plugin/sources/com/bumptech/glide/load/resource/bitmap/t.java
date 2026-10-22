package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class t implements com.bumptech.glide.load.f<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f880a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f881b;

    static class a implements j.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RecyclableBufferedInputStream f882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.util.c f883b;

        a(RecyclableBufferedInputStream r1, com.bumptech.glide.util.c r2) {
            this.f882a = r1;
            this.f883b = r2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.j.a
        public void a() {
            this.f882a.a();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.j.a
        public void a(com.bumptech.glide.load.engine.bitmap_recycle.e r3, Bitmap r4) {
            com.bumptech.glide.load.engine.bitmap_recycle.e r5 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
            IOException r2 = this.f883b.a();
            if (r2 == null) goto L7;
            if (r4 == null) goto L8;
            r5.a(r4);
            throw r2;
        L8:
            throw r2;
        }
    }

    public t(j r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        com.bumptech.glide.load.engine.bitmap_recycle.b r5 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.f880a = r3;
        this.f881b = r5;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.s<Bitmap> a2(InputStream r10, int r11, int r12, com.bumptech.glide.load.e r13) {
        if (ZeusTransformUtils.instanceOf(r10, RecyclableBufferedInputStream.class) == false) goto L5;
        RecyclableBufferedInputStream r14 = (RecyclableBufferedInputStream) ZeusTransformUtils.preCheckCast(r10, RecyclableBufferedInputStream.class, "com.obric.memorydata.plugin");
        boolean r0 = false;
    L6:
        com.bumptech.glide.util.c r1 = com.bumptech.glide.util.c.a(r14);
        com.bumptech.glide.load.engine.s<Bitmap> r9 = this.f880a.a(new com.bumptech.glide.util.h(r1), r11, r12, r13, new a(r14, r1));     // Catch: Throwable -> L12
        r1.b();
        if (r0 == false) goto L11;
        r14.b();
    L11:
        return r9;
    L12:
        th = move-exception;
        r1.b();
        if (r0 == false) goto L16;
        r14.b();
    L16:
        throw th;
    L5:
        r0 = true;
        r14 = new RecyclableBufferedInputStream(r10, this.f881b);
        goto L6
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ com.bumptech.glide.load.engine.s<Bitmap> a(InputStream r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(InputStream r1, com.bumptech.glide.load.e r2) {
        return this.f880a.a(r1);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(InputStream r3, com.bumptech.glide.load.e r4) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), r4);
    }
}
