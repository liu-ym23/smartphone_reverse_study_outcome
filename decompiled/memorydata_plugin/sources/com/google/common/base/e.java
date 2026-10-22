package com.google.common.base;

/* JADX INFO: loaded from: classes2.dex */
abstract class e {
    e() {
    }

    public static e compile(String r0) {
        return m.c(r0);
    }

    public static boolean isPcreLike() {
        return m.a();
    }

    public abstract int flags();

    public abstract d matcher(CharSequence r1);

    public abstract String pattern();

    public abstract String toString();
}
