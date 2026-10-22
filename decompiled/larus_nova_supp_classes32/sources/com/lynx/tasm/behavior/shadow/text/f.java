package com.lynx.tasm.behavior.shadow.text;

import com.lynx.tasm.behavior.shadow.MeasureMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class f {
    public final a a;
    public final MeasureMode b;
    public final MeasureMode c;
    public final float d;
    public final float e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public static class a {
        public CharSequence a;
        public final com.lynx.tasm.behavior.shadow.text.a b;

        public final int hashCode() {
            CharSequence r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            com.lynx.tasm.behavior.shadow.text.a r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final boolean equals(Object r4) {
            if ((r4 instanceof a) == true) goto L5;
            return false;
        L5:
            a r5 = (a) r4;
            CharSequence r0 = this.a;
            if (r0 == null) goto L8;
        L10:
            if (r0 != null) goto L12;
        L14:
            com.lynx.tasm.behavior.shadow.text.a r1 = this.b;
            if (r1 == null) goto L17;
        L19:
            if (r1 != null) goto L21;
        L22:
            return true;
        L21:
            if (r1.equals(r5.b) == true) goto L22;
            return false;
        L17:
            if (r5.b == null) goto L19;
            return false;
        L12:
            if (r0.equals(r5.a) == true) goto L14;
            return false;
        L8:
            if (r5.a == null) goto L10;
            return false;
        }

        public a(CharSequence r1, com.lynx.tasm.behavior.shadow.text.a r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public final int hashCode() {
        return (((((((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }

    public final String toString() {
        return this.a.a + " " + this.d + " " + this.e;
    }

    public final boolean equals(Object r4) {
        if ((r4 instanceof f) == true) goto L5;
        return false;
    L5:
        f r5 = (f) r4;
        if (this.a.equals(r5.a) == true) goto L8;
        return false;
    L8:
        if (this.b == r5.b) goto L10;
        return false;
    L10:
        if (this.c == r5.c) goto L12;
        return false;
    L12:
        if (this.d == r5.d) goto L14;
        return false;
    L14:
        if (this.e == r5.e) goto L16;
        return false;
    L16:
        if (this.f == r5.f) goto L18;
        return false;
    L18:
        if (this.g == r5.g) goto L20;
        return false;
    L20:
        if (this.h == r5.h) goto L22;
        return false;
    L22:
        if (this.i != r5.i) goto L33;
        return true;
    L33:
        return false;
    }

    public f(CharSequence r2, com.lynx.tasm.behavior.shadow.text.a r3, MeasureMode r4, MeasureMode r5, float r6, float r7, int r8, boolean r9, boolean r10, boolean r11) {
        this.a = new a(r2, r3);
        this.d = r6;
        this.e = r7;
        this.b = r4;
        this.c = r5;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
    }
}
