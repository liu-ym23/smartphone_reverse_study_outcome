package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f1611b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f1612c = null;
    public static final j d = null;
    public static final j e = null;
    public static final j f = null;
    public static final z.e g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final boolean f1613h = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1614a;

    static {
        f1611b = new j(2);
        f1612c = new j(0);
        j r5 = new j(1);
        d = r5;
        e = new j(3);
        f = r5;
        g = z.e.a(r5, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f1613h = true;
    }

    public /* synthetic */ j(int r5) {
        this.f1614a = r5;
    }

    public final DownsampleStrategy$SampleSizeRounding a(int r5, int r10, int r11, int r12) {
        switch(this.f1614a) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return DownsampleStrategy$SampleSizeRounding.QUALITY;
    L7:
        if (f1613h == false) goto L10;
        return DownsampleStrategy$SampleSizeRounding.QUALITY;
    L10:
        return DownsampleStrategy$SampleSizeRounding.MEMORY;
    L12:
        return DownsampleStrategy$SampleSizeRounding.QUALITY;
    L14:
        if (b(r5, r10, r11, r12) != 1.0f) goto L17;
        return DownsampleStrategy$SampleSizeRounding.QUALITY;
    L17:
        return f1611b.a(r5, r10, r11, r12);
    }

    public final float b(int r5, int r10, int r11, int r12) {
        switch(this.f1614a) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L7;
            default: goto L4;
        };
    L4:
        return 1.0f;
    L7:
        if (f1613h == true) goto L13;
        int r13 = Math.max(r10 / r12, r5 / r11);
        float r14 = 1.0f;
        if (r13 == 0) goto L18;
        r14 = 1.0f / Integer.highestOneBit(r13);
    L18:
        return r14;
    L13:
        return Math.min(r11 / r5, r12 / r10);
    L15:
        return Math.max(r11 / r5, r12 / r10);
    L17:
        return Math.min(1.0f, f1611b.b(r5, r10, r11, r12));
    }
}
