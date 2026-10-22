package org.apache.xmlbeans;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes7.dex */
public class XmlCalendar extends GregorianCalendar {
    private static final int DEFAULT_DEFAULT_YEAR = 0;
    private static final Date _beginningOfTime = null;
    private static int defaultYear = Integer.MIN_VALUE;

    static {
        _beginningOfTime = new Date(Long.MIN_VALUE);
    }

    public XmlCalendar() {
        setGregorianChange(_beginningOfTime);
        clear();
    }

    public XmlCalendar(int r11, int r12, int r13, int r14, int r15, int r16, BigDecimal r17) {
        this(TimeZone.getDefault(), new GDate(r11, r12, r13, r14, r15, r16, r17));
    }

    public XmlCalendar(int r13, int r14, int r15, int r16, int r17, int r18, BigDecimal r19, int r20, int r21, int r22) {
        this(new GDate(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22));
    }

    public XmlCalendar(String r2) {
        this(new GDate(r2));
    }

    public XmlCalendar(Date r3) {
        this(TimeZone.getDefault(), new GDate(r3));
        complete();
    }

    private XmlCalendar(TimeZone r4, GDateSpecification r5) {
        GDateSpecification r6 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r5, GDateSpecification.class, "com.obric.memorydata.plugin");
        super(r4);
        setGregorianChange(_beginningOfTime);
        clear();
        if (r6.hasYear() == false) goto L10;
        int r7 = r6.getYear();
        if (r7 <= 0) goto L7;
        set(0, 1);
    L8:
        set(1, r7);
        goto L10
    L7:
        set(0, 0);
        r7 = -r7;
    L10:
        if (r6.hasMonth() == false) goto L13;
        set(2, r6.getMonth() - 1);
    L13:
        if (r6.hasDay() == false) goto L16;
        set(5, r6.getDay());
    L16:
        if (r6.hasTime() == false) goto L21;
        set(11, r6.getHour());
        set(12, r6.getMinute());
        set(13, r6.getSecond());
        if (r6.getFraction().scale() <= 0) goto L21;
        set(14, r6.getMillisecond());
    L21:
        if (r6.hasTimeZone() == false) goto L24;
        set(15, ((r6.getTimeZoneSign() * 1000) * 60) * ((r6.getTimeZoneHour() * 60) + r6.getTimeZoneMinute()));
        set(16, 0);
        return;
    }

    public XmlCalendar(GDateSpecification r3) {
        GDateSpecification r4 = (GDateSpecification) ZeusTransformUtils.wrapperContextForParams(r3, GDateSpecification.class, "com.obric.memorydata.plugin");
        this(GDate.timeZoneForGDate(r4), r4);
    }

    public static int getDefaultYear() {
        if (defaultYear != Integer.MIN_VALUE) goto L12;
        String r1 = SystemProperties.getProperty("user.defaultyear");     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        defaultYear = Integer.parseInt(r1);     // Catch: Throwable -> L10
    L13:
        goto L12
    L8:
        defaultYear = 0;     // Catch: Throwable -> L10
    L10:
        defaultYear = 0;
    L12:
        return defaultYear;
    }

    public static void setDefaultYear(int r0) {
        defaultYear = r0;
    }

    @Override // java.util.GregorianCalendar, java.util.Calendar
    public void computeTime() {
        boolean r1 = !isSet(1);
        if (r1 == false) goto L13;
        set(1, getDefaultYear());
    L13:
        super.computeTime();     // Catch: Throwable -> L9
        if (r1 == false) goto L15;
        clear(1);
        return;
    L15:
        return;
    L9:
        th = move-exception;
        if (r1 == false) goto L12;
        clear(1);
    L12:
        throw th;
    }

    @Override // java.util.Calendar
    public int get(int r2) {
        if (isSet(r2) == false) goto L10;
        if (this.isTimeSet == true) goto L10;
        return internalGet(r2);
    L10:
        return super.get(r2);
    }

    @Override // java.util.Calendar
    public String toString() {
        return new GDate(this).toString();
    }
}
