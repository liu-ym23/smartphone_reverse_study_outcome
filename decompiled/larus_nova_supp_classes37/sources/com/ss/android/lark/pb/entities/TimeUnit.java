package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final enum TimeUnit extends Enum<TimeUnit> implements WireEnum {
    private static final /* synthetic */ TimeUnit[] $VALUES = null;
    public static final ProtoAdapter<TimeUnit> ADAPTER = null;
    public static final TimeUnit DAY = null;
    public static final TimeUnit HOUR = null;
    public static final TimeUnit MINUTE = null;
    public static final TimeUnit MONTH = null;
    public static final TimeUnit SECOND = null;
    public static final TimeUnit YEAR = null;
    private final int value;

    static {
        TimeUnit r0 = new TimeUnit("SECOND", 0, 0);
        SECOND = r0;
        TimeUnit r1 = new TimeUnit("MINUTE", 1, 1);
        MINUTE = r1;
        TimeUnit r3 = new TimeUnit("HOUR", 2, 2);
        HOUR = r3;
        TimeUnit r5 = new TimeUnit("DAY", 3, 3);
        DAY = r5;
        TimeUnit r7 = new TimeUnit("MONTH", 4, 4);
        MONTH = r7;
        TimeUnit r9 = new TimeUnit("YEAR", 5, 5);
        YEAR = r9;
        $VALUES = new TimeUnit[]{r0, r1, r3, r5, r7, r9};
        ADAPTER = ProtoAdapter.newEnumAdapter(TimeUnit.class);
    }

    public static TimeUnit[] values() {
        return (TimeUnit[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static TimeUnit fromValue(int r1) {
        if (r1 == 0) goto L26;
        if (r1 == 1) goto L24;
        if (r1 == 2) goto L22;
        if (r1 == 3) goto L20;
        if (r1 == 4) goto L18;
        if (r1 == 5) goto L16;
        return null;
    L16:
        return YEAR;
    L18:
        return MONTH;
    L20:
        return DAY;
    L22:
        return HOUR;
    L24:
        return MINUTE;
    L26:
        return SECOND;
    }

    public static TimeUnit valueOf(String r1) {
        return (TimeUnit) a.a(TimeUnit.class, r1);
    }

    private TimeUnit(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
