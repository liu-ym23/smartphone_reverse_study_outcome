package com.cronutils.model.field.expression;

import com.cronutils.mapper.WeekDay;
import com.cronutils.mapper.a;
import com.cronutils.model.definition.CronDefinition;
import com.cronutils.model.field.CronFieldName;
import com.cronutils.model.field.definition.DayOfWeekFieldDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public final enum Weekdays extends Enum<Weekdays> {
    private static final /* synthetic */ Weekdays[] $VALUES = null;
    public static final Weekdays FRIDAY = null;
    public static final Weekdays MONDAY = null;
    public static final Weekdays SATURDAY = null;
    public static final Weekdays SUNDAY = null;
    public static final Weekdays THURSDAY = null;
    public static final Weekdays TUESDAY = null;
    public static final Weekdays WEDNESDAY = null;
    private int weekday;

    static {
        Weekdays r0 = new Weekdays("MONDAY", 0, 1);
        MONDAY = r0;
        Weekdays r1 = new Weekdays("TUESDAY", 1, 2);
        TUESDAY = r1;
        Weekdays r4 = new Weekdays("WEDNESDAY", 2, 3);
        WEDNESDAY = r4;
        Weekdays r6 = new Weekdays("THURSDAY", 3, 4);
        THURSDAY = r6;
        Weekdays r8 = new Weekdays("FRIDAY", 4, 5);
        FRIDAY = r8;
        Weekdays r10 = new Weekdays("SATURDAY", 5, 6);
        SATURDAY = r10;
        Weekdays r12 = new Weekdays("SUNDAY", 6, 7);
        SUNDAY = r12;
        $VALUES = new Weekdays[]{r0, r1, r4, r6, r8, r10, r12};
    }

    private Weekdays(String r1, int r2, int r3) {
        super(r1, r2);
        this.weekday = r3;
    }

    public static Weekdays valueOf(String r2) {
        return (Weekdays) ZeusTransformUtils.preCheckCast(Enum.valueOf(Weekdays.class, r2), Weekdays.class, "com.obric.memorydata.plugin");
    }

    public static Weekdays[] values() {
        return (Weekdays[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Weekdays[].class, "com.obric.memorydata.plugin");
    }

    public int getWeekday() {
        return getWeekday(a.c);
    }

    public int getWeekday(WeekDay r2) {
        return a.a(a.c, r2, this.weekday);
    }

    public int getWeekday(CronDefinition r3) {
        return getWeekday(((DayOfWeekFieldDefinition) ZeusTransformUtils.preCheckCast(r3.getFieldDefinition(CronFieldName.DAY_OF_WEEK), DayOfWeekFieldDefinition.class, "com.obric.memorydata.plugin")).getMondayDoWValue());
    }
}
