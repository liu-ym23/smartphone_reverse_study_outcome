package com.obric.oui.orecyclerview.widget;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f13787c;
    public int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r10 = (a) r5;
        int r11 = this.f13785a;
        if (r11 == r10.f13785a) goto L12;
        return false;
    L12:
        if (r11 != 8) goto L21;
        if (Math.abs(this.d - this.f13786b) != 1) goto L21;
        if (this.d != r10.f13786b) goto L21;
        if (this.f13786b != r10.d) goto L21;
        return true;
    L21:
        if (this.d == r10.d) goto L24;
        return false;
    L24:
        if (this.f13786b == r10.f13786b) goto L26;
        return false;
    L26:
        Object r12 = this.f13787c;
        if (r12 == null) goto L32;
        if (r12.equals(r10.f13787c) == true) goto L34;
        return false;
    L34:
        return true;
    L32:
        if (r10.f13787c == null) goto L34;
        return false;
    }

    public final int hashCode() {
        return (((this.f13785a * 31) + this.f13786b) * 31) + this.d;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder();
        r5.append(Integer.toHexString(System.identityHashCode(this)));
        r5.append("[");
        int r10 = this.f13785a;
        if (r10 != 1) goto L5;
        String r11 = "add";
    L15:
        r5.append(r11);
        r5.append(",s:");
        r5.append(this.f13786b);
        r5.append("c:");
        r5.append(this.d);
        r5.append(",p:");
        r5.append(this.f13787c);
        r5.append("]");
        return r5.toString();
    L5:
        if (r10 != 2) goto L7;
        r11 = "rm";
        goto L15
    L7:
        if (r10 != 4) goto L9;
        r11 = "up";
        goto L15
    L9:
        if (r10 == 8) goto L11;
        r11 = "??";
        goto L15
    L11:
        r11 = "mv";
        goto L15
    }
}
