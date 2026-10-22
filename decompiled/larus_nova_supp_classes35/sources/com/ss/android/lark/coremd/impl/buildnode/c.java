package com.ss.android.lark.coremd.impl.buildnode;

import java.util.Comparator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c<T> implements Comparator {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r3, Object r4) {
        b.C0186b r5 = (b.C0186b) r3;
        b.C0186b r6 = (b.C0186b) r4;
        int r0 = r5.b;
        int r1 = r6.b;
        int r7 = r5.c;
        int r8 = r6.c;
        if (r0 == r1) goto L6;
        return r0 - r1;
    L6:
        return r8 - r7;
    }
}
