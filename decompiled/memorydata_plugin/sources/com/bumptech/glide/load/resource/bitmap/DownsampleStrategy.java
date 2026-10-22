package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class DownsampleStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownsampleStrategy f840a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DownsampleStrategy f841b = null;
    public static final DownsampleStrategy c = null;
    public static final DownsampleStrategy d = null;
    public static final DownsampleStrategy e = null;
    public static final DownsampleStrategy f = null;
    public static final DownsampleStrategy g = null;
    public static final com.bumptech.glide.load.d<DownsampleStrategy> h = null;
    static final boolean i = false;

    public static final enum SampleSizeRounding extends Enum<SampleSizeRounding> {
        private static final /* synthetic */ SampleSizeRounding[] $VALUES = null;
        public static final SampleSizeRounding MEMORY = null;
        public static final SampleSizeRounding QUALITY = null;

        private static /* synthetic */ SampleSizeRounding[] $values() {
            return new SampleSizeRounding[]{MEMORY, QUALITY};
        }

        static {
            MEMORY = new SampleSizeRounding("MEMORY", 0);
            QUALITY = new SampleSizeRounding("QUALITY", 1);
            $VALUES = $values();
        }

        private SampleSizeRounding(String r1, int r2) {
            super(r1, r2);
        }

        public static SampleSizeRounding valueOf(String r2) {
            return (SampleSizeRounding) ZeusTransformUtils.preCheckCast(Enum.valueOf(SampleSizeRounding.class, r2), SampleSizeRounding.class, "com.obric.memorydata.plugin");
        }

        public static SampleSizeRounding[] values() {
            return (SampleSizeRounding[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SampleSizeRounding[].class, "com.obric.memorydata.plugin");
        }
    }

    private static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int r1, int r2, int r3, int r4) {
            int r0 = Math.min(r2 / r4, r1 / r3);
            if (r0 != 0) goto L6;
            return 1.0f;
        L6:
            return 1.0f / Integer.highestOneBit(r0);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int r1, int r2, int r3, int r4) {
            int r0 = (int) Math.ceil(Math.max(r2 / r4, r1 / r3));
            int r5 = 1;
            int r6 = Math.max(1, Integer.highestOneBit(r0));
            if (r6 < r0) goto L7;
            r5 = 0;
        L7:
            return 1.0f / (r6 << r5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int r1, int r2, int r3, int r4) {
            return Math.min(1.0f, c.a(r1, r2, r3, r4));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int r2, int r3, int r4, int r5) {
            if (a(r2, r3, r4, r5) != 1.0f) goto L6;
            return SampleSizeRounding.QUALITY;
        L6:
            return c.b(r2, r3, r4, r5);
        }
    }

    private static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int r1, int r2, int r3, int r4) {
            return Math.max(r3 / r1, r4 / r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int r1, int r2, int r3, int r4) {
            if (i == true) goto L5;
            int r0 = Math.max(r2 / r4, r1 / r3);
            if (r0 != 0) goto L10;
            return 1.0f;
        L10:
            return 1.0f / Integer.highestOneBit(r0);
        L5:
            return Math.min(r3 / r1, r4 / r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int r1, int r2, int r3, int r4) {
            if (i == false) goto L7;
            return SampleSizeRounding.QUALITY;
        L7:
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class f extends DownsampleStrategy {
        f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float a(int r1, int r2, int r3, int r4) {
            return 1.0f;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding b(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    static {
        f840a = new a();
        f841b = new b();
        c = new e();
        d = new c();
        d r0 = new d();
        e = r0;
        f = new f();
        g = r0;
        h = com.bumptech.glide.load.d.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", r0);
        if (Build.VERSION.SDK_INT < 19) goto L5;
        boolean r1 = true;
    L6:
        i = r1;
        return;
    L5:
        r1 = false;
        goto L6
    }

    public DownsampleStrategy() {
    }

    public abstract float a(int r1, int r2, int r3, int r4);

    public abstract SampleSizeRounding b(int r1, int r2, int r3, int r4);
}
