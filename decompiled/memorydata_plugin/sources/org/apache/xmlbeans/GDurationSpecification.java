package org.apache.xmlbeans;

import java.math.BigDecimal;

/* JADX INFO: loaded from: classes7.dex */
public interface GDurationSpecification {
    int compareToGDuration(GDurationSpecification r1);

    int getDay();

    BigDecimal getFraction();

    int getHour();

    int getMinute();

    int getMonth();

    int getSecond();

    int getSign();

    int getYear();

    boolean isImmutable();
}
