package bd0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final String h;
    public String i;
    public String j;
    public final String k;
    public final Integer l;
    public Integer m;

    public final int hashCode() {
        int r0 = ((((((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31;
        Integer r1 = this.m;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public final String toString() {
        return "{x:" + this.a + ",y:" + this.b + ",z:" + this.c + ",width:" + this.d + ",height:" + this.e + ",nW:" + this.f + ",nH:" + this.g + ",uid:" + this.i + "},url:" + this.j + ",linkType:" + this.h + ",position:" + this.m;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if ((!Intrinsics.areEqual(a.class, r2)) == false) goto L12;
        return false;
    L12:
        if (r5 == null) goto L39;
        a r6 = (a) r5;
        if (this.a == r6.a) goto L17;
        return false;
    L17:
        if (this.b == r6.b) goto L20;
        return false;
    L20:
        if (this.c == r6.c) goto L23;
        return false;
    L23:
        if (this.d == r6.d) goto L26;
        return false;
    L26:
        if (this.e == r6.e) goto L29;
        return false;
    L29:
        if (this.f == r6.f) goto L32;
        return false;
    L32:
        if (this.g == r6.g) goto L35;
        return false;
    L35:
        if ((!Intrinsics.areEqual(this.m, r6.m)) == false) goto L37;
        return false;
    L37:
        return true;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.animation.universalwidget.model.HeadWordRenderInfo");
    L8:
        r2 = null;
        goto L10
    }

    public a(float r4, float r5, float r6, float r7, float r8, float r9, String r10, String r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r10, "linkType");
        Intrinsics.checkNotNullParameter("", "uid");
        Intrinsics.checkNotNullParameter("", "url");
        this.a = r4;
        this.b = r5;
        this.c = 0.001f;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = "";
        this.j = "";
        this.k = r11;
        this.l = r12;
        this.m = -1;
    }
}
