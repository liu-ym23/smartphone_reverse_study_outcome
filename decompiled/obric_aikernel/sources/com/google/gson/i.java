package com.google.gson;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    @Deprecated
    public i() {
    }

    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public f d() {
        if (i() == false) goto L7;
        return (f) this;
    L7:
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public k e() {
        if (k() == false) goto L7;
        return (k) this;
    L7:
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public m f() {
        if (l() == false) goto L7;
        return (m) this;
    L7:
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean i() {
        return this instanceof f;
    }

    public boolean j() {
        return this instanceof j;
    }

    public boolean k() {
        return this instanceof k;
    }

    public boolean l() {
        return this instanceof m;
    }

    public String toString() {
        StringWriter r10 = new StringWriter();     // Catch: IOException -> L4
        com.google.gson.stream.a r11 = new com.google.gson.stream.a(r10);     // Catch: IOException -> L4
        r11.K(true);     // Catch: IOException -> L4
        com.google.gson.internal.j.b(this, r11);     // Catch: IOException -> L4
        return r10.toString();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
