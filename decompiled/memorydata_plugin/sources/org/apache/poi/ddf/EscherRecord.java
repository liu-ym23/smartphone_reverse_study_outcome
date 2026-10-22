package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public abstract class EscherRecord implements GenericRecord {
    private static final BitField fInstance = null;
    private static final BitField fVersion = null;
    private short _options;
    private short _recordId;

    static {
        fInstance = BitFieldFactory.getInstance(65520);
        fVersion = BitFieldFactory.getInstance(15);
    }

    public EscherRecord() {
    }

    public static short readInstance(byte[] r0, int r1) {
        short r2 = LittleEndian.getShort(r0, r1);
        return fInstance.getShortValue(r2);
    }

    public abstract int fillFields(byte[] r1, int r2, EscherRecordFactory r3);

    public EscherRecord getChild(int r2) {
        return (EscherRecord) ZeusTransformUtils.preCheckCast(getChildRecords().get(r2), EscherRecord.class, "com.obric.memorydata.plugin");
    }

    public List<EscherRecord> getChildRecords() {
        return Collections.emptyList();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<? extends GenericRecord> getGenericChildren() {
        return getChildRecords();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("recordId", new $$Lambda$YdFU1GskliZhvknhdlPutpxXaN4(this), "version", new $$Lambda$a6v213vD_2It40wQ1yGXzUWx0(this), "instance", new $$Lambda$aK3wtdOhj96T98sTGqNlET8krA(this), "options", new $$Lambda$W4h7lgWotRPTR48ANQePRnwKJM(this), "recordSize", new $$Lambda$qWpVbr6ADrymElBUKylAs217KQ(this));
    }

    public short getInstance() {
        return fInstance.getShortValue(this._options);
    }

    public short getOptions() {
        return this._options;
    }

    public short getRecordId() {
        return this._recordId;
    }

    public abstract int getRecordSize();

    public short getVersion() {
        return fVersion.getShortValue(this._options);
    }

    public boolean isContainerRecord() {
        if (getVersion() != 15) goto L5;
        return true;
    L5:
        return false;
    }

    public int readHeader(byte[] r2, int r3) {
        this._options = LittleEndian.getShort(r2, r3);
        this._recordId = LittleEndian.getShort(r2, r3 + 2);
        return LittleEndian.getInt(r2, r3 + 4);
    }

    public int serialize(int r2, byte[] r3) {
        return serialize(r2, r3, new NullEscherSerializationListener());
    }

    public abstract int serialize(int r1, byte[] r2, EscherSerializationListener r3);

    public byte[] serialize() {
        byte[] r0 = new byte[getRecordSize()];
        serialize(0, r0);
        return r0;
    }

    public void setInstance(short r3) {
        this._options = fInstance.setShortValue(this._options, r3);
    }

    public void setOptions(short r2) {
        setVersion(fVersion.getShortValue(r2));
        setInstance(fInstance.getShortValue(r2));
        this._options = r2;
    }

    public void setRecordId(short r1) {
        this._recordId = r1;
    }

    public void setVersion(short r3) {
        this._options = fVersion.setShortValue(this._options, r3);
    }

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
