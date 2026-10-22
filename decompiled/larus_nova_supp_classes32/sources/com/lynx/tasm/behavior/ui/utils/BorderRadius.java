package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class BorderRadius {
    public float a;
    public float b;
    public a[] c;
    public float[] d;

    public static final enum Location extends Enum<Location> {
        public static final Location BOTTOM_LEFT = null;
        public static final Location BOTTOM_RIGHT = null;
        public static final Location TOP_LEFT = null;
        public static final Location TOP_RIGHT = null;
        public static final /* synthetic */ Location[] a = null;

        static {
            Location r0 = new Location("TOP_LEFT", 0);
            TOP_LEFT = r0;
            Location r1 = new Location("TOP_RIGHT", 1);
            TOP_RIGHT = r1;
            Location r3 = new Location("BOTTOM_RIGHT", 2);
            BOTTOM_RIGHT = r3;
            Location r5 = new Location("BOTTOM_LEFT", 3);
            BOTTOM_LEFT = r5;
            a = new Location[]{r0, r1, r3, r5};
        }

        public static Location[] values() {
            return (Location[]) a.clone();
        }

        public static Location valueOf(String r1) {
            return (Location) r27.a.a(Location.class, r1);
        }

        public Location(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static class a {
        public j a;
        public j b;

        public a() {
        }

        public final boolean equals(Object r4) {
            if (r4 != null) goto L5;
            return false;
        L5:
            a r5 = (a) r4;
            if (Objects.equals(this.a, r5.a) == true) goto L8;
            return false;
        L8:
            if (Objects.equals(this.b, r5.b) == false) goto L12;
            return true;
        L12:
            return false;
        }

        public static a a(ReadableArray r4, int r5) {
            a r0 = new a();
            r0.a = new j(r4.getDynamic(r5), r4.getInt(r5 + 1));
            r0.b = new j(r4.getDynamic(r5 + 2), r4.getInt(r5 + 3));
            return r0;
        }
    }

    public final float[] a() {
        float[] r0 = this.d;
        if (r0 == null) goto L5;
        return r0;
    L5:
        float[] r1 = new float[8];
        int r4 = 0;
        if (this.c != null) goto L10;
        int r2 = 0;
    L8:
        if (r2 >= 8) goto L20;
        r1[r2] = 0.0f;
        r2 = r2 + 1;
    L20:
        this.d = r1;
        if (com.lynx.tasm.utils.b.a(this.a, 0.0f) == true) goto L51;
        if (com.lynx.tasm.utils.b.a(this.b, 0.0f) == true) goto L51;
        float[] r3 = this.d;
        float r5 = r3[0] + r3[2];
        float r6 = this.a;
        if (r5 <= r6) goto L30;
        float r7 = r6 / r5;
        if (r7 >= 1.0f) goto L30;
    L31:
        float r8 = r3[4] + r3[6];
        if (r8 <= r6) goto L36;
        float r9 = r6 / r8;
        if (r9 >= r7) goto L36;
        r7 = r9;
    L36:
        float r10 = r3[1] + r3[7];
        float r11 = this.b;
        if (r10 <= r11) goto L41;
        float r12 = r11 / r10;
        if (r12 >= r7) goto L41;
        r7 = r12;
    L41:
        float r13 = r3[3] + r3[5];
        if (r13 <= r11) goto L47;
        float r14 = r11 / r13;
        if (r14 >= r7) goto L47;
        r7 = r14;
    L47:
        if (r7 >= 1.0f) goto L51;
    L48:
        if (r4 >= 8) goto L51;
        r3[r4] = r3[r4] * r7;
        r4 = r4 + 1;
    L30:
        r7 = 1.0f;
    L51:
        return this.d;
    L10:
        int r15 = 0;
    L11:
        if (r15 >= 4) goto L20;
        a r16 = this.c[r15];
        int r17 = r15 * 2;
        int r18 = r17 + 1;
        if (r16 == null) goto L18;
        j r19 = r16.a;
        if (r19 == null) goto L18;
        r1[r17] = r19.b(this.a);
        r1[r18] = r16.b.b(this.b);
    L19:
        r15 = r15 + 1;
    L18:
        r1[r18] = 0.0f;
        r1[r17] = 0.0f;
        goto L19
    }

    public final boolean b() {
        a[] r0 = this.c;
        if (r0 == null) goto L27;
        int r2 = r0.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L27;
        a r4 = r0[r3];
        if (r4 == null) goto L26;
        j r5 = r4.a;
        if (r5 == null) goto L26;
        if (r5.a != 2) goto L14;
    L16:
        boolean r6 = false;
    L17:
        if (r6 == false) goto L25;
        j r7 = r4.b;
        if (r7.a != 2) goto L21;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == true) goto L26;
    L21:
        if (r7.b != 0.0f) goto L23;
        r8 = true;
    L25:
        return true;
    L14:
        if (r5.b != 0.0f) goto L16;
        r6 = true;
    L26:
        r3 = r3 + 1;
    L27:
        return false;
    }

    public BorderRadius() {
        this.a = 0.0f;
        this.b = 0.0f;
    }

    public final boolean c(int r3, a r4) {
        if (r3 >= 0) goto L4;
        return false;
    L4:
        if (r3 < 4) goto L7;
        return false;
    L7:
        if (this.c != null) goto L10;
        this.c = new a[4];
    L10:
        if (r4.equals(this.c[r3]) == true) goto L15;
        this.c[r3] = r4;
        return true;
    L15:
        return false;
    }

    public final boolean d(float r3, float r4) {
        if (r3 >= 0.0f) goto L5;
    L7:
        r3 = 0.0f;
    L9:
        if (r4 >= 0.0f) goto L11;
    L13:
        r4 = 0.0f;
    L15:
        if (com.lynx.tasm.utils.b.a(r3, this.a) == true) goto L17;
    L23:
        this.a = r3;
        this.b = r4;
        this.d = null;
        return true;
    L17:
        if (com.lynx.tasm.utils.b.a(r4, this.b) == false) goto L23;
        if (this.d == null) goto L25;
        return false;
    L25:
        return true;
    L11:
        if (y6a.l.a(r4) == true) goto L13;
    L5:
        if (y6a.l.a(r3) == true) goto L7;
        goto L7
    }
}
