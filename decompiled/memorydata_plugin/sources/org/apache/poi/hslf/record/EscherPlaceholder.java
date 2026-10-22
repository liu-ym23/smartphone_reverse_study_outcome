package org.apache.poi.hslf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.EscherRecordFactory;
import org.apache.poi.ddf.EscherSerializationListener;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes7.dex */
public class EscherPlaceholder extends EscherRecord {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final short RECORD_ID = 0;
    private byte placementId;
    private int position;
    private byte size;
    private short unused;

    static {
        RECORD_ID = RecordTypes.OEPlaceholderAtom.typeID;
    }

    public EscherPlaceholder() {
        this.position = -1;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r3, int r4, EscherRecordFactory r5) {
        EscherRecordFactory r6 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r5, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r7 = readHeader(r3, r4);
        this.position = LittleEndian.getInt(r3, r4 + 8);
        this.placementId = r3[r4 + 12];
        this.size = r3[r4 + 13];
        this.unused = LittleEndian.getShort(r3, r4 + 14);
        return r7 + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherPlaceholder$VS22zVeCLud1HybBC2szEL_xnmU(this), "position", new $$Lambda$EQpAYD6ZGJ2OtHXuRUhkjHQ6Mmw(this), "placementId", new $$Lambda$8bKqKWMYo4upLmlCUNreghQHimk(this), "size", new $$Lambda$oVxxo7Bbu8MRfPPPPGtOKk2Q_A(this));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Enum getGenericRecordType() {
        return RecordTypes.OEPlaceholderAtom;
    }

    public byte getPlacementId() {
        return this.placementId;
    }

    public int getPosition() {
        return this.position;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 16;
    }

    public byte getSize() {
        return this.size;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherPlaceholder() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r3, byte[] r4, EscherSerializationListener r5) {
        EscherSerializationListener r6 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r5, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r6.beforeRecordSerialize(r3, getRecordId(), this);
        LittleEndian.putShort(r4, r3, getOptions());
        LittleEndian.putShort(r4, r3 + 2, getRecordId());
        LittleEndian.putInt(r4, r3 + 4, 8);
        LittleEndian.putInt(r4, r3 + 8, this.position);
        LittleEndian.putByte(r4, r3 + 12, this.placementId);
        LittleEndian.putByte(r4, r3 + 13, this.size);
        LittleEndian.putShort(r4, r3 + 14, this.unused);
        r6.afterRecordSerialize(r3 + getRecordSize(), getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }
}
