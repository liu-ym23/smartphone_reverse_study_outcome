package com.bumptech.glide.load.resource.bitmap;

/* JADX INFO: loaded from: classes.dex */
public final enum DownsampleStrategy$SampleSizeRounding extends Enum<DownsampleStrategy$SampleSizeRounding> {
    public static final DownsampleStrategy$SampleSizeRounding MEMORY = null;
    public static final DownsampleStrategy$SampleSizeRounding QUALITY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DownsampleStrategy$SampleSizeRounding[] f1595a = null;

    static {
        DownsampleStrategy$SampleSizeRounding r5 = new DownsampleStrategy$SampleSizeRounding("MEMORY", 0);
        MEMORY = r5;
        DownsampleStrategy$SampleSizeRounding r10 = new DownsampleStrategy$SampleSizeRounding("QUALITY", 1);
        QUALITY = r10;
        f1595a = new DownsampleStrategy$SampleSizeRounding[]{r5, r10};
    }

    public static DownsampleStrategy$SampleSizeRounding valueOf(String r5) {
        return (DownsampleStrategy$SampleSizeRounding) Enum.valueOf(DownsampleStrategy$SampleSizeRounding.class, r5);
    }

    public static DownsampleStrategy$SampleSizeRounding[] values() {
        return (DownsampleStrategy$SampleSizeRounding[]) f1595a.clone();
    }
}
