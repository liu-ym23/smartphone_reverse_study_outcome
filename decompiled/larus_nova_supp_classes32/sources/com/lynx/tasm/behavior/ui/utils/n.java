package com.lynx.tasm.behavior.ui.utils;

import android.renderscript.Matrix4f;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.LLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class n {
    public final int a;
    public final float b;
    public final j c;
    public final int d;
    public final float e;
    public final j f;
    public final int g;
    public final j h;
    public final int i;
    public final float[] j;

    public static boolean a(List<n> r4) {
        if (r4 != null) goto L5;
    L30:
        return false;
    L5:
        if (r4.isEmpty() == true) goto L30;
        Iterator<n> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L30;
        n r1 = r5.next();
        if (r1.d != 1) goto L13;
        boolean r2 = true;
    L14:
        if (r2 == false) goto L16;
    L27:
        boolean r3 = true;
    L28:
        if (r3 == false) goto L9;
        return true;
    L16:
        if (r1.g != 1) goto L18;
        boolean r6 = true;
    L19:
        if (r6 == true) goto L27;
        if (r1.i != 1) goto L23;
        boolean r7 = true;
    L24:
        if (r7 == true) goto L27;
        r3 = false;
        goto L28
    L23:
        r7 = false;
        goto L24
    L18:
        r6 = false;
        goto L19
    L13:
        r2 = false;
        goto L14
    }

    public static float b(List<n> r4) {
        float r0 = 0.0f;
        if (r4 != null) goto L5;
    L18:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L18;
        Iterator<n> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L18;
        n r1 = r5.next();
        int r2 = r1.a;
        if (r2 == 1) goto L17;
        if (r2 == 2) goto L17;
        if (r2 != 16) goto L9;
    L17:
        r0 = r1.c.a();
        goto L9
    }

    public static float c(List<n> r4) {
        float r0 = 0.0f;
        if (r4 != null) goto L5;
    L19:
        return r0;
    L5:
        if (r4.isEmpty() == true) goto L19;
        Iterator<n> r5 = r4.iterator();
    L9:
        if (r5.hasNext() == false) goto L19;
        n r1 = r5.next();
        int r2 = r1.a;
        if (r2 == 1) goto L18;
        if (r2 != 4) goto L15;
        r0 = r1.c.a();
        goto L9
    L15:
        if (r2 != 16) goto L9;
    L18:
        r0 = r1.f.a();
        goto L9
    }

    public static List<n> d(ReadableArray r14) {
        if (r14 != null) goto L4;
        return null;
    L4:
        if (r14.size() <= 0) goto L41;
        ArrayList r0 = new ArrayList();
        int r2 = 0;
    L8:
        if (r2 >= r14.size()) goto L32;
        ReadableArray r3 = r14.getArray(r2);
        if (r3.size() >= 7) goto L12;
        LLog.DTHROW(new IllegalArgumentException("transform params is error."));
    L31:
        r2 = r2 + 1;
        goto L8
    L12:
        int r6 = r3.getInt(0);
        if (r6 != 32768) goto L15;
    L27:
        float[] r4 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f, 0.0f, 0.0f, 0.0f, 0.0f, 0.1f};
        int r7 = 0;
    L28:
        if (r7 >= 16) goto L30;
        int r8 = r7 + 1;
        r4[r7] = (float) r3.getDouble(r8);
        r7 = r8;
        goto L28
    L30:
        r0.add(new n(r6, r4));
        goto L31
    L15:
        if (r6 == 65536) goto L27;
        int r9 = r3.getInt(2);
        int r10 = r3.getInt(4);
        int r12 = r3.getInt(6);
        if (r6 == 1) goto L26;
        if (r6 == 2) goto L26;
        if (r6 == 4) goto L26;
        if (r6 == 8) goto L26;
        if (r6 == 16) goto L26;
        float r11 = (float) r3.getDouble(1);
        float r13 = (float) r3.getDouble(3);
        r3.getDouble(5);
        r0.add(new n(r6, r11, r9, r13, r10, r12));
    L26:
        r0.add(new n(r6, new j(r3.getDynamic(1), r9), r9, new j(r3.getDynamic(3), r10), r10, new j(r3.getDynamic(5), r12), r12));
        goto L31
    L32:
        return r0;
    L41:
        return null;
    }

    public n(int r3, float[] r4) {
        this.a = r3;
        this.c = new j();
        this.b = 0.0f;
        this.d = 0;
        this.f = new j();
        this.e = 0.0f;
        this.g = 0;
        this.h = new j();
        this.i = 0;
        this.j = r4;
    }

    public n(int r1, float r2, int r3, float r4, int r5, int r6) {
        this.a = r1;
        this.c = new j();
        this.b = r2;
        this.d = r3;
        this.f = new j();
        this.e = r4;
        this.g = r5;
        this.h = new j();
        this.i = r6;
        this.j = new Matrix4f().getArray();
    }

    public n(int r1, j r2, int r3, j r4, int r5, j r6, int r7) {
        this.a = r1;
        this.c = r2;
        this.b = 0.0f;
        this.d = r3;
        this.f = r4;
        this.e = 0.0f;
        this.g = r5;
        this.h = r6;
        this.i = r7;
        this.j = new Matrix4f().getArray();
    }
}
