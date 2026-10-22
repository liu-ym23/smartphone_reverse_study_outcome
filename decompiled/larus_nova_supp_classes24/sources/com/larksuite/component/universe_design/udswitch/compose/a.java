package com.larksuite.component.universe_design.udswitch.compose;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;

    public final long a(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return this.a;
    L5:
        if (r1 == true) goto L12;
        if (r2 == false) goto L10;
        return this.b;
    L10:
        return this.d;
    L12:
        return this.c;
    }

    public final long b(boolean r1, boolean r2) {
        if (r1 == false) goto L5;
        if (r2 == false) goto L5;
        return this.e;
    L5:
        if (r1 == true) goto L12;
        if (r2 == false) goto L10;
        return this.f;
    L10:
        return this.h;
    L12:
        return this.g;
    }

    public a(long r4, long r6, long r8, long r10, long r12, long r14, long r16, long r19) {
        this.a = r4;
        this.b = r6;
        this.c = r8;
        this.d = r10;
        this.e = r12;
        this.f = r14;
        this.g = r16;
        this.h = r19;
    }
}
