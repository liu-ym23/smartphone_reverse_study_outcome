package com.bytedance.applog.monitor.exception;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public final enum ExceptionType extends Enum<ExceptionType> {
    private static final /* synthetic */ ExceptionType[] $VALUES = null;
    public static final ExceptionType CacheOverflow = null;
    public static final ExceptionType CommonError = null;
    public static final ExceptionType HighFrequency = null;
    public static final ExceptionType InterruptionBlockList = null;
    public static final ExceptionType InterruptionEventList = null;
    public static final ExceptionType InterruptionInvalidDid = null;
    public static final ExceptionType InterruptionSampling = null;
    public static final ExceptionType InterruptionTouristMode = null;
    public static final ExceptionType LargeSize = null;
    public static final ExceptionType OutOfDataBoundary = null;

    static {
        ExceptionType r0 = new ExceptionType("InterruptionInvalidDid", 0);
        InterruptionInvalidDid = r0;
        ExceptionType r1 = new ExceptionType("InterruptionBlockList", 1);
        InterruptionBlockList = r1;
        ExceptionType r3 = new ExceptionType("InterruptionTouristMode", 2);
        InterruptionTouristMode = r3;
        ExceptionType r5 = new ExceptionType("InterruptionEventList", 3);
        InterruptionEventList = r5;
        ExceptionType r7 = new ExceptionType("InterruptionSampling", 4);
        InterruptionSampling = r7;
        ExceptionType r9 = new ExceptionType("OutOfDataBoundary", 5);
        OutOfDataBoundary = r9;
        ExceptionType r11 = new ExceptionType("CacheOverflow", 6);
        CacheOverflow = r11;
        ExceptionType r13 = new ExceptionType("CommonError", 7);
        CommonError = r13;
        ExceptionType r15 = new ExceptionType("HighFrequency", 8);
        HighFrequency = r15;
        ExceptionType r14 = new ExceptionType("LargeSize", 9);
        LargeSize = r14;
        $VALUES = new ExceptionType[]{r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
    }

    private ExceptionType(String r1, int r2) {
        super(r1, r2);
    }

    public static ExceptionType valueOf(String r2) {
        return (ExceptionType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ExceptionType.class, r2), ExceptionType.class, "com.obric.memorydata.plugin");
    }

    public static ExceptionType[] values() {
        return (ExceptionType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ExceptionType[].class, "com.obric.memorydata.plugin");
    }
}
