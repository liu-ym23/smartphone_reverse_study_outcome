package org.bouncycastle.i18n;

import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class LocalizedException extends Exception {
    private Throwable cause;
    protected ErrorBundle message;

    public LocalizedException(ErrorBundle r2) {
        super(r2.getText(Locale.getDefault()));
        this.message = r2;
    }

    public LocalizedException(ErrorBundle r2, Throwable r3) {
        super(r2.getText(Locale.getDefault()));
        this.message = r2;
        this.cause = r3;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public ErrorBundle getErrorMessage() {
        return this.message;
    }
}
