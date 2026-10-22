package com.bytedance.ies.bullet.service.base.web;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.Keep;
import bd.c;
import com.bytedance.ies.bullet.service.base.YieldError;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\nJ-\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0006\u0010\f¨\u0006\r"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher;", "Landroid/webkit/WebChromeClient;", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "uploadMsg", "", "openFileChooser", "(Landroid/webkit/ValueCallback;)V", "", "acceptType", "(Landroid/webkit/ValueCallback;Ljava/lang/String;)V", "capture", "(Landroid/webkit/ValueCallback;Ljava/lang/String;Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SourceDebugExtension({"SMAP\nWebChromeClientDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WebChromeClientDispatcher.kt\ncom/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Yield.kt\ncom/bytedance/ies/bullet/service/base/YieldKt\n*L\n1#1,249:1\n1819#2:250\n1820#2:256\n1819#2:257\n1820#2:263\n1819#2:264\n1820#2:270\n1819#2:271\n1820#2:277\n1819#2:278\n1820#2:284\n1819#2:285\n1820#2:291\n1819#2:292\n1820#2:298\n1819#2:299\n1820#2:305\n1819#2:306\n1820#2:312\n1819#2:313\n1820#2:319\n1819#2:320\n1820#2:326\n1819#2:327\n1820#2:333\n1819#2:334\n1820#2:340\n1819#2:341\n1820#2:347\n1819#2:348\n1820#2:354\n1819#2:355\n1820#2:361\n1819#2:362\n1820#2:368\n1819#2:369\n1820#2:375\n1819#2:376\n1820#2:382\n10#3,5:251\n10#3,5:258\n10#3,5:265\n10#3,5:272\n10#3,5:279\n10#3,5:286\n10#3,5:293\n10#3,5:300\n10#3,5:307\n10#3,5:314\n10#3,5:321\n10#3,5:328\n10#3,5:335\n10#3,5:342\n10#3,5:349\n10#3,5:356\n10#3,5:363\n10#3,5:370\n10#3,5:377\n*E\n*S KotlinDebug\n*F\n+ 1 WebChromeClientDispatcher.kt\ncom/bytedance/ies/bullet/service/base/web/WebChromeClientDispatcher\n*L\n41#1:250\n41#1:256\n56#1:257\n56#1:263\n69#1:264\n69#1:270\n78#1:271\n78#1:277\n91#1:278\n91#1:284\n103#1:285\n103#1:291\n112#1:292\n112#1:298\n121#1:299\n121#1:305\n133#1:306\n133#1:312\n143#1:313\n143#1:319\n152#1:320\n152#1:326\n165#1:327\n165#1:333\n174#1:334\n174#1:340\n185#1:341\n185#1:347\n198#1:348\n198#1:354\n207#1:355\n207#1:361\n218#1:362\n218#1:368\n227#1:369\n227#1:375\n243#1:376\n243#1:382\n42#1,5:251\n57#1,5:258\n70#1,5:265\n79#1,5:272\n92#1,5:279\n104#1,5:286\n113#1,5:293\n122#1,5:300\n134#1,5:307\n144#1,5:314\n153#1,5:321\n166#1,5:328\n175#1,5:335\n186#1,5:342\n199#1,5:349\n208#1,5:356\n219#1,5:363\n228#1,5:370\n244#1,5:377\n*E\n"})
public class WebChromeClientDispatcher extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f6021a;

    public WebChromeClientDispatcher() {
        this.f6021a = new CopyOnWriteArrayList();
    }

    @Override // android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        Iterator r5 = this.f6021a.iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        return ((c) r5.next()).getDefaultVideoPoster();
    L9:
        return super.getDefaultVideoPoster();
    }

    @Override // android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        Iterator r5 = this.f6021a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((c) r5.next()).getClass();     // Catch: YieldError -> L10
        throw new YieldError();     // Catch: YieldError -> L10
    L6:
        return super.getVideoLoadingProgressView();
    }

    @Override // android.webkit.WebChromeClient
    public final void onConsoleMessage(String r5, int r10, String r11) {
        super.onConsoleMessage(r5, r10, r11);
        Iterator r12 = this.f6021a.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ((c) r12.next()).onConsoleMessage(r5, r10, r11);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt();
        Iterator r5 = this.f6021a.iterator();
    L4:
        if (r5.hasNext() == false) goto L5;
        ((c) r5.next()).getClass();     // Catch: YieldError -> L9
        throw new YieldError();     // Catch: YieldError -> L9
    }

    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String r5, GeolocationPermissions.Callback r10) {
        super.onGeolocationPermissionsShowPrompt(r5, r10);
        Iterator r11 = this.f6021a.iterator();
    L4:
        if (r11.hasNext() == false) goto L5;
        ((c) r11.next()).getClass();     // Catch: YieldError -> L9
        throw new YieldError();     // Catch: YieldError -> L9
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        super.onHideCustomView();
        Iterator r5 = this.f6021a.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        ((c) r5.next()).onHideCustomView();     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r5, String r10, String r11, JsResult r12) {
        Iterator r13 = this.f6021a.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((c) r13.next()).getClass();     // Catch: YieldError -> L10
        throw new YieldError();     // Catch: YieldError -> L10
    L6:
        return super.onJsAlert(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView r5, String r10, String r11, JsResult r12) {
        Iterator r13 = this.f6021a.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((c) r13.next()).onJsBeforeUnload(r5, r10, r11, r12);     // Catch: YieldError -> L10
        throw null;     // Catch: YieldError -> L10
    L6:
        return super.onJsBeforeUnload(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView r5, String r10, String r11, JsResult r12) {
        Iterator r13 = this.f6021a.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        ((c) r13.next()).onJsConfirm(r5, r10, r11, r12);     // Catch: YieldError -> L10
        throw null;     // Catch: YieldError -> L10
    L6:
        return super.onJsConfirm(r5, r10, r11, r12);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r10, String r11, String r12, String r13, JsPromptResult r14) {
        Iterator r5 = this.f6021a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ((c) r5.next()).onJsPrompt(r10, r11, r12, r13, r14);     // Catch: YieldError -> L10
        throw null;     // Catch: YieldError -> L10
    L6:
        return super.onJsPrompt(r10, r11, r12, r13, r14);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r5) {
        Iterator r10 = this.f6021a.iterator();
    L4:
        if (r10.hasNext() == false) goto L5;
        ((c) r10.next()).onPermissionRequest(r5);     // Catch: YieldError -> L9
        throw null;     // Catch: YieldError -> L9
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r5, int r10) {
        super.onProgressChanged(r5, r10);
        Iterator r11 = this.f6021a.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ((c) r11.next()).onProgressChanged(r5, r10);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r5, String r10) {
        super.onReceivedTitle(r5, r10);
        Iterator r11 = this.f6021a.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ((c) r11.next()).onReceivedTitle(r5, r10);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r5, WebChromeClient.CustomViewCallback r10) {
        super.onShowCustomView(r5, r10);
        Iterator r11 = this.f6021a.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ((c) r11.next()).onShowCustomView(r5, r10);     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onShowFileChooser(WebView r5, ValueCallback r10, WebChromeClient.FileChooserParams r11) {
        Iterator r12 = this.f6021a.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        return ((c) r12.next()).onShowFileChooser(r5, r10, r11);
    L9:
        return super.onShowFileChooser(r5, r10, r11);
    }

    @Keep
    public final void openFileChooser(ValueCallback<Uri> r5) {
        Intrinsics.checkNotNullParameter(r5, "uploadMsg");
        Iterator r10 = this.f6021a.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        ((c) r10.next()).getClass();     // Catch: YieldError -> L9
        Intrinsics.checkNotNullParameter(r5, "uploadMsg");     // Catch: YieldError -> L9
        goto L4
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r5, int r10, WebChromeClient.CustomViewCallback r11) {
        super.onShowCustomView(r5, r10, r11);
        Iterator r12 = this.f6021a.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ((c) r12.next()).onShowCustomView(r5, r10, r11);     // Catch: YieldError -> L9
        goto L4
    }

    @Keep
    public final void openFileChooser(ValueCallback<Uri> r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "uploadMsg");
        Intrinsics.checkNotNullParameter(r10, "acceptType");
        Iterator r11 = this.f6021a.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        ((c) r11.next()).getClass();     // Catch: YieldError -> L9
        Intrinsics.checkNotNullParameter(r5, "uploadMsg");     // Catch: YieldError -> L9
        Intrinsics.checkNotNullParameter(r10, "acceptType");     // Catch: YieldError -> L9
        goto L4
    }

    @Keep
    public final void openFileChooser(ValueCallback<Uri> r5, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "uploadMsg");
        Intrinsics.checkNotNullParameter(r10, "acceptType");
        Intrinsics.checkNotNullParameter(r11, "capture");
        Iterator r12 = this.f6021a.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        ((c) r12.next()).getClass();     // Catch: YieldError -> L9
        Intrinsics.checkNotNullParameter(r5, "uploadMsg");     // Catch: YieldError -> L9
        Intrinsics.checkNotNullParameter(r10, "acceptType");     // Catch: YieldError -> L9
        Intrinsics.checkNotNullParameter(r11, "capture");     // Catch: YieldError -> L9
        goto L4
    }
}
