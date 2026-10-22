package org.apache.poi.hpsf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final enum ClassIDPredefined extends Enum<ClassIDPredefined> {
    private static final /* synthetic */ ClassIDPredefined[] $VALUES = null;
    public static final ClassIDPredefined DOC_SUMMARY = null;
    public static final ClassIDPredefined EQUATION_V3 = null;
    public static final ClassIDPredefined EXCEL_V11 = null;
    public static final ClassIDPredefined EXCEL_V12 = null;
    public static final ClassIDPredefined EXCEL_V12_MACRO = null;
    public static final ClassIDPredefined EXCEL_V12_XLSB = null;
    public static final ClassIDPredefined EXCEL_V14 = null;
    public static final ClassIDPredefined EXCEL_V14_CHART = null;
    public static final ClassIDPredefined EXCEL_V14_ODS = null;
    public static final ClassIDPredefined EXCEL_V14_WORKBOOK = null;
    public static final ClassIDPredefined EXCEL_V3 = null;
    public static final ClassIDPredefined EXCEL_V3_CHART = null;
    public static final ClassIDPredefined EXCEL_V3_MACRO = null;
    public static final ClassIDPredefined EXCEL_V7 = null;
    public static final ClassIDPredefined EXCEL_V7_CHART = null;
    public static final ClassIDPredefined EXCEL_V7_WORKBOOK = null;
    public static final ClassIDPredefined EXCEL_V8 = null;
    public static final ClassIDPredefined EXCEL_V8_CHART = null;
    public static final ClassIDPredefined FILE_MONIKER = null;
    private static final Map<String, ClassIDPredefined> LOOKUP = null;
    public static final ClassIDPredefined OLE_V1_PACKAGE = null;
    public static final ClassIDPredefined PAINT = null;
    public static final ClassIDPredefined PDF = null;
    public static final ClassIDPredefined POWERPOINT_V12 = null;
    public static final ClassIDPredefined POWERPOINT_V12_MACRO = null;
    public static final ClassIDPredefined POWERPOINT_V7 = null;
    public static final ClassIDPredefined POWERPOINT_V7_SLIDE = null;
    public static final ClassIDPredefined POWERPOINT_V8 = null;
    public static final ClassIDPredefined POWERPOINT_V8_TPL = null;
    public static final ClassIDPredefined PUBLISHER_V12 = null;
    public static final ClassIDPredefined STD_MONIKER = null;
    public static final ClassIDPredefined SUMMARY_PROPERTIES = null;
    public static final ClassIDPredefined TXT_ONLY = null;
    public static final ClassIDPredefined URL_MONIKER = null;
    public static final ClassIDPredefined USER_PROPERTIES = null;
    public static final ClassIDPredefined VISIO_V10 = null;
    public static final ClassIDPredefined WORD_V12 = null;
    public static final ClassIDPredefined WORD_V12_MACRO = null;
    public static final ClassIDPredefined WORD_V7 = null;
    public static final ClassIDPredefined WORD_V8 = null;
    private ClassID classId;
    private final String contentType;
    private final String externalForm;
    private final String fileExtension;

    static {
        ClassIDPredefined r6 = new ClassIDPredefined("OLE_V1_PACKAGE", 0, "{0003000C-0000-0000-C000-000000000046}", ".bin", null);
        OLE_V1_PACKAGE = r6;
        ClassIDPredefined r0 = new ClassIDPredefined("EXCEL_V3", 1, "{00030000-0000-0000-C000-000000000046}", ".xls", "application/vnd.ms-excel");
        EXCEL_V3 = r0;
        ClassIDPredefined r1 = new ClassIDPredefined("EXCEL_V3_CHART", 2, "{00030001-0000-0000-C000-000000000046}", null, null);
        EXCEL_V3_CHART = r1;
        ClassIDPredefined r2 = new ClassIDPredefined("EXCEL_V3_MACRO", 3, "{00030002-0000-0000-C000-000000000046}", null, null);
        EXCEL_V3_MACRO = r2;
        ClassIDPredefined r3 = new ClassIDPredefined("EXCEL_V7", 4, "{00020810-0000-0000-C000-000000000046}", ".xls", "application/vnd.ms-excel");
        EXCEL_V7 = r3;
        ClassIDPredefined r4 = new ClassIDPredefined("EXCEL_V7_WORKBOOK", 5, "{00020841-0000-0000-C000-000000000046}", null, null);
        EXCEL_V7_WORKBOOK = r4;
        ClassIDPredefined r5 = new ClassIDPredefined("EXCEL_V7_CHART", 6, "{00020811-0000-0000-C000-000000000046}", null, null);
        EXCEL_V7_CHART = r5;
        ClassIDPredefined r13 = new ClassIDPredefined("EXCEL_V8", 7, "{00020820-0000-0000-C000-000000000046}", ".xls", "application/vnd.ms-excel");
        EXCEL_V8 = r13;
        ClassIDPredefined r7 = new ClassIDPredefined("EXCEL_V8_CHART", 8, "{00020821-0000-0000-C000-000000000046}", null, null);
        EXCEL_V8_CHART = r7;
        ClassIDPredefined r8 = new ClassIDPredefined("EXCEL_V11", 9, "{00020812-0000-0000-C000-000000000046}", ".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        EXCEL_V11 = r8;
        ClassIDPredefined r9 = new ClassIDPredefined("EXCEL_V12", 10, "{00020830-0000-0000-C000-000000000046}", ".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        EXCEL_V12 = r9;
        ClassIDPredefined r10 = new ClassIDPredefined("EXCEL_V12_MACRO", 11, "{00020832-0000-0000-C000-000000000046}", ".xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12");
        EXCEL_V12_MACRO = r10;
        ClassIDPredefined r11 = new ClassIDPredefined("EXCEL_V12_XLSB", 12, "{00020833-0000-0000-C000-000000000046}", ".xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12");
        EXCEL_V12_XLSB = r11;
        ClassIDPredefined r12 = new ClassIDPredefined("EXCEL_V14", 13, "{00024500-0000-0000-C000-000000000046}", ".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        EXCEL_V14 = r12;
        ClassIDPredefined r20 = new ClassIDPredefined("EXCEL_V14_WORKBOOK", 14, "{000208D5-0000-0000-C000-000000000046}", null, null);
        EXCEL_V14_WORKBOOK = r20;
        ClassIDPredefined r14 = new ClassIDPredefined("EXCEL_V14_CHART", 15, "{00024505-0014-0000-C000-000000000046}", null, null);
        EXCEL_V14_CHART = r14;
        ClassIDPredefined r15 = new ClassIDPredefined("EXCEL_V14_ODS", 16, "{EABCECDB-CC1C-4A6F-B4E3-7F888A5ADFC8}", ".ods", "application/vnd.oasis.opendocument.spreadsheet");
        EXCEL_V14_ODS = r15;
        ClassIDPredefined r16 = new ClassIDPredefined("WORD_V7", 17, "{00020900-0000-0000-C000-000000000046}", ".doc", "application/msword");
        WORD_V7 = r16;
        ClassIDPredefined r17 = new ClassIDPredefined("WORD_V8", 18, "{00020906-0000-0000-C000-000000000046}", ".doc", "application/msword");
        WORD_V8 = r17;
        ClassIDPredefined r18 = new ClassIDPredefined("WORD_V12", 19, "{F4754C9B-64F5-4B40-8AF4-679732AC0607}", ".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
        WORD_V12 = r18;
        ClassIDPredefined r19 = new ClassIDPredefined("WORD_V12_MACRO", 20, "{18A06B6B-2F3F-4E2B-A611-52BE631B2D22}", ".docm", "application/vnd.ms-word.document.macroEnabled.12");
        WORD_V12_MACRO = r19;
        ClassIDPredefined r27 = new ClassIDPredefined("POWERPOINT_V7", 21, "{EA7BAE70-FB3B-11CD-A903-00AA00510EA3}", ".ppt", "application/vnd.ms-powerpoint");
        POWERPOINT_V7 = r27;
        ClassIDPredefined r21 = new ClassIDPredefined("POWERPOINT_V7_SLIDE", 22, "{EA7BAE71-FB3B-11CD-A903-00AA00510EA3}", null, null);
        POWERPOINT_V7_SLIDE = r21;
        ClassIDPredefined r22 = new ClassIDPredefined("POWERPOINT_V8", 23, "{64818D10-4F9B-11CF-86EA-00AA00B929E8}", ".ppt", "application/vnd.ms-powerpoint");
        POWERPOINT_V8 = r22;
        ClassIDPredefined r23 = new ClassIDPredefined("POWERPOINT_V8_TPL", 24, "{64818D11-4F9B-11CF-86EA-00AA00B929E8}", ".pot", "application/vnd.ms-powerpoint");
        POWERPOINT_V8_TPL = r23;
        ClassIDPredefined r24 = new ClassIDPredefined("POWERPOINT_V12", 25, "{CF4F55F4-8F87-4D47-80BB-5808164BB3F8}", ".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation");
        POWERPOINT_V12 = r24;
        ClassIDPredefined r25 = new ClassIDPredefined("POWERPOINT_V12_MACRO", 26, "{DC020317-E6E2-4A62-B9FA-B3EFE16626F4}", ".pptm", "application/vnd.ms-powerpoint.presentation.macroEnabled.12");
        POWERPOINT_V12_MACRO = r25;
        ClassIDPredefined r26 = new ClassIDPredefined("PUBLISHER_V12", 27, "{0002123D-0000-0000-C000-000000000046}", ".pub", "application/x-mspublisher");
        PUBLISHER_V12 = r26;
        ClassIDPredefined r34 = new ClassIDPredefined("VISIO_V10", 28, "{00021A14-0000-0000-C000-000000000046}", ".vsd", "application/vnd.visio");
        VISIO_V10 = r34;
        ClassIDPredefined r28 = new ClassIDPredefined("EQUATION_V3", 29, "{0002CE02-0000-0000-C000-000000000046}", null, null);
        EQUATION_V3 = r28;
        ClassIDPredefined r29 = new ClassIDPredefined("PDF", 30, "{B801CA65-A1FC-11D0-85AD-444553540000}", ".pdf", "application/pdf");
        PDF = r29;
        ClassIDPredefined r30 = new ClassIDPredefined("TXT_ONLY", 31, "{5e941d80-bf96-11cd-b579-08002b30bfeb}", ".txt", "text/plain");
        TXT_ONLY = r30;
        ClassIDPredefined r31 = new ClassIDPredefined("PAINT", 32, "{0003000A-0000-0000-C000-000000000046}", null, null);
        PAINT = r31;
        ClassIDPredefined r32 = new ClassIDPredefined("STD_MONIKER", 33, "{79EAC9D0-BAF9-11CE-8C82-00AA004BA90B}", null, null);
        STD_MONIKER = r32;
        ClassIDPredefined r33 = new ClassIDPredefined("URL_MONIKER", 34, "{79EAC9E0-BAF9-11CE-8C82-00AA004BA90B}", null, null);
        URL_MONIKER = r33;
        ClassIDPredefined r41 = new ClassIDPredefined("FILE_MONIKER", 35, "{00000303-0000-0000-C000-000000000046}", null, null);
        FILE_MONIKER = r41;
        ClassIDPredefined r35 = new ClassIDPredefined("DOC_SUMMARY", 36, "{D5CDD502-2E9C-101B-9397-08002B2CF9AE}", null, null);
        DOC_SUMMARY = r35;
        ClassIDPredefined r36 = new ClassIDPredefined("USER_PROPERTIES", 37, "{D5CDD505-2E9C-101B-9397-08002B2CF9AE}", null, null);
        USER_PROPERTIES = r36;
        ClassIDPredefined r37 = new ClassIDPredefined("SUMMARY_PROPERTIES", 38, "{F29F85E0-4FF9-1068-AB91-08002B27B3D9}", null, null);
        SUMMARY_PROPERTIES = r37;
        $VALUES = new ClassIDPredefined[]{r6, r0, r1, r2, r3, r4, r5, r13, r7, r8, r9, r10, r11, r12, r20, r14, r15, r16, r17, r18, r19, r27, r21, r22, r23, r24, r25, r26, r34, r28, r29, r30, r31, r32, r33, r41, r35, r36, r37};
        LOOKUP = new HashMap();
        ClassIDPredefined[] r38 = values();
        int r39 = r38.length;
        int r40 = 0;
    L3:
        if (r40 >= r39) goto L5;
        ClassIDPredefined r42 = r38[r40];
        LOOKUP.put(r42.externalForm, r42);
        r40 = r40 + 1;
        goto L3
    }

    private ClassIDPredefined(String r1, int r2, String r3, String r4, String r5) {
        super(r1, r2);
        this.externalForm = r3;
        this.fileExtension = r4;
        this.contentType = r5;
    }

    public static ClassIDPredefined lookup(String r2) {
        return (ClassIDPredefined) ZeusTransformUtils.preCheckCast(LOOKUP.get(r2), ClassIDPredefined.class, "com.obric.memorydata.plugin");
    }

    public static ClassIDPredefined lookup(ClassID r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        return (ClassIDPredefined) ZeusTransformUtils.preCheckCast(LOOKUP.get(r2.toString()), ClassIDPredefined.class, "com.obric.memorydata.plugin");
    }

    public static ClassIDPredefined valueOf(String r2) {
        return (ClassIDPredefined) ZeusTransformUtils.preCheckCast(Enum.valueOf(ClassIDPredefined.class, r2), ClassIDPredefined.class, "com.obric.memorydata.plugin");
    }

    public static ClassIDPredefined[] values() {
        return (ClassIDPredefined[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ClassIDPredefined[].class, "com.obric.memorydata.plugin");
    }

    public boolean equals(ClassID r1) {
        return getClassID().equals(r1);
    }

    public ClassID getClassID() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.classId != null) goto L6;
        this.classId = new ClassID(this.externalForm);     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);     // Catch: Throwable -> L9
        return this.classId;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getFileExtension() {
        return this.fileExtension;
    }
}
