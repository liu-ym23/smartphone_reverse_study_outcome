package com.bytedance.android.live.browser;

import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i implements com.bytedance.android.annie.monitor.lynx.b {
    public final /* synthetic */ w a;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.android.live.browser.AnnieNGInitHelper$createMonitorProvider$1$providerFpsMonitor$1] */
    public final AnnieNGInitHelper$createMonitorProvider$1$providerFpsMonitor$1 a() {
        return new AnnieNGInitHelper$createMonitorProvider$1$providerFpsMonitor$1(this);
    }

    public final Map<String, String> b() {
        return MapsKt.mapOf(TuplesKt.to("webcast_sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b())));
    }

    public i(w r1) {
        this.a = r1;
    }
}
