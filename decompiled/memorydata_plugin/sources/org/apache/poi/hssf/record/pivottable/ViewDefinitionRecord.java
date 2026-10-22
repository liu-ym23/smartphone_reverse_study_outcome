package org.apache.poi.hssf.record.pivottable;

import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.poi.hssf.record.HSSFRecordTypes;
import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.StringUtil;

/* JADX INFO: loaded from: classes7.dex */
public final class ViewDefinitionRecord extends StandardRecord {
    private int cCol;
    private int cDim;
    private int cDimCol;
    private int cDimData;
    private int cDimPg;
    private int cDimRw;
    private int cRw;
    private int colFirst;
    private int colFirstData;
    private int colLast;
    private String dataField;
    private int grbit;
    private int iCache;
    private int ipos4Data;
    private int itblAutoFmt;
    private String name;
    private int reserved;
    private int rwFirst;
    private int rwFirstData;
    private int rwFirstHead;
    private int rwLast;
    private int sxaxis4Data;

    public ViewDefinitionRecord(RecordInputStream r3) {
        this.rwFirst = r3.readUShort();
        this.rwLast = r3.readUShort();
        this.colFirst = r3.readUShort();
        this.colLast = r3.readUShort();
        this.rwFirstHead = r3.readUShort();
        this.rwFirstData = r3.readUShort();
        this.colFirstData = r3.readUShort();
        this.iCache = r3.readUShort();
        this.reserved = r3.readUShort();
        this.sxaxis4Data = r3.readUShort();
        this.ipos4Data = r3.readUShort();
        this.cDim = r3.readUShort();
        this.cDimRw = r3.readUShort();
        this.cDimCol = r3.readUShort();
        this.cDimPg = r3.readUShort();
        this.cDimData = r3.readUShort();
        this.cRw = r3.readUShort();
        this.cCol = r3.readUShort();
        this.grbit = r3.readUShort();
        this.itblAutoFmt = r3.readUShort();
        int r0 = r3.readUShort();
        int r1 = r3.readUShort();
        this.name = StringUtil.readUnicodeString(r3, r0);
        this.dataField = StringUtil.readUnicodeString(r3, r1);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public int getDataSize() {
        return (StringUtil.getEncodedSize(this.name) + 40) + StringUtil.getEncodedSize(this.dataField);
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("rwFirst", new $$Lambda$ViewDefinitionRecord$Z9nUoqbwY2ViEWPgRUJLJbUcKI(this));
        r0.put("rwLast", new $$Lambda$ViewDefinitionRecord$99NW6q_un2t_fHIWO_Jp8hfjmx4(this));
        r0.put("colFirst", new $$Lambda$ViewDefinitionRecord$2m9ENYen77G425OMHg096QDQCVM(this));
        r0.put("colLast", new $$Lambda$ViewDefinitionRecord$KjErJ8zELbjhNCtTfrdk2L4hjM(this));
        r0.put("rwFirstHead", new $$Lambda$ViewDefinitionRecord$h3Lbe8FpGl04FL5EKJsgtYyfWI(this));
        r0.put("rwFirstData", new $$Lambda$ViewDefinitionRecord$INbiEDmWKdCyiafQFzYvUZyJqM4(this));
        r0.put("colFirstData", new $$Lambda$ViewDefinitionRecord$qgFJxTTgkrXyu9JqXsQybTl6DDc(this));
        r0.put("iCache", new $$Lambda$ViewDefinitionRecord$TFBweUEhq1sPVHLgMwGpbbsOLz0(this));
        r0.put("reserved", new $$Lambda$ViewDefinitionRecord$_nE1sN8Pt8V1G80b8LViU5cAmU(this));
        r0.put("sxaxis4Data", new $$Lambda$ViewDefinitionRecord$aPyE9cmaMAU5MMsz0fZbvqgDc(this));
        r0.put("ipos4Data", new $$Lambda$ViewDefinitionRecord$caaDoIJOny6yKtK15h276OsuPuc(this));
        r0.put("cDim", new $$Lambda$ViewDefinitionRecord$SG6TUWaBq3yldNqdRcuSJ3fdkYQ(this));
        r0.put("cDimRw", new $$Lambda$ViewDefinitionRecord$6HaWP26nLYpqr8eZfRaJeWT7TM(this));
        r0.put("cDimCol", new $$Lambda$ViewDefinitionRecord$ioeFyyjUtALvoT9aAHI_oPd4T30(this));
        r0.put("cDimPg", new $$Lambda$ViewDefinitionRecord$b3Jn2tZvGVcJ63JCFz2SQJZPqS4(this));
        r0.put("cDimData", new $$Lambda$ViewDefinitionRecord$pkrO8Zf1Wtcg7Me3uoyP_W3e0nY(this));
        r0.put("cRw", new $$Lambda$ViewDefinitionRecord$kJV_oVLMYSvoOePu1rqCVGyALY(this));
        r0.put("cCol", new $$Lambda$ViewDefinitionRecord$y6Dmd4gL2oe1a_Ll9Hs5HBNKSo(this));
        r0.put("grbit", new $$Lambda$ViewDefinitionRecord$eBbkoGbs7OQ28giiF4xsSQb1Y(this));
        r0.put("itblAutoFmt", new $$Lambda$ViewDefinitionRecord$LhphyNLQneBonvzP58orGceCmw(this));
        r0.put(ActivityLifecycle.NAME, new $$Lambda$ViewDefinitionRecord$vBMLfIxJoVw8_vEWPzqkjQjdS4(this));
        r0.put("dataField", new $$Lambda$ViewDefinitionRecord$M5fEwTUM3QbJqvRQiS22WQW0Qg(this));
        return Collections.unmodifiableMap(r0);
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public /* bridge */ /* synthetic */ Enum getGenericRecordType() {
        return getGenericRecordType();
    }

    @Override // org.apache.poi.hssf.record.Record, org.apache.poi.common.usermodel.GenericRecord
    public HSSFRecordTypes getGenericRecordType() {
        return HSSFRecordTypes.VIEW_DEFINITION;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return 176;
    }

    public /* synthetic */ Object lambda$getGenericProperties$0$ViewDefinitionRecord() {
        return Integer.valueOf(this.rwFirst);
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$ViewDefinitionRecord() {
        return Integer.valueOf(this.rwLast);
    }

    public /* synthetic */ Object lambda$getGenericProperties$10$ViewDefinitionRecord() {
        return Integer.valueOf(this.ipos4Data);
    }

    public /* synthetic */ Object lambda$getGenericProperties$11$ViewDefinitionRecord() {
        return Integer.valueOf(this.cDim);
    }

    public /* synthetic */ Object lambda$getGenericProperties$12$ViewDefinitionRecord() {
        return Integer.valueOf(this.cDimRw);
    }

    public /* synthetic */ Object lambda$getGenericProperties$13$ViewDefinitionRecord() {
        return Integer.valueOf(this.cDimCol);
    }

    public /* synthetic */ Object lambda$getGenericProperties$14$ViewDefinitionRecord() {
        return Integer.valueOf(this.cDimPg);
    }

    public /* synthetic */ Object lambda$getGenericProperties$15$ViewDefinitionRecord() {
        return Integer.valueOf(this.cDimData);
    }

    public /* synthetic */ Object lambda$getGenericProperties$16$ViewDefinitionRecord() {
        return Integer.valueOf(this.cRw);
    }

    public /* synthetic */ Object lambda$getGenericProperties$17$ViewDefinitionRecord() {
        return Integer.valueOf(this.cCol);
    }

    public /* synthetic */ Object lambda$getGenericProperties$18$ViewDefinitionRecord() {
        return Integer.valueOf(this.grbit);
    }

    public /* synthetic */ Object lambda$getGenericProperties$19$ViewDefinitionRecord() {
        return Integer.valueOf(this.itblAutoFmt);
    }

    public /* synthetic */ Object lambda$getGenericProperties$2$ViewDefinitionRecord() {
        return Integer.valueOf(this.colFirst);
    }

    public /* synthetic */ Object lambda$getGenericProperties$20$ViewDefinitionRecord() {
        return this.name;
    }

    public /* synthetic */ Object lambda$getGenericProperties$21$ViewDefinitionRecord() {
        return this.dataField;
    }

    public /* synthetic */ Object lambda$getGenericProperties$3$ViewDefinitionRecord() {
        return Integer.valueOf(this.colLast);
    }

    public /* synthetic */ Object lambda$getGenericProperties$4$ViewDefinitionRecord() {
        return Integer.valueOf(this.rwFirstHead);
    }

    public /* synthetic */ Object lambda$getGenericProperties$5$ViewDefinitionRecord() {
        return Integer.valueOf(this.rwFirstData);
    }

    public /* synthetic */ Object lambda$getGenericProperties$6$ViewDefinitionRecord() {
        return Integer.valueOf(this.colFirstData);
    }

    public /* synthetic */ Object lambda$getGenericProperties$7$ViewDefinitionRecord() {
        return Integer.valueOf(this.iCache);
    }

    public /* synthetic */ Object lambda$getGenericProperties$8$ViewDefinitionRecord() {
        return Integer.valueOf(this.reserved);
    }

    public /* synthetic */ Object lambda$getGenericProperties$9$ViewDefinitionRecord() {
        return Integer.valueOf(this.sxaxis4Data);
    }
}
