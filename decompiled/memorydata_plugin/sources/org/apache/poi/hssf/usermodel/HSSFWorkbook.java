package org.apache.poi.hssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.regex.Pattern;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.POIDocument;
import org.apache.poi.ddf.EscherBSERecord;
import org.apache.poi.ddf.EscherBlipRecord;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.hssf.OldExcelFormatException;
import org.apache.poi.hssf.model.InternalSheet;
import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.AbstractEscherHolderRecord;
import org.apache.poi.hssf.record.FilePassRecord;
import org.apache.poi.hssf.record.LabelRecord;
import org.apache.poi.hssf.record.LabelSSTRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.DirectoryNode;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.formula.udf.AggregatingUDFFinder;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.Configurator;

/* JADX INFO: loaded from: classes7.dex */
public final class HSSFWorkbook extends POIDocument implements Workbook {
    private static final Pattern COMMA_PATTERN = null;
    public static final int INITIAL_CAPACITY = 0;
    private static final c LOGGER = null;
    private static int MAX_IMAGE_LENGTH = 50000000;
    private static int MAX_RECORD_LENGTH = 100000;
    protected List<HSSFSheet> _sheets;
    private final UDFFinder _udfFinder;
    private Map<Integer, HSSFFont> fonts;
    private Row.MissingCellPolicy missingCellPolicy;
    private final ArrayList<HSSFName> names;
    private boolean preserveNodes;
    private InternalWorkbook workbook;

    private final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<T> it;
        final /* synthetic */ HSSFWorkbook this$0;

