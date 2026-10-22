package bd;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.ies.bullet.service.base.YieldError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c extends WebChromeClient {
    public void a(com.bytedance.frameworks.baselib.network.http.cronet.b r5) {
        throw new YieldError();
    }

    public boolean b(WebView r5, ValueCallback r10, ym.d r11) {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String r5, GeolocationPermissions.Callback r10) {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r5, String r10, String r11, JsResult r12) {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r5, String r10, String r11, JsResult r12) {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r5, String r10, String r11, JsResult r12) {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r5, String r10, String r11, String r12, JsPromptResult r13) {
        throw new YieldError();
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r5) {
        if (r5 == null) goto L5;
        Intrinsics.checkNotNullParameter(r5, "<this>");
        com.bytedance.frameworks.baselib.network.http.cronet.b r10 = new com.bytedance.frameworks.baselib.network.http.cronet.b(2);
    L6:
        a(r10);
        throw null;
    L5:
        r10 = null;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r5, ValueCallback r10, WebChromeClient.FileChooserParams r11) {
        if (r11 == null) goto L4;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        ym.d r12 = new ym.d(r11);
    L6:
        return b(r5, r10, r12);
    L4:
        r12 = null;
        goto L6
    }
}
