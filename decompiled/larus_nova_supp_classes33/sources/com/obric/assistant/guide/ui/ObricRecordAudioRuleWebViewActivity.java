package com.obric.assistant.guide.ui;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricActivityRecordAudioRuleWebviewBinding;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0018\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/guide/ui/ObricRecordAudioRuleWebViewActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/obric/assistant/impl/databinding/ObricActivityRecordAudioRuleWebviewBinding;", "webView", "Landroid/webkit/WebView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupWebView", "currentBinding", "openUrl", "", "onBackPressed", "onDestroy", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricRecordAudioRuleWebViewActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int h = 0;
    public WebView g;

    public static final class a {
    }

    static {
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
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
        finish();
        return;
    L5:
        if (r0.canGoBack() != true) goto L7;
        r1 = true;
        goto L7
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricRecordAudioRuleWebViewActivity.class.getName()));
    L5:
        WebView r0 = this.g;
        if (r0 == null) goto L8;
        r0.destroy();
    L8:
        this.g = null;
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ObricRecordAudioRuleWebViewActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map<Activity, Long> r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = r5.get(this);     // Catch: Throwable -> L45
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
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L42
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

    public ObricRecordAudioRuleWebViewActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r14) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        com.obric.assistant.settings.c0.a(this);
        super.onCreate(r14);
        boolean r15 = true;
        com.larus.utils.u.e(this, true, false);
        com.larus.utils.u.d(this);
        Window r1 = getWindow();
        if (r1 == null) goto L13;
        r1.setBackgroundDrawableResource(2131104374);
    L13:
        String r3 = null;
        View r2 = getLayoutInflater().inflate(2131563923, null, false);
        int r4 = 2131364679;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r2, 2131364679);
        if (r5 == null) goto L51;
        r4 = 2131369197;
        View r8 = ViewBindings.findChildViewById(r2, 2131369197);
        if (r8 == null) goto L51;
        r4 = 2131383297;
        ProgressBar r9 = (ProgressBar) ViewBindings.findChildViewById(r2, 2131383297);
        if (r9 == null) goto L51;
        r4 = 2131388807;
        if (ViewBindings.findChildViewById(r2, 2131388807) == null) goto L51;
        r4 = 2131391606;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r2, 2131391606);
        if (r10 == null) goto L51;
        r4 = 2131393142;
        WebView r12 = (WebView) ViewBindings.findChildViewById(r2, 2131393142);
        if (r12 == null) goto L51;
        LinearLayout r6 = (LinearLayout) r2;
        ObricActivityRecordAudioRuleWebviewBinding r7 = new ObricActivityRecordAudioRuleWebviewBinding(r6, r5, r8, r9, r10, r12);
        setContentView(r6);
        r5.setOnClickListener(new x(this));
        String r11 = getIntent().getStringExtra("open_link");
        if (r11 != null) goto L28;
    L30:
        r11 = null;
    L31:
        if (r11 != null) goto L33;
    L36:
        boolean r13 = true;
    L37:
        if (r13 == false) goto L39;
        FLogger.a.w("ObricRecordAudioRuleWebViewActivity", "finish because open url is invalid");
        finish();
        return;
    L39:
        this.g = r12;
        r12.setWebViewClient(new y(this, r7));
        r12.setWebChromeClient(new z(r7));
        WebSettings r16 = r12.getSettings();
        r16.setMixedContentMode(2);
        r16.setAllowFileAccess(false);
        r16.setAllowContentAccess(false);
        String r17 = UriProtector.parse(r11).getScheme();
        if (r17 == null) goto L43;
        r3 = r17.toLowerCase(Locale.getDefault());
    L43:
        if (Intrinsics.areEqual(r3, "file") == false) goto L45;
    L47:
        r15 = false;
    L48:
        r16.setJavaScriptEnabled(r15);
        r16.setDomStorageEnabled(false);
        r16.setTextZoom(100);
        r12.loadUrl(r11);
        return;
    L45:
        if (Intrinsics.areEqual(r3, "content") == true) goto L47;
    L33:
        if (r11.length() == 0) goto L36;
        r13 = false;
        goto L37
    L28:
        if (Intrinsics.areEqual(r11, "https://os.obriccloud.com/agreement/AudioRecordingUsageRules") == false) goto L30;
    L51:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(r4)));
    }
}
