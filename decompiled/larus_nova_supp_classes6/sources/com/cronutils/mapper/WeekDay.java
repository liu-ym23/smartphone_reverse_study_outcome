package com.cronutils.mapper;

import java.io.Serializable;
import zr7.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public class WeekDay implements Serializable {
    private static final long serialVersionUID = -1542525283511798919L;
    private final boolean firstDayZero;
    private final int mondayDoWValue;

    public int getMondayDoWValue() {
        return this.mondayDoWValue;
    }

    public boolean isFirstDayZero() {
        return this.firstDayZero;
    }

    public WeekDay(int r3, boolean r4) {
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        a.a(r0, "Monday Day of Week value must be greater or equal to zero");
        this.mondayDoWValue = r3;
        this.firstDayZero = r4;
        return;
    L5:
        r0 = false;
        goto L6
    }

    public int mapTo(int r5, WeekDay r6) {
        if (this.firstDayZero == false) goto L22;
        if (r6.isFirstDayZero() == false) goto L22;
        Integer r7 = Integer.valueOf(r5);
        int r8 = r6.getMondayDoWValue() - getMondayDoWValue();
        int r0 = r7.intValue();
        if (r8 == 0) goto L20;
        if (r8 >= 0) goto L14;
        r0 = r7.intValue() + r8;
        int r3 = 0 - r0;
        if (r0 >= 0) goto L14;
        r0 = (1 + 6) - r3;
    L14:
        if (r8 <= 0) goto L18;
        r0 = r7.intValue() + r8;
        if (r0 <= 6) goto L18;
        r0 = r0 - 6;
    L18:
        r7 = Integer.valueOf(r0);
    L20:
        return r7.intValue();
    L22:
        if (this.firstDayZero == true) goto L40;
        if (r6.isFirstDayZero() == true) goto L40;
        Integer r9 = Integer.valueOf(r5);
        int r10 = r6.getMondayDoWValue() - getMondayDoWValue();
        int r1 = r9.intValue();
        if (r10 == 0) goto L38;
        if (r10 >= 0) goto L32;
        r1 = r9.intValue() + r10;
        int r4 = 1 - r1;
        if (r1 >= 1) goto L32;
        r1 = (1 + 7) - r4;
    L32:
        if (r10 <= 0) goto L36;
        r1 = r9.intValue() + r10;
        if (r1 <= 7) goto L36;
        r1 = r1 - 7;
    L36:
        r9 = Integer.valueOf(r1);
    L38:
        return r9.intValue();
    L40:
        if (r6.isFirstDayZero() == false) goto L44;
        return mapTo(r5, new WeekDay(r6.getMondayDoWValue() + 1, false)) - 1;
    L44:
        return (mapTo(r5, new WeekDay(r6.getMondayDoWValue() - 1, true)) % 7) + 1;
    }
}
