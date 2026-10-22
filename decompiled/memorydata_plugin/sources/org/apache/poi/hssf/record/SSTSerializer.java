package org.apache.poi.hssf.record;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.hssf.record.common.UnicodeString;
import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
import org.apache.poi.util.IntMapper;

/* JADX INFO: loaded from: classes7.dex */
final class SSTSerializer {
    private final int _numStrings;
    private final int _numUniqueStrings;
    private final int[] bucketAbsoluteOffsets;
    private final int[] bucketRelativeOffsets;
    private final IntMapper<UnicodeString> strings;

    public SSTSerializer(IntMapper<UnicodeString> r1, int r2, int r3) {
        this.strings = r1;
        this._numStrings = r2;
        this._numUniqueStrings = r3;
        int r4 = ExtSSTRecord.getNumberOfInfoRecsForStrings(r1.size());
        this.bucketAbsoluteOffsets = new int[r4];
        this.bucketRelativeOffsets = new int[r4];
    }

    private UnicodeString getUnicodeString(int r1) {
        return getUnicodeString(this.strings, r1);
    }

    private static UnicodeString getUnicodeString(IntMapper<UnicodeString> r1, int r2) {
        return (UnicodeString) ZeusTransformUtils.preCheckCast(r1.get(r2), UnicodeString.class, "com.obric.memorydata.plugin");
    }

    public int[] getBucketAbsoluteOffsets() {
        return this.bucketAbsoluteOffsets;
    }

    public int[] getBucketRelativeOffsets() {
        return this.bucketRelativeOffsets;
    }

    public void serialize(ContinuableRecordOutput r5) {
        r5.writeInt(this._numStrings);
        r5.writeInt(this._numUniqueStrings);
        int r0 = 0;
    L4:
        if (r0 >= this.strings.size()) goto L11;
        if ((r0 % 8) != 0) goto L10;
        int r1 = r5.getTotalSize();
        int r2 = r0 / 8;
        if (r2 >= 128) goto L10;
        this.bucketAbsoluteOffsets[r2] = r1;
        this.bucketRelativeOffsets[r2] = r1;
    L10:
        getUnicodeString(r0).serialize(r5);
        r0 = r0 + 1;
        goto L4
    }
}
