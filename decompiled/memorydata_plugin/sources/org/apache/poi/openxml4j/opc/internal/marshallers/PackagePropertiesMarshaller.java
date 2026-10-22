package org.apache.poi.openxml4j.opc.internal.marshallers;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.entity.EventBody;
import com.ctc.wstx.shaded.msv_core.grammar.xmlschema.XMLSchemaSchema;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import java.util.Optional;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.openxml4j.opc.internal.PartMarshaller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* JADX INFO: loaded from: classes7.dex */
public class PackagePropertiesMarshaller implements PartMarshaller {
    private static final NamespaceImpl namespaceCoreProperties = null;
    private static final NamespaceImpl namespaceDC = null;
    private static final NamespaceImpl namespaceDcTerms = null;
    private static final NamespaceImpl namespaceXSI = null;
    PackagePropertiesPart propsPart;
    Document xmlDoc;

    private static class NamespaceImpl {
        private final String namespaceURI;
        private final String prefix;

        NamespaceImpl(String r1, String r2) {
            this.prefix = r1;
            this.namespaceURI = r2;
        }

        public String getNamespaceURI() {
            return this.namespaceURI;
        }

        public String getPrefix() {
            return this.prefix;
        }
    }

    static {
        namespaceDC = new NamespaceImpl("dc", "http://purl.org/dc/elements/1.1/");
        namespaceCoreProperties = new NamespaceImpl("cp", "http://schemas.openxmlformats.org/package/2006/metadata/core-properties");
        namespaceDcTerms = new NamespaceImpl("dcterms", "http://purl.org/dc/terms/");
        namespaceXSI = new NamespaceImpl("xsi", XMLSchemaSchema.XMLSchemaInstanceNamespace);
    }

    public PackagePropertiesMarshaller() {
    }

    private void addCategory() {
        setElementTextContent(EventBody.KEY_CATEGORY, namespaceCoreProperties, this.propsPart.getCategoryProperty());
    }

    private void addContentStatus() {
        setElementTextContent("contentStatus", namespaceCoreProperties, this.propsPart.getContentStatusProperty());
    }

    private void addContentType() {
        setElementTextContent("contentType", namespaceCoreProperties, this.propsPart.getContentTypeProperty());
    }

    private void addCreated() {
        setElementTextContent("created", namespaceDcTerms, this.propsPart.getCreatedProperty(), this.propsPart.getCreatedPropertyString(), "dcterms:W3CDTF");
    }

    private void addCreator() {
        setElementTextContent("creator", namespaceDC, this.propsPart.getCreatorProperty());
    }

    private void addDescription() {
        setElementTextContent("description", namespaceDC, this.propsPart.getDescriptionProperty());
    }

    private void addIdentifier() {
        setElementTextContent(MemoryKeyInfoEntity.KEY_IDENTIFIER, namespaceDC, this.propsPart.getIdentifierProperty());
    }

    private void addKeywords() {
        setElementTextContent("keywords", namespaceCoreProperties, this.propsPart.getKeywordsProperty());
    }

    private void addLanguage() {
        setElementTextContent(Api.KEY_LANGUAGE, namespaceDC, this.propsPart.getLanguageProperty());
    }

    private void addLastModifiedBy() {
        setElementTextContent("lastModifiedBy", namespaceCoreProperties, this.propsPart.getLastModifiedByProperty());
    }

    private void addLastPrinted() {
        setElementTextContent("lastPrinted", namespaceCoreProperties, this.propsPart.getLastPrintedProperty(), this.propsPart.getLastPrintedPropertyString());
    }

    private void addModified() {
        setElementTextContent("modified", namespaceDcTerms, this.propsPart.getModifiedProperty(), this.propsPart.getModifiedPropertyString(), "dcterms:W3CDTF");
    }

    private void addRevision() {
        setElementTextContent("revision", namespaceCoreProperties, this.propsPart.getRevisionProperty());
    }

    private void addSubject() {
        setElementTextContent("subject", namespaceDC, this.propsPart.getSubjectProperty());
    }

    private void addTitle() {
        setElementTextContent("title", namespaceDC, this.propsPart.getTitleProperty());
    }

    private void addVersion() {
        setElementTextContent("version", namespaceCoreProperties, this.propsPart.getVersionProperty());
    }

    private String getQName(String r1, NamespaceImpl r2) {
        if (r2.getPrefix().isEmpty() == false) goto L6;
        return r1;
    L6:
        return r2.getPrefix() + ':' + r1;
    }

    private Element setElementTextContent(String r4, NamespaceImpl r5, Optional<String> r6) {
        return setElementTextContent(r4, r5, r6, (String) ZeusTransformUtils.preCheckCast(r6.orElse(null), String.class, "com.obric.memorydata.plugin"));
    }

    private Element setElementTextContent(String r4, NamespaceImpl r5, Optional<?> r6, String r7) {
        if (r6.isPresent() == true) goto L6;
        return null;
    L6:
        Element r8 = this.xmlDoc.getDocumentElement();
        Element r0 = (Element) ZeusTransformUtils.preCheckCast(r8.getElementsByTagNameNS(r5.getNamespaceURI(), r4).item(0), Element.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        r0 = this.xmlDoc.createElementNS(r5.getNamespaceURI(), getQName(r4, r5));
        r8.appendChild(r0);
    L9:
        r0.setTextContent(r7);
        return r0;
    }

    private Element setElementTextContent(String r1, NamespaceImpl r2, Optional<?> r3, String r4, String r5) {
        Element r6 = setElementTextContent(r1, r2, r3, r4);
        if (r6 == null) goto L5;
        NamespaceImpl r7 = namespaceXSI;
        r6.setAttributeNS(r7.getNamespaceURI(), getQName("type", r7), r5);
    L5:
        return r6;
    }

    @Override // org.apache.poi.openxml4j.opc.internal.PartMarshaller
    public boolean marshall(PackagePart r3, OutputStream r4) {
        if (ZeusTransformUtils.instanceOf(r3, PackagePropertiesPart.class) == false) goto L7;
        this.propsPart = (PackagePropertiesPart) ZeusTransformUtils.preCheckCast(r3, PackagePropertiesPart.class, "com.obric.memorydata.plugin");
        Document r5 = DocumentHelper.createDocument();
        this.xmlDoc = r5;
        NamespaceImpl r6 = namespaceCoreProperties;
        Element r7 = r5.createElementNS(r6.getNamespaceURI(), getQName("coreProperties", r6));
        DocumentHelper.addNamespaceDeclaration(r7, r6.getPrefix(), r6.getNamespaceURI());
        NamespaceImpl r8 = namespaceDC;
        DocumentHelper.addNamespaceDeclaration(r7, r8.getPrefix(), r8.getNamespaceURI());
        NamespaceImpl r9 = namespaceDcTerms;
        DocumentHelper.addNamespaceDeclaration(r7, r9.getPrefix(), r9.getNamespaceURI());
        NamespaceImpl r10 = namespaceXSI;
        DocumentHelper.addNamespaceDeclaration(r7, r10.getPrefix(), r10.getNamespaceURI());
        this.xmlDoc.appendChild(r7);
        addCategory();
        addContentStatus();
        addContentType();
        addCreated();
        addCreator();
        addDescription();
        addIdentifier();
        addKeywords();
        addLanguage();
        addLastModifiedBy();
        addLastPrinted();
        addModified();
        addRevision();
        addSubject();
        addTitle();
        addVersion();
        return true;
    L7:
        throw new IllegalArgumentException("'part' must be a PackagePropertiesPart instance.");
    }
}
