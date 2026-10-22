package com.lynx.tasm.behavior.ui.utils;

import android.renderscript.Matrix4f;
import com.lynx.tasm.base.LLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class m {
    public float a;
    public float b;
    public final LinkedHashMap<String, Float> c;

    public final float c() {
        Float r0 = this.c.get("rotate");
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.floatValue();
    }

    public final float d() {
        Float r0 = this.c.get("rotateX");
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.floatValue();
    }

    public final float e() {
        Float r0 = this.c.get("rotateY");
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.floatValue();
    }

    public final float f() {
        Float r0 = this.c.get("scaleX");
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.floatValue();
    }

    public final float g() {
        Float r0 = this.c.get("scaleY");
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.floatValue();
    }

    public final float h() {
        Float r0 = this.c.get("translateX");
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.floatValue();
    }

    public final float i() {
        Float r0 = this.c.get("translateY");
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.floatValue();
    }

    public final float j() {
        Float r0 = this.c.get("translateZ");
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return r0.floatValue();
    }

    public m() {
        LinkedHashMap<String, Float> r0 = new LinkedHashMap();
        this.c = r0;
        r0.clear();
    }

    public static double[] b(float[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        double[] r0 = new double[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0[r1] = r4[r1];
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public final void l(com.lynx.tasm.utils.h.a r7) {
        float r0 = com.lynx.tasm.utils.b.b((float) r7.d[0]);
        this.c.put("translateX", Float.valueOf(r0));
        float r1 = com.lynx.tasm.utils.b.b((float) r7.d[1]);
        this.c.put("translateY", Float.valueOf(r1));
        float r2 = com.lynx.tasm.utils.b.b((float) r7.d[2]);
        this.c.put("translateZ", Float.valueOf(r2));
        float r3 = com.lynx.tasm.utils.b.b((float) r7.e[2]);
        this.c.put("rotate", Float.valueOf(r3));
        float r4 = com.lynx.tasm.utils.b.b((float) r7.e[0]);
        this.c.put("rotateX", Float.valueOf(r4));
        float r5 = com.lynx.tasm.utils.b.b((float) r7.e[1]);
        this.c.put("rotateY", Float.valueOf(r5));
        float r6 = com.lynx.tasm.utils.b.b((float) r7.b[0]);
        this.c.put("scaleX", Float.valueOf(r6));
        float r8 = com.lynx.tasm.utils.b.b((float) r7.b[1]);
        this.c.put("scaleY", Float.valueOf(r8));
    }

    public final void m(float r4) {
        this.c.put("skewX", Float.valueOf((float) Math.tan(r4)));
    }

    public final void n(float r4) {
        this.c.put("skewY", Float.valueOf((float) Math.tan(r4)));
    }

    public static float a(n r3, int r4, float r5) {
        boolean r0 = false;
        if (r4 != 0) goto L9;
        float r6 = r3.c.b(r5);
        if (r3.d != 1) goto L7;
        r0 = true;
    L7:
        if (r0 == false) goto L25;
        int r7 = Math.round(r6);
    L28:
        return r7;
    L25:
        return r6;
    L9:
        if (r4 != 1) goto L16;
        float r8 = r3.f.b(r5);
        if (r3.g != 1) goto L13;
        r0 = true;
    L13:
        if (r0 == false) goto L26;
        r7 = Math.round(r8);
        goto L28
    L26:
        return r8;
    L16:
        if (r4 != 2) goto L23;
        float r9 = r3.h.b(r5);
        if (r3.i != 1) goto L20;
        r0 = true;
    L20:
        if (r0 == false) goto L27;
        r7 = Math.round(r9);
        goto L28
    L27:
        return r9;
    L23:
        return 0.0f;
    }

    public static m k(List r12, int r13, int r14) {
        m r0 = new m();
        if (r12 != null) goto L5;
    L31:
        return r0;
    L5:
        if (r12.isEmpty() == true) goto L31;
        Iterator r15 = r12.iterator();
    L9:
        if (r15.hasNext() == false) goto L31;
        n r1 = (n) r15.next();
        int r2 = r1.a;
        if (r2 == 1) goto L30;
        if (r2 != 2) goto L14;
        r0.c.put("translateX", Float.valueOf(a(r1, 0, r13)));
        goto L9
    L14:
        switch(r2) {
            case 4: goto L28;
            case 8: goto L27;
            case 16: goto L30;
            case 32: goto L26;
            case 64: goto L25;
            case 128: goto L24;
            case 256: goto L26;
            case 512: goto L23;
            case 1024: goto L22;
            case 2048: goto L21;
            case 4096: goto L20;
            case 8192: goto L19;
            case 16384: goto L18;
            case 32768: goto L17;
            case 65536: goto L17;
            default: goto L15;
        };
    L15:
        LLog.DTHROW();
        return null;
    L18:
        r0.n((float) com.lynx.tasm.utils.h.b(r1.b));
        goto L9
    L19:
        r0.m((float) com.lynx.tasm.utils.h.b(r1.b));
        goto L9
    L20:
        r0.m((float) com.lynx.tasm.utils.h.b(r1.b));
        r0.n((float) com.lynx.tasm.utils.h.b(r1.e));
        goto L9
    L21:
        r0.c.put("scaleY", Float.valueOf(r1.b));
        goto L9
    L22:
        r0.c.put("scaleX", Float.valueOf(r1.b));
        goto L9
    L23:
        r0.c.put("scaleX", Float.valueOf(r1.b));
        r0.c.put("scaleY", Float.valueOf(r1.e));
        goto L9
    L24:
        r0.c.put("rotateY", Float.valueOf(r1.b));
        goto L9
    L25:
        r0.c.put("rotateX", Float.valueOf(r1.b));
        goto L9
    L26:
        r0.c.put("rotate", Float.valueOf(r1.b));
        goto L9
    L27:
        r0.c.put("translateZ", Float.valueOf(a(r1, 0, 0.0f)));
        goto L9
    L28:
        r0.c.put("translateY", Float.valueOf(a(r1, 0, r14)));
        goto L9
    L17:
        Matrix4f r3 = new Matrix4f(r1.j);
        com.lynx.tasm.utils.h.a r4 = new com.lynx.tasm.utils.h.a();
        r4.a();
        com.lynx.tasm.utils.h.a(b(r3.getArray()), r4);
        r0.l(r4);
    L30:
        r0.c.put("translateX", Float.valueOf(a(r1, 0, r13)));
        r0.c.put("translateY", Float.valueOf(a(r1, 1, r14)));
        r0.c.put("translateZ", Float.valueOf(a(r1, 2, 0.0f)));
        goto L9
    }
}