        public SheetIterator(HSSFWorkbook r1) {
            this.this$0 = r1;
            this.it = r1._sheets.iterator();
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
            throw new UnsupportedOperationException("remove method not supported on HSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }
    }

    static {
        COMMA_PATTERN = Pattern.compile(",");
        INITIAL_CAPACITY = Configurator.getIntValue("HSSFWorkbook.SheetInitialCapacity", 3);
        LOGGER = b.a(HSSFWorkbook.class);
    }

    public HSSFWorkbook() {
        this(InternalWorkbook.createWorkbook());
    }

    public HSSFWorkbook(InputStream r2) {
        this(r2, true);
    }

    public HSSFWorkbook(InputStream r2, boolean r3) {
        this(new POIFSFileSystem(r2).getRoot(), r3);
    }

    private HSSFWorkbook(InternalWorkbook r5) {
        super((DirectoryNode) ZeusTransformUtils.preCheckCast(null, DirectoryNode.class, "com.obric.memorydata.plugin"));
        this.missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        this._udfFinder = new IndexedUDFFinder(new UDFFinder[]{AggregatingUDFFinder.DEFAULT});
        this.workbook = r5;
        int r0 = INITIAL_CAPACITY;
        this._sheets = new ArrayList(r0);
        this.names = new ArrayList(r0);
    }

    public HSSFWorkbook(DirectoryNode r5, boolean r6) {
        super(r5);
        this.missingCellPolicy = Row.MissingCellPolicy.RETURN_NULL_AND_BLANK;
        int r3 = 0;
        this._udfFinder = new IndexedUDFFinder(new UDFFinder[]{AggregatingUDFFinder.DEFAULT});
        String r0 = getWorkbookDirEntryName(r5);
        this.preserveNodes = r6;
        if (r6 == true) goto L5;
        clearDirectory();
    L5:
        int r1 = INITIAL_CAPACITY;
        this._sheets = new ArrayList(r1);
        this.names = new ArrayList(r1);
        List<Record> r7 = RecordFactory.createRecords(r5.createDocumentInputStream(r0));
        InternalWorkbook r8 = InternalWorkbook.createWorkbook(r7);
        this.workbook = r8;
        setPropertiesFromWorkbook(r8);
        int r9 = this.workbook.getNumRecords();
        convertLabelRecords(r7, r9);
        RecordStream r2 = new RecordStream(r7, r9);
    L7:
        if (r2.hasNext() == false) goto L13;
        this._sheets.add(new HSSFSheet(this, InternalSheet.createSheet(r2)));     // Catch: InternalSheet.UnsupportedBOFType -> L10
    L10:
        e = move-exception;
        LOGGER.atWarn().a("Unsupported BOF found of type {}", v.a(e.getType()));
    L13:
        if (r3 >= this.workbook.getNumNames()) goto L15;
        NameRecord r10 = this.workbook.getNameRecord(r3);
        this.names.add(new HSSFName(this, r10, this.workbook.getNameCommentRecord(r10)));
        r3 = r3 + 1;
        goto L13
    }

    private void convertLabelRecords(List<Record> r7, int r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        LOGGER.atDebug().a("convertLabelRecords called");
    L4:
        if (r8 >= r9.size()) goto L9;
        Record r0 = (Record) ZeusTransformUtils.preCheckCast(r9.get(r8), Record.class, "com.obric.memorydata.plugin");
        if (r0.getSid() != 516) goto L8;
        LabelRecord r1 = (LabelRecord) ZeusTransformUtils.preCheckCast(r0, LabelRecord.class, "com.obric.memorydata.plugin");
        r9.remove(r8);
        LabelSSTRecord r2 = new LabelSSTRecord();
        int r3 = this.workbook.addSSTString(new UnicodeString(r1.getValue()));
        r2.setRow(r1.getRow());
        r2.setColumn(r1.getColumn());
        r2.setXFIndex(r1.getXFIndex());
        r2.setSSTIndex(r3);
        r9.add(r8, r2);
    L8:
        r8 = r8 + 1;
        goto L4
    L9:
        LOGGER.atDebug().a("convertLabelRecords exit");
    }

    public static HSSFWorkbook create(InternalWorkbook r1) {
        return new HSSFWorkbook(r1);
    }

    public static int getMaxRecordLength() {
        return MAX_RECORD_LENGTH;
    }

    public static String getWorkbookDirEntryName(DirectoryNode r4) {
        Iterator<String> r0 = InternalWorkbook.WORKBOOK_DIR_ENTRY_NAMES.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        if (r4.hasEntry(r1) == false) goto L4;
        return r1;
    L9:
        if (r4.hasEntry("EncryptedPackage") == true) goto L21;
        if (r4.hasEntry("Book") == true) goto L19;
        if (r4.hasEntry("WordDocument") == false) goto L17;
        throw new IllegalArgumentException("The document is really a DOC file");
    L17:
        throw new IllegalArgumentException("The supplied POIFSFileSystem does not contain a BIFF8 'Workbook' entry. Is it really an excel file? Had: " + r4.getEntryNames());
    L19:
        throw new OldExcelFormatException("The supplied spreadsheet seems to be Excel 5.0/7.0 (BIFF5) format. POI only supports BIFF8 format (from Excel versions 97/2000/XP/2003)");
    L21:
        throw new EncryptedDocumentException("The supplied spreadsheet seems to be an Encrypted .xlsx file. It must be decrypted before use by XSSF, it cannot be used by HSSF");
    }

    private void searchForPictures(List<EscherRecord> r5, List<HSSFPictureData> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        List<HSSFPictureData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        Iterator r9 = r7.iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        EscherRecord r0 = (EscherRecord) ZeusTransformUtils.preCheckCast(r9.next(), EscherRecord.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, EscherBSERecord.class) == false) goto L10;
        EscherBlipRecord r2 = ((EscherBSERecord) ZeusTransformUtils.preCheckCast(r0, EscherBSERecord.class, "com.obric.memorydata.plugin")).getBlipRecord();
        if (r2 == null) goto L10;
        r8.add(new HSSFPictureData(r2));
    L10:
        searchForPictures(r0.getChildRecords(), r8);
        goto L4
    }

    private void setPropertiesFromWorkbook(InternalWorkbook r1) {
        this.workbook = r1;
    }

    private void validateSheetIndex(int r4) {
        int r3 = this._sheets.size() - 1;
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

    @Override // org.apache.poi.POIDocument, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
    }

    public HSSFName createName() {
        HSSFName r1 = new HSSFName(this, this.workbook.createName());
        this.names.add(r1);
        return r1;
    }

