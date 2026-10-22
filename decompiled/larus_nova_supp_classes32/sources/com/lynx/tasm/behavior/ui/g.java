package com.lynx.tasm.behavior.ui;

import android.graphics.Color;
import com.lynx.react.bridge.ReadableArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public int a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;

    public final boolean a() {
        if (this.g == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.g * 31) + this.a) * 31;
        float r1 = this.b;
        int r2 = 0;
        if (r1 == 0.0f) goto L5;
        int r3 = Float.floatToIntBits(r1);
    L6:
        int r4 = (r0 + r3) * 31;
        float r5 = this.c;
        if (r5 == 0.0f) goto L9;
        int r6 = Float.floatToIntBits(r5);
    L10:
        int r7 = (r4 + r6) * 31;
        float r8 = this.d;
        if (r8 == 0.0f) goto L13;
        int r9 = Float.floatToIntBits(r8);
    L14:
        int r10 = (r7 + r9) * 31;
        float r11 = this.e;
        if (r11 == 0.0f) goto L17;
        int r12 = Float.floatToIntBits(r11);
    L18:
        int r13 = (r10 + r12) * 31;
        float r14 = this.f;
        if (r14 == 0.0f) goto L22;
        r2 = Float.floatToIntBits(r14);
    L22:
        return r13 + r2;
    L17:
        r12 = 0;
        goto L18
    L13:
        r9 = 0;
        goto L14
    L9:
        r6 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "ShadowData: Color: red " + Color.red(this.a) + " green: " + Color.green(this.a) + " blue: " + Color.blue(Color.blue(this.a)) + " OffsetX: " + this.b + " offsetY: " + this.c + " blurRadius: " + this.d + " spreadRadius: " + this.e + "option: " + this.g;
    }

    public g() {
        this.g = 0;
    }

    public static List<g> b(ReadableArray r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.size() == 0) goto L31;
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L8:
        if (r2 >= r8.size()) goto L25;
        ReadableArray r3 = r8.getArray(r2);
        g r4 = new g();
        r4.b = (float) r3.getDouble(0);
        boolean r5 = true;
        r4.c = (float) r3.getDouble(1);
        float r6 = (float) r3.getDouble(2);
        r4.d = r6;
        r4.f = r6 * 1.25f;
        r4.e = (float) r3.getDouble(3);
        r4.g = r3.getInt(4);
        int r7 = (int) r3.getLong(5);
        r4.a = r7;
        if (r4.b != 0.0f) goto L18;
        if (r4.c != 0.0f) goto L18;
        if (r4.d != 0.0f) goto L18;
        if (r4.e != 0.0f) goto L18;
    L21:
        r5 = false;
    L22:
        if (r5 == false) goto L24;
        r0.add(r4);
    L24:
        r2 = r2 + 1;
    L18:
        if (Color.alpha(r7) == 0) goto L21;
        if (r4.d >= 0.0f) goto L22;
    L25:
        return r0;
    L31:
        return null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L33:
        return false;
    L8:
        if (g.class != r5.getClass()) goto L33;
        g r6 = (g) r5;
        if (this.a == r6.a) goto L14;
        return false;
    L14:
        if (Float.compare(r6.b, this.b) == 0) goto L17;
        return false;
    L17:
        if (Float.compare(r6.c, this.c) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(r6.d, this.d) == 0) goto L23;
        return false;
    L23:
        if (Float.compare(r6.e, this.e) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(r6.f, this.f) == 0) goto L29;
        return false;
    L29:
        if (this.g == r6.g) goto L34;
        return false;
    L34:
        return true;
    }
}
