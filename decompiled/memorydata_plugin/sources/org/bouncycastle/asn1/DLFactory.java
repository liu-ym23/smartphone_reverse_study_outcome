package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
class DLFactory {
    static final DLSequence EMPTY_SEQUENCE = null;
    static final DLSet EMPTY_SET = null;

    static {
        EMPTY_SEQUENCE = new DLSequence();
        EMPTY_SET = new DLSet();
    }

    static DLSequence createSequence(ASN1EncodableVector r2) {
        if (r2.size() >= 1) goto L7;
        return EMPTY_SEQUENCE;
    L7:
        return new DLSequence(r2);
    }

    static DLSet createSet(ASN1EncodableVector r2) {
        if (r2.size() >= 1) goto L7;
        return EMPTY_SET;
    L7:
        return new DLSet(r2);
    }
}
