package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum PaperSize extends Enum<PaperSize> {
    private static final /* synthetic */ PaperSize[] $VALUES = null;
    public static final PaperSize A3_PAPER = null;
    public static final PaperSize A4_PAPER = null;
    public static final PaperSize A4_SMALL_PAPER = null;
    public static final PaperSize A5_PAPER = null;
    public static final PaperSize B4_PAPER = null;
    public static final PaperSize B5_PAPER = null;
    public static final PaperSize EXECUTIVE_PAPER = null;
    public static final PaperSize FOLIO_PAPER = null;
    public static final PaperSize LEDGER_PAPER = null;
    public static final PaperSize LEGAL_PAPER = null;
    public static final PaperSize LETTER_PAPER = null;
    public static final PaperSize LETTER_SMALL_PAPER = null;
    public static final PaperSize QUARTO_PAPER = null;
    public static final PaperSize STANDARD_PAPER_10_14 = null;
    public static final PaperSize STANDARD_PAPER_11_17 = null;
    public static final PaperSize STATEMENT_PAPER = null;
    public static final PaperSize TABLOID_PAPER = null;

    static {
        PaperSize r0 = new PaperSize("LETTER_PAPER", 0);
        LETTER_PAPER = r0;
        PaperSize r1 = new PaperSize("LETTER_SMALL_PAPER", 1);
        LETTER_SMALL_PAPER = r1;
        PaperSize r3 = new PaperSize("TABLOID_PAPER", 2);
        TABLOID_PAPER = r3;
        PaperSize r5 = new PaperSize("LEDGER_PAPER", 3);
        LEDGER_PAPER = r5;
        PaperSize r7 = new PaperSize("LEGAL_PAPER", 4);
        LEGAL_PAPER = r7;
        PaperSize r9 = new PaperSize("STATEMENT_PAPER", 5);
        STATEMENT_PAPER = r9;
        PaperSize r11 = new PaperSize("EXECUTIVE_PAPER", 6);
        EXECUTIVE_PAPER = r11;
        PaperSize r13 = new PaperSize("A3_PAPER", 7);
        A3_PAPER = r13;
        PaperSize r15 = new PaperSize("A4_PAPER", 8);
        A4_PAPER = r15;
        PaperSize r14 = new PaperSize("A4_SMALL_PAPER", 9);
        A4_SMALL_PAPER = r14;
        PaperSize r12 = new PaperSize("A5_PAPER", 10);
        A5_PAPER = r12;
        PaperSize r10 = new PaperSize("B4_PAPER", 11);
        B4_PAPER = r10;
        PaperSize r8 = new PaperSize("B5_PAPER", 12);
        B5_PAPER = r8;
        PaperSize r6 = new PaperSize("FOLIO_PAPER", 13);
        FOLIO_PAPER = r6;
        PaperSize r4 = new PaperSize("QUARTO_PAPER", 14);
        QUARTO_PAPER = r4;
        PaperSize r2 = new PaperSize("STANDARD_PAPER_10_14", 15);
        STANDARD_PAPER_10_14 = r2;
        PaperSize r16 = new PaperSize("STANDARD_PAPER_11_17", 16);
        STANDARD_PAPER_11_17 = r16;
        $VALUES = new PaperSize[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
    }

    private PaperSize(String r1, int r2) {
        super(r1, r2);
    }

    public static PaperSize valueOf(String r2) {
        return (PaperSize) ZeusTransformUtils.preCheckCast(Enum.valueOf(PaperSize.class, r2), PaperSize.class, "com.obric.memorydata.plugin");
    }

    public static PaperSize[] values() {
        return (PaperSize[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PaperSize[].class, "com.obric.memorydata.plugin");
    }
}
