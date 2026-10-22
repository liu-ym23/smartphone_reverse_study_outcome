package com.obric.oui.window.permission;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.obric.cae.R;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;
import he.i;
import y0.d;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f6705m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebView f6706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f6707b;

    public class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WebViewActivity f6708a;

        public a(WebViewActivity r8) {
            this.f6708a = r8;
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView r8, String r10) {
            super.onPageFinished(r8, r10);
            r8.loadUrl("javascript:(function() { document.body.style.paddingTop = '96px';})()");
        }

        @Override // android.webkit.WebViewClient
        public final void onPageStarted(WebView r8, String r10, Bitmap r11) {
            super.onPageStarted(r8, r10, r11);
        }

        @Override // android.webkit.WebViewClient
        public final void onReceivedError(WebView r8, WebResourceRequest r10, WebResourceError r11) {
            super.onReceivedError(r8, r10, r11);
            StringBuilder r12 = new StringBuilder("onReceivedError: ");
            if (r11 == null) goto L5;
            CharSequence r13 = r11.getDescription();
        L6:
            r12.append(r13);
            Log.e("WebViewActivity", r12.toString());
            WebViewActivity r14 = this.f6708a;
            r14.f6706a.setVisibility(8);
            r14.f6707b.setVisibility(0);
            if (d.d(r14) == false) goto L9;
            TextView r15 = r14.f6707b;
            int r16 = R.string.tip_load_fail;
        L10:
            r15.setText(r16);
            r14.f6707b.setOnClickListener(new com.obric.cae.location.zpp.ui.a(r14, 3));
            return;
        L9:
            r15 = r14.f6707b;
            r16 = R.string.tip_load_fail_no_network;
            goto L10
        L5:
            r13 = "unknown error";
            goto L6
        }

        @Override // android.webkit.WebViewClient
        public final boolean shouldOverrideUrlLoading(WebView r8, WebResourceRequest r10) {
            String r11 = r10.getUrl().toString();
            if (r11.startsWith("tel:") == false) goto L5;
        L23:
            Intent r12 = new Intent("android.intent.action.VIEW", Uri.parse(r11));     // Catch: Exception -> L20
            r8.getContext().startActivity(r12);     // Catch: Exception -> L20
            return true;
        L20:
            Log.e("WebViewActivity", "shouldOverrideUrlLoading can resolve : ".concat(r11));
        L21:
            r8.loadUrl(r11);
            return true;
        L5:
            if (r11.startsWith("mailto:") == true) goto L23;
            if (r11.startsWith("sms:") == true) goto L23;
            if (r11.startsWith("smsto:") == true) goto L23;
            if (r11.startsWith("market:") == true) goto L23;
            if (r11.startsWith("geo:") == true) goto L23;
            if (r11.startsWith("whatsapp:") == true) goto L23;
            if (r11.startsWith("intent:") == false) goto L21;
            goto L21
        }
    }

    public class b extends WebChromeClient {
        @Override // android.webkit.WebChromeClient
        public final void onProgressChanged(WebView r8, int r10) {
        }
    }

    public WebViewActivity() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f6706a.canGoBack() == false) goto L5;
        this.f6706a.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    public final void onCreate(Bundle r10) {
        super.onCreate(r10);
        setContentView(R.layout.activity_webview);
        Window r11 = getWindow();
        r11.getDecorView().setSystemUiVisibility(1792);
        int r8 = Build.VERSION.SDK_INT;
        t2.b.f(this);
        r11.setStatusBarColor(0);
        r11.setNavigationBarColor(0);
        this.f6706a = (WebView) findViewById(R.id.webView);
        this.f6707b = (TextView) findViewById(R.id.errorView);
        String r12 = getIntent().getStringExtra("extra_title");
        if (TextUtils.isEmpty(r12) == false) goto L5;
        r12 = getString(R.string.title_privacy_policy_and_user_agreement);
    L5:
        OFloatingTitleBar r13 = (OFloatingTitleBar) findViewById(R.id.web_activity_title_bar);
        if (r13 == null) goto L16;
        r13.setCenterTitle(r12);
        com.google.android.material.search.a r14 = new com.google.android.material.search.a(this, 8);
        OUIFrameLayout r15 = r13.c(R.drawable.o_floating_title_bar_icon_back, r13.f6622y);
        r15.setOnClickListener(r14);
        OButtonGroup r16 = r13.f6609b;
        if (r16 == null) goto L14;
        r16.k(r15, new ViewGroup.MarginLayoutParams(-2, -2));
        OButtonGroup r17 = r13.f6609b;
        if (r17 == null) goto L12;
        r17.setVisibility(0);
        goto L16
    L12:
        i.j("startButtonGroup");
        throw null;
    L14:
        i.j("startButtonGroup");
        throw null;
    L16:
        this.f6706a.setLayerType(2, null);
        WebSettings r18 = this.f6706a.getSettings();
        r18.setJavaScriptEnabled(true);
        r18.setDomStorageEnabled(true);
        r18.setLoadWithOverviewMode(true);
        r18.setUseWideViewPort(true);
        if (r8 < 33) goto L19;
        r18.setAlgorithmicDarkeningAllowed(true);
    L19:
        this.f6706a.setWebViewClient(new a(this));
        this.f6706a.setWebChromeClient(new b());
        String r19 = getIntent().getStringExtra("extra_url");
        if (r19 == null) goto L23;
        this.f6706a.loadUrl(r19);
        return;
    }
}
