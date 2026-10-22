package org.apache.poi.openxml4j.opc;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Spliterator;
import java.util.TreeMap;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.util.DocumentHelper;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: classes7.dex */
public final class PackageRelationshipCollection implements Iterable<PackageRelationship> {
    private static final c LOG = null;
    private OPCPackage container;
    private HashMap<String, PackageRelationship> internalRelationshipsByTargetName;
    private int nextRelationshipId;
    private PackagePartName partName;
    private PackagePart relationshipPart;
    private final TreeMap<String, PackageRelationship> relationshipsByID;
    private final TreeMap<String, PackageRelationship> relationshipsByType;
    private PackagePart sourcePart;

    static {
        LOG = b.a(PackageRelationshipCollection.class);
    }

    PackageRelationshipCollection() {
        this.relationshipsByID = new TreeMap();
        this.relationshipsByType = new TreeMap();
        this.internalRelationshipsByTargetName = new HashMap();
        this.nextRelationshipId = -1;
    }

    public PackageRelationshipCollection(OPCPackage r2) {
        this(r2, null);
    }

    public PackageRelationshipCollection(OPCPackage r2, PackagePart r3) {
        this.relationshipsByID = new TreeMap();
        this.relationshipsByType = new TreeMap();
        this.internalRelationshipsByTargetName = new HashMap();
        this.nextRelationshipId = -1;
        if (r2 == null) goto L17;
        if (r3 != null) goto L6;
    L10:
        this.container = r2;
        this.sourcePart = r3;
        this.partName = getRelationshipPartName(r3);
        if (r2.getPackageAccess() != PackageAccess.WRITE) goto L13;
        return;
    L13:
        if (r2.containPart(this.partName) == false) goto L19;
        PackagePart r4 = r2.getPart(this.partName);
        this.relationshipPart = r4;
        parseRelationshipsPart(r4);
        return;
    L19:
        return;
    L6:
        if (r3.isRelationshipPart() == false) goto L10;
        throw new IllegalArgumentException("part");
    L17:
        throw new IllegalArgumentException("container needs to be specified");
    }

    public PackageRelationshipCollection(PackagePart r2) {
        this(r2._container, r2);
    }

    public PackageRelationshipCollection(PackageRelationshipCollection r4, String r5) {
        this();
        Iterator<PackageRelationship> r6 = r4.relationshipsByID.values().iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        PackageRelationship r0 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r6.next(), PackageRelationship.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L9;
        if (r0.getRelationshipType().equals(r5) == false) goto L4;
    L9:
        addRelationship(r0);
        goto L4
    }

    private static PackagePartName getRelationshipPartName(PackagePart r0) {
        if (r0 != null) goto L4;
        PackagePartName r1 = PackagingURIHelper.PACKAGE_ROOT_PART_NAME;
    L6:
        return PackagingURIHelper.getRelationshipPartName(r1);
    L4:
        r1 = r0.getPartName();
        goto L6
    }

    public PackageRelationship addRelationship(URI r9, TargetMode r10, String r11, String r12) {
        if (r12 == null) goto L8;
        if (r12.length() == 0) goto L8;
    L6:
        String r7 = r12;
        PackageRelationship r13 = new PackageRelationship(this.container, this.sourcePart, r9, r10, r11, r7);
        addRelationship(r13);
        if (r10 != TargetMode.INTERNAL) goto L16;
        this.internalRelationshipsByTargetName.put(r9.toASCIIString(), r13);
    L16:
        return r13;
    L8:
        if (this.nextRelationshipId != (-1)) goto L10;
        this.nextRelationshipId = size() + 1;
    L10:
        StringBuilder r14 = new StringBuilder().append("rId");
        int r0 = this.nextRelationshipId;
        this.nextRelationshipId = r0 + 1;
        r12 = r14.append(r0).toString();
        if (this.relationshipsByID.get(r12) != null) goto L10;
        goto L6
    }

    public void addRelationship(PackageRelationship r3) {
        if (r3 != null) goto L4;
    L10:
        StringBuilder r0 = new StringBuilder().append("invalid relationship part/id: ");
        if (r3 != null) goto L13;
        String r1 = "<null>";
    L15:
        throw new IllegalArgumentException(r0.append(r1).append(" for relationship: ").append(r3).toString());
    L13:
        r1 = r3.getId();
        goto L15
    L4:
        if (r3.getId() == null) goto L10;
        if (r3.getId().isEmpty() == true) goto L10;
        this.relationshipsByID.put(r3.getId(), r3);
        this.relationshipsByType.put(r3.getRelationshipType(), r3);
    }

    public void clear() {
        this.relationshipsByID.clear();
        this.relationshipsByType.clear();
        this.internalRelationshipsByTargetName.clear();
    }

    public PackageRelationship findExistingInternalRelation(PackagePart r2) {
        return (PackageRelationship) ZeusTransformUtils.preCheckCast(this.internalRelationshipsByTargetName.get(r2.getPartName().getName()), PackageRelationship.class, "com.obric.memorydata.plugin");
    }

