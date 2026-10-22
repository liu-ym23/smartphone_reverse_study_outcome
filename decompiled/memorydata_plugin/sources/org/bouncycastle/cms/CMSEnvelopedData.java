package org.bouncycastle.cms;

import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.EncryptedContentInfo;
import org.bouncycastle.asn1.cms.EnvelopedData;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.util.Encodable;

/* JADX INFO: loaded from: classes7.dex */
public class CMSEnvelopedData implements Encodable {
    ContentInfo contentInfo;
    private AlgorithmIdentifier encAlg;
    private OriginatorInformation originatorInfo;
    RecipientInformationStore recipientInfoStore;
    private ASN1Set unprotectedAttributes;

    public CMSEnvelopedData(ContentInfo r7) {
        this.contentInfo = r7;
        EnvelopedData r8 = EnvelopedData.getInstance(r7.getContent());     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        if (r8.getOriginatorInfo() == null) goto L6;
        this.originatorInfo = new OriginatorInformation(r8.getOriginatorInfo());     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
    L6:
        ASN1Set r1 = r8.getRecipientInfos();     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        EncryptedContentInfo r2 = r8.getEncryptedContentInfo();     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        this.encAlg = r2.getContentEncryptionAlgorithm();     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        CMSProcessableByteArray r3 = new CMSProcessableByteArray(r2.getEncryptedContent().getOctets());     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        CMSEnvelopedHelper.CMSEnvelopedSecureReadable r4 = new CMSEnvelopedHelper.CMSEnvelopedSecureReadable(this.encAlg, r2.getContentType(), r3);     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(r1, this.encAlg, r4);     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        this.unprotectedAttributes = r8.getUnprotectedAttrs();     // Catch: IllegalArgumentException -> L8 ClassCastException -> L11
        return;
    L11:
        e = move-exception;
        throw new CMSException("Malformed content.", e);
    L8:
        e = move-exception;
        throw new CMSException("Malformed content.", e);
    }

    public CMSEnvelopedData(byte[] r1) {
        this(CMSUtils.readContentInfo(r1));
    }

    @Override // org.bouncycastle.util.Encodable
    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    public RecipientInformationStore getRecipientInfos() {
        return this.recipientInfoStore;
    }
}
