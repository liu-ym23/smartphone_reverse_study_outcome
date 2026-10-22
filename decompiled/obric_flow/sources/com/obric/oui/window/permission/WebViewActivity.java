package com.obric.oui.window.permission;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowInsetsController;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import com.lynx.tasm.behavior.a0;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.common.oui.R$string;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.jvm.internal.Intrinsics;
import ym.h;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f14915x = 0;
    public WebView s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f14916t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public a0 f14917u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public com.obric.oui.lisitem.a f14918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f14919w;

    public WebViewActivity() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.s.canGoBack() == false) goto L5;
        Log.d("WebViewActivity", "onBackPressed, go back");
        this.s.goBack();
        return;
    L5:
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r13) {
        super.onCreate(r13);
        setContentView(R$layout.activity_webview);
        Window r14 = getWindow();
        r14.getDecorView().setSystemUiVisibility(1792);
        int r5 = Build.VERSION.SDK_INT;
        Intrinsics.checkNotNullParameter(this, "<this>");
        Window r10 = getWindow();
        if (r10 != null) goto L5;
        WindowInsetsController r11 = null;
    L7:
        if (r11 == null) goto L23;
        int r12 = Resources.getSystem().getConfiguration().uiMode & 48;
        if (r12 != 32) goto L11;
        boolean r15 = true;
    L12:
        ps.a.a("ActivityUtils", "isSystemInDarkTheme: " + r15 + ", currentNightMode" + r12);
        if (r15 == false) goto L15;
    L22:
        r11.setSystemBarsAppearance(0, 8);
        r11.setSystemBarsAppearance(0, 16);
        goto L23
    L15:
        if (AppCompatDelegate.getDefaultNightMode() != 2) goto L17;
        boolean r16 = true;
    L18:
        ps.a.a("ActivityUtils", Intrinsics.stringPlus("isAppInDarkTheme: ", Boolean.valueOf(r16)));
        if (r16 == true) goto L22;
        r11.setSystemBarsAppearance(8, 8);
        r11.setSystemBarsAppearance(16, 16);
        goto L23
    L17:
        r16 = false;
        goto L18
    L11:
        r15 = false;
    L23:
        r14.setStatusBarColor(0);
        r14.setNavigationBarColor(0);
        r14.setNavigationBarContrastEnforced(false);
        WebView r17 = (WebView) findViewById(R$id.webView);
        this.s = r17;
        this.f14917u = new a0(r17);
        this.f14916t = (TextView) findViewById(R$id.errorView);
        String r18 = getIntent().getStringExtra("extra_title");
        if (TextUtils.isEmpty(r18) == false) goto L26;
        r18 = getString(R$string.title_privacy_policy_and_user_agreement);
    L26:
        OFloatingTitleBar r19 = (OFloatingTitleBar) findViewById(R$id.web_activity_title_bar);
        if (r19 == null) goto L29;
        r19.setCenterTitle(r18);
        r19.d(R$drawable.o_floating_title_bar_icon_back, -1, new e(this, 0));
    L29:
        this.s.setLayerType(2, null);
        WebSettings r110 = this.s.getSettings();
        r110.setJavaScriptEnabled(true);
        r110.setDomStorageEnabled(true);
        r110.setLoadWithOverviewMode(true);
        r110.setUseWideViewPort(true);
        if (r5 < 33) goto L32;
        androidx.activity.e.r(r110);
    L32:
        this.s.setAlpha(0.0f);
        this.s.setWebViewClient(new f(this));
        this.s.setWebChromeClient(new g());
        String r111 = getIntent().getStringExtra("extra_url");
        if (r111 == null) goto L35;
        Log.d("WebViewActivity", "onCreate: start load url ".concat(r111));
        this.s.loadUrl(r111);
    L35:
        this.s.setOnApplyWindowInsetsListener(new com.obric.oui.actionbar.v2.b(this, 3));
        return;
    L5:
        r11 = r10.getInsetsController();
        goto L7
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        WebView r5 = this.s;
        if (r5 == null) goto L9;
        r5.removeCallbacks(this.f14917u);
        com.obric.oui.lisitem.a r10 = this.f14918v;
        if (r10 == null) goto L7;
        this.s.removeCallbacks(r10);
    L7:
        this.s.stopLoading();
        this.s.removeAllViews();
        this.s.destroy();
        Log.d("WebViewActivity", "onDestroy, webView destroyed");
        return;
    }

    public final void x() {
        Log.w("WebViewActivity", "showErrorPage");
        this.f14919w = false;
        com.obric.oui.lisitem.a r5 = this.f14918v;
        if (r5 == null) goto L5;
        this.s.removeCallbacks(r5);
    L5:
        this.s.setVisibility(8);
        this.f14916t.setVisibility(0);
        if (h.k(this) == false) goto L8;
        this.f14916t.setText(R$string.tip_load_fail);
    L9:
        this.f14916t.setOnClickListener(new e(this, 1));
        return;
    L8:
        this.f14916t.setText(R$string.tip_load_fail_no_network);
        goto L9
    }
}
