package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreVopTextType extends Enum<SAMICoreVopTextType> {
    private static final /* synthetic */ SAMICoreVopTextType[] $VALUES = null;
    public static final SAMICoreVopTextType PRIMARY = null;
    public static final SAMICoreVopTextType STANDARD = null;
    private int value;

    static {
        SAMICoreVopTextType r0 = new SAMICoreVopTextType("PRIMARY", 0, 50);
        PRIMARY = r0;
        SAMICoreVopTextType r1 = new SAMICoreVopTextType("STANDARD", 1, 80);
        STANDARD = r1;
        $VALUES = new SAMICoreVopTextType[]{r0, r1};
    }

    public static SAMICoreVopTextType[] values() {
        return (SAMICoreVopTextType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopTextType valueOf(String r1) {
        return (SAMICoreVopTextType) a.a(SAMICoreVopTextType.class, r1);
    }

    private SAMICoreVopTextType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
