package org.apache.poi.xssf.eventusermodel;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFReader {
    private static final c LOGGER = null;
    private static final Set<String> WORKSHEET_RELS = null;
    protected OPCPackage pkg;
    protected PackagePart workbookPart;

    public static class SheetIterator implements Iterator<InputStream> {
        protected final Iterator<XSSFSheetRef> sheetIterator;
        protected final Map<String, PackagePart> sheetMap;
        protected XSSFSheetRef xssfSheetRef;

        public SheetIterator(PackagePart r7) {
            this.sheetMap = new HashMap();     // Catch: InvalidFormatException -> L11
            OPCPackage r0 = r7.getPackage();     // Catch: InvalidFormatException -> L11
            Set<String> r1 = getSheetRelationships();     // Catch: InvalidFormatException -> L11
            Iterator<PackageRelationship> r2 = r7.getRelationships().iterator();     // Catch: InvalidFormatException -> L11
        L5:
            if (r2.hasNext() == false) goto L9;
            PackageRelationship r3 = (PackageRelationship) ZeusTransformUtils.preCheckCast(r2.next(), PackageRelationship.class, "com.obric.memorydata.plugin");     // Catch: InvalidFormatException -> L11
            if (r1.contains(r3.getRelationshipType()) == false) goto L5;
            PackagePartName r4 = PackagingURIHelper.createPartName(r3.getTargetURI());     // Catch: InvalidFormatException -> L11
            this.sheetMap.put(r3.getId(), r0.getPart(r4));     // Catch: InvalidFormatException -> L11
            goto L5
        L9:
            this.sheetIterator = createSheetIteratorFromWB(r7);     // Catch: InvalidFormatException -> L11
            return;
        L11:
            e = move-exception;
            throw new POIXMLException(e);
        }

        public Iterator<XSSFSheetRef> createSheetIteratorFromWB(PackagePart r4) {
            XMLSheetRefReader r3 = new XMLSheetRefReader();
            XMLReader r0 = XMLHelper.newXMLReader();     // Catch: Throwable -> L31
            r0.setContentHandler(r3);
            InputStream r5 = r4.getInputStream();     // Catch: SAXException -> L28
            r0.parse(new InputSource(r5));     // Catch: Throwable -> L19
            if (r5 == null) goto L9;
            r5.close();     // Catch: SAXException -> L28
        L9:
            ArrayList r6 = new ArrayList();
            Iterator<XSSFSheetRef> r7 = r3.getSheetRefs().iterator();
        L11:
            if (r7.hasNext() == false) goto L18;
            XSSFSheetRef r1 = (XSSFSheetRef) ZeusTransformUtils.preCheckCast(r7.next(), XSSFSheetRef.class, "com.obric.memorydata.plugin");
            String r2 = r1.getId();
            if (r2 == null) goto L11;
            if (r2.length() <= 0) goto L11;
            r6.add(r1);
            goto L11
        L18:
            return r6.iterator();
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L21
        L21:
            th = move-exception;
            if (r5 != null) goto L41;
        L27:
            throw th;     // Catch: SAXException -> L28
        L41:
            r5.close();     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            th.addSuppressed(th);     // Catch: SAXException -> L28
        L28:
            e = move-exception;
            throw new POIXMLException(e);
        L31:
            e = move-exception;
            throw new POIXMLException(e);
        }

        public String getSheetName() {
            return this.xssfSheetRef.getName();
        }

        public PackagePart getSheetPart() {
            String r0 = this.xssfSheetRef.getId();
            return (PackagePart) ZeusTransformUtils.preCheckCast(this.sheetMap.get(r0), PackagePart.class, "com.obric.memorydata.plugin");
        }

        public Set<String> getSheetRelationships() {
            return XSSFReader.access$000();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.sheetIterator.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public InputStream next() {
            XSSFSheetRef r0 = (XSSFSheetRef) ZeusTransformUtils.preCheckCast(this.sheetIterator.next(), XSSFSheetRef.class, "com.obric.memorydata.plugin");
            this.xssfSheetRef = r0;
            String r1 = r0.getId();
            return ((PackagePart) ZeusTransformUtils.preCheckCast(this.sheetMap.get(r1), PackagePart.class, "com.obric.memorydata.plugin")).getInputStream();
        L5:
            e = move-exception;
            throw new POIXMLException(e);
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ InputStream next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException("Not supported");
        }
    }

    public static class XMLSheetRefReader extends DefaultHandler {
        private final List<XSSFSheetRef> sheetRefs;

        public XMLSheetRefReader() {
            this.sheetRefs = new LinkedList();
        }

        public List<XSSFSheetRef> getSheetRefs() {
            return Collections.unmodifiableList(this.sheetRefs);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String r3, String r4, String r5, Attributes r6) {
            Attributes r7 = (Attributes) ZeusTransformUtils.wrapperContextForParams(r6, Attributes.class, "com.obric.memorydata.plugin");
            if (r4.equalsIgnoreCase("sheet") == false) goto L17;
            int r8 = 0;
            String r9 = null;
            String r10 = null;
        L6:
            if (r8 >= r7.getLength()) goto L23;
            String r0 = r7.getLocalName(r8);
            if (r0.equalsIgnoreCase(ActivityLifecycle.NAME) == false) goto L11;
            r9 = r7.getValue(r8);
        L13:
            if (r9 == null) goto L16;
            if (r10 == null) goto L16;
            this.sheetRefs.add(new XSSFSheetRef(r10, r9));
            return;
        L16:
            r8 = r8 + 1;
            goto L6
        L11:
            if (r0.equalsIgnoreCase(OaidModel.KEY_ID) == false) goto L13;
            r10 = r7.getValue(r8);
            goto L13
        L23:
            return;
        }
    }

    public static final class XSSFSheetRef {
        private final String id;
        private final String name;

        public XSSFSheetRef(String r1, String r2) {
            this.id = r1;
            this.name = r2;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }
    }

    static {
        WORKSHEET_RELS = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{XSSFRelation.WORKSHEET.getRelation(), XSSFRelation.CHARTSHEET.getRelation(), XSSFRelation.MACRO_SHEET_BIN.getRelation()})));
        LOGGER = b.a(XSSFReader.class);
    }

    public XSSFReader(OPCPackage r2) {
        this(r2, false);
    }

    public XSSFReader(OPCPackage r3, boolean r4) {
        this.pkg = r3;
        PackageRelationship r5 = r3.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument").getRelationship(0);
        if (r5 == null) goto L5;
    L15:
        this.workbookPart = this.pkg.getPart(r5);
        return;
    L5:
        if (r4 == false) goto L8;
        r5 = this.pkg.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument").getRelationship(0);
    L9:
        if (r5 != null) goto L15;
        throw new POIXMLException("OOXML file structure broken/invalid - no core document found!");
    L8:
        if (this.pkg.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument").getRelationship(0) == null) goto L9;
        throw new POIXMLException("Strict OOXML isn't currently supported, please see bug #57699");
    }

    static /* synthetic */ Set access$000() {
        return WORKSHEET_RELS;
    }

    public Iterator<InputStream> getSheetsData() {
        return new SheetIterator(this.workbookPart);
    }

    public StylesTable getStylesTable() {
        ArrayList<PackagePart> r0 = this.pkg.getPartsByContentType(XSSFRelation.STYLES.getContentType());
        if (r0.isEmpty() == false) goto L6;
        return null;
    L6:
        StylesTable r1 = new StylesTable((PackagePart) ZeusTransformUtils.preCheckCast(r0.get(0), PackagePart.class, "com.obric.memorydata.plugin"));
        ArrayList<PackagePart> r5 = this.pkg.getPartsByContentType(XSSFRelation.THEME.getContentType());
        if (r5.size() == 0) goto L9;
        r1.setTheme(new ThemesTable((PackagePart) ZeusTransformUtils.preCheckCast(r5.get(0), PackagePart.class, "com.obric.memorydata.plugin")));
    L9:
        return r1;
    }

    public InputStream getWorkbookData() {
        return this.workbookPart.getInputStream();
    }
}
