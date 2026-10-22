package com.larus.common_ui.icon;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u001b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/larus/common_ui/icon/CommonFileIconType;", "", "<init>", "(Ljava/lang/String;I)V", "FOLDER", "DOC", "TXT", "PPT", "PDF", "IMAGE", "VIDEO", "AUDIO", "XLS", "CODE", "MARKDOWN", "ZIP", "CSV", "KEYNOTE", "PAGES", "NUMBERS", "AI_DOC", "AI_SLIDES", "AI_SHEET", "BITABLE", "BITABLE_APP", "MIAODA", "MINDNOTE", "UNKNOWN", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonFileIconType extends Enum<CommonFileIconType> {
    public static final CommonFileIconType AI_DOC = null;
    public static final CommonFileIconType AI_SHEET = null;
    public static final CommonFileIconType AI_SLIDES = null;
    public static final CommonFileIconType AUDIO = null;
    public static final CommonFileIconType BITABLE = null;
    public static final CommonFileIconType BITABLE_APP = null;
    public static final CommonFileIconType CODE = null;
    public static final CommonFileIconType CSV = null;
    public static final CommonFileIconType DOC = null;
    public static final CommonFileIconType FOLDER = null;
    public static final CommonFileIconType IMAGE = null;
    public static final CommonFileIconType KEYNOTE = null;
    public static final CommonFileIconType MARKDOWN = null;
    public static final CommonFileIconType MIAODA = null;
    public static final CommonFileIconType MINDNOTE = null;
    public static final CommonFileIconType NUMBERS = null;
    public static final CommonFileIconType PAGES = null;
    public static final CommonFileIconType PDF = null;
    public static final CommonFileIconType PPT = null;
    public static final CommonFileIconType TXT = null;
    public static final CommonFileIconType UNKNOWN = null;
    public static final CommonFileIconType VIDEO = null;
    public static final CommonFileIconType XLS = null;
    public static final CommonFileIconType ZIP = null;
    public static final /* synthetic */ CommonFileIconType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<CommonFileIconType> getEntries() {
        return b;
    }

    static {
        CommonFileIconType r0 = new CommonFileIconType("FOLDER", 0);
        FOLDER = r0;
        CommonFileIconType r1 = new CommonFileIconType("DOC", 1);
        DOC = r1;
        CommonFileIconType r3 = new CommonFileIconType("TXT", 2);
        TXT = r3;
        CommonFileIconType r5 = new CommonFileIconType("PPT", 3);
        PPT = r5;
        CommonFileIconType r7 = new CommonFileIconType("PDF", 4);
        PDF = r7;
        CommonFileIconType r9 = new CommonFileIconType("IMAGE", 5);
        IMAGE = r9;
        CommonFileIconType r11 = new CommonFileIconType("VIDEO", 6);
        VIDEO = r11;
        CommonFileIconType r13 = new CommonFileIconType("AUDIO", 7);
        AUDIO = r13;
        CommonFileIconType r15 = new CommonFileIconType("XLS", 8);
        XLS = r15;
        CommonFileIconType r14 = new CommonFileIconType("CODE", 9);
        CODE = r14;
        CommonFileIconType r12 = new CommonFileIconType("MARKDOWN", 10);
        MARKDOWN = r12;
        CommonFileIconType r10 = new CommonFileIconType("ZIP", 11);
        ZIP = r10;
        CommonFileIconType r8 = new CommonFileIconType("CSV", 12);
        CSV = r8;
        CommonFileIconType r6 = new CommonFileIconType("KEYNOTE", 13);
        KEYNOTE = r6;
        CommonFileIconType r4 = new CommonFileIconType("PAGES", 14);
        PAGES = r4;
        CommonFileIconType r2 = new CommonFileIconType("NUMBERS", 15);
        NUMBERS = r2;
        CommonFileIconType r16 = new CommonFileIconType("AI_DOC", 16);
        AI_DOC = r16;
        CommonFileIconType r17 = new CommonFileIconType("AI_SLIDES", 17);
        AI_SLIDES = r17;
        CommonFileIconType r18 = new CommonFileIconType("AI_SHEET", 18);
        AI_SHEET = r18;
        CommonFileIconType r20 = new CommonFileIconType("BITABLE", 19);
        BITABLE = r20;
        CommonFileIconType r21 = new CommonFileIconType("BITABLE_APP", 20);
        BITABLE_APP = r21;
        CommonFileIconType r22 = new CommonFileIconType("MIAODA", 21);
        MIAODA = r22;
        CommonFileIconType r23 = new CommonFileIconType("MINDNOTE", 22);
        MINDNOTE = r23;
        CommonFileIconType r24 = new CommonFileIconType("UNKNOWN", 23);
        UNKNOWN = r24;
        CommonFileIconType[] r25 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16, r17, r18, r20, r21, r22, r23, r24};
        a = r25;
        b = EnumEntriesKt.enumEntries(r25);
    }

    public static CommonFileIconType[] values() {
        return (CommonFileIconType[]) a.clone();
    }

    public static CommonFileIconType valueOf(String r1) {
        return (CommonFileIconType) a.a(CommonFileIconType.class, r1);
    }

    public CommonFileIconType(String r1, int r2) {
        super(r1, r2);
    }
}
