package io.noties.markwon.core.spans;

import android.view.animation.Interpolator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class CubicBezierInterpolator implements Interpolator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f16439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected a f16440b;
    protected a c;
    protected a d;
    protected a e;

    static final enum CurveType extends Enum<CurveType> {
        private static final /* synthetic */ CurveType[] $VALUES = null;
        public static final CurveType EXPO_EASE_IN_OUT = null;
        public static final CurveType LINEAR = null;
        public static final CurveType QUAD_EASE_IN = null;
        public static final CurveType SINE_EASE_IN = null;
        public static final CurveType SINE_EASE_IN_OUT = null;
        public static final CurveType SINE_EASE_OUT = null;
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
            $VALUES = new CurveType[]{r7, r0, r1, r2, r3, r4};
        }

        private CurveType(String r1, int r2, float r3, float r4, float r5, float r6) {
            super(r1, r2);
            this.startX = r3;
            this.startY = r4;
            this.endX = r5;
            this.endY = r6;
        }

        public static CurveType valueOf(String r2) {
            return (CurveType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CurveType.class, r2), CurveType.class, "com.obric.memorydata.plugin");
        }

        public static CurveType[] values() {
            return (CurveType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CurveType[].class, "com.obric.memorydata.plugin");
        }
    }

    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f16441a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        float f16442b;

        a() {
        }

        a(float r1, float r2) {
            this.f16441a = r1;
            this.f16442b = r2;
        }
    }

    public CubicBezierInterpolator(float r2, float r3, float r4, float r5) {
        this(new a(r2, r3), new a(r4, r5));
    }

    public CubicBezierInterpolator(a r2, a r3) {
        this.c = new a();
        this.d = new a();
        this.e = new a();
        a(r2);
        a(r3);
        this.f16439a = r2;
        this.f16440b = r3;
    }

    private void a() {
        a r0 = this.e;
        r0.f16441a = this.f16439a.f16441a * 3.0f;
        a r1 = this.d;
        r1.f16441a = ((this.f16440b.f16441a - this.f16439a.f16441a) * 3.0f) - this.e.f16441a;
        a r2 = this.c;
        r2.f16441a = (1.0f - this.e.f16441a) - this.d.f16441a;
        a r3 = this.e;
        r3.f16442b = this.f16439a.f16442b * 3.0f;
        a r4 = this.d;
        r4.f16442b = ((this.f16440b.f16442b - this.f16439a.f16442b) * 3.0f) - this.e.f16442b;
        a r5 = this.c;
        r5.f16442b = (1.0f - this.e.f16442b) - this.d.f16442b;
    }

    private void a(a r2) {
        if (r2.f16441a < 0.0f) goto L8;
        if (r2.f16441a > 1.0f) goto L8;
        return;
    L8:
        throw new IllegalArgumentException("Point x value must be in the range [0, 1]");
    }

    private float c(float r3) {
        return r3 * (this.e.f16441a + ((this.d.f16441a + (this.c.f16441a * r3)) * r3));
    }

    private float d(float r4) {
        return this.e.f16441a + (r4 * ((this.d.f16441a * 2.0f) + ((this.c.f16441a * 3.0f) * r4)));
    }

    public float a(float r3) {
        a();
        return r3 * (this.e.f16442b + ((this.d.f16442b + (this.c.f16442b * r3)) * r3));
    }

    public float b(float r8) {
        int r0 = 0;
        float r1 = r8;
    L4:
        if (r0 >= 14) goto L9;
        float r2 = c(r1) - r8;
        if (Math.abs(r2) < 0.001d) goto L9;
        r1 = r1 - (r2 / d(r1));
        r0 = r0 + 1;
    L9:
        return r1;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float r1) {
        return a(b(r1));
    }
}
