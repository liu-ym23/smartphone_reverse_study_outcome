package org.apache.poi.hssf.record.cont;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.util.DelayableLittleEndianOutput;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianOutput;

/* JADX INFO: loaded from: classes7.dex */
final class UnknownLengthRecordOutput implements LittleEndianOutput {
    private final byte[] _byteBuffer;
    private final LittleEndianOutput _dataSizeOutput;
    private final LittleEndianOutput _originalOut;
    private LittleEndianOutput _out;
    private int _size;

    public UnknownLengthRecordOutput(LittleEndianOutput r3, int r4) {
        LittleEndianOutput r5 = (LittleEndianOutput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianOutput.class, "com.obric.memorydata.plugin");
        this._originalOut = r5;
        r5.writeShort(r4);
        if (ZeusTransformUtils.instanceOf(r5, DelayableLittleEndianOutput.class) == false) goto L5;
        this._dataSizeOutput = ((DelayableLittleEndianOutput) ZeusTransformUtils.preCheckCast(r5, DelayableLittleEndianOutput.class, "com.obric.memorydata.plugin")).createDelayedOutput(2);
        this._byteBuffer = null;
        this._out = r5;
        return;
    L5:
        this._dataSizeOutput = r5;
        byte[] r6 = new byte[8224];
        this._byteBuffer = r6;
        this._out = new LittleEndianByteArrayOutputStream(r6, 0);
    }

    public int getAvailableSpace() {
        if (this._out == null) goto L7;
        return 8224 - this._size;
    L7:
        throw new IllegalStateException("Record already terminated");
    }

    public int getTotalSize() {
        return this._size + 4;
    }

    public void terminate() {
        if (this._out == null) goto L11;
        this._dataSizeOutput.writeShort(this._size);
        byte[] r0 = this._byteBuffer;
        if (r0 == null) goto L8;
        this._originalOut.write(r0, 0, this._size);
        this._out = null;
        return;
    L8:
        this._out = null;
        return;
    L11:
        throw new IllegalStateException("Record already terminated");
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r2) {
        this._out.write(r2);
        this._size += r2.length;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void write(byte[] r2, int r3, int r4) {
        this._out.write(r2, r3, r4);
        this._size += r4;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeByte(int r2) {
        this._out.writeByte(r2);
        this._size++;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeDouble(double r2) {
        this._out.writeDouble(r2);
        this._size += 8;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeInt(int r2) {
        this._out.writeInt(r2);
        this._size += 4;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeLong(long r2) {
        this._out.writeLong(r2);
        this._size += 8;
    }

    @Override // org.apache.poi.util.LittleEndianOutput
    public void writeShort(int r2) {
        this._out.writeShort(r2);
        this._size += 2;
    }
}
