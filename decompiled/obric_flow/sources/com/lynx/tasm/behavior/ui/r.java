package com.lynx.tasm.behavior.ui;

import android.graphics.Color;
import com.lynx.react.bridge.ReadableArray;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f10591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f10592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f10593c;
    public float d;
    public float e;
    public float f;
    public int g;

    public static ArrayList a(ReadableArray r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.size() == 0) goto L32;
        ArrayList r5 = new ArrayList();
        int r11 = 0;
    L8:
        if (r11 >= r10.size()) goto L24;
        ReadableArray r12 = r10.getArray(r11);
        r r13 = new r();
        r13.g = 0;
        r13.f10592b = (float) r12.getDouble(0);
        r13.f10593c = (float) r12.getDouble(1);
        float r14 = (float) r12.getDouble(2);
        r13.d = r14;
        r13.f = r14 * 1.25f;
        r13.e = (float) r12.getDouble(3);
        r13.g = r12.getInt(4);
        int r15 = (int) r12.getLong(5);
        r13.f10591a = r15;
        if (r13.f10592b != 0.0f) goto L18;
        if (r13.f10593c != 0.0f) goto L18;
        if (r13.d != 0.0f) goto L18;
        if (r13.e != 0.0f) goto L18;
    L23:
        r11 = r11 + 1;
    L18:
        if (Color.alpha(r15) == 0) goto L23;
        if (r13.d < 0.0f) goto L23;
        r5.add(r13);
        goto L23
    L24:
        return r5;
    L32:
        return null;
    }

    public final boolean b() {
        if (this.g != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L31:
        return false;
    L8:
        if (r.class != r5.getClass()) goto L31;
        r r10 = (r) r5;
        if (this.f10591a == r10.f10591a) goto L14;
        return false;
    L14:
        if (Float.compare(r10.f10592b, this.f10592b) == 0) goto L17;
        return false;
    L17:
        if (Float.compare(r10.f10593c, this.f10593c) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(r10.d, this.d) == 0) goto L23;
        return false;
    L23:
        if (Float.compare(r10.e, this.e) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(r10.f, this.f) == 0) goto L29;
        return false;
    L29:
        if (this.g != r10.g) goto L31;
        return true;
    }

    public final int hashCode() {
        int r5 = ((this.g * 31) + this.f10591a) * 31;
        float r10 = this.f10592b;
        int r11 = 0;
        if (r10 == 0.0f) goto L5;
        int r12 = Float.floatToIntBits(r10);
    L6:
        int r13 = (r5 + r12) * 31;
        float r14 = this.f10593c;
        if (r14 == 0.0f) goto L9;
        int r15 = Float.floatToIntBits(r14);
    L10:
        int r16 = (r13 + r15) * 31;
        float r17 = this.d;
        if (r17 == 0.0f) goto L13;
        int r18 = Float.floatToIntBits(r17);
    L14:
        int r19 = (r16 + r18) * 31;
        float r20 = this.e;
        if (r20 == 0.0f) goto L17;
        int r21 = Float.floatToIntBits(r20);
    L18:
        int r22 = (r19 + r21) * 31;
        float r23 = this.f;
        if (r23 == 0.0f) goto L22;
        r11 = Float.floatToIntBits(r23);
    L22:
        return r22 + r11;
    L17:
        r21 = 0;
        goto L18
    L13:
        r18 = 0;
        goto L14
    L9:
        r15 = 0;
        goto L10
    L5:
        r12 = 0;
        goto L6
    }

    public final String toString() {
        return "ShadowData: Color: red " + Color.red(this.f10591a) + " green: " + Color.green(this.f10591a) + " blue: " + Color.blue(Color.blue(this.f10591a)) + " OffsetX: " + this.f10592b + " offsetY: " + this.f10593c + " blurRadius: " + this.d + " spreadRadius: " + this.e + "option: " + this.g;
    }
}
