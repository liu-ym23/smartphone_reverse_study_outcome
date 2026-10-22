package com.bytedance.apm;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3880c;

    public h(long r5, long r10, boolean r11) {
        this.f3878a = r5;
        this.f3879b = r10;
        this.f3880c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean r5 = j.f3887a;
        long r10 = this.f3879b;
        boolean r11 = this.f3880c;
        ApmAgent.reportLegacyMonitorLog(null, this.f3878a, r10, r11);
    }
}
