package com.bytedance.applog.filter;

import com.bytedance.applog.monitor.MonitorKey;

/* JADX INFO: loaded from: classes.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.b f1592a;

    public d(com.bytedance.applog.b r1) {
        this.f1592a = r1;
    }

    @Override // com.bytedance.applog.filter.e
    public boolean a() {
        if (this.f1592a.aG() != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.applog.filter.e
    public boolean a(MonitorKey r2, String r3, String r4) {
        if (this.f1592a.aG() != null) goto L7;
        return false;
    L7:
        return !this.f1592a.aG().a(r2.name(), r3, r4);
    }
}
