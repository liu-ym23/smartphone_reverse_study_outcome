package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class i implements com.bumptech.glide.load.f<InputStream, GifDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.f<ByteBuffer, GifDrawable> f913b;
    private final com.bumptech.glide.load.engine.bitmap_recycle.b c;

    public i(List<ImageHeaderParser> r3, com.bumptech.glide.load.f<ByteBuffer, GifDrawable> r4, com.bumptech.glide.load.engine.bitmap_recycle.b r5) {
        List<ImageHeaderParser> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.f<ByteBuffer, GifDrawable> r7 = (com.bumptech.glide.load.f) ZeusTransformUtils.wrapperContextForParams(r4, com.bumptech.glide.load.f.class, "com.obric.memorydata.plugin");
        com.bumptech.glide.load.engine.bitmap_recycle.b r8 = (com.bumptech.glide.load.engine.bitmap_recycle.b) ZeusTransformUtils.wrapperContextForParams(r5, com.bumptech.glide.load.engine.bitmap_recycle.b.class, "com.obric.memorydata.plugin");
        this.f912a = r6;
        this.f913b = r7;
        this.c = r8;
    }

    private static byte[] a(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream(16384);
        byte[] r1 = new byte[16384];     // Catch: IOException -> L10
    L4:
        int r2 = r4.read(r1);     // Catch: IOException -> L10
        if (r2 == (-1)) goto L7;
        r0.write(r1, 0, r2);     // Catch: IOException -> L10
        goto L4
    L7:
        r0.flush();     // Catch: IOException -> L10
        return r0.toByteArray();
    L10:
        e = move-exception;
        if (Log.isLoggable("StreamGifDecoder", 5) == false) goto L19;
        Log.w("StreamGifDecoder", "Error reading data from stream", e);
        return null;
    L19:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public s<GifDrawable> a2(InputStream r1, int r2, int r3, com.bumptech.glide.load.e r4) {
        byte[] r5 = a(r1);
        if (r5 != null) goto L6;
        return null;
    L6:
        ByteBuffer r6 = ByteBuffer.wrap(r5);
        return this.f913b.a(r6, r2, r3, r4);
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ s<GifDrawable> a(InputStream r3, int r4, int r5, com.bumptech.glide.load.e r6) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), r4, r5, r6);
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(InputStream r3, com.bumptech.glide.load.e r4) {
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.b(h.f911b), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L5;
    L7:
        return false;
    L5:
        if (com.bumptech.glide.load.b.getType(this.f912a, r3, this.c) != ImageHeaderParser.ImageType.GIF) goto L7;
        return true;
    }

    @Override // com.bumptech.glide.load.f
    public /* synthetic */ boolean a(InputStream r3, com.bumptech.glide.load.e r4) {
        return a2((InputStream) ZeusTransformUtils.preCheckCast(r3, InputStream.class, "com.obric.memorydata.plugin"), r4);
    }
}
