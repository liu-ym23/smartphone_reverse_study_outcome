package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f753b;

    static class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f755b;
        private int c;
        private Bitmap.Config d;

        public a(b r1) {
            this.f754a = r1;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f754a.a(this);
        }

        public void a(int r1, int r2, Bitmap.Config r3) {
            this.f755b = r1;
            this.c = r2;
            this.d = r3;
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L12;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.memorydata.plugin");
            if (this.f755b == r5.f755b) goto L7;
            return false;
        L7:
            if (this.c == r5.c) goto L9;
            return false;
        L9:
            if (this.d != r5.d) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = ((this.f755b * 31) + this.c) * 31;
            Bitmap.Config r2 = this.d;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r0 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            return c.c(this.f755b, this.c, this.d);
        }
    }

    static class b extends d<a> {
        b() {
        }

        public a a() {
            return new a(this);
        }

        a a(int r3, int r4, Bitmap.Config r5) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(c(), a.class, "com.obric.memorydata.plugin");
            r2.a(r3, r4, r5);
            return r2;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        public /* synthetic */ m b() {
            return a();
        }
    }

    c() {
        this.f752a = new b();
        this.f753b = new h();
    }

    static String c(int r2, int r3, Bitmap.Config r4) {
        return "[" + r2 + "x" + r3 + "], " + r4;
    }

    private static String d(Bitmap r2) {
        return c(r2.getWidth(), r2.getHeight(), r2.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public Bitmap a() {
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.f753b.a(), Bitmap.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public Bitmap a(int r2, int r3, Bitmap.Config r4) {
        a r5 = this.f752a.a(r2, r3, r4);
        return (Bitmap) ZeusTransformUtils.preCheckCast(this.f753b.a(r5), Bitmap.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public void a(Bitmap r5) {
        a r0 = this.f752a.a(r5.getWidth(), r5.getHeight(), r5.getConfig());
        this.f753b.a(r0, r5);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String b(int r1, int r2, Bitmap.Config r3) {
        return c(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String b(Bitmap r1) {
        return d(r1);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public int c(Bitmap r1) {
        return com.bumptech.glide.util.k.a(r1);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f753b;
    }
}
