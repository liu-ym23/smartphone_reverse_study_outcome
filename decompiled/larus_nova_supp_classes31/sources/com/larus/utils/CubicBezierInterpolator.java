package com.larus.utils;

import android.view.animation.Interpolator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class CubicBezierInterpolator implements Interpolator {
    public final a a;
    public final a b;
    public final a c;
    public final a d;
    public final a e;

    public static final enum CurveType extends Enum<CurveType> {
        public static final CurveType EXPO_EASE_IN_OUT = null;
        public static final CurveType LINEAR = null;
        public static final CurveType QUAD_EASE_IN = null;
        public static final CurveType SINE_EASE_IN = null;
        public static final CurveType SINE_EASE_IN_OUT = null;
        public static final CurveType SINE_EASE_OUT = null;
        public static final /* synthetic */ CurveType[] a = null;
        final float endX;
        final float endY;
        final float startX;
        final float startY;

        static {
            CurveType r7 = new CurveType("LINEAR", 0, 0.0f, 0.0f, 1.0f, 1.0f);
            LINEAR = r7;
            CurveType r0 = new CurveType("SINE_EASE_IN", 1, 0.47f, 0.0f, 0.745f, 0.715f);
            SINE_EASE_IN = r0;
            CurveType r1 = new CurveType("SINE_EASE_OUT", 2, 0.39f, 0.575f, 0.565f, 1.0f);
            SINE_EASE_OUT = r1;
            CurveType r2 = new CurveType("SINE_EASE_IN_OUT", 3, 0.445f, 0.05f, 0.55f, 0.95f);
            SINE_EASE_IN_OUT = r2;
            CurveType r3 = new CurveType("QUAD_EASE_IN", 4, 0.26f, 0.0f, 0.6f, 0.2f);
            QUAD_EASE_IN = r3;
            CurveType r4 = new CurveType("EXPO_EASE_IN_OUT", 5, 0.9f, 0.0f, 0.1f, 1.0f);
            EXPO_EASE_IN_OUT = r4;
            a = new CurveType[]{r7, r0, r1, r2, r3, r4};
        }

        public static CurveType[] values() {
            return (CurveType[]) a.clone();
        }

        public static CurveType valueOf(String r1) {
            return (CurveType) r27.a.a(CurveType.class, r1);
        }

        public CurveType(String r1, int r2, float r3, float r4, float r5, float r6) {
            super(r1, r2);
            this.startX = r3;
            this.startY = r4;
            this.endX = r5;
            this.endY = r6;
        }
    }

    public static class a {
        public float a;
        public float b;

        public a() {
        }

        public a(float r1, float r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float r10) {
        int r0 = 0;
        float r1 = r10;
    L4:
        if (r0 >= 14) goto L9;
        float r2 = ((this.e.a + ((this.d.a + (this.c.a * r1)) * r1)) * r1) - r10;
        if (Math.abs(r2) < 0.001d) goto L9;
        r1 = r1 - (r2 / (this.e.a + (((this.d.a * 2.0f) + ((this.c.a * 3.0f) * r1)) * r1)));
        r0 = r0 + 1;
    L9:
        a r11 = this.e;
        a r3 = this.a;
        float r4 = r3.a * 3.0f;
        r11.a = r4;
        a r5 = this.d;
        a r6 = this.b;
        float r7 = ((r6.a - r3.a) * 3.0f) - r4;
        r5.a = r7;
        a r8 = this.c;
        r8.a = (1.0f - r11.a) - r7;
        float r9 = r3.b * 3.0f;
        r11.b = r9;
        float r12 = ((r6.b - r3.b) * 3.0f) - r9;
        r5.b = r12;
        float r13 = (1.0f - r11.b) - r12;
        r8.b = r13;
        return r1 * (r11.b + ((r5.b + (r13 * r1)) * r1));
    }

    public CubicBezierInterpolator(float r5, float r6, float r7) {
        a r0 = new a(r5, r6);
        a r8 = new a(r7, 1.0f);
        this.c = new a();
        this.d = new a();
        this.e = new a();
        float r9 = r0.a;
        if (r9 < 0.0f) goto L15;
        if (r9 > 1.0f) goto L15;
        float r10 = r8.a;
        if (r10 < 0.0f) goto L13;
        if (r10 > 1.0f) goto L13;
        this.a = r0;
        this.b = r8;
        return;
    L13:
        throw new IllegalArgumentException("Point x value must be in the range [0, 1]");
    L15:
        throw new IllegalArgumentException("Point x value must be in the range [0, 1]");
    }
}
