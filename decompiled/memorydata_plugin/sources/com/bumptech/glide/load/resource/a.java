package com.bumptech.glide.load.resource;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final class a implements ImageDecoder.OnHeaderDecodedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f821b;
    private final int c;
    private final DecodeFormat d;
    private final DownsampleStrategy e;
    private final boolean f;
    private final PreferredColorSpace g;

    public a(int r2, int r3, e r4) {
        this.f820a = n.a();
        this.f821b = r2;
        this.c = r3;
        this.d = (DecodeFormat) ZeusTransformUtils.preCheckCast(r4.b(j.f862a), DecodeFormat.class, "com.obric.memorydata.plugin");
        this.e = (DownsampleStrategy) ZeusTransformUtils.preCheckCast(r4.b(DownsampleStrategy.h), DownsampleStrategy.class, "com.obric.memorydata.plugin");
        if (r4.b(j.e) != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.f = r5;
        this.g = (PreferredColorSpace) ZeusTransformUtils.preCheckCast(r4.b(j.f863b), PreferredColorSpace.class, "com.obric.memorydata.plugin");
        return;
    L5:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r4.b(j.e), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L7;
        r5 = true;
        goto L8
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder r9, ImageDecoder.ImageInfo r10, ImageDecoder.Source r11) {
        boolean r3 = false;
        if (this.f820a.a(this.f821b, this.c, this.f, false) == false) goto L5;
        r9.setAllocator(3);
    L7:
        if (this.d != DecodeFormat.PREFER_RGB_565) goto L9;
        r9.setMemorySizePolicy(0);
    L9:
        r9.setOnPartialImageListener(new AnonymousClass1(this));
        Size r12 = r10.getSize();
        int r1 = this.f821b;
        if (r1 != Integer.MIN_VALUE) goto L12;
        r1 = r12.getWidth();
    L12:
        int r4 = this.c;
        if (r4 != Integer.MIN_VALUE) goto L15;
        r4 = r12.getHeight();
    L15:
        float r2 = this.e.a(r12.getWidth(), r12.getHeight(), r1, r4);
        int r5 = Math.round(r12.getWidth() * r2);
        int r6 = Math.round(r12.getHeight() * r2);
        if (Log.isLoggable("ImageDecoder", 2) == false) goto L18;
        Log.v("ImageDecoder", "Resizing from [" + r12.getWidth() + "x" + r12.getHeight() + "] to [" + r5 + "x" + r6 + "] scaleFactor: " + r2);
    L18:
        r9.setTargetSize(r5, r6);
        if (this.g != null) goto L21;
        return;
    L21:
        if (Build.VERSION.SDK_INT < 28) goto L32;
        if (this.g == PreferredColorSpace.DISPLAY_P3) goto L25;
    L29:
        if (r3 == false) goto L33;
        ColorSpace.Named r8 = ColorSpace.Named.DISPLAY_P3;
    L34:
        r9.setTargetColorSpace(ColorSpace.get(r8));
        return;
    L33:
        r8 = ColorSpace.Named.SRGB;
        goto L34
    L25:
        if (r10.getColorSpace() == null) goto L29;
        if (r10.getColorSpace().isWideGamut() == false) goto L29;
        r3 = true;
        goto L29
    L32:
        if (Build.VERSION.SDK_INT >= 26) goto L33;
        return;
    L5:
        r9.setAllocator(1);
        goto L7
    }
}
