package com.ss.android.lark.chameleon.pluginsystem;

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
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient;
import com.ss.android.lark.chameleon.basewebview.interfaces.ILarkWebViewContext;
import f06.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ExtendableWebChromeClient extends LarkBaseWebChromeClient {
    private List<WebChromeClient> delegates;

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Bitmap r1 = r0.next().getDefaultVideoPoster();
        if (r1 == null) goto L4;
        return r1;
    L9:
        return super.getDefaultVideoPoster();
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        r0.next().getVideoLoadingProgressView();
        goto L4
    L7:
        return super.getVideoLoadingProgressView();
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onGeolocationPermissionsHidePrompt();
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onHideCustomView() {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onHideCustomView();
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsTimeout() {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().onJsTimeout() == false) goto L4;
        return true;
    L10:
        return super.onJsTimeout();
    }

    public ExtendableWebChromeClient(ILarkWebViewContext r1) {
        super(r1);
        this.delegates = new CopyOnWriteArrayList();
    }

    public void addWebChromeClientDelegate(WebChromeClient r2) {
        if (this.delegates.contains(r2) == true) goto L6;
        this.delegates.add(r2);
        return;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> r3) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().getVisitedHistory(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onCloseWindow(WebView r3) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onCloseWindow(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage r3) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().onConsoleMessage(r3) == false) goto L4;
        return true;
    L10:
        return super.onConsoleMessage(r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r3) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPermissionRequest(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onPermissionRequestCanceled(PermissionRequest r3) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onPermissionRequestCanceled(r3);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onRequestFocus(WebView r3) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onRequestFocus(r3);
        goto L4
    }

    public void removeWebChromeClientDelegate(WebChromeClient r2) {
        this.delegates.remove(r2);
    }

    public void sortDelegates(Comparator<WebChromeClient> r3) {
        ArrayList r0 = new ArrayList(this.delegates);
        Collections.sort(r0, r3);
        this.delegates.clear();
        this.delegates.addAll(r0);
    }

    public void addWebChromeClientDelegate(int r2, WebChromeClient r3) {
        if (this.delegates.contains(r3) == true) goto L6;
        ListProtector.add(this.delegates, r2, r3);
        return;
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String r21, GeolocationPermissions.Callback r22) {
        ArrayList r2 = new ArrayList();
        Object[] r3 = {r21, r22};
        f06.b r13 = new f06.b();
        g06.a r4 = (g06.a) ApiHookConfig.b.get(100003);
        if (r4 == null) goto L5;
        f06.a[] r5 = r4.i;
    L6:
        f06.a[] r11 = r5;
        int r10 = r11.length;
        int r9 = 0;
    L8:
        if (r9 >= r10) goto L15;
        f06.a r8 = r11[r9];
        int r17 = r9;
        int r18 = r10;
        f06.a[] r19 = r11;
        d r6 = r8.preInvoke(100003, "com/ss/android/lark/chameleon/pluginsystem/ExtendableWebChromeClient", "onGeolocationPermissionsShowPrompt", this, r3, "void", r13);     // Catch: Exception -> L24
        if (r6.a == true) goto L17;
        r2.add(r8);     // Catch: Exception -> L24
    L17:
        if (r6.a == false) goto L19;
        return;
    L19:
        Iterator<WebChromeClient> r7 = this.delegates.iterator();
    L21:
        if (r7.hasNext() == false) goto L23;
        r7.next().onGeolocationPermissionsShowPrompt(r21, r22);
        goto L21
    L23:
        return;
    L14:
        r9 = r17 + 1;
        r10 = r18;
        r11 = r19;
        goto L8
    L15:
        r6 = new d(false, null);
        goto L17
    L5:
        r5 = ApiHookConfig.d;
        goto L6
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onProgressChanged(WebView r3, int r4) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onProgressChanged(r3, r4);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onReceivedIcon(WebView r3, Bitmap r4) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedIcon(r3, r4);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r3, String r4) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedTitle(r3, r4);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onShowCustomView(View r3, WebChromeClient.CustomViewCallback r4) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onShowCustomView(r3, r4);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onConsoleMessage(String r3, int r4, String r5) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onConsoleMessage(r3, r4, r5);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onReceivedTouchIconUrl(WebView r3, String r4, boolean r5) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onReceivedTouchIconUrl(r3, r4, r5);
        goto L4
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onShowCustomView(View r3, int r4, WebChromeClient.CustomViewCallback r5) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onShowCustomView(r3, r4, r5);
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r1, ValueCallback<Uri[]> r2, WebChromeClient.FileChooserParams r3) {
        return super.onShowFileChooser(r1, r2, r3);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView r3, boolean r4, boolean r5, Message r6) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().onCreateWindow(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onCreateWindow(r3, r4, r5, r6);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r3, String r4, String r5, JsResult r6) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().onJsAlert(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onJsAlert(r3, r4, r5, r6);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r3, String r4, String r5, JsResult r6) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().onJsBeforeUnload(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onJsBeforeUnload(r3, r4, r5, r6);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r3, String r4, String r5, JsResult r6) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().onJsConfirm(r3, r4, r5, r6) == false) goto L4;
        return true;
    L10:
        return super.onJsConfirm(r3, r4, r5, r6);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r9, String r10, String r11, String r12, JsPromptResult r13) {
        Iterator<WebChromeClient> r0 = this.delegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        if (r0.next().onJsPrompt(r9, r10, r11, r12, r13) == false) goto L4;
        return true;
    L10:
        return super.onJsPrompt(r9, r10, r11, r12, r13);
    }

    @Override // com.ss.android.lark.chameleon.basewebview.client.LarkBaseWebChromeClient, android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String r14, String r15, long r16, long r18, long r20, WebStorage.QuotaUpdater r22) {
        Iterator<WebChromeClient> r1 = this.delegates.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onExceededDatabaseQuota(r14, r15, r16, r18, r20, r22);
        goto L4
    }
}
