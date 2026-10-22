package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.apache.poi.ss.util.CellRangeAddressBase;
import org.apache.poi.ss.util.CellReference;

/* JADX INFO: loaded from: classes7.dex */
public enum TableStyleType extends Enum<TableStyleType> {
    private static final /* synthetic */ TableStyleType[] $VALUES = null;
    public static final TableStyleType blankRow = null;
    public static final TableStyleType firstColumn = null;
    public static final TableStyleType firstColumnStripe = null;
    public static final TableStyleType firstColumnSubheading = null;
    public static final TableStyleType firstHeaderCell = null;
    public static final TableStyleType firstRowStripe = null;
    public static final TableStyleType firstRowSubheading = null;
    public static final TableStyleType firstSubtotalColumn = null;
    public static final TableStyleType firstSubtotalRow = null;
    public static final TableStyleType firstTotalCell = null;
    public static final TableStyleType headerRow = null;
    public static final TableStyleType lastColumn = null;
    public static final TableStyleType lastHeaderCell = null;
    public static final TableStyleType lastTotalCell = null;
    public static final TableStyleType pageFieldLabels = null;
    public static final TableStyleType pageFieldValues = null;
    public static final TableStyleType secondColumnStripe = null;
    public static final TableStyleType secondColumnSubheading = null;
    public static final TableStyleType secondRowStripe = null;
    public static final TableStyleType secondRowSubheading = null;
    public static final TableStyleType secondSubtotalColumn = null;
    public static final TableStyleType secondSubtotalRow = null;
    public static final TableStyleType thirdColumnSubheading = null;
    public static final TableStyleType thirdRowSubheading = null;
    public static final TableStyleType thirdSubtotalColumn = null;
    public static final TableStyleType thirdSubtotalRow = null;
    public static final TableStyleType totalRow = null;
    public static final TableStyleType wholeTable = null;

    static {
        final String r1 = "wholeTable";
        final int r2 = 0;
        TableStyleType r0 = new AnonymousClass1(r1, r2);
        wholeTable = r0;
        TableStyleType r3 = new TableStyleType("pageFieldLabels", 1);
        pageFieldLabels = r3;
        TableStyleType r4 = new TableStyleType("pageFieldValues", 2);
        pageFieldValues = r4;
        final String r7 = "firstColumnStripe";
        final int r8 = 3;
        TableStyleType r5 = new AnonymousClass2(r7, r8);
        firstColumnStripe = r5;
        final String r9 = "secondColumnStripe";
        final int r10 = 4;
        TableStyleType r11 = new AnonymousClass3(r9, r10);
        secondColumnStripe = r11;
        final String r12 = "firstRowStripe";
        final int r13 = 5;
        TableStyleType r14 = new AnonymousClass4(r12, r13);
        firstRowStripe = r14;
        final String r15 = "secondRowStripe";
        final int r16 = 6;
        TableStyleType r17 = new AnonymousClass5(r15, r16);
        secondRowStripe = r17;
        final String r18 = "lastColumn";
        final int r19 = 7;
        TableStyleType r110 = new AnonymousClass6(r18, r19);
        lastColumn = r110;
        final String r111 = "firstColumn";
        final int r112 = 8;
        TableStyleType r113 = new AnonymousClass7(r111, r112);
        firstColumn = r113;
        final String r114 = "headerRow";
        final int r115 = 9;
        TableStyleType r116 = new AnonymousClass8(r114, r115);
        headerRow = r116;
        final String r117 = "totalRow";
        final int r20 = 10;
        TableStyleType r118 = new AnonymousClass9(r117, r20);
        totalRow = r118;
        final String r21 = "firstHeaderCell";
        final int r6 = 11;
        TableStyleType r119 = new AnonymousClass10(r21, r6);
        firstHeaderCell = r119;
        final String r22 = "lastHeaderCell";
        final int r23 = 12;
        TableStyleType r24 = new AnonymousClass11(r22, r23);
        lastHeaderCell = r24;
        final String r25 = "firstTotalCell";
        final int r26 = 13;
        TableStyleType r27 = new AnonymousClass12(r25, r26);
        firstTotalCell = r27;
        final String r28 = "lastTotalCell";
        final int r29 = 14;
        TableStyleType r30 = new AnonymousClass13(r28, r29);
        lastTotalCell = r30;
        TableStyleType r31 = new TableStyleType("firstSubtotalColumn", 15);
        firstSubtotalColumn = r31;
        TableStyleType r32 = new TableStyleType("secondSubtotalColumn", 16);
        secondSubtotalColumn = r32;
        TableStyleType r33 = new TableStyleType("thirdSubtotalColumn", 17);
        thirdSubtotalColumn = r33;
        TableStyleType r34 = new TableStyleType("blankRow", 18);
        blankRow = r34;
        TableStyleType r35 = new TableStyleType("firstSubtotalRow", 19);
        firstSubtotalRow = r35;
        TableStyleType r36 = new TableStyleType("secondSubtotalRow", 20);
        secondSubtotalRow = r36;
        TableStyleType r37 = new TableStyleType("thirdSubtotalRow", 21);
        thirdSubtotalRow = r37;
        TableStyleType r38 = new TableStyleType("firstColumnSubheading", 22);
        firstColumnSubheading = r38;
        TableStyleType r39 = new TableStyleType("secondColumnSubheading", 23);
        secondColumnSubheading = r39;
        TableStyleType r40 = new TableStyleType("thirdColumnSubheading", 24);
        thirdColumnSubheading = r40;
        TableStyleType r41 = new TableStyleType("firstRowSubheading", 25);
        firstRowSubheading = r41;
        TableStyleType r42 = new TableStyleType("secondRowSubheading", 26);
        secondRowSubheading = r42;
        TableStyleType r43 = new TableStyleType("thirdRowSubheading", 27);
        thirdRowSubheading = r43;
        $VALUES = new TableStyleType[]{r0, r3, r4, r5, r11, r14, r17, r110, r113, r116, r118, r119, r24, r27, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43};
    }

