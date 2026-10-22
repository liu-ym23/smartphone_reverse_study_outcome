package org.ehcache.xml.model;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/* JADX INFO: loaded from: classes7.dex */
@XmlEnum
@XmlType(name = "time-unit")
public final enum TimeUnit extends Enum<TimeUnit> {
    private static final /* synthetic */ TimeUnit[] $VALUES = null;

    @XmlEnumValue("days")
    public static final TimeUnit DAYS = null;

    @XmlEnumValue("hours")
    public static final TimeUnit HOURS = null;

    @XmlEnumValue("micros")
    public static final TimeUnit MICROS = null;

    @XmlEnumValue("millis")
    public static final TimeUnit MILLIS = null;

    @XmlEnumValue("minutes")
    public static final TimeUnit MINUTES = null;

    @XmlEnumValue("nanos")
    public static final TimeUnit NANOS = null;

    @XmlEnumValue("seconds")
    public static final TimeUnit SECONDS = null;
    private final String value;

    static {
        TimeUnit r0 = new TimeUnit("NANOS", 0, "nanos");
        NANOS = r0;
        TimeUnit r1 = new TimeUnit("MICROS", 1, "micros");
        MICROS = r1;
        TimeUnit r3 = new TimeUnit("MILLIS", 2, "millis");
        MILLIS = r3;
        TimeUnit r5 = new TimeUnit("SECONDS", 3, "seconds");
        SECONDS = r5;
        TimeUnit r7 = new TimeUnit("MINUTES", 4, "minutes");
        MINUTES = r7;
        TimeUnit r9 = new TimeUnit("HOURS", 5, "hours");
        HOURS = r9;
        TimeUnit r11 = new TimeUnit("DAYS", 6, "days");
        DAYS = r11;
        $VALUES = new TimeUnit[]{r0, r1, r3, r5, r7, r9, r11};
    }

    private TimeUnit(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }

    public static TimeUnit fromValue(String r5) {
        TimeUnit[] r0 = values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        TimeUnit r3 = r0[r2];
        if (r3.value.equals(r5) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException(r5);
    }

    public static TimeUnit valueOf(String r2) {
        return (TimeUnit) ZeusTransformUtils.preCheckCast(Enum.valueOf(TimeUnit.class, r2), TimeUnit.class, "com.obric.memorydata.plugin");
    }

    public static TimeUnit[] values() {
        return (TimeUnit[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TimeUnit[].class, "com.obric.memorydata.plugin");
    }

    public String value() {
        return this.value;
    }
}
