package org.apache.poi.ooxml;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.exceptions.PartAlreadyExistsException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xddf.usermodel.chart.XDDFChart;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFRelation;
import org.threeten.bp.chrono.HijrahDate;

/* JADX INFO: loaded from: classes7.dex */
public class POIXMLDocumentPart {
    private static final c LOG = null;
    private String coreDocumentRel;
    private boolean isCommitted;
    private PackagePart packagePart;
    private POIXMLDocumentPart parent;
    private int relationCounter;
    private final Map<String, RelationPart> relations;

    public static class RelationPart {
        private final POIXMLDocumentPart documentPart;
        private final PackageRelationship relationship;

        RelationPart(PackageRelationship r1, POIXMLDocumentPart r2) {
            this.relationship = r1;
            this.documentPart = r2;
        }

        public <T extends POIXMLDocumentPart> T getDocumentPart() {
            return (T) this.documentPart;
        }

        public PackageRelationship getRelationship() {
            return this.relationship;
        }
    }

    static {
        LOG = b.a(POIXMLDocumentPart.class);
    }

    public POIXMLDocumentPart() {
        this.coreDocumentRel = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
        this.relations = new LinkedHashMap();
        this.isCommitted = false;
    }

    public POIXMLDocumentPart(POIXMLDocumentPart r2, PackagePart r3) {
        this.coreDocumentRel = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
        this.relations = new LinkedHashMap();
        this.isCommitted = false;
        this.packagePart = r3;
        this.parent = r2;
    }

