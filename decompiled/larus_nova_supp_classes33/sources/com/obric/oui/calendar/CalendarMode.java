package com.obric.oui.calendar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final enum CalendarMode extends Enum<CalendarMode> {
    public static final CalendarMode MONTHS = null;
    public static final CalendarMode WEEKS = null;
    public static final /* synthetic */ CalendarMode[] a = null;
    final int visibleWeeksCount;

    static {
        CalendarMode r0 = new CalendarMode("MONTHS", 0, 5);
        MONTHS = r0;
        CalendarMode r1 = new CalendarMode("WEEKS", 1, 1);
        WEEKS = r1;
        a = new CalendarMode[]{r0, r1};
    }

    public static CalendarMode[] values() {
        return (CalendarMode[]) a.clone();
    }

    public static CalendarMode valueOf(String r1) {
        return (CalendarMode) r27.a.a(CalendarMode.class, r1);
    }

    public CalendarMode(String r1, int r2, int r3) {
        super(r1, r2);
        this.visibleWeeksCount = r3;
    }
}
