package com.ctc.wstx.d;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    public ah() {
    }

    public final String a(String r2) {
        StringBuilder r0 = new StringBuilder();
        a(r0, r2);
        return r0.toString();
    }

    public abstract void a(StringBuilder r1, String r2);

    public abstract boolean a();

    public abstract boolean a(com.ctc.wstx.util.h r1);

    public final String toString() {
        return a(", ");
    }
}
