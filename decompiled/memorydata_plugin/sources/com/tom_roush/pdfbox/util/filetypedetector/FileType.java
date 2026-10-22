package com.tom_roush.pdfbox.util.filetypedetector;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public final enum FileType extends Enum<FileType> {
    private static final /* synthetic */ FileType[] $VALUES = null;
    public static final FileType ARW = null;
    public static final FileType BMP = null;
    public static final FileType CR2 = null;
    public static final FileType CRW = null;
    public static final FileType GIF = null;
    public static final FileType ICO = null;
    public static final FileType JPEG = null;
    public static final FileType NEF = null;
    public static final FileType ORF = null;
    public static final FileType PCX = null;
    public static final FileType PNG = null;
    public static final FileType PSD = null;
    public static final FileType RAF = null;
    public static final FileType RIFF = null;
    public static final FileType RW2 = null;
    public static final FileType TIFF = null;
    public static final FileType UNKNOWN = null;

    static {
        FileType r0 = new FileType("UNKNOWN", 0);
        UNKNOWN = r0;
        FileType r1 = new FileType("JPEG", 1);
        JPEG = r1;
        FileType r3 = new FileType("TIFF", 2);
        TIFF = r3;
        FileType r5 = new FileType("PSD", 3);
        PSD = r5;
        FileType r7 = new FileType("PNG", 4);
        PNG = r7;
        FileType r9 = new FileType("BMP", 5);
        BMP = r9;
        FileType r11 = new FileType("GIF", 6);
        GIF = r11;
        FileType r13 = new FileType("ICO", 7);
        ICO = r13;
        FileType r15 = new FileType("PCX", 8);
        PCX = r15;
        FileType r14 = new FileType("RIFF", 9);
        RIFF = r14;
        FileType r12 = new FileType("ARW", 10);
        ARW = r12;
        FileType r10 = new FileType("CRW", 11);
        CRW = r10;
        FileType r8 = new FileType("CR2", 12);
        CR2 = r8;
        FileType r6 = new FileType("NEF", 13);
        NEF = r6;
        FileType r4 = new FileType("ORF", 14);
        ORF = r4;
        FileType r2 = new FileType("RAF", 15);
        RAF = r2;
        FileType r16 = new FileType("RW2", 16);
        RW2 = r16;
        $VALUES = new FileType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
    }

    private FileType(String r1, int r2) {
        super(r1, r2);
    }

    public static FileType valueOf(String r2) {
        return (FileType) ZeusTransformUtils.preCheckCast(Enum.valueOf(FileType.class, r2), FileType.class, "com.obric.memorydata.plugin");
    }

    public static FileType[] values() {
        return (FileType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FileType[].class, "com.obric.memorydata.plugin");
    }
}
