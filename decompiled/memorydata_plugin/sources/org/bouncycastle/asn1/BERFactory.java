package org.bouncycastle.asn1;

/* JADX INFO: loaded from: classes7.dex */
class BERFactory {
    static final BERSequence EMPTY_SEQUENCE = null;
    static final BERSet EMPTY_SET = null;

    static {
        EMPTY_SEQUENCE = new BERSequence();
        EMPTY_SET = new BERSet();
    }

    static BERSequence createSequence(ASN1EncodableVector r2) {
        if (r2.size() >= 1) goto L7;
        return EMPTY_SEQUENCE;
    L7:
        return new BERSequence(r2);
    }
}
