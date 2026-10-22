package com.bytedance.android.monitorV2.webview;

/* JADX INFO: loaded from: classes2.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3819b;

    public /* synthetic */ r(Object r5, int r10) {
        this.f3818a = r10;
        this.f3819b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3818a) {
            case 0: goto L12;
            case 1: goto L8;
            default: goto L4;
        };
    L4:
        c r5 = ((i) this.f3819b).f;
        if (r5 == null) goto L16;
        r5.e();
        return;
    L16:
        return;
    L8:
        c r10 = WebViewMonitorJsBridge.access$100((WebViewMonitorJsBridge) this.f3819b);
        if (r10 == null) goto L17;
        r10.f3760k.f3775b.a();
        return;
    L17:
        return;
    L12:
        long r11 = System.currentTimeMillis();
        c r12 = WebViewMonitorJsBridge.access$100((WebViewMonitorJsBridge) this.f3819b);
        if (r12 == null) goto L18;
        r12.f = true;
        r12.f3768t.f20002h = r11;
        r12.g();
        return;
    }
}
