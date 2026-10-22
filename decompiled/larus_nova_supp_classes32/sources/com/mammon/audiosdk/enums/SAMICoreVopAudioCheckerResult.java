package com.mammon.audiosdk.enums;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final enum SAMICoreVopAudioCheckerResult extends Enum<SAMICoreVopAudioCheckerResult> {
    private static final /* synthetic */ SAMICoreVopAudioCheckerResult[] $VALUES = null;
    public static final SAMICoreVopAudioCheckerResult INTERNAL_ERROR = null;
    public static final SAMICoreVopAudioCheckerResult NETWORK_ERROR = null;
    public static final SAMICoreVopAudioCheckerResult PASSED = null;
    public static final SAMICoreVopAudioCheckerResult SNR_FAILED = null;
    public static final SAMICoreVopAudioCheckerResult WER_FAILED = null;
    private int value;

    static {
        SAMICoreVopAudioCheckerResult r0 = new SAMICoreVopAudioCheckerResult("INTERNAL_ERROR", 0, 0);
        INTERNAL_ERROR = r0;
        SAMICoreVopAudioCheckerResult r1 = new SAMICoreVopAudioCheckerResult("NETWORK_ERROR", 1, 1);
        NETWORK_ERROR = r1;
        SAMICoreVopAudioCheckerResult r3 = new SAMICoreVopAudioCheckerResult("PASSED", 2, 2);
        PASSED = r3;
        SAMICoreVopAudioCheckerResult r5 = new SAMICoreVopAudioCheckerResult("SNR_FAILED", 3, 3);
        SNR_FAILED = r5;
        SAMICoreVopAudioCheckerResult r7 = new SAMICoreVopAudioCheckerResult("WER_FAILED", 4, 4);
        WER_FAILED = r7;
        $VALUES = new SAMICoreVopAudioCheckerResult[]{r0, r1, r3, r5, r7};
    }

    public static SAMICoreVopAudioCheckerResult[] values() {
        return (SAMICoreVopAudioCheckerResult[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static SAMICoreVopAudioCheckerResult valueOf(String r1) {
        return (SAMICoreVopAudioCheckerResult) a.a(SAMICoreVopAudioCheckerResult.class, r1);
    }

    private SAMICoreVopAudioCheckerResult(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
