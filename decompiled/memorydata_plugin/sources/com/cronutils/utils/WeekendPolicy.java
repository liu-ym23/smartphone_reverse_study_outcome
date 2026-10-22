package com.cronutils.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.time.ZonedDateTime;

/* JADX INFO: loaded from: classes2.dex */
public final enum WeekendPolicy extends Enum<WeekendPolicy> {
    private static final /* synthetic */ WeekendPolicy[] $VALUES = null;
    public static final WeekendPolicy FRIDAY_SATURDAY = null;
    public static final WeekendPolicy SATURDAY_SUNDAY = null;
    public static final WeekendPolicy THURSDAY_FRIDAY = null;

    /* JADX INFO: renamed from: com.cronutils.utils.WeekendPolicy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3445a = null;

        static {
            int[] r0 = new int[WeekendPolicy.values().length];
            f3445a = r0;
            r0[WeekendPolicy.THURSDAY_FRIDAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f3445a[WeekendPolicy.FRIDAY_SATURDAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f3445a[WeekendPolicy.SATURDAY_SUNDAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        WeekendPolicy r0 = new WeekendPolicy("THURSDAY_FRIDAY", 0);
        THURSDAY_FRIDAY = r0;
        WeekendPolicy r1 = new WeekendPolicy("FRIDAY_SATURDAY", 1);
        FRIDAY_SATURDAY = r1;
        WeekendPolicy r3 = new WeekendPolicy("SATURDAY_SUNDAY", 2);
        SATURDAY_SUNDAY = r3;
        $VALUES = new WeekendPolicy[]{r0, r1, r3};
    }

    private WeekendPolicy(String r1, int r2) {
        super(r1, r2);
    }

    public static int daysFromWeekend(WeekendPolicy r3, ZonedDateTime r4) {
        int r5 = r4.getDayOfWeek().getValue();
        int r6 = AnonymousClass1.f3445a[r3.ordinal()];
        if (r6 == 1) goto L17;
        if (r6 != 2) goto L7;
        if (r5 >= 5) goto L13;
        return r5;
    L13:
        if (r5 > 6) goto L15;
        return 0;
    L15:
        return r5 - 6;
    L7:
        if (r6 != 3) goto L26;
        if (r5 >= 6) goto L22;
        return r5;
    L22:
        return 0;
    L26:
        return 0;
    L17:
        if (r5 >= 4) goto L19;
        return r5;
    L19:
        if (r5 > 5) goto L21;
        return 0;
    L21:
        return r5 - 5;
    }

    public static int daysToWeekend(WeekendPolicy r4, ZonedDateTime r5) {
        int r6 = r5.getDayOfWeek().getValue();
        int r7 = AnonymousClass1.f3445a[r4.ordinal()];
        if (r7 == 1) goto L19;
        if (r7 != 2) goto L7;
        if (r6 < 5) goto L14;
        if (r6 > 6) goto L17;
    L25:
        return 0;
    L17:
        return (7 - r6) + 5;
    L14:
        return 6 - r6;
    L7:
        if (r7 != 3) goto L25;
        if (r6 >= 6) goto L25;
        return Math.max(0, 6 - r6);
    L19:
        if (r6 < 4) goto L21;
        if (r6 <= 5) goto L25;
        return (7 - r6) + 4;
    L21:
        return 4 - r6;
    }

    public static WeekendPolicy valueOf(String r2) {
        return (WeekendPolicy) ZeusTransformUtils.preCheckCast(Enum.valueOf(WeekendPolicy.class, r2), WeekendPolicy.class, "com.obric.memorydata.plugin");
    }

    public static WeekendPolicy[] values() {
        return (WeekendPolicy[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WeekendPolicy[].class, "com.obric.memorydata.plugin");
    }
}
