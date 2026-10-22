package com.squareup.javapoet;

/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f15000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f15002c;
    public final StringBuilder d;
    public int e;
    public int f;
    public LineWrapper$FlushType g;

    public r(Appendable r5, String r10) {
        this.d = new StringBuilder();
        this.e = 0;
        this.f = -1;
        com.bytedance.android.anniex.base.service.f.s(r5, "out == null", new Object[0]);
        this.f15000a = new q(r5);
        this.f15001b = r10;
        this.f15002c = 100;
    }

    public final void a(String r10) {
        if (this.g == null) goto L17;
        int r5 = r10.indexOf(10);
        int r11 = this.f15002c;
        if (r5 == (-1)) goto L7;
    L10:
        if (r5 != (-1)) goto L12;
    L15:
        LineWrapper$FlushType r12 = LineWrapper$FlushType.WRAP;
    L16:
        b(r12);
        goto L17
    L12:
        if ((this.e + r5) > r11) goto L15;
        r12 = this.g;
        goto L16
    L7:
        if ((r10.length() + this.e) > r11) goto L10;
        this.d.append(r10);
        this.e = r10.length() + this.e;
        return;
    L17:
        this.f15000a.append(r10);
        int r13 = r10.lastIndexOf(10);
        if (r13 == (-1)) goto L20;
        int r14 = (r10.length() - r13) - 1;
    L21:
        this.e = r14;
        return;
    L20:
        r14 = r10.length() + this.e;
        goto L21
    }

    public final void b(LineWrapper$FlushType r10) {
        int r5 = p.f14997a[r10.ordinal()];
        StringBuilder r11 = this.d;
        q r12 = this.f15000a;
        if (r5 != 1) goto L5;
        r12.append('\n');
        int r13 = 0;
    L13:
        int r14 = this.f;
        String r15 = this.f15001b;
        if (r13 >= r14) goto L16;
        r12.append(r15);
        r13 = r13 + 1;
        goto L13
    L16:
        int r16 = r15.length() * r14;
        this.e = r16;
        this.e = r11.length() + r16;
    L17:
        r12.append(r11);
        r11.delete(0, r11.length());
        this.f = -1;
        this.g = null;
        return;
    L5:
        if (r5 != 2) goto L7;
        r12.append(' ');
        goto L17
    L7:
        if (r5 == 3) goto L17;
        throw new IllegalArgumentException("Unknown FlushType: " + r10);
    }
}