    public POIXMLDocumentPart(OPCPackage r2) {
        this(r2, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
    }

    public POIXMLDocumentPart(OPCPackage r1, String r2) {
        this(getPartFromOPCPackage(r1, r2));
        this.coreDocumentRel = r2;
    }

    public POIXMLDocumentPart(PackagePart r2) {
        this(null, r2);
    }

    @Deprecated
    public static void _invokeOnDocumentRead(POIXMLDocumentPart r0) {
        r0.onDocumentRead();
    }

    private void addRelation(PackageRelationship r3, POIXMLDocumentPart r4) {
        this.relations.put(r3.getId(), new RelationPart(r3, r4));
        r4.incrementRelationCounter();
    }

    private static PackagePart getPartFromOPCPackage(OPCPackage r3, String r4) {
        PackageRelationship r5 = r3.getRelationshipsByType(r4).getRelationship(0);     // Catch: RuntimeException -> L15 POIXMLException -> L18
        if (r5 == null) goto L10;
        PackagePart r0 = r3.getPart(r5);     // Catch: RuntimeException -> L15 POIXMLException -> L18
        if (r0 == null) goto L7;
        return r0;
    L7:
        IOUtils.closeQuietly(r3);     // Catch: RuntimeException -> L15 POIXMLException -> L18
        throw new POIXMLException("OOXML file structure broken/invalid - core document '" + r5.getTargetURI() + "' not found.");     // Catch: RuntimeException -> L15 POIXMLException -> L18
    L10:
        if (r3.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument").getRelationship(0) == null) goto L13;
        IOUtils.closeQuietly(r3);     // Catch: RuntimeException -> L15 POIXMLException -> L18
        throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");     // Catch: RuntimeException -> L15 POIXMLException -> L18
    L13:
        IOUtils.closeQuietly(r3);     // Catch: RuntimeException -> L15 POIXMLException -> L18
        throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");     // Catch: RuntimeException -> L15 POIXMLException -> L18
    L18:
        e = move-exception;
        throw e;
    L15:
        e = move-exception;
        IOUtils.closeQuietly(r3);
        throw new POIXMLException("OOXML file structure broken/invalid", e);
    }

    private boolean removeRelation(String r4, boolean r5) {
        RelationPart r0 = (RelationPart) ZeusTransformUtils.preCheckCast(this.relations.get(r4), RelationPart.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        POIXMLDocumentPart r1 = r0.getDocumentPart();
        r1.decrementRelationCounter();
        getPackagePart().removeRelationship(r4);
        this.relations.remove(r4);
        if (r5 == true) goto L9;
        return true;
    L9:
        if (r1.getRelationCounter() != 0) goto L19;
        r1.onDocumentRemove();     // Catch: IOException -> L12
        getPackagePart().getPackage().removePart(r1.getPackagePart());
        return true;
    L12:
        e = move-exception;
        throw new POIXMLException(e);
    L19:
        return true;
    }

    public final RelationPart addRelation(String r4, POIXMLRelation r5, POIXMLDocumentPart r6) {
        PackageRelationship r0 = this.packagePart.findExistingRelation(r6.getPackagePart());
        if (r0 != null) goto L5;
        PackagePartName r1 = r6.getPackagePart().getPartName();
        String r7 = r5.getRelation();
        r0 = this.packagePart.addRelationship(r1, TargetMode.INTERNAL, r7, r4);
    L5:
        addRelation(r0, r6);
        return new RelationPart(r0, r6);
    }

    public void commit() {
    }

    public final RelationPart createRelationship(POIXMLRelation r5, POIXMLFactory r6, int r7, boolean r8) {
        PackagePartName r9 = PackagingURIHelper.createPartName(r5.getFileName(r7));     // Catch: Exception -> L10 PartAlreadyExistsException -> L13
        PackageRelationship r0 = null;
        PackagePart r1 = this.packagePart.getPackage().createPart(r9, r5.getContentType());     // Catch: Exception -> L10 PartAlreadyExistsException -> L13
        if (r8 == true) goto L5;
        r0 = this.packagePart.addRelationship(r9, TargetMode.INTERNAL, r5.getRelation());     // Catch: Exception -> L10 PartAlreadyExistsException -> L13
    L5:
        POIXMLDocumentPart r10 = r6.newDocumentPart(r5);     // Catch: Exception -> L10 PartAlreadyExistsException -> L13
        r10.packagePart = r1;     // Catch: Exception -> L10 PartAlreadyExistsException -> L13
        r10.parent = this;     // Catch: Exception -> L10 PartAlreadyExistsException -> L13
        if (r8 == true) goto L8;
        addRelation(r0, r10);     // Catch: Exception -> L10 PartAlreadyExistsException -> L13
    L8:
        return new RelationPart(r0, r10);
    L13:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        throw new POIXMLException(e);
    }

    public final POIXMLDocumentPart createRelationship(POIXMLRelation r3, POIXMLFactory r4) {
        return createRelationship(r3, r4, -1, false).getDocumentPart();
    }

    int decrementRelationCounter() {
        int r0 = this.relationCounter - 1;
        this.relationCounter = r0;
        return r0;
    }

    public final int getNextPartNumber(POIXMLRelation r4, int r5) {
        OPCPackage r3 = this.packagePart.getPackage();
        String r0 = r4.getDefaultFileName();     // Catch: InvalidFormatException -> L20
        if (r0.equals(r4.getFileName(HijrahDate.MAX_VALUE_OF_ERA)) == true) goto L6;
        if (r5 >= 0) goto L12;
        int r1 = 1;
    L13:
        int r6 = r5 + r3.getParts().size();     // Catch: InvalidFormatException -> L20
    L14:
        if (r1 > r6) goto L19;
        if (r3.containPart(PackagingURIHelper.createPartName(r4.getFileName(r1))) == false) goto L17;
        r1 = r1 + 1;
        goto L14
    L17:
        return r1;
    L19:
        return -1;
    L12:
        r1 = r5;
        goto L13
    L6:
        if (r3.containPart(PackagingURIHelper.createPartName(r0)) == false) goto L8;
        return -1;
    L8:
        return 0;
    L20:
        e = move-exception;
        throw new POIXMLException(e);
    }

    public final PackagePart getPackagePart() {
        return this.packagePart;
    }

    public final POIXMLDocumentPart getParent() {
        return this.parent;
    }

    public final POIXMLDocumentPart getRelationById(String r1) {
        RelationPart r0 = getRelationPartById(r1);
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getDocumentPart();
    }

    int getRelationCounter() {
        return this.relationCounter;
    }

    public final String getRelationId(POIXMLDocumentPart r4) {
        Iterator<RelationPart> r3 = this.relations.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        RelationPart r0 = (RelationPart) ZeusTransformUtils.preCheckCast(r3.next(), RelationPart.class, "com.obric.memorydata.plugin");
        if (r0.getDocumentPart() != r4) goto L4;
        return r0.getRelationship().getId();
    L9:
        return null;
    }

    public final RelationPart getRelationPartById(String r2) {
        return (RelationPart) ZeusTransformUtils.preCheckCast(this.relations.get(r2), RelationPart.class, "com.obric.memorydata.plugin");
    }

    public final List<RelationPart> getRelationParts() {
        return Collections.unmodifiableList(new ArrayList(this.relations.values()));
    }

    public final List<POIXMLDocumentPart> getRelations() {
        ArrayList r0 = new ArrayList();
        Iterator<RelationPart> r4 = this.relations.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        r0.add(((RelationPart) ZeusTransformUtils.preCheckCast(r4.next(), RelationPart.class, "com.obric.memorydata.plugin")).getDocumentPart());
        goto L4
    L7:
        return Collections.unmodifiableList(r0);
    }

    public PackagePart getTargetPart(PackageRelationship r1) {
        return getPackagePart().getRelatedPart(r1);
    }

    int incrementRelationCounter() {
        int r0 = this.relationCounter + 1;
        this.relationCounter = r0;
        return r0;
    }

    public void onDocumentCreate() {
    }

    public void onDocumentRead() {
    }

    public void onDocumentRemove() {
    }

    public final void onSave(Set<PackagePart> r4) {
        Set<PackagePart> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        if (this.isCommitted == false) goto L5;
        return;
    L5:
        prepareForCommit();
        commit();
        r5.add(getPackagePart());
        Iterator<RelationPart> r3 = this.relations.values().iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        POIXMLDocumentPart r0 = ((RelationPart) ZeusTransformUtils.preCheckCast(r3.next(), RelationPart.class, "com.obric.memorydata.plugin")).getDocumentPart();
        if (r5.contains(r0.getPackagePart()) == true) goto L7;
        r0.onSave(r5);
        goto L7
    }

    public void prepareForCommit() {
        PackagePart r0 = getPackagePart();
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void read(POIXMLFactory r10, Map<PackagePart, POIXMLDocumentPart> r11) {
        Map<PackagePart, POIXMLDocumentPart> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.memorydata.plugin");
        PackagePart r1 = getPackagePart();
        if (r1.getContentType().equals(XWPFRelation.GLOSSARY_DOCUMENT.getContentType()) == false) goto L6;
        LOG.atWarn().a("POI does not currently support template.main+xml (glossary) parts.  Skipping this part for now.");
        return;
    L6:
        POIXMLDocumentPart r3 = (POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r12.put(r1, this), POIXMLDocumentPart.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L13;
        if (r3 == this) goto L13;
        throw new POIXMLException("Unique PackagePart-POIXMLDocumentPart relation broken!");
    L13:
        if (r1.hasRelationships() == true) goto L15;
        return;
    L15:
        PackageRelationshipCollection r2 = this.packagePart.getRelationships();
        ArrayList r4 = new ArrayList();
        Iterator<PackageRelationship> r5 = r2.iterator();
    L17:
        if (r5.hasNext() == false) goto L36;
        PackageRelationship r6 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r5.next(), PackageRelationship.class, "com.obric.memorydata.plugin");
        if (r6.getTargetMode() != TargetMode.INTERNAL) goto L17;
        URI r7 = r6.getTargetURI();
        if (r7.getRawFragment() == null) goto L23;
        PackagePartName r8 = PackagingURIHelper.createPartName(r7.getPath());
    L24:
        PackagePart r9 = this.packagePart.getPackage().getPart(r8);
        if (r9 == null) goto L26;
        POIXMLDocumentPart r13 = (POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r12.get(r9), POIXMLDocumentPart.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L35;
        r13 = r10.createDocumentPart(this, r9);
        if (ZeusTransformUtils.instanceOf(this, XDDFChart.class) == true) goto L32;
    L34:
        r13.parent = this;
        r12.put(r9, r13);
        r4.add(r13);
        goto L35
    L32:
        if (ZeusTransformUtils.instanceOf(r13, XSSFWorkbook.class) == false) goto L34;
        ((XDDFChart) ZeusTransformUtils.preCheckCast(this, XDDFChart.class, "com.obric.memorydata.plugin")).setWorkbook((XSSFWorkbook) ZeusTransformUtils.preCheckCast(r13, XSSFWorkbook.class, "com.obric.memorydata.plugin"));
    L35:
        addRelation(r6, r13);
        goto L17
    L26:
        LOG.atError().a("Skipped invalid entry {}", r6.getTargetURI());
        goto L17
    L23:
        r8 = PackagingURIHelper.createPartName(r7);
        goto L24
    L36:
        Iterator r14 = r4.iterator();
    L38:
        if (r14.hasNext() == false) goto L40;
        ((POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r14.next(), POIXMLDocumentPart.class, "com.obric.memorydata.plugin")).read(r10, r12);
        goto L38
    }

    public final void rebase(OPCPackage r4) {
        PackageRelationshipCollection r5 = this.packagePart.getRelationshipsByType(this.coreDocumentRel);
        if (r5.size() != 1) goto L7;
        this.packagePart = this.packagePart.getRelatedPart(r5.getRelationship(0));
        return;
    L7:
        throw new IllegalStateException("Tried to rebase using " + this.coreDocumentRel + " but found " + r5.size() + " parts of the right type");
    }

    public final void removeRelation(POIXMLDocumentPart r2) {
        removeRelation(r2, true);
    }

    public final boolean removeRelation(POIXMLDocumentPart r1, boolean r2) {
        return removeRelation(getRelationId(r1), r2);
    }

    public void setCommitted(boolean r1) {
        this.isCommitted = r1;
    }

    public String toString() {
        PackagePart r0 = this.packagePart;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0.toString();
    }
}
