package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Spliterator;
import java.util.regex.Pattern;
import javax.xml.namespace.QName;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ooxml.POIXMLException;
import org.apache.poi.ooxml.POIXMLTypeLoader;
import org.apache.poi.ooxml.util.PackageHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackageAccess;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Date1904Support;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.XLSBUnsupportedException;
import org.apache.poi.xssf.model.CalculationChain;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.apache.poi.xssf.model.MapInfo;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ay;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.az;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.bl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.dl;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ef;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fj;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.fk;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.gt;

/* JADX INFO: loaded from: classes7.dex */
public class XSSFWorkbook extends POIXMLDocument implements Date1904Support, Workbook {
    private static final Pattern COMMA_PATTERN = null;
    private static final Pattern GET_ALL_PICTURES_PATTERN = null;
    private static final c LOG = null;
    private XSSFCreationHelper _creationHelper;
    private Row.MissingCellPolicy _missingCellPolicy;
    private final IndexedUDFFinder _udfFinder;
    private CalculationChain calcChain;
    private boolean cellFormulaValidation;
    private List<ExternalLinksTable> externalLinks;
    private MapInfo mapInfo;
    private List<XSSFName> namedRanges;
    private ListValuedMap<String, XSSFName> namedRangesByName;
    private List<XSSFPictureData> pictures;
    private List<dl> pivotCaches;
    private List<XSSFPivotTable> pivotTables;
    private SharedStringsTable sharedStringSource;
    private List<XSSFSheet> sheets;
    private StylesTable stylesSource;
    private fj workbook;
    private final XSSFFactory xssfFactory;

    private final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<T> it;
        final /* synthetic */ XSSFWorkbook this$0;