    private TableStyleType(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ TableStyleType(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static TableStyleType valueOf(String r2) {
        return (TableStyleType) ZeusTransformUtils.preCheckCast(Enum.valueOf(TableStyleType.class, r2), TableStyleType.class, "com.obric.memorydata.plugin");
    }

    public static TableStyleType[] values() {
        return (TableStyleType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TableStyleType[].class, "com.obric.memorydata.plugin");
    }

    public CellRangeAddressBase appliesTo(Table r8, Cell r9) {
        Table r10 = (Table) ZeusTransformUtils.wrapperContextForParams(r8, Table.class, "com.obric.memorydata.plugin");
        Cell r11 = (Cell) ZeusTransformUtils.wrapperContextForParams(r9, Cell.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L7;
        return null;
    L7:
        return appliesTo(r10, new CellReference(r11.getSheet().getSheetName(), r11.getRowIndex(), r11.getColumnIndex(), true, true));
    }

    public CellRangeAddressBase appliesTo(Table r4, CellReference r5) {
        Table r6 = (Table) ZeusTransformUtils.wrapperContextForParams(r4, Table.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L17;
        if (r5 == null) goto L17;
        if (r5.getSheetName().equals(r6.getSheetName()) == true) goto L10;
        return null;
    L10:
        if (r6.contains(r5) == true) goto L12;
        return null;
    L12:
        CellRangeAddressBase r3 = getRange(r6, r5);
        if (r3 == null) goto L17;
        if (r3.isInRange(r5.getRow(), r5.getCol()) == false) goto L17;
        return r3;
    L17:
        return null;
    }

    public final CellRangeAddressBase getRange(Table r8, Cell r9) {
        Table r10 = (Table) ZeusTransformUtils.wrapperContextForParams(r8, Table.class, "com.obric.memorydata.plugin");
        Cell r11 = (Cell) ZeusTransformUtils.wrapperContextForParams(r9, Cell.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L7;
        return null;
    L7:
        return getRange(r10, new CellReference(r11.getSheet().getSheetName(), r11.getRowIndex(), r11.getColumnIndex(), true, true));
    }

    public CellRangeAddressBase getRange(Table r1, CellReference r2) {
        Table r0 = (Table) ZeusTransformUtils.wrapperContextForParams(r1, Table.class, "com.obric.memorydata.plugin");
        return null;
    }
}
