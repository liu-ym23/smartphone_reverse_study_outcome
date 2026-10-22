package com.google.zxing;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f5062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f5063b;

    public final float a() {
        return this.f5062a;
    }

    public final float b() {
        return this.f5063b;
    }

    public final boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, b.class) == false) goto L10;
        b r5 = (b) ZeusTransformUtils.preCheckCast(r4, b.class, "com.obric.memorydata.plugin");
        if (this.f5062a == r5.f5062a) goto L7;
        return false;
    L7:
        if (this.f5063b != r5.f5063b) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f5062a) * 31) + Float.floatToIntBits(this.f5063b);
    }

    public final String toString() {
        return "(" + this.f5062a + ',' + this.f5063b + ')';
    }
}
