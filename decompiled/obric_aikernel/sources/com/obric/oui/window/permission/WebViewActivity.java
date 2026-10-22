package com.obric.oui.window.permission;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import androidx.core.view.ViewCompat;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import da.d;
import u8.f;
import u8.h;
import u8.j;

/* JADX INFO: loaded from: classes2.dex */
public class WebViewActivity extends AppCompatActivity {
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private TextView errorView;
    private ProgressBar progressBar;
    private WebView webView;

    class a extends WebViewClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewActivity f7774a;

        a(WebViewActivity r10) {
            this.f7774a = r10;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView r10, String r11) {
            super.onPageFinished(r10, r11);
            WebViewActivity.access$000(this.f7774a).setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView r10, String r11, Bitmap r12) {
            super.onPageStarted(r10, r11, r12);
            WebViewActivity.access$000(this.f7774a).setVisibility(0);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView r10, WebResourceRequest r11, WebResourceError r12) {
            super.onReceivedError(r10, r11, r12);
            StringBuilder r13 = new StringBuilder();
            r13.append("onReceivedError: ");
            if (r12 == null) goto L5;
            CharSequence r14 = r12.getDescription();
        L6:
            r13.append(r14);
            Log.e("WebViewActivity", r13.toString());
            WebViewActivity.access$100(this.f7774a);
            return;
        L5:
            r14 = "unknown error";
            goto L6
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r10, WebResourceRequest r11) {
            String r12 = r11.getUrl().toString();
            if (r12.startsWith("tel:") == false) goto L5;
        L23:
            r10.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(r12)));     // Catch: Exception -> L20
            return true;
        L20:
            Log.e("WebViewActivity", "shouldOverrideUrlLoading can resolve : " + r12);
        L21:
            r10.loadUrl(r12);
            return true;
        L5:
            if (r12.startsWith(MailTo.MAILTO_SCHEME) == true) goto L23;
            if (r12.startsWith("sms:") == true) goto L23;
            if (r12.startsWith("smsto:") == true) goto L23;
            if (r12.startsWith("market:") == true) goto L23;
            if (r12.startsWith("geo:") == true) goto L23;
            if (r12.startsWith("whatsapp:") == true) goto L23;
            if (r12.startsWith("intent:") == false) goto L21;
            goto L21
        }
    }

    class b extends WebChromeClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewActivity f7775a;

        b(WebViewActivity r10) {
            this.f7775a = r10;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView r10, int r11) {
            WebViewActivity.access$000(this.f7775a).setProgress(r11);
            if (r11 != 100) goto L6;
            WebViewActivity.access$000(this.f7775a).setVisibility(8);
            return;
        }
    }

    public WebViewActivity() {
    }

    static /* synthetic */ ProgressBar access$000(WebViewActivity r10) {
        return r10.progressBar;
    }

    static /* synthetic */ void access$100(WebViewActivity r10) {
        r10.showErrorPage();
    }

    public static /* synthetic */ void c(WebViewActivity r10, View r11) {
        r10.lambda$onCreate$0(r11);
    }

    public static /* synthetic */ void d(WebViewActivity r10, View r11) {
        r10.lambda$showErrorPage$1(r11);
    }

    private Boolean isEdgeToEdge() {
        return Boolean.valueOf(!getWindow().getDecorView().getFitsSystemWindows());
    }

    private /* synthetic */ void lambda$onCreate$0(View r10) {
        finish();
    }

    private /* synthetic */ void lambda$showErrorPage$1(View r10) {
        if (d.a(this) == false) goto L6;
        this.errorView.setVisibility(8);
        this.webView.setVisibility(0);
        this.webView.reload();
        return;
    }

    public static void open(Context r10, String r11, String r12) {
        Intent r13 = new Intent(r10, WebViewActivity.class);
        r13.putExtra(EXTRA_URL, r11);
        r13.putExtra(EXTRA_TITLE, r12);
        r10.startActivity(r13);
    }

    private void showErrorPage() {
        this.webView.setVisibility(8);
        this.errorView.setVisibility(0);
        if (d.a(this) == false) goto L5;
        TextView r10 = this.errorView;
        int r11 = j.tip_load_fail;
    L6:
        r10.setText(r11);
        this.errorView.setOnClickListener(new c(this));
        return;
    L5:
        r10 = this.errorView;
        r11 = j.tip_load_fail_no_network;
        goto L6
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.webView.canGoBack() == false) goto L5;
        this.webView.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        View r10 = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (isEdgeToEdge().booleanValue() == false) goto L6;
        ViewCompat.setOnApplyWindowInsetsListener(r10, new AnonymousClass3(this));
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"SetJavaScriptEnabled"})
    protected void onCreate(@Nullable Bundle r10) {
        super.onCreate(r10);
        setContentView(h.activity_webview);
        Window r11 = getWindow();
        int r12 = u8.c.oui_bg_base_1;
        r11.setStatusBarColor(getColor(r12));
        r11.setNavigationBarColor(getColor(r12));
        int r13 = Build.VERSION.SDK_INT;
        if (r13 < 30) goto L5;
        da.a.a(this);
    L5:
        this.webView = (WebView) findViewById(f.webView);
        this.progressBar = (ProgressBar) findViewById(f.progressBar);
        this.errorView = (TextView) findViewById(f.errorView);
        String r14 = getIntent().getStringExtra(EXTRA_TITLE);
        if (TextUtils.isEmpty(r14) == false) goto L8;
        r14 = getString(j.title_privacy_policy_and_user_agreement);
    L8:
        OCTitleBar r15 = (OCTitleBar) findViewById(f.web_activity_title_bar);
        if (r15 == null) goto L13;
        r15.setTitleText(r14);
        OButton r16 = r15.getMLeftActionBack();
        if (r16 == null) goto L13;
        r16.setOnClickListener(new com.obric.oui.window.permission.b(this));
    L13:
        this.webView.setBackgroundColor(ContextCompat.getColor(this, r12));
        this.webView.setLayerType(2, null);
        WebSettings r17 = this.webView.getSettings();
        r17.setJavaScriptEnabled(true);
        r17.setDomStorageEnabled(true);
        r17.setLoadWithOverviewMode(true);
        r17.setUseWideViewPort(true);
        if (r13 < 33) goto L16;
        r17.setAlgorithmicDarkeningAllowed(true);
    L16:
        this.webView.setWebViewClient(new a(this));
        this.webView.setWebChromeClient(new b(this));
        String r18 = getIntent().getStringExtra(EXTRA_URL);
        if (r18 == null) goto L20;
        this.webView.loadUrl(r18);
        return;
    }
}
