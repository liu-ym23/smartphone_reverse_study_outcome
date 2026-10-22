package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class v implements com.bumptech.glide.load.f<Bitmap, Bitmap> {

    private static final class a implements com.bumptech.glide.load.engine.s<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Bitmap f886a;

        a(Bitmap r1) {
            this.f886a = r1;
        }

        public Bitmap a() {
            return this.f886a;
        }

        @Override // com.bumptech.glide.load.engine.s
        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.s
        public /* synthetic */ Bitmap d() {
            return a();
        }

        @Override // com.bumptech.glide.load.engine.s
        public int e() {
            return com.bumptech.glide.util.k.a(this.f886a);
        }

        @Override // com.bumptech.glide.load.engine.s
        public void f() {
        }
    }

    public v() {
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public com.bumptech.glide.load.engine.s<Bitmap> a2(Bitmap r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        return new a(r1);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ com.bumptech.glide.load.engine.s<Bitmap> a(Bitmap r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Bitmap r1, com.bumptech.glide.load.e r2) {
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(Bitmap r3, com.bumptech.glide.load.e r4) {
        return a2((Bitmap) ZeusTransformUtils.preCheckCast(r3, Bitmap.class, "com.obric.memorydata.plugin"), r4);
    }
}
