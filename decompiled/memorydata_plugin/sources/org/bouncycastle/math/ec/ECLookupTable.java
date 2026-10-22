package org.bouncycastle.math.ec;

/* JADX INFO: loaded from: classes7.dex */
public interface ECLookupTable {
    int getSize();

    ECPoint lookup(int r1);

    ECPoint lookupVar(int r1);
}
