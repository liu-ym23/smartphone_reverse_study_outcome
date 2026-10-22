package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public class a implements com.bumptech.glide.load.f<ByteBuffer, GifDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0069a f898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f899b = null;
    private final Context c;
    private final List<ImageHeaderParser> d;
    private final b e;
    private final C0069a f;
    private final com.bumptech.glide.load.resource.gif.b g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.gif.a$a, reason: collision with other inner class name */
    static class C0069a {
        C0069a() {
        }

        com.bumptech.glide.b.a a(com.bumptech.glide.b.a.InterfaceC0055a r2, com.bumptech.glide.b.c r3, ByteBuffer r4, int r5) {
            return new com.bumptech.glide.b.e((com.bumptech.glide.b.a.InterfaceC0055a) ZeusTransformUtils.wrapperContextForParams(r2, com.bumptech.glide.b.a.InterfaceC0055a.class, "com.obric.memorydata.plugin"), r3, r4, r5);
        }
    }

    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.b.d> f900a;

        b() {
            this.f900a = k.b(0);
        }

        synchronized com.bumptech.glide.b.d a(ByteBuffer r4) {
            monitor-enter(this);
            com.bumptech.glide.b.d r0 = (com.bumptech.glide.b.d) ZeusTransformUtils.preCheckCast(this.f900a.poll(), com.bumptech.glide.b.d.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r0 != null) goto L6;
            r0 = new com.bumptech.glide.b.d();     // Catch: Throwable -> L9
        L6:
            com.bumptech.glide.b.d r5 = r0.a(r4);     // Catch: Throwable -> L9
            monitor-exit(this);
            return r5;
        L9:
            th = move-exception;
            throw th;
        }

        synchronized void a(com.bumptech.glide.b.d r2) {
            monitor-enter(this);
            r2.a();     // Catch: Throwable -> L6
            this.f900a.offer(r2);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }
    }

    static {
        f898a = new C0069a();
        f899b = new b();
    }

    public a(Context r10, List<ImageHeaderParser> r11, com.bumptech.glide.load.engine.bitmap_recycle.e r12, com.bumptech.glide.load.engine.bitmap_recycle.b r13) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin"), (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin"), (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r12, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin"), (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r13, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin"), f899b, f898a);
    }

    a(Context r3, List<ImageHeaderParser> r4, com.bumptech.glide.load.engine.bitmap_recycle.e r5, com.bumptech.glide.load.engine.bitmap_recycle.b r6, b r7, C0069a r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        List<ImageHeaderParser> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r11 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r12 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r6, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.c = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r9.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.d = r10;
        this.f = r8;
        this.g = new com.bumptech.glide.load.resource.gif.b(r11, r12);
        this.e = r7;
    }

    private static int a(com.bumptech.glide.b.c r4, int r5, int r6) {
        int r0 = Math.min(r4.a() / r6, r4.b() / r5);
        if (r0 != 0) goto L5;
        int r1 = 0;
    L6:
        int r2 = Math.max(1, r1);
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L10;
        if (r2 <= 1) goto L10;
        Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + r2 + ", target dimens: [" + r5 + "x" + r6 + "], actual dimens: [" + r4.b() + "x" + r4.a() + "]");
    L10:
        return r2;
    L5:
        r1 = Integer.highestOneBit(r0);
        goto L6
    }

    private d a(ByteBuffer r17, int r18, int r19, com.bumptech.glide.b.d r20, com.bumptech.glide.load.e r21) {
        long r3 = com.bumptech.glide.util.f.a();
        com.bumptech.glide.b.c r6 = r20.b();     // Catch: Throwable -> L27
        if (r6.c() <= 0) goto L24;
        if (r6.d() != 0) goto L24;
        if (r21.b(h.f910a) != DecodeFormat.PREFER_RGB_565) goto L11;
        Bitmap.Config r7 = Bitmap.Config.RGB_565;     // Catch: Throwable -> L27
    L12:
        com.bumptech.glide.b.a r11 = this.f.a(this.g, r6, r17, a(r6, r18, r19));     // Catch: Throwable -> L27
        r11.a(r7);     // Catch: Throwable -> L27
        r11.b();     // Catch: Throwable -> L27
        Bitmap r15 = r11.i();     // Catch: Throwable -> L27
        if (r15 == null) goto L15;
        d r0 = new d(new GifDrawable(this.c, r11, com.bumptech.glide.load.resource.c.a(), r18, r19, r15));     // Catch: Throwable -> L27
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L22;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(r3));
    L22:
        return r0;
    L15:
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L17;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(r3));
    L17:
        return null;
    L11:
        r7 = Bitmap.Config.ARGB_8888;     // Catch: Throwable -> L27
    L24:
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L26;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(r3));
    L26:
        return null;
    L27:
        th = move-exception;
        if (Log.isLoggable("BufferGifDecoder", 2) == false) goto L31;
        Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.util.f.a(r3));
    L31:
        throw th;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ s<GifDrawable> a(ByteBuffer r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public d a2(ByteBuffer r8, int r9, int r10, com.bumptech.glide.load.e r11) {
        com.bumptech.glide.b.d r0 = this.e.a(r8);
        d r12 = a(r8, r9, r10, r0, r11);     // Catch: Throwable -> L6
        this.e.a(r0);
        return r12;
    L6:
        th = move-exception;
        this.e.a(r0);
        throw th;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(ByteBuffer r3, com.bumptech.glide.load.e r4) {
        return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.memorydata.plugin"), r4);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(ByteBuffer r3, com.bumptech.glide.load.e r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.b(h.f911b), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (com.bumptech.glide.load.b.getType(this.d, r3) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }
}
