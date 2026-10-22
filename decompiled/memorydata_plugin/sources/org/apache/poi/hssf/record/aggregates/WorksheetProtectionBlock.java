package org.apache.poi.hssf.record.aggregates;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.record.ObjectProtectRecord;
import org.apache.poi.hssf.record.PasswordRecord;
import org.apache.poi.hssf.record.ProtectRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.ScenarioProtectRecord;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class WorksheetProtectionBlock extends RecordAggregate {
    private ObjectProtectRecord _objectProtectRecord;
    private PasswordRecord _passwordRecord;
    private ProtectRecord _protectRecord;
    private ScenarioProtectRecord _scenarioProtectRecord;

    public WorksheetProtectionBlock() {
    }

    private void checkNotPresent(Record r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        throw new RecordFormatException("Duplicate PageSettingsBlock record (sid=0x" + Integer.toHexString(r3.getSid()) + ")");
    }

    public static boolean isComponentRecord(int r1) {
        if (r1 != 18) goto L5;
        return true;
    L5:
        if (r1 != 19) goto L7;
        return true;
    L7:
        if (r1 != 99) goto L9;
        return true;
    L9:
        if (r1 == 221) goto L16;
        return false;
    L16:
        return true;
    }

    private boolean readARecord(RecordStream r4) {
        int r0 = r4.peekNextSid();
        if (r0 != 18) goto L5;
        checkNotPresent(this._protectRecord);
        this._protectRecord = (ProtectRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), ProtectRecord.class, "com.obric.memorydata.plugin");
        return true;
    L5:
        if (r0 != 19) goto L7;
        checkNotPresent(this._passwordRecord);
        this._passwordRecord = (PasswordRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), PasswordRecord.class, "com.obric.memorydata.plugin");
        return true;
    L7:
        if (r0 != 99) goto L9;
        checkNotPresent(this._objectProtectRecord);
        this._objectProtectRecord = (ObjectProtectRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), ObjectProtectRecord.class, "com.obric.memorydata.plugin");
        return true;
    L9:
        if (r0 == 221) goto L12;
        return false;
    L12:
        checkNotPresent(this._scenarioProtectRecord);
        this._scenarioProtectRecord = (ScenarioProtectRecord) ZeusTransformUtils.preCheckCast(r4.getNext(), ScenarioProtectRecord.class, "com.obric.memorydata.plugin");
        return true;
    }

    private static void visitIfPresent(Record r2, RecordAggregate.RecordVisitor r3) {
        RecordAggregate.RecordVisitor r4 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L6;
        r4.visitRecord(r2);
        return;
    }

    public void addRecords(RecordStream r2) {
    L3:
        if (readARecord(r2) == true) goto L3;
    }

    @Override // org.apache.poi.hssf.record.aggregates.RecordAggregate
    public void visitContainedRecords(RecordAggregate.RecordVisitor r3) {
        RecordAggregate.RecordVisitor r4 = (RecordAggregate.RecordVisitor) ZeusTransformUtils.wrapperContextForParams(r3, RecordAggregate.RecordVisitor.class, "com.obric.memorydata.plugin");
        visitIfPresent(this._protectRecord, r4);
        visitIfPresent(this._objectProtectRecord, r4);
        visitIfPresent(this._scenarioProtectRecord, r4);
        visitIfPresent(this._passwordRecord, r4);
    }
}
