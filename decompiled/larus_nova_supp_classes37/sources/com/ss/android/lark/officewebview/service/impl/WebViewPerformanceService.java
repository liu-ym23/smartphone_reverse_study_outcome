package com.ss.android.lark.officewebview.service.impl;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import otb.h;
import oxb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class WebViewPerformanceService implements mxb.b {
    public final Lazy a;

    public static final class a {
    }

    static {
    }

    @Override // mxb.b
    public final void E() {
    }

    public WebViewPerformanceService() {
        new CopyOnWriteArraySet();
        this.a = LazyKt.lazy(new WebViewPerformanceService$mPerformanceTimingListener$2(this));
    }

    @Override // mxb.b
    public final void b(OfficeWebView r2) {
        if (r2 == null) goto L8;
        n r3 = r2.getServiceManager();
        if (r3 == null) goto L8;
        oxb.f r4 = (oxb.f) r3.a(oxb.f.class);
        if (r4 == null) goto L8;
        otb.e r5 = r4.B();
    L9:
        if (r5 == null) goto L12;
        r5.a((h) this.a.getValue());
        return;
    L12:
        return;
    L8:
        r5 = null;
        goto L9
    }
}
