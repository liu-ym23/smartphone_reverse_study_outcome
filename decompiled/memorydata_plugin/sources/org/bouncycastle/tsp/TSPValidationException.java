package org.bouncycastle.tsp;

/* JADX INFO: loaded from: classes7.dex */
public class TSPValidationException extends TSPException {
    private int failureCode;

    public TSPValidationException(String r1) {
        super(r1);
        this.failureCode = -1;
    }

    public TSPValidationException(String r1, int r2) {
        super(r1);
        this.failureCode = -1;
        this.failureCode = r2;
    }

    public int getFailureCode() {
        return this.failureCode;
    }
}
