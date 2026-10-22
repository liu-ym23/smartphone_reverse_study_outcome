package n30;

import android.webkit.WebView;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.monitor.webview.h;
import com.bytedance.android.monitorV2.webview.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements v30.a {
    public static final f a = null;

    public f() {
    }

    @Override // v30.a
    public final void a(WebView r1, String r2, String r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "method");
    }

    @Override // v30.a
    public final void c(com.bytedance.android.monitorV2.webview.c r1) {
    }

    @Override // v30.a
    public final void d(com.bytedance.android.monitor.webview.b r1) {
    }

    static {
        a = new f();
    }

    @Override // v30.a
    public final com.bytedance.android.monitorV2.webview.c b() {
        m.f.getClass();
        return new com.bytedance.android.monitorV2.webview.c();
    }

    @Override // v30.a
    public final com.bytedance.android.monitor.webview.b buildConfig() {
        h.g.getClass();
        return new com.bytedance.android.monitor.webview.b();
    }

    public final v30.a e() {
        if (LiveInitSettingKeys.get_LIVE_WEBVIEW_USE_MONITOR() == false) goto L6;
        return d.b;
    L6:
        return this;
    }
}
