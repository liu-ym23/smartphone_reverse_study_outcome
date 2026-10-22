package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreVopLanguage extends Enum<SAMICoreVopLanguage> {
    private static final /* synthetic */ SAMICoreVopLanguage[] $VALUES = null;
    public static final SAMICoreVopLanguage CHINESE = null;
    public static final SAMICoreVopLanguage ENGLISH = null;
    public static final SAMICoreVopLanguage JAPANESE = null;
    private int value;

    static {
        SAMICoreVopLanguage r0 = new SAMICoreVopLanguage("JAPANESE", 0, 0);
        JAPANESE = r0;
        SAMICoreVopLanguage r1 = new SAMICoreVopLanguage("ENGLISH", 1, 1);
        ENGLISH = r1;
        SAMICoreVopLanguage r3 = new SAMICoreVopLanguage("CHINESE", 2, 2);
        CHINESE = r3;
        $VALUES = new SAMICoreVopLanguage[]{r0, r1, r3};
    }

    public static SAMICoreVopLanguage[] values() {
        return (SAMICoreVopLanguage[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopLanguage valueOf(String r1) {
        return (SAMICoreVopLanguage) a.a(SAMICoreVopLanguage.class, r1);
    }

    private SAMICoreVopLanguage(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
