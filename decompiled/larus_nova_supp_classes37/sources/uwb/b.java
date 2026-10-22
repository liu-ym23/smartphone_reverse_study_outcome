package uwb;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.officesdk.utils.di.k;
import com.ss.android.lark.officesdk.utils.di.l;
import com.ss.android.lark.officewebview.base.OfficeWebView;
import com.ss.android.lark.officewebview.quality.safe.FileChooseHandlerV2;
import dxb.t;
import f06.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ntb.o;
import oxb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class b extends WebChromeClient {
    public final wwb.c a;
    public WebChromeClient b;
    public final FileChooseHandlerV2 c;

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        g r0 = (g) this.a.getServiceManager().a(g.class);
        if (r0 == null) goto L7;
        j.e("LarkBaseWebChromeClient", "getDefaultVideoPoster service handle");
        return r0.C();
    L7:
        if (this.b == null) goto L10;
        j.e("LarkBaseWebChromeClient", "getDefaultVideoPoster mClient handle");
        return this.b.getDefaultVideoPoster();
    L10:
        j.e("LarkBaseWebChromeClient", "getDefaultVideoPoster default");
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        if (this.b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "getVideoLoadingProgressView");
        return this.b.getVideoLoadingProgressView();
    L6:
        j.e("LarkBaseWebChromeClient", "getVideoLoadingProgressView");
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsHidePrompt");
        super.onGeolocationPermissionsHidePrompt();
        if (this.b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsHidePrompt mClient");
        this.b.onGeolocationPermissionsHidePrompt();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onHideCustomView() {
        j.e("LarkBaseWebChromeClient", "onHideCustomView");
        super.onHideCustomView();
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onHideCustomView();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L7;
        return r0.onJsTimeout();
    L7:
        return super.onJsTimeout();
    }

    public b(wwb.c r2) {
        this.a = r2;
        this.c = new FileChooseHandlerV2(r2.getWebView().getContext());
    }

    @Override // android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r3) {
        j.e("LarkBaseWebChromeClient", "getVisitedHistory");
        super.getVisitedHistory(r3);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.getVisitedHistory(r3);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onCloseWindow(WebView r3) {
        j.e("LarkBaseWebChromeClient", "onCloseWindow");
        super.onCloseWindow(r3);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onCloseWindow(r3);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r2) {
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L7;
        return r0.onConsoleMessage(r2);
    L7:
        return super.onConsoleMessage(r2);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r3) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebChromeClient", "onPermissionRequest mClient");
        this.b.onPermissionRequest(r3);
        return;
    L5:
        j.e("LarkBaseWebChromeClient", "onPermissionRequest default");
        super.onPermissionRequest(r3);
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r3) {
        if (this.b == null) goto L5;
        j.e("LarkBaseWebChromeClient", "onPermissionRequestCanceled mClient");
        this.b.onPermissionRequestCanceled(r3);
        return;
    L5:
        j.e("LarkBaseWebChromeClient", "onPermissionRequestCanceled default");
        super.onPermissionRequestCanceled(r3);
    }

    @Override // android.webkit.WebChromeClient
    public void onRequestFocus(WebView r2) {
        super.onRequestFocus(r2);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onRequestFocus(r2);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String r22, GeolocationPermissions.Callback r23) {
        ArrayList r11 = new ArrayList();
        Object[] r12 = {r22, r23};
        f06.b r14 = new f06.b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(100003);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r7 = r1;
        int r6 = r7.length;
        int r5 = 0;
    L8:
        if (r5 >= r6) goto L15;
        f06.a r4 = r7[r5];
        int r18 = r5;
        int r19 = r6;
        f06.a[] r20 = r7;
        d r2 = r4.preInvoke(100003, "com/ss/android/lark/officewebview/base/client/LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r12, "void", r14);     // Catch: Exception -> L23
        if (r2.a == true) goto L17;
        r11.add(r4);     // Catch: Exception -> L23
    L17:
        if (r2.a == false) goto L19;
        return;
    L19:
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt");
        super.onGeolocationPermissionsShowPrompt(r22, r23);
        if (this.b == null) goto L29;
        j.e("LarkBaseWebChromeClient", "onGeolocationPermissionsShowPrompt default");
        this.b.onGeolocationPermissionsShowPrompt(r22, r23);
        return;
    L29:
        return;
    L14:
        r5 = r18 + 1;
        r6 = r19;
        r7 = r20;
        goto L8
    L15:
        r2 = new d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView r3, int r4) {
        j.e("LarkBaseWebChromeClient", "onProgressChanged " + r4);
        super.onProgressChanged(r3, r4);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L5;
        r0.onProgressChanged(r3, r4);
    L5:
        int r5 = com.ss.android.lark.officewebview.util.a.a;
        Intrinsics.checkNotNullParameter(r3, "view");
        zwb.a r6 = com.ss.android.lark.officewebview.util.a.C0081a.a();
        if (r6 == null) goto L9;
        r6.f();
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r3, Bitmap r4) {
        j.e("LarkBaseWebChromeClient", "onReceiveIcon");
        super.onReceivedIcon(r3, r4);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedIcon(r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r3, String r4) {
        j.e("LarkBaseWebChromeClient", "onReceivedTitle");
        super.onReceivedTitle(r3, r4);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onReceivedTitle(r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r3, WebChromeClient.CustomViewCallback r4) {
        j.e("LarkBaseWebChromeClient", "onShowCustomView");
        super.onShowCustomView(r3, r4);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onShowCustomView(r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String r2, int r3, String r4) {
        super.onConsoleMessage(r2, r3, r4);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onConsoleMessage(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r3, String r4, boolean r5) {
        j.e("LarkBaseWebChromeClient", "onReceivedTouchIconUrl , precomposed = " + r5);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L5;
        r0.onReceivedTouchIconUrl(r3, r4, r5);
    L5:
        super.onReceivedTouchIconUrl(r3, r4, r5);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View r2, int r3, WebChromeClient.CustomViewCallback r4) {
        super.onShowCustomView(r2, r3, r4);
        WebChromeClient r0 = this.b;
        if (r0 == null) goto L6;
        r0.onShowCustomView(r2, r3, r4);
        return;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r10, ValueCallback<Uri[]> r11, WebChromeClient.FileChooserParams r12) {
        int r0 = t.a;
        OfficeWebView r1 = this.a.getWebView();
        Intrinsics.checkNotNullParameter("input", "tag");
        dxb.c.a r2 = dxb.c.a;
        int r3 = l.a;
        o r4 = l.a.a();
        if (r4 == null) goto L6;
        o.a r5 = r4.d();
        if (r5 == null) goto L6;
    L7:
        Intrinsics.checkNotNullParameter("tag", "key");
        r5.a("tag");
        new HashMap();
        r5.b();
        if (r1 != null) goto L31;
        Map<String, Object> r6 = null;
    L14:
        if (r6 != null) goto L16;
    L18:
        boolean r7 = false;
    L19:
        if (r7 == false) goto L21;
        r5.b();     // Catch: Throwable -> L10
    L21:
        r5.flush();     // Catch: Throwable -> L10
        WebChromeClient r8 = this.b;
        if (r8 == null) goto L28;
        boolean r13 = r8.onShowFileChooser(r10, r11, r12);
        j.e("LarkBaseWebChromeClient", "onShowFileChooser mClient clientResult = " + r13);
        if (r13 == true) goto L27;
        FileChooseHandlerV2 r9 = this.c;
        r9.getClass();
        Intrinsics.checkNotNull(r12);
        r9.g(null, r11, r12.getAcceptTypes(), r12, false);
    L27:
        return true;
    L28:
        j.e("LarkBaseWebChromeClient", "onShowFileChooser default");
        FileChooseHandlerV2 r14 = this.c;
        r14.getClass();
        Intrinsics.checkNotNull(r12);
        r14.g(null, r11, r12.getAcceptTypes(), r12, false);
        return true;
    L10:
        th = move-exception;
        throw th;
    L16:
        if ((!r6.isEmpty()) != true) goto L18;
        r7 = true;
        goto L19
    L31:
        r6 = r1.getCommonParams();     // Catch: Throwable -> L10
    L6:
        r5 = new k();
        goto L7
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r3, boolean r4, boolean r5, Message r6) {
        if (this.b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onCreateWindow mClient");
        return this.b.onCreateWindow(r3, r4, r5, r6);
    L6:
        j.e("LarkBaseWebChromeClient", "onCreateWindow default");
        return super.onCreateWindow(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r3, String r4, String r5, JsResult r6) {
        if (this.b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsAlert mClient");
        return this.b.onJsAlert(r3, r4, r5, r6);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsAlert default");
        return super.onJsAlert(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r3, String r4, String r5, JsResult r6) {
        if (this.b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsBeforeUnload mClient");
        return this.b.onJsBeforeUnload(r3, r4, r5, r6);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsBeforeUnload default");
        return super.onJsBeforeUnload(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r3, String r4, String r5, JsResult r6) {
        if (this.b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsConfirm mClient");
        return this.b.onJsConfirm(r3, r4, r5, r6);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsConfirm default");
        return super.onJsConfirm(r3, r4, r5, r6);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r9, String r10, String r11, String r12, JsPromptResult r13) {
        if (this.b == null) goto L6;
        j.e("LarkBaseWebChromeClient", "onJsPrompt mClient");
        return this.b.onJsPrompt(r9, r10, r11, r12, r13);
    L6:
        j.e("LarkBaseWebChromeClient", "onJsPrompt default");
        return super.onJsPrompt(r9, r10, r11, r12, r13);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r1, String r2, long r3, long r5, long r7, WebStorage.QuotaUpdater r9) {
        super.onExceededDatabaseQuota(r1, r2, r3, r5, r7, r9);
    }
}
