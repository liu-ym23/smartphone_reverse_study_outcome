package org.bouncycastle.util.encoders;

/* JADX INFO: loaded from: classes7.dex */
public class EncoderException extends IllegalStateException {
    private Throwable cause;

    EncoderException(String r1, Throwable r2) {
        super(r1);
        this.cause = r2;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
