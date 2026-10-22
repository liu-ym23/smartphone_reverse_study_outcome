package com.bytedance.android.monitorV2.webview.ttweb;

import android.webkit.WebView;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import mn.h;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f3832a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f3833b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f3834c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    static {
        f3832a = LazyKt.lazy(TTUtils$ttWebSdkClazz$2.f3829a);
        f3833b = LazyKt.lazy(TTUtils$ttWebViewExtensionClazz$2.f3830a);
        LazyKt.lazy(TTUtils$isTTWebViewMethod$2.f3828a);
        f3834c = LazyKt.lazy(TTUtils$isHookSuccessMethod$2.f3827a);
        d = LazyKt.lazy(TTUtils$ttWebViewExtensionConstructor$2.f3831a);
        e = LazyKt.lazy(TTUtils$getPerformanceMetricsMethod$2.f3826a);
    }

    public static JSONObject a(WebView r5, TTUtils$MetricsArgs r10) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        Intrinsics.checkNotNullParameter(r10, "args");
        JSONObject r11 = new JSONObject();     // Catch: Throwable -> L9
        Constructor r12 = (Constructor) d.getValue();     // Catch: Throwable -> L9
        if (r12 == null) goto L11;
        Method r13 = (Method) e.getValue();     // Catch: Throwable -> L9
        if (r13 == null) goto L11;
        Object r14 = r13.invoke(r12.newInstance(new Object[]{r5}), new Object[]{r10.f3825a});     // Catch: Throwable -> L9
        Intrinsics.checkNotNull(r14, "null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L9
        return new JSONObject((String) r14);
    L11:
        return r11;
    L9:
        th = move-exception;
        h.g("default_handle", th);
        return new JSONObject();
    }

    public static boolean b(WebView r5) {
        Intrinsics.checkNotNullParameter(r5, "webView");
        Method r10 = (Method) f3834c.getValue();     // Catch: Throwable -> L7
        if (r10 == null) goto L9;
        r10.setAccessible(true);     // Catch: Throwable -> L7
        Object r11 = r10.invoke(null, new Object[]{r5});     // Catch: Throwable -> L7
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L7
        return ((Boolean) r11).booleanValue();
    L9:
        return false;
    L7:
        th = move-exception;
        h.g("default_handle", th);
        return false;
    }
}
