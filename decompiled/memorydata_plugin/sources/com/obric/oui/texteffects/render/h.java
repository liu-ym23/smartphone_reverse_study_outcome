package com.obric.oui.texteffects.render;

import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.LruCache;
import android.view.animation.PathInterpolator;
import com.obric.oui.texteffects.core.CharacterRangeUnit;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LruCache<com.obric.oui.texteffects.core.i.b, PathInterpolator> f14663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LruCache<com.obric.oui.texteffects.core.i.a, com.obric.oui.texteffects.runtime.a> f14664b = null;

    public interface a {
        int map(float r1);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f14665a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f14666b;
        public final int c;

        public b(int[] r1, float[] r2, int r3) {
            this.f14665a = r1;
            this.f14666b = r2;
            this.c = r3;
        }
    }

    static {
        f14663a = new LruCache(16);
        f14664b = new LruCache(16);
    }

    private static float a(float r0, float r1, float r2) {
        return Math.max(r1, Math.min(r2, r0));
    }

    public static float a(com.obric.oui.texteffects.core.g r2, long r3, long r5, long r7, float r9) {
        long r0 = Math.max(1, r7);
        float r4 = a(r2.c(), a(r3 - r5, 0, r0) / r0);
        float r6 = r2.a() * r9;
        return r6 + (((r9 * r2.b()) - r6) * r4);
    }

    public static float a(com.obric.oui.texteffects.core.h r2, float r3) {
        CharacterRangeUnit r0 = r2.b();
        CharacterRangeUnit r1 = CharacterRangeUnit.Absolute;
        float r4 = r2.a();
        if (r0 != r1) goto L6;
        return r4;
    L6:
        return r3 * r4;
    }

    public static float a(com.obric.oui.texteffects.core.i r2, float r3) {
        float r4 = a(r3, 0.0f, 1.0f);
        if (r2 != com.obric.oui.texteffects.core.i.c.f14603a) goto L6;
        return r4;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.i.b.class) == false) goto L10;
        return a((com.obric.oui.texteffects.core.i.b) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.i.b.class, "com.obric.memorydata.plugin")).getInterpolation(r4);
    L10:
        if (ZeusTransformUtils.instanceOf(r2, com.obric.oui.texteffects.core.i.a.class) == true) goto L12;
        return r4;
    L12:
        return a((com.obric.oui.texteffects.core.i.a) ZeusTransformUtils.preCheckCast(r2, com.obric.oui.texteffects.core.i.a.class, "com.obric.memorydata.plugin")).getInterpolation(r4);
    }

    private static int a(float r6, int[] r7, float[] r8) {
        if (r7.length != 0) goto L6;
        return 0;
    L6:
        if (r7.length == 1) goto L8;
        float r9 = a(r6, 0.0f, 1.0f);
        if (r8.length == r7.length) goto L18;
        float r10 = r9 * (r7.length - 1);
        int r11 = a((int) r10, 0, r7.length - 1);
        int r1 = Math.min(r11 + 1, r7.length - 1);
        if (r11 != r1) goto L16;
        return r7[r11];
    L16:
        return a(r7[r11], r7[r1], a(r10 - r11, 0.0f, 1.0f));
    L18:
        if (r9 > r8[0]) goto L22;
        return r7[0];
    L22:
        if (r9 >= r8[r8.length - 1]) goto L24;
        int r2 = 1;
    L27:
        if (r2 >= r8.length) goto L34;
        float r4 = r8[r2];
        if (r9 <= r4) goto L30;
        r2 = r2 + 1;
        goto L27
    L30:
        int r3 = r2 - 1;
        float r12 = r8[r3];
        return a(r7[r3], r7[r2], a((r9 - r12) / Math.max(1.0E-4f, r4 - r12), 0.0f, 1.0f));
    L34:
        return r7[r7.length - 1];
    L24:
        return r7[r7.length - 1];
    L8:
        return r7[0];
    }

    private static int a(int r5, int r6, float r7) {
        float r8 = a(r7, 0.0f, 1.0f);
        return Color.argb(Color.alpha(r5) + ((int) ((Color.alpha(r6) - Color.alpha(r5)) * r8)), Color.red(r5) + ((int) ((Color.red(r6) - Color.red(r5)) * r8)), Color.green(r5) + ((int) ((Color.green(r6) - Color.green(r5)) * r8)), Color.blue(r5) + ((int) ((Color.blue(r6) - Color.blue(r5)) * r8)));
    }

    private static int a(int r0, int r1, int r2) {
        return Math.max(r1, Math.min(r2, r0));
    }

    private static /* synthetic */ int a(int[] r0, float[] r1, float r2) {
        return a(r2, r0, r1);
    }

    private static long a(long r0, long r2, long r4) {
        return Math.max(r2, Math.min(r4, r0));
    }

    public static LinearGradient a(b r9) {
        return new LinearGradient(0.0f, 0.0f, 1.0f, 0.0f, r9.f14665a, r9.f14666b, Shader.TileMode.CLAMP);
    }

    private static PathInterpolator a(com.obric.oui.texteffects.core.i.b r6) {
        LruCache<com.obric.oui.texteffects.core.i.b, PathInterpolator> r0 = f14663a;
        PathInterpolator r1 = (PathInterpolator) ZeusTransformUtils.preCheckCast(r0.get(r6), PathInterpolator.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        PathInterpolator r2 = new PathInterpolator(r6.a(), r6.b(), r6.c(), r6.d());
        r0.put(r6, r2);
        return r2;
    }

    public static a a(int[] r2, float[] r3) {
        final int[] r4 = (int[]) ZeusTransformUtils.preCheckCast(r2.clone(), int[].class, "com.obric.memorydata.plugin");
        final float[] r5 = (float[]) ZeusTransformUtils.preCheckCast(r3.clone(), float[].class, "com.obric.memorydata.plugin");
        return new $$Lambda$h$YEi9yosIMDwfkgA2786tu93ffE(r4, r5);
    }

    public static b a(com.obric.oui.texteffects.core.i r6, int r7, a r8) {
        a r9 = (a) ZeusTransformUtils.wrapperContextForParams(r8, a.class, "com.obric.memorydata.plugin");
        int r10 = Math.max(2, r7);
        int[] r0 = new int[r10];
        float[] r1 = new float[r10];
        int r2 = 17;
        int r3 = 0;
    L3:
        if (r3 >= r10) goto L6;
        float r4 = r3 / (r10 - 1);
        int r5 = r9.map(a(r6, r4));
        r0[r3] = r5;
        r1[r3] = r4;
        r2 = (((r2 * 31) + r5) * 31) + Float.floatToRawIntBits(r1[r3]);
        r3 = r3 + 1;
        goto L3
    L6:
        return new b(r0, r1, r2);
    }

    private static com.obric.oui.texteffects.runtime.a a(com.obric.oui.texteffects.core.i.a r5) {
        LruCache<com.obric.oui.texteffects.core.i.a, com.obric.oui.texteffects.runtime.a> r0 = f14664b;
        com.obric.oui.texteffects.runtime.a r1 = (com.obric.oui.texteffects.runtime.a) ZeusTransformUtils.preCheckCast(r0.get(r5), com.obric.oui.texteffects.runtime.a.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L5;
        return r1;
    L5:
        com.obric.oui.texteffects.runtime.a r2 = new com.obric.oui.texteffects.runtime.a(r5.a(), r5.b(), r5.c());
        r0.put(r5, r2);
        return r2;
    }

    /* JADX INFO: renamed from: lambda$YEi9yosIM-DwfkgA2786tu93ffE, reason: not valid java name */
    public static /* synthetic */ int m1377lambda$YEi9yosIMDwfkgA2786tu93ffE(int[] r0, float[] r1, float r2) {
        return a(r0, r1, r2);
    }
}
