package com.bytedance.crash;

import com.bytedance.crash.diagnose.NpthMonitor;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class EnsureImpl {
    public EnsureImpl() {
    }

    public void ensureNotReachHereForce(String r1, Throwable r2) {
        NpthMonitor.reportInnerException(r1, r2);
    }
}
