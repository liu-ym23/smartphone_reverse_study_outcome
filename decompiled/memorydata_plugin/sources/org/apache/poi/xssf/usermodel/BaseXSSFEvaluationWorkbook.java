package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationName;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.FormulaParser;
import org.apache.poi.ss.formula.FormulaParsingWorkbook;
import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
import org.apache.poi.ss.formula.FormulaType;
import org.apache.poi.ss.formula.SheetIdentifier;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.NamePtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.NameXPxg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Table;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.model.ExternalLinksTable;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.ay;

/* JADX INFO: loaded from: classes7.dex */
public abstract class BaseXSSFEvaluationWorkbook implements EvaluationWorkbook, FormulaParsingWorkbook, FormulaRenderingWorkbook {
    private Map<String, XSSFTable> _tableCache;
    protected final XSSFWorkbook _uBook;

    /* JADX INFO: renamed from: org.apache.poi.xssf.usermodel.BaseXSSFEvaluationWorkbook$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class FakeExternalLinksTable extends ExternalLinksTable {
        private final String fileName;

        private FakeExternalLinksTable(String r1) {
            this.fileName = r1;
        }

        /* synthetic */ FakeExternalLinksTable(String r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // org.apache.poi.xssf.model.ExternalLinksTable
        public String getLinkedFileName() {
            return this.fileName;
        }
    }

    private static final class Name implements EvaluationName {
        private final FormulaParsingWorkbook _fpBook;
        private final int _index;
        private final XSSFName _nameRecord;

