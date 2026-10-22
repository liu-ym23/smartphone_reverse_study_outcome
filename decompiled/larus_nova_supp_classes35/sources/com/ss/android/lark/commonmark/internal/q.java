package com.ss.android.lark.commonmark.internal;

import v7b.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class q extends y7b.a {
    public final v7b.q a;
    public final int b;
    public boolean c;

    @Override // y7b.a, y7b.d
    public final boolean isContainer() {
        return true;
    }

    @Override // y7b.d
    public final v7b.a a() {
        return this.a;
    }

    @Override // y7b.a, y7b.d
    public final boolean g(v7b.a r2) {
        if (this.c == false) goto L9;
        v7b.a r3 = (v7b.a) this.a.d;
        if ((r3 instanceof v7b.p) == false) goto L10;
        ((v7b.p) r3).getClass();
        return true;
    L10:
        return true;
    L9:
        return true;
    }

    @Override // y7b.d
    public final y7b.c h(y7b.g r5) {
        h r6 = (h) r5;
        boolean r1 = false;
        if (r6.i == true) goto L5;
        int r0 = r6.h;
        int r3 = this.b;
        if (r0 >= r3) goto L17;
        return null;
    L17:
        return new b(-1, r6.d + r3, false);
    L5:
        if (this.a.e != null) goto L7;
        return null;
    L7:
        v7b.a r2 = r6.h().a();
        if ((r2 instanceof v) == false) goto L10;
    L11:
        r1 = true;
    L12:
        this.c = r1;
        return y7b.c.a(r6.f);
    L10:
        if ((r2 instanceof v7b.q) == false) goto L12;
        goto L11
    }

    public q(int r1, int r2, Integer r3) {
        v7b.q r4 = new v7b.q();
        this.a = r4;
        this.b = r2;
        r4.j = r3;
    }
}
