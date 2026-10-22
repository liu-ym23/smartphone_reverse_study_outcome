package org.apache.poi.xssf.streaming;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import org.apache.commons.compress.archivers.zip.Zip64Mode;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/* JADX INFO: loaded from: classes7.dex */
public class SXSSFWorkbook implements Workbook {
    private static final c LOG = null;
    private boolean _compressTmpFiles;
    private int _randomAccessWindowSize;
    protected final SharedStringsTable _sharedStringSource;
    private final Map<SXSSFSheet, XSSFSheet> _sxFromXHash;
    protected final XSSFWorkbook _wb;
    private final Map<XSSFSheet, SXSSFSheet> _xFromSxHash;
    private boolean shouldCalculateSheetDimensions;
    protected Zip64Mode zip64Mode;

    protected final class SheetIterator<T extends Sheet> implements Iterator<T> {
        private final Iterator<XSSFSheet> it;
        final /* synthetic */ SXSSFWorkbook this$0;

        public SheetIterator(SXSSFWorkbook r1) {
            this.this$0 = r1;
            this.it = r1._wb.iterator();
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
            XSSFSheet r0 = (XSSFSheet) ZeusTransformUtils.preCheckCast(this.it.next(), XSSFSheet.class, "com.obric.memorydata.plugin");
            return this.this$0.getSXSSFSheet(r0);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove method not supported on XSSFWorkbook.iterator(). Use Sheet.removeSheetAt(int) instead.");
        }
    }

    static {
        LOG = b.a(SXSSFWorkbook.class);
    }

    public SXSSFWorkbook() {
        this(null);
    }

    public SXSSFWorkbook(XSSFWorkbook r2) {
        this(r2, 100);
    }

    public SXSSFWorkbook(XSSFWorkbook r2, int r3) {
        this(r2, r3, false);
    }

    public SXSSFWorkbook(XSSFWorkbook r2, int r3, boolean r4) {
        this(r2, r3, r4, false);
    }

    public SXSSFWorkbook(XSSFWorkbook r2, int r3, boolean r4, boolean r5) {
        this._sxFromXHash = new HashMap();
        this._xFromSxHash = new HashMap();
        this._randomAccessWindowSize = 100;
        this.zip64Mode = Zip64Mode.Always;
        this.shouldCalculateSheetDimensions = true;
        setRandomAccessWindowSize(r3);
        setCompressTempFiles(r4);
        SharedStringsTable r6 = null;
        if (r2 != null) goto L8;
        XSSFWorkbook r7 = new XSSFWorkbook();
        this._wb = r7;
        if (r5 == false) goto L7;
        r6 = r7.getSharedStringSource();
    L7:
        this._sharedStringSource = r6;
        return;
    L8:
        this._wb = r2;
        if (r5 == false) goto L11;
        r6 = r2.getSharedStringSource();
    L11:
        this._sharedStringSource = r6;
        Iterator<Sheet> r8 = r2.iterator();
    L13:
        if (r8.hasNext() == false) goto L17;
        createAndRegisterSXSSFSheet((XSSFSheet) ZeusTransformUtils.preCheckCast((Sheet) ZeusTransformUtils.preCheckCast(r8.next(), Sheet.class, "com.obric.memorydata.plugin"), XSSFSheet.class, "com.obric.memorydata.plugin"));
        goto L13
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Iterator<SXSSFSheet> r0 = this._xFromSxHash.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        SXSSFSheet r1 = (SXSSFSheet) ZeusTransformUtils.preCheckCast(r0.next(), SXSSFSheet.class, "com.obric.memorydata.plugin");
        SheetDataWriter r2 = r1.getSheetDataWriter();     // Catch: IOException -> L10
        if (r2 == null) goto L4;
        r2.close();     // Catch: IOException -> L10
    L10:
        e = move-exception;
        LOG.atWarn().a(e).a("An exception occurred while closing sheet data writer for sheet {}.", r1.getSheetName());
        goto L4
    L12:
        this._wb.close();
    }

    SXSSFSheet createAndRegisterSXSSFSheet(XSSFSheet r2) {
        SXSSFSheet r0 = new SXSSFSheet(this, r2);     // Catch: IOException -> L5
        registerSheetMapping(r0, r2);
        return r0;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public SheetDataWriter createSheetDataWriter() {
        if (this._compressTmpFiles == false) goto L7;
        return new GZIPSheetDataWriter(this._sharedStringSource);
    L7:
        return new SheetDataWriter(this._sharedStringSource);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getActiveSheetIndex() {
        return this._wb.getActiveSheetIndex();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public List<? extends PictureData> getAllPictures() {
        return this._wb.getAllPictures();
    }

    public CellStyle getCellStyleAt(int r1) {
        return this._wb.getCellStyleAt(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Font getFontAt(int r1) {
        return this._wb.getFontAt(r1);
    }

    public Row.MissingCellPolicy getMissingCellPolicy() {
        return this._wb.getMissingCellPolicy();
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public int getNumberOfSheets() {
        return this._wb.getNumberOfSheets();
    }

    public int getRandomAccessWindowSize() {
        return this._randomAccessWindowSize;
    }

    SXSSFSheet getSXSSFSheet(XSSFSheet r2) {
        return (SXSSFSheet) ZeusTransformUtils.preCheckCast(this._xFromSxHash.get(r2), SXSSFSheet.class, "com.obric.memorydata.plugin");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Sheet getSheet(String r1) {
        return getSheet(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet getSheet(String r2) {
        return getSXSSFSheet(this._wb.getSheet(r2));
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public /* bridge */ /* synthetic */ Sheet getSheetAt(int r1) {
        return getSheetAt(r1);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public SXSSFSheet getSheetAt(int r2) {
        return getSXSSFSheet(this._wb.getSheetAt(r2));
    }

    XSSFSheet getXSSFSheet(SXSSFSheet r2) {
        return (XSSFSheet) ZeusTransformUtils.preCheckCast(this._sxFromXHash.get(r2), XSSFSheet.class, "com.obric.memorydata.plugin");
    }

    public boolean isDate1904() {
        return this._wb.isDate1904();
    }

    void registerSheetMapping(SXSSFSheet r2, XSSFSheet r3) {
        this._sxFromXHash.put(r2, r3);
        this._xFromSxHash.put(r3, r2);
    }

    public void setCompressTempFiles(boolean r1) {
        this._compressTmpFiles = r1;
    }

    public void setRandomAccessWindowSize(int r2) {
        if (r2 == 0) goto L8;
        if (r2 < (-1)) goto L8;
        this._randomAccessWindowSize = r2;
        return;
    L8:
        throw new IllegalArgumentException("rowAccessWindowSize must be greater than 0 or -1");
    }

    @Override // org.apache.poi.ss.usermodel.Workbook
    public Iterator<Sheet> sheetIterator() {
        return new SheetIterator(this);
    }

    @Override // org.apache.poi.ss.usermodel.Workbook, java.lang.Iterable
    public Spliterator<Sheet> spliterator() {
        return this._wb.spliterator();
    }
}
