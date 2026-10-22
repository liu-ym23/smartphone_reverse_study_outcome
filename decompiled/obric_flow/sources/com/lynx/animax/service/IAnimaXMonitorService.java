package com.lynx.animax.service;

import androidx.annotation.Keep;
import dm.a;
import fm.b;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public interface IAnimaXMonitorService extends IAnimaXService {
    void reportError(a r5);

    void reportPerformanceMetrics(b r5);

    void setCurrentUrl(String r5);
}
