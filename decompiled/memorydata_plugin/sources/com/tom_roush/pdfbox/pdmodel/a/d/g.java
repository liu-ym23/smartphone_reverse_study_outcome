package com.tom_roush.pdfbox.pdmodel.a.d;

import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public abstract class g extends com.tom_roush.pdfbox.pdmodel.a.a.a {
    protected static final float ak = -1.0f;

    public g() {
    }

    public g(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
    }

    public float a(String r1, float r2) {
        return a().b(r1, r2);
    }

    public int a(String r1, int r2) {
        return a().b(r1, r2);
    }

    public void a(String r3, c r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r3);
        a().a(r3, r4);
        if (r4 != null) goto L5;
        com.tom_roush.pdfbox.a.b r5 = null;
    L6:
        a(r0, r5);
        return;
    L5:
        r5 = r4.e();
        goto L6
    }

    public void a(String r3, com.tom_roush.pdfbox.pdmodel.graphics.b.f r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r3);
        a().a(r3, r4);
        if (r4 != null) goto L5;
        com.tom_roush.pdfbox.a.b r5 = null;
    L6:
        a(r0, r5);
        return;
    L5:
        r5 = r4.e();
        goto L6
    }

    public void a(String r3, String r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r3);
        a().b(r3, r4);
        a(r0, a().a(r3));
    }

    public void a(String r6, float[] r7) {
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        r0.a(new com.tom_roush.pdfbox.a.f(r7[r2]));
        r2 = r2 + 1;
        goto L3
    L5:
        com.tom_roush.pdfbox.a.b r8 = a().a(r6);
        a().a(r6, r0);
        a(r8, a().a(r6));
    }

    public void a(String r7, String[] r8) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r7);
        com.tom_roush.pdfbox.a.a r1 = new com.tom_roush.pdfbox.a.a();
        int r2 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1.a(new o(r8[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        a().a(r7, r1);
        a(r0, a().a(r7));
    }

    public Object b(String r4, float r5) {
        com.tom_roush.pdfbox.a.b r3 = a().a(r4);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.a.class) == false) goto L13;
        com.tom_roush.pdfbox.a.a r6 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        float[] r7 = new float[r6.b()];
        int r8 = 0;
    L6:
        if (r8 >= r6.b()) goto L11;
        com.tom_roush.pdfbox.a.b r1 = r6.a(r8);
        if (ZeusTransformUtils.instanceOf(r1, k.class) == false) goto L10;
        r7[r8] = ((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.memorydata.plugin")).a();
    L10:
        r8 = r8 + 1;
        goto L6
    L11:
        return r7;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, k.class) == false) goto L17;
        return Float.valueOf(((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.memorydata.plugin")).a());
    L17:
        if (r5 != (-1.0f)) goto L21;
        return null;
    L21:
        return Float.valueOf(r5);
    }

    public String b(String r1, String r2) {
        return a().c(r1, r2);
    }

    public void b(String r3, int r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r3);
        a().a(r3, r4);
        a(r0, a().a(r3));
    }

    public void b(String r6, String[] r7) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r6);
        com.tom_roush.pdfbox.a.a r1 = new com.tom_roush.pdfbox.a.a();
        int r2 = r7.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1.a(com.tom_roush.pdfbox.a.i.a(r7[r3]));
        r3 = r3 + 1;
        goto L3
    L5:
        a().a(r6, r1);
        a(r0, a().a(r6));
    }

    public Object c(String r4, String r5) {
        com.tom_roush.pdfbox.a.b r3 = a().a(r4);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.a.class) == false) goto L13;
        com.tom_roush.pdfbox.a.a r6 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        String[] r7 = new String[r6.b()];
        int r8 = 0;
    L6:
        if (r8 >= r6.b()) goto L11;
        com.tom_roush.pdfbox.a.b r1 = r6.a(r8);
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.i.class) == false) goto L10;
        r7[r8] = ((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a();
    L10:
        r8 = r8 + 1;
        goto L6
    L11:
        return r7;
    L13:
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.i.class) == true) goto L15;
        return r5;
    L15:
        return ((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a();
    }

    public void c(String r3, float r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r3);
        a().a(r3, r4);
        a(r0, a().a(r3));
    }

    public void c(String r3, int r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r3);
        a().a(r3, r4);
        a(r0, a().a(r3));
    }

    public void d(String r3, String r4) {
        com.tom_roush.pdfbox.a.b r0 = a().a(r3);
        a().a(r3, r4);
        a(r0, a().a(r3));
    }

    public Object e(String r2, String r3) {
        com.tom_roush.pdfbox.a.b r1 = a().a(r2);
        if (ZeusTransformUtils.instanceOf(r1, k.class) == false) goto L7;
        return Float.valueOf(((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.memorydata.plugin")).a());
    L7:
        if (ZeusTransformUtils.instanceOf(r1, com.tom_roush.pdfbox.a.i.class) == true) goto L9;
        return r3;
    L9:
        return ((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r1, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a();
    }

    public boolean p(String r1) {
        if (a().a(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public String q(String r1) {
        return a().c(r1);
    }

    public String[] r(String r5) {
        com.tom_roush.pdfbox.a.b r4 = a().a(r5);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.a.class) == false) goto L9;
        com.tom_roush.pdfbox.a.a r6 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        String[] r7 = new String[r6.b()];
        int r1 = 0;
    L6:
        if (r1 >= r6.b()) goto L8;
        r7[r1] = ((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r6.a(r1), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a();
        r1 = r1 + 1;
        goto L6
    L8:
        return r7;
    L9:
        return null;
    }

    public String s(String r1) {
        return a().b(r1);
    }

    public float t(String r1) {
        return a().d(r1);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f u(String r2) {
        com.tom_roush.pdfbox.a.a r1 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(a().a(r2), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        return new com.tom_roush.pdfbox.pdmodel.graphics.b.f(r1);
    }

    public Object v(String r3) {
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(a().a(r3), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.b() != 3) goto L10;
        return new com.tom_roush.pdfbox.pdmodel.graphics.b.f(r2);
    L10:
        if (r2.b() == 4) goto L12;
        return null;
    L12:
        return new c(r2);
    }
}