    public HSSFSheet createSheet(String r5) {
        if (r5 == null) goto L16;
        if (this.workbook.doesContainsSheetName(r5, this._sheets.size()) == true) goto L14;
        boolean r1 = false;
        if (r5.length() <= 31) goto L8;
        String r0 = r5.substring(0, 31);
        LOGGER.atWarn().a("Sheet '{}' will be added with a trimmed name '{}' for MS Excel compliance.", r5, r0);
        r5 = r0;
    L8:
        HSSFSheet r2 = new HSSFSheet(this);
        this.workbook.setSheetName(this._sheets.size(), r5);
        this._sheets.add(r2);
        if (this._sheets.size() != 1) goto L11;
        r1 = true;
    L11:
        r2.setSelected(r1);
        r2.setActive(r1);
        return r2;
    L14:
        throw new IllegalArgumentException("The workbook already contains a sheet named '" + r5 + "'");
    L16:
        throw new IllegalArgumentException("sheetName must not be null");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this.workbook.getWindowOne().getActiveSheetIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<HSSFPictureData> getAllPictures() {
        ArrayList r0 = new ArrayList();
        Iterator<Record> r1 = this.workbook.getRecords().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        Record r2 = (Record) ZeusTransformUtils.preCheckCast(r1.next(), Record.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, AbstractEscherHolderRecord.class) == false) goto L4;
        ((AbstractEscherHolderRecord) ZeusTransformUtils.preCheckCast(r2, AbstractEscherHolderRecord.class, "com.obric.memorydata.plugin")).decode();
        searchForPictures(((AbstractEscherHolderRecord) ZeusTransformUtils.preCheckCast(r2, AbstractEscherHolderRecord.class, "com.obric.memorydata.plugin")).getEscherRecords(), r0);
        goto L4
    L9:
        return Collections.unmodifiableList(r0);
    }

    @Override // org.apache.poi.POIDocument
    public EncryptionInfo getEncryptionInfo() {
        FilePassRecord r2 = (FilePassRecord) ZeusTransformUtils.preCheckCast(this.workbook.findFirstRecordBySid(47), FilePassRecord.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.getEncryptionInfo();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFFont getFontAt(int r4) {
        if (this.fonts != null) goto L5;
        this.fonts = new HashMap();
    L5:
        Integer r0 = Integer.valueOf(r4);
        if (this.fonts.containsKey(r0) == true) goto L8;
        HSSFFont r2 = new HSSFFont(r4, this.workbook.getFontRecordAt(r4));
        this.fonts.put(r0, r2);
        return r2;
    L8:
        return (HSSFFont) ZeusTransformUtils.preCheckCast(this.fonts.get(r0), HSSFFont.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Font getFontAt(int r1) {
        return getFontAt(r1);
    }

    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this.missingCellPolicy;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._sheets.size();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheet(String r5) {
        HSSFSheet r0 = null;
        int r1 = 0;
    L4:
        if (r1 >= this._sheets.size()) goto L9;
        if (this.workbook.getSheetName(r1).equalsIgnoreCase(r5) == false) goto L8;
        r0 = (HSSFSheet) ZeusTransformUtils.preCheckCast(this._sheets.get(r1), HSSFSheet.class, "com.obric.memorydata.plugin");
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Sheet getSheet(String r1) {
        return getSheet(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public HSSFSheet getSheetAt(int r2) {
        validateSheetIndex(r2);
        return (HSSFSheet) ZeusTransformUtils.preCheckCast(this._sheets.get(r2), HSSFSheet.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Sheet getSheetAt(int r1) {
        return getSheetAt(r1);
    }

    public int getSheetIndex(String r1) {
        return this.workbook.getSheetIndex(r1);
    }

    public int getSheetIndex(Sheet r3) {
        Sheet r4 = (Sheet) ZeusTransformUtils.wrapperContextForParams(r3, Sheet.class, "com.obric.memorydata.plugin");
        return this._sheets.indexOf(r4);
    }

    public String getSheetName(int r1) {
        validateSheetIndex(r1);
        return this.workbook.getSheetName(r1);
    }

    UDFFinder getUDFFinder() {
        return this._udfFinder;
    }

    public InternalWorkbook getWorkbook() {
        return this.workbook;
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Spliterator<Sheet> spliterator() {
        return this._sheets.spliterator();
    }
}
