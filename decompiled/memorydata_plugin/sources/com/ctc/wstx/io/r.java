package com.ctc.wstx.io;

import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected URL f3539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f3540b;

    public r(String r1, URL r2) {
        if (r1 != null) goto L8;
        if (r2 != null) goto L8;
        throw new IllegalArgumentException("Can not pass null for both systemId and url");
    L8:
        this.f3540b = r1;
        this.f3539a = r2;
    }

    public static r a(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new r(r2, null);
    }

    public static r a(String r1, URL r2) {
        if (r1 != null) goto L7;
        if (r2 != null) goto L7;
        return null;
    L7:
        return new r(r1, r2);
    }

    public static r a(URL r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new r(null, r2);
    }

    public URL a() {
        if (this.f3539a != null) goto L6;
        this.f3539a = com.ctc.wstx.util.n.a(this.f3540b);
    L6:
        return this.f3539a;
    }

    public String toString() {
        if (this.f3540b != null) goto L6;
        this.f3540b = this.f3539a.toExternalForm();
    L6:
        return this.f3540b;
    }
}
