package org.bouncycastle.pqc.math.ntru.parameters;

/* JADX INFO: loaded from: classes7.dex */
public abstract class NTRUParameterSet {
    private final int logQ;
    private final int n;
    private final int prfKeyBytes;
    private final int seedBytes;
    private final int sharedKeyBytes;

    public NTRUParameterSet(int r1, int r2, int r3, int r4, int r5) {
        this.n = r1;
        this.logQ = r2;
        this.seedBytes = r3;
        this.prfKeyBytes = r4;
        this.sharedKeyBytes = r5;
    }
}
