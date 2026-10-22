package otb;

import android.os.Build;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class m implements e {
    public final WebView a;
    public j b;

    @Override // otb.e
    public final void a(h r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // otb.e
    public final void b(g r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // otb.e
    public final void getLoadingStatusCode() {
    }

    @Override // otb.e
    public final void getPerformanceTiming() {
    }

    @Override // otb.e
    public final void isFeatureSupport(String r2) {
        Intrinsics.checkNotNullParameter(r2, "feature");
    }

    @Override // otb.e
    public final void notifyV8ToGC() {
    }

    public m(WebView r2) {
        Intrinsics.checkNotNullParameter(r2, "webView");
        this.a = r2;
    }

    public final void c(j r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.b = r4;
        if (Build.VERSION.SDK_INT < 26) goto L14;
        WebViewClient r5 = this.a.getWebViewClient();     // Catch: Exception -> L10
        if ((r5 instanceof k) == false) goto L8;
        j r0 = this.b;     // Catch: Exception -> L10
        ((k) r5).b = r0;     // Catch: Exception -> L10
    L11:
        return;
    L8:
        this.a.setWebViewClient(new k(r5, this.b));     // Catch: Exception -> L10
    L15:
        return;
    }
}
