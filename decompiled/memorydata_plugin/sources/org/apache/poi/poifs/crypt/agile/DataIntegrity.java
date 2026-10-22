package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes7.dex */
public class DataIntegrity {
    private byte[] encryptedHmacKey;
    private byte[] encryptedHmacValue;

    public DataIntegrity() {
    }

    public DataIntegrity(Element r3) {
        Element r4 = EncryptionDocument.getTag((Element) ZeusTransformUtils.wrapperContextForParams(r3, Element.class, "com.obric.memorydata.plugin"), "http://schemas.microsoft.com/office/2006/encryption", "dataIntegrity");
        if (r4 == null) goto L7;
        this.encryptedHmacKey = EncryptionDocument.getBinAttr(r4, "encryptedHmacKey");
        this.encryptedHmacValue = EncryptionDocument.getBinAttr(r4, "encryptedHmacValue");
        return;
    L7:
        throw new EncryptedDocumentException("Unable to parse encryption descriptor");
    }

    public byte[] getEncryptedHmacKey() {
        return this.encryptedHmacKey;
    }

    public byte[] getEncryptedHmacValue() {
        return this.encryptedHmacValue;
    }
}
