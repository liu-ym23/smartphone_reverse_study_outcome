package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
public class ASN1ParsingException extends IllegalStateException {
    private Throwable cause;

    public ASN1ParsingException(String r1) {
        super(r1);
    }

    public ASN1ParsingException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
