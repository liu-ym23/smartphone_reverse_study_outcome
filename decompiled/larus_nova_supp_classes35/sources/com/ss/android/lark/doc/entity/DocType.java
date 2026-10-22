package com.ss.android.lark.doc.entity;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final enum DocType extends Enum<DocType> {
    public static final DocType BITABLE = null;
    public static final DocType CATALOG = null;
    public static final DocType DOC = null;
    public static final DocType DOCX = null;
    public static final DocType DOCX_SYNCED_BLOCK = null;
    public static final DocType DOUBAO_CHAT = null;
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
    public static final /* synthetic */ DocType[] a = null;
    private int value;

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
        DocType r6 = new DocType("DOCX_SYNCED_BLOCK", 13, 13);
        DOCX_SYNCED_BLOCK = r6;
        DocType r4 = new DocType("MIAODA", 14, 14);
        MIAODA = r4;
        DocType r2 = new DocType("MIAODA_APP_DEVELOPMENT", 15, 15);
        MIAODA_APP_DEVELOPMENT = r2;
        DocType r16 = new DocType("DOUBAO_CHAT", 16, 16);
        DOUBAO_CHAT = r16;
        a = new DocType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
    }

    public static DocType[] values() {
        return (DocType[]) a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static DocType forNumber(int r0) {
        switch(r0) {
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L12;
            case 14: goto L10;
            case 15: goto L8;
            case 16: goto L6;
            default: goto L4;
        };
    L4:
        return UNKNOWN_DOC_TYPE;
    L6:
        return DOUBAO_CHAT;
    L8:
        return MIAODA_APP_DEVELOPMENT;
    L10:
        return MIAODA;
    L12:
        return DOCX_SYNCED_BLOCK;
    L14:
        return SHORTCUT;
    L16:
        return SLIDES;
    L18:
        return CATALOG;
    L20:
        return FOLDER;
    L22:
        return DOCX;
    L24:
        return WIKI;
    L26:
        return SLIDE;
    L28:
        return FILE;
    L30:
        return MINDNOTE;
    L32:
        return BITABLE;
    L34:
        return SHEET;
    L36:
        return DOC;
    }

    public static DocType valueOf(String r1) {
        return (DocType) a.a(DocType.class, r1);
    }

    public DocType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
