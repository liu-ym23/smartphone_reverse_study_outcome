package org.apache.poi.hslf.record;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hslf.exceptions.HSLFException;
import org.apache.poi.sl.usermodel.TextShape;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public final class TextHeaderAtom extends RecordAtom implements ParentAwareRecord {
    public static final long _type = 0;
    private byte[] _header;
    private int index;
    private RecordContainer parentRecord;
    private int textType;

    static {
        _type = RecordTypes.TextHeaderAtom.typeID;
    }

    public TextHeaderAtom() {
        this.index = -1;
        byte[] r0 = new byte[8];
        this._header = r0;
        LittleEndian.putUShort(r0, 0, 0);
        LittleEndian.putUShort(this._header, 2, (int) _type);
        LittleEndian.putInt(this._header, 4, 4);
        this.textType = TextShape.TextPlaceholder.OTHER.nativeId;
    }

    public TextHeaderAtom(byte[] r2, int r3, int r4) {
        this.index = -1;
        if (r4 < 12) goto L5;
    L9:
        int r5 = r3 + 8;
        this._header = Arrays.copyOfRange(r2, r3, r5);
        this.textType = LittleEndian.getInt(r2, r5);
        return;
    L5:
        if ((r2.length - r3) >= 12) goto L9;
        throw new HSLFException("Not enough data to form a TextHeaderAtom (always 12 bytes long) - found " + (r2.length - r3));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("index", new $$Lambda$yywWhb6aNWtZgxOpS8nnhJgk2k(this), "textType", new $$Lambda$vKguFYDcuNTdJWkNPVVUxIQz_7Y(this));
    }

    public int getIndex() {
        return this.index;
    }

    public RecordContainer getParentRecord() {
        return this.parentRecord;
    }

    @Override // org.apache.poi.hslf.record.Record
    public long getRecordType() {
        return _type;
    }

    public int getTextType() {
        return this.textType;
    }

    public TextShape.TextPlaceholder getTextTypeEnum() {
        return TextShape.TextPlaceholder.fromNativeId(this.textType);
    }

    public void setIndex(int r1) {
        this.index = r1;
    }

    @Override // org.apache.poi.hslf.record.ParentAwareRecord
    public void setParentRecord(RecordContainer r1) {
        this.parentRecord = r1;
    }

    @Override // org.apache.poi.hslf.record.Record
    public void writeOut(OutputStream r2) {
        r2.write(this._header);
        writeLittleEndian(this.textType, r2);
    }
}
