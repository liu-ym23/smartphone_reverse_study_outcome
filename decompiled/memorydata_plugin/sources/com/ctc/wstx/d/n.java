package com.ctc.wstx.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URI;

/* JADX INFO: loaded from: classes2.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final String f3495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final URI f3496b;
    protected final int c;
    protected final boolean d;
    protected int e;

    private n(String r2, URI r3, int r4, boolean r5) {
        this.e = 0;
        this.f3495a = r2;
        this.f3496b = r3;
        this.c = r4;
        this.d = r5;
    }

    public static n a(String r2, URI r3, int r4, boolean r5) {
        if (r2 != null) goto L5;
    L8:
        if (r3 == null) goto L12;
        return new n(null, r3, r4, r5);
    L12:
        throw new IllegalArgumentException("Illegal arguments; both public and system id null/empty.");
    L5:
        if (r2.length() <= 0) goto L8;
        return new n(r2, null, r4, r5);
    }

    public static n a(URI r2, int r3, boolean r4) {
        if (r2 == null) goto L6;
        return new n(null, r2, r3, r4);
    L6:
        throw new IllegalArgumentException("Null system id.");
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L26:
        return false;
    L8:
        if (r5.getClass() != getClass()) goto L26;
        n r6 = (n) ZeusTransformUtils.preCheckCast(r5, n.class, "com.obric.memorydata.plugin");
        if (r6.c != this.c) goto L26;
        if (r6.d != this.d) goto L26;
        String r2 = this.f3495a;
        if (r2 == null) goto L25;
        String r4 = r6.f3495a;
        if (r4 == null) goto L23;
        if (r4.equals(r2) == false) goto L23;
        return true;
    L23:
        return false;
    L25:
        return this.f3496b.equals(r6.f3496b);
    }

    public int hashCode() {
        int r0 = this.e;
        if (r0 != 0) goto L12;
        int r1 = this.c;
        String r2 = this.f3495a;
        if (r2 == null) goto L7;
        int r3 = r2.hashCode();
    L8:
        r0 = r1 ^ r3;
        if (this.d == false) goto L11;
        r0 = r0 ^ 1;
    L11:
        this.e = r0;
        goto L12
    L7:
        r3 = this.f3496b.hashCode();
    L12:
        return r0;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer(60);
        r0.append("Public-id: ");
        r0.append(this.f3495a);
        r0.append(", system-id: ");
        r0.append(this.f3496b);
        r0.append(" [config flags: 0x");
        r0.append(Integer.toHexString(this.c));
        r0.append("], xml11: ");
        r0.append(this.d);
        return r0.toString();
    }
}
