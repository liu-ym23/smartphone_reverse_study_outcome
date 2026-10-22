package org.apache.poi.xslf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum SlideLayout extends Enum<SlideLayout> {
    private static final /* synthetic */ SlideLayout[] $VALUES = null;
    public static final SlideLayout BLANK = null;
    public static final SlideLayout CHART = null;
    public static final SlideLayout CHART_AND_TEXT = null;
    public static final SlideLayout CLIP_ART_AND_TEXT = null;
    public static final SlideLayout CLIP_ART_AND_VERT_TX = null;
    public static final SlideLayout CUST = null;
    public static final SlideLayout DGM = null;
    public static final SlideLayout FOUR_OBJ = null;
    public static final SlideLayout MEDIA_AND_TX = null;
    public static final SlideLayout OBJ_AND_TWO_OBJ = null;
    public static final SlideLayout OBJ_AND_TX = null;
    public static final SlideLayout OBJ_ONLY = null;
    public static final SlideLayout OBJ_OVER_TX = null;
    public static final SlideLayout OBJ_TX = null;
    public static final SlideLayout PIC_TX = null;
    public static final SlideLayout SECTION_HEADER = null;
    public static final SlideLayout TBL = null;
    public static final SlideLayout TEXT = null;
    public static final SlideLayout TEXT_AND_CHART = null;
    public static final SlideLayout TITLE = null;
    public static final SlideLayout TITLE_AND_CONTENT = null;
    public static final SlideLayout TITLE_ONLY = null;
    public static final SlideLayout TWO_COL_TX = null;
    public static final SlideLayout TWO_OBJ = null;
    public static final SlideLayout TWO_OBJ_AND_OBJ = null;
    public static final SlideLayout TWO_OBJ_AND_TX = null;
    public static final SlideLayout TWO_OBJ_OVER_TX = null;
    public static final SlideLayout TWO_TX_TWO_OBJ = null;
    public static final SlideLayout TX_AND_CLIP_ART = null;
    public static final SlideLayout TX_AND_MEDIA = null;
    public static final SlideLayout TX_AND_OBJ = null;
    public static final SlideLayout TX_AND_TWO_OBJ = null;
    public static final SlideLayout TX_OVER_OBJ = null;
    public static final SlideLayout VERT_TITLE_AND_TX = null;
    public static final SlideLayout VERT_TITLE_AND_TX_OVER_CHART = null;
    public static final SlideLayout VERT_TX = null;

    static {
        SlideLayout r0 = new SlideLayout("TITLE", 0);
        TITLE = r0;
        SlideLayout r1 = new SlideLayout("TEXT", 1);
        TEXT = r1;
        SlideLayout r3 = new SlideLayout("TWO_COL_TX", 2);
        TWO_COL_TX = r3;
        SlideLayout r5 = new SlideLayout("TBL", 3);
        TBL = r5;
        SlideLayout r7 = new SlideLayout("TEXT_AND_CHART", 4);
        TEXT_AND_CHART = r7;
        SlideLayout r9 = new SlideLayout("CHART_AND_TEXT", 5);
        CHART_AND_TEXT = r9;
        SlideLayout r11 = new SlideLayout("DGM", 6);
        DGM = r11;
        SlideLayout r13 = new SlideLayout("CHART", 7);
        CHART = r13;
        SlideLayout r15 = new SlideLayout("TX_AND_CLIP_ART", 8);
        TX_AND_CLIP_ART = r15;
        SlideLayout r14 = new SlideLayout("CLIP_ART_AND_TEXT", 9);
        CLIP_ART_AND_TEXT = r14;
        SlideLayout r12 = new SlideLayout("TITLE_ONLY", 10);
        TITLE_ONLY = r12;
        SlideLayout r10 = new SlideLayout("BLANK", 11);
        BLANK = r10;
        SlideLayout r8 = new SlideLayout("TX_AND_OBJ", 12);
        TX_AND_OBJ = r8;
        SlideLayout r6 = new SlideLayout("OBJ_AND_TX", 13);
        OBJ_AND_TX = r6;
        SlideLayout r4 = new SlideLayout("OBJ_ONLY", 14);
        OBJ_ONLY = r4;
        SlideLayout r2 = new SlideLayout("TITLE_AND_CONTENT", 15);
        TITLE_AND_CONTENT = r2;
        SlideLayout r16 = new SlideLayout("TX_AND_MEDIA", 16);
        TX_AND_MEDIA = r16;
        SlideLayout r17 = new SlideLayout("MEDIA_AND_TX", 17);
        MEDIA_AND_TX = r17;
        SlideLayout r18 = new SlideLayout("OBJ_OVER_TX", 18);
        OBJ_OVER_TX = r18;
        SlideLayout r19 = new SlideLayout("TX_OVER_OBJ", 19);
        TX_OVER_OBJ = r19;
        SlideLayout r20 = new SlideLayout("TX_AND_TWO_OBJ", 20);
        TX_AND_TWO_OBJ = r20;
        SlideLayout r21 = new SlideLayout("TWO_OBJ_AND_TX", 21);
        TWO_OBJ_AND_TX = r21;
        SlideLayout r22 = new SlideLayout("TWO_OBJ_OVER_TX", 22);
        TWO_OBJ_OVER_TX = r22;
        SlideLayout r23 = new SlideLayout("FOUR_OBJ", 23);
        FOUR_OBJ = r23;
        SlideLayout r24 = new SlideLayout("VERT_TX", 24);
        VERT_TX = r24;
        SlideLayout r25 = new SlideLayout("CLIP_ART_AND_VERT_TX", 25);
        CLIP_ART_AND_VERT_TX = r25;
        SlideLayout r26 = new SlideLayout("VERT_TITLE_AND_TX", 26);
        VERT_TITLE_AND_TX = r26;
        SlideLayout r27 = new SlideLayout("VERT_TITLE_AND_TX_OVER_CHART", 27);
        VERT_TITLE_AND_TX_OVER_CHART = r27;
        SlideLayout r28 = new SlideLayout("TWO_OBJ", 28);
        TWO_OBJ = r28;
        SlideLayout r29 = new SlideLayout("OBJ_AND_TWO_OBJ", 29);
        OBJ_AND_TWO_OBJ = r29;
        SlideLayout r30 = new SlideLayout("TWO_OBJ_AND_OBJ", 30);
        TWO_OBJ_AND_OBJ = r30;
        SlideLayout r31 = new SlideLayout("CUST", 31);
        CUST = r31;
        SlideLayout r32 = new SlideLayout("SECTION_HEADER", 32);
        SECTION_HEADER = r32;
        SlideLayout r33 = new SlideLayout("TWO_TX_TWO_OBJ", 33);
        TWO_TX_TWO_OBJ = r33;
        SlideLayout r34 = new SlideLayout("OBJ_TX", 34);
        OBJ_TX = r34;
        SlideLayout r35 = new SlideLayout("PIC_TX", 35);
        PIC_TX = r35;
        $VALUES = new SlideLayout[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35};
    }

    private SlideLayout(String r1, int r2) {
        super(r1, r2);
    }

    public static SlideLayout valueOf(String r2) {
        return (SlideLayout) ZeusTransformUtils.preCheckCast(Enum.valueOf(SlideLayout.class, r2), SlideLayout.class, "com.obric.memorydata.plugin");
    }

    public static SlideLayout[] values() {
        return (SlideLayout[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), SlideLayout[].class, "com.obric.memorydata.plugin");
    }
}
