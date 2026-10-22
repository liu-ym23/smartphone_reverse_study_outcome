package com.cronutils.mapper;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public class WeekDay implements Serializable {
    private static final long serialVersionUID = -1542525283511798919L;
    private final boolean firstDayZero;
    private final int mondayDoWValue;

    public WeekDay(int r3, boolean r4) {
        if (r3 < 0) goto L5;
        boolean r0 = true;
    L6:
        com.cronutils.utils.a.a(r0, "Monday Day of Week value must be greater or equal to zero");
        this.mondayDoWValue = r3;
        this.firstDayZero = r4;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private com.cronutils.a<Integer, Integer> bothSameStartOfRange(final int r1, final int r2, final WeekDay r3, final WeekDay r4) {
        return new $$Lambda$WeekDay$G1F_hhb1fTNXvRfoO5JaY7QpLaA(r4, r3, r1, r2);
    }

    static /* synthetic */ Integer lambda$bothSameStartOfRange$0(WeekDay r1, WeekDay r2, int r3, int r4, Integer r5) {
        int r6 = r1.getMondayDoWValue() - r2.getMondayDoWValue();
        int r7 = r5.intValue();
        if (r6 != 0) goto L5;
        return r5;
    L5:
        if (r6 >= 0) goto L9;
        r7 = r5.intValue() + r6;
        int r0 = r3 - r7;
        if (r7 >= r3) goto L9;
        r7 = (r4 + 1) - r0;
    L9:
        if (r6 <= 0) goto L14;
        r7 = r5.intValue() + r6;
        if (r7 <= r4) goto L14;
        r7 = r7 - r4;
    L14:
        return Integer.valueOf(r7);
    }

    public int getMondayDoWValue() {
        return this.mondayDoWValue;
    }

    public boolean isFirstDayZero() {
        return this.firstDayZero;
    }

    public int mapTo(int r6, WeekDay r7) {
        if (this.firstDayZero == false) goto L9;
        if (r7.isFirstDayZero() == false) goto L9;
        return ((Integer) ZeusTransformUtils.preCheckCast(bothSameStartOfRange(0, 6, this, r7).apply(Integer.valueOf(r6)), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L9:
        if (this.firstDayZero == true) goto L15;
        if (r7.isFirstDayZero() == true) goto L15;
        return ((Integer) ZeusTransformUtils.preCheckCast(bothSameStartOfRange(1, 7, this, r7).apply(Integer.valueOf(r6)), Integer.class, "com.obric.memorydata.plugin")).intValue();
    L15:
        if (r7.isFirstDayZero() == false) goto L19;
        return mapTo(r6, new WeekDay(r7.getMondayDoWValue() + 1, false)) - 1;
    L19:
        return (mapTo(r6, new WeekDay(r7.getMondayDoWValue() - 1, true)) % 7) + 1;
    }
}
