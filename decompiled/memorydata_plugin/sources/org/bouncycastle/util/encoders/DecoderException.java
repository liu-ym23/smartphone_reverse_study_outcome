package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes7.dex */
public class DecoderException extends IllegalStateException {
    private Throwable cause;

    DecoderException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
