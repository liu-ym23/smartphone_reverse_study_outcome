package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractECLookupTable implements ECLookupTable {
    public AbstractECLookupTable() {
    }

    @Override // org.bouncycastle.math.ec.ECLookupTable
    public ECPoint lookupVar(int r1) {
        return lookup(r1);
    }
}
