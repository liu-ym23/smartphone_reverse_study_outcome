package org.sqlite.date;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
public class FastDateFormat extends Format {
    public static final int FULL = 0;
    public static final int LONG = 1;
    public static final int MEDIUM = 2;
    public static final int SHORT = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21057a = null;
    private static final long serialVersionUID = 2;
    private final FastDateParser parser;
    private final FastDatePrinter printer;

    static {
        f21057a = new a();
    }

    public FastDateFormat(String r5, TimeZone r10, Locale r11) {
        this(r5, r10, r11, null);
    }

    public static FastDateFormat getDateInstance(int r5) {
        Integer r10 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(r10, null, null, null);
    }

    public static FastDateFormat getDateTimeInstance(int r5, int r10) {
        Integer r11 = Integer.valueOf(r5);
        Integer r12 = Integer.valueOf(r10);
        return (FastDateFormat) f21057a.a(r11, r12, null, null);
    }

    public static FastDateFormat getInstance() {
        a r5 = f21057a;
        r5.getClass();
        return (FastDateFormat) r5.a(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public static FastDateFormat getTimeInstance(int r5) {
        Integer r10 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(null, r10, null, null);
    }

    public StringBuffer applyRules(Calendar r5, StringBuffer r10) {
        return this.printer.applyRules(r5, r10);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof FastDateFormat) == true) goto L7;
        return false;
    L7:
        return this.printer.equals(((FastDateFormat) r5).printer);
    }

    @Override // java.text.Format
    public StringBuffer format(Object r5, StringBuffer r10, FieldPosition r11) {
        return this.printer.format(r5, r10, r11);
    }

    public Locale getLocale() {
        return this.printer.getLocale();
    }

    public int getMaxLengthEstimate() {
        return this.printer.getMaxLengthEstimate();
    }

    public String getPattern() {
        return this.printer.getPattern();
    }

    public TimeZone getTimeZone() {
        return this.printer.getTimeZone();
    }

    public int hashCode() {
        return this.printer.hashCode();
    }

    public Date parse(String r5) throws ParseException {
        return this.parser.parse(r5);
    }

    @Override // java.text.Format
    public Object parseObject(String r5, ParsePosition r10) {
        return this.parser.parseObject(r5, r10);
    }

    public String toString() {
        return "FastDateFormat[" + this.printer.getPattern() + "," + this.printer.getLocale() + "," + this.printer.getTimeZone().getID() + "]";
    }

    public FastDateFormat(String r5, TimeZone r10, Locale r11, Date r12) {
        this.printer = new FastDatePrinter(r5, r10, r11);
        this.parser = new FastDateParser(r5, r10, r11, r12);
    }

    public String format(long r5) {
        return this.printer.format(r5);
    }

    public Date parse(String r5, ParsePosition r10) {
        return this.parser.parse(r5, r10);
    }

    public String format(Date r5) {
        return this.printer.format(r5);
    }

    public static FastDateFormat getDateInstance(int r5, Locale r10) {
        Integer r11 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(r11, null, null, r10);
    }

    public static FastDateFormat getDateTimeInstance(int r5, int r10, Locale r11) {
        Integer r12 = Integer.valueOf(r5);
        Integer r13 = Integer.valueOf(r10);
        return (FastDateFormat) f21057a.a(r12, r13, null, r11);
    }

    public static FastDateFormat getTimeInstance(int r5, Locale r10) {
        Integer r11 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(null, r11, null, r10);
    }

    public String format(Calendar r5) {
        return this.printer.format(r5);
    }

    public static FastDateFormat getInstance(String r5) {
        return (FastDateFormat) f21057a.b(r5, null, null);
    }

    public StringBuffer format(long r5, StringBuffer r10) {
        return this.printer.format(r5, r10);
    }

    public static FastDateFormat getInstance(String r5, TimeZone r10) {
        return (FastDateFormat) f21057a.b(r5, r10, null);
    }

    public StringBuffer format(Date r5, StringBuffer r10) {
        return this.printer.format(r5, r10);
    }

    public static FastDateFormat getDateInstance(int r5, TimeZone r10) {
        Integer r11 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(r11, null, r10, null);
    }

    public static FastDateFormat getDateTimeInstance(int r5, int r10, TimeZone r11, Locale r12) {
        Integer r13 = Integer.valueOf(r5);
        Integer r14 = Integer.valueOf(r10);
        return (FastDateFormat) f21057a.a(r13, r14, r11, r12);
    }

    public static FastDateFormat getInstance(String r5, Locale r10) {
        return (FastDateFormat) f21057a.b(r5, null, r10);
    }

    public static FastDateFormat getTimeInstance(int r5, TimeZone r10) {
        Integer r11 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(null, r11, r10, null);
    }

    public StringBuffer format(Calendar r5, StringBuffer r10) {
        return this.printer.format(r5, r10);
    }

    public static FastDateFormat getInstance(String r5, TimeZone r10, Locale r11) {
        return (FastDateFormat) f21057a.b(r5, r10, r11);
    }

    public static FastDateFormat getDateInstance(int r5, TimeZone r10, Locale r11) {
        Integer r12 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(r12, null, r10, r11);
    }

    public static FastDateFormat getDateTimeInstance(int r5, int r10, TimeZone r11) {
        return getDateTimeInstance(r5, r10, r11, null);
    }

    public static FastDateFormat getTimeInstance(int r5, TimeZone r10, Locale r11) {
        Integer r12 = Integer.valueOf(r5);
        return (FastDateFormat) f21057a.a(null, r12, r10, r11);
    }
}
