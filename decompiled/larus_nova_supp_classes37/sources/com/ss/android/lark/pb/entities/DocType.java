package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum DocType extends Enum<DocType> implements WireEnum {
    private static final /* synthetic */ DocType[] $VALUES = null;
    public static final ProtoAdapter<DocType> ADAPTER = null;
    public static final DocType BITABLE = null;
    public static final DocType CATALOG = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType FILE = null;
    public static final DocType FOLDER = null;
    public static final DocType MIAODA = null;
    public static final DocType MIAODA_APP_DEVELOPMENT = null;
    public static final DocType MINDNOTE = null;
    public static final DocType SHEET = null;
    public static final DocType SHORTCUT = null;
    public static final DocType SLIDE = null;
    public static final DocType SLIDES = null;
    public static final DocType UNKNOWN_DOC_TYPE = null;
    public static final DocType WIKI = null;
    private final int value;

    static {
        DocType r0 = new DocType("UNKNOWN_DOC_TYPE", 0, 0);
        UNKNOWN_DOC_TYPE = r0;
        DocType r1 = new DocType("DOC", 1, 1);
        DOC = r1;
        DocType r3 = new DocType("SHEET", 2, 2);
        SHEET = r3;
        DocType r5 = new DocType("BITABLE", 3, 3);
        BITABLE = r5;
        DocType r7 = new DocType("MINDNOTE", 4, 4);
        MINDNOTE = r7;
        DocType r9 = new DocType("FILE", 5, 5);
        FILE = r9;
        DocType r11 = new DocType("SLIDE", 6, 6);
        SLIDE = r11;
        DocType r13 = new DocType("WIKI", 7, 7);
        WIKI = r13;
        DocType r15 = new DocType("DOCX", 8, 8);
        DOCX = r15;
        DocType r14 = new DocType("FOLDER", 9, 9);
        FOLDER = r14;
        DocType r12 = new DocType("CATALOG", 10, 10);
        CATALOG = r12;
        DocType r10 = new DocType("SLIDES", 11, 11);
        SLIDES = r10;
        DocType r8 = new DocType("SHORTCUT", 12, 12);
        SHORTCUT = r8;
        DocType r6 = new DocType("MIAODA", 13, 14);
        MIAODA = r6;
        DocType r4 = new DocType("MIAODA_APP_DEVELOPMENT", 14, 15);
        MIAODA_APP_DEVELOPMENT = r4;
        $VALUES = new DocType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4};
        ADAPTER = ProtoAdapter.newEnumAdapter(DocType.class);
    }

    public static DocType[] values() {
        return (DocType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DocType fromValue(int r0) {
        switch(r0) {
            case 0: goto L34;
            case 1: goto L32;
            case 2: goto L30;
            case 3: goto L28;
            case 4: goto L26;
            case 5: goto L24;
            case 6: goto L22;
            case 7: goto L20;
            case 8: goto L18;
            case 9: goto L16;
            case 10: goto L14;
            case 11: goto L12;
            case 12: goto L10;
            case 13: goto L3;
            case 14: goto L8;
            case 15: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return MIAODA_APP_DEVELOPMENT;
    L8:
        return MIAODA;
    L10:
        return SHORTCUT;
    L12:
        return SLIDES;
    L14:
        return CATALOG;
    L16:
        return FOLDER;
    L18:
        return DOCX;
    L20:
        return WIKI;
    L22:
        return SLIDE;
    L24:
        return FILE;
    L26:
        return MINDNOTE;
    L28:
        return BITABLE;
    L30:
        return SHEET;
    L32:
        return DOC;
    L34:
        return UNKNOWN_DOC_TYPE;
    }

    public static DocType valueOf(String r1) {
        return (DocType) a.a(DocType.class, r1);
    }

    private DocType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
