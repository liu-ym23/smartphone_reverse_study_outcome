package com.bytedance.crash;

import com.bytedance.crash.diagnose.NpthMonitor;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class EnsureImpl {
    public EnsureImpl() {
    }

    public void ensureNotReachHereForce(String r10, Throwable r11) {
        NpthMonitor.reportInnerException(r10, r11);
    }
}
