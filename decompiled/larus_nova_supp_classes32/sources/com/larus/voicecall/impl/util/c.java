package com.larus.voicecall.impl.util;

import com.larus.audio.audiov3.report.AudioDeviceMonitorScenes;
import com.larus.audio.audiov3.report.IAudioDeviceMonitorReporter;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ EarphoneChecker a;

    public /* synthetic */ c(EarphoneChecker r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getClass();
        IAudioDeviceMonitorReporter r0 = (IAudioDeviceMonitorReporter) ServiceManager.get().getService(IAudioDeviceMonitorReporter.class);     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.a(AudioDeviceMonitorScenes.SWITCH);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        FLogger.a.e("EarphoneChecker", "reportDeviceSwitch error: " + e.getMessage());
    }
}
