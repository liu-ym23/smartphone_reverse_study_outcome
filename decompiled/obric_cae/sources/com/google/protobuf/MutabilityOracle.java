package com.google.protobuf;

/* JADX INFO: loaded from: classes.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = null;

    static {
        IMMUTABLE = new AnonymousClass1();
    }

    void ensureMutable();
}
