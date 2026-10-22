package org.apache.poi.ss.usermodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public final enum FontUnderline extends Enum<FontUnderline> {
    private static final /* synthetic */ FontUnderline[] $VALUES = null;
    public static final FontUnderline DOUBLE = null;
    public static final FontUnderline DOUBLE_ACCOUNTING = null;
    public static final FontUnderline NONE = null;
    public static final FontUnderline SINGLE = null;
    public static final FontUnderline SINGLE_ACCOUNTING = null;
    private static FontUnderline[] _table;
    private int value;

    /* JADX INFO: renamed from: org.apache.poi.ss.usermodel.FontUnderline$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline = null;

        static {
            int[] r0 = new int[FontUnderline.values().length];
            $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline = r0;
            r0[FontUnderline.DOUBLE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.DOUBLE_ACCOUNTING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.SINGLE_ACCOUNTING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.NONE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[FontUnderline.SINGLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    static {
        int r2 = 0;
        FontUnderline r0 = new FontUnderline("SINGLE", 0, 1);
        SINGLE = r0;
        FontUnderline r1 = new FontUnderline("DOUBLE", 1, 2);
        DOUBLE = r1;
        FontUnderline r4 = new FontUnderline("SINGLE_ACCOUNTING", 2, 3);
        SINGLE_ACCOUNTING = r4;
        FontUnderline r6 = new FontUnderline("DOUBLE_ACCOUNTING", 3, 4);
        DOUBLE_ACCOUNTING = r6;
        FontUnderline r8 = new FontUnderline("NONE", 4, 5);
        NONE = r8;
        $VALUES = new FontUnderline[]{r0, r1, r4, r6, r8};
        _table = new FontUnderline[6];
        FontUnderline[] r3 = values();
        int r5 = r3.length;
    L3:
        if (r2 >= r5) goto L5;
        FontUnderline r7 = r3[r2];
        _table[r7.getValue()] = r7;
        r2 = r2 + 1;
        goto L3
    }

    private FontUnderline(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static FontUnderline valueOf(byte r1) {
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L19;
        if (r1 == 33) goto L18;
        if (r1 == 34) goto L17;
        return NONE;
    L17:
        return DOUBLE_ACCOUNTING;
    L18:
        return SINGLE_ACCOUNTING;
    L19:
        return DOUBLE;
    L15:
        return SINGLE;
    }

    public static FontUnderline valueOf(int r1) {
        return _table[r1];
    }

    public static FontUnderline valueOf(String r2) {
        return (FontUnderline) ZeusTransformUtils.preCheckCast(Enum.valueOf(FontUnderline.class, r2), FontUnderline.class, "com.obric.memorydata.plugin");
    }

    public static FontUnderline[] values() {
        return (FontUnderline[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), FontUnderline[].class, "com.obric.memorydata.plugin");
    }

    public byte getByteValue() {
        int r2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$usermodel$FontUnderline[ordinal()];
        if (r2 == 1) goto L16;
        if (r2 != 2) goto L6;
        return 34;
    L6:
        if (r2 != 3) goto L8;
        return 33;
    L8:
        if (r2 == 4) goto L10;
        return 1;
    L10:
        return 0;
    L16:
        return 2;
    }

    public int getValue() {
        return this.value;
    }
}
