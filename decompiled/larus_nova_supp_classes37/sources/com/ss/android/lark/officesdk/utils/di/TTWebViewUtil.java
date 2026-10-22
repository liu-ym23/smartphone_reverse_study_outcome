package com.ss.android.lark.officesdk.utils.di;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class TTWebViewUtil {
    public static final Lazy<otb.n> a = null;
    public static final Lazy<otb.l> b = null;

    public static final class a {
        @JvmStatic
        public static otb.f b() {
            DependencyContainer r0 = DependencyContainer.a;
            otb.f r1 = (otb.f) DependencyContainer.a(otb.f.class, null);
            if (r1 == null) goto L5;
            return r1;
        L5:
            return (otb.f) TTWebViewUtil.a.getValue();
        }

        @JvmStatic
        public static otb.e a(WebView r2) {
            Intrinsics.checkNotNullParameter(r2, "webview");
            DependencyContainer r0 = DependencyContainer.a;
            otb.d r1 = (otb.d) DependencyContainer.a(otb.d.class, null);
            if (r1 != null) goto L6;
            r1 = (otb.d) TTWebViewUtil.b.getValue();
        L6:
            return r1.o(r2);
        }

        @JvmStatic
        public static boolean c(WebView r1) {
            Intrinsics.checkNotNullParameter(r1, "webview");
            b().b0(r1);
            return false;
        }

        @JvmStatic
        public static boolean d(WebView r0) {
            b().isTTWebView();
            return false;
        }

        @JvmStatic
        public static void e(WebView r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "webview");
            Intrinsics.checkNotNullParameter(r2, "bizType");
            b().q(r1, r2);
        }
    }

    static {
        a = LazyKt.lazy(TTWebViewUtil$Companion$defaultWebViewDependency$2.INSTANCE);
        b = LazyKt.lazy(TTWebViewUtil$Companion$defaultExtensionDependency$2.INSTANCE);
    }

    @JvmStatic
    public static final void a(WebSettings r0, int r1, WebView r2) {
        Intrinsics.checkNotNullParameter(r0, "settings");
        Intrinsics.checkNotNullParameter(r2, "webview");
        a.b().K(r0, r2);
    }

    @JvmStatic
    public static final void b(WebSettings r0, int r1, WebView r2) {
        Intrinsics.checkNotNullParameter(r0, "settings");
        Intrinsics.checkNotNullParameter(r2, "webview");
        a.b().W(r0, r2);
    }
}
