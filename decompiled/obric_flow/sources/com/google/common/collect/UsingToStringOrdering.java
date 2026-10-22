package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class UsingToStringOrdering extends g8 implements Serializable {
    static final UsingToStringOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    static {
        INSTANCE = new UsingToStringOrdering();
    }

    private UsingToStringOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(Object r5, Object r10) {
        return r5.toString().compareTo(r10.toString());
    }

    public String toString() {
        return "Ordering.usingToString()";
    }
}
