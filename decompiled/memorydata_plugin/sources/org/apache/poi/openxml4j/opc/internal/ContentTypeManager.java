package org.apache.poi.openxml4j.opc.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes7.dex */
public abstract class ContentTypeManager {
    protected OPCPackage container;
    private TreeMap<String, String> defaultContentType;
    private TreeMap<PackagePartName, String> overrideContentType;

    public ContentTypeManager(InputStream r1, OPCPackage r2) {
        this.container = r2;
        this.defaultContentType = new TreeMap();
        if (r1 != null) goto L10;
        return;
    L10:
        parseContentTypesFile(r1);     // Catch: InvalidFormatException -> L6
        return;
    L6:
        e = move-exception;
        InvalidFormatException r3 = new InvalidFormatException("Can't read content types part !");
        r3.initCause(e);
        throw r3;
    }

    private void addDefaultContentType(String r2, String r3) {
        this.defaultContentType.put(r2.toLowerCase(Locale.ROOT), r3);
    }

    private void addOverrideContentType(PackagePartName r2, String r3) {
        if (this.overrideContentType != null) goto L5;
        this.overrideContentType = new TreeMap();
    L5:
        this.overrideContentType.put(r2, r3);
    }

    private void appendDefaultType(Element r4, Map.Entry<String, String> r5) {
        Element r3 = (Element) ZeusTransformUtils.wrapperContextForParams(r4, Element.class, "com.obric.memorydata.plugin");
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        Element r7 = r3.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");
        r7.setAttribute("Extension", (String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"));
        r7.setAttribute("ContentType", (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));
        r3.appendChild(r7);
    }

    private void appendSpecificTypes(Element r4, Map.Entry<PackagePartName, String> r5) {
        Element r3 = (Element) ZeusTransformUtils.wrapperContextForParams(r4, Element.class, "com.obric.memorydata.plugin");
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.wrapperContextForParams(r5, Map.Entry.class, "com.obric.memorydata.plugin");
        Element r7 = r3.getOwnerDocument().createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Override");
        r7.setAttribute("PartName", ((PackagePartName) ZeusTransformUtils.preCheckCast(r6.getKey(), PackagePartName.class, "com.obric.memorydata.plugin")).getName());
        r7.setAttribute("ContentType", (String) ZeusTransformUtils.preCheckCast(r6.getValue(), String.class, "com.obric.memorydata.plugin"));
        r3.appendChild(r7);
    }

    private void parseContentTypesFile(InputStream r10) {
        Document r11 = DocumentHelper.readDocument(r10);     // Catch: Throwable -> L13
        NodeList r1 = r11.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", "Default");     // Catch: Throwable -> L13
        int r2 = r1.getLength();     // Catch: Throwable -> L13
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L8;
        Element r6 = (Element) ZeusTransformUtils.preCheckCast(r1.item(r4), Element.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        addDefaultContentType(r6.getAttribute("Extension"), r6.getAttribute("ContentType"));     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        r4 = r4 + 1;     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        goto L6
    L8:
        NodeList r12 = r11.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/content-types", "Override");     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        int r0 = r12.getLength();     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
    L9:
        if (r3 >= r0) goto L12;
        Element r5 = (Element) ZeusTransformUtils.preCheckCast(r12.item(r3), Element.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        addOverrideContentType(PackagingURIHelper.createPartName(new URI(r5.getAttribute("PartName"))), r5.getAttribute("ContentType"));     // Catch: Throwable -> L13 Throwable -> L13 Throwable -> L13
        r3 = r3 + 1;
        goto L9
    L12:
        return;
    L13:
        e = move-exception;
        throw new InvalidFormatException(e.getMessage());
    }

    public void addContentType(PackagePartName r4, String r5) {
        boolean r0 = this.defaultContentType.containsValue(r5);
        String r1 = r4.getExtension().toLowerCase(Locale.ROOT);
        if (r1.length() != 0) goto L5;
    L13:
        addOverrideContentType(r4, r5);
        return;
    L5:
        if (this.defaultContentType.containsKey(r1) == false) goto L8;
        if (r0 == false) goto L13;
    L8:
        if (this.defaultContentType.containsKey(r1) == true) goto L11;
        if (r0 == true) goto L13;
    L11:
        if (r0 == true) goto L15;
        addDefaultContentType(r1, r5);
        return;
    }

    public void clearAll() {
        this.defaultContentType.clear();
        TreeMap<PackagePartName, String> r1 = this.overrideContentType;
        if (r1 == null) goto L6;
        r1.clear();
        return;
    }

    public String getContentType(PackagePartName r4) {
        if (r4 == null) goto L23;
        TreeMap<PackagePartName, String> r0 = this.overrideContentType;
        if (r0 != null) goto L6;
    L10:
        String r1 = r4.getExtension().toLowerCase(Locale.ROOT);
        if (this.defaultContentType.containsKey(r1) == false) goto L13;
        String r3 = this.defaultContentType.get(r1);
    L9:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L13:
        OPCPackage r5 = this.container;
        if (r5 != null) goto L16;
        return null;
    L16:
        if (r5.getPart(r4) != null) goto L19;
        return null;
    L19:
        throw new OpenXML4JRuntimeException("Rule M2.4 exception : Part '" + r4 + "' not found - this error should NEVER happen!\nCheck that your code is closing the open resources in the correct order prior to filing a bug report.\nIf you can provide the triggering file, then please raise a bug at https://bz.apache.org/bugzilla/enter_bug.cgi?product=POI and attach the file that triggers it, thanks!");
    L6:
        if (r0.containsKey(r4) == false) goto L10;
        r3 = this.overrideContentType.get(r4);
        goto L9
    L23:
        throw new IllegalArgumentException("partName");
    }

    public boolean isContentTypeRegister(String r2) {
        if (r2 == null) goto L14;
        if (this.defaultContentType.containsValue(r2) == true) goto L11;
        TreeMap<PackagePartName, String> r1 = this.overrideContentType;
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.containsValue(r2) == false) goto L10;
    L11:
        return true;
    L14:
        throw new IllegalArgumentException("contentType");
    }

    public void removeContentType(PackagePartName r7) {
        if (r7 == null) goto L41;
        TreeMap<PackagePartName, String> r0 = this.overrideContentType;
        if (r0 != null) goto L6;
    L9:
        String r1 = r7.getExtension();
        boolean r2 = true;
        OPCPackage r3 = this.container;
        if (r3 != null) goto L44;
    L22:
        if (r2 == false) goto L24;
        this.defaultContentType.remove(r1);
    L24:
        OPCPackage r4 = this.container;
        if (r4 != null) goto L42;
        return;
    L42:
        Iterator<PackagePart> r5 = r4.getParts().iterator();     // Catch: InvalidFormatException -> L36
    L28:
        if (r5.hasNext() == false) goto L58;
        PackagePart r6 = (PackagePart) ZeusTransformUtils.preCheckCast(r5.next(), PackagePart.class, "com.obric.memorydata.plugin");     // Catch: InvalidFormatException -> L36
        if (r6.getPartName().equals(r7) == true) goto L28;
        if (getContentType(r6.getPartName()) != null) goto L28;
        throw new InvalidOperationException("Rule M2.4 is not respected: Nor a default element or override element is associated with the part: " + r6.getPartName().getName());     // Catch: InvalidFormatException -> L36
    L58:
        return;
    L36:
        e = move-exception;
        throw new InvalidOperationException(e.getMessage());
    L44:
        Iterator<PackagePart> r8 = r3.getParts().iterator();     // Catch: InvalidFormatException -> L19
    L13:
        if (r8.hasNext() == false) goto L22;
        PackagePart r9 = (PackagePart) ZeusTransformUtils.preCheckCast(r8.next(), PackagePart.class, "com.obric.memorydata.plugin");     // Catch: InvalidFormatException -> L19
        if (r9.getPartName().equals(r7) == true) goto L13;
        if (r9.getPartName().getExtension().equalsIgnoreCase(r1) == false) goto L13;
        r2 = false;
    L19:
        e = move-exception;
        throw new InvalidOperationException(e.getMessage());
    L6:
        if (r0.get(r7) == null) goto L9;
        this.overrideContentType.remove(r7);
        return;
    L41:
        throw new IllegalArgumentException("partName");
    }

    public boolean save(OutputStream r7) {
        Document r0 = DocumentHelper.createDocument();
        Element r1 = r0.createElementNS("http://schemas.openxmlformats.org/package/2006/content-types", "Types");
        r0.appendChild(r1);
        Iterator<Map.Entry<String, String>> r2 = this.defaultContentType.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        appendDefaultType(r1, (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        TreeMap<PackagePartName, String> r3 = this.overrideContentType;
        if (r3 == null) goto L12;
        Iterator<Map.Entry<PackagePartName, String>> r4 = r3.entrySet().iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        appendSpecificTypes(r1, (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin"));
    L12:
        r0.normalize();
        return saveImpl(r0, r7);
    }

    public abstract boolean saveImpl(Document r1, OutputStream r2);
}
