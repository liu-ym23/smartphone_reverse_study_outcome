package com.ss.android.lark.custom.repeat.entity;

import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class CalendarDate implements Serializable {
    private static final long serialVersionUID = 1;
    private GregorianCalendar mGregorianCalendar;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CustomRepeatParams$DayOfWeek.values().length];
            a = r0;
            r0[CustomRepeatParams$DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            a[CustomRepeatParams$DayOfWeek.SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public Date getDate() {
        return this.mGregorianCalendar.getTime();
    }

    public int getHour() {
        return this.mGregorianCalendar.get(11);
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
        GregorianCalendar r0 = this.mGregorianCalendar;
        if (r0 == null) goto L7;
        return r0.getTimeZone();
    L7:
        return TimeZone.getDefault();
    }

    public int getWeekDay() {
        return this.mGregorianCalendar.get(7);
    }

    public int getYear() {
        return this.mGregorianCalendar.get(1);
    }

    public CalendarDate moveToDayStart() {
        CalendarDate r0 = new CalendarDate(this);
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

    public CalendarDate(CalendarDate r2) {
        if (this == r2) goto L6;
        this.mGregorianCalendar = new GregorianCalendar();
        setYear(r2.getYear());
        setMonth(r2.getMonth());
        setMonthDay(r2.getMonthDay());
        setHour(r2.getHour());
        setMinute(r2.getMinute());
        setSecond(r2.getSecond());
        return;
    }

    public CalendarDate addDay(int r3) {
        CalendarDate r0 = new CalendarDate(this);
        r0.add(5, r3);
        return r0;
    }

    public boolean before(CalendarDate r2) {
        return this.mGregorianCalendar.before(r2.mGregorianCalendar);
    }

    public int dayDiff(CalendarDate r2) {
        return getJulianDay() - r2.getJulianDay();
    }

    public int getWeeklyDayIndex(CustomRepeatParams$DayOfWeek r3) {
        int r4 = a.a[r3.ordinal()];
        if (r4 == 1) goto L11;
        if (r4 == 2) goto L9;
        return getWeekDay() - 1;
    L9:
        return ((getWeekDay() - 1) + 1) % 7;
    L11:
        return ((getWeekDay() - 1) + 6) % 7;
    }

    public boolean sameDay(CalendarDate r2) {
        if (getJulianDay() != r2.getJulianDay()) goto L5;
        return true;
    L5:
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
        long r8 = ((r1 + serialVersionUID) * 4000) / 1461001;
        long r2 = (r1 - ((1461 * r8) / 4)) + 31;
        long r10 = (r2 * 80) / 2447;
        int r16 = (int) (r2 - ((2447 * r10) / 80));
        long r3 = r10 / 11;
        int r5 = (int) (((r10 + 2) - (12 * r3)) - serialVersionUID);
        setYear((int) ((((r4 - 49) * 100) + r8) + r3));
        setMonth(r5 + 1);
        setMonthDay(r16);
        setHour(0);
        setMinute(0);
        setSecond(0);
        return this;
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

    public CalendarDate(CalendarDate r2, TimeZone r3) {
        if (this == r2) goto L6;
        this.mGregorianCalendar = new GregorianCalendar(r3);
        setYear(r2.getYear());
        setMonth(r2.getMonth());
        setMonthDay(r2.getMonthDay());
        setHour(r2.getHour());
        setMinute(r2.getMinute());
        setSecond(r2.getSecond());
        return;
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
