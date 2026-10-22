package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes7.dex */
public class CertificateKeyEncryptor {
    private byte[] certVerifier;
    private byte[] encryptedKeyValue;
    private byte[] x509Certificate;

    public CertificateKeyEncryptor(Element r3) {
        Element r4 = (Element) ZeusTransformUtils.wrapperContextForParams(r3, Element.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        this.encryptedKeyValue = EncryptionDocument.getBinAttr(r4, "encryptedKeyValue");
        this.x509Certificate = EncryptionDocument.getBinAttr(r4, "X509Certificate");
        this.certVerifier = EncryptionDocument.getBinAttr(r4, "certVerifier");
        return;
    L7:
        throw new EncryptedDocumentException("Unable to parse encryption descriptor");
    }
}
