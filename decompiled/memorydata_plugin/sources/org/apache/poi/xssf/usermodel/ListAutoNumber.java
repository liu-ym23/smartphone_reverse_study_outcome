package org.apache.poi.xssf.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum ListAutoNumber extends Enum<ListAutoNumber> {
    private static final /* synthetic */ ListAutoNumber[] $VALUES = null;
    public static final ListAutoNumber ALPHA_LC_PARENT_BOTH = null;
    public static final ListAutoNumber ALPHA_LC_PARENT_R = null;
    public static final ListAutoNumber ALPHA_LC_PERIOD = null;
    public static final ListAutoNumber ALPHA_UC_PARENT_BOTH = null;
    public static final ListAutoNumber ALPHA_UC_PARENT_R = null;
    public static final ListAutoNumber ALPHA_UC_PERIOD = null;
    public static final ListAutoNumber ARABIC_PARENT_BOTH = null;
    public static final ListAutoNumber ARABIC_PARENT_R = null;
    public static final ListAutoNumber ARABIC_PERIOD = null;
    public static final ListAutoNumber ARABIC_PLAIN = null;
    public static final ListAutoNumber CIRCLE_NUM_DB_PLAIN = null;
    public static final ListAutoNumber CIRCLE_NUM_WD_BLACK_PLAIN = null;
    public static final ListAutoNumber CIRCLE_NUM_WD_WHITE_PLAIN = null;
    public static final ListAutoNumber ROMAN_LC_PARENT_BOTH = null;
    public static final ListAutoNumber ROMAN_LC_PARENT_R = null;
    public static final ListAutoNumber ROMAN_LC_PERIOD = null;
    public static final ListAutoNumber ROMAN_UC_PARENT_BOTH = null;
    public static final ListAutoNumber ROMAN_UC_PARENT_R = null;
    public static final ListAutoNumber ROMAN_UC_PERIOD = null;

    static {
        ListAutoNumber r0 = new ListAutoNumber("ALPHA_LC_PARENT_BOTH", 0);
        ALPHA_LC_PARENT_BOTH = r0;
        ListAutoNumber r1 = new ListAutoNumber("ALPHA_UC_PARENT_BOTH", 1);
        ALPHA_UC_PARENT_BOTH = r1;
        ListAutoNumber r3 = new ListAutoNumber("ALPHA_LC_PARENT_R", 2);
        ALPHA_LC_PARENT_R = r3;
        ListAutoNumber r5 = new ListAutoNumber("ALPHA_UC_PARENT_R", 3);
        ALPHA_UC_PARENT_R = r5;
        ListAutoNumber r7 = new ListAutoNumber("ALPHA_LC_PERIOD", 4);
        ALPHA_LC_PERIOD = r7;
        ListAutoNumber r9 = new ListAutoNumber("ALPHA_UC_PERIOD", 5);
        ALPHA_UC_PERIOD = r9;
        ListAutoNumber r11 = new ListAutoNumber("ARABIC_PARENT_BOTH", 6);
        ARABIC_PARENT_BOTH = r11;
        ListAutoNumber r13 = new ListAutoNumber("ARABIC_PARENT_R", 7);
        ARABIC_PARENT_R = r13;
        ListAutoNumber r15 = new ListAutoNumber("ARABIC_PERIOD", 8);
        ARABIC_PERIOD = r15;
        ListAutoNumber r14 = new ListAutoNumber("ARABIC_PLAIN", 9);
        ARABIC_PLAIN = r14;
        ListAutoNumber r12 = new ListAutoNumber("ROMAN_LC_PARENT_BOTH", 10);
        ROMAN_LC_PARENT_BOTH = r12;
        ListAutoNumber r10 = new ListAutoNumber("ROMAN_UC_PARENT_BOTH", 11);
        ROMAN_UC_PARENT_BOTH = r10;
        ListAutoNumber r8 = new ListAutoNumber("ROMAN_LC_PARENT_R", 12);
        ROMAN_LC_PARENT_R = r8;
        ListAutoNumber r6 = new ListAutoNumber("ROMAN_UC_PARENT_R", 13);
        ROMAN_UC_PARENT_R = r6;
        ListAutoNumber r4 = new ListAutoNumber("ROMAN_LC_PERIOD", 14);
        ROMAN_LC_PERIOD = r4;
        ListAutoNumber r2 = new ListAutoNumber("ROMAN_UC_PERIOD", 15);
        ROMAN_UC_PERIOD = r2;
        ListAutoNumber r16 = new ListAutoNumber("CIRCLE_NUM_DB_PLAIN", 16);
        CIRCLE_NUM_DB_PLAIN = r16;
        ListAutoNumber r17 = new ListAutoNumber("CIRCLE_NUM_WD_BLACK_PLAIN", 17);
        CIRCLE_NUM_WD_BLACK_PLAIN = r17;
        ListAutoNumber r18 = new ListAutoNumber("CIRCLE_NUM_WD_WHITE_PLAIN", 18);
        CIRCLE_NUM_WD_WHITE_PLAIN = r18;
        $VALUES = new ListAutoNumber[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18};
    }

    private ListAutoNumber(String r1, int r2) {
        super(r1, r2);
    }

    public static ListAutoNumber valueOf(String r2) {
        return (ListAutoNumber) ZeusTransformUtils.preCheckCast(Enum.valueOf(ListAutoNumber.class, r2), ListAutoNumber.class, "com.obric.memorydata.plugin");
    }

    public static ListAutoNumber[] values() {
        return (ListAutoNumber[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ListAutoNumber[].class, "com.obric.memorydata.plugin");
    }
}
