package com.ss.android.lark.officewebview.monitor.base;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import cxb.a;
import dxb.p;
import dxb.t;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import oxb.f;
import oxb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class PerformanceTimingHandler implements Serializable {
    public static final String API_NAME = "_container_performance_timing";
    public static final String FETCH_TIMING_RECORD = "javascript:window._container_performance_timing.report(JSON.stringify(performance.timing.toJSON()))";
    public static boolean a = true;

    public PerformanceTimingHandler() {
    }

    public static void enableTTPerformanceTiming(WebView r2) {
        if (r2 == null) goto L5;
        r2.evaluateJavascript("ttwebview:/*enableTTLogEvent*/;", null);
        return;
    }

    @JavascriptInterface
    public void report(String r4) {
        int r0 = t.a;
        boolean r1 = a;
        Intrinsics.checkNotNullParameter(null, "dependency");
        if (TextUtils.isEmpty(r4) == true) goto L6;
        Lazy<Handler> r2 = ThreadUtil.a;
        ThreadUtil.a.b(new p(null, r1, null, r4));
    L6:
        a = false;
        j.e("PerformanceTimingH", r4);
    }

    public static void reportPerformanceTiming(WebView r2, boolean r3, String r4, a r5) {
        if (r2 != null) goto L5;
        return;
    L5:
        if ((r2 instanceof OfficeWebView) == false) goto L9;
        n r6 = ((OfficeWebView) r2).getServiceManager();
        if (r6 == null) goto L9;
        f r7 = (f) r6.a(f.class);
    L10:
        if (r7 != null) goto L12;
        return;
    L12:
        if (r7.B() == null) goto L19;
        r7.B().getPerformanceTiming();
        int r8 = t.a;
        Intrinsics.checkNotNullParameter(r5, "dependency");
        if (TextUtils.isEmpty(null) == true) goto L20;
        Lazy<Handler> r9 = ThreadUtil.a;
        ThreadUtil.a.b(new p(r5, r3, r4, null));
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r7 = null;
        goto L10
    }
}
