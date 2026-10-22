package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class OIDTokenizer {
    private int index;
    private String oid;

    public OIDTokenizer(String r1) {
        this.oid = r1;
        this.index = 0;
    }

    public boolean hasMoreTokens() {
        if (this.index == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public String nextToken() {
        int r0 = this.index;
        if (r0 != (-1)) goto L6;
        return null;
    L6:
        int r1 = this.oid.indexOf(46, r0);
        if (r1 != (-1)) goto L10;
        String r2 = this.oid.substring(this.index);
        this.index = -1;
        return r2;
    L10:
        String r3 = this.oid.substring(this.index, r1);
        this.index = r1 + 1;
        return r3;
    }
}
