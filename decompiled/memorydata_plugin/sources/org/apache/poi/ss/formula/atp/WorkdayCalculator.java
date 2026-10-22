package org.apache.poi.ss.formula.atp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.util.LocaleUtil;

/* JADX INFO: loaded from: classes7.dex */
public class WorkdayCalculator {
    private static final Set<Integer> friSatWeekend = null;
    private static final Set<Integer> friWeekend = null;
    public static final WorkdayCalculator instance = null;
    private static final Set<Integer> monTuesWeekend = null;
    private static final Set<Integer> monWeekend = null;
    private static final Set<Integer> satWeekend = null;
    private static final Set<Integer> standardWeekend = null;
    private static final Set<Integer> sunMonWeekend = null;
    private static final Set<Integer> sunWeekend = null;
    private static final Set<Integer> thursFriWeekend = null;
    private static final Set<Integer> thursWeekend = null;
    private static final Set<Integer> tuesWedsWeekend = null;
    private static final Set<Integer> tuesWeekend = null;
    private static final Set<Integer> wedsThursWeekend = null;
    private static final Set<Integer> wedsWeekend = null;
    private static final Map<Integer, Set<Integer>> weekendTypeMap = null;

    static {
        instance = new WorkdayCalculator();
        HashSet r0 = new HashSet(Arrays.asList(new Integer[]{7, 1}));
        standardWeekend = r0;
        HashSet r3 = new HashSet(Arrays.asList(new Integer[]{1, 2}));
        sunMonWeekend = r3;
        HashSet r8 = new HashSet(Arrays.asList(new Integer[]{2, 3}));
        monTuesWeekend = r8;
        HashSet r9 = new HashSet(Arrays.asList(new Integer[]{3, 4}));
        tuesWedsWeekend = r9;
        HashSet r11 = new HashSet(Arrays.asList(new Integer[]{4, 5}));
        wedsThursWeekend = r11;
        HashSet r13 = new HashSet(Arrays.asList(new Integer[]{5, 6}));
        thursFriWeekend = r13;
        HashSet r15 = new HashSet(Arrays.asList(new Integer[]{6, 7}));
        friSatWeekend = r15;
        Set<Integer> r1 = Collections.singleton(2);
        monWeekend = r1;
        Set<Integer> r6 = Collections.singleton(3);
        tuesWeekend = r6;
        Set<Integer> r7 = Collections.singleton(4);
        wedsWeekend = r7;
        Set<Integer> r10 = Collections.singleton(5);
        thursWeekend = r10;
        Set<Integer> r12 = Collections.singleton(6);
        friWeekend = r12;
        Set<Integer> r14 = Collections.singleton(7);
        satWeekend = r14;
        Set<Integer> r16 = Collections.singleton(1);
        sunWeekend = r16;
        HashMap r2 = new HashMap();
        weekendTypeMap = r2;
        r2.put(1, r0);
        r2.put(2, r3);
        r2.put(3, r8);
        r2.put(4, r9);
        r2.put(5, r11);
        r2.put(6, r13);
        r2.put(7, r15);
        r2.put(11, r16);
        r2.put(12, r1);
        r2.put(13, r6);
        r2.put(14, r7);
        r2.put(15, r10);
        r2.put(16, r12);
        r2.put(17, r14);
    }

    private WorkdayCalculator() {
    }

    private boolean isWeekend(Calendar r2) {
        return isWeekend(r2, standardWeekend);
    }

    private boolean isWeekend(Calendar r2, Set<Integer> r3) {
        return ((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin")).contains(Integer.valueOf(r2.get(7)));
    }

    public int calculateNonWeekendHolidays(double r21, double r23, double[] r25) {
        double[] r4 = r25;
        double r12 = Math.min(r21, r23);
        double r14 = Math.max(r23, r21);
        int r10 = r4.length;
        int r8 = 0;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L12;
        double r6 = r4[r11];
        int r5 = r8;
        int r18 = r10;
        int r19 = r11;
        if (isInARange(r12, r14, r6) == false) goto L10;
        if (isWeekend(r6) == true) goto L10;
        r8 = r5 + 1;
    L11:
        r11 = r19 + 1;
        r4 = r25;
        r10 = r18;
    L10:
        r8 = r5;
        goto L11
    L12:
        int r7 = r8;
        if (r21 > r23) goto L16;
        return r7;
    L16:
        return -r7;
    }

    public int calculateWorkdays(double r10, double r12, double[] r14) {
        Set<Integer> r0 = standardWeekend;
        Integer[] r1 = (Integer[]) ZeusTransformUtils.preCheckCast(r0.toArray(new Integer[r0.size()]), Integer[].class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r1.length != 0) goto L5;
        int r3 = 0;
    L7:
        if (r1.length <= 1) goto L11;
        r2 = pastDaysOfWeek(r10, r12, r1[1].intValue());
    L11:
        return ((((int) ((r12 - r10) + 1.0d)) - r3) - r2) - calculateNonWeekendHolidays(r10, r12, r14);
    L5:
        r3 = pastDaysOfWeek(r10, r12, r1[0].intValue());
        goto L7
    }

    public Date calculateWorkdays(double r6, int r8, int r9, double[] r10) {
        Set<Integer> r11 = (Set) ZeusTransformUtils.preCheckCast(weekendTypeMap.getOrDefault(Integer.valueOf(r9), standardWeekend), Set.class, "com.obric.memorydata.plugin");
        Date r7 = DateUtil.getJavaDate(r6);
        if (r8 >= 0) goto L5;
        int r12 = -1;
    L6:
        Calendar r0 = LocaleUtil.getLocaleCalendar();
        r0.setTime(r7);
        double r1 = DateUtil.getExcelDate(r0.getTime());
    L7:
        if (r8 == 0) goto L14;
        r0.add(6, r12);
        r1 = r1 + ((double) r12);
        if (isWeekend(r0, r11) == true) goto L7;
        if (isHoliday(r1, r10) == true) goto L7;
        r8 = r8 - r12;
        goto L7
    L14:
        return r0.getTime();
    L5:
        r12 = 1;
        goto L6
    }

    public Date calculateWorkdays(double r7, int r9, double[] r10) {
        return calculateWorkdays(r7, r9, 1, r10);
    }

    public Set<Integer> getValidWeekendTypes() {
        return weekendTypeMap.keySet();
    }

    public boolean isHoliday(double r7, double[] r9) {
        int r6 = r9.length;
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L9;
        if (Math.round(r9[r1]) == Math.round(r7)) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    public boolean isInARange(double r1, double r3, double r5) {
        if (r5 >= r1) goto L5;
    L7:
        return false;
    L5:
        if (r5 > r3) goto L7;
        return true;
    }

    public boolean isWeekend(double r2) {
        Calendar r0 = LocaleUtil.getLocaleCalendar();
        r0.setTime(DateUtil.getJavaDate(r2));
        return isWeekend(r0);
    }

    public int pastDaysOfWeek(double r6, double r8, int r10) {
        int r5 = (int) Math.floor(Math.min(r6, r8));
        int r0 = (int) Math.floor(Math.max(r8, r6));
        int r1 = 0;
    L3:
        if (r5 > r0) goto L9;
        Calendar r2 = LocaleUtil.getLocaleCalendar();
        r2.setTime(DateUtil.getJavaDate(r5));
        if (r2.get(7) != r10) goto L7;
        r1 = r1 + 1;
    L7:
        r5 = r5 + 1;
        goto L3
    L9:
        if (r6 > r8) goto L12;
        return r1;
    L12:
        return -r1;
    }
}
