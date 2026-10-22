package org.apache.poi.hssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.CRNCountRecord;
import org.apache.poi.hssf.record.CRNRecord;
import org.apache.poi.hssf.record.ExternSheetRecord;
import org.apache.poi.hssf.record.ExternalNameRecord;
import org.apache.poi.hssf.record.NameCommentRecord;
import org.apache.poi.hssf.record.NameRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.SupBookRecord;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.formula.ptg.ErrPtg;
import org.apache.poi.ss.formula.ptg.NameXPtg;
import org.apache.poi.ss.formula.ptg.Ptg;

/* JADX INFO: loaded from: classes7.dex */
final class LinkTable {
    private final List<NameRecord> _definedNames;
    private final ExternSheetRecord _externSheetRecord;
    private ExternalBookBlock[] _externalBookBlocks;
    private final int _recordCount;
    private final WorkbookRecordList _workbookRecordList;

    private static final class CRNBlock {
        private final CRNCountRecord _countRecord;
        private final CRNRecord[] _crns;

        public CRNBlock(RecordStream r7) {
            CRNCountRecord r0 = (CRNCountRecord) ZeusTransformUtils.preCheckCast(r7.getNext(), CRNCountRecord.class, "com.obric.memorydata.plugin");
            this._countRecord = r0;
            int r1 = r0.getNumberOfCRNs();
            CRNRecord[] r2 = new CRNRecord[r1];
            int r3 = 0;
        L3:
            if (r3 >= r1) goto L5;
            r2[r3] = (CRNRecord) ZeusTransformUtils.preCheckCast(r7.getNext(), CRNRecord.class, "com.obric.memorydata.plugin");
            r3 = r3 + 1;
            goto L3
        L5:
            this._crns = r2;
        }
    }

    private static final class ExternalBookBlock {
        private final CRNBlock[] _crnBlocks;
        private final SupBookRecord _externalBookRecord;
        private ExternalNameRecord[] _externalNameRecords;

        public ExternalBookBlock() {
            this._externalBookRecord = SupBookRecord.createAddInFunctions();
            this._externalNameRecords = new ExternalNameRecord[0];
            this._crnBlocks = new CRNBlock[0];
        }

        public ExternalBookBlock(int r2) {
            this._externalBookRecord = SupBookRecord.createInternalReferences((short) r2);
            this._externalNameRecords = new ExternalNameRecord[0];
            this._crnBlocks = new CRNBlock[0];
        }

        public ExternalBookBlock(RecordStream r4) {
            this._externalBookRecord = (SupBookRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), SupBookRecord.class, "com.obric.memorydata.plugin");
            ArrayList r0 = new ArrayList();
        L4:
            if (r4.peekNextClass() != ExternalNameRecord.class) goto L6;
            r0.add(r4.getNext());
            goto L4
        L6:
            ExternalNameRecord[] r1 = new ExternalNameRecord[r0.size()];
            this._externalNameRecords = r1;
            r0.toArray(r1);
            r0.clear();
        L8:
            if (r4.peekNextClass() != CRNCountRecord.class) goto L10;
            r0.add(new CRNBlock(r4));
            goto L8
        L10:
            CRNBlock[] r5 = new CRNBlock[r0.size()];
            this._crnBlocks = r5;
            r0.toArray(r5);
        }

        static /* synthetic */ ExternalNameRecord[] access$000(ExternalBookBlock r0) {
            return r0._externalNameRecords;
        }

        public int addExternalName(ExternalNameRecord r6) {
            ExternalNameRecord[] r0 = this._externalNameRecords;
            int r1 = r0.length + 1;
            ExternalNameRecord[] r2 = new ExternalNameRecord[r1];
            System.arraycopy(r0, 0, r2, 0, r0.length);
            r2[r1 - 1] = r6;
            this._externalNameRecords = r2;
            return r2.length - 1;
        }

        public SupBookRecord getExternalBookRecord() {
            return this._externalBookRecord;
        }

        public int getIndexOfName(String r4) {
            int r0 = 0;
        L3:
            ExternalNameRecord[] r1 = this._externalNameRecords;
            if (r0 >= r1.length) goto L9;
            if (r1[r0].getText().equalsIgnoreCase(r4) == true) goto L7;
            r0 = r0 + 1;
            goto L3
        L7:
            return r0;
        L9:
            return -1;
        }

        public int getNameIx(int r1) {
            return this._externalNameRecords[r1].getIx();
        }

        public String getNameText(int r1) {
            return this._externalNameRecords[r1].getText();
        }

