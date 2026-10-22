package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.activity.ActivityMonitor;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h3<T> implements Consumer {
    public final /* synthetic */ e3 a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ CallContext e;

    public h3(e3 r1, String r2, String r3, Ref.ObjectRef r4, CallContext r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r12) {
        Throwable r13 = (Throwable) r12;
        this.a.finishWithFailure(r13);
        int r1 = ActivityMonitor.ActivityStatusCode.UNKNOWN_CODE.getCode();
        String r2 = this.b;
        String r3 = this.c;
        JsonObject r4 = (JsonObject) this.d.element;
        Throwable r0 = null;
        if (r13 == null) goto L5;
        String r5 = r13.getMessage();
    L6:
        x40.c.a(r1, r2, r3, r4, r5, "");
        e3 r6 = this.a;
        View r7 = this.e.d;
        String r8 = this.b;
        String r9 = this.c;
        r6.getClass();
        if ((r13 instanceof NetworkErrorException) == false) goto L10;
        r0 = r13;
    L10:
        NetworkErrorException r11 = (NetworkErrorException) r0;
        if (r11 == null) goto L13;
        int r14 = r11.statusCode;
    L14:
        if (r7 != null) goto L17;
        return;
    L17:
        if ((r7 instanceof WebView) == false) goto L23;
        IBrowserService r15 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r15 == null) goto L27;
        v30.a r16 = r15.webViewMonitorHelper();
        if (r16 == null) goto L28;
        r16.a((WebView) r7, r8, r9, r14, r13.getMessage());
        return;
    L28:
        return;
    L27:
        return;
    L23:
        IBrowserService r17 = (IBrowserService) jc1.k.f(IBrowserService.class);
        if (r17 == null) goto L30;
        r17.reportLynxFetchJsbError(r7, r8, r9, r14, r13.getMessage());
        return;
    L30:
        return;
    L13:
        r14 = -1;
        goto L14
    L5:
        r5 = null;
        goto L6
    }
}
