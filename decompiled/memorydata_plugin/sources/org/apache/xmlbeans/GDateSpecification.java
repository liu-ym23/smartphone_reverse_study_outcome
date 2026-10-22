package org.apache.xmlbeans;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes7.dex */
public interface GDateSpecification {
    int compareToGDate(GDateSpecification r1);

    int getBuiltinTypeCode();

    int getDay();

    int getFlags();

    BigDecimal getFraction();

    int getHour();

    int getMillisecond();

    int getMinute();

    int getMonth();

    int getSecond();

    int getTimeZoneHour();

    int getTimeZoneMinute();

    int getTimeZoneSign();

    int getYear();

    boolean hasDate();

    boolean hasDay();

    boolean hasMonth();

    boolean hasTime();

    boolean hasTimeZone();

    boolean hasYear();

    boolean isImmutable();
}
