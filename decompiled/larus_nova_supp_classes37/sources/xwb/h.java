package xwb;

import com.ss.android.lark.officewebview.base.OfficeWebView;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class h {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(OfficeWebView r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter("wb_lark_webview_bridge_error", "event");
        com.ss.android.lark.officesdk.utils.di.j.b("JSBridge", r4);
        o.c.a.getClass();
        r2.m("wb_lark_webview_bridge_error", new dxb.c.b(r3, o.c.a.d)).b();
    }

    public static void b(OfficeWebView r2, int r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        Intrinsics.checkNotNullParameter("wb_lark_webview_bridge_error", "event");
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        com.ss.android.lark.officesdk.utils.di.j.b("JSBridge", r4);
        o.c.a.getClass();
        dxb.g r6 = r2.m("wb_lark_webview_bridge_error", new dxb.c.b(r3, o.c.a.d));
        r6.a("api_name", r5);
        r6.b();
    }
}
