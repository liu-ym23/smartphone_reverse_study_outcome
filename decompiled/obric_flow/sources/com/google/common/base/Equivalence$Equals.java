package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Equivalence$Equals extends p implements Serializable {
    static final Equivalence$Equals INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new Equivalence$Equals();
    }

    public Equivalence$Equals() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.p
    public boolean doEquivalent(Object r5, Object r10) {
        return r5.equals(r10);
    }

    @Override // com.google.common.base.p
    public int doHash(Object r5) {
        return r5.hashCode();
    }
}
