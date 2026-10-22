package com.cronutils.model.definition;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum CronNicknames extends Enum<CronNicknames> {
    private static final /* synthetic */ CronNicknames[] $VALUES = null;
    public static final CronNicknames ANNUALLY = null;
    public static final CronNicknames DAILY = null;
    public static final CronNicknames HOURLY = null;
    public static final CronNicknames MIDNIGHT = null;
    public static final CronNicknames MONTHLY = null;
    public static final CronNicknames REBOOT = null;
    public static final CronNicknames WEEKLY = null;
    public static final CronNicknames YEARLY = null;

    static {
        CronNicknames r0 = new CronNicknames("YEARLY", 0);
        YEARLY = r0;
        CronNicknames r1 = new CronNicknames("ANNUALLY", 1);
        ANNUALLY = r1;
        CronNicknames r3 = new CronNicknames("MONTHLY", 2);
        MONTHLY = r3;
        CronNicknames r5 = new CronNicknames("WEEKLY", 3);
        WEEKLY = r5;
        CronNicknames r7 = new CronNicknames("DAILY", 4);
        DAILY = r7;
        CronNicknames r9 = new CronNicknames("MIDNIGHT", 5);
        MIDNIGHT = r9;
        CronNicknames r11 = new CronNicknames("HOURLY", 6);
        HOURLY = r11;
        CronNicknames r13 = new CronNicknames("REBOOT", 7);
        REBOOT = r13;
        $VALUES = new CronNicknames[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    private CronNicknames(String r1, int r2) {
        super(r1, r2);
    }

    public static CronNicknames valueOf(String r2) {
        return (CronNicknames) ZeusTransformUtils.preCheckCast(Enum.valueOf(CronNicknames.class, r2), CronNicknames.class, "com.obric.memorydata.plugin");
    }

    public static CronNicknames[] values() {
        return (CronNicknames[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), CronNicknames[].class, "com.obric.memorydata.plugin");
    }
}
