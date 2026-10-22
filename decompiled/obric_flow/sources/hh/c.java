package hh;

import android.webkit.WebView;
import com.bytedance.ai.applet.render.core.web.WebViewAIBridgePort$JSInterface;
import com.bytedance.pia.core.bridge.channel.WebViewPort$JSInterface;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f17325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f17326b;

    public /* synthetic */ c(WebView r5, int r10) {
        this.f17325a = r10;
        this.f17326b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WebView r5 = this.f17326b;
        switch(this.f17325a) {
            case 0: goto L11;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        r5.removeJavascriptInterface("AppletBridgeModule");
        WebViewAIBridgePort$JSInterface.f1797c.remove(r5);
        return;
    L6:
        WeakHashMap r10 = WebViewPort$JSInterface.f6958c;
        if (r10.get(r5) != null) goto L13;
        WebViewPort$JSInterface r11 = new WebViewPort$JSInterface();
        r5.addJavascriptInterface(r11, "pia_bridge");
        r10.put(r5, r11);
        return;
    L13:
        return;
    L11:
        WeakHashMap r12 = WebViewPort$JSInterface.f6958c;
        r5.removeJavascriptInterface("pia_bridge");
        WebViewPort$JSInterface.f6958c.remove(r5);
    }
}
