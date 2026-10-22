package org.apache.poi.ss.formula.atp;

import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.WifiScanStateMachine;
import java.util.Calendar;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
final class YearFracCalculator {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static final class SimpleDate {
        public final int day;
        public final int month;
        public final long tsMilliseconds;
        public final int year;

        public SimpleDate(Calendar r3) {
            this.year = r3.get(1);
            this.month = r3.get(2) + 1;
            this.day = r3.get(5);
            this.tsMilliseconds = r3.getTimeInMillis();
        }
    }

    static {
    }

    private YearFracCalculator() {
    }

    private static double averageYearLength(int r3, int r4) {
        int r0 = 0;
        int r1 = r3;
    L3:
        if (r1 > r4) goto L10;
        if (isLeapYear(r1) == false) goto L7;
        int r2 = 366;
    L8:
        r0 = r0 + r2;
        r1 = r1 + 1;
        goto L3
    L7:
        r2 = 365;
        goto L8
    L10:
        return r0 / (((double) (r4 - r3)) + 1.0d);
    }

    private static double basis0(int r5, int r6) {
        SimpleDate r7 = createDate(r5);
        SimpleDate r8 = createDate(r6);
        int r0 = r7.day;
        int r1 = r8.day;
        if (r0 != 31) goto L6;
        if (r1 != 31) goto L6;
    L5:
        r0 = 30;
        r1 = 30;
    L21:
        return calculateAdjusted(r7, r8, r0, r1);
    L6:
        if (r0 != 31) goto L8;
    L7:
        r0 = 30;
        goto L21
    L8:
        if (r0 != 30) goto L12;
        if (r1 != 31) goto L12;
        r1 = 30;
    L12:
        if (r7.month != 2) goto L21;
        if (isLastDayOfMonth(r7) == false) goto L21;
        if (r8.month != 2) goto L7;
        if (isLastDayOfMonth(r8) == false) goto L7;
        goto L7
    }

    private static double basis1(int r4, int r5) {
        SimpleDate r6 = createDate(r4);
        SimpleDate r7 = createDate(r5);
        if (isGreaterThanOneYear(r6, r7) == false) goto L6;
        double r0 = averageYearLength(r6.year, r7.year);
    L10:
        return ((double) dateDiff(r6.tsMilliseconds, r7.tsMilliseconds)) / r0;
    L6:
        if (shouldCountFeb29(r6, r7) == false) goto L8;
        r0 = 366.0d;
        goto L10
    L8:
        r0 = 365.0d;
        goto L10
    }

    private static double basis2(int r2, int r3) {
        return ((double) (r3 - r2)) / 360.0d;
    }

    private static double basis3(double r0, double r2) {
        return (r2 - r0) / 365.0d;
    }

    private static double basis4(int r4, int r5) {
        SimpleDate r6 = createDate(r4);
        SimpleDate r7 = createDate(r5);
        int r0 = r6.day;
        int r1 = r7.day;
        if (r0 != 31) goto L5;
        r0 = 30;
    L5:
        if (r1 != 31) goto L8;
        r1 = 30;
    L8:
        return calculateAdjusted(r6, r7, r0, r1);
    }

    public static double calculate(double r2, double r4, int r6) {
        if (r6 < 0) goto L33;
        if (r6 >= 5) goto L33;
        int r3 = (int) Math.floor(r2);
        int r5 = (int) Math.floor(r4);
        if (r3 != r5) goto L9;
        return 0.0d;
    L9:
        if (r3 <= r5) goto L11;
        r5 = r3;
        r3 = r5;
    L11:
        if (r6 == 0) goto L31;
        if (r6 == 1) goto L29;
        if (r6 == 2) goto L27;
        if (r6 == 3) goto L25;
        if (r6 != 4) goto L23;
        return basis4(r3, r5);
    L23:
        throw new IllegalStateException("cannot happen");
    L25:
        return basis3(r3, r5);
    L27:
        return basis2(r3, r5);
    L29:
        return basis1(r3, r5);
    L31:
        return basis0(r3, r5);
    L33:
        throw new EvaluationException(ErrorEval.NUM_ERROR);
    }

    private static double calculateAdjusted(SimpleDate r6, SimpleDate r7, int r8, int r9) {
        return (((((double) (r7.year - r6.year)) * 360.0d) + (((double) (r7.month - r6.month)) * 30.0d)) + (((double) (r9 - r8)) * 1.0d)) / 360.0d;
    }

    private static SimpleDate createDate(int r2) {
        Calendar r0 = LocaleUtil.getLocaleCalendar(LocaleUtil.TIMEZONE_UTC);
        DateUtil.setCalendar(r0, r2, 0, false, false);
        return new SimpleDate(r0);
    }

    private static int dateDiff(long r6, long r8) {
        long r0 = r8 - r6;
        if (((int) ((r0 % WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) / ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS)) != 0) goto L7;
        return (int) ((r0 / 8.64E7d) + 0.5d);
    L7:
        throw new RuntimeException("Unexpected date diff between " + r6 + " and " + r8);
    }

    private static int getLastDayOfMonth(SimpleDate r1) {
        switch(r1.month) {
            case 1: goto L10;
            case 2: goto L5;
            case 3: goto L10;
            case 4: goto L8;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L10;
            case 8: goto L10;
            case 9: goto L8;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L10;
            default: goto L5;
        };
    L8:
        return 30;
    L10:
        return 31;
    L5:
        if (isLeapYear(r1.year) == false) goto L12;
        return 29;
    L12:
        return 28;
    }

    private static boolean isGreaterThanOneYear(SimpleDate r4, SimpleDate r5) {
        if (r4.year != r5.year) goto L6;
        return false;
    L6:
        if ((r4.year + 1) == r5.year) goto L9;
        return true;
    L9:
        if (r4.month <= r5.month) goto L12;
        return false;
    L12:
        if (r4.month >= r5.month) goto L15;
        return true;
    L15:
        if (r4.day < r5.day) goto L17;
        return false;
    L17:
        return true;
    }

    private static boolean isLastDayOfMonth(SimpleDate r3) {
        if (r3.day >= 28) goto L6;
        return false;
    L6:
        if (r3.day != getLastDayOfMonth(r3)) goto L9;
        return true;
    L9:
        return false;
    }

    private static boolean isLeapYear(int r3) {
        if ((r3 % 4) == 0) goto L6;
        return false;
    L6:
        if ((r3 % 400) != 0) goto L9;
        return true;
    L9:
        if ((r3 % 100) != 0) goto L11;
        return false;
    L11:
        return true;
    }

    private static boolean shouldCountFeb29(SimpleDate r4, SimpleDate r5) {
        if (isLeapYear(r4.year) == false) goto L13;
        if (r4.year != r5.year) goto L7;
        return true;
    L7:
        int r6 = r4.month;
        if (r6 == 1) goto L11;
        if (r6 == 2) goto L11;
        return false;
    L11:
        return true;
    L13:
        if (isLeapYear(r5.year) == false) goto L22;
        int r7 = r5.month;
        if (r7 == 1) goto L23;
        if (r7 == 2) goto L19;
        return true;
    L19:
        if (r5.day == 29) goto L21;
        return false;
    L21:
        return true;
    L23:
        return false;
    L22:
        return false;
    }
}
