package com.ctc.wstx.io;

import java.io.IOException;
import java.net.URL;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v {
    protected final v t;
    protected final String u;
    protected int v;
    protected int w;

    public v(v r2, String r3) {
        this.v = 0;
        this.t = r2;
        this.u = r3;
    }

    public abstract WstxInputLocation a(long r1, int r3, int r4);

    public abstract URL a();

    public abstract void a(u r1);

    public final void a(u r1, int r2, int r3) {
        this.v = r2;
        this.w = r3;
        d(r1);
    }

    public abstract boolean a(u r1, int r2);

    public boolean a(String r2) {
        if (r2 == null) goto L9;
    L3:
        if (this == null) goto L13;
        if (r2 == this.u) goto L6;
        v this = this.t;
        goto L3
    L6:
        return true;
    L13:
        return false;
    L9:
        return false;
    }

    public abstract void b(u r1);

    public abstract int c(u r1);

    public abstract String c();

    public abstract WstxInputLocation d();

    public abstract void d(u r1);

    public abstract boolean e();

    public abstract void f();

    public abstract void g();

    public final v h() {
        return this.t;
    }

    public String i() {
        return this.u;
    }

    public int j() {
        return this.v;
    }

    public int k() {
        return this.w;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(80);
        r0.append("<WstxInputSource [class ");
        r0.append(getClass().toString());
        r0.append("]; systemId: ");
        r0.append(c());
        r0.append(", source: ");
        r0.append(a().toString());     // Catch: IOException -> L5
    L7:
        r0.append(Typography.greater);
        return r0.toString();
    L5:
        e = move-exception;
        r0.append("[ERROR: " + e.getMessage() + "]");
        goto L7
    }
}