        public SheetIterator(XSSFWorkbook r1) {
            this.this$0 = r1;
            this.it = XSSFWorkbook.access$000(r1).iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.it.hasNext();
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) ZeusTransformUtils.preCheckCast(this.it.next(), Sheet.class, "com.obric.memorydata.plugin");
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }
    }

    static {
        COMMA_PATTERN = Pattern.compile(",");
        GET_ALL_PICTURES_PATTERN = Pattern.compile("/xl/media/.*?");
        LOG = b.a(XSSFWorkbook.class);
    }

    public XSSFWorkbook() {
        this(XSSFWorkbookType.XLSX);
    }

    public XSSFWorkbook(InputStream r2) {
        this(r2, false);
    }

    private XSSFWorkbook(InputStream r1, boolean r2) {
        this(PackageHelper.open(r1, r2));
    }

    public XSSFWorkbook(OPCPackage r5) {
        super(r5);
        this._udfFinder = new IndexedUDFFinder(new UDFFinder[]{AggregatingUDFFinder.DEFAULT});
        this._missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this.cellFormulaValidation = true;
        XSSFFactory r6 = XSSFFactory.getInstance();
        this.xssfFactory = r6;
        beforeDocumentRead();
        load(r6);
        setBookViewsIfMissing();
    }

    public XSSFWorkbook(PackagePart r2) {
        this(r2.getInputStream(), true);
    }

    public XSSFWorkbook(XSSFWorkbookType r2) {
        this(r2, null);
    }

    private XSSFWorkbook(XSSFWorkbookType r5, XSSFFactory r6) {
        super(newPackage(r5));
        this._udfFinder = new IndexedUDFFinder(new UDFFinder[]{AggregatingUDFFinder.DEFAULT});
        this._missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this.cellFormulaValidation = true;
        if (r6 != null) goto L5;
        r6 = XSSFFactory.getInstance();
    L5:
        this.xssfFactory = r6;
        onWorkbookCreate();
    }

    static /* synthetic */ List access$000(XSSFWorkbook r0) {
        return r0.sheets;
    }

    private ef addSheet(String r1) {
        ef r0 = this.workbook.getSheets().addNewSheet();
        r0.setName(r1);
        return r0;
    }

    private boolean containsSheet(String r6, int r7) {
        ef[] r5 = this.workbook.getSheets().getSheetArray();
        if (r6.length() <= 31) goto L5;
        r6 = r6.substring(0, 31);
    L5:
        int r0 = 0;
    L7:
        if (r0 >= r5.length) goto L17;
        String r3 = r5[r0].getName();
        if (r3.length() <= 31) goto L11;
        r3 = r3.substring(0, 31);
    L11:
        if (r7 == r0) goto L16;
        if (r6.equalsIgnoreCase(r3) == false) goto L16;
        return true;
    L16:
        r0 = r0 + 1;
        goto L7
    L17:
        return false;
    }

    private XSSFName createAndStoreName(ay r3) {
        ay r4 = (ay) ZeusTransformUtils.wrapperContextForParams(r3, ay.class, "com.obric.memorydata.plugin");
        XSSFName r0 = new XSSFName(r4, this);
        this.namedRanges.add(r0);
        this.namedRangesByName.put(r4.getName().toLowerCase(Locale.ENGLISH), r0);
        return r0;
    }

    public static OPCPackage newPackage(XSSFWorkbookType r4) {
        OPCPackage r0 = null;
        r0 = OPCPackage.create(new UnsynchronizedByteArrayOutputStream());     // Catch: Exception -> L5
        PackagePartName r1 = PackagingURIHelper.createPartName(XSSFRelation.WORKBOOK.getDefaultFileName());     // Catch: Exception -> L5
        r0.addRelationship(r1, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");     // Catch: Exception -> L5
        r0.createPart(r1, r4.getContentType());     // Catch: Exception -> L5
        r0.getPackageProperties().setCreatorProperty("Apache POI");     // Catch: Exception -> L5
        return r0;
    L5:
        e = move-exception;
        IOUtils.closeQuietly(r0);
        throw new POIXMLException(e);
    }

    private void onWorkbookCreate() {
        fj r0 = (fj) ZeusTransformUtils.preCheckCast(fj.f19691a.newInstance(), fj.class, "com.obric.memorydata.plugin");
        this.workbook = r0;
        r0.addNewWorkbookPr().setDate1904(false);
        setBookViewsIfMissing();
        this.workbook.addNewSheets();
        getProperties().getExtendedProperties().getUnderlyingProperties().setApplication("Apache POI");
        this.sharedStringSource = (SharedStringsTable) ZeusTransformUtils.preCheckCast(createRelationship(XSSFRelation.SHARED_STRINGS, this.xssfFactory), SharedStringsTable.class, "com.obric.memorydata.plugin");
        StylesTable r1 = (StylesTable) ZeusTransformUtils.preCheckCast(createRelationship(XSSFRelation.STYLES, this.xssfFactory), StylesTable.class, "com.obric.memorydata.plugin");
        this.stylesSource = r1;
        r1.setWorkbook(this);
        this.namedRanges = new ArrayList();
        this.namedRangesByName = new ArrayListValuedHashMap();
        this.sheets = new ArrayList();
        this.pivotTables = new ArrayList();
        this.externalLinks = new ArrayList();
    }

    private void reprocessNamedRanges() {
        this.namedRangesByName = new ArrayListValuedHashMap();
        this.namedRanges = new ArrayList();
        if (this.workbook.isSetDefinedNames() == false) goto L7;
        ay[] r0 = this.workbook.getDefinedNames().getDefinedNameArray();
        int r1 = r0.length;
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L9;
        createAndStoreName(r0[r2]);
        r2 = r2 + 1;
        goto L5
    L9:
        return;
    }

    private void saveCalculationChain() {
        CalculationChain r0 = this.calcChain;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getCTCalcChain().sizeOfCArray() != 0) goto L9;
        removeRelation(this.calcChain);
        this.calcChain = null;
        return;
    }

    private void saveNamedRanges() {
        if (this.namedRanges.isEmpty() == true) goto L13;
        az r0 = (az) ZeusTransformUtils.preCheckCast(az.f19457a.newInstance(), az.class, "com.obric.memorydata.plugin");
        ay[] r1 = new ay[this.namedRanges.size()];
        int r3 = 0;
        Iterator<XSSFName> r4 = this.namedRanges.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r1[r3] = ((XSSFName) ZeusTransformUtils.preCheckCast(r4.next(), XSSFName.class, "com.obric.memorydata.plugin")).getCTName();
        r3 = r3 + 1;
        goto L6
    L8:
        r0.setDefinedNameArray(r1);
        if (this.workbook.isSetDefinedNames() == false) goto L11;
        this.workbook.unsetDefinedNames();
    L11:
        this.workbook.setDefinedNames(r0);
        reprocessNamedRanges();
        return;
    L13:
        if (this.workbook.isSetDefinedNames() == false) goto L18;
        this.workbook.unsetDefinedNames();
        return;
    }

    private void setBookViewsIfMissing() {
        if (this.workbook.isSetBookViews() == true) goto L6;
        this.workbook.addNewBookViews().addNewWorkbookView().setActiveTab(0);
        return;
    }

    private void validateSheetIndex(int r4) {
        int r3 = this.sheets.size() - 1;
        if (r4 < 0) goto L7;
        if (r4 > r3) goto L7;
        return;
    L7:
        String r0 = "(0.." + r3 + ")";
        if (r3 != (-1)) goto L11;
        r0 = "(no sheets)";
    L11:
        throw new IllegalArgumentException("Sheet index (" + r4 + ") is out of range " + r0);
    }

    private void validateSheetName(String r3) {
        if (containsSheet(r3, this.sheets.size()) == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("The workbook already contains a sheet named '" + r3 + "'");
    }

    public void beforeDocumentRead() {
        if (getCorePart().getContentType().equals(XSSFRelation.XLSB_BINARY_WORKBOOK.getContentType()) == true) goto L7;
        this.pivotTables = new ArrayList();
        this.pivotCaches = new ArrayList();
        return;
    L7:
        throw new XLSBUnsupportedException();
    }

    @Override // org.apache.poi.ooxml.POIXMLDocument, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();     // Catch: Throwable -> L5
        IOUtils.closeQuietly(this.sharedStringSource);
        return;
    L5:
        th = move-exception;
        IOUtils.closeQuietly(this.sharedStringSource);
        throw th;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void commit() {
        saveNamedRanges();
        saveCalculationChain();
        XmlOptions r0 = new XmlOptions(POIXMLTypeLoader.DEFAULT_XML_OPTIONS);
        r0.setSaveSyntheticDocumentElement(new QName(fj.f19692b.getName().getNamespaceURI(), "workbook"));
        OutputStream r1 = getPackagePart().getOutputStream();
        this.workbook.save(r1, r0);     // Catch: Throwable -> L7
        if (r1 == null) goto L22;
        r1.close();
        return;
    L22:
        return;
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        if (r1 != null) goto L20;
    L15:
        throw th;
    L20:
        r1.close();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.addSuppressed(th);
        goto L15
    }

    public XSSFName createName() {
        ay r0 = (ay) ZeusTransformUtils.preCheckCast(ay.c.newInstance(), ay.class, "com.obric.memorydata.plugin");
        r0.setName("");
        return createAndStoreName(r0);
    }

    public XSSFSheet createSheet(String r9) {
        if (r9 == null) goto L25;
        validateSheetName(r9);
        if (r9.length() <= 31) goto L6;
        String r0 = r9.substring(0, 31);
        LOG.atWarn().a("Sheet '{}' will be added with a trimmed name '{}' for MS Excel compliance.", r9, r0);
        r9 = r0;
    L6:
        WorkbookUtil.validateSheetName(r9);
        ef r10 = addSheet(r9);
        int r2 = 1;
    L7:
        Iterator<XSSFSheet> r3 = this.sheets.iterator();
    L9:
        if (r3.hasNext() == false) goto L11;
        r2 = (int) Math.max(((XSSFSheet) ZeusTransformUtils.preCheckCast(r3.next(), XSSFSheet.class, "com.obric.memorydata.plugin")).sheet.getSheetId() + 1, r2);
        goto L9
    L11:
        String r4 = XSSFRelation.WORKSHEET.getFileName(r2);
        Iterator<POIXMLDocumentPart> r5 = getRelations().iterator();
    L13:
        if (r5.hasNext() == false) goto L19;
        POIXMLDocumentPart r6 = (POIXMLDocumentPart) ZeusTransformUtils.preCheckCast(r5.next(), POIXMLDocumentPart.class, "com.obric.memorydata.plugin");
        if (r6.getPackagePart() == null) goto L13;
        if (r4.equals(r6.getPackagePart().getPartName().getName()) == false) goto L13;
        r2 = r2 + 1;
        goto L7
    L19:
        POIXMLDocumentPart.RelationPart r1 = createRelationship(XSSFRelation.WORKSHEET, this.xssfFactory, r2, false);
        XSSFSheet r7 = (XSSFSheet) ZeusTransformUtils.preCheckCast(r1.getDocumentPart(), XSSFSheet.class, "com.obric.memorydata.plugin");
        r7.sheet = r10;
        r10.setId(r1.getRelationship().getId());
        r10.setSheetId(r2);
        if (this.sheets.isEmpty() == false) goto L22;
        r7.setSelected(true);
    L22:
        this.sheets.add(r7);
        return r7;
    L25:
        throw new IllegalArgumentException("sheetName must not be null");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return (int) this.workbook.getBookViews().getWorkbookViewArray(0).getActiveTab();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<XSSFPictureData> getAllPictures() {
        if (this.pictures != null) goto L9;
        List<PackagePart> r0 = getPackage().getPartsByName(GET_ALL_PICTURES_PATTERN);
        this.pictures = new ArrayList(r0.size());
        Iterator<PackagePart> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L9;
        PackagePart r2 = (PackagePart) ZeusTransformUtils.preCheckCast(r1.next(), PackagePart.class, "com.obric.memorydata.plugin");
        this.pictures.add(new XSSFPictureData(r2));
    L9:
        return this.pictures;
    }

    public boolean getCellFormulaValidation() {
        return this.cellFormulaValidation;
    }

    public XSSFCellStyle getCellStyleAt(int r1) {
        return this.stylesSource.getStyleAt(r1);
    }

    public XSSFCreationHelper getCreationHelper() {
        if (this._creationHelper != null) goto L6;
        this._creationHelper = new XSSFCreationHelper(this);
    L6:
        return this._creationHelper;
    }

    public List<ExternalLinksTable> getExternalLinksTable() {
        return this.externalLinks;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Font getFontAt(int r1) {
        return getFontAt(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFFont getFontAt(int r1) {
        return this.stylesSource.getFontAt(r1);
    }

    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._missingCellPolicy;
    }

    public XSSFName getName(String r2) {
        List<XSSFName> r1 = getNames(r2);
        if (r1.isEmpty() == false) goto L7;
        return null;
    L7:
        return (XSSFName) ZeusTransformUtils.preCheckCast(r1.iterator().next(), XSSFName.class, "com.obric.memorydata.plugin");
    }

    @Deprecated
    XSSFName getNameAt(int r5) {
        int r0 = this.namedRanges.size();
        if (r0 < 1) goto L11;
        if (r5 < 0) goto L9;
        if (r5 > r0) goto L9;
        return (XSSFName) ZeusTransformUtils.preCheckCast(this.namedRanges.get(r5), XSSFName.class, "com.obric.memorydata.plugin");
    L9:
        throw new IllegalArgumentException("Specified name index " + r5 + " is outside the allowable range (0.." + (r0 - 1) + ").");
    L11:
        throw new IllegalStateException("There are no defined names in this workbook");
    }

    @Deprecated
    int getNameIndex(String r1) {
        XSSFName r2 = getName(r1);
        if (r2 != null) goto L5;
        return -1;
    L5:
        return this.namedRanges.indexOf(r2);
    }

    public List<XSSFName> getNames(String r2) {
        return Collections.unmodifiableList(this.namedRangesByName.get(r2.toLowerCase(Locale.ENGLISH)));
    }

    public int getNumberOfNames() {
        return this.namedRanges.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this.sheets.size();
    }

    public List<XSSFPivotTable> getPivotTables() {
        return this.pivotTables;
    }

    public SharedStringsTable getSharedStringSource() {
        return this.sharedStringSource;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Sheet getSheet(String r1) {
        return getSheet(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheet(String r4) {
        Iterator<XSSFSheet> r3 = this.sheets.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        XSSFSheet r0 = (XSSFSheet) ZeusTransformUtils.preCheckCast(r3.next(), XSSFSheet.class, "com.obric.memorydata.plugin");
        if (r4.equalsIgnoreCase(r0.getSheetName()) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Sheet getSheetAt(int r1) {
        return getSheetAt(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public XSSFSheet getSheetAt(int r2) {
        validateSheetIndex(r2);
        return (XSSFSheet) ZeusTransformUtils.preCheckCast(this.sheets.get(r2), XSSFSheet.class, "com.obric.memorydata.plugin");
    }

    public int getSheetIndex(String r5) {
        Iterator<XSSFSheet> r4 = this.sheets.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (r5.equalsIgnoreCase(((XSSFSheet) ZeusTransformUtils.preCheckCast(r4.next(), XSSFSheet.class, "com.obric.memorydata.plugin")).getSheetName()) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public int getSheetIndex(Sheet r5) {
        Sheet r6 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r5, Sheet.class, "com.obric.memorydata.plugin");
        Iterator<XSSFSheet> r4 = this.sheets.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (((XSSFSheet) ZeusTransformUtils.preCheckCast(r4.next(), XSSFSheet.class, "com.obric.memorydata.plugin")) == r6) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    public String getSheetName(int r2) {
        validateSheetIndex(r2);
        return ((XSSFSheet) ZeusTransformUtils.preCheckCast(this.sheets.get(r2), XSSFSheet.class, "com.obric.memorydata.plugin")).getSheetName();
    }

    public StylesTable getStylesSource() {
        return this.stylesSource;
    }

    UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    public XSSFFactory getXssfFactory() {
        return this.xssfFactory;
    }

    @Override // org.apache.poi.ss.usermodel.Date1904Support
    public boolean isDate1904() {
        fk r0 = this.workbook.getWorkbookPr();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getDate1904() == false) goto L7;
        return true;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Iterator<Sheet> iterator() {
        return sheetIterator();
    }

    public void onDeleteFormula(XSSFCell r3) {
        if (this.calcChain == null) goto L6;
        int r0 = (int) r3.getSheet().sheet.getSheetId();
        this.calcChain.removeItem(r0, r3.getReference());
        return;
    }

    @Override // org.apache.poi.ooxml.POIXMLDocumentPart
    public void onDocumentRead() {
        InputStream r1 = getPackagePart().getInputStream();     // Catch: XmlException -> L78
        this.workbook = ((gt) ZeusTransformUtils.preCheckCast(gt.f19759a.parse(r1, POIXMLTypeLoader.DEFAULT_XML_OPTIONS), gt.class, "com.obric.memorydata.plugin")).getWorkbook();     // Catch: Throwable -> L69
        if (r1 == null) goto L7;
        r1.close();     // Catch: XmlException -> L78
    L7:
        ThemesTable r2 = null;
        HashMap r3 = new HashMap();     // Catch: XmlException -> L78
        HashMap r4 = new HashMap();     // Catch: XmlException -> L78
        Iterator<POIXMLDocumentPart.RelationPart> r5 = getRelationParts().iterator();     // Catch: XmlException -> L78
    L9:
        if (r5.hasNext() == false) goto L31;
        POIXMLDocumentPart.RelationPart r6 = (POIXMLDocumentPart.RelationPart) ZeusTransformUtils.preCheckCast(r5.next(), POIXMLDocumentPart.RelationPart.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
        POIXMLDocumentPart r7 = r6.getDocumentPart();     // Catch: XmlException -> L78
        if (ZeusTransformUtils.instanceOf(r7, SharedStringsTable.class) == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r7, StylesTable.class) == true) goto L15;
        if (ZeusTransformUtils.instanceOf(r7, ThemesTable.class) == true) goto L18;
        if (ZeusTransformUtils.instanceOf(r7, CalculationChain.class) == true) goto L21;
        if (ZeusTransformUtils.instanceOf(r7, MapInfo.class) == true) goto L24;
        if (ZeusTransformUtils.instanceOf(r7, XSSFSheet.class) == true) goto L27;
        if (ZeusTransformUtils.instanceOf(r7, ExternalLinksTable.class) == false) goto L9;
        r4.put(r6.getRelationship().getId(), (ExternalLinksTable) ZeusTransformUtils.preCheckCast(r7, ExternalLinksTable.class, "com.obric.memorydata.plugin"));     // Catch: XmlException -> L78
        goto L9
    L27:
        r3.put(r6.getRelationship().getId(), (XSSFSheet) ZeusTransformUtils.preCheckCast(r7, XSSFSheet.class, "com.obric.memorydata.plugin"));     // Catch: XmlException -> L78
        goto L9
    L24:
        this.mapInfo = (MapInfo) ZeusTransformUtils.preCheckCast(r7, MapInfo.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
        goto L9
    L21:
        this.calcChain = (CalculationChain) ZeusTransformUtils.preCheckCast(r7, CalculationChain.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
        goto L9
    L18:
        r2 = (ThemesTable) ZeusTransformUtils.preCheckCast(r7, ThemesTable.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
        goto L9
    L15:
        this.stylesSource = (StylesTable) ZeusTransformUtils.preCheckCast(r7, StylesTable.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
        goto L9
    L12:
        this.sharedStringSource = (SharedStringsTable) ZeusTransformUtils.preCheckCast(r7, SharedStringsTable.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
        goto L9
    L31:
        int r8 = 0;
        if (getPackage().getPackageAccess() != PackageAccess.READ) goto L34;
        boolean r9 = true;
    L36:
        if (this.stylesSource != null) goto L41;
        if (r9 == false) goto L40;
        StylesTable r10 = new StylesTable();     // Catch: XmlException -> L78
    L39:
        this.stylesSource = r10;     // Catch: XmlException -> L78
        goto L41
    L40:
        r10 = (StylesTable) ZeusTransformUtils.preCheckCast(createRelationship(XSSFRelation.STYLES, this.xssfFactory), StylesTable.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
    L41:
        this.stylesSource.setWorkbook(this);     // Catch: XmlException -> L78
        this.stylesSource.setTheme(r2);     // Catch: XmlException -> L78
        if (this.sharedStringSource != null) goto L47;
        if (r9 == false) goto L46;
        SharedStringsTable r11 = new SharedStringsTable();     // Catch: XmlException -> L78
    L45:
        this.sharedStringSource = r11;     // Catch: XmlException -> L78
        goto L47
    L46:
        r11 = (SharedStringsTable) ZeusTransformUtils.preCheckCast(createRelationship(XSSFRelation.SHARED_STRINGS, this.xssfFactory), SharedStringsTable.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
    L47:
        this.sheets = new ArrayList(r3.size());     // Catch: XmlException -> L78
        fj r12 = this.workbook;     // Catch: XmlException -> L78
        if (r12 == null) goto L68;
        if (r12.getSheets() == null) goto L68;
        if (this.workbook.getSheets().getSheetArray() == null) goto L68;
        ef[] r13 = this.workbook.getSheets().getSheetArray();     // Catch: XmlException -> L78
        int r14 = r13.length;     // Catch: XmlException -> L78
        int r15 = 0;
    L54:
        if (r15 >= r14) goto L56;
        parseSheet(r3, r13[r15]);     // Catch: XmlException -> L78
        r15 = r15 + 1;     // Catch: XmlException -> L78
        goto L54
    L56:
        this.externalLinks = new ArrayList(r4.size());     // Catch: XmlException -> L78
        if (this.workbook.isSetExternalReferences() == false) goto L65;
        bl[] r16 = this.workbook.getExternalReferences().getExternalReferenceArray();     // Catch: XmlException -> L78
        int r17 = r16.length;     // Catch: XmlException -> L78
    L59:
        if (r8 >= r17) goto L65;
        bl r18 = r16[r8];     // Catch: XmlException -> L78
        ExternalLinksTable r19 = (ExternalLinksTable) ZeusTransformUtils.preCheckCast(r4.get(r18.getId()), ExternalLinksTable.class, "com.obric.memorydata.plugin");     // Catch: XmlException -> L78
        if (r19 != null) goto L63;
        LOG.atWarn().a("ExternalLinksTable with r:id {} was defined, but didn't exist in package, skipping", r18.getId());     // Catch: XmlException -> L78
    L64:
        r8 = r8 + 1;     // Catch: XmlException -> L78
        goto L59
    L63:
        this.externalLinks.add(r19);     // Catch: XmlException -> L78
    L65:
        reprocessNamedRanges();     // Catch: XmlException -> L78
        return;
    L68:
        throw new POIXMLException("Cannot read a workbook without sheets");     // Catch: XmlException -> L78
    L34:
        r9 = false;
        goto L36
    L69:
        th = move-exception;
        throw th;     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        if (r1 != null) goto L81;
    L77:
        throw th;     // Catch: XmlException -> L78
    L81:
        r1.close();     // Catch: Throwable -> L75
    L75:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlException -> L78
    L78:
        e = move-exception;
        throw new POIXMLException(e);
    }

    public void parseSheet(Map<String, XSSFSheet> r3, ef r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        ef r6 = (ef) ZeusTransformUtils.wrapperContextForParams(r4, ef.class, "com.obric.memorydata.plugin");
        XSSFSheet r7 = (XSSFSheet) ZeusTransformUtils.preCheckCast(r5.get(r6.getId()), XSSFSheet.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L6;
        LOG.atWarn().a("Sheet with name {} and r:id {} was defined, but didn't exist in package, skipping", r6.getName(), r6.getId());
        return;
    L6:
        r7.sheet = r6;
        r7.onDocumentRead();
        this.sheets.add(r7);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Spliterator<Sheet> spliterator() {
        return this.sheets.spliterator();
    }

    void updateName(XSSFName r3, String r4) {
        if (this.namedRangesByName.removeMapping(r4.toLowerCase(Locale.ENGLISH), r3) == false) goto L7;
        this.namedRangesByName.put(r3.getNameName().toLowerCase(Locale.ENGLISH), r3);
        return;
    L7:
        throw new IllegalArgumentException("Name was not found: " + r3);
    }
}
