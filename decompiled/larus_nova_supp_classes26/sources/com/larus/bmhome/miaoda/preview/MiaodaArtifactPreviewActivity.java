package com.larus.bmhome.miaoda.preview;

import android.R;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.impl.utils.c;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import v19.f;
import zq8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u001a\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/miaoda/preview/MiaodaArtifactPreviewActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "webFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseUrl", "", "intent", "Landroid/content/Intent;", "initTitleBar", "attachWebFragment", ShareType.URL, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiaodaArtifactPreviewActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int h = 0;
    public AbsWebFragment g;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(MiaodaArtifactPreviewActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(MiaodaArtifactPreviewActivity.class.getName()));
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
        if (c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r1 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r1 == c.a) goto L9;
        c.a(r1, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r0.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    public MiaodaArtifactPreviewActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r12);
        setContentView(2131561791);
        Intent r13 = getIntent();
        Fragment r0 = null;
        if (r13 == null) goto L14;
        String r2 = r13.getStringExtra("miaoda_artifact_preview_url");
        if (r2 == null) goto L14;
    L18:
        String r4 = r2;
    L21:
        if (r4 != null) goto L23;
    L26:
        boolean r1 = true;
    L28:
        if (r1 == false) goto L30;
        FLogger.a.w("MiaodaArtifactPreviewActivity", "url is empty, finish");
        finish();
        return;
    L30:
        ImageView r3 = (ImageView) findViewById(2131364650);
        if (r3 == null) goto L33;
        r3.setOnClickListener(new zq8.a(this));
    L33:
        ImageView r5 = (ImageView) findViewById(2131364832);
        if (r5 == null) goto L36;
        e1.d(r5, new b(this));
    L36:
        AbsWebFragment r6 = getSupportFragmentManager().findFragmentByTag("MiaodaArtifactPreviewWebFragment");
        if ((r6 instanceof AbsWebFragment) == false) goto L39;
        AbsWebFragment r7 = r6;
    L40:
        if (r7 == null) goto L42;
        this.g = r7;
        return;
    L42:
        AiChatHostWebService r8 = AiChatHostWebService.a;
        Fragment r9 = r8.a(null);
        if ((r9 instanceof AbsWebFragment) == false) goto L45;
        r0 = r9;
    L45:
        if (r0 != null) goto L47;
        FLogger.a.e("MiaodaArtifactPreviewActivity", "AiChatHostWebService.getWebFragment() return null");
        finish();
        return;
    L47:
        Bundle r10 = r8.c(new zt8.b(r4, true, true, null, false, 112));
        if (r10 != null) goto L50;
        r10 = new Bundle();
    L50:
        r10.putBoolean("bundle_need_lark_auth_cookie_sync", true);
        r0.setArguments(r10);
        this.g = r0;
        FragmentTransaction r11 = getSupportFragmentManager().beginTransaction();
        r11.setReorderingAllowed(true);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r0, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "MiaodaArtifactPreviewWebFragment", 2131393123) == true) goto L54;
        r11.replace(2131393123, r0, "MiaodaArtifactPreviewWebFragment");
    L54:
        r11.commit();
        return;
    L39:
        r7 = null;
        goto L40
    L23:
        if (r4.length() == 0) goto L26;
        r1 = false;
    L14:
        if (r13 == null) goto L19;
        Uri r14 = r13.getData();
        if (r14 == null) goto L19;
        r2 = UriProtector.getQueryParameter(r14, "miaoda_artifact_preview_url");
    L19:
        r4 = null;
        goto L21
    }
}
