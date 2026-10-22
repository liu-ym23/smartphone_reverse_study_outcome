package org.apache.poi.hssf.record;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.util.IOUtils;
import org.apache.poi.util.RecordFormatException;

/* JADX INFO: loaded from: classes7.dex */
public final class RecordFactory {
    private static int MAX_NUMBER_OF_RECORDS = 5000000;

    static {
    }

    public static BlankRecord[] convertBlankRecords(MulBlankRecord r4) {
        BlankRecord[] r0 = new BlankRecord[r4.getNumColumns()];
        int r1 = 0;
    L4:
        if (r1 >= r4.getNumColumns()) goto L6;
        BlankRecord r2 = new BlankRecord();
        r2.setColumn((short) (r4.getFirstColumn() + r1));
        r2.setRow(r4.getRow());
        r2.setXFIndex(r4.getXFAt(r1));
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static NumberRecord[] convertRKRecords(MulRKRecord r6) {
        int r0 = r6.getNumColumns();
        if (r0 < 0) goto L9;
        NumberRecord[] r1 = new NumberRecord[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L7;
        NumberRecord r3 = new NumberRecord();
        r3.setColumn((short) (r6.getFirstColumn() + r2));
        r3.setRow(r6.getRow());
        r3.setXFIndex(r6.getXFAt(r2));
        r3.setValue(r6.getRKNumberAt(r2));
        r1[r2] = r3;
        r2 = r2 + 1;
        goto L5
    L7:
        return r1;
    L9:
        throw new RecordFormatException("Cannot create RKRecords with negative number of columns: " + r0);
    }

    public static NumberRecord convertToNumberRecord(RKRecord r3) {
        NumberRecord r0 = new NumberRecord();
        r0.setColumn(r3.getColumn());
        r0.setRow(r3.getRow());
        r0.setXFIndex(r3.getXFIndex());
        r0.setValue(r3.getRKNumber());
        return r0;
    }

    public static List<Record> createRecords(InputStream r4) {
        ArrayList r0 = new ArrayList(512);
        RecordFactoryInputStream r1 = new RecordFactoryInputStream(r4, true);
    L3:
        Record r5 = r1.nextRecord();
        if (r5 == null) goto L6;
        r0.add(r5);
        IOUtils.safelyAllocateCheck(r0.size(), MAX_NUMBER_OF_RECORDS);
        goto L3
    L6:
        return r0;
    }

    public static Record createSingleRecord(RecordInputStream r2) {
        HSSFRecordTypes r0 = HSSFRecordTypes.forSID(r2.getSid());
        if (r0.isParseable() == true) goto L6;
        r0 = HSSFRecordTypes.UNKNOWN;
    L6:
        return r0.recordConstructor.apply(r2);
    }

    public static short[] getAllKnownRecordSIDs() {
        int[] r0 = Arrays.stream(HSSFRecordTypes.values()).mapToInt($$Lambda$bRDQX8sFmnmZzmBpq1g74qe04.INSTANCE).toArray();
        short[] r1 = new short[r0.length];
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L6;
        r1[r2] = (short) r0[r2];
        r2 = r2 + 1;
        goto L4
    L6:
        return r1;
    }

    public static Class<? extends Record> getRecordClass(int r0) {
        return HSSFRecordTypes.forSID(r0).clazz;
    }
}
