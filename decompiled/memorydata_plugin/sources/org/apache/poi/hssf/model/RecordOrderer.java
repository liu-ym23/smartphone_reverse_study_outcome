package org.apache.poi.hssf.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import org.apache.poi.hssf.record.DimensionsRecord;
import org.apache.poi.hssf.record.EOFRecord;
import org.apache.poi.hssf.record.GutsRecord;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordBase;
import org.apache.poi.hssf.record.aggregates.ColumnInfoRecordsAggregate;
import org.apache.poi.hssf.record.aggregates.ConditionalFormattingTable;
import org.apache.poi.hssf.record.aggregates.DataValidityTable;
import org.apache.poi.hssf.record.aggregates.MergedCellsTable;
import org.apache.poi.hssf.record.aggregates.PageSettingsBlock;
import org.apache.poi.hssf.record.aggregates.WorksheetProtectionBlock;

/* JADX INFO: loaded from: classes7.dex */
final class RecordOrderer {
    public static void addNewSheetRecord(List<RecordBase> r2, RecordBase r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        r4.add(findSheetInsertPos(r4, r3.getClass()), r3);
    }

    private static int findDataValidationTableInsertPos(List<RecordBase> r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        int r0 = r6.size() - 1;
        if (ZeusTransformUtils.instanceOf(r6.get(r0), EOFRecord.class) == false) goto L20;
    L4:
        if (r0 <= 0) goto L17;
        r0 = r0 - 1;
        RecordBase r2 = (RecordBase) ZeusTransformUtils.preCheckCast(r6.get(r0), RecordBase.class, "com.obric.memorydata.plugin");
        if (isDVTPriorRecord(r2) == true) goto L7;
        Record r3 = (Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin");
        if (isDVTSubsequentRecord(r3.getSid()) == true) goto L4;
        throw new IllegalStateException("Unexpected (" + r3.getClass().getName() + ") while looking for DV Table insert pos");
    L7:
        int r1 = r0 + 1;
        Record r7 = (Record) ZeusTransformUtils.preCheckCast(r6.get(r1), Record.class, "com.obric.memorydata.plugin");
        if (isDVTSubsequentRecord(r7.getSid()) == false) goto L11;
        return r1;
    L11:
        throw new IllegalStateException("Unexpected (" + r7.getClass().getName() + ") found after (" + r2.getClass().getName() + ")");
    L17:
        return 0;
    L20:
        throw new IllegalStateException("Last sheet record should be EOFRecord");
    }

    private static int findInsertPosForNewCondFormatTable(List<RecordBase> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size() - 2;
    L3:
        if (r0 < 0) goto L29;
        Object r2 = r5.get(r0);
        if (ZeusTransformUtils.instanceOf(r2, MergedCellsTable.class) == true) goto L7;
        if (ZeusTransformUtils.instanceOf(r2, DataValidityTable.class) == true) goto L25;
        short r3 = ((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin")).getSid();
        if (r3 == 29) goto L27;
        if (r3 == 65) goto L27;
        if (r3 == 153) goto L27;
        if (r3 == 160) goto L27;
        if (r3 == 239) goto L27;
        if (r3 == 351) goto L27;
        if (r3 != 574) goto L25;
    L27:
        return r0 + 1;
    L25:
        r0 = r0 - 1;
        goto L3
    L7:
        return r0 + 1;
    L29:
        throw new IllegalArgumentException("Did not find Window2 record");
    }

    private static int findInsertPosForNewMergedRecordTable(List<RecordBase> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size() - 2;
    L3:
        if (r0 < 0) goto L21;
        Object r2 = r5.get(r0);
        if (ZeusTransformUtils.instanceOf(r2, Record.class) == false) goto L17;
        short r3 = ((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin")).getSid();
        if (r3 == 29) goto L19;
        if (r3 == 65) goto L19;
        if (r3 == 153) goto L19;
        if (r3 == 160) goto L19;
        if (r3 != 574) goto L17;
    L19:
        return r0 + 1;
    L17:
        r0 = r0 - 1;
        goto L3
    L21:
        throw new IllegalArgumentException("Did not find Window2 record");
    }

    private static int findSheetInsertPos(List<RecordBase> r2, Class<? extends RecordBase> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if (r3 != DataValidityTable.class) goto L7;
        return findDataValidationTableInsertPos(r4);
    L7:
        if (r3 != MergedCellsTable.class) goto L11;
        return findInsertPosForNewMergedRecordTable(r4);
    L11:
        if (r3 != ConditionalFormattingTable.class) goto L15;
        return findInsertPosForNewCondFormatTable(r4);
    L15:
        if (r3 != GutsRecord.class) goto L19;
        return getGutsRecordInsertPos(r4);
    L19:
        if (r3 != PageSettingsBlock.class) goto L23;
        return getPageBreakRecordInsertPos(r4);
    L23:
        if (r3 != WorksheetProtectionBlock.class) goto L27;
        return getWorksheetProtectionBlockInsertPos(r4);
    L27:
        throw new IllegalArgumentException("Unexpected record class (" + r3.getName() + ")");
    }

    private static int getDimensionsIndex(List<RecordBase> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        if (ZeusTransformUtils.instanceOf(r5.get(r1), DimensionsRecord.class) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r1;
    L9:
        throw new IllegalArgumentException("DimensionsRecord not found");
    }

    private static int getGutsRecordInsertPos(List<RecordBase> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        int r0 = getDimensionsIndex(r5) - 1;
    L3:
        if (r0 <= 0) goto L9;
        r0 = r0 - 1;
        if (isGutsPriorRecord((RecordBase) ZeusTransformUtils.preCheckCast(r5.get(r0), RecordBase.class, "com.obric.memorydata.plugin")) == false) goto L3;
        return r0 + 1;
    L9:
        throw new IllegalArgumentException("Did not find insert point for GUTS");
    }

    private static int getPageBreakRecordInsertPos(List<RecordBase> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        int r0 = getDimensionsIndex(r3) - 1;
    L3:
        if (r0 <= 0) goto L9;
        r0 = r0 - 1;
        if (isPageBreakPriorRecord(r3.get(r0)) == false) goto L3;
        return r0 + 1;
    L9:
        throw new IllegalArgumentException("Did not find insert point for GUTS");
    }

    private static int getWorksheetProtectionBlockInsertPos(List<RecordBase> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        int r0 = getDimensionsIndex(r3);
    L3:
        if (r0 <= 0) goto L9;
        r0 = r0 - 1;
        if (isProtectionSubsequentRecord(r3.get(r0)) == true) goto L3;
        return r0 + 1;
    L9:
        throw new IllegalStateException("did not find insert pos for protection block");
    }

    private static boolean isDVTPriorRecord(RecordBase r3) {
        if (ZeusTransformUtils.instanceOf(r3, MergedCellsTable.class) == false) goto L5;
    L29:
        return true;
    L5:
        if (ZeusTransformUtils.instanceOf(r3, ConditionalFormattingTable.class) == true) goto L29;
        short r4 = ((Record) ZeusTransformUtils.preCheckCast(r3, Record.class, "com.obric.memorydata.plugin")).getSid();
        if (r4 == 29) goto L29;
        if (r4 == 65) goto L29;
        if (r4 == 153) goto L29;
        if (r4 == 160) goto L29;
        if (r4 == 239) goto L29;
        if (r4 == 351) goto L29;
        if (r4 == 440) goto L29;
        if (r4 == 442) goto L29;
        if (r4 == 574) goto L29;
        if (r4 == 2048) goto L29;
        return false;
    }

    private static boolean isDVTSubsequentRecord(short r1) {
        if (r1 != 10) goto L5;
        return true;
    L5:
        if (r1 != 2146) goto L7;
        return true;
    L7:
        if (r1 != 2248) goto L9;
        return true;
    L9:
        if (r1 != 2151) goto L11;
        return true;
    L11:
        if (r1 == 2152) goto L19;
        return false;
    L19:
        return true;
    }

    public static boolean isEndOfRowBlock(int r2) {
        if (r2 == 10) goto L28;
        if (r2 != 61) goto L7;
    L26:
        return true;
    L7:
        if (r2 == 93) goto L26;
        if (r2 == 125) goto L26;
        if (r2 == 128) goto L26;
        if (r2 == 176) goto L26;
        if (r2 == 434) goto L26;
        if (r2 == 438) goto L26;
        if (r2 == 574) goto L26;
        if (r2 == 236) goto L26;
        if (r2 == 237) goto L26;
        return PageSettingsBlock.isComponentRecord(r2);
    L28:
        throw new IllegalArgumentException("Found EOFRecord before WindowTwoRecord was encountered");
    }

    private static boolean isGutsPriorRecord(RecordBase r2) {
        if (ZeusTransformUtils.instanceOf(r2, Record.class) == false) goto L24;
        short r3 = ((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin")).getSid();
        if (r3 != 34) goto L7;
        return true;
    L7:
        if (r3 != 130) goto L9;
        return true;
    L9:
        if (r3 != 523) goto L11;
        return true;
    L11:
        if (r3 != 2057) goto L13;
        return true;
    L13:
        if (r3 != 42) goto L15;
        return true;
    L15:
        if (r3 != 43) goto L17;
        return true;
    L17:
        if (r3 != 94) goto L19;
        return true;
    L19:
        if (r3 == 95) goto L32;
        switch(r3) {
            case 12: goto L33;
            case 13: goto L33;
            case 14: goto L33;
            case 15: goto L33;
            case 16: goto L33;
            case 17: goto L33;
            default: goto L34;
        };
    L33:
        return true;
    L34:
        return false;
    L32:
        return true;
    L24:
        return false;
    }

    private static boolean isPageBreakPriorRecord(Object r2) {
        if (ZeusTransformUtils.instanceOf(r2, Record.class) == false) goto L28;
        short r3 = ((Record) ZeusTransformUtils.preCheckCast(r2, Record.class, "com.obric.memorydata.plugin")).getSid();
        if (r3 != 34) goto L7;
        return true;
    L7:
        if (r3 != 523) goto L9;
        return true;
    L9:
        if (r3 != 549) goto L11;
        return true;
    L11:
        if (r3 != 2057) goto L13;
        return true;
    L13:
        if (r3 != 42) goto L15;
        return true;
    L15:
        if (r3 != 43) goto L17;
        return true;
    L17:
        if (r3 != 94) goto L19;
        return true;
    L19:
        if (r3 != 95) goto L21;
        return true;
    L21:
        if (r3 != 129) goto L23;
        return true;
    L23:
        if (r3 == 130) goto L38;
        switch(r3) {
            case 12: goto L39;
            case 13: goto L39;
            case 14: goto L39;
            case 15: goto L39;
            case 16: goto L39;
            case 17: goto L39;
            default: goto L40;
        };
    L39:
        return true;
    L40:
        return false;
    L38:
        return true;
    L28:
        return false;
    }

    private static boolean isProtectionSubsequentRecord(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, ColumnInfoRecordsAggregate.class) == false) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, Record.class) == false) goto L13;
        short r4 = ((Record) ZeusTransformUtils.preCheckCast(r3, Record.class, "com.obric.memorydata.plugin")).getSid();
        if (r4 != 85) goto L10;
    L12:
        return true;
    L10:
        if (r4 == 144) goto L12;
        return false;
    L13:
        return false;
    }

    public static boolean isRowBlockRecord(int r1) {
        if (r1 != 6) goto L5;
        return true;
    L5:
        if (r1 != 253) goto L7;
        return true;
    L7:
        if (r1 != 513) goto L9;
        return true;
    L9:
        if (r1 != 520) goto L11;
        return true;
    L11:
        if (r1 != 545) goto L13;
        return true;
    L13:
        if (r1 != 566) goto L15;
        return true;
    L15:
        if (r1 != 638) goto L17;
        return true;
    L17:
        if (r1 == 1212) goto L29;
        switch(r1) {
            case 515: goto L30;
            case 516: goto L30;
            case 517: goto L30;
            default: goto L19;
        };
    L19:
        return false;
    L30:
        return true;
    L29:
        return true;
    }
}
