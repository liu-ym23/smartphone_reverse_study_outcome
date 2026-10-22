package com.bytedance.android.monitorV2.webview;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JSONObject f3817c;
    public final /* synthetic */ JSONObject d;
    public final /* synthetic */ p e;

    public q(p r5, String r10, JSONObject r11, JSONObject r12, JSONObject r13) {
        this.e = r5;
        this.f3815a = r10;
        this.f3816b = r11;
        this.f3817c = r12;
        this.d = r13;
    }

    @Override // java.lang.Runnable
    public final void run() {
        JSONObject r5 = this.d;
        p r10 = this.e;
        d5.b.c("WebViewMonitorJsBridge", "reportPageLatestData : " + this.f3815a);     // Catch: Throwable -> L6
        WebViewMonitorJsBridge.access$000(r10.f3814c).d(this.f3816b);     // Catch: Throwable -> L6
        WebViewMonitorJsBridge.access$000(r10.f3814c).d(this.f3817c);     // Catch: Throwable -> L6
        c r11 = WebViewMonitorJsBridge.access$100(r10.f3814c);     // Catch: Throwable -> L6
        if (r11 == null) goto L9;
        r11.e();     // Catch: Throwable -> L6
    L9:
        if (r5.length() <= 0) goto L16;
        WebViewMonitorJsBridge.access$000(r10.f3814c).d(r5);     // Catch: Throwable -> L6
        return;
    L16:
        return;
    L6:
        th = move-exception;
        mn.h.g("default_handle", th);
    }
}
