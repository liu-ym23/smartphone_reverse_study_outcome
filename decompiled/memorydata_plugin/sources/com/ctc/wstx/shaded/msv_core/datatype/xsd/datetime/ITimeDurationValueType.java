package com.ctc.wstx.shaded.msv_core.datatype.xsd.datetime;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface ITimeDurationValueType extends Serializable {
    int compare(ITimeDurationValueType r1);

    BigTimeDurationValueType getBigValue();
}
