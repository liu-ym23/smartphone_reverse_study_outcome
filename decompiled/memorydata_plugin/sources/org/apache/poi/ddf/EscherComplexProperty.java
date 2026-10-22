package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import kotlin.jvm.internal.ShortCompanionObject;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherComplexProperty extends EscherProperty {
    private static int MAX_RECORD_LENGTH = 100000000;
    private byte[] complexData;

    static {
    }

    public EscherComplexProperty(short r2, int r3) {
        super((short) (r2 | ShortCompanionObject.MIN_VALUE));
        this.complexData = IOUtils.safelyAllocate(r3, MAX_RECORD_LENGTH);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r3, EscherComplexProperty.class) == true) goto L10;
        return false;
    L10:
        EscherComplexProperty r4 = (EscherComplexProperty) ZeusTransformUtils.preCheckCast(r3, EscherComplexProperty.class, "com.obric.memorydata.plugin");
        return Arrays.equals(this.complexData, r4.complexData);
    }

    public byte[] getComplexData() {
        return this.complexData;
    }

    @Override // org.apache.poi.ddf.EscherProperty, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherComplexProperty$s88i9coL7Wjtf2Ae0CLkqZxzBw8(this), "data", new $$Lambda$cPpXIikUX1gINg3keeNxnIMFrc(this));
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int getPropertySize() {
        return this.complexData.length + 6;
    }

    public int hashCode() {
        return Arrays.deepHashCode(new Object[]{this.complexData, Short.valueOf(getId())});
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherComplexProperty() {
        return super.getGenericProperties();
    }

    public void resizeComplexData(int r2) {
        resizeComplexData(r2, Integer.MAX_VALUE);
    }

    public void resizeComplexData(int r4, int r5) {
        if (r4 != this.complexData.length) goto L5;
        return;
    L5:
        byte[] r0 = IOUtils.safelyAllocate(r4, MAX_RECORD_LENGTH);
        byte[] r1 = this.complexData;
        System.arraycopy(r1, 0, r0, 0, Math.min(Math.min(r1.length, r5), r4));
        this.complexData = r0;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeComplexPart(byte[] r4, int r5) {
        byte[] r0 = this.complexData;
        System.arraycopy(r0, 0, r4, r5, r0.length);
        return this.complexData.length;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] r2, int r3) {
        LittleEndian.putShort(r2, r3, getId());
        LittleEndian.putInt(r2, r3 + 2, this.complexData.length);
        return 6;
    }

    public int setComplexData(byte[] r4, int r5) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        int r1 = Math.max(0, Math.min(this.complexData.length, r4.length - r5));
        System.arraycopy(r4, r5, this.complexData, 0, r1);
        return r1;
    }
}
