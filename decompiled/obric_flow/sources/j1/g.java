package j1;

import android.webkit.WebMessagePort;
import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort$JSInterface;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends i2.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f18229c;
    public final l2.a d;
    public WebMessagePort e;

    public g(WeakReference r5, l2.a r10) {
        Intrinsics.checkNotNullParameter(r5, "webViewReference");
        Intrinsics.checkNotNullParameter(r10, "remoteMessageCache");
        this.f18229c = r5;
        this.d = r10;
    }

    @Override // i2.c
    public final void a() {
        super.a();
        this.d.a();
        c1.b.a(new f(this, 0));
        WebView r5 = (WebView) this.f18229c.get();
        if (r5 == null) goto L6;
        WeakHashMap r10 = WebViewAIBridgePort$JSInterface.f1797c;
        Intrinsics.checkNotNullParameter(r5, "webView");
        c1.b.b(new hh.c(r5, 2));
        return;
    }

    @Override // i2.c
    public final void b(i2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "consumer");
        com.bytedance.ai.applet.render.core.lynx.c r10 = new com.bytedance.ai.applet.render.core.lynx.c(r5, 2);
        this.d.b(r10);
    }

    @Override // i2.c
    public final void c() {
        super.c();
        c1.b.b(new f(this, 1));
    }

    @Override // i2.c
    public final void d(j2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "messageWrapper");
        c1.b.a(new a2.b(27, r5, this));
    }
}
