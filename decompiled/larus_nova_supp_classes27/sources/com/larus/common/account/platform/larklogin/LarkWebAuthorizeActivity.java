package com.larus.common.account.platform.larklogin;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.disk.api.CacheHandlerBusiness;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import com.larus.utils.y0;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0003\u0017\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\b\u0010\u0016\u001a\u00020\rH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/common/account/platform/larklogin/LarkWebAuthorizeActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", CacheHandlerBusiness.WEBVIEW, "Landroid/webkit/WebView;", "titleBar", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "url", "", "redirectUri", "state", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "setupTitle", "cancel", "setupWebView", "onAuthorizeResp", "uri", "removeAllCookie", "Companion", "LarkWebAuthorizeClient", "LarkWebAuthorizeChromeClient", "larkauth_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkWebAuthorizeActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int l = 0;
    public WebView g;
    public NovaTitleBarEx h;
    public String i;
    public String j;
    public String k;

    public static final class a {
    }

    public final class b extends WebChromeClient {
        public final /* synthetic */ LarkWebAuthorizeActivity a;

        public b(LarkWebAuthorizeActivity r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebChromeClient
        public final void onReceivedTitle(WebView r3, String r4) {
            if (r4 == null) goto L7;
            NovaTitleBarEx r5 = this.a.h;
            if (r5 == null) goto L8;
            NovaTitleBarEx.Y5(r5, r4, null, null, 6);
            return;
        L8:
            return;
        }
    }

    public final class c extends WebViewClient {
        public final /* synthetic */ LarkWebAuthorizeActivity a;

        public c(LarkWebAuthorizeActivity r1) {
            this.a = r1;
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView r6, String r7) {
            if (r7 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L28;
            String r3 = this.a.j;
            if (r3 == null) goto L17;
            if (StringsKt.startsWith$default(r7, r3, false, 2, null) == false) goto L17;
            this.a.O1(r7);
            return true;
        L17:
            if (y0.e(r7) == true) goto L28;
            FlowCommonAppCompatActivity r8 = this.a;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L21
            r8.startActivity(new Intent("android.intent.action.VIEW", UriProtector.parse(r7)));     // Catch: Throwable -> L21
            Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L21
        L23:
            LarkWebAuthorizeActivity r1 = this.a;
            Throwable r10 = Result.exceptionOrNull-impl(r9);
            if (r10 == null) goto L26;
            FLogger.a.e("LarkWebAuthorizeActivity", "execute deeplink {" + r7 + "} failed: " + r10);
            r1.N1();
        L26:
            return true;
        L21:
            th = move-exception;
            Result.Companion r4 = Result.Companion;
            r9 = Result.constructor-impl(ResultKt.createFailure(th));
        L28:
            return super.shouldOverrideUrlLoading(r6, r7);
        L5:
            if (r7.length() == 0) goto L8;
            r2 = false;
            goto L9
        }
    }

    static {
    }

    public final void N1() {
        O1(UriProtector.parse(this.j).buildUpon().appendQueryParameter("error", "access_denied").appendQueryParameter("state", this.k).build().toString());
    }

    public final void onBackPressed() {
        WebView r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L11;
        WebView r2 = this.g;
        if (r2 == null) goto L13;
        r2.goBack();
        return;
    L13:
        return;
    L11:
        N1();
        return;
    L5:
        if (r0.canGoBack() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(LarkWebAuthorizeActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(LarkWebAuthorizeActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L45
        if (r6 != null) goto L10;
    L13:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L45
        monitor-exit(r5);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L50:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L50
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L50
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L50
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L50
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L50
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L50
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L50;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L50
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r0 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public LarkWebAuthorizeActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O1(String r3) {
        Intent r0 = new Intent(this, LarkEntryActivity.class);
        r0.setData(UriProtector.parse(r3));
        startActivity(r0);
        CookieSyncManager r4 = CookieSyncManager.createInstance(this);
        CookieManager r1 = CookieManager.getInstance();
        r1.setAcceptCookie(true);
        r1.removeSessionCookie();
        r1.removeAllCookie();
        r4.sync();
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r12);
        setContentView(2131561790);
        Bundle r13 = getIntent().getExtras();
        String r0 = null;
        if (r13 == null) goto L13;
        String r14 = r13.getString("url");
    L14:
        this.i = r14;
        Bundle r15 = getIntent().getExtras();
        if (r15 == null) goto L17;
        String r16 = r15.getString("redirect_uri");
    L18:
        this.j = r16;
        Bundle r17 = getIntent().getExtras();
        if (r17 == null) goto L21;
        r0 = r17.getString("state");
    L21:
        this.k = r0;
        FLogger r18 = FLogger.a;
        StringBuilder r1 = new StringBuilder("oauth web params received, hasUrl=");
        String r2 = this.i;
        if (r2 != null) goto L24;
    L27:
        boolean r3 = true;
    L28:
        r1.append(!r3);
        r1.append(", hasRedirectUri=");
        String r4 = this.j;
        if (r4 != null) goto L31;
    L34:
        boolean r5 = true;
    L35:
        r1.append(!r5);
        r18.d("LarkWebAuthorizeActivity", r1.toString());
        this.g = (WebView) findViewById(2131393137);
        this.h = findViewById(2131388772);
        String r6 = this.i;
        if (r6 != null) goto L38;
    L41:
        boolean r7 = true;
    L42:
        if (r7 == true) goto L71;
        String r8 = this.j;
        if (r8 != null) goto L46;
    L49:
        boolean r9 = true;
    L50:
        if (r9 == true) goto L71;
        String r10 = this.k;
        if (r10 != null) goto L54;
    L57:
        boolean r11 = true;
    L58:
        if (r11 == true) goto L71;
        NovaTitleBarEx r20 = this.h;
        if (r20 == null) goto L63;
        NovaTitleBarEx.b6(r20, 2131241477, false, null, null, new o(this), 14);
    L63:
        NovaTitleBarEx r110 = this.h;
        if (r110 == null) goto L66;
        r110.setTitleMaxWidth(m0.b(this) - i5.l());
    L66:
        WebView r111 = this.g;
        if (r111 == null) goto L75;
        r111.getSettings().setJavaScriptEnabled(true);
        r111.getSettings().setDomStorageEnabled(true);
        r111.getSettings().setAllowFileAccess(false);
        r111.getSettings().setAllowContentAccess(false);
        r111.setWebViewClient(new c(this));
        r111.setWebChromeClient(new b(this));
        String r21 = this.i;
        if (r21 == null) goto L76;
        r111.loadUrl(r21);
        return;
    L76:
        return;
    L75:
        return;
    L54:
        if (r10.length() == 0) goto L57;
        r11 = false;
        goto L58
    L46:
        if (r8.length() == 0) goto L49;
        r9 = false;
    L71:
        r18.e("LarkWebAuthorizeActivity", "illegal oauth web params, Abort");
        N1();
        return;
    L38:
        if (r6.length() == 0) goto L41;
        r7 = false;
        goto L42
    L31:
        if (r4.length() == 0) goto L34;
        r5 = false;
        goto L35
    L24:
        if (r2.length() == 0) goto L27;
        r3 = false;
        goto L28
    L17:
        r16 = null;
        goto L18
    L13:
        r14 = null;
        goto L14
    }
}
