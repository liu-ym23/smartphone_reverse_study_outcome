package org.apache.poi.hssf.record.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.LittleEndianInput;

/* JADX INFO: loaded from: classes7.dex */
public class PhRun {
    final int phoneticTextFirstCharacterOffset;
    final int realTextFirstCharacterOffset;
    final int realTextLength;

    public PhRun(PhRun r2) {
        this.phoneticTextFirstCharacterOffset = r2.phoneticTextFirstCharacterOffset;
        this.realTextFirstCharacterOffset = r2.realTextFirstCharacterOffset;
        this.realTextLength = r2.realTextLength;
    }

    PhRun(LittleEndianInput r3) {
        LittleEndianInput r4 = (LittleEndianInput) ZeusTransformUtils.wrapperContextForParams(r3, LittleEndianInput.class, "com.obric.memorydata.plugin");
        this.phoneticTextFirstCharacterOffset = r4.readUShort();
        this.realTextFirstCharacterOffset = r4.readUShort();
        this.realTextLength = r4.readUShort();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L19:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L19;
        PhRun r6 = (PhRun) ZeusTransformUtils.preCheckCast(r5, PhRun.class, "com.obric.memorydata.plugin");
        if (this.phoneticTextFirstCharacterOffset != r6.phoneticTextFirstCharacterOffset) goto L18;
        if (this.realTextFirstCharacterOffset != r6.realTextFirstCharacterOffset) goto L18;
        if (this.realTextLength != r6.realTextLength) goto L18;
        return true;
    L18:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.phoneticTextFirstCharacterOffset), Integer.valueOf(this.realTextFirstCharacterOffset), Integer.valueOf(this.realTextLength)});
    }

    void serialize(ContinuableRecordOutput r2) {
        r2.writeContinueIfRequired(6);
        r2.writeShort(this.phoneticTextFirstCharacterOffset);
        r2.writeShort(this.realTextFirstCharacterOffset);
        r2.writeShort(this.realTextLength);
    }
}
