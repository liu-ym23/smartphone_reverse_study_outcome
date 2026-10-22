package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreVopRecordingType extends Enum<SAMICoreVopRecordingType> {
    private static final /* synthetic */ SAMICoreVopRecordingType[] $VALUES = null;
    public static final SAMICoreVopRecordingType FILE = null;
    public static final SAMICoreVopRecordingType INTERNAL = null;
    public static final SAMICoreVopRecordingType PCM_S16 = null;
    private int value;

    static {
        SAMICoreVopRecordingType r0 = new SAMICoreVopRecordingType("PCM_S16", 0, 0);
        PCM_S16 = r0;
        SAMICoreVopRecordingType r1 = new SAMICoreVopRecordingType("FILE", 1, 1);
        FILE = r1;
        SAMICoreVopRecordingType r3 = new SAMICoreVopRecordingType("INTERNAL", 2, 2);
        INTERNAL = r3;
        $VALUES = new SAMICoreVopRecordingType[]{r0, r1, r3};
    }

    public static SAMICoreVopRecordingType[] values() {
        return (SAMICoreVopRecordingType[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopRecordingType valueOf(String r1) {
        return (SAMICoreVopRecordingType) a.a(SAMICoreVopRecordingType.class, r1);
    }

    private SAMICoreVopRecordingType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
