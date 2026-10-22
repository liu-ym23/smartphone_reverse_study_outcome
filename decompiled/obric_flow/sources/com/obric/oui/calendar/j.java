package com.obric.oui.calendar;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f12282a = null;

    static {
        int[] r5 = new int[CalendarMode.values().length];
        f12282a = r5;
        r5[CalendarMode.MONTHS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
    L8:
        f12282a[CalendarMode.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
        return;
    }
}
