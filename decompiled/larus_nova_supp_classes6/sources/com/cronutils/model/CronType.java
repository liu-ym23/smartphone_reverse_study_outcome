package com.cronutils.model;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final enum CronType extends Enum<CronType> {
    public static final CronType CRON4J = null;
    public static final CronType QUARTZ = null;
    public static final CronType SPRING = null;
    public static final CronType SPRING53 = null;
    public static final CronType UNIX = null;
    public static final /* synthetic */ CronType[] a = null;

    static {
        CronType r0 = new CronType("CRON4J", 0);
        CRON4J = r0;
        CronType r1 = new CronType("QUARTZ", 1);
        QUARTZ = r1;
        CronType r3 = new CronType("UNIX", 2);
        UNIX = r3;
        CronType r5 = new CronType("SPRING", 3);
        SPRING = r5;
        CronType r7 = new CronType("SPRING53", 4);
        SPRING53 = r7;
        a = new CronType[]{r0, r1, r3, r5, r7};
    }

    public static CronType[] values() {
        return (CronType[]) a.clone();
    }

    public static CronType valueOf(String r1) {
        return (CronType) a.a(CronType.class, r1);
    }

    public CronType(String r1, int r2) {
        super(r1, r2);
    }
}
