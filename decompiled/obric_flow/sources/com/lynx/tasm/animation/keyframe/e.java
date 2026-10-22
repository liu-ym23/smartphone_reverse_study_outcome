package com.lynx.tasm.animation.keyframe;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10098b;

    public /* synthetic */ e() {
        this.f10097a = 0;
    }

    public String toString() {
        switch(this.f10097a) {
            case 2: goto L6;
            default: goto L5;
        };
    L6:
        StringBuilder r5 = new StringBuilder("(");
        long r10 = this.f10098b;
        r5.append(Float.intBitsToFloat((int) (r10 >> 32)));
        r5.append(", ");
        r5.append(Float.intBitsToFloat((int) (r10 & 4294967295L)));
        r5.append(')');
        return r5.toString();
    L5:
        return super.toString();
    }

    public e(long r5) {
        this.f10097a = 1;
        this.f10098b = r5;
    }

    public e(float r5, float r10) {
        this.f10097a = 2;
        long r11 = Float.floatToRawIntBits(r5);
        this.f10098b = (((long) Float.floatToRawIntBits(r10)) & 4294967295L) | (r11 << 32);
    }
}
