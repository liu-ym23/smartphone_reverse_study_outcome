package com.bytedance.apm.impl;

import com.bytedance.services.apm.api.ILaunchTrace;

/* JADX INFO: loaded from: classes.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        com.bytedance.apm.trace.b.b();
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r1, String r2) {
        com.bytedance.apm.trace.b.b(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r1, String r2, long r3) {
        com.bytedance.apm.trace.b.a(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r1, String r2) {
        com.bytedance.apm.trace.b.a(r1, r2);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        com.bytedance.apm.trace.b.a();
    }
}
