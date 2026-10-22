package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;

/* JADX INFO: loaded from: classes7.dex */
public class CMSProcessableByteArray implements CMSReadable {
    private final byte[] bytes;
    private final ASN1ObjectIdentifier type;

    public CMSProcessableByteArray(ASN1ObjectIdentifier r1, byte[] r2) {
        this.type = r1;
        this.bytes = r2;
    }

    public CMSProcessableByteArray(byte[] r2) {
        this(CMSObjectIdentifiers.data, r2);
    }

    @Override // org.bouncycastle.cms.CMSReadable
    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.bytes);
    }
}
