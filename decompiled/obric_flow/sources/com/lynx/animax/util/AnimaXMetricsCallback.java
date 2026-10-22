package com.lynx.animax.util;

import androidx.annotation.RestrictTo;
import com.lynx.animax.base.CalledByNative;
import com.lynx.animax.base.bridge.ReadableMap;
import com.lynx.animax.service.IAnimaXMonitorService;
import fm.b;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class AnimaXMetricsCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IAnimaXMonitorService f9716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap f9718c;

    public AnimaXMetricsCallback(IAnimaXMonitorService r5, String r10, HashMap r11) {
        this.f9716a = r5;
        this.f9717b = r10;
        this.f9718c = r11;
    }

    @CalledByNative
    public void onMetricsReady(ReadableMap r5, ReadableMap r10) {
        b r11 = new b(r5, r10, this.f9718c, this.f9717b);
        this.f9716a.reportPerformanceMetrics(r11);
    }
}
