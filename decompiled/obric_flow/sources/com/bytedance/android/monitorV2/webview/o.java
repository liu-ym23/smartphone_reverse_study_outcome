package com.bytedance.android.monitorV2.webview;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3809a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3810b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3811c;
    public final /* synthetic */ WebViewMonitorJsBridge d;

    public /* synthetic */ o(WebViewMonitorJsBridge r5, String r10, String r11, int r12) {
        this.f3809a = r12;
        this.d = r5;
        this.f3810b = r10;
        this.f3811c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f3809a) {
            case 0: goto L20;
            default: goto L22;
        };
    L20:
        JSONObject r5 = qo.a.c(this.f3810b);     // Catch: Throwable -> L17
        r5.optString("url", "");     // Catch: Throwable -> L17
        i r10 = WebViewMonitorJsBridge.access$000(this.d);     // Catch: Throwable -> L17
        String r11 = this.f3811c;     // Catch: Throwable -> L17
        r10.getClass();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r5, "json");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r11, "eventType");     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r11, "perf") == false) goto L26;
        c r12 = r10.f;     // Catch: Throwable -> L17
        if (r12 == null) goto L27;
        r12.c(r5);     // Catch: Throwable -> L17
        return;
    L27:
        return;
    L26:
        return;
    L17:
        th = move-exception;
        mn.h.g("default_handle", th);
        return;
    L22:
        JSONObject r13 = qo.a.c(this.f3810b);     // Catch: Throwable -> L8
        c r14 = WebViewMonitorJsBridge.access$100(this.d);     // Catch: Throwable -> L8
        if (r14 == null) goto L24;
        r14.b(this.f3811c, r13);     // Catch: Throwable -> L8
        return;
    L24:
        return;
    L8:
        th = move-exception;
        mn.h.g("default_handle", th);
    }
}
