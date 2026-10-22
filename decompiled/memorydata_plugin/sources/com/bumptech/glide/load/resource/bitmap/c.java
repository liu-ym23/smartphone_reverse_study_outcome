package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class c implements com.bumptech.glide.load.g<Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Integer> f854a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.d<Bitmap.CompressFormat> f855b = null;
    private final com.bumptech.glide.load.engine.bitmap_recycle.b c;

    static {
        f854a = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
        f855b = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");
    }

    @Deprecated
    public c() {
        this.c = null;
    }

    public c(com.bumptech.glide.load.engine.bitmap_recycle.b r3) {
        this.c = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
    }

    private Bitmap.CompressFormat a(Bitmap r2, com.bumptech.glide.load.e r3) {
        Bitmap.CompressFormat r1 = (Bitmap.CompressFormat) ZeusTransformUtils.preCheckCast(r3.b(f855b), Bitmap.CompressFormat.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (r2.hasAlpha() == false) goto L10;
        return Bitmap.CompressFormat.PNG;
    L10:
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.g
    public EncodeStrategy a(com.bumptech.glide.load.e r1) {
        return EncodeStrategy.TRANSFORMED;
    }

    public boolean a(com.bumptech.glide.load.engine.s<Bitmap> r9, File r10, com.bumptech.glide.load.e r11) {
        Bitmap r12 = (Bitmap) ZeusTransformUtils.preCheckCast(((com.bumptech.glide.load.engine.s) ZeusTransformUtils.wrapperContextForParams(r9, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin")).d(), Bitmap.class, "com.obric.memorydata.plugin");
        Bitmap.CompressFormat r1 = a(r12, r11);
        com.bumptech.glide.util.pool.a.a("encode: [%dx%d] %s", Integer.valueOf(r12.getWidth()), Integer.valueOf(r12.getHeight()), r1);
        long r3 = com.bumptech.glide.util.f.a();     // Catch: Throwable -> L37
        int r2 = ((Integer) ZeusTransformUtils.preCheckCast(r11.b(f854a), Integer.class, "com.obric.memorydata.plugin")).intValue();     // Catch: Throwable -> L37
        boolean r5 = false;
        OutputStream r6 = null;
        FileOutputStream r7 = new FileOutputStream(r10);     // Catch: Throwable -> L19 IOException -> L21
    L17:
        e = e;
        r6 = r7;
    L24:
        if (Log.isLoggable("BitmapEncoder", 3) == false) goto L26;
        Log.d("BitmapEncoder", "Failed to encode Bitmap", e);     // Catch: Throwable -> L19
    L26:
        if (r6 == null) goto L30;
    L45:
        r6.close();     // Catch: IOException -> L40 Throwable -> L37
    L30:
        if (Log.isLoggable("BitmapEncoder", 2) == false) goto L32;
        Log.v("BitmapEncoder", "Compressed with type: " + r1 + " of size " + com.bumptech.glide.util.k.a(r12) + " in " + com.bumptech.glide.util.f.a(r3) + ", options format: " + r11.b(f855b) + ", hasAlpha: " + r12.hasAlpha());     // Catch: Throwable -> L37
    L32:
        com.bumptech.glide.util.pool.a.a();
        return r5;
    L15:
        th = th;
        r6 = r7;
    L34:
        if (r6 != null) goto L43;
    L36:
        throw th;     // Catch: Throwable -> L37
    L43:
        r6.close();     // Catch: IOException -> L41 Throwable -> L37
        goto L36
    L7:
        if (this.c == null) goto L10;
        r6 = new com.bumptech.glide.load.data.c(r7, this.c);     // Catch: Throwable -> L15 IOException -> L17
    L11:
        r12.compress(r1, r2, r6);     // Catch: Throwable -> L19 IOException -> L21
        r6.close();     // Catch: Throwable -> L19 IOException -> L21
        r5 = true;
        goto L45
    L10:
        r6 = r7;
    L21:
        e = e;
    L19:
        th = th;
    L37:
        th = move-exception;
        com.bumptech.glide.util.pool.a.a();
        throw th;
    }

    @Override // com.bumptech.glide.load.a
    public /* synthetic */ boolean a(Object r3, File r4, com.bumptech.glide.load.e r5) {
        return a((com.bumptech.glide.load.engine.s) ZeusTransformUtils.preCheckCast(r3, com.bumptech.glide.load.engine.s.class, "com.obric.memorydata.plugin"), r4, r5);
    }
}
