package org.apache.poi.ooxml.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import org.apache.poi.util.XMLHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes7.dex */
public final class DocumentHelper {
    private static final DocumentBuilder documentBuilderSingleton = null;

    static {
        documentBuilderSingleton = newDocumentBuilder();
    }

    public static void addNamespaceDeclaration(Element r2, String r3, String r4) {
        ((Element) ZeusTransformUtils.wrapperContextForParams(r2, Element.class, "com.obric.memorydata.plugin")).setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + r3, r4);
    }

    public static Document createDocument() {
        return documentBuilderSingleton.newDocument();
    }

    public static DocumentBuilder newDocumentBuilder() {
        return XMLHelper.newDocumentBuilder();
    }

    public static Document readDocument(InputStream r1) {
        return newDocumentBuilder().parse(r1);
    }
}
