package org.bouncycastle.asn1;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes7.dex */
class LazyConstructionEnumeration implements Enumeration {
    private ASN1InputStream aIn;
    private Object nextObj;

    public LazyConstructionEnumeration(byte[] r3) {
        this.aIn = new ASN1InputStream(r3, true);
        this.nextObj = readObject();
    }

    private Object readObject() {
        return this.aIn.readObject();
    L4:
        e = move-exception;
        throw new ASN1ParsingException("malformed ASN.1: " + e, e);
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        if (this.nextObj == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        Object r0 = this.nextObj;
        if (r0 == null) goto L7;
        this.nextObj = readObject();
        return r0;
    L7:
        throw new NoSuchElementException();
    }
}
