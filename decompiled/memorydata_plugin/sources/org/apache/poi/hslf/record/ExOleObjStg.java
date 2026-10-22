package org.apache.poi.hslf.record;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.zip.InflaterInputStream;
import org.apache.commons.io.input.BoundedInputStream;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class ExOleObjStg extends PositionDependentRecordAtom implements PersistRecord {
    private byte[] _data;
    private final byte[] _header;
    private int _persistId;

    public ExOleObjStg() {
        byte[] r0 = new byte[8];
        this._header = r0;
        this._data = new byte[0];
        LittleEndian.putShort(r0, 0, 16);
        LittleEndian.putShort(r0, 2, (short) getRecordType());
        LittleEndian.putInt(r0, 4, this._data.length);
    }

    public ExOleObjStg(byte[] r2, int r3, int r4) {
        int r0 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r0);
        this._data = IOUtils.safelyClone(r2, r0, r4 - 8, 100000000);
    }

    public InputStream getData() {
        if (isCompressed() == false) goto L6;
        int r0 = LittleEndian.getInt(this._data);
        byte[] r4 = this._data;
        return new BoundedInputStream(new InflaterInputStream(new ByteArrayInputStream(r4, 4, r4.length)), r0);
    L6:
        byte[] r5 = this._data;
        return new ByteArrayInputStream(r5, 0, r5.length);
    }

    public int getDataLength() {
        boolean r0 = isCompressed();
        byte[] r1 = this._data;
        if (r0 == false) goto L7;
        return LittleEndian.getInt(r1, 0);
    L7:
        return r1.length;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("compressed", new $$Lambda$cZyZmt3LJQ7irsasQmhHyBJ6O_A(this), "persistId", new $$Lambda$VTiYkR24_TSNpw2F6_LUPRvbvBk(this), "dataLength", new $$Lambda$mXceE6CCwBfjIaGHqRro2gS49s(this), "data", new $$Lambda$w8Fzm2OzR4CWkacjzuX6ciRgw74(this));
    }

    public int getPersistId() {
        return this._persistId;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return RecordTypes.ExOleObjStg.typeID;
    }

    public boolean isCompressed() {
        if (LittleEndian.getShort(this._header, 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // org.apache.poi.hslf.record.PersistRecord
    public void setPersistId(int r1) {
        this._persistId = r1;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        r2.write(this._data);
    }
}
