package com.obric.miniapp.calendar.compatibility;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/ReminderEntity$TimeType;", "", "<init>", "(Ljava/lang/String;I)V", "minute", "hour", "day", "week", "second", "start_time", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReminderEntity$TimeType extends Enum<ReminderEntity$TimeType> {
    public static final /* synthetic */ ReminderEntity$TimeType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    public static final ReminderEntity$TimeType day = null;
    public static final ReminderEntity$TimeType hour = null;
    public static final ReminderEntity$TimeType minute = null;
    public static final ReminderEntity$TimeType second = null;
    public static final ReminderEntity$TimeType start_time = null;
    public static final ReminderEntity$TimeType week = null;

    public static EnumEntries<ReminderEntity$TimeType> getEntries() {
        return b;
    }

    static {
        ReminderEntity$TimeType r0 = new ReminderEntity$TimeType("minute", 0);
        minute = r0;
        ReminderEntity$TimeType r1 = new ReminderEntity$TimeType("hour", 1);
        hour = r1;
        ReminderEntity$TimeType r3 = new ReminderEntity$TimeType("day", 2);
        day = r3;
        ReminderEntity$TimeType r5 = new ReminderEntity$TimeType("week", 3);
        week = r5;
        ReminderEntity$TimeType r7 = new ReminderEntity$TimeType("second", 4);
        second = r7;
        ReminderEntity$TimeType r9 = new ReminderEntity$TimeType("start_time", 5);
        start_time = r9;
        ReminderEntity$TimeType[] r11 = {r0, r1, r3, r5, r7, r9};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
    }

    public static ReminderEntity$TimeType[] values() {
        return (ReminderEntity$TimeType[]) a.clone();
    }

    public static ReminderEntity$TimeType valueOf(String r1) {
        return (ReminderEntity$TimeType) r27.a.a(ReminderEntity$TimeType.class, r1);
    }

    public ReminderEntity$TimeType(String r1, int r2) {
        super(r1, r2);
    }
}
