package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface o {

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f869b;
        private final com.bumptech.glide.load.engine.bitmap_recycle.b c;

        a(ByteBuffer r3, List<ImageHeaderParser> r4, com.bumptech.glide.load.engine.bitmap_recycle.b r5) {
            List<ImageHeaderParser> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.load.engine.bitmap_recycle.b r7 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
            this.f868a = r3;
            this.f869b = r6;
            this.c = r7;
        }

        private InputStream d() {
            return com.bumptech.glide.util.a.b(com.bumptech.glide.util.a.c(this.f868a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public Bitmap a(BitmapFactory.Options r2) {
            return BitmapFactory.decodeStream(d(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public ImageHeaderParser.ImageType a() {
            return com.bumptech.glide.load.b.getType(this.f869b, com.bumptech.glide.util.a.c(this.f868a));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public int b() {
            return com.bumptech.glide.load.b.a(this.f869b, com.bumptech.glide.util.a.c(this.f868a), this.c);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public void c() {
        }
    }

    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.data.k f870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.bitmap_recycle.b f871b;
        private final List<ImageHeaderParser> c;

        b(InputStream r4, List<ImageHeaderParser> r5, com.bumptech.glide.load.engine.bitmap_recycle.b r6) {
            List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            com.bumptech.glide.load.engine.bitmap_recycle.b r8 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
            this.f871b = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r8), com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
            this.c = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r7), List.class, "com.obric.memorydata.plugin");
            this.f870a = new com.bumptech.glide.load.data.k(r4, r8);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public Bitmap a(BitmapFactory.Options r2) {
            return BitmapFactory.decodeStream(this.f870a.c(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public ImageHeaderParser.ImageType a() {
            return com.bumptech.glide.load.b.getType(this.c, this.f870a.c(), this.f871b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public int b() {
            return com.bumptech.glide.load.b.a(this.c, this.f870a.c(), this.f871b);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public void c() {
            this.f870a.d();
        }
    }

    public static final class c implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.bitmap_recycle.b f872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<ImageHeaderParser> f873b;
        private final ParcelFileDescriptorRewinder c;

        c(ParcelFileDescriptor r3, List<ImageHeaderParser> r4, com.bumptech.glide.load.engine.bitmap_recycle.b r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f872a = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a((com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin")), com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
            this.f873b = (List) ZeusTransformUtils.preCheckCast(com.bumptech.glide.util.j.a(r6), List.class, "com.obric.memorydata.plugin");
            this.c = new ParcelFileDescriptorRewinder(r3);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public Bitmap a(BitmapFactory.Options r2) {
            return BitmapFactory.decodeFileDescriptor(this.c.d().getFileDescriptor(), null, r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public ImageHeaderParser.ImageType a() {
            return com.bumptech.glide.load.b.getType(this.f873b, this.c, this.f872a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public int b() {
            return com.bumptech.glide.load.b.a(this.f873b, this.c, this.f872a);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.o
        public void c() {
        }
    }

    Bitmap a(BitmapFactory.Options r1);

    ImageHeaderParser.ImageType a();

    int b();

    void c();
}
