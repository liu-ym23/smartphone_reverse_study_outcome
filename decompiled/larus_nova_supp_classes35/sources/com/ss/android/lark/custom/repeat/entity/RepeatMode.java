package com.ss.android.lark.custom.repeat.entity;

import android.text.format.Time;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.custom.repeat.CustomRepeatParams$DayOfWeek;
import com.ss.android.lark.utils.UIHelper;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class RepeatMode implements Serializable {
    public static final int TYPE_CUSTOM_BYDAY = 7;
    public static final int TYPE_CUSTOM_BYMONTHDAY = 9;
    public static final int TYPE_CUSTOM_BYMONTHWEEK = 10;
    public static final int TYPE_CUSTOM_BYWEEK = 8;
    public static final int TYPE_CUSTOM_BYYEAR = 11;
    public static final int TYPE_DAILY = 1;
    public static final int TYPE_MONTHLY = 4;
    public static final int TYPE_NONE = 0;
    public static final int TYPE_TWO_WEEK = 3;
    public static final int TYPE_WEEKLY = 2;
    public static final int TYPE_WORKDAY = 6;
    public static final int TYPE_YEARLY = 5;
    private static final long serialVersionUID = 1;
    private List<Integer> mCustomerByMonthDay;
    private String mCustomerByMonthWeekDay;
    private String mCustomerByMonthWeekNo;
    private List<Integer> mCustomerByWeek;
    private int mFrequency;
    private int mInterval;
    private boolean mIsSingleInMonth;
    private boolean mIsSingleInWeek;
    private String[] mMonthlyDay;
    private int mRepeatType;
    private CalendarDate mUntilDate;
    private String[] mWeekNo;
    private CustomRepeatParams$DayOfWeek mWeekStartDay;
    private String[] mWeeks;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[CustomRepeatParams$DayOfWeek.values().length];
            a = r0;
            r0[CustomRepeatParams$DayOfWeek.MONDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[CustomRepeatParams$DayOfWeek.TUESDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[CustomRepeatParams$DayOfWeek.WEDNESDAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[CustomRepeatParams$DayOfWeek.THURSDAY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[CustomRepeatParams$DayOfWeek.FRIDAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[CustomRepeatParams$DayOfWeek.SATURDAY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static int a(int r0) {
        switch(r0) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        return 4194304;
    L7:
        return Bridge.TRANSFER_MAX_SIZE;
    L9:
        return 1048576;
    L11:
        return 524288;
    L13:
        return 262144;
    L15:
        return 131072;
    L17:
        return 65536;
    }

    public static int b(int r1) {
        if (r1 != 65536) goto L5;
        return 0;
    L5:
        if (r1 != 131072) goto L7;
        return 1;
    L7:
        if (r1 != 262144) goto L9;
        return 2;
    L9:
        if (r1 != 524288) goto L11;
        return 3;
    L11:
        if (r1 != 1048576) goto L13;
        return 4;
    L13:
        if (r1 != 2097152) goto L15;
        return 5;
    L15:
        if (r1 == 4194304) goto L18;
        return -1;
    L18:
        return 6;
    }

    public void clearRule() {
        this.mRepeatType = 0;
        this.mFrequency = 0;
        this.mInterval = 0;
        this.mCustomerByWeek = null;
        this.mCustomerByMonthDay = null;
        this.mCustomerByMonthWeekDay = BuildConfig.FLAVOR;
        this.mCustomerByMonthWeekNo = BuildConfig.FLAVOR;
    }

    public EventRecurrence toER() {
        EventRecurrence r0 = new EventRecurrence();
        r0.a = this.mFrequency;
        r0.d = this.mInterval;
        int r2 = 0;
        switch(this.mRepeatType) {
            case 6: goto L30;
            case 7: goto L49;
            case 8: goto L30;
            case 9: goto L22;
            case 10: goto L5;
            default: goto L49;
        };
    L5:
        r0.n = 1;
        r0.l = new int[1];
        int[] r1 = new int[1];
        r0.m = r1;
        String r4 = this.mCustomerByMonthWeekNo;
        int r5 = 0;
    L6:
        String[] r6 = this.mWeekNo;
        int r8 = -1;
        if (r5 >= r6.length) goto L12;
        if (r6[r5].equals(r4) == true) goto L10;
        r5 = r5 + 1;
        goto L6
    L10:
        int r7 = r5 + 1;
    L13:
        r1[0] = r7;
        int[] r3 = r0.l;
        String r9 = this.mCustomerByMonthWeekDay;
        int r10 = 0;
    L14:
        String[] r11 = this.mWeeks;
        if (r10 >= r11.length) goto L20;
        if (r11[r10].equals(r9) == true) goto L18;
        r10 = r10 + 1;
        goto L14
    L18:
        r8 = a(r10);
    L20:
        r3[0] = r8;
        goto L49
    L12:
        r7 = -1;
        goto L13
    L22:
        if (CollectionUtils.isNotEmpty(this.mCustomerByMonthDay) == false) goto L24;
        int r12 = this.mCustomerByMonthDay.size();
    L25:
        r0.p = r12;
        r0.o = new int[r12];
    L27:
        if (r2 >= r0.p) goto L49;
        r0.o[r2] = ((Integer) ListProtector.get(this.mCustomerByMonthDay, r2)).intValue();
        r2 = r2 + 1;
        goto L27
    L24:
        r12 = 0;
        goto L25
    L30:
        if (CollectionUtils.isNotEmpty(this.mCustomerByWeek) == false) goto L32;
        int r13 = this.mCustomerByWeek.size();
    L33:
        r0.n = r13;
        r0.l = new int[r13];
        r0.m = new int[r13];
        int r14 = 0;
    L35:
        if (r14 >= r0.n) goto L38;
        r0.m[r14] = 0;
        r0.l[r14] = a(((Integer) ListProtector.get(this.mCustomerByWeek, r14)).intValue());
        r14 = r14 + 1;
        goto L35
    L38:
        if (this.mInterval <= 1) goto L49;
        switch(a.a[this.mWeekStartDay.ordinal()]) {
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L43;
            case 6: goto L42;
            default: goto L41;
        };
    L41:
        r0.e = 65536;
        goto L49
    L42:
        r0.e = 4194304;
        goto L49
    L43:
        r0.e = Bridge.TRANSFER_MAX_SIZE;
        goto L49
    L44:
        r0.e = 1048576;
        goto L49
    L45:
        r0.e = 524288;
        goto L49
    L46:
        r0.e = 262144;
        goto L49
    L47:
        r0.e = 131072;
        goto L49
    L32:
        r13 = 0;
    L49:
        if (this.mUntilDate == null) goto L51;
        Time r15 = new Time();
        r15.set(this.mUntilDate.getMonthDay(), this.mUntilDate.getMonth() - 1, this.mUntilDate.getYear());
        r0.b = r15.format2445();
    L51:
        return r0;
    }

    public String toString() {
        return "repeatType: " + this.mRepeatType + " mFrequency: " + this.mFrequency + " mInterval: " + this.mInterval;
    }

    public RepeatMode() {
        this.mIsSingleInWeek = false;
        this.mIsSingleInMonth = false;
        this.mWeekStartDay = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.mRepeatType = 0;
        this.mWeeks = UIHelper.getStringArray(2130903138);
        this.mWeekNo = UIHelper.getStringArray(2130903134);
        this.mMonthlyDay = UIHelper.getStringArray(2130903051);
    }

    public List<Integer> getCustomerByMonthDayList() {
        return this.mCustomerByMonthDay;
    }

    public List<Integer> getCustomerByWeekList() {
        return this.mCustomerByWeek;
    }

    public int getRepeatType() {
        return this.mRepeatType;
    }

    public CustomRepeatParams$DayOfWeek getWeekStartDay() {
        return this.mWeekStartDay;
    }

    public boolean isSingleInMonth() {
        return this.mIsSingleInMonth;
    }

    public boolean isSingleInWeek() {
        return this.mIsSingleInWeek;
    }

    public RepeatMode(EventRecurrence r12) {
        int r0 = 0;
        this.mIsSingleInWeek = false;
        this.mIsSingleInMonth = false;
        this.mWeekStartDay = CustomRepeatParams$DayOfWeek.SUNDAY;
        this.mWeeks = UIHelper.getStringArray(2130903138);
        this.mWeekNo = UIHelper.getStringArray(2130903134);
        this.mMonthlyDay = UIHelper.getStringArray(2130903051);
        int r1 = r12.a;
        this.mFrequency = r1;
        int r2 = r12.d;
        this.mInterval = r2;
        if (r1 != 4) goto L8;
        if (r2 > 1) goto L6;
        this.mRepeatType = 1;
    L50:
        if (r12.b == null) goto L57;
        Time r3 = new Time();
        r3.parse(r12.b);
        this.mUntilDate = new CalendarDate(r3.year, r3.month + 1, r3.monthDay, r3.hour, r3.minute, 0);
        return;
    L57:
        return;
    L6:
        this.mRepeatType = 7;
        goto L50
    L8:
        if (r1 == 5) goto L10;
        if (r1 == 6) goto L33;
        if (r1 != 7) goto L50;
        if (r2 > 1) goto L48;
        this.mRepeatType = 5;
        goto L50
    L48:
        this.mRepeatType = 11;
        goto L50
    L33:
        if (r12.n <= 0) goto L39;
        this.mRepeatType = 10;
        int r4 = r12.m[0] - 1;
        if (r4 >= 0) goto L37;
        r4 = 0;
    L37:
        this.mCustomerByMonthWeekNo = this.mWeekNo[r4];
        this.mCustomerByMonthWeekDay = this.mWeeks[b(r12.l[0])];
        goto L50
    L39:
        if (r12.p <= 0) goto L44;
        this.mRepeatType = 9;
        this.mCustomerByMonthDay = new ArrayList();
    L42:
        if (r0 >= r12.p) goto L50;
        this.mCustomerByMonthDay.add(Integer.valueOf(r12.o[r0]));
        r0 = r0 + 1;
        goto L42
    L44:
        this.mRepeatType = 4;
        goto L50
    L10:
        if (r12.n <= 0) goto L26;
        this.mRepeatType = 8;
        this.mCustomerByWeek = new ArrayList();
        int r5 = 0;
    L13:
        if (r5 >= r12.n) goto L16;
        this.mCustomerByWeek.add(Integer.valueOf(b(r12.l[r5])));
        r5 = r5 + 1;
        goto L13
    L16:
        if (this.mCustomerByWeek.size() != 5) goto L50;
        Collections.sort(this.mCustomerByWeek);
    L18:
        if (r0 >= 5) goto L23;
        int r6 = r0 + 1;
        if (((Integer) ListProtector.get(this.mCustomerByWeek, r0)).intValue() != r6) goto L23;
        r0 = r6;
    L23:
        if (r0 != 5) goto L50;
        this.mRepeatType = 6;
        goto L50
    L26:
        if (r2 > 1) goto L28;
        this.mRepeatType = 2;
        goto L50
    L28:
        if (r2 != 2) goto L30;
        this.mRepeatType = 3;
        goto L50
    L30:
        this.mRepeatType = 8;
        goto L50
    }

    public void addMonthList(int r3) {
        if (this.mCustomerByMonthDay != null) goto L6;
        this.mCustomerByMonthDay = new ArrayList();
    L6:
        if (this.mCustomerByMonthDay.contains(Integer.valueOf(r3)) == true) goto L9;
        this.mCustomerByMonthDay.add(Integer.valueOf(r3));
        Collections.sort(this.mCustomerByMonthDay);
        return;
    }

    public void addWeekList(int r3) {
        if (this.mCustomerByWeek != null) goto L6;
        this.mCustomerByWeek = new ArrayList();
    L6:
        if (this.mCustomerByWeek.contains(Integer.valueOf(r3)) == true) goto L9;
        this.mCustomerByWeek.add(Integer.valueOf(r3));
        Collections.sort(this.mCustomerByWeek);
        return;
    }

    public boolean containsMonthDay(int r2) {
        if (CollectionUtils.isEmpty(this.mCustomerByMonthDay) == false) goto L7;
        return false;
    L7:
        return this.mCustomerByMonthDay.contains(Integer.valueOf(r2));
    }

    public boolean containsWeekDay(int r2) {
        if (CollectionUtils.isEmpty(this.mCustomerByWeek) == false) goto L7;
        return false;
    L7:
        return this.mCustomerByWeek.contains(Integer.valueOf(r2));
    }

    public String getWeekDay(int r3) {
        if (r3 < 0) goto L8;
        String[] r0 = this.mWeeks;
        if (r3 < r0.length) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0[r3];
    L8:
        return BuildConfig.FLAVOR;
    }

    public String getWeekNo(int r3) {
        if (r3 < 0) goto L8;
        String[] r0 = this.mWeekNo;
        if (r3 < r0.length) goto L7;
        return BuildConfig.FLAVOR;
    L7:
        return r0[r3];
    L8:
        return BuildConfig.FLAVOR;
    }

    public void removeMonthList(int r2) {
        List<Integer> r0 = this.mCustomerByMonthDay;
        if (r0 == null) goto L6;
        r0.remove(Integer.valueOf(r2));
        return;
    }

    public void removeWeekList(int r2) {
        List<Integer> r0 = this.mCustomerByWeek;
        if (r0 == null) goto L6;
        r0.remove(Integer.valueOf(r2));
        return;
    }

    public void setCustomerByMonthWeekDay(String r1) {
        this.mCustomerByMonthWeekDay = r1;
    }

    public void setCustomerByMonthWeekNo(String r1) {
        this.mCustomerByMonthWeekNo = r1;
    }

    public void setInterval(int r1) {
        this.mInterval = r1;
    }

    public void setIsSingleInMonth(boolean r1) {
        this.mIsSingleInMonth = r1;
    }

    public void setIsSingleInWeek(boolean r1) {
        this.mIsSingleInWeek = r1;
    }

    public void setRepeatType(int r5) {
        this.mRepeatType = r5;
        switch(r5) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            case 11: goto L5;
            default: goto L29;
        };
    L5:
        this.mFrequency = 7;
        return;
    L6:
        this.mFrequency = 6;
        return;
    L7:
        this.mFrequency = 6;
        return;
    L8:
        this.mFrequency = 5;
        return;
    L9:
        this.mFrequency = 4;
        return;
    L10:
        this.mFrequency = 5;
        this.mCustomerByWeek = new ArrayList();
        int r6 = 1;
    L11:
        if (r6 >= 6) goto L30;
        this.mCustomerByWeek.add(Integer.valueOf(r6));
        r6 = r6 + 1;
        goto L11
    L30:
        return;
    L13:
        this.mFrequency = 7;
        return;
    L14:
        this.mFrequency = 6;
        return;
    L15:
        this.mFrequency = 5;
        return;
    L16:
        this.mFrequency = 5;
        return;
    L17:
        this.mFrequency = 4;
        return;
    }

    public void setWeekStartDay(CustomRepeatParams$DayOfWeek r1) {
        this.mWeekStartDay = r1;
    }
}
