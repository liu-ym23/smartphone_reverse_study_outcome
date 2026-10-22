package com.ss.android.lark.commonmark.internal;

import java.util.List;
import v7b.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public final List<b0> a;
    public final char b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public f f;
    public f g;

    public final int c() {
        return this.a.size();
    }

    public final Iterable<b0> a(int r4) {
        if (r4 < 1) goto L9;
        if (r4 > c()) goto L9;
        return this.a.subList(0, r4);
    L9:
        throw new IllegalArgumentException("length must be between 1 and " + c() + ", was " + r4);
    }

    public final Iterable<b0> b(int r4) {
        if (r4 < 1) goto L9;
        if (r4 > c()) goto L9;
        List<b0> r0 = this.a;
        return r0.subList(r0.size() - r4, this.a.size());
    L9:
        throw new IllegalArgumentException("length must be between 1 and " + c() + ", was " + r4);
    }

    public f(List<b0> r1, char r2, boolean r3, boolean r4, f r5) {
        this.a = r1;
        this.b = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.c = r1.size();
    }
}
