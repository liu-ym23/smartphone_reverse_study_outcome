package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes3.dex */
public final enum CalendarMode extends Enum<CalendarMode> {
    public static final CalendarMode MONTHS = null;
    public static final CalendarMode WEEKS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CalendarMode[] f12168a = null;
    final int visibleWeeksCount;

    static {
        CalendarMode r5 = new CalendarMode("MONTHS", 0, 5);
        MONTHS = r5;
        CalendarMode r10 = new CalendarMode("WEEKS", 1, 1);
        WEEKS = r10;
        f12168a = new CalendarMode[]{r5, r10};
    }

    public CalendarMode(String r5, int r10, int r11) {
        super(r5, r10);
        this.visibleWeeksCount = r11;
    }

    public static CalendarMode valueOf(String r5) {
        return (CalendarMode) Enum.valueOf(CalendarMode.class, r5);
    }

    public static CalendarMode[] values() {
        return (CalendarMode[]) f12168a.clone();
    }
}
