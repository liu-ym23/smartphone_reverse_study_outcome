package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes3.dex */
public final class a1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13790c;
    public int d;
    public int e;

    public final boolean a() {
        int r5 = this.f13788a;
        int r10 = 2;
        if ((r5 & 7) == 0) goto L14;
        int r11 = this.d;
        int r12 = this.f13789b;
        if (r11 <= r12) goto L7;
        int r13 = 1;
    L11:
        if ((r13 & r5) != 0) goto L14;
        return false;
    L7:
        if (r11 != r12) goto L9;
        r13 = 2;
        goto L11
    L9:
        r13 = 4;
    L14:
        if ((r5 & 112) == 0) goto L25;
        int r14 = this.d;
        int r15 = this.f13790c;
        if (r14 <= r15) goto L18;
        int r16 = 1;
    L22:
        if (((r16 << 4) & r5) != 0) goto L25;
        return false;
    L18:
        if (r14 != r15) goto L20;
        r16 = 2;
        goto L22
    L20:
        r16 = 4;
    L25:
        if ((r5 & 1792) == 0) goto L36;
        int r17 = this.e;
        int r18 = this.f13789b;
        if (r17 <= r18) goto L29;
        int r19 = 1;
    L33:
        if (((r19 << 8) & r5) != 0) goto L36;
        return false;
    L29:
        if (r17 != r18) goto L31;
        r19 = 2;
        goto L33
    L31:
        r19 = 4;
    L36:
        if ((r5 & 28672) == 0) goto L46;
        int r20 = this.e;
        int r21 = this.f13790c;
        if (r20 <= r21) goto L40;
        r10 = 1;
    L44:
        if (((r10 << 12) & r5) != 0) goto L46;
        return false;
    L40:
        if (r20 == r21) goto L44;
        r10 = 4;
    L46:
        return true;
    }
}
