package com.loc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class bf {
    bf c;
    byte[] d;

    bf() {
        this.d = null;
    }

    bf(bf r2) {
        this.d = null;
        this.c = r2;
    }

    public final byte[] a() {
        byte[] r0 = a(this.d);
        bf r1 = this.c;
        if (r1 == null) goto L6;
        r1.d = r0;
        return r1.a();
    L6:
        return r0;
    }

    public abstract byte[] a(byte[] r1);

    public void b(byte[] r1) {
    }
}
