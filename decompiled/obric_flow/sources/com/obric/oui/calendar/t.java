package com.obric.oui.calendar;

import java.time.DayOfWeek;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f12295a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f12296b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f12297c = null;

    static {
        int[] r5 = new int[ODatePickerView.OutOfMonthVisibility.values().length];
        r5[ODatePickerView.OutOfMonthVisibility.HIDE.ordinal()] = 1;
        r5[ODatePickerView.OutOfMonthVisibility.GREY.ordinal()] = 2;
        f12295a = r5;
        int[] r10 = new int[DayOfWeek.values().length];
        r10[DayOfWeek.SUNDAY.ordinal()] = 1;
        r10[DayOfWeek.MONDAY.ordinal()] = 2;
        r10[DayOfWeek.TUESDAY.ordinal()] = 3;
        r10[DayOfWeek.WEDNESDAY.ordinal()] = 4;
        r10[DayOfWeek.THURSDAY.ordinal()] = 5;
        r10[DayOfWeek.FRIDAY.ordinal()] = 6;
        r10[DayOfWeek.SATURDAY.ordinal()] = 7;
        f12296b = r10;
        int[] r11 = new int[ODatePickerView.DatePickerMode.values().length];
        r11[ODatePickerView.DatePickerMode.BOARD_SHEET.ordinal()] = 1;
        r11[ODatePickerView.DatePickerMode.NARROW_SHEET.ordinal()] = 2;
        f12297c = r11;
    }
}