        public Name(XSSFName r3, int r4, FormulaParsingWorkbook r5) {
            FormulaParsingWorkbook r6 = (FormulaParsingWorkbook) ZeusTransformUtils.wrapperContextForParams(r5, FormulaParsingWorkbook.class, "com.obric.memorydata.plugin");
            this._nameRecord = r3;
            this._index = r4;
            this._fpBook = r6;
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public NamePtg createPtg() {
            return new NamePtg(this._index);
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public Ptg[] getNameDefinition() {
            return FormulaParser.parse(this._nameRecord.getRefersToFormula(), this._fpBook, FormulaType.NAMEDRANGE, this._nameRecord.getSheetIndex());
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public String getNameText() {
            return this._nameRecord.getNameName();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean hasFormula() {
            ay r1 = this._nameRecord.getCTName();
            String r0 = r1.getStringValue();
            if (r1.getFunction() == true) goto L8;
            if (r0 == null) goto L8;
            if (r0.length() <= 0) goto L8;
            return true;
        L8:
            return false;
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isFunctionName() {
            return this._nameRecord.isFunctionName();
        }

        @Override // org.apache.poi.ss.formula.EvaluationName
        public boolean isRange() {
            return hasFormula();
        }
    }

    public BaseXSSFEvaluationWorkbook(XSSFWorkbook r1) {
        this._uBook = r1;
    }

    private int convertFromExternalSheetIndex(int r1) {
        return r1;
    }

    private int findExternalLinkIndex(String r4, List<ExternalLinksTable> r5) {
        Iterator r3 = ((List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin")).iterator();
        int r6 = 0;
    L4:
        if (r3.hasNext() == false) goto L8;
        r6 = r6 + 1;
        if (((ExternalLinksTable) ZeusTransformUtils.preCheckCast(r3.next(), ExternalLinksTable.class, "com.obric.memorydata.plugin")).getLinkedFileName().equals(r4) == false) goto L4;
        return r6;
    L8:
        return -1;
    }

    private Map<String, XSSFTable> getTableCache() {
        Map<String, XSSFTable> r0 = this._tableCache;
        if (r0 == null) goto L5;
        return r0;
    L5:
        this._tableCache = new ConcurrentSkipListMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Sheet> r1 = this._uBook.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        Iterator<XSSFTable> r2 = ((XSSFSheet) ZeusTransformUtils.preCheckCast((Sheet) ZeusTransformUtils.preCheckCast(r1.next(), Sheet.class, "com.obric.memorydata.plugin"), XSSFSheet.class, "com.obric.memorydata.plugin")).getTables().iterator();
    L10:
        if (r2.hasNext() == false) goto L7;
        XSSFTable r3 = (XSSFTable) ZeusTransformUtils.preCheckCast(r2.next(), XSSFTable.class, "com.obric.memorydata.plugin");
        this._tableCache.put(r3.getName(), r3);
        goto L10
    L13:
        return this._tableCache;
    }

    private int resolveBookIndex(String r6) {
        if (r6.startsWith("[") == true) goto L5;
    L23:
        return Integer.parseInt(r6);
    L9:
        List<ExternalLinksTable> r0 = this._uBook.getExternalLinksTable();
        int r2 = findExternalLinkIndex(r6, r0);
        if (r2 == (-1)) goto L13;
        return r2;
    L13:
        if (r6.startsWith("'file:///") == false) goto L22;
        if (r6.endsWith("'") == false) goto L22;
        String r7 = r6.substring(r6.lastIndexOf(47) + 1);
        String r8 = r7.substring(0, r7.length() - 1);
        int r5 = findExternalLinkIndex(r8, r0);
        if (r5 == (-1)) goto L19;
        return r5;
    L19:
        r0.add(new FakeExternalLinksTable(r8, null));
        return r0.size();
    L22:
        throw new RuntimeException("Book not linked for filename " + r6);
    L5:
        if (r6.endsWith("]") == false) goto L23;
        r6 = r6.substring(1, r6.length() - 2);
        goto L23
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public /* bridge */ /* synthetic */ org.apache.poi.ss.usermodel.Name createName() {
        return createName();
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public XSSFName createName() {
        return this._uBook.createName();
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(AreaReference r2, SheetIdentifier r3) {
        if (r3.getBookName() == null) goto L7;
        return new Area3DPxg(resolveBookIndex(r3.getBookName()), r3, r2);
    L7:
        return new Area3DPxg(r3, r2);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public Ptg get3DReferencePtg(CellReference r2, SheetIdentifier r3) {
        if (r3.getBookName() == null) goto L7;
        return new Ref3DPxg(resolveBookIndex(r3.getBookName()), r3, r2);
    L7:
        return new Ref3DPxg(r3, r2);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(int r1, int r2) {
        throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalName getExternalName(String r3, String r4, int r5) {
        if (r5 <= 0) goto L13;
        ExternalLinksTable r2 = (ExternalLinksTable) ZeusTransformUtils.preCheckCast(this._uBook.getExternalLinksTable().get(r5 - 1), ExternalLinksTable.class, "com.obric.memorydata.plugin");
        Iterator<org.apache.poi.ss.usermodel.Name> r6 = r2.getDefinedNames().iterator();
    L5:
        if (r6.hasNext() == false) goto L11;
        org.apache.poi.ss.usermodel.Name r0 = (org.apache.poi.ss.usermodel.Name) ZeusTransformUtils.preCheckCast(r6.next(), org.apache.poi.ss.usermodel.Name.class, "com.obric.memorydata.plugin");
        if (r0.getNameName().equals(r3) == false) goto L5;
        return new EvaluationWorkbook.ExternalName(r3, -1, r0.getSheetIndex() + 1);
    L11:
        throw new IllegalArgumentException("Name '" + r3 + "' not found in reference to " + r2.getLinkedFileName());
    L13:
        return new EvaluationWorkbook.ExternalName(r3, this._uBook.getNameIndex(r3), 0);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(int r1) {
        throw new IllegalStateException("HSSF-style external references are not supported for XSSF");
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationWorkbook.ExternalSheet getExternalSheet(String r2, String r3, int r4) {
        if (r4 <= 0) goto L4;
        String r1 = ((ExternalLinksTable) ZeusTransformUtils.preCheckCast(this._uBook.getExternalLinksTable().get(r4 - 1), ExternalLinksTable.class, "com.obric.memorydata.plugin")).getLinkedFileName();
    L5:
        if (r3 == null) goto L12;
        if (r2.equals(r3) == true) goto L12;
        return new EvaluationWorkbook.ExternalSheetRange(r1, r2, r3);
    L12:
        return new EvaluationWorkbook.ExternalSheet(r1, r2);
    L4:
        r1 = null;
        goto L5
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public EvaluationName getName(String r6, int r7) {
        int r0 = 0;
    L4:
        if (r0 >= this._uBook.getNumberOfNames()) goto L12;
        XSSFName r1 = this._uBook.getNameAt(r0);
        String r3 = r1.getNameName();
        int r4 = r1.getSheetIndex();
        if (r6.equalsIgnoreCase(r3) == false) goto L11;
        if (r4 == (-1)) goto L10;
        if (r4 != r7) goto L11;
    L10:
        return new Name(r1, r0, this);
    L11:
        r0 = r0 + 1;
        goto L4
    L12:
        if (r7 != (-1)) goto L15;
        return null;
    L15:
        return getName(r6, -1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public EvaluationName getName(NamePtg r3) {
        int r4 = r3.getIndex();
        return new Name(this._uBook.getNameAt(r4), r4, this);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getNameText(NamePtg r1) {
        return this._uBook.getNameAt(r1.getIndex()).getNameName();
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public NameXPxg getNameXPtg(String r4, SheetIdentifier r5) {
        if (((IndexedUDFFinder) ZeusTransformUtils.preCheckCast(getUDFFinder(), IndexedUDFFinder.class, "com.obric.memorydata.plugin")).findFunction(r4) != null) goto L5;
        if (r5 != null) goto L13;
        if (this._uBook.getNames(r4).isEmpty() == false) goto L10;
        return null;
    L10:
        return new NameXPxg(null, r4);
    L13:
        if (r5.getSheetIdentifier() == null) goto L15;
        String r0 = r5.getSheetIdentifier().getName();
        if (r5.getBookName() == null) goto L21;
        return new NameXPxg(resolveBookIndex(r5.getBookName()), r0, r4);
    L21:
        return new NameXPxg(r0, r4);
    L15:
        return new NameXPxg(resolveBookIndex(r5.getBookName()), null, r4);
    L5:
        return new NameXPxg(null, r4);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public /* bridge */ /* synthetic */ Ptg getNameXPtg(String r1, SheetIdentifier r2) {
        return getNameXPtg(r1, r2);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetFirstNameByExternSheet(int r1) {
        int r2 = convertFromExternalSheetIndex(r1);
        return this._uBook.getSheetName(r2);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public int getSheetIndex(String r1) {
        return this._uBook.getSheetIndex(r1);
    }

    @Override // org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String getSheetLastNameByExternSheet(int r1) {
        return getSheetFirstNameByExternSheet(r1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook
    public String getSheetName(int r1) {
        return this._uBook.getSheetName(r1);
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaParsingWorkbook
    public SpreadsheetVersion getSpreadsheetVersion() {
        return SpreadsheetVersion.EXCEL2007;
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public /* bridge */ /* synthetic */ Table getTable(String r1) {
        return getTable(r1);
    }

    @Override // org.apache.poi.ss.formula.FormulaParsingWorkbook
    public XSSFTable getTable(String r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return (XSSFTable) ZeusTransformUtils.preCheckCast(getTableCache().get(r2), XSSFTable.class, "com.obric.memorydata.plugin");
    }

    public UDFFinder getUDFFinder() {
        return this._uBook.getUDFFinder();
    }

    @Override // org.apache.poi.ss.formula.EvaluationWorkbook, org.apache.poi.ss.formula.FormulaRenderingWorkbook
    public String resolveNameXText(NameXPtg r4) {
        int r5 = r4.getNameIndex();
        String r0 = ((IndexedUDFFinder) ZeusTransformUtils.preCheckCast(getUDFFinder(), IndexedUDFFinder.class, "com.obric.memorydata.plugin")).getFunctionName(r5);
        if (r0 == null) goto L5;
        return r0;
    L5:
        XSSFName r3 = this._uBook.getNameAt(r5);
        if (r3 != null) goto L8;
        return r0;
    L8:
        return r3.getNameName();
    }
}
