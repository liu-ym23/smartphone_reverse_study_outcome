package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.ILaunchTrace;

/* JADX INFO: loaded from: classes.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        r0.c.a();
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r10, String r11) {
        r0.c.b(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r10, String r11, long r12) {
        r0.c.c(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r10, String r11) {
        r0.c.h(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        r0.c.i();
    }
}