        public int getNumberOfNames() {
            return this._externalNameRecords.length;
        }
    }

    public LinkTable(int r4, WorkbookRecordList r5) {
        this._workbookRecordList = r5;
        this._definedNames = new ArrayList();
        this._externalBookBlocks = new ExternalBookBlock[]{new ExternalBookBlock(r4)};
        ExternSheetRecord r1 = new ExternSheetRecord();
        this._externSheetRecord = r1;
        this._recordCount = 2;
        Record r6 = this._externalBookBlocks[0].getExternalBookRecord();
        int r2 = findFirstRecordLocBySid(140);
        if (r2 >= 0) goto L9;
        r2 = findFirstRecordLocBySid(252) - 1;
        if (r2 >= 0) goto L9;
        throw new RuntimeException("CountryRecord or SSTRecord not found");
    L9:
        int r3 = r2 + 1;
        r5.add(r3, r1);
        r5.add(r3, r6);
    }

    public LinkTable(List<Record> r5, int r6, WorkbookRecordList r7, Map<String, NameCommentRecord> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        this._workbookRecordList = r7;
        RecordStream r11 = new RecordStream(r9, r6);
        ArrayList r0 = new ArrayList();
    L4:
        if (r11.peekNextClass() != SupBookRecord.class) goto L6;
        r0.add(new ExternalBookBlock(r11));
        goto L4
    L6:
        ExternalBookBlock[] r2 = new ExternalBookBlock[r0.size()];
        this._externalBookBlocks = r2;
        r0.toArray(r2);
        r0.clear();
        if (this._externalBookBlocks.length > 0) goto L9;
    L12:
        this._externSheetRecord = null;
    L13:
        this._definedNames = new ArrayList();
    L14:
        Class<? extends Record> r1 = r11.peekNextClass();
        if (r1 == NameRecord.class) goto L16;
        if (r1 != NameCommentRecord.class) goto L20;
        NameCommentRecord r3 = (NameCommentRecord) ZeusTransformUtils.preCheckCast(r11.getNext(), NameCommentRecord.class, "com.obric.memorydata.plugin");
        r10.put(r3.getNameText(), r3);
        goto L14
    L20:
        int r12 = r11.getCountRead();
        this._recordCount = r12;
        this._workbookRecordList.getRecords().addAll(r9.subList(r6, r12 + r6));
        return;
    L16:
        NameRecord r4 = (NameRecord) ZeusTransformUtils.preCheckCast(r11.getNext(), NameRecord.class, "com.obric.memorydata.plugin");
        this._definedNames.add(r4);
        goto L14
    L9:
        if (r11.peekNextClass() != ExternSheetRecord.class) goto L12;
        this._externSheetRecord = readExtSheetRecord(r11);
        goto L13
    }

    private int extendExternalBookBlocks(ExternalBookBlock r6) {
        ExternalBookBlock[] r0 = this._externalBookBlocks;
        int r1 = r0.length + 1;
        ExternalBookBlock[] r2 = new ExternalBookBlock[r1];
        System.arraycopy(r0, 0, r2, 0, r0.length);
        r2[r1 - 1] = r6;
        this._externalBookBlocks = r2;
        return r2.length - 1;
    }

    private int findFirstRecordLocBySid(short r5) {
        Iterator<Record> r4 = this._workbookRecordList.getRecords().iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L9;
        if (((Record) ZeusTransformUtils.preCheckCast(r4.next(), Record.class, "com.obric.memorydata.plugin")).getSid() == r5) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L9:
        return -1;
    }

    private int findRefIndexFromExtBookIndex(int r1) {
        return this._externSheetRecord.findRefIndexFromExtBookIndex(r1);
    }

    private int getExternalWorkbookIndex(String r4) {
        int r0 = 0;
    L3:
        ExternalBookBlock[] r1 = this._externalBookBlocks;
        if (r0 >= r1.length) goto L12;
        SupBookRecord r2 = r1[r0].getExternalBookRecord();
        if (r2.isExternalReferences() == false) goto L11;
        if (r4.equals(r2.getURL()) == false) goto L11;
        return r0;
    L11:
        r0 = r0 + 1;
        goto L3
    L12:
        return -1;
    }

    private static int getSheetIndex(String[] r2, String r3) {
        int r0 = 0;
    L4:
        if (r0 >= r2.length) goto L10;
        if (r2[r0].equals(r3) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L10:
        throw new RuntimeException("External workbook does not contain sheet '" + r3 + "'");
    }

    private static ExternSheetRecord readExtSheetRecord(RecordStream r4) {
        ArrayList r0 = new ArrayList(2);
    L4:
        if (r4.peekNextClass() != ExternSheetRecord.class) goto L6;
        r0.add((ExternSheetRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), ExternSheetRecord.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        int r1 = r0.size();
        if (r1 < 1) goto L14;
        if (r1 == 1) goto L10;
        ExternSheetRecord[] r5 = new ExternSheetRecord[r1];
        r0.toArray(r5);
        return ExternSheetRecord.combine(r5);
    L10:
        return (ExternSheetRecord) ZeusTransformUtils.preCheckCast(r0.get(0), ExternSheetRecord.class, "com.obric.memorydata.plugin");
    L14:
        throw new RuntimeException("Expected an EXTERNSHEET record but got (" + r4.peekNextClass().getName() + ")");
    }

    public void addName(NameRecord r3) {
        this._definedNames.add(r3);
        int r0 = findFirstRecordLocBySid(23);
        if (r0 != (-1)) goto L5;
        r0 = findFirstRecordLocBySid(430);
    L5:
        if (r0 != (-1)) goto L7;
        r0 = findFirstRecordLocBySid(140);
    L7:
        int r1 = this._definedNames.size();
        this._workbookRecordList.add(r0 + r1, r3);
    }

    public NameXPtg addNameXPtg(String r10) {
        int r0 = 0;
        int r1 = 0;
    L3:
        ExternalBookBlock[] r2 = this._externalBookBlocks;
        if (r1 >= r2.length) goto L9;
        if (r2[r1].getExternalBookRecord().isAddInFunctions() == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        ExternalBookBlock r3 = this._externalBookBlocks[r1];
    L11:
        if (r3 != null) goto L13;
        r3 = new ExternalBookBlock();
        r1 = extendExternalBookBlocks(r3);
        this._workbookRecordList.add(findFirstRecordLocBySid(23), r3.getExternalBookRecord());
        this._externSheetRecord.addRef(this._externalBookBlocks.length - 1, -2, -2);
    L13:
        ExternalNameRecord r5 = new ExternalNameRecord();
        r5.setText(r10);
        r5.setParsedExpression(new Ptg[]{ErrPtg.REF_INVALID});
        int r11 = r3.addExternalName(r5);
        Iterator<Record> r4 = this._workbookRecordList.getRecords().iterator();
    L15:
        if (r4.hasNext() == false) goto L22;
        Record r6 = (Record) ZeusTransformUtils.preCheckCast(r4.next(), Record.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, SupBookRecord.class) == false) goto L21;
        if (((SupBookRecord) ZeusTransformUtils.preCheckCast(r6, SupBookRecord.class, "com.obric.memorydata.plugin")).isAddInFunctions() == true) goto L22;
    L21:
        r0 = r0 + 1;
    L22:
        this._workbookRecordList.add(r0 + r3.getNumberOfNames(), r5);
        return new NameXPtg(this._externSheetRecord.getRefIxForSheet(r1, -2, -2), r11);
    L9:
        r1 = -1;
        r3 = null;
        goto L11
    }

    public int checkExternSheet(int r1) {
        return checkExternSheet(r1, r1);
    }

    public int checkExternSheet(int r4, int r5) {
        int r0 = 0;
    L3:
        ExternalBookBlock[] r1 = this._externalBookBlocks;
        if (r0 >= r1.length) goto L9;
        if (r1[r0].getExternalBookRecord().isInternalReferences() == true) goto L10;
        r0 = r0 + 1;
    L10:
        if (r0 < 0) goto L21;
        ExternSheetRecord r2 = this._externSheetRecord;
        if (r2 == null) goto L19;
        int r3 = r2.getRefIxForSheet(r0, r4, r5);
        if (r3 < 0) goto L17;
        return r3;
    L17:
        return this._externSheetRecord.addRef(r0, r4, r5);
    L19:
        throw new RuntimeException("Did not have an external sheet record, having blocks: " + this._externalBookBlocks.length);
    L21:
        throw new RuntimeException("Could not find 'internal references' EXTERNALBOOK");
    L9:
        r0 = -1;
        goto L10
    }

    public String[] getExternalBookAndSheetName(int r7) {
        SupBookRecord r0 = this._externalBookBlocks[this._externSheetRecord.getExtbookIndexFromRefIndex(r7)].getExternalBookRecord();
        String r2 = null;
        if (r0.isExternalReferences() == true) goto L5;
        return null;
    L5:
        int r1 = this._externSheetRecord.getFirstSheetIndexFromRefIndex(r7);
        int r6 = this._externSheetRecord.getLastSheetIndexFromRefIndex(r7);
        if (r1 < 0) goto L8;
        String r8 = r0.getSheetNames()[r1];
    L9:
        if (r6 < 0) goto L12;
        r2 = r0.getSheetNames()[r6];
    L12:
        if (r1 != r6) goto L16;
        return new String[]{r0.getURL(), r8};
    L16:
        return new String[]{r0.getURL(), r8, r2};
    L8:
        r8 = null;
        goto L9
    }

    public int getExternalSheetIndex(String r3, String r4, String r5) {
        int r0 = getExternalWorkbookIndex(r3);
        if (r0 == (-1)) goto L9;
        SupBookRecord r6 = this._externalBookBlocks[r0].getExternalBookRecord();
        int r7 = getSheetIndex(r6.getSheetNames(), r4);
        int r8 = getSheetIndex(r6.getSheetNames(), r5);
        int r9 = this._externSheetRecord.getRefIxForSheet(r0, r7, r8);
        if (r9 < 0) goto L7;
        return r9;
    L7:
        return this._externSheetRecord.addRef(r0, r7, r8);
    L9:
        throw new RuntimeException("No external workbook with name '" + r3 + "'");
    }

    public int getFirstInternalSheetIndexForExtIndex(int r2) {
        if (r2 >= this._externSheetRecord.getNumOfRefs()) goto L8;
        if (r2 >= 0) goto L7;
        return -1;
    L7:
        return this._externSheetRecord.getFirstSheetIndexFromRefIndex(r2);
    L8:
        return -1;
    }

    public int getLastInternalSheetIndexForExtIndex(int r2) {
        if (r2 >= this._externSheetRecord.getNumOfRefs()) goto L8;
        if (r2 >= 0) goto L7;
        return -1;
    L7:
        return this._externSheetRecord.getLastSheetIndexFromRefIndex(r2);
    L8:
        return -1;
    }

    public NameRecord getNameRecord(int r2) {
        return (NameRecord) ZeusTransformUtils.preCheckCast(this._definedNames.get(r2), NameRecord.class, "com.obric.memorydata.plugin");
    }

    public NameXPtg getNameXPtg(String r5, int r6) {
        int r0 = 0;
    L3:
        ExternalBookBlock[] r1 = this._externalBookBlocks;
        if (r0 >= r1.length) goto L16;
        int r2 = r1[r0].getIndexOfName(r5);
        if (r2 < 0) goto L15;
        int r3 = findRefIndexFromExtBookIndex(r0);
        if (r3 < 0) goto L15;
        if (r6 == (-1)) goto L14;
        if (r3 != r6) goto L15;
    L14:
        return new NameXPtg(r3, r2);
    L15:
        r0 = r0 + 1;
        goto L3
    L16:
        return null;
    }

    public int getNumNames() {
        return this._definedNames.size();
    }

    public int getRecordCount() {
        return this._recordCount;
    }

    public int resolveNameXIx(int r2, int r3) {
        int r4 = this._externSheetRecord.getExtbookIndexFromRefIndex(r2);
        return this._externalBookBlocks[r4].getNameIx(r3);
    }

    public String resolveNameXText(int r3, int r4, InternalWorkbook r5) {
        int r0 = this._externSheetRecord.getExtbookIndexFromRefIndex(r3);
        int r6 = this._externSheetRecord.getFirstSheetIndexFromRefIndex(r3);
        if (r6 == (-1)) goto L18;
        if (ExternalBookBlock.access$000(this._externalBookBlocks[r0]).length <= r4) goto L9;
        return this._externalBookBlocks[r0].getNameText(r4);
    L9:
        if (r6 != (-2)) goto L16;
        NameRecord r2 = getNameRecord(r4);
        int r7 = r2.getSheetNumber();
        StringBuilder r8 = new StringBuilder(64);
        if (r7 <= 0) goto L13;
        SheetNameFormatter.appendFormat(r8, r5.getSheetName(r7 - 1));
        r8.append("!");
    L13:
        r8.append(r2.getNameText());
        return r8.toString();
    L16:
        throw new ArrayIndexOutOfBoundsException("Ext Book Index relative but beyond the supported length, was " + r0 + " but maximum is " + this._externalBookBlocks.length);
    L18:
        throw new RuntimeException("Referenced sheet could not be found");
    }
}
