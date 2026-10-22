package org.apache.poi.xssf.binary;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum XSSFBRecordType extends Enum<XSSFBRecordType> {
    private static final /* synthetic */ XSSFBRecordType[] $VALUES = null;
    public static final XSSFBRecordType BrtAbsPath15 = null;
    public static final XSSFBRecordType BrtBeginCellStyleXFS = null;
    public static final XSSFBRecordType BrtBeginCellXFs = null;
    public static final XSSFBRecordType BrtBeginComment = null;
    public static final XSSFBRecordType BrtBeginCommentAuthors = null;
    public static final XSSFBRecordType BrtBeginFmts = null;
    public static final XSSFBRecordType BrtBeginHeaderFooter = null;
    public static final XSSFBRecordType BrtBeginSheet = null;
    public static final XSSFBRecordType BrtBeginSheetData = null;
    public static final XSSFBRecordType BrtBeginSst = null;
    public static final XSSFBRecordType BrtBundleSh = null;
    public static final XSSFBRecordType BrtCellBlank = null;
    public static final XSSFBRecordType BrtCellBool = null;
    public static final XSSFBRecordType BrtCellError = null;
    public static final XSSFBRecordType BrtCellIsst = null;
    public static final XSSFBRecordType BrtCellRString = null;
    public static final XSSFBRecordType BrtCellReal = null;
    public static final XSSFBRecordType BrtCellRk = null;
    public static final XSSFBRecordType BrtCellSt = null;
    public static final XSSFBRecordType BrtColInfo = null;
    public static final XSSFBRecordType BrtCommentAuthor = null;
    public static final XSSFBRecordType BrtCommentText = null;
    public static final XSSFBRecordType BrtEndCellStyleXFS = null;
    public static final XSSFBRecordType BrtEndCellXFs = null;
    public static final XSSFBRecordType BrtEndComment = null;
    public static final XSSFBRecordType BrtEndCommentAuthors = null;
    public static final XSSFBRecordType BrtEndFmts = null;
    public static final XSSFBRecordType BrtEndSheetData = null;
    public static final XSSFBRecordType BrtEndSst = null;
    public static final XSSFBRecordType BrtFmlaBool = null;
    public static final XSSFBRecordType BrtFmlaError = null;
    public static final XSSFBRecordType BrtFmlaNum = null;
    public static final XSSFBRecordType BrtFmlaString = null;
    public static final XSSFBRecordType BrtFmt = null;
    public static final XSSFBRecordType BrtHLink = null;
    public static final XSSFBRecordType BrtRowHdr = null;
    public static final XSSFBRecordType BrtSstItem = null;
    public static final XSSFBRecordType BrtWsDim = null;
    public static final XSSFBRecordType BrtWsProp = null;
    public static final XSSFBRecordType BrtXf = null;
    private static final Map<Integer, XSSFBRecordType> TYPE_MAP = null;
    public static final XSSFBRecordType Unimplemented = null;
    private final int id;

    static {
        XSSFBRecordType r0 = new XSSFBRecordType("BrtCellBlank", 0, 1);
        BrtCellBlank = r0;
        XSSFBRecordType r1 = new XSSFBRecordType("BrtCellRk", 1, 2);
        BrtCellRk = r1;
        XSSFBRecordType r4 = new XSSFBRecordType("BrtCellError", 2, 3);
        BrtCellError = r4;
        XSSFBRecordType r6 = new XSSFBRecordType("BrtCellBool", 3, 4);
        BrtCellBool = r6;
        XSSFBRecordType r8 = new XSSFBRecordType("BrtCellReal", 4, 5);
        BrtCellReal = r8;
        XSSFBRecordType r10 = new XSSFBRecordType("BrtCellSt", 5, 6);
        BrtCellSt = r10;
        XSSFBRecordType r12 = new XSSFBRecordType("BrtCellIsst", 6, 7);
        BrtCellIsst = r12;
        XSSFBRecordType r14 = new XSSFBRecordType("BrtFmlaString", 7, 8);
        BrtFmlaString = r14;
        XSSFBRecordType r13 = new XSSFBRecordType("BrtFmlaNum", 8, 9);
        BrtFmlaNum = r13;
        XSSFBRecordType r15 = new XSSFBRecordType("BrtFmlaBool", 9, 10);
        BrtFmlaBool = r15;
        XSSFBRecordType r11 = new XSSFBRecordType("BrtFmlaError", 10, 11);
        BrtFmlaError = r11;
        XSSFBRecordType r9 = new XSSFBRecordType("BrtRowHdr", 11, 0);
        BrtRowHdr = r9;
        XSSFBRecordType r7 = new XSSFBRecordType("BrtCellRString", 12, 62);
        BrtCellRString = r7;
        XSSFBRecordType r2 = new XSSFBRecordType("BrtBeginSheet", 13, 129);
        BrtBeginSheet = r2;
        XSSFBRecordType r5 = new XSSFBRecordType("BrtWsProp", 14, 147);
        BrtWsProp = r5;
        XSSFBRecordType r3 = new XSSFBRecordType("BrtWsDim", 15, 148);
        BrtWsDim = r3;
        XSSFBRecordType r16 = new XSSFBRecordType("BrtColInfo", 16, 60);
        BrtColInfo = r16;
        XSSFBRecordType r17 = new XSSFBRecordType("BrtBeginSheetData", 17, 145);
        BrtBeginSheetData = r17;
        XSSFBRecordType r18 = new XSSFBRecordType("BrtEndSheetData", 18, 146);
        BrtEndSheetData = r18;
        XSSFBRecordType r19 = new XSSFBRecordType("BrtHLink", 19, 494);
        BrtHLink = r19;
        XSSFBRecordType r20 = new XSSFBRecordType("BrtBeginHeaderFooter", 20, 479);
        BrtBeginHeaderFooter = r20;
        XSSFBRecordType r21 = new XSSFBRecordType("BrtBeginCommentAuthors", 21, 630);
        BrtBeginCommentAuthors = r21;
        XSSFBRecordType r22 = new XSSFBRecordType("BrtEndCommentAuthors", 22, 631);
        BrtEndCommentAuthors = r22;
        XSSFBRecordType r23 = new XSSFBRecordType("BrtCommentAuthor", 23, 632);
        BrtCommentAuthor = r23;
        XSSFBRecordType r24 = new XSSFBRecordType("BrtBeginComment", 24, 635);
        BrtBeginComment = r24;
        XSSFBRecordType r25 = new XSSFBRecordType("BrtCommentText", 25, 637);
        BrtCommentText = r25;
        XSSFBRecordType r26 = new XSSFBRecordType("BrtEndComment", 26, 636);
        BrtEndComment = r26;
        XSSFBRecordType r27 = new XSSFBRecordType("BrtXf", 27, 47);
        BrtXf = r27;
        XSSFBRecordType r28 = new XSSFBRecordType("BrtFmt", 28, 44);
        BrtFmt = r28;
        XSSFBRecordType r29 = new XSSFBRecordType("BrtBeginFmts", 29, 615);
        BrtBeginFmts = r29;
        XSSFBRecordType r30 = new XSSFBRecordType("BrtEndFmts", 30, 616);
        BrtEndFmts = r30;
        XSSFBRecordType r31 = new XSSFBRecordType("BrtBeginCellXFs", 31, 617);
        BrtBeginCellXFs = r31;
        XSSFBRecordType r32 = new XSSFBRecordType("BrtEndCellXFs", 32, 618);
        BrtEndCellXFs = r32;
        XSSFBRecordType r33 = new XSSFBRecordType("BrtBeginCellStyleXFS", 33, 626);
        BrtBeginCellStyleXFS = r33;
        XSSFBRecordType r34 = new XSSFBRecordType("BrtEndCellStyleXFS", 34, 627);
        BrtEndCellStyleXFS = r34;
        XSSFBRecordType r35 = new XSSFBRecordType("BrtSstItem", 35, 19);
        BrtSstItem = r35;
        XSSFBRecordType r36 = new XSSFBRecordType("BrtBeginSst", 36, 159);
        BrtBeginSst = r36;
        XSSFBRecordType r37 = new XSSFBRecordType("BrtEndSst", 37, 160);
        BrtEndSst = r37;
        XSSFBRecordType r38 = new XSSFBRecordType("BrtBundleSh", 38, 156);
        BrtBundleSh = r38;
        XSSFBRecordType r39 = new XSSFBRecordType("BrtAbsPath15", 39, 2071);
        BrtAbsPath15 = r39;
        XSSFBRecordType r40 = new XSSFBRecordType("Unimplemented", 40, -1);
        Unimplemented = r40;
        $VALUES = new XSSFBRecordType[]{r0, r1, r4, r6, r8, r10, r12, r14, r13, r15, r11, r9, r7, r2, r5, r3, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40};
        TYPE_MAP = new HashMap();
        XSSFBRecordType[] r41 = values();
        int r42 = r41.length;
        int r43 = 0;
    L3:
        if (r43 >= r42) goto L5;
        XSSFBRecordType r44 = r41[r43];
        TYPE_MAP.put(Integer.valueOf(r44.getId()), r44);
        r43 = r43 + 1;
        goto L3
    }

    private XSSFBRecordType(String r1, int r2, int r3) {
        super(r1, r2);
        this.id = r3;
    }

    public static XSSFBRecordType lookup(int r2) {
        XSSFBRecordType r3 = (XSSFBRecordType) ZeusTransformUtils.preCheckCast(TYPE_MAP.get(Integer.valueOf(r2)), XSSFBRecordType.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L5;
        return r3;
    L5:
        return Unimplemented;
    }

    public static XSSFBRecordType valueOf(String r2) {
        return (XSSFBRecordType) ZeusTransformUtils.preCheckCast(Enum.valueOf(XSSFBRecordType.class, r2), XSSFBRecordType.class, "com.obric.memorydata.plugin");
    }

    public static XSSFBRecordType[] values() {
        return (XSSFBRecordType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), XSSFBRecordType[].class, "com.obric.memorydata.plugin");
    }

    public int getId() {
        return this.id;
    }
}
