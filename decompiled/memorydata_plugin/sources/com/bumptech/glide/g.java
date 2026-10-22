package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a.l;
import com.bumptech.glide.load.a.p;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.a.v;
import com.bumptech.glide.load.a.w;
import com.bumptech.glide.load.a.x;
import com.bumptech.glide.load.a.y;
import com.bumptech.glide.load.a.z;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.data.k;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.load.resource.bitmap.r;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.load.resource.bitmap.t;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class g {
    static com.bumptech.glide.util.e.a<Registry> a(final c r2, List<com.bumptech.glide.c.c> r3, final com.bumptech.glide.c.a r4) {
        final List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        return new AnonymousClass1(r2, r5, r4);
    }

    private static void a(Context r18, Registry r19, com.bumptech.glide.load.engine.bitmap_recycle.e r20, com.bumptech.glide.load.engine.bitmap_recycle.b r21, f r22) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r4 = (com.bumptech.glide.load.engine.bitmap_recycle.e) ZeusTransformUtils.wrapperContextForParams(r20, com.bumptech.glide.load.engine.bitmap_recycle.e.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r5 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r21, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        r19.a(new DefaultImageHeaderParser());
        if (Build.VERSION.SDK_INT < 27) goto L5;
        r19.a(new m());
    L5:
        Resources r3 = ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin");
        List<ImageHeaderParser> r6 = r19.a();
        com.bumptech.glide.load.resource.gif.a r7 = new com.bumptech.glide.load.resource.gif.a(r2, r6, r4, r5);
        com.bumptech.glide.load.f<ParcelFileDescriptor, Bitmap> r8 = VideoDecoder.b(r4);
        com.bumptech.glide.load.resource.bitmap.j r9 = new com.bumptech.glide.load.resource.bitmap.j(r19.a(), r3.getDisplayMetrics(), r4, r5);
        if (Build.VERSION.SDK_INT >= 28) goto L8;
    L10:
        com.bumptech.glide.load.f r12 = new com.bumptech.glide.load.resource.bitmap.g(r9);
        com.bumptech.glide.load.f r10 = new t(r9, r5);
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L14;
        r19.a("Animation", InputStream.class, Drawable.class, com.bumptech.glide.load.resource.b.a.a(r6, r5));
        r19.a("Animation", ByteBuffer.class, Drawable.class, com.bumptech.glide.load.resource.b.a.b(r6, r5));
    L14:
        com.bumptech.glide.load.resource.b.e r11 = new com.bumptech.glide.load.resource.b.e(r2);
        com.bumptech.glide.load.resource.bitmap.c r13 = new com.bumptech.glide.load.resource.bitmap.c(r5);
        com.bumptech.glide.load.resource.d.a r15 = new com.bumptech.glide.load.resource.d.a();
        com.bumptech.glide.load.resource.d.d r16 = new com.bumptech.glide.load.resource.d.d();
        ContentResolver r17 = r2.getContentResolver();
        r19.a(ByteBuffer.class, new com.bumptech.glide.load.a.c()).a(InputStream.class, new v(r5)).a("Bitmap", ByteBuffer.class, Bitmap.class, r12).a("Bitmap", InputStream.class, Bitmap.class, r10);
        if (ParcelFileDescriptorRewinder.c() == false) goto L18;
        r19.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new r(r9));
    L18:
        if (Build.VERSION.SDK_INT < 16) goto L20;
        r19.a("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.a(r4));
    L20:
        r19.a("Bitmap", ParcelFileDescriptor.class, Bitmap.class, r8).a(Bitmap.class, Bitmap.class, x.a.a()).a("Bitmap", Bitmap.class, Bitmap.class, new com.bumptech.glide.load.resource.bitmap.v()).a(Bitmap.class, r13).a("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r12)).a("BitmapDrawable", InputStream.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r10)).a("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r8)).a(BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.b(r4, r13)).a("Animation", InputStream.class, GifDrawable.class, new com.bumptech.glide.load.resource.gif.i(r6, r7, r5)).a("Animation", ByteBuffer.class, GifDrawable.class, r7).a(GifDrawable.class, new com.bumptech.glide.load.resource.gif.c()).a(com.bumptech.glide.b.a.class, com.bumptech.glide.b.a.class, x.a.a()).a("Bitmap", com.bumptech.glide.b.a.class, Bitmap.class, new com.bumptech.glide.load.resource.gif.g(r4)).a(Uri.class, Drawable.class, r11).a(Uri.class, Bitmap.class, new s(r11, r4)).a(new com.bumptech.glide.load.resource.a.a.C0067a()).a(File.class, ByteBuffer.class, new com.bumptech.glide.load.a.d.b()).a(File.class, InputStream.class, new com.bumptech.glide.load.a.g.e()).a(File.class, File.class, new com.bumptech.glide.load.resource.c.a()).a(File.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.a.g.b()).a(File.class, File.class, x.a.a()).a(new k.a(r5));
        if (ParcelFileDescriptorRewinder.c() == false) goto L23;
        r19.a(new ParcelFileDescriptorRewinder.a());
    L23:
        p<Integer, InputStream> r1 = com.bumptech.glide.load.a.f.a(r2);
        p<Integer, AssetFileDescriptor> r14 = com.bumptech.glide.load.a.f.b(r2);
        p<Integer, Drawable> r23 = com.bumptech.glide.load.a.f.c(r2);
        r19.a(Integer.TYPE, InputStream.class, r1).a(Integer.class, InputStream.class, r1).a(Integer.TYPE, AssetFileDescriptor.class, r14).a(Integer.class, AssetFileDescriptor.class, r14).a(Integer.TYPE, Drawable.class, r23).a(Integer.class, Drawable.class, r23).a(Uri.class, InputStream.class, u.a(r2)).a(Uri.class, AssetFileDescriptor.class, u.b(r2));
        com.bumptech.glide.load.a.t.c r24 = new com.bumptech.glide.load.a.t.c(r3);
        com.bumptech.glide.load.a.t.a r25 = new com.bumptech.glide.load.a.t.a(r3);
        com.bumptech.glide.load.a.t.b r26 = new com.bumptech.glide.load.a.t.b(r3);
        r19.a(Integer.class, Uri.class, r24).a(Integer.TYPE, Uri.class, r24).a(Integer.class, AssetFileDescriptor.class, r25).a(Integer.TYPE, AssetFileDescriptor.class, r25).a(Integer.class, InputStream.class, r26).a(Integer.TYPE, InputStream.class, r26);
        r19.a(String.class, InputStream.class, new com.bumptech.glide.load.a.e.c()).a(Uri.class, InputStream.class, new com.bumptech.glide.load.a.e.c()).a(String.class, InputStream.class, new w.c()).a(String.class, ParcelFileDescriptor.class, new w.b()).a(String.class, AssetFileDescriptor.class, new w.a()).a(Uri.class, InputStream.class, new com.bumptech.glide.load.a.a.c(r2.getAssets())).a(Uri.class, AssetFileDescriptor.class, new com.bumptech.glide.load.a.a.b(r2.getAssets())).a(Uri.class, InputStream.class, new com.bumptech.glide.load.a.a.b.a(r2)).a(Uri.class, InputStream.class, new com.bumptech.glide.load.a.a.c.a(r2));
        if (Build.VERSION.SDK_INT < 29) goto L26;
        r19.a(Uri.class, InputStream.class, new com.bumptech.glide.load.a.a.d.c(r2));
        r19.a(Uri.class, ParcelFileDescriptor.class, new com.bumptech.glide.load.a.a.d.b(r2));
    L26:
        r19.a(Uri.class, InputStream.class, new y.d(r17)).a(Uri.class, ParcelFileDescriptor.class, new y.b(r17)).a(Uri.class, AssetFileDescriptor.class, new y.a(r17)).a(Uri.class, InputStream.class, new z.a()).a(URL.class, InputStream.class, new com.bumptech.glide.load.a.a.e.a()).a(Uri.class, File.class, new l.a(r2)).a(com.bumptech.glide.load.a.h.class, InputStream.class, new com.bumptech.glide.load.a.a.a.C0058a()).a(byte[].class, ByteBuffer.class, new com.bumptech.glide.load.a.b.a()).a(byte[].class, InputStream.class, new com.bumptech.glide.load.a.b.d()).a(Uri.class, Uri.class, x.a.a()).a(Drawable.class, Drawable.class, x.a.a()).a(Drawable.class, Drawable.class, new com.bumptech.glide.load.resource.b.f()).a(Bitmap.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.d.b(r3)).a(Bitmap.class, byte[].class, r15).a(Drawable.class, byte[].class, new com.bumptech.glide.load.resource.d.c(r4, r15, r16)).a(GifDrawable.class, byte[].class, r16);
        if (Build.VERSION.SDK_INT < 23) goto L30;
        com.bumptech.glide.load.f<ByteBuffer, Bitmap> r27 = VideoDecoder.c(r4);
        r19.a(ByteBuffer.class, Bitmap.class, r27);
        r19.a(ByteBuffer.class, BitmapDrawable.class, new com.bumptech.glide.load.resource.bitmap.a(r3, r27));
        return;
    L30:
        return;
    L8:
        if (r22.a(d.a.class) == false) goto L10;
        r10 = new com.bumptech.glide.load.resource.bitmap.p();
        r12 = new com.bumptech.glide.load.resource.bitmap.h();
        goto L12
    }

    private static void a(Context r3, c r4, Registry r5, List<com.bumptech.glide.c.c> r6, com.bumptech.glide.c.a r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Iterator r9 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        com.bumptech.glide.c.c r0 = (com.bumptech.glide.c.c) ZeusTransformUtils.preCheckCast(r9.next(), com.bumptech.glide.c.c.class, "com.obric.memorydata.plugin");
        r0.a(r8, r4, r5);     // Catch: AbstractMethodError -> L8
    L8:
        e = move-exception;
        throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + r0.getClass().getName(), e);
    L11:
        if (r7 == null) goto L18;
        r7.a(r8, r4, r5);
        return;
    }

    static Registry b(c r6, List<com.bumptech.glide.c.c> r7, com.bumptech.glide.c.a r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.e r0 = r6.a();
        com.bumptech.glide.load.engine.bitmap_recycle.b r2 = r6.b();
        Context r3 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((e) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.d(), "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")).getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        f r1 = ((e) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.d(), "com.obric.memorydata.plugin"), e.class, "com.obric.memorydata.plugin")).g();
        Registry r4 = new Registry();
        a(r3, r4, r0, r2, r1);
        a(r3, r6, r4, r9, r8);
        return r4;
    }
}
