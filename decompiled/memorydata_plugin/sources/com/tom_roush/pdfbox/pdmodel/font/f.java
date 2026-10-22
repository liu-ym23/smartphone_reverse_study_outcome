package com.tom_roush.pdfbox.pdmodel.font;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f {
    public f() {
    }

    public abstract String a();

    public abstract FontFormat b();

    public abstract b c();

    public abstract com.tom_roush.fontbox.b d();

    public abstract int e();

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract v j();

    final int k() {
        int r1 = f();
        if (r1 != 100) goto L5;
        return 2;
    L5:
        if (r1 != 200) goto L7;
        return 3;
    L7:
        if (r1 != 300) goto L9;
        return 4;
    L9:
        if (r1 != 400) goto L11;
        return 5;
    L11:
        if (r1 != 500) goto L13;
        return 6;
    L13:
        if (r1 != 600) goto L15;
        return 7;
    L15:
        if (r1 != 700) goto L17;
        return 8;
    L17:
        if (r1 != 800) goto L19;
        return 9;
    L19:
        if (r1 == 900) goto L22;
        return 0;
    L22:
        return 10;
    }

    final long l() {
        return (((long) g()) & 4294967295L) | ((4294967295L & ((long) h())) << 32);
    }

    public String toString() {
        return a() + " (" + b() + ", mac: 0x" + Integer.toHexString(i()) + ", os/2: 0x" + Integer.toHexString(e()) + ", cid: " + c() + ")";
    }
}
