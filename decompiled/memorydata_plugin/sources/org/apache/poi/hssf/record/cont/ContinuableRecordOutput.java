package org.apache.poi.hssf.record.cont;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ContinuableRecordOutput implements LittleEndianOutput {
    private static final LittleEndianOutput NOPOutput = null;
    private final LittleEndianOutput _out;
    private int _totalPreviousRecordsSize;
    private UnknownLengthRecordOutput _ulrOutput;

    static {
        NOPOutput = new AnonymousClass1();
    }

    public ContinuableRecordOutput(LittleEndianOutput r3, int r4) {
        LittleEndianOutput r5 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        this._ulrOutput = new UnknownLengthRecordOutput(r5, r4);
        this._out = r5;
        this._totalPreviousRecordsSize = 0;
    }

    public static ContinuableRecordOutput createForCountingOnly() {
        return new ContinuableRecordOutput(NOPOutput, -777);
    }

    private void writeCharacterData(String r6, boolean r7) {
        int r0 = r6.length();
        int r1 = 0;
        if (r7 == false) goto L10;
    L4:
        int r8 = Math.min(r0 - r1, this._ulrOutput.getAvailableSpace() / 2);
    L5:
        if (r8 <= 0) goto L7;
        this._ulrOutput.writeShort(r6.charAt(r1));
        r8 = r8 - 1;
        r1 = r1 + 1;
        goto L5
    L7:
        if (r1 >= r0) goto L15;
        writeContinue();
        writeByte(1);
        goto L4
    L15:
        return;
    L10:
        int r9 = 0;
    L11:
        int r2 = Math.min(r0 - r9, this._ulrOutput.getAvailableSpace());
    L12:
        if (r2 <= 0) goto L14;
        this._ulrOutput.writeByte(r6.charAt(r9));
        r2 = r2 - 1;
        r9 = r9 + 1;
        goto L12
    L14:
        if (r9 >= r0) goto L21;
        writeContinue();
        writeByte(0);
        goto L11
    }

    public int getAvailableSpace() {
        return this._ulrOutput.getAvailableSpace();
    }

    public int getTotalSize() {
        return this._totalPreviousRecordsSize + this._ulrOutput.getTotalSize();
    }

    void terminate() {
        this._ulrOutput.terminate();
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r2) {
        writeContinueIfRequired(r2.length);
        this._ulrOutput.write(r2);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r5, int r6, int r7) {
        int r0 = 0;
    L3:
        int r1 = Math.min(r7 - r0, this._ulrOutput.getAvailableSpace());
    L4:
        if (r1 <= 0) goto L6;
        this._ulrOutput.writeByte(r5[r0 + r6]);
        r1 = r1 - 1;
        r0 = r0 + 1;
        goto L4
    L6:
        if (r0 >= r7) goto L7;
        writeContinue();
        goto L3
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int r2) {
        writeContinueIfRequired(1);
        this._ulrOutput.writeByte(r2);
    }

    public void writeContinue() {
        this._ulrOutput.terminate();
        this._totalPreviousRecordsSize += this._ulrOutput.getTotalSize();
        this._ulrOutput = new UnknownLengthRecordOutput(this._out, 60);
    }

    public void writeContinueIfRequired(int r2) {
        if (this._ulrOutput.getAvailableSpace() >= r2) goto L6;
        writeContinue();
        return;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double r2) {
        writeContinueIfRequired(8);
        this._ulrOutput.writeDouble(r2);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int r2) {
        writeContinueIfRequired(4);
        this._ulrOutput.writeInt(r2);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long r2) {
        writeContinueIfRequired(8);
        this._ulrOutput.writeLong(r2);
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int r2) {
        writeContinueIfRequired(2);
        this._ulrOutput.writeShort(r2);
    }

    public void writeString(String r4, int r5, int r6) {
        boolean r0 = StringUtil.hasMultibyte(r4);
        if (r0 == false) goto L5;
        int r1 = 1;
        int r2 = 5;
    L6:
        if (r5 <= 0) goto L8;
        r1 = r1 | 8;
        r2 = r2 + 2;
    L8:
        if (r6 <= 0) goto L10;
        r1 = r1 | 4;
        r2 = r2 + 4;
    L10:
        writeContinueIfRequired(r2);
        writeShort(r4.length());
        writeByte(r1);
        if (r5 <= 0) goto L13;
        writeShort(r5);
    L13:
        if (r6 <= 0) goto L15;
        writeInt(r6);
    L15:
        writeCharacterData(r4, r0);
        return;
    L5:
        r2 = 4;
        r1 = 0;
        goto L6
    }

    public void writeStringData(String r4) {
        boolean r0 = StringUtil.hasMultibyte(r4);
        if (r0 == false) goto L5;
        int r1 = 1;
        int r2 = 3;
    L6:
        writeContinueIfRequired(r2);
        writeByte(r1);
        writeCharacterData(r4, r0);
        return;
    L5:
        r2 = 2;
        r1 = 0;
        goto L6
    }
}
