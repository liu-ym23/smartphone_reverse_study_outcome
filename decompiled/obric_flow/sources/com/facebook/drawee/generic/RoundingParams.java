package com.facebook.drawee.generic;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class RoundingParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RoundingMethod f7927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float[] f7929c;
    public int d;
    public float e;
    public int f;
    public float g;

    public static final enum RoundingMethod extends Enum<RoundingMethod> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RoundingMethod f7930a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final RoundingMethod f7931b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ RoundingMethod[] f7932c = null;

        static {
            RoundingMethod r5 = new RoundingMethod("OVERLAY_COLOR", 0);
            f7930a = r5;
            RoundingMethod r10 = new RoundingMethod("BITMAP_ONLY", 1);
            f7931b = r10;
            f7932c = new RoundingMethod[]{r5, r10};
        }

        public RoundingMethod(String r5, int r10) {
            super(r5, r10);
        }

        public static RoundingMethod valueOf(String r5) {
            return (RoundingMethod) Enum.valueOf(RoundingMethod.class, r5);
        }

        public static RoundingMethod[] values() {
            return (RoundingMethod[]) f7932c.clone();
        }
    }

    public RoundingParams() {
        this.f7927a = RoundingMethod.f7931b;
        this.f7928b = false;
        this.f7929c = null;
        this.d = 0;
        this.e = 0.0f;
        this.f = 0;
        this.g = 0.0f;
    }

    public static RoundingParams a(float[] r5) {
        RoundingParams r10 = new RoundingParams();
        r5.getClass();
        if (r5.length != 8) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L13;
        if (r10.f7929c != null) goto L10;
        r10.f7929c = new float[8];
    L10:
        System.arraycopy(r5, 0, r10.f7929c, 0, 8);
        return r10;
    L13:
        throw new IllegalArgumentException("radii should have exactly 8 values");
    L5:
        r11 = false;
        goto L6
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L30:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L30;
        RoundingParams r10 = (RoundingParams) r5;
        if (this.f7928b == r10.f7928b) goto L14;
        return false;
    L14:
        if (this.d == r10.d) goto L17;
        return false;
    L17:
        if (Float.compare(r10.e, this.e) == 0) goto L20;
        return false;
    L20:
        if (this.f == r10.f) goto L23;
        return false;
    L23:
        if (Float.compare(r10.g, this.g) == 0) goto L26;
        return false;
    L26:
        if (this.f7927a == r10.f7927a) goto L29;
        return false;
    L29:
        return Arrays.equals(this.f7929c, r10.f7929c);
    }

    public final int hashCode() {
        RoundingMethod r5 = this.f7927a;
        int r10 = 0;
        if (r5 == null) goto L5;
        int r11 = r5.hashCode();
    L6:
        int r12 = ((r11 * 31) + (this.f7928b ? 1 : 0)) * 31;
        float[] r13 = this.f7929c;
        if (r13 == null) goto L9;
        int r14 = Arrays.hashCode(r13);
    L10:
        int r15 = (((r12 + r14) * 31) + this.d) * 31;
        float r16 = this.e;
        if (r16 == 0.0f) goto L13;
        int r17 = Float.floatToIntBits(r16);
    L14:
        int r18 = (((r15 + r17) * 31) + this.f) * 31;
        float r19 = this.g;
        if (r19 == 0.0f) goto L18;
        r10 = Float.floatToIntBits(r19);
    L18:
        return (r18 + r10) * 961;
    L13:
        r17 = 0;
        goto L14
    L9:
        r14 = 0;
        goto L10
    L5:
        r11 = 0;
        goto L6
    }
}
