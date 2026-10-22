package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class bl {
    bl c;

    public bl() {
    }

    public bl(bl r1) {
        this.c = r1;
    }

    public void a(int r1) {
        bl r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public void a(boolean r1) {
        bl r0 = this.c;
        if (r0 == null) goto L6;
        r0.a(r1);
        return;
    }

    public abstract boolean a();

    public int b() {
        bl r1 = this.c;
        if (r1 == null) goto L5;
        int r2 = r1.b();
    L7:
        return Math.min(Integer.MAX_VALUE, r2);
    L5:
        r2 = Integer.MAX_VALUE;
        goto L7
    }

    public final boolean c() {
        bl r0 = this.c;
        if (r0 == null) goto L5;
        boolean r1 = r0.c();
    L6:
        if (r1 == true) goto L10;
        return false;
    L10:
        return a();
    L5:
        r1 = true;
        goto L6
    }
}
