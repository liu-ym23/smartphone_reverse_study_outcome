package com.obric.miniapp.calendar.compatibility;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/ReminderEntity$Method;", "", "<init>", "(Ljava/lang/String;I)V", "NOTIFICATION", "ALARM", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReminderEntity$Method extends Enum<ReminderEntity$Method> {
    public static final ReminderEntity$Method ALARM = null;
    public static final ReminderEntity$Method NOTIFICATION = null;
    public static final /* synthetic */ ReminderEntity$Method[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ReminderEntity$Method> getEntries() {
        return b;
    }

    static {
        ReminderEntity$Method r0 = new ReminderEntity$Method("NOTIFICATION", 0);
        NOTIFICATION = r0;
        ReminderEntity$Method r1 = new ReminderEntity$Method("ALARM", 1);
        ALARM = r1;
        ReminderEntity$Method[] r3 = {r0, r1};
        a = r3;
        b = EnumEntriesKt.enumEntries(r3);
    }

    public static ReminderEntity$Method[] values() {
        return (ReminderEntity$Method[]) a.clone();
    }

    public static ReminderEntity$Method valueOf(String r1) {
        return (ReminderEntity$Method) r27.a.a(ReminderEntity$Method.class, r1);
    }

    public ReminderEntity$Method(String r1, int r2) {
        super(r1, r2);
    }
}
