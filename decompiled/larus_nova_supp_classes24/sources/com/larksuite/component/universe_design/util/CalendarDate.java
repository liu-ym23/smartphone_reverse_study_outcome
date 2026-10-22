package com.larksuite.component.universe_design.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CalendarDate {
    private Calendar mGregorianCalendar;

    public static final enum DayOfWeek extends Enum<DayOfWeek> {
        public static final DayOfWeek FRIDAY = null;
        public static final DayOfWeek MONDAY = null;
        public static final DayOfWeek SATURDAY = null;
        public static final DayOfWeek SUNDAY = null;
        public static final DayOfWeek THURSDAY = null;
        public static final DayOfWeek TUESDAY = null;
        public static final DayOfWeek WEDNESDAY = null;
        public static final /* synthetic */ DayOfWeek[] a = null;
        private final int value;

        static {
            DayOfWeek r0 = new DayOfWeek("SUNDAY", 0, 0);
            SUNDAY = r0;
            DayOfWeek r1 = new DayOfWeek("MONDAY", 1, 1);
            MONDAY = r1;
            DayOfWeek r3 = new DayOfWeek("TUESDAY", 2, 2);
            TUESDAY = r3;
            DayOfWeek r5 = new DayOfWeek("WEDNESDAY", 3, 3);
            WEDNESDAY = r5;
            DayOfWeek r7 = new DayOfWeek("THURSDAY", 4, 4);
            THURSDAY = r7;
            DayOfWeek r9 = new DayOfWeek("FRIDAY", 5, 5);
            FRIDAY = r9;
            DayOfWeek r11 = new DayOfWeek("SATURDAY", 6, 6);
            SATURDAY = r11;
            a = new DayOfWeek[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static DayOfWeek[] values() {
            return (DayOfWeek[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static DayOfWeek forNumber(int r0) {
            switch(r0) {
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L14;
                case 3: goto L12;
                case 4: goto L10;
                case 5: goto L8;
                case 6: goto L6;
                default: goto L4;
            };
        L4:
            return SUNDAY;
        L6:
            return SATURDAY;
        L8:
            return FRIDAY;
        L10:
            return THURSDAY;
        L12:
            return WEDNESDAY;
        L14:
            return TUESDAY;
        L16:
            return MONDAY;
        L18:
            return SUNDAY;
        }

        public static DayOfWeek valueOf(String r1) {
            return (DayOfWeek) r27.a.a(DayOfWeek.class, r1);
        }

        public static DayOfWeek valueOf(int r0) {
            return forNumber(r0);
        }

        public DayOfWeek(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DayOfWeek.values().length];
            a = r0;
            r0[DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[DayOfWeek.SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public CalendarDate moveThisDateToDayStart() {
        setHour(0);
        setMinute(0);
        setSecond(0);
        return this;
    }

    public int getAMPM() {
        return this.mGregorianCalendar.get(9);
    }

    public Date getDate() {
        return this.mGregorianCalendar.getTime();
    }

    public int getHour() {
        return this.mGregorianCalendar.get(11);
    }

    public int getHourForTwelve() {
        return this.mGregorianCalendar.get(10);
    }

    public int getMilliSecond() {
        return this.mGregorianCalendar.get(14);
    }

    public int getMinute() {
        return this.mGregorianCalendar.get(12);
    }

    public int getMonth() {
        return this.mGregorianCalendar.get(2) + 1;
    }

    public int getMonthDay() {
        return this.mGregorianCalendar.get(5);
    }

    public int getSecond() {
        return this.mGregorianCalendar.get(13);
    }

    public Date getTime() {
        return this.mGregorianCalendar.getTime();
    }

    public long getTimeInMilliSeconds() {
        return this.mGregorianCalendar.getTimeInMillis();
    }

    public long getTimeInSeconds() {
        return this.mGregorianCalendar.getTimeInMillis() / 1000;
    }

    public TimeZone getTimeZone() {
        return this.mGregorianCalendar.getTimeZone();
    }

    public int getWeekDay() {
        return this.mGregorianCalendar.get(7);
    }

    public int getYear() {
        return this.mGregorianCalendar.get(1);
    }

    public int getYearDay() {
        return this.mGregorianCalendar.get(6);
    }

    public CalendarDate moveThisDateToDayEnd() {
        setHour(23);
        setMinute(59);
        setSecond(59);
        return this;
    }

    public CalendarDate moveToDayEnd() {
        CalendarDate r0 = new CalendarDate(this);
        r0.setHour(23);
        r0.setMinute(59);
        r0.setSecond(59);
        return r0;
    }

    public CalendarDate moveToDayStart() {
        CalendarDate r0 = new CalendarDate(this);
        r0.setHour(0);
        r0.setMinute(0);
        r0.setSecond(0);
        return r0;
    }

    public void moveToNow() {
        this.mGregorianCalendar.setTimeInMillis(System.currentTimeMillis());
    }

    public CalendarDate moveToSameDayEnd() {
        CalendarDate r0 = new CalendarDate(this, this.mGregorianCalendar.getTimeZone());
        r0.setHour(23);
        r0.setMinute(59);
        r0.setSecond(59);
        return r0;
    }

    public CalendarDate moveToSameDayStart() {
        CalendarDate r0 = new CalendarDate(this, this.mGregorianCalendar.getTimeZone());
        r0.setHour(0);
        r0.setMinute(0);
        r0.setSecond(0);
        return r0;
    }

    public String toString() {
        return "Year：" + getYear() + " Month:" + getMonth() + " Day:" + getMonthDay() + " Hour:" + getHour() + " Minute:" + getMinute() + " Second:" + getSecond() + " JulianDay:" + getJulianDay();
    }

    public CalendarDate() {
        this.mGregorianCalendar = new GregorianCalendar();
    }

    public int getDayMinutes() {
        return (getHour() * 60) + getMinute();
    }

    public int getJulianDay() {
        int r0 = getYear();
        int r1 = getMonth();
        int r4 = (r1 - 14) / 12;
        return (((((((getYear() + 4800) + r4) * 1461) / 4) + ((((r1 - 2) - (r4 * 12)) * 367) / 12)) - (((((r0 + 4900) + r4) / 100) * 3) / 4)) + getMonthDay()) - 32075;
    }

    public Calendar getCalendar() {
        return this.mGregorianCalendar;
    }

    public CalendarDate(CalendarDate r2) {
        if (this == r2) goto L6;
        this.mGregorianCalendar = new GregorianCalendar();
        setYear(r2.getYear());
        setMonth(r2.getMonth());
        setMonthDay(r2.getMonthDay());
        setHour(r2.getHour());
        setMinute(r2.getMinute());
        setSecond(r2.getSecond());
        setMilliSecond(r2.getMilliSecond());
        return;
    }

    public static CalendarDate getCalendarDate(long r1) {
        return new CalendarDate(new Date(r1));
    }

    public static void roundSecond(CalendarDate r2) {
        if (r2.getSecond() < 30) goto L5;
        r2.setMinute(r2.getMinute() + 1);
    L5:
        r2.setSecond(0);
    }

    public CalendarDate addDay(int r3) {
        CalendarDate r0 = new CalendarDate(this);
        r0.add(5, r3);
        return r0;
    }

    public CalendarDate addMinute(int r3) {
        CalendarDate r0 = new CalendarDate(this);
        r0.add(12, r3);
        return r0;
    }

    public CalendarDate addMonth(int r3) {
        CalendarDate r0 = new CalendarDate(this);
        r0.add(2, r3);
        return r0;
    }

    public CalendarDate addYear(int r3) {
        CalendarDate r0 = new CalendarDate(this);
        r0.add(1, r3);
        return r0;
    }

    public boolean before(CalendarDate r2) {
        return this.mGregorianCalendar.before(r2.mGregorianCalendar);
    }

    public boolean beforeDay(CalendarDate r2) {
        if (getJulianDay() >= r2.getJulianDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public int dayDiff(CalendarDate r2) {
        return getJulianDay() - r2.getJulianDay();
    }

    public CalendarDate getFirstDayOfTheWeek(DayOfWeek r1) {
        return addDay(-getWeeklyDayIndex(r1));
    }

    public int getWeeklyDayIndex(DayOfWeek r3) {
        int r4 = a.a[r3.ordinal()];
        if (r4 == 1) goto L11;
        if (r4 == 2) goto L9;
        return getWeekDay() - 1;
    L9:
        return ((getWeekDay() - 1) + 1) % 7;
    L11:
        return ((getWeekDay() - 1) + 6) % 7;
    }

    public int getYearWeek(DayOfWeek r3) {
        int r4 = a.a[r3.ordinal()];
        if (r4 == 1) goto L7;
        if (r4 == 2) goto L6;
        this.mGregorianCalendar.setFirstDayOfWeek(1);
    L9:
        return this.mGregorianCalendar.get(3);
    L6:
        this.mGregorianCalendar.setFirstDayOfWeek(7);
        goto L9
    L7:
        this.mGregorianCalendar.setFirstDayOfWeek(2);
        goto L9
    }

    public CalendarDate modifyDay(int r17) {
        int r0 = com.larksuite.component.universe_design.util.a.a(getYear(), getMonth() - 1);
        if (r17 > com.larksuite.component.universe_design.util.a.a(getYear(), getMonth())) goto L12;
        if (r17 <= 0) goto L8;
        return new CalendarDate(getYear(), getMonth(), r17, 0, 0, 0);
    L8:
        if (r17 <= (0 - r0)) goto L11;
        return new CalendarDate(getYear(), getMonth(), r0 + r17, 0, 0, 0);
    L11:
        return new CalendarDate(getYear(), getMonth(), getMonthDay(), 0, 0, 0);
    L12:
        return new CalendarDate(getYear(), getMonth(), getMonthDay(), 0, 0, 0);
    }

    public CalendarDate modifyMonth(int r5) {
        CalendarDate r0 = new CalendarDate();
        int r1 = getMonth() + r5;
        int r2 = 12;
        if (r5 <= 0) goto L11;
        if (r1 <= 12) goto L10;
        r0.setYear(getYear() + ((r1 - 1) / 12));
        int r3 = r1 % 12;
        if (r3 == 0) goto L9;
        r2 = r3;
    L9:
        r0.setMonth(r2);
    L23:
        return r0;
    L10:
        r0.setYear(getYear());
        r0.setMonth(r1);
        goto L23
    L11:
        if (r1 != 0) goto L13;
        r0.setYear(getYear() - 1);
        r0.setMonth(12);
        goto L23
    L13:
        if (r1 >= 0) goto L19;
        r0.setYear((getYear() + (r1 / 12)) - 1);
        int r6 = 12 - (Math.abs(r1) % 12);
        if (r6 == 0) goto L18;
        r2 = r6;
    L18:
        r0.setMonth(r2);
        goto L23
    L19:
        r0.setYear(getYear());
        if (r1 != 0) goto L22;
        r1 = 12;
    L22:
        r0.setMonth(r1);
        goto L23
    }

    public CalendarDate modifyWeek(int r2) {
        return new CalendarDate(this).addDay(r2 * 7);
    }

    public int monthDiff(CalendarDate r3) {
        return ((getYear() * 12) + getMonth()) - ((r3.getYear() * 12) + r3.getMonth());
    }

    public boolean sameDay(CalendarDate r2) {
        if (getJulianDay() != r2.getJulianDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean sameDayWithZeroPoint(CalendarDate r8) {
        if (r8.getTimeInSeconds() != r8.moveToSameDayStart().getTimeInSeconds()) goto L12;
        if (getTimeInSeconds() != r8.getTimeInSeconds()) goto L8;
        return true;
    L8:
        if (getJulianDay() != r8.addDay(-1).getJulianDay()) goto L15;
        return true;
    L15:
        return false;
    L12:
        if (getJulianDay() != r8.getJulianDay()) goto L16;
        return true;
    L16:
        return false;
    }

    public void setDayMinutes(int r2) {
        setHour(r2 / 60);
        setMinute(r2 % 60);
    }

    public void setHour(int r3) {
        this.mGregorianCalendar.set(11, r3);
    }

    public CalendarDate setJulianDay(int r15) {
        long r0 = r15 + 68569;
        long r4 = (r0 * 4) / 146097;
        long r1 = r0 - (((146097 * r4) + 3) / 4);
        long r8 = ((r1 + 1) * 4000) / 1461001;
        long r2 = (r1 - ((1461 * r8) / 4)) + 31;
        long r10 = (r2 * 80) / 2447;
        int r16 = (int) (r2 - ((2447 * r10) / 80));
        long r3 = r10 / 11;
        setYear((int) ((((r4 - 49) * 100) + r8) + r3));
        setMonth(((int) (((r10 + 2) - (12 * r3)) - 1)) + 1);
        setMonthDay(r16);
        setHour(0);
        setMinute(0);
        setSecond(0);
        return this;
    }

    public void setMilliSecond(int r3) {
        this.mGregorianCalendar.set(14, r3);
    }

    public void setMinute(int r3) {
        this.mGregorianCalendar.set(12, r3);
    }

    public void setMonth(int r3) {
        this.mGregorianCalendar.set(2, r3 - 1);
    }

    public void setMonthDay(int r3) {
        this.mGregorianCalendar.set(5, r3);
    }

    public void setSecond(int r3) {
        this.mGregorianCalendar.set(13, r3);
    }

    public CalendarDate setTimeInMillis(long r2) {
        this.mGregorianCalendar.setTimeInMillis(r2);
        return this;
    }

    public CalendarDate setTimeInSeconds(long r4) {
        this.mGregorianCalendar.setTimeInMillis(r4 * 1000);
        return this;
    }

    public void setTimeZone(TimeZone r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.mGregorianCalendar.setTimeZone(r2);
    }

    public void setYear(int r3) {
        this.mGregorianCalendar.set(1, r3);
    }

    public CalendarDate(Date r2) {
        GregorianCalendar r0 = new GregorianCalendar();
        this.mGregorianCalendar = r0;
        r0.setTime(r2);
    }

    public CalendarDate(TimeZone r2) {
        this.mGregorianCalendar = new GregorianCalendar(r2);
    }

    public CalendarDate(Calendar r1) {
        this.mGregorianCalendar = r1;
    }

    public CalendarDate(CalendarDate r2, TimeZone r3) {
        if (this == r2) goto L6;
        this.mGregorianCalendar = new GregorianCalendar(r3);
        setYear(r2.getYear());
        setMonth(r2.getMonth());
        setMonthDay(r2.getMonthDay());
        setHour(r2.getHour());
        setMinute(r2.getMinute());
        setSecond(r2.getSecond());
        setMilliSecond(r2.getMilliSecond());
        return;
    }

    public static CalendarDate getCalendarDate(long r1, TimeZone r3) {
        return new CalendarDate(new Date(r1), r3);
    }

    public void add(int r2, int r3) {
        this.mGregorianCalendar.add(r2, r3);
    }

    public CalendarDate(Date r2, TimeZone r3) {
        GregorianCalendar r0 = new GregorianCalendar(r3);
        this.mGregorianCalendar = r0;
        r0.setTime(r2);
    }

    public CalendarDate(int r2, int r3, int r4, int r5, int r6, int r7) {
        this.mGregorianCalendar = new GregorianCalendar();
        setYear(r2);
        setMonth(r3);
        setMonthDay(r4);
        setHour(r5);
        setMinute(r6);
        setSecond(r7);
    }
}
