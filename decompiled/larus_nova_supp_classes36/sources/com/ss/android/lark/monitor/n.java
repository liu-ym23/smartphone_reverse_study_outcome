package com.ss.android.lark.monitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ MonitorModule a;

    public /* synthetic */ n(MonitorModule r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
