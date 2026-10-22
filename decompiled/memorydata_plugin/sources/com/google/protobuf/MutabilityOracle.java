package com.google.protobuf;

/* JADX INFO: loaded from: classes3.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = null;

    static {
        IMMUTABLE = new AnonymousClass1();
    }

    void ensureMutable();
}
