package com.loc;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import n4a.a5;
import n4a.f5;
import n4a.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a extends a5 {
    public final byte[] k;
    public final String l;

    @Override // com.loc.bo
    public final Map<String, String> a() {
        HashMap r0 = new HashMap();
        r0.put("Content-Type", "application/zip");
        r0.put("Content-Length", String.valueOf(this.k.length));
        return r0;
    }

    @Override // com.loc.bo
    public final boolean g() {
        return false;
    }

    @Override // com.loc.bo
    public final Map<String, String> h() {
        return null;
    }

    @Override // com.loc.bo
    public final byte[] i() {
        return this.k;
    }

    @Override // com.loc.bo
    public final String c() {
        byte[] r0 = n4a.c.a;
        String r1 = f5.o("IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz");
        Object[] r2 = new Object[5];
        r2[0] = "1";
        r2[1] = this.l;
        r2[2] = "1";
        r2[3] = "open";
        byte[] r3 = f5.j("9aj&#k81");
        byte[] r4 = new byte[r3.length + 50];
        System.arraycopy(this.k, 0, r4, 0, 50);
        System.arraycopy(r3, 0, r4, 50, r3.length);
        String r5 = null;
        MessageDigest r6 = MessageDigest.getInstance(f5.o("ETUQ1"));     // Catch: Throwable -> L5
        r6.update(r4);     // Catch: Throwable -> L5
        byte[] r7 = r6.digest();     // Catch: Throwable -> L5
    L13:
        r5 = f5.s(r7);     // Catch: Throwable -> L9
    L11:
        r2[4] = r5;
        return String.format(r1, r2);
    L9:
        th = move-exception;
        n.a(th, "ut", "h2s");
    L5:
        th = move-exception;
        n.a(th, "MD5", "gmb");
        r7 = null;
        goto L13
    }

    public a(byte[] r2, String r3) {
        this.l = "1";
        this.k = (byte[]) r2.clone();
        this.l = r3;
        this.i = bo.a.e;
        b(bo.c.a);
    }
}
