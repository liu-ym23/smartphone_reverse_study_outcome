package com.bytedance.webx.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bytedance.webx.core.webview.inner.WebViewContainerInner;
import java.util.Map;
import java.util.concurrent.Executor;
import uk.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class WebViewContainer extends WebViewContainerInner {
    public WebViewContainer(Context r5, AttributeSet r10, int r11) {
        super(r5, r10, r11);
    }

    @Override // android.webkit.WebView
    public final void addJavascriptInterface(Object r5, String r10) {
        getExtendableContext();
        a.a();
        super.addJavascriptInterface(r5, r10);
    }

    @Override // android.webkit.WebView
    public boolean canGoBack() {
        getExtendableContext();
        a.a();
        return super.canGoBack();
    }

    @Override // android.webkit.WebView
    public boolean canGoBackOrForward(int r5) {
        getExtendableContext();
        a.a();
        return super.canGoBackOrForward(r5);
    }

    @Override // android.webkit.WebView
    public boolean canGoForward() {
        getExtendableContext();
        a.a();
        return super.canGoForward();
    }

    @Override // android.webkit.WebView
    public final WebMessagePort[] createWebMessageChannel() {
        getExtendableContext();
        a.a();
        return super.createWebMessageChannel();
    }

    @Override // android.webkit.WebView
    public void destroy() {
        getExtendableContext();
        a.a();
        super.destroy();
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r5) {
        getExtendableContext();
        a.a();
        super.dispatchDraw(r5);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r5) {
        getExtendableContext();
        a.a();
        return super.dispatchKeyEvent(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        getExtendableContext();
        a.a();
        return super.dispatchTouchEvent(r5);
    }

    @Override // android.webkit.WebView
    public final void documentHasImages(Message r5) {
        getExtendableContext();
        a.a();
        super.documentHasImages(r5);
    }

    @Override // android.view.View
    public final void draw(Canvas r5) {
        getExtendableContext();
        a.a();
        super.draw(r5);
    }

    @Override // android.webkit.WebView
    public void evaluateJavascript(String r5, ValueCallback r10) {
        getExtendableContext();
        a.a();
        super.evaluateJavascript(r5, r10);
    }

    @Override // android.webkit.WebView
    public final void flingScroll(int r5, int r10) {
        getExtendableContext();
        a.a();
        super.flingScroll(r5, r10);
    }

    @Override // android.webkit.WebView
    public SslCertificate getCertificate() {
        getExtendableContext();
        a.a();
        return super.getCertificate();
    }

    @Override // android.webkit.WebView
    public final String[] getHttpAuthUsernamePassword(String r5, String r10) {
        getExtendableContext();
        a.a();
        return super.getHttpAuthUsernamePassword(r5, r10);
    }

    @Override // android.webkit.WebView
    public WebSettings getSettings() {
        getExtendableContext();
        a.a();
        return super.getSettings();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public WebChromeClient getWebChromeClient() {
        getExtendableContext();
        a.a();
        return super.getWebChromeClient();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public WebViewClient getWebViewClient() {
        getExtendableContext();
        a.a();
        return super.getWebViewClient();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    @RequiresApi(29)
    public WebViewRenderProcess getWebViewRenderProcess() {
        getExtendableContext();
        a.a();
        return super.getWebViewRenderProcess();
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    @RequiresApi(29)
    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        getExtendableContext();
        a.a();
        return super.getWebViewRenderProcessClient();
    }

    @Override // android.webkit.WebView
    public void goBack() {
        getExtendableContext();
        a.a();
        super.goBack();
    }

    @Override // android.webkit.WebView
    public void goBackOrForward(int r5) {
        getExtendableContext();
        a.a();
        super.goBackOrForward(r5);
    }

    @Override // android.webkit.WebView
    public void goForward() {
        getExtendableContext();
        a.a();
        super.goForward();
    }

    @Override // android.webkit.WebView
    public void loadData(String r5, String r10, String r11) {
        getExtendableContext();
        a.a();
        super.loadData(r5, r10, r11);
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String r5, String r10, String r11, String r12, String r13) {
        getExtendableContext();
        a.a();
        super.loadDataWithBaseURL(r5, r10, r11, r12, r13);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r5, Map r10) {
        getExtendableContext();
        a.a();
        super.loadUrl(r5, r10);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        getExtendableContext();
        a.a();
        super.onAttachedToWindow();
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onCheckIsTextEditor() {
        getExtendableContext();
        a.a();
        return super.onCheckIsTextEditor();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onConfigurationChanged(Configuration r5) {
        getExtendableContext();
        a.a();
        super.onConfigurationChanged(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo r5) {
        getExtendableContext();
        a.a();
        return super.onCreateInputConnection(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onDragEvent(DragEvent r5) {
        getExtendableContext();
        a.a();
        return super.onDragEvent(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onDraw(Canvas r5) {
        getExtendableContext();
        a.a();
        super.onDraw(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onFinishTemporaryDetach() {
        getExtendableContext();
        a.a();
        super.onFinishTemporaryDetach();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onFocusChanged(boolean r5, int r10, Rect r11) {
        getExtendableContext();
        a.a();
        super.onFocusChanged(r5, r10, r11);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent r5) {
        getExtendableContext();
        a.a();
        return super.onGenericMotionEvent(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onHoverEvent(MotionEvent r5) {
        getExtendableContext();
        a.a();
        return super.onHoverEvent(r5);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r5) {
        getExtendableContext();
        a.a();
        return super.onInterceptTouchEvent(r5);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r5, KeyEvent r10) {
        getExtendableContext();
        a.a();
        return super.onKeyDown(r5, r10);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyMultiple(int r5, int r10, KeyEvent r11) {
        getExtendableContext();
        a.a();
        return super.onKeyMultiple(r5, r10, r11);
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int r5, KeyEvent r10) {
        getExtendableContext();
        a.a();
        return super.onKeyUp(r5, r10);
    }

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    public final void onMeasure(int r5, int r10) {
        getExtendableContext();
        a.a();
        super.onMeasure(r5, r10);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int r5, int r10, boolean r11, boolean r12) {
        getExtendableContext();
        a.a();
        super.onOverScrolled(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebView
    public void onPause() {
        getExtendableContext();
        a.a();
        super.onPause();
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onProvideAutofillVirtualStructure(ViewStructure r5, int r10) {
        getExtendableContext();
        a.a();
        super.onProvideAutofillVirtualStructure(r5, r10);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onProvideVirtualStructure(ViewStructure r5) {
        getExtendableContext();
        a.a();
        super.onProvideVirtualStructure(r5);
    }

    @Override // android.webkit.WebView
    public void onResume() {
        getExtendableContext();
        a.a();
        super.onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public void onScrollChanged(int r5, int r10, int r11, int r12) {
        getExtendableContext();
        a.a();
        super.onScrollChanged(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onSizeChanged(int r5, int r10, int r11, int r12) {
        getExtendableContext();
        a.a();
        super.onSizeChanged(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onStartTemporaryDetach() {
        getExtendableContext();
        a.a();
        super.onStartTemporaryDetach();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent r5) {
        getExtendableContext();
        a.a();
        return super.onTouchEvent(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTrackballEvent(MotionEvent r5) {
        getExtendableContext();
        a.a();
        return super.onTrackballEvent(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onVisibilityChanged(View r5, int r10) {
        getExtendableContext();
        a.a();
        super.onVisibilityChanged(r5, r10);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowFocusChanged(boolean r5) {
        getExtendableContext();
        a.a();
        super.onWindowFocusChanged(r5);
    }

    @Override // android.webkit.WebView, android.view.View
    public final void onWindowVisibilityChanged(int r5) {
        getExtendableContext();
        a.a();
        super.onWindowVisibilityChanged(r5);
    }

    @Override // android.view.View
    public boolean overScrollBy(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16, boolean r17) {
        getExtendableContext();
        a.a();
        return super.overScrollBy(r5, r10, r11, r12, r13, r14, r15, r16, r17);
    }

    @Override // android.webkit.WebView
    public final boolean pageDown(boolean r5) {
        getExtendableContext();
        a.a();
        return super.pageDown(r5);
    }

    @Override // android.webkit.WebView
    public final boolean pageUp(boolean r5) {
        getExtendableContext();
        a.a();
        return super.pageUp(r5);
    }

    @Override // android.webkit.WebView
    public void postUrl(String r5, byte[] r10) {
        getExtendableContext();
        a.a();
        super.postUrl(r5, r10);
    }

    @Override // android.webkit.WebView
    public final void postWebMessage(WebMessage r5, Uri r10) {
        getExtendableContext();
        a.a();
        super.postWebMessage(r5, r10);
    }

    @Override // android.webkit.WebView
    public void reload() {
        getExtendableContext();
        a.a();
        super.reload();
    }

    @Override // android.webkit.WebView
    public final void removeJavascriptInterface(String r5) {
        getExtendableContext();
        a.a();
        super.removeJavascriptInterface(r5);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int r5, Rect r10) {
        getExtendableContext();
        a.a();
        return super.requestFocus(r5, r10);
    }

    @Override // android.webkit.WebView
    public final WebBackForwardList restoreState(Bundle r5) {
        getExtendableContext();
        a.a();
        return super.restoreState(r5);
    }

    @Override // android.webkit.WebView
    public final void savePassword(String r5, String r10, String r11) {
        getExtendableContext();
        a.a();
        super.savePassword(r5, r10, r11);
    }

    @Override // android.webkit.WebView
    public final WebBackForwardList saveState(Bundle r5) {
        getExtendableContext();
        a.a();
        return super.saveState(r5);
    }

    @Override // android.webkit.WebView
    public final void saveWebArchive(String r5) {
        getExtendableContext();
        a.a();
        super.saveWebArchive(r5);
    }

    @Override // android.webkit.WebView
    public void setCertificate(SslCertificate r5) {
        getExtendableContext();
        a.a();
        super.setCertificate(r5);
    }

    @Override // android.webkit.WebView
    public void setDownloadListener(DownloadListener r5) {
        getExtendableContext();
        a.a();
        super.setDownloadListener(r5);
    }

    @Override // android.webkit.WebView
    public void setFindListener(WebView.FindListener r5) {
        getExtendableContext();
        a.a();
        super.setFindListener(r5);
    }

    @Override // android.webkit.WebView
    public final void setHttpAuthUsernamePassword(String r5, String r10, String r11, String r12) {
        getExtendableContext();
        a.a();
        super.setHttpAuthUsernamePassword(r5, r10, r11, r12);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebChromeClient(WebChromeClient r5) {
        getExtendableContext();
        a.a();
        super.setWebChromeClient(r5);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    public void setWebViewClient(WebViewClient r5) {
        getExtendableContext();
        a.a();
        super.setWebViewClient(r5);
    }

    @Override // android.webkit.WebView
    public final void setWebViewRenderProcessClient(Executor r5, WebViewRenderProcessClient r10) {
        getExtendableContext();
        a.a();
        super.setWebViewRenderProcessClient(r5, r10);
    }

    @Override // android.webkit.WebView
    public void stopLoading() {
        getExtendableContext();
        a.a();
        super.stopLoading();
    }

    @Override // android.webkit.WebView
    public final void zoomBy(float r5) {
        getExtendableContext();
        a.a();
        super.zoomBy(r5);
    }

    @Override // android.webkit.WebView
    public final boolean zoomIn() {
        getExtendableContext();
        a.a();
        return super.zoomIn();
    }

    @Override // android.webkit.WebView
    public final boolean zoomOut() {
        getExtendableContext();
        a.a();
        return super.zoomOut();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String r5) {
        getExtendableContext();
        a.a();
        super.loadUrl(r5);
    }

    @Override // android.webkit.WebView
    public final void saveWebArchive(String r5, boolean r10, ValueCallback r11) {
        getExtendableContext();
        a.a();
        super.saveWebArchive(r5, r10, r11);
    }

    @Override // com.bytedance.webx.core.webview.inner.WebViewContainerInner, android.webkit.WebView
    @RequiresApi(29)
    public void setWebViewRenderProcessClient(@Nullable WebViewRenderProcessClient r5) {
        getExtendableContext();
        a.a();
        super.setWebViewRenderProcessClient(r5);
    }
}
