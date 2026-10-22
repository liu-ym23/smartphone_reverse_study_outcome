package com.lynx.animax.property;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public final float a;
    public final float b;
    public final AnimaXValueParam c;
    public final AnimaXValueParam d;
    public final float e;
    public final float f;
    public final float g;

    public final String toString() {
        StringBuilder r0 = new StringBuilder("AnimaXFrameInfo{frames=");
        r0.append(this.a);
        r0.append("->");
        r0.append(this.b);
        r0.append(", startValue=");
        Object r1 = this.c;
        Object r2 = "null";
        if (r1 != null) goto L6;
        r1 = "null";
    L6:
        r0.append(r1);
        r0.append(", endValue=");
        AnimaXValueParam r3 = this.d;
        if (r3 == null) goto L9;
        r2 = r3;
    L9:
        r0.append(r2);
        r0.append(", progress=[linear=");
        r0.append(String.format("%.2f", new Object[]{Float.valueOf(this.e)}));
        r0.append(", interpolated=");
        r0.append(String.format("%.2f", new Object[]{Float.valueOf(this.f)}));
        r0.append(", overall=");
        r0.append(String.format("%.2f", new Object[]{Float.valueOf(this.g)}));
        r0.append("]}");
        return r0.toString();
    }

    public a(float r1, float r2, AnimaXValueParam r3, AnimaXValueParam r4, float r5, float r6, float r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
