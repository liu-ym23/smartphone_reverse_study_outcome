package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayInputStream;

/* JADX INFO: loaded from: classes7.dex */
public final class TextSpecInfoAtom extends RecordAtom {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long _type = 0;
    private byte[] _data;
    private final byte[] _header;

    static {
        _type = RecordTypes.TextSpecInfoAtom.typeID;
    }

    public TextSpecInfoAtom() {
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUInt(r0, 4, _type);
        reset(1);
    }

    public TextSpecInfoAtom(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._data = IOUtils.safelyClone(r2, r0, r4 - 8, getMaxRecordLength());
    }

    public int getCharactersCovered() {
        TextSpecInfoRun[] r4 = getTextSpecInfoRuns();
        int r0 = r4.length;
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r2 = r2 + r4[r1].getLength();
        r1 = r1 + 1;
        goto L3
    L5:
        return r2;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("charactersCovered", new $$Lambda$mrgrrKIM5I_WdIRkey4p3Vp4idA(this), "textSpecInfoRuns", new $$Lambda$tTNrnjY1MtqPyNm1dToirrLSMMs(this));
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public TextSpecInfoRun[] getTextSpecInfoRuns() {
        LittleEndianByteArrayInputStream r0 = new LittleEndianByteArrayInputStream(this._data);
        ArrayList r1 = new ArrayList();
    L4:
        if (r0.getReadIndex() >= this._data.length) goto L7;
        r1.add(new TextSpecInfoRun(r0));
        goto L4
    L7:
        return (TextSpecInfoRun[]) ZeusTransformUtils.preCheckCast(r1.toArray(new TextSpecInfoRun[0]), TextSpecInfoRun[].class, "com.obric.memorydata.plugin");
    }

    public void reset(int r2) {
        TextSpecInfoRun r0 = new TextSpecInfoRun(r2);
        UnsynchronizedByteArrayOutputStream r3 = new UnsynchronizedByteArrayOutputStream();
        r0.writeOut(r3);     // Catch: IOException -> L6
        byte[] r4 = r3.toByteArray();
        this._data = r4;
        LittleEndian.putInt(this._header, 4, r4.length);
        return;
    L6:
        e = move-exception;
        throw new HSLFException(e);
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
