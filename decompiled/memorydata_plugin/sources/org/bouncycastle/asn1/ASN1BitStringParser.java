package org.bouncycastle.asn1;

import java.io.InputStream;

/* JADX INFO: loaded from: classes7.dex */
public interface ASN1BitStringParser extends ASN1Encodable, InMemoryRepresentable {
    InputStream getBitStream();

    int getPadBits();
}
