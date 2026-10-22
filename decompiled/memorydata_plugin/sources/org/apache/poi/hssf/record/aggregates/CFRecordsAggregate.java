package org.apache.poi.hssf.record.aggregates;

import com.ss.bduploader.BDNetworkSpeedTest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.apache.logging.log4j.b;
import org.apache.logging.log4j.c;
import org.apache.logging.log4j.util.v;
import org.apache.poi.common.usermodel.GenericRecord;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.CFHeader12Record;
import org.apache.poi.hssf.record.CFHeaderBase;
import org.apache.poi.hssf.record.CFHeaderRecord;
import org.apache.poi.hssf.record.CFRule12Record;
import org.apache.poi.hssf.record.CFRuleBase;
import org.apache.poi.hssf.record.CFRuleRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.util.GenericRecordJsonWriter;
import org.apache.poi.util.GenericRecordUtil;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class CFRecordsAggregate extends RecordAggregate implements GenericRecord {
    private static final c LOG = null;
    private final CFHeaderBase header;
    private final List<CFRuleBase> rules;

    static {
        LOG = b.a(CFRecordsAggregate.class);
    }

    private CFRecordsAggregate(CFHeaderBase r4, CFRuleBase[] r5) {
        this.rules = new ArrayList();
        if (r4 == null) goto L19;
        if (r5 == null) goto L17;
        if (r5.length <= 3) goto L9;
        LOG.atWarn().a("Excel versions before 2007 require that No more than 3 rules may be specified, {} were found, this file will cause problems with old Excel versions", v.a(r5.length));
    L9:
        if (r5.length != r4.getNumberOfConditionalFormats()) goto L15;
        this.header = r4;
        int r6 = r5.length;
        int r0 = 0;
    L11:
        if (r0 >= r6) goto L13;
        CFRuleBase r1 = r5[r0];
        checkRuleType(r1);
        this.rules.add(r1);
        r0 = r0 + 1;
        goto L11
    L13:
        return;
    L15:
        throw new RecordFormatException("Mismatch number of rules");
    L17:
        throw new IllegalArgumentException("rules must not be null");
    L19:
        throw new IllegalArgumentException("header must not be null");
    }

    private void checkRuleIndex(int r4) {
        if (r4 < 0) goto L7;
        if (r4 >= this.rules.size()) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("Bad rule record index (" + r4 + ") nRules=" + this.rules.size());
    }

    private void checkRuleType(CFRuleBase r3) {
        if (ZeusTransformUtils.instanceOf(this.header, CFHeaderRecord.class) == false) goto L8;
        if (ZeusTransformUtils.instanceOf(r3, CFRuleRecord.class) == false) goto L8;
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(this.header, CFHeader12Record.class) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, CFRule12Record.class) == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("Header and Rule must both be CF or both be CF12, can't mix");
    }

    public static CFRecordsAggregate createCFAggregate(RecordStream r7) {
        Record r0 = r7.getNext();
        if (r0.getSid() != 432) goto L5;
    L9:
        CFHeaderBase r1 = (CFHeaderBase) ZeusTransformUtils.preCheckCast(r0, CFHeaderBase.class, "com.obric.memorydata.plugin");
        int r2 = r1.getNumberOfConditionalFormats();
        CFRuleBase[] r3 = new CFRuleBase[r2];
        int r4 = 0;
    L10:
        if (r4 >= r2) goto L13;
        r3[r4] = (CFRuleBase) ZeusTransformUtils.preCheckCast(r7.getNext(), CFRuleBase.class, "com.obric.memorydata.plugin");
        r4 = r4 + 1;
        goto L10
    L13:
        return new CFRecordsAggregate(r1, r3);
    L5:
        if (r0.getSid() == 2169) goto L9;
        throw new IllegalStateException("next record sid was " + r0.getSid() + " instead of " + BDNetworkSpeedTest.KeyIsIntelligentTestResult + " or 2169 as expected");
    }

    @Override // org.apache.poi.common.usermodel.GenericRecord
    public Map<String, Supplier<?>> getGenericProperties() {
        return GenericRecordUtil.getGenericProperties("header", new $$Lambda$anQ8Z7SJGHVfTIVsB0RsukRpHB4(this), "rules", new $$Lambda$CFRecordsAggregate$phWgcDvQfffBucvejUDNw9EIKoI(this));
    }

    public CFHeaderBase getHeader() {
        return this.header;
    }

    public int getNumberOfRules() {
        return this.rules.size();
    }

    public CFRuleBase getRule(int r2) {
        checkRuleIndex(r2);
        return (CFRuleBase) ZeusTransformUtils.preCheckCast(this.rules.get(r2), CFRuleBase.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ Object lambda$getGenericProperties$1$CFRecordsAggregate() {
        return this.rules;
    }

    public String toString() {
        return GenericRecordJsonWriter.marshal(this);
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r4) {
        RecordAggregate.RecordVisitor r5 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r4, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        r5.visitRecord(this.header);
        Iterator<CFRuleBase> r3 = this.rules.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r5.visitRecord((CFRuleBase) ZeusTransformUtils.preCheckCast(r3.next(), CFRuleBase.class, "com.obric.memorydata.plugin"));
        goto L4
    }
}
