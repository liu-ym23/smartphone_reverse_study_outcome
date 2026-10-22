package org.apache.poi.hwpf.model;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Locale;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.model.types.FibBaseAbstractType;
import org.apache.poi.hwpf.model.types.FibRgLw97AbstractType;
import org.apache.poi.hwpf.model.types.FibRgW97AbstractType;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class FileInformationBlock {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final c LOG = null;
    private int _cbRgFcLcb;
    private final int _cslw;
    private final int _csw;
    private final int _cswNew;
    private final FibBase _fibBase;
    private final byte[] _fibRgCswNew;
    private final FibRgLw _fibRgLw;
    private final FibRgW97 _fibRgW;
    private FIBFieldHandler _fieldHandler;
    private final int _nFibNew;

    static {
        LOG = b.a(FileInformationBlock.class);
    }

    public FileInformationBlock(byte[] r6) {
        FibBase r0 = new FibBase(r6, 0);
        this._fibBase = r0;
        int r2 = FibBaseAbstractType.getSize();
        this._csw = LittleEndian.getUShort(r6, r2);
        int r3 = r2 + 2;
        this._fibRgW = new FibRgW97(r6, r3);
        int r4 = r3 + FibRgW97AbstractType.getSize();
        this._cslw = LittleEndian.getUShort(r6, r4);
        int r5 = r4 + 2;
        if (r0.getNFib() >= 105) goto L6;
        this._fibRgLw = new FibRgLw95(r6, r5);
        FibRgLw97AbstractType.getSize();
        this._cbRgFcLcb = 74;
        this._cswNew = 0;
        this._nFibNew = -1;
        this._fibRgCswNew = new byte[0];
        return;
    L6:
        this._fibRgLw = new FibRgLw97(r6, r5);
        int r7 = r5 + FibRgLw97AbstractType.getSize();
        int r1 = LittleEndian.getUShort(r6, r7);
        this._cbRgFcLcb = r1;
        int r8 = (r7 + 2) + ((r1 * 4) * 2);
        int r9 = LittleEndian.getUShort(r6, r8);
        this._cswNew = r9;
        int r10 = r8 + 2;
        if (r9 == 0) goto L9;
        this._nFibNew = LittleEndian.getUShort(r6, r10);
        this._fibRgCswNew = IOUtils.safelyClone(r6, r10 + 2, (r9 - 1) * 2, HWPFDocument.getMaxRecordLength());
    L10:
        assertCbRgFcLcb();
        assertCswNew();
        return;
    L9:
        this._nFibNew = -1;
        this._fibRgCswNew = new byte[0];
        goto L10
    }

    private void assertCbRgFcLcb() {
        int r0 = getNFib();
        String r1 = String.format(Locale.ROOT, "%04X", new Object[]{Integer.valueOf(r0)});
        if (r0 != 113) goto L5;
        return;
    L5:
        if (r0 != 257) goto L7;
        int r2 = 136;
        int r5 = this._cbRgFcLcb;
        r1 = "0x0101";
        String r3 = "0x0088";
    L19:
        assertCbRgFcLcb(r1, r2, r3, r5);
        return;
    L7:
        if (r0 != 274) goto L9;
        r2 = 183;
        r5 = this._cbRgFcLcb;
        r1 = "0x0112";
        r3 = "0x00B7";
        goto L19
    L9:
        if (r0 != 216) goto L11;
    L21:
        r2 = 108;
        r5 = this._cbRgFcLcb;
        r3 = "0x006C";
        goto L19
    L11:
        if (r0 == 217) goto L21;
        if (r0 != 267) goto L15;
    L20:
        r2 = 164;
        r5 = this._cbRgFcLcb;
        r3 = "0x00A4";
        goto L19
    L15:
        if (r0 == 268) goto L20;
        switch(r0) {
            case 190: goto L18;
            case 191: goto L18;
            case 192: goto L18;
            case 193: goto L18;
            case 194: goto L18;
            case 195: goto L18;
            default: goto L17;
        };
    L17:
        LOG.atWarn().a("Invalid file format version number: {}({})", v.a(r0), r1);
        return;
    L18:
        r2 = 93;
        r5 = this._cbRgFcLcb;
        r3 = "0x005D";
        goto L19
    }

    private static void assertCbRgFcLcb(String r1, int r2, String r3, int r4) {
        if (r4 != r2) goto L4;
        return;
    L4:
        LOG.atWarn().a("Since FIB.nFib == {} value of FIB.cbRgFcLcb MUST be {}, not 0x{}", r1, r3, Integer.toHexString(r4));
    }

    private void assertCswNew() {
        int r0 = getNFib();
        if (r0 != 193) goto L5;
        int r1 = 0;
        int r4 = this._cswNew;
        String r2 = "0x00C1";
        String r3 = "0x0000";
    L19:
        assertCswNew(r2, r1, r3, r4);
        return;
    L5:
        if (r0 != 217) goto L7;
        int r5 = this._cswNew;
        String r6 = "0x00D9";
    L17:
        assertCswNew(r6, 2, "0x0002", r5);
        return;
    L7:
        if (r0 != 257) goto L9;
        r5 = this._cswNew;
        r6 = "0x0101";
        goto L17
    L9:
        if (r0 != 268) goto L11;
        r5 = this._cswNew;
        r6 = "0x010C";
        goto L17
    L11:
        if (r0 == 274) goto L13;
        LOG.atWarn().a("Invalid file format version number: {}", v.a(getNFib()));
        return;
    L13:
        r1 = 5;
        r4 = this._cswNew;
        r2 = "0x0112";
        r3 = "0x0005";
        goto L19
    }

    private static void assertCswNew(String r1, int r2, String r3, int r4) {
        if (r4 != r2) goto L4;
        return;
    L4:
        LOG.atWarn().a("Since FIB.nFib == {} value of FIB.cswNew MUST be {}, not 0x{}", r1, r3, Integer.toHexString(r4));
    }

    public void fillVariableFields(byte[] r9, byte[] r10) {
        HashSet r5 = new HashSet();
        r5.add(1);
        r5.add(33);
        r5.add(31);
        r5.add(12);
        r5.add(13);
        r5.add(6);
        r5.add(73);
        r5.add(74);
        FieldsDocumentPart[] r0 = FieldsDocumentPart.values();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r5.add(Integer.valueOf(r0[r3].getFibFieldsField()));
        r3 = r3 + 1;
        goto L3
    L5:
        r5.add(22);
        r5.add(23);
        r5.add(21);
        NoteType[] r4 = NoteType.values();
        int r6 = r4.length;
    L6:
        if (r2 >= r6) goto L8;
        NoteType r7 = r4[r2];
        r5.add(Integer.valueOf(r7.getFibDescriptorsFieldIndex()));
        r5.add(Integer.valueOf(r7.getFibTextPositionsFieldIndex()));
        r2 = r2 + 1;
        goto L6
    L8:
        r5.add(15);
        r5.add(51);
        r5.add(71);
        r5.add(87);
        this._fieldHandler = new FIBFieldHandler(r9, 154, this._cbRgFcLcb, r10, r5, true);
    }

    public int getFSPAPlcfLength(FSPADocumentPart r1) {
        return this._fieldHandler.getFieldSize(r1.getFibFieldsField());
    }

    public int getFSPAPlcfOffset(FSPADocumentPart r1) {
        return this._fieldHandler.getFieldOffset(r1.getFibFieldsField());
    }

    public int getFcClx() {
        return this._fieldHandler.getFieldOffset(33);
    }

    public int getFcDggInfo() {
        return this._fieldHandler.getFieldOffset(50);
    }

    public int getFcDop() {
        return this._fieldHandler.getFieldOffset(31);
    }

    public int getFcPlcfbkf() {
        return this._fieldHandler.getFieldOffset(22);
    }

    public int getFcPlcfbkl() {
        return this._fieldHandler.getFieldOffset(23);
    }

    public int getFcPlcfbteChpx() {
        return this._fieldHandler.getFieldOffset(12);
    }

    public int getFcPlcfbtePapx() {
        return this._fieldHandler.getFieldOffset(13);
    }

    public int getFcPlcfsed() {
        return this._fieldHandler.getFieldOffset(6);
    }

    public int getFcPlfLfo() {
        return this._fieldHandler.getFieldOffset(74);
    }

    public int getFcPlfLst() {
        return this._fieldHandler.getFieldOffset(73);
    }

    public int getFcStshf() {
        return this._fieldHandler.getFieldOffset(1);
    }

    public int getFcSttbSavedBy() {
        return this._fieldHandler.getFieldOffset(71);
    }

    public int getFcSttbfRMark() {
        return this._fieldHandler.getFieldOffset(51);
    }

    public int getFcSttbfbkmk() {
        return this._fieldHandler.getFieldOffset(21);
    }

    public int getFcSttbfffn() {
        return this._fieldHandler.getFieldOffset(15);
    }

    public FibBase getFibBase() {
        return this._fibBase;
    }

    public int getFieldsPlcfLength(FieldsDocumentPart r1) {
        return this._fieldHandler.getFieldSize(r1.getFibFieldsField());
    }

    public int getFieldsPlcfOffset(FieldsDocumentPart r1) {
        return this._fieldHandler.getFieldOffset(r1.getFibFieldsField());
    }

    public int getLcbDggInfo() {
        return this._fieldHandler.getFieldSize(50);
    }

    public int getLcbDop() {
        return this._fieldHandler.getFieldSize(31);
    }

    public int getLcbPlcfbkf() {
        return this._fieldHandler.getFieldSize(22);
    }

    public int getLcbPlcfbkl() {
        return this._fieldHandler.getFieldSize(23);
    }

    public int getLcbPlcfbteChpx() {
        return this._fieldHandler.getFieldSize(12);
    }

    public int getLcbPlcfbtePapx() {
        return this._fieldHandler.getFieldSize(13);
    }

    public int getLcbPlcfsed() {
        return this._fieldHandler.getFieldSize(6);
    }

    public int getLcbPlfLfo() {
        return this._fieldHandler.getFieldSize(74);
    }

    public int getLcbPlfLst() {
        return this._fieldHandler.getFieldSize(73);
    }

    public int getLcbSttbSavedBy() {
        return this._fieldHandler.getFieldSize(71);
    }

    public int getLcbSttbfRMark() {
        return this._fieldHandler.getFieldSize(51);
    }

    public int getLcbSttbfbkmk() {
        return this._fieldHandler.getFieldSize(21);
    }

    public int getLcbSttbfffn() {
        return this._fieldHandler.getFieldSize(15);
    }

    public int getNFib() {
        if (this._cswNew != 0) goto L7;
        return this._fibBase.getNFib();
    L7:
        return this._nFibNew;
    }

    public int getNotesDescriptorsOffset(NoteType r1) {
        return this._fieldHandler.getFieldOffset(r1.getFibDescriptorsFieldIndex());
    }

    public int getNotesDescriptorsSize(NoteType r1) {
        return this._fieldHandler.getFieldSize(r1.getFibDescriptorsFieldIndex());
    }

    public int getNotesTextPositionsOffset(NoteType r1) {
        return this._fieldHandler.getFieldOffset(r1.getFibTextPositionsFieldIndex());
    }

    public int getNotesTextPositionsSize(NoteType r1) {
        return this._fieldHandler.getFieldSize(r1.getFibTextPositionsFieldIndex());
    }

    public int getSubdocumentTextStreamLength(SubdocumentType r1) {
        if (r1 == null) goto L6;
        return this._fibRgLw.getSubdocumentTextStreamLength(r1);
    L6:
        throw new IllegalArgumentException("argument 'type' is null");
    }

    public void setSubdocumentTextStreamLength(SubdocumentType r2, int r3) {
        if (r2 == null) goto L9;
        if (r3 < 0) goto L7;
        this._fibRgLw.setSubdocumentTextStreamLength(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException("Subdocument length can't be less than 0 (passed value is " + r3 + "). If there is no subdocument length must be set to zero.");
    L9:
        throw new IllegalArgumentException("argument 'type' is null");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this._fibBase);
        r0.append("[FIB2]\n");
        r0.append("\tSubdocuments info:\n");
        SubdocumentType[] r1 = SubdocumentType.values();
        int r2 = r1.length;
        int r4 = 0;
    L4:
        if (r4 >= r2) goto L6;
        SubdocumentType r6 = r1[r4];
        r0.append("\t\t");
        r0.append(r6);
        r0.append(" has length of ");
        r0.append(getSubdocumentTextStreamLength(r6));
        r0.append(" char(s)\n");
        r4 = r4 + 1;
        goto L4
    L6:
        r0.append("\tFields PLCF info:\n");
        FieldsDocumentPart[] r3 = FieldsDocumentPart.values();
        int r5 = r3.length;
        int r7 = 0;
    L8:
        if (r7 >= r5) goto L10;
        FieldsDocumentPart r8 = r3[r7];
        r0.append("\t\t");
        r0.append(r8);
        r0.append(": PLCF starts at ");
        r0.append(getFieldsPlcfOffset(r8));
        r0.append(" and have length of ");
        r0.append(getFieldsPlcfLength(r8));
        r0.append("\n");
        r7 = r7 + 1;
        goto L8
    L10:
        r0.append("\tNotes PLCF info:\n");
        NoteType[] r9 = NoteType.values();
        int r10 = r9.length;
        int r11 = 0;
    L11:
        if (r11 >= r10) goto L13;
        NoteType r12 = r9[r11];
        r0.append("\t\t");
        r0.append(r12);
        r0.append(": descriptions starts ");
        r0.append(getNotesDescriptorsOffset(r12));
        r0.append(" and have length of ");
        r0.append(getNotesDescriptorsSize(r12));
        r0.append(" bytes\n");
        r0.append("\t\t");
        r0.append(r12);
        r0.append(": text positions starts ");
        r0.append(getNotesTextPositionsOffset(r12));
        r0.append(" and have length of ");
        r0.append(getNotesTextPositionsSize(r12));
        r0.append(" bytes\n");
        r11 = r11 + 1;
        goto L11
    L13:
        r0.append(this._fieldHandler);
        r0.append("\tJava reflection info:\n");     // Catch: Exception -> L27
        Method[] r13 = FileInformationBlock.class.getMethods();     // Catch: Exception -> L27
        int r14 = r13.length;     // Catch: Exception -> L27
        int r15 = 0;
    L15:
        if (r15 >= r14) goto L29;
        Method r16 = r13[r15];     // Catch: Exception -> L27
        if (r16.getName().startsWith("get") == false) goto L26;
        if (Modifier.isPublic(r16.getModifiers()) == false) goto L26;
        if (Modifier.isStatic(r16.getModifiers()) == true) goto L26;
        if (r16.getParameterTypes().length > 0) goto L26;
        r0.append("\t\t");     // Catch: Exception -> L27
        r0.append(r16.getName());     // Catch: Exception -> L27
        r0.append(" => ");     // Catch: Exception -> L27
        r0.append(r16.invoke(this, new Object[0]));     // Catch: Exception -> L27
        r0.append("\n");     // Catch: Exception -> L27
    L26:
        r15 = r15 + 1;
    L29:
        r0.append("[/FIB2]\n");
        return r0.toString();
    L27:
        e = move-exception;
        r0.append("(exc: ").append(e.getMessage()).append(")");
        goto L29
    }
}
