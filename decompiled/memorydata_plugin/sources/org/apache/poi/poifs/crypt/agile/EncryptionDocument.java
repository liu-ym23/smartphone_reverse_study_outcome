package org.apache.poi.poifs.crypt.agile;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes7.dex */
public class EncryptionDocument {
    private DataIntegrity dataIntegrity;
    private KeyData keyData;
    private final List<KeyEncryptor> keyEncryptors;

    public EncryptionDocument() {
        this.keyEncryptors = new ArrayList();
    }

    static byte[] getBinAttr(Element r2, String r3) {
        String r4 = ((Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin")).getAttribute(r3);
        if (r4.isEmpty() == false) goto L6;
        return null;
    L6:
        return Base64.getDecoder().decode(r4);
    }

    static Integer getIntAttr(Element r2, String r3) {
        String r4 = ((Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin")).getAttribute(r3);
        if (r4.isEmpty() == false) goto L6;
        return null;
    L6:
        return Integer.valueOf(r4);
    }

    static Element getTag(Element r2, String r3, String r4) {
        Element r5 = (Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return null;
    L5:
        NodeList r6 = r5.getElementsByTagNameNS(r3, r4);
        if (r6.getLength() > 0) goto L8;
        return null;
    L8:
        return (Element) ZeusTransformUtils.preCheckCast(r6.item(0), Element.class, "com.obric.memorydata.plugin");
    }

    public DataIntegrity getDataIntegrity() {
        return this.dataIntegrity;
    }

    public KeyData getKeyData() {
        return this.keyData;
    }

    public List<KeyEncryptor> getKeyEncryptors() {
        return this.keyEncryptors;
    }

    public void parse(Document r7) {
        Element r8 = ((Document) ZeusTransformUtils.wrapperContextForParams(r7, Document.class, "com.obric.memorydata.plugin")).getDocumentElement();
        if ("http://schemas.microsoft.com/office/2006/encryption".equals(r8.getNamespaceURI()) == false) goto L16;
        if ("encryption".equals(r8.getLocalName()) == false) goto L16;
        this.keyData = new KeyData(r8);
        this.dataIntegrity = new DataIntegrity(r8);
        Element r9 = getTag(r8, "http://schemas.microsoft.com/office/2006/encryption", "keyEncryptors");
        if (r9 == null) goto L14;
        NodeList r10 = r9.getElementsByTagNameNS("http://schemas.microsoft.com/office/2006/encryption", "keyEncryptor");
        int r0 = 0;
    L10:
        if (r0 >= r10.getLength()) goto L12;
        this.keyEncryptors.add(new KeyEncryptor((Element) ZeusTransformUtils.preCheckCast(r10.item(r0), Element.class, "com.obric.memorydata.plugin")));
        r0 = r0 + 1;
        goto L10
    L12:
        return;
    L14:
        throw new EncryptedDocumentException("Unable to parse encryption descriptor");
    L16:
        throw new EncryptedDocumentException("Unable to parse encryption descriptor");
    }
}
