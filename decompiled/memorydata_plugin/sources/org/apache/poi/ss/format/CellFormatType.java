package org.apache.poi.ss.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public abstract enum CellFormatType extends Enum<CellFormatType> {
    private static final /* synthetic */ CellFormatType[] $VALUES = null;
    public static final CellFormatType DATE = null;
    public static final CellFormatType ELAPSED = null;
    public static final CellFormatType GENERAL = null;
    public static final CellFormatType NUMBER = null;
    public static final CellFormatType TEXT = null;

    static {
        final String r1 = "GENERAL";
        final int r2 = 0;
        CellFormatType r0 = new AnonymousClass1(r1, r2);
        GENERAL = r0;
        final String r3 = "NUMBER";
        final int r4 = 1;
        CellFormatType r5 = new AnonymousClass2(r3, r4);
        NUMBER = r5;
        final String r6 = "DATE";
        final int r7 = 2;
        CellFormatType r8 = new AnonymousClass3(r6, r7);
        DATE = r8;
        final String r9 = "ELAPSED";
        final int r10 = 3;
        CellFormatType r11 = new AnonymousClass4(r9, r10);
        ELAPSED = r11;
        final String r12 = "TEXT";
        final int r13 = 4;
        CellFormatType r14 = new AnonymousClass5(r12, r13);
        TEXT = r14;
        $VALUES = new CellFormatType[]{r0, r5, r8, r11, r14};
    }

    private CellFormatType(String r1, int r2) {
        super(r1, r2);
    }

    /* synthetic */ CellFormatType(String r1, int r2, AnonymousClass1 r3) {
        this(r1, r2);
    }

    public static CellFormatType valueOf(String r2) {
        return (CellFormatType) ZeusTransformUtils.preCheckCast(Enum.valueOf(CellFormatType.class, r2), CellFormatType.class, "com.obric.memorydata.plugin");
    }

    public static CellFormatType[] values() {
        return (CellFormatType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CellFormatType[].class, "com.obric.memorydata.plugin");
    }

    abstract CellFormatter formatter(String r1);

    abstract CellFormatter formatter(Locale r1, String r2);

    abstract boolean isSpecial(char r1);
}
