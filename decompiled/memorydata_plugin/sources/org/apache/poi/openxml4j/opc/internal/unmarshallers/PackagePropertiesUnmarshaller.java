package org.apache.poi.openxml4j.opc.internal.unmarshallers;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaSchema;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.openxml4j.opc.internal.PartUnmarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: classes7.dex */
public final class PackagePropertiesUnmarshaller implements PartUnmarshaller {
    public PackagePropertiesUnmarshaller() {
    }

    private String loadCategory(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), EventBody.KEY_CATEGORY, "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadContentStatus(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "contentStatus", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadContentType(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "contentType", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadCreated(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "created", "http://purl.org/dc/terms/");
    }

    private String loadCreator(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "creator", "http://purl.org/dc/elements/1.1/");
    }

    private String loadDescription(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "description", "http://purl.org/dc/elements/1.1/");
    }

    private String loadIdentifier(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), MemoryKeyInfoEntity.KEY_IDENTIFIER, "http://purl.org/dc/elements/1.1/");
    }

    private String loadKeywords(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "keywords", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadLanguage(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), Api.KEY_LANGUAGE, "http://purl.org/dc/elements/1.1/");
    }

    private String loadLastModifiedBy(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "lastModifiedBy", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadLastPrinted(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "lastPrinted", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadModified(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "modified", "http://purl.org/dc/terms/");
    }

    private String loadRevision(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "revision", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String loadSubject(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "subject", "http://purl.org/dc/elements/1.1/");
    }

    private String loadTitle(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "title", "http://purl.org/dc/elements/1.1/");
    }

    private String loadVersion(Document r3) {
        return readElement((Document) ZeusTransformUtils.wrapperContextForParams(r3, Document.class, "com.obric.memorydata.plugin"), "version", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
    }

    private String readElement(Document r2, String r3, String r4) {
        Element r1 = (Element) ZeusTransformUtils.preCheckCast(((Document) ZeusTransformUtils.wrapperContextForParams(r2, Document.class, "com.obric.memorydata.plugin")).getDocumentElement().getElementsByTagNameNS(r4, r3).item(0), Element.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getTextContent();
    }

    public void checkElementForOPCCompliance(Element r9) {
        Element r10 = (Element) ZeusTransformUtils.wrapperContextForParams(r9, Element.class, "com.obric.memorydata.plugin");
        NamedNodeMap r0 = r10.getAttributes();
        int r2 = r0.getLength();
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L14;
        Attr r5 = (Attr) ZeusTransformUtils.preCheckCast(r0.item(0), Attr.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L13;
        if ("http://www.w3.org/2000/xmlns/".equals(r5.getNamespaceURI()) == false) goto L13;
        if ("http://schemas.openxmlformats.org/markup-compatibility/2006".equals(r5.getValue()) == false) goto L13;
        throw new InvalidFormatException("OPC Compliance error [M4.2]: A format consumer shall consider the use of the Markup Compatibility namespace to be an error.");
    L13:
        r4 = r4 + 1;
        goto L3
    L14:
        String r1 = r10.getLocalName();
        if ("http://purl.org/dc/terms/".equals(r10.getNamespaceURI()) == false) goto L24;
        if ("created".equals(r1) == true) goto L24;
        if ("modified".equals(r1) == true) goto L24;
        throw new InvalidFormatException("OPC Compliance error [M4.3]: Producers shall not create a document element that contains refinements to the Dublin Core elements, except for the two specified in the schema: <dcterms:created> and <dcterms:modified> Consumers shall consider a document element that violates this constraint to be an error.");
    L24:
        if (r10.getAttributeNodeNS("http://www.w3.org/XML/1998/namespace", "lang") != null) goto L48;
        if ("http://purl.org/dc/terms/".equals(r10.getNamespaceURI()) == true) goto L28;
    L43:
        NodeList r11 = r10.getElementsByTagName("*");
        int r6 = r11.getLength();
    L44:
        if (r3 >= r6) goto L46;
        checkElementForOPCCompliance((Element) ZeusTransformUtils.preCheckCast(r11.item(r3), Element.class, "com.obric.memorydata.plugin"));
        r3 = r3 + 1;
        goto L44
    L46:
        return;
    L28:
        if (r1.equals("created") == false) goto L30;
    L34:
        Attr r7 = r10.getAttributeNodeNS(XMLSchemaSchema.XMLSchemaInstanceNamespace, "type");
        if (r7 == null) goto L42;
        if (r7.getValue().equals(r10.getPrefix() + ":W3CDTF") == true) goto L43;
        throw new InvalidFormatException("The element '" + r1 + "' must have the 'xsi:type' attribute with the value '" + r10.getPrefix() + ":W3CDTF', but had '" + r7.getValue() + "' !");
    L42:
        throw new InvalidFormatException("The element '" + r1 + "' must have the 'xsi:type' attribute present !");
    L30:
        if (r1.equals("modified") == true) goto L34;
        throw new InvalidFormatException("Namespace error : " + r1 + " shouldn't have the following namespace -> http://purl.org/dc/terms/");
    L48:
        throw new InvalidFormatException("OPC Compliance error [M4.4]: Producers shall not create a document element that contains the xml:lang attribute. Consumers shall consider a document element that violates this constraint to be an error.");
    }

    @Override // org.apache.poi.openxml4j.opc.internal.PartUnmarshaller
    public PackagePart unmarshall(UnmarshallContext r4, InputStream r5) {
        PackagePropertiesPart r0 = new PackagePropertiesPart(r4.getPackage(), r4.getPartName());
        if (r5 == null) goto L5;
    L18:
        Document r6 = DocumentHelper.readDocument(r5);     // Catch: SAXException -> L15
        checkElementForOPCCompliance(r6.getDocumentElement());     // Catch: SAXException -> L15
        r0.setCategoryProperty(loadCategory(r6));
        r0.setContentStatusProperty(loadContentStatus(r6));
        r0.setContentTypeProperty(loadContentType(r6));
        r0.setCreatedProperty(loadCreated(r6));
        r0.setCreatorProperty(loadCreator(r6));
        r0.setDescriptionProperty(loadDescription(r6));
        r0.setIdentifierProperty(loadIdentifier(r6));
        r0.setKeywordsProperty(loadKeywords(r6));
        r0.setLanguageProperty(loadLanguage(r6));
        r0.setLastModifiedByProperty(loadLastModifiedBy(r6));
        r0.setLastPrintedProperty(loadLastPrinted(r6));
        r0.setModifiedProperty(loadModified(r6));
        r0.setRevisionProperty(loadRevision(r6));
        r0.setSubjectProperty(loadSubject(r6));
        r0.setTitleProperty(loadTitle(r6));
        r0.setVersionProperty(loadVersion(r6));
        return r0;
    L15:
        e = move-exception;
        throw new IOException(e.getMessage());
    L5:
        if (r4.getZipEntry() == null) goto L8;
        r5 = ((ZipPackage) ZeusTransformUtils.preCheckCast(r4.getPackage(), ZipPackage.class, "com.obric.memorydata.plugin")).getZipArchive().getInputStream(r4.getZipEntry());
        goto L18
    L8:
        if (r4.getPackage() == null) goto L11;
        ZipArchiveEntry r7 = ZipHelper.getCorePropertiesZipEntry((ZipPackage) ZeusTransformUtils.preCheckCast(r4.getPackage(), ZipPackage.class, "com.obric.memorydata.plugin"));
        r5 = ((ZipPackage) ZeusTransformUtils.preCheckCast(r4.getPackage(), ZipPackage.class, "com.obric.memorydata.plugin")).getZipArchive().getInputStream(r7);
        goto L18
    L11:
        throw new IOException("Error while trying to get the part input stream.");
    }
}
