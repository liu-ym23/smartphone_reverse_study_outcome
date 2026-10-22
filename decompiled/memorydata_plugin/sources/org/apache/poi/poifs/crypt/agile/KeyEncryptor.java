package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.EncryptedDocumentException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes7.dex */
public class KeyEncryptor {
    private CertificateKeyEncryptor certificateKeyEncryptor;
    private PasswordKeyEncryptor passwordKeyEncryptor;

    public KeyEncryptor() {
    }

    public KeyEncryptor(Element r6) {
        Element r7 = (Element) ZeusTransformUtils.wrapperContextForParams(r6, Element.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L16;
        NodeList r8 = r7.getElementsByTagNameNS("*", "encryptedKey");
        int r0 = 0;
    L6:
        if (r0 >= r8.getLength()) goto L14;
        Element r2 = (Element) ZeusTransformUtils.preCheckCast(r8.item(r0), Element.class, "com.obric.memorydata.plugin");
        String r3 = r2.getNamespaceURI();
        if ("http://schemas.microsoft.com/office/2006/keyEncryptor/password".equals(r3) == false) goto L11;
        this.passwordKeyEncryptor = new PasswordKeyEncryptor(r2);
    L13:
        r0 = r0 + 1;
        goto L6
    L11:
        if ("http://schemas.microsoft.com/office/2006/keyEncryptor/certificate".equals(r3) == false) goto L13;
        this.certificateKeyEncryptor = new CertificateKeyEncryptor(r2);
        goto L13
    L14:
        return;
    L16:
        throw new EncryptedDocumentException("Unable to parse encryption descriptor");
    }

    public PasswordKeyEncryptor getPasswordKeyEncryptor() {
        return this.passwordKeyEncryptor;
    }
}
