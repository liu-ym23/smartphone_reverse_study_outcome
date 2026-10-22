package org.bouncycastle.asn1;

import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1Exception extends IOException {
    private Throwable cause;

    ASN1Exception(String r1) {
        super(r1);
    }

    ASN1Exception(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
