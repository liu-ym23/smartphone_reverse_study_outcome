package com.larus.browsertakeover.render;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public boolean a;
    public a b;
    public int c;
    public int d;

    public static final class a {
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Float.compare(this.a, r6.a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
        }

        public final String toString() {
            return "Bounds(left=" + this.a + ", top=" + this.b + ", right=" + this.c + ", bottom=" + this.d + ')';
        }

        public final a a(a r8) {
            Intrinsics.checkNotNullParameter(r8, "other");
            float r1 = Math.max(this.a, r8.a);
            float r2 = Math.max(this.b, r8.b);
            float r3 = Math.min(this.c, r8.c);
            float r9 = Math.min(this.d, r8.d);
            a r0 = new a(r1, r2, r3, r9);
            boolean r5 = true;
            if (Float.isInfinite(r1) == false) goto L5;
        L7:
            boolean r4 = false;
        L8:
            if (r4 == true) goto L10;
        L35:
            r5 = false;
        L36:
            if (r5 == true) goto L40;
            return null;
        L40:
            return r0;
        L10:
            if (Float.isInfinite(r2) == false) goto L12;
        L14:
            boolean r6 = false;
        L15:
            if (r6 == false) goto L35;
            if (Float.isInfinite(r3) == false) goto L19;
        L21:
            boolean r7 = false;
        L22:
            if (r7 == false) goto L35;
            if (Float.isInfinite(r9) == false) goto L26;
        L28:
            boolean r10 = false;
        L29:
            if (r10 == false) goto L35;
            if (r1 >= r3) goto L35;
            if (r2 >= r9) goto L35;
        L26:
            if (Float.isNaN(r9) == true) goto L28;
            r10 = true;
            goto L29
        L19:
            if (Float.isNaN(r3) == true) goto L21;
            r7 = true;
            goto L22
        L12:
            if (Float.isNaN(r2) == true) goto L14;
            r6 = true;
            goto L15
        L5:
            if (Float.isNaN(r1) == true) goto L7;
            r4 = true;
            goto L8
        }

        public a(float r1, float r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b {
        public final a a;
        public final float b;
        public final float c;
        public final float d;
        public final float e;
        public final a f;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Float.compare(this.b, r6.b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.c, r6.c) == 0) goto L18;
            return false;
        L18:
            if (Float.compare(this.d, r6.d) == 0) goto L21;
            return false;
        L21:
            if (Float.compare(this.e, r6.e) == 0) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31;
            a r1 = this.f;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Mapping(bounds=" + this.a + ", deviceWidth=" + this.b + ", deviceHeight=" + this.c + ", offsetTop=" + this.d + ", scale=" + this.e + ", clipBounds=" + this.f + ')';
        }

        public final b a(float r10, float r11, float r12) {
            boolean r1 = true;
            if (Float.isInfinite(r10) == false) goto L5;
        L7:
            boolean r0 = false;
        L8:
            if (r0 == true) goto L10;
        L26:
            r1 = false;
        L27:
            if (r1 == false) goto L31;
            a r2 = this.a;
            float r3 = r2.a;
            float r4 = r2.b;
            a r5 = new a(r3 + r11, r4 + r12, (r11 + r3) + ((r2.c - r3) * r10), (r12 + r4) + ((r2.d - r4) * r10));
            float r7 = this.e * r10;
            float r6 = this.b;
            float r8 = this.c;
            float r9 = this.d;
            a r13 = this.f;
            Intrinsics.checkNotNullParameter(r5, "bounds");
            return new b(r5, r6, r8, r9, r7, r13);
        L31:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L10:
            if (r10 < 1.0f) goto L26;
            if (Float.isInfinite(r11) == false) goto L14;
        L16:
            boolean r14 = false;
        L17:
            if (r14 == false) goto L26;
            if (Float.isInfinite(r12) == false) goto L21;
        L23:
            boolean r15 = false;
        L24:
            if (r15 == false) goto L26;
        L21:
            if (Float.isNaN(r12) == true) goto L23;
            r15 = true;
            goto L24
        L14:
            if (Float.isNaN(r11) == true) goto L16;
            r14 = true;
            goto L17
        L5:
            if (Float.isNaN(r10) == true) goto L7;
            r0 = true;
            goto L8
        }

        public b(a r2, float r3, float r4, float r5, float r6, a r7) {
            Intrinsics.checkNotNullParameter(r2, "bounds");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
        }
    }

    public c() {
    }

    public final b a(int r10, int r11, float r12, float r13, float r14) {
        if (r10 <= 0) goto L56;
        if (r11 <= 0) goto L56;
        boolean r4 = true;
        if (Float.isInfinite(r12) == false) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L56;
        if (Float.isInfinite(r13) == false) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L56;
        if (Float.isInfinite(r14) == false) goto L22;
    L24:
        r4 = false;
    L25:
        if (r4 == false) goto L56;
        if (r12 <= 0.0f) goto L56;
        if (r13 <= 0.0f) goto L56;
        if (r14 < 0.0f) goto L56;
        if (r14 >= r13) goto L56;
        float r6 = r10;
        a r7 = new a(0.0f, 0.0f, r6, r11);
        if (this.a == false) goto L45;
        a r8 = this.b;
        if (r8 == null) goto L45;
        if (r8 == null) goto L44;
        a r9 = r8.a(r7);
        if (r9 == null) goto L44;
        a r15 = r9;
    L47:
        if (this.a == true) goto L49;
    L53:
        int r0 = r11;
    L54:
        float r1 = r0;
        float r16 = Math.min((r6 - 0.0f) / r12, (r1 - 0.0f) / r13);
        float r2 = r12 * r16;
        float r17 = r13 * r16;
        float r18 = ((r6 + 0.0f) - r2) / 2.0f;
        float r19 = ((0.0f + r1) - r17) / 2.0f;
        return new b(new a(r18, r19, r2 + r18, r17 + r19), r12, r13, r14, r16, r15);
    L49:
        if (this.c != r10) goto L53;
        r0 = this.d;
        if (r0 <= 0) goto L53;
    L44:
        return null;
    L45:
        r15 = null;
        goto L47
    L22:
        if (Float.isNaN(r14) == true) goto L24;
    L15:
        if (Float.isNaN(r13) == true) goto L17;
        r5 = true;
        goto L18
    L8:
        if (Float.isNaN(r12) == true) goto L10;
        r3 = true;
    L56:
        return null;
    }
}
