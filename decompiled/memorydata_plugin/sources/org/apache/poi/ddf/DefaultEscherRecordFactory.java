package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.function.Supplier;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class DefaultEscherRecordFactory implements EscherRecordFactory {
    private static final BitField IS_CONTAINER = null;

    static {
        IS_CONTAINER = BitFieldFactory.getInstance(15);
    }

    public DefaultEscherRecordFactory() {
    }

    @Override // org.apache.poi.ddf.EscherRecordFactory
    public EscherRecord createRecord(byte[] r3, int r4) {
        short r0 = LittleEndian.getShort(r3, r4);
        short r5 = LittleEndian.getShort(r3, r4 + 2);
        EscherRecord r2 = (EscherRecord) ZeusTransformUtils.preCheckCast(getConstructor(r0, r5).get(), EscherRecord.class, "com.obric.memorydata.plugin");
        r2.setRecordId(r5);
        r2.setOptions(r0);
        return r2;
    }

    public Supplier<? extends EscherRecord> getConstructor(short r2, short r3) {
        EscherRecordTypes r1 = EscherRecordTypes.forTypeID(r3);
        if (r1 != EscherRecordTypes.UNKNOWN) goto L9;
        if (IS_CONTAINER.isAllSet(r2) == false) goto L9;
        return $$Lambda$UkrJb21kH7REMSc0sFqgtces4P4.INSTANCE;
    L9:
        if (r1.constructor == null) goto L15;
        if (r1 == EscherRecordTypes.UNKNOWN) goto L15;
        return r1.constructor;
    L15:
        if (EscherBlipRecord.RECORD_ID_START > r3) goto L21;
        if (r3 > EscherBlipRecord.RECORD_ID_END) goto L21;
        return $$Lambda$2FrAKTLuW8BA9W_wjEjmP6VP1ig.INSTANCE;
    L21:
        return $$Lambda$JkxpoELxDKaCsvKFw1leavjEJ_8.INSTANCE;
    }
}
