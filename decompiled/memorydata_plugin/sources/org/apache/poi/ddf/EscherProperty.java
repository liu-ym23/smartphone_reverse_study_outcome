package org.apache.poi.ddf;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;

/* JADX INFO: loaded from: classes6.dex */
public abstract class EscherProperty implements GenericRecord {
    private static final int[] FLAG_MASK = null;
    private static final String[] FLAG_NAMES = null;
    private final short id;

    static {
        FLAG_MASK = new int[]{16384, 32768};
        FLAG_NAMES = new String[]{"IS_BLIP", "IS_COMPLEX"};
    }

    public EscherProperty(EscherPropertyTypes r2, boolean r3, boolean r4) {
        short r5 = r2.propNumber;
        int r0 = 0;
        if (r3 == false) goto L5;
        short r6 = ShortCompanionObject.MIN_VALUE;
    L6:
        int r7 = r5 | r6;
        if (r4 == false) goto L9;
        r0 = 16384;
    L9:
        this((short) (r7 | r0));
        return;
    L5:
        r6 = 0;
        goto L6
    }

    public EscherProperty(short r1) {
        this.id = r1;
    }

    public EscherProperty(short r2, boolean r3, boolean r4) {
        int r0 = 0;
        if (r3 == false) goto L5;
        short r5 = ShortCompanionObject.MIN_VALUE;
    L6:
        int r6 = r2 | r5;
        if (r4 == false) goto L9;
        r0 = 16384;
    L9:
        this((short) (r6 | r0));
        return;
    L5:
        r5 = 0;
        goto L6
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public List<? extends GenericRecord> getGenericChildren() {
        return null;
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties(OaidModel.KEY_ID, new $$Lambda$gJhxQeTlVOP9gseFjqfuGAS0xg(this), ActivityLifecycle.NAME, new $$Lambda$FTZwfFxIyGypMV2LfgTYNCgAArw(this), "propertyNumber", new $$Lambda$Ej9O6mooLTvMrJ07ukFcSGydSco(this), "propertySize", new $$Lambda$lFDRgJSpJVlYObbODNNYAiUhc(this), "flags", GenericRecordUtil.getBitsAsString(new $$Lambda$UaM7XWdB6TtSmyis1kHE_aVxcs(this), FLAG_MASK, FLAG_NAMES));
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public EscherPropertyTypes getGenericRecordType() {
        return EscherPropertyTypes.forPropertyID(this.id);
    }

    public short getId() {
        return this.id;
    }

    public String getName() {
        return EscherPropertyTypes.forPropertyID(getPropertyNumber()).propName;
    }

    public short getPropertyNumber() {
        return (short) (this.id & 16383);
    }

    public int getPropertySize() {
        return 6;
    }

    public boolean isComplex() {
        if ((this.id & ShortCompanionObject.MIN_VALUE) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public abstract int serializeComplexPart(byte[] r1, int r2);

    public abstract int serializeSimplePart(byte[] r1, int r2);

    public final String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }
}
