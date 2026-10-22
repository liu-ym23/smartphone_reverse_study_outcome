package com.cronutils.model.field;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CronFieldName extends Enum<CronFieldName> {
    private static final /* synthetic */ CronFieldName[] $VALUES = null;
    public static final CronFieldName DAY_OF_MONTH = null;
    public static final CronFieldName DAY_OF_WEEK = null;
    public static final CronFieldName DAY_OF_YEAR = null;
    public static final CronFieldName HOUR = null;
    public static final CronFieldName MINUTE = null;
    public static final CronFieldName MONTH = null;
    public static final CronFieldName SECOND = null;
    public static final CronFieldName YEAR = null;
    private int order;

    static {
        CronFieldName r0 = new CronFieldName("SECOND", 0, 0);
        SECOND = r0;
        CronFieldName r1 = new CronFieldName("MINUTE", 1, 1);
        MINUTE = r1;
        CronFieldName r3 = new CronFieldName("HOUR", 2, 2);
        HOUR = r3;
        CronFieldName r5 = new CronFieldName("DAY_OF_MONTH", 3, 3);
        DAY_OF_MONTH = r5;
        CronFieldName r7 = new CronFieldName("MONTH", 4, 4);
        MONTH = r7;
        CronFieldName r9 = new CronFieldName("DAY_OF_WEEK", 5, 5);
        DAY_OF_WEEK = r9;
        CronFieldName r11 = new CronFieldName("YEAR", 6, 6);
        YEAR = r11;
        CronFieldName r13 = new CronFieldName("DAY_OF_YEAR", 7, 7);
        DAY_OF_YEAR = r13;
        $VALUES = new CronFieldName[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private CronFieldName(String r1, int r2, int r3) {
        super(r1, r2);
        this.order = r3;
    }

    public static CronFieldName valueOf(String r2) {
        return (CronFieldName) ZeusTransformUtils.preCheckCast(Enum.valueOf(CronFieldName.class, r2), CronFieldName.class, "com.obric.memorydata.plugin");
    }

    public static CronFieldName[] values() {
        return (CronFieldName[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CronFieldName[].class, "com.obric.memorydata.plugin");
    }

    public int getOrder() {
        return this.order;
    }
}
