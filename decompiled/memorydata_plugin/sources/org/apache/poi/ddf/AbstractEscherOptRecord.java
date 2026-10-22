package org.apache.poi.ddf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.LittleEndian;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractEscherOptRecord extends EscherRecord {
    private final List<EscherProperty> properties;

    public AbstractEscherOptRecord() {
        this.properties = new ArrayList();
    }

    private int getPropertiesSize() {
        Iterator<EscherProperty> r4 = this.properties.iterator();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L6;
        r0 = r0 + ((EscherProperty) ZeusTransformUtils.preCheckCast(r4.next(), EscherProperty.class, "com.obric.memorydata.plugin")).getPropertySize();
        goto L4
    L6:
        return r0;
    }

    static /* synthetic */ boolean lambda$lookup$0(int r0, EscherProperty r1) {
        if (r1.getPropertyNumber() != r0) goto L5;
        return true;
    L5:
        return false;
    }

    public void addEscherProperty(EscherProperty r1) {
        this.properties.add(r1);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] r4, int r5, EscherRecordFactory r6) {
        EscherRecordFactory r7 = (EscherRecordFactory) ZeusTransformUtils.wrapperContextForParams(r6, EscherRecordFactory.class, "com.obric.memorydata.plugin");
        int r8 = readHeader(r4, r5);
        if (r8 < 0) goto L7;
        short r0 = readInstance(r4, r5);
        EscherPropertyFactory r1 = new EscherPropertyFactory();
        this.properties.clear();
        this.properties.addAll(r1.createProperties(r4, r5 + 8, r0));
        return r8 + 8;
    L7:
        throw new IllegalStateException("Invalid value for bytesRemaining: " + r8);
    }

    public List<EscherProperty> getEscherProperties() {
        return this.properties;
    }

    @Override // org.apache.poi.ddf.EscherRecord, org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("base", new $$Lambda$AbstractEscherOptRecord$fMedgfpIziQMG9mWOwBbq3UfSDU(this), "isContainer", new $$Lambda$d7ncM4dRDGf9rYxUmONcQNTtuo(this), "properties", new $$Lambda$pNvEL0JCiRkGo4pqGDycwEtGs40(this));
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return getPropertiesSize() + 8;
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$AbstractEscherOptRecord() {
        return super.getGenericProperties();
    }

    public <T extends EscherProperty> T lookup(final int r2) {
        return (T) ZeusTransformUtils.preCheckCast(this.properties.stream().filter(new $$Lambda$AbstractEscherOptRecord$kR2hiziiWDE01dsFzO0JAF6Bc(r2)).findFirst().orElse(null), EscherProperty.class, "com.obric.memorydata.plugin");
    }

    public <T extends EscherProperty> T lookup(EscherPropertyTypes r1) {
        return (T) lookup(r1.propNumber);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int r6, byte[] r7, EscherSerializationListener r8) {
        EscherSerializationListener r9 = (EscherSerializationListener) ZeusTransformUtils.wrapperContextForParams(r8, EscherSerializationListener.class, "com.obric.memorydata.plugin");
        r9.beforeRecordSerialize(r6, getRecordId(), this);
        LittleEndian.putShort(r7, r6, getOptions());
        LittleEndian.putShort(r7, r6 + 2, getRecordId());
        LittleEndian.putInt(r7, r6 + 4, getPropertiesSize());
        int r0 = r6 + 8;
        Iterator<EscherProperty> r2 = this.properties.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + ((EscherProperty) ZeusTransformUtils.preCheckCast(r2.next(), EscherProperty.class, "com.obric.memorydata.plugin")).serializeSimplePart(r7, r0);
        goto L4
    L6:
        Iterator<EscherProperty> r3 = this.properties.iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r0 = r0 + ((EscherProperty) ZeusTransformUtils.preCheckCast(r3.next(), EscherProperty.class, "com.obric.memorydata.plugin")).serializeComplexPart(r7, r0);
        goto L8
    L10:
        int r10 = r0 - r6;
        r9.afterRecordSerialize(r0, getRecordId(), r10, this);
        return r10;
    }

    public void sortProperties() {
        this.properties.sort(Comparator.comparingInt($$Lambda$g7gXiBtHakst80mcJpLq2t5ccIU.INSTANCE));
    }
}
