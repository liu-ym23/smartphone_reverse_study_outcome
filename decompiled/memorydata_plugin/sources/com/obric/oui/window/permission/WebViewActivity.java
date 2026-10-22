package com.obric.oui.window.permission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.plugin.R;
import com.obric.oui.c.d;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class WebViewActivity extends AppCompatActivity {
    private static final String EXTRA_FLOATING_TRANSITION_ENABLED = "extra_floating_transition_enabled";
    private static final String EXTRA_TITLE = "extra_title";
    private static final String EXTRA_URL = "extra_url";
    private static final String QUERY_THEME = "theme";
    private static final String QUERY_THEME_DARK = "o_dark";
    private static final String TAG = "WebViewActivity";
    private TextView errorView;
    private Runnable mPendingReloadTimeoutRunnable;
    private a mPendingShowWebViewRunnable;
    private boolean mReloadingFromErrorPage;
    private WebView webView;

    private static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<WebView> f14914a;

        public a(WebView r2) {
            this.f14914a = new WeakReference(r2);
        }

        @Override // java.lang.Runnable
        public void run() {
            WebView r2 = (WebView) ZeusTransformUtils.preCheckCast(this.f14914a.get(), WebView.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            r2.setAlpha(1.0f);
            return;
        }
    }

    public WebViewActivity() {
    }

    static /* synthetic */ WebView access$000(WebViewActivity r2) {
        return ((WebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebViewActivity.class, "com.obric.memorydata.plugin")).webView;
    }

    static /* synthetic */ boolean access$100(WebViewActivity r2) {
        return ((WebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebViewActivity.class, "com.obric.memorydata.plugin")).mReloadingFromErrorPage;
    }

    static /* synthetic */ boolean access$102(WebViewActivity r2, boolean r3) {
        ((WebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebViewActivity.class, "com.obric.memorydata.plugin")).mReloadingFromErrorPage = r3;
        return r3;
    }

    static /* synthetic */ Runnable access$200(WebViewActivity r2) {
        return ((WebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebViewActivity.class, "com.obric.memorydata.plugin")).mPendingReloadTimeoutRunnable;
    }

    static /* synthetic */ TextView access$300(WebViewActivity r2) {
        return ((WebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebViewActivity.class, "com.obric.memorydata.plugin")).errorView;
    }

    static /* synthetic */ a access$400(WebViewActivity r2) {
        return ((WebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebViewActivity.class, "com.obric.memorydata.plugin")).mPendingShowWebViewRunnable;
    }

    static /* synthetic */ void access$500(WebViewActivity r2) {
        ((WebViewActivity) ZeusTransformUtils.wrapperContextForParams(r2, WebViewActivity.class, "com.obric.memorydata.plugin")).showErrorPage();
    }

    private String getNightModeUrl(String r9) {
        if (isActivityInNightMode() == true) goto L5;
    L22:
        return r9;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L22;
        Uri r8 = Uri.parse(r9);
        if (QUERY_THEME_DARK.equals(r8.getQueryParameter(QUERY_THEME)) == false) goto L10;
        return r9;
    L10:
        Uri.Builder r10 = r8.buildUpon().clearQuery();
        Iterator<String> r1 = r8.getQueryParameterNames().iterator();
    L12:
        if (r1.hasNext() == false) goto L20;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (QUERY_THEME.equals(r3) == true) goto L12;
        Iterator<String> r4 = r8.getQueryParameters(r3).iterator();
    L18:
        if (r4.hasNext() == false) goto L12;
        r10.appendQueryParameter(r3, (String) ZeusTransformUtils.preCheckCast(r4.next(), String.class, "com.obric.memorydata.plugin"));
        goto L18
    L20:
        r10.appendQueryParameter(QUERY_THEME, QUERY_THEME_DARK);
        return r10.build().toString();
    }

    private boolean isActivityInNightMode() {
        if ((ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static void open(Context r2, String r3, String r4) {
        open((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"), r3, r4, false);
    }

    public static void open(Context r3, String r4, String r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intent r0 = new Intent(r7, WebViewActivity.class);
        r0.putExtra(EXTRA_URL, r4);
        r0.putExtra(EXTRA_TITLE, r5);
        r0.putExtra(EXTRA_FLOATING_TRANSITION_ENABLED, r6);
        ZeusTransformUtils.startActivity(r7, r0, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void showErrorPage() {
        Log.w(TAG, "showErrorPage");
        WebView r0 = this.webView;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mReloadingFromErrorPage = false;
        Runnable r2 = this.mPendingReloadTimeoutRunnable;
        if (r2 == null) goto L8;
        r0.removeCallbacks(r2);
    L8:
        r0.setVisibility(8);
        this.errorView.setVisibility(0);
        if (d.a(this) == false) goto L11;
        TextView r1 = this.errorView;
        int r3 = R.string.tip_load_fail;
        String r4 = "tip_load_fail";
    L12:
        r1.setText(ZeusTransformUtils.mapRes(r3, TypedValues.Custom.S_STRING, r4));
        this.errorView.setOnClickListener(new $$Lambda$WebViewActivity$0LOJiglti1Ydu_3LWfq0wrr6yLw(this));
        return;
    L11:
        r1 = this.errorView;
        r3 = R.string.tip_load_fail_no_network;
        r4 = "tip_load_fail_no_network";
        goto L12
    }

    public /* synthetic */ void lambda$onCreate$0$WebViewActivity(View r1) {
        onBackPressed();
    }

    public /* synthetic */ WindowInsets lambda$onCreate$1$WebViewActivity(View r4, WindowInsets r5) {
        int r0 = com.obric.oui.window.a.a(r4, r5).e;
        if (com.obric.oui.window.a.f((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L5;
        r0 = 0;
    L5:
        updateLayoutForInsetBottom(r0);
        return r5;
    }

    public /* synthetic */ void lambda$showErrorPage$2$WebViewActivity() {
        if (this.mReloadingFromErrorPage == false) goto L6;
        Log.w(TAG, "reload timeout, keep showing error page");
        showErrorPage();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showErrorPage$3$WebViewActivity(View r3) {
        WebView r4 = this.webView;
        if (r4 != null) goto L5;
        return;
    L5:
        if (d.a(this) == false) goto L12;
        this.errorView.setVisibility(8);
        r4.setVisibility(0);
        Log.d(TAG, "onClick, reload");
        r4.reload();
        this.mReloadingFromErrorPage = true;
        if (this.mPendingReloadTimeoutRunnable != null) goto L9;
        this.mPendingReloadTimeoutRunnable = new $$Lambda$WebViewActivity$CfWZF_vYK5z7fnnbRD6mBnPNMg(this);
    L9:
        r4.removeCallbacks(this.mPendingReloadTimeoutRunnable);
        r4.postDelayed(this.mPendingReloadTimeoutRunnable, 3000);
        return;
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        WebView r0 = this.webView;
        if (r0 != null) goto L5;
    L7:
        finish();
        return;
    L5:
        if (r0.canGoBack() == false) goto L7;
        Log.d(TAG, "onBackPressed, go back");
        this.webView.goBack();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r6) {
        super.onCreate(r6);
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_webview, "layout", "activity_webview"));
        Window r7 = getWindow();
        r7.getDecorView().setSystemUiVisibility(1792);
        if (Build.VERSION.SDK_INT < 30) goto L5;
        com.obric.oui.c.a.a(this);
    L5:
        r7.setStatusBarColor(0);
        r7.setNavigationBarColor(0);
        if (Build.VERSION.SDK_INT < 29) goto L8;
        r7.setNavigationBarContrastEnforced(false);
    L8:
        this.webView = (WebView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.webView, OaidModel.KEY_ID, "webView")), WebView.class, "com.obric.memorydata.plugin");
        this.mPendingShowWebViewRunnable = new a(this.webView);
        this.errorView = (TextView) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.errorView, OaidModel.KEY_ID, "errorView")), TextView.class, "com.obric.memorydata.plugin");
        String r8 = getIntent().getStringExtra(EXTRA_TITLE);
        if (TextUtils.isEmpty(r8) == false) goto L11;
        r8 = getString(ZeusTransformUtils.mapRes(R.string.title_privacy_policy_and_user_agreement, TypedValues.Custom.S_STRING, "title_privacy_policy_and_user_agreement"));
    L11:
        OFloatingTitleBar r1 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.web_activity_title_bar, OaidModel.KEY_ID, "web_activity_title_bar")), OFloatingTitleBar.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L16;
        r1.setCenterTitle(r8);
        r1.a(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), -1, new $$Lambda$WebViewActivity$3ORsaZxDWobp3DttiCjJptEjno(this));
        if (getIntent().getBooleanExtra(EXTRA_FLOATING_TRANSITION_ENABLED, false) == false) goto L16;
        r1.setFloatingTransitionEnabled(true);
    L16:
        this.webView.setLayerType(2, null);
        WebSettings r9 = this.webView.getSettings();
        r9.setJavaScriptEnabled(true);
        r9.setDomStorageEnabled(true);
        r9.setLoadWithOverviewMode(true);
        r9.setUseWideViewPort(true);
        if (Build.VERSION.SDK_INT < 33) goto L19;
        r9.setAlgorithmicDarkeningAllowed(true);
    L19:
        this.webView.setAlpha(0.0f);
        this.webView.setWebViewClient(new AnonymousClass1(this));
        this.webView.setWebChromeClient(new AnonymousClass2(this));
        String r10 = getNightModeUrl(getIntent().getStringExtra(EXTRA_URL));
        if (r10 == null) goto L22;
        Log.d(TAG, "onCreate: start load url " + r10);
        this.webView.loadUrl(r10);
    L22:
        this.webView.setOnApplyWindowInsetsListener(new $$Lambda$WebViewActivity$VBsMnfqpUH9Qyy1lU9jehT9h1FY(this));
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        WebView r0 = this.webView;
        this.webView = null;
        if (r0 == null) goto L11;
        r0.removeCallbacks(this.mPendingShowWebViewRunnable);
        Runnable r2 = this.mPendingReloadTimeoutRunnable;
        if (r2 == null) goto L7;
        r0.removeCallbacks(r2);
    L7:
        r0.setScrollbarFadingEnabled(false);
        r0.setOnApplyWindowInsetsListener(null);
        r0.setWebChromeClient(null);
        r0.setWebViewClient(null);
        r0.stopLoading();
        r0.loadUrl("about:blank");
        ViewGroup r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0.getParent(), ViewGroup.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L10;
        r3.removeView(r0);
    L10:
        r0.removeAllViews();
        r0.destroy();
        Log.d(TAG, "onDestroy, webView destroyed");
    L11:
        TextView r1 = this.errorView;
        if (r1 == null) goto L14;
        r1.setOnClickListener(null);
    L14:
        this.mPendingShowWebViewRunnable = null;
        this.mPendingReloadTimeoutRunnable = null;
        this.errorView = null;
        super.onDestroy();
    }

    public void updateLayoutForInsetBottom(int r4) {
        WebView r3 = this.webView;
        if (r3 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3.getLayoutParams(), ViewGroup.MarginLayoutParams.class) == false) goto L9;
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), ViewGroup.MarginLayoutParams.class, "com.obric.memorydata.plugin");
        r0.bottomMargin = r4;
        r3.setLayoutParams(r0);
        Log.d(TAG, "updateLayoutForInsetBottom, insetBottom: " + r4);
        return;
    }
}
