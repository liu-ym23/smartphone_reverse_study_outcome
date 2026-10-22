package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class Equivalence$Identity extends p implements Serializable {
    static final Equivalence$Identity INSTANCE = null;
    private static final long serialVersionUID = 1;

    static {
        INSTANCE = new Equivalence$Identity();
    }

    public Equivalence$Identity() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.base.p
    public boolean doEquivalent(Object r5, Object r10) {
        return false;
    }

    @Override // com.google.common.base.p
    public int doHash(Object r5) {
        return System.identityHashCode(r5);
    }
}
