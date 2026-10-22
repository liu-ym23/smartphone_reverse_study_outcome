package com.bytedance.android.ec.adapter.api;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public interface i {
    long a(@IUxTracerAdapter$Companion$Scene String r1);

    void b();

    Object getArgument(String r1);

    void getSingleTimeStamp(String r1);

    void setBeforeReportCallback(Function0<Unit> r1);
}