    public PackageRelationship getRelationship(int r5) {
        if (r5 < 0) goto L15;
        if (r5 > this.relationshipsByID.values().size()) goto L15;
        int r0 = 0;
        Iterator<PackageRelationship> r4 = this.relationshipsByID.values().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        PackageRelationship r1 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r4.next(), PackageRelationship.class, "com.obric.memorydata.plugin");
        int r2 = r0 + 1;
        if (r5 == r0) goto L10;
        r0 = r2;
        goto L7
    L10:
        return r1;
    L12:
        return null;
    L15:
        throw new IllegalArgumentException("index");
    }

    public PackageRelationship getRelationshipByID(String r2) {
        return (PackageRelationship) ZeusTransformUtils.preCheckCast(this.relationshipsByID.get(r2), PackageRelationship.class, "com.obric.memorydata.plugin");
    }

    public PackageRelationshipCollection getRelationships(String r2) {
        return new PackageRelationshipCollection(this, r2);
    }

    public boolean isEmpty() {
        return this.relationshipsByID.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<PackageRelationship> iterator() {
        return this.relationshipsByID.values().iterator();
    }

    public void parseRelationshipsPart(PackagePart r11) {
        LOG.atDebug().a("Parsing relationship: {}", r11.getPartName());     // Catch: Exception -> L38
        InputStream r12 = r11.getInputStream();     // Catch: Exception -> L38
        Document r0 = DocumentHelper.readDocument(r12);     // Catch: Throwable -> L29
        if (r12 == null) goto L6;
        r12.close();     // Catch: Exception -> L38
    L6:
        NodeList r13 = r0.getDocumentElement().getElementsByTagNameNS("http://schemas.openxmlformats.org/package/2006/relationships", "Relationship");     // Catch: Exception -> L38
        int r1 = r13.getLength();     // Catch: Exception -> L38
        int r2 = 0;
        boolean r3 = false;
    L7:
        if (r2 >= r1) goto L28;
        Element r4 = (Element) ZeusTransformUtils.preCheckCast(r13.item(r2), Element.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
        String r5 = r4.getAttribute("Id");     // Catch: Exception -> L38
        String r6 = r4.getAttribute("Type");     // Catch: Exception -> L38
        if (r6.equals("http://schemas.openxmlformats.org/package/2006/relationships/metadata/core-properties") == false) goto L14;
        if (r3 == true) goto L13;
        r3 = true;
        goto L14
    L13:
        throw new InvalidFormatException("OPC Compliance error [M4.1]: there is more than one core properties relationship in the package !");     // Catch: Exception -> L38
    L14:
        Attr r7 = r4.getAttributeNode("TargetMode");     // Catch: Exception -> L38
        TargetMode r8 = TargetMode.INTERNAL;     // Catch: Exception -> L38
        if (r7 != null) goto L17;
    L21:
        URI r9 = PackagingURIHelper.toURI("http://invalid.uri");     // Catch: Exception -> L38
        String r10 = r4.getAttribute("Target");     // Catch: Exception -> L38
        r9 = PackagingURIHelper.toURI(r10);     // Catch: URISyntaxException -> L24 Exception -> L38
    L26:
        addRelationship(r9, r8, r6, r5);     // Catch: Exception -> L38
        r2 = r2 + 1;
        goto L7
    L24:
        e = move-exception;
        LOG.atError().a(e).a("Cannot convert {} in a valid relationship URI-> dummy-URI used", r10);     // Catch: Exception -> L38
        goto L26
    L17:
        if (r7.getValue().toLowerCase(Locale.ROOT).equals("internal") == false) goto L19;
        TargetMode r14 = TargetMode.INTERNAL;     // Catch: Exception -> L38
    L20:
        r8 = r14;
        goto L21
    L19:
        r14 = TargetMode.EXTERNAL;     // Catch: Exception -> L38
        goto L20
    L28:
        return;
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        if (r12 != null) goto L41;
    L37:
        throw th;     // Catch: Exception -> L38
    L41:
        r12.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        throw new InvalidFormatException("Failed to parse relationships", e);
    }

    public void removeRelationship(String r3) {
        PackageRelationship r4 = (PackageRelationship) ZeusTransformUtils.preCheckCast(this.relationshipsByID.get(r3), PackageRelationship.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        this.relationshipsByID.remove(r4.getId());
        this.relationshipsByType.values().remove(r4);
        this.internalRelationshipsByTargetName.values().remove(r4);
        return;
    }

    public int size() {
        return this.relationshipsByID.size();
    }

    @Override // java.lang.Iterable
    public Spliterator<PackageRelationship> spliterator() {
        return this.relationshipsByID.values().spliterator();
    }

    public String toString() {
        String r0 = this.relationshipsByID.size() + " relationship(s) = [";
        PackagePart r1 = this.relationshipPart;
        if (r1 != null) goto L5;
    L7:
        StringBuilder r2 = new StringBuilder().append(r0).append("relationshipPart=null");
    L8:
        String r3 = r2.toString();
        PackagePart r4 = this.sourcePart;
        if (r4 != null) goto L11;
    L13:
        StringBuilder r5 = new StringBuilder().append(r3).append(",sourcePart=null");
    L14:
        String r6 = r5.toString();
        if (this.partName == null) goto L17;
        StringBuilder r7 = new StringBuilder().append(r6).append(",").append(this.partName);
    L19:
        return r7.toString() + "]";
    L17:
        r7 = new StringBuilder().append(r6).append(",uri=null)");
        goto L19
    L11:
        if (r4._partName == null) goto L13;
        r5 = new StringBuilder().append(r3).append(",").append(this.sourcePart._partName);
        goto L14
    L5:
        if (r1._partName == null) goto L7;
        r2 = new StringBuilder().append(r0).append(this.relationshipPart._partName);
        goto L8
    }
}
