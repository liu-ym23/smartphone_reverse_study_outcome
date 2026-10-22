package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import java.io.Serializable;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
public interface IDateTimeValueType extends Serializable {
    IDateTimeValueType add(ITimeDurationValueType r1);

    int compare(IDateTimeValueType r1);

    BigDateTimeValueType getBigValue();

    IDateTimeValueType normalize();

    Calendar toCalendar();
}
