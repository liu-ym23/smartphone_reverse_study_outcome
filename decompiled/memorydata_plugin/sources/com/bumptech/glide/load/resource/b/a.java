package com.bumptech.glide.load.resource.b;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.bitmap_recycle.b f827b;

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.b.a$a, reason: collision with other inner class name */
    private static final class C0068a implements s<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedImageDrawable f828a;

        C0068a(AnimatedImageDrawable r1) {
            this.f828a = r1;
        }

        public AnimatedImageDrawable a() {
            return this.f828a;
        }

        @Override // com.bumptech.glide.load.engine.s
        public Class<Drawable> c() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.s
        public /* synthetic */ Drawable d() {
            return a();
        }

        @Override // com.bumptech.glide.load.engine.s
        public int e() {
            return ((this.f828a.getIntrinsicWidth() * this.f828a.getIntrinsicHeight()) * k.a(Bitmap.Config.ARGB_8888)) * 2;
        }

        @Override // com.bumptech.glide.load.engine.s
        public void f() {
            this.f828a.stop();
            this.f828a.clearAnimationCallbacks();
        }
    }

    private static final class b implements com.bumptech.glide.load.f<ByteBuffer, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f829a;

        b(a r1) {
            this.f829a = r1;
        }

        @Override // com.bumptech.glide.load.f
        public /* synthetic */ s<Drawable> a(ByteBuffer r3, int r4, int r5, com.bumptech.glide.load.e r6) {
            return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public s<Drawable> a2(ByteBuffer r1, int r2, int r3, com.bumptech.glide.load.e r4) {
            ImageDecoder.Source r5 = ImageDecoder.createSource(r1);
            return this.f829a.a(r5, r2, r3, r4);
        }

        @Override // com.bumptech.glide.load.f
        public /* synthetic */ boolean a(ByteBuffer r3, com.bumptech.glide.load.e r4) {
            return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(ByteBuffer r1, com.bumptech.glide.load.e r2) {
            return this.f829a.a(r1);
        }
    }

    private static final class c implements com.bumptech.glide.load.f<InputStream, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a f830a;

        c(a r1) {
            this.f830a = r1;
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public s<Drawable> a2(InputStream r1, int r2, int r3, com.bumptech.glide.load.e r4) {
            ImageDecoder.Source r5 = ImageDecoder.createSource(com.bumptech.glide.util.a.a(r1));
            return this.f830a.a(r5, r2, r3, r4);
        }

        @Override // com.bumptech.glide.load.f
        public /* synthetic */ s<Drawable> a(InputStream r3, int r4, int r5, com.bumptech.glide.load.e r6) {
            return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public boolean a2(InputStream r1, com.bumptech.glide.load.e r2) {
            return this.f830a.a(r1);
        }

        @Override // com.bumptech.glide.load.f
        public /* synthetic */ boolean a(InputStream r3, com.bumptech.glide.load.e r4) {
            return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), r4);
        }
    }

    private a(List<ImageHeaderParser> r3, com.bumptech.glide.load.engine.bitmap_recycle.b r4) {
        List<ImageHeaderParser> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r6 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.f826a = r5;
        this.f827b = r6;
    }

    public static com.bumptech.glide.load.f<InputStream, Drawable> a(List<ImageHeaderParser> r2, com.bumptech.glide.load.engine.bitmap_recycle.b r3) {
        return new c(new a((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin")));
    }

    private boolean a(ImageHeaderParser.ImageType r2) {
        if (r2 != ImageHeaderParser.ImageType.ANIMATED_WEBP) goto L5;
    L10:
        return true;
    L5:
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L9:
        return false;
    L7:
        if (r2 != ImageHeaderParser.ImageType.ANIMATED_AVIF) goto L9;
        goto L9
    }

    public static com.bumptech.glide.load.f<ByteBuffer, Drawable> b(List<ImageHeaderParser> r2, com.bumptech.glide.load.engine.bitmap_recycle.b r3) {
        return new b(new a((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin"), (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin")));
    }

    s<Drawable> a(ImageDecoder.Source r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        Drawable r0 = ImageDecoder.decodeDrawable(r1, new com.bumptech.glide.load.resource.a(r2, r3, r4));
        if (ZeusTransformUtils.instanceOf(r0, AnimatedImageDrawable.class) == false) goto L7;
        return new C0068a((AnimatedImageDrawable) ZeusTransformUtils.preCheckCast(r0, AnimatedImageDrawable.class, "com.obric.memorydata.plugin"));
    L7:
        throw new IOException("Received unexpected drawable type for animated image, failing: " + r0);
    }

    boolean a(InputStream r3) {
        return a(com.bumptech.glide.load.b.getType(this.f826a, r3, this.f827b));
    }

    boolean a(ByteBuffer r2) {
        return a(com.bumptech.glide.load.b.getType(this.f826a, r2));
    }
}
