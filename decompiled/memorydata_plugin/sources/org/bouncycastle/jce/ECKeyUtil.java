package org.bouncycastle.jce;

/* JADX INFO: loaded from: classes7.dex */
public class ECKeyUtil {

    private static class UnexpectedException extends RuntimeException {
        private Throwable cause;

        UnexpectedException(Throwable r2) {
            super(r2.toString());
            this.cause = r2;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }
}
