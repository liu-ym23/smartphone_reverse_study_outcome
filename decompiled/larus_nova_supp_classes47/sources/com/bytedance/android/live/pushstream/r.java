package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.base.BaseServices;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class r<T> implements Consumer {
    public static final r a = null;

    static {
        a = new r();
    }

    public r() {
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        ALogger.e("AudioSamiDiagnosisImpl", "createLiveStream: e: " + r4.getMessage());
        String r0 = "AudioSamiDiagnosisImpl " + r4.getMessage();
        SettingKey r1 = LiveTracingMonitor.a;
        IHostMonitor r2 = (IHostMonitor) BaseServices.as(IHostMonitor.class);
        if (r2 == null) goto L6;
        r2.ensureNotReachHere(r4, r0);
        return;
    }
}
