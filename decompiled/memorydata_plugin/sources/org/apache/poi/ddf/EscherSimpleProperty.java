package org.apache.poi.ddf;

import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public class EscherSimpleProperty extends EscherProperty {
    private final int propertyValue;

    public EscherSimpleProperty(EscherPropertyTypes r2, int r3) {
        this(r2, false, false, r3);
    }

    public EscherSimpleProperty(EscherPropertyTypes r1, boolean r2, boolean r3, int r4) {
        super(r1, r2, r3);
        this.propertyValue = r4;
    }

    public EscherSimpleProperty(short r1, int r2) {
        super(r1);
        this.propertyValue = r2;
    }

    public EscherSimpleProperty(short r1, boolean r2, boolean r3, int r4) {
        super(r1, r2, r3);
        this.propertyValue = r4;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, EscherSimpleProperty.class) == true) goto L8;
        return false;
    L8:
        EscherSimpleProperty r6 = (EscherSimpleProperty) ZeusTransformUtils.preCheckCast(r5, EscherSimpleProperty.class, "com.obric.memorydata.plugin");
        if (this.propertyValue == r6.propertyValue) goto L12;
        return false;
    L12:
        if (getId() == r6.getId()) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // org.apache.poi.ddf.EscherProperty, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$EscherSimpleProperty$Lq7S_JkTACQWUeIjLg2XzcPq9co(this), EventBody.KEY_VALUE, new $$Lambda$yzJOyihJtopXiZaBMzPrKW3MJUw(this));
    }

    public int getPropertyValue() {
        return this.propertyValue;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.propertyValue), Short.valueOf(getId())});
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$EscherSimpleProperty() {
        return super.getGenericProperties();
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeComplexPart(byte[] r1, int r2) {
        return 0;
    }

    @Override // org.apache.poi.ddf.EscherProperty
    public int serializeSimplePart(byte[] r2, int r3) {
        LittleEndian.putShort(r2, r3, getId());
        LittleEndian.putInt(r2, r3 + 2, this.propertyValue);
        return 6;
    }
}
