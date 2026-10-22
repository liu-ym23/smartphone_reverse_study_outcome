package com.obric.assistant.privacy.activity;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.common.mssdk.api.SecurityService;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.luckydog.api.ILuckyDogService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.aiagent.assistant.idl.IAgentAppIntentIDL;
import com.obric.assistant.interaction.base.util.DeviceUtil;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.privacy.ObricPrivacyProvider;
import com.obric.assistant.privacy.impl.databinding.ObricActivityPrivacyAgreementBinding;
import com.obric.assistant.t1;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.status.OPageStatus;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0002J\b\u0010\u0019\u001a\u00020\u0010H\u0002J\b\u0010\u001a\u001a\u00020\u0010H\u0002J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0010H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\b\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\b\u0010!\u001a\u00020\u0010H\u0002J\b\u0010$\u001a\u00020\u0010H\u0003J\u0010\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\rH\u0016J\b\u0010(\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/obric/assistant/privacy/activity/ObricPrivacyAgreeActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "mainProcessPid", "", "luckydogSchema", "", "privacyNextIntent", "Landroid/content/Intent;", "binding", "Lcom/obric/assistant/privacy/impl/databinding/ObricActivityPrivacyAgreementBinding;", "isSetResult", "", "isKillPrivacyProcess", "attachBaseContext", "", "newBase", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onDestroy", "onPrivacyAccepted", "launchNextIntent", "goMainActivity", "isMainProcessRunning", "context", "onPrivacyRefuse", "killMainProcess", "killSelfProcess", "killAllProcess", "adaptScreenOrientation", "privacySheet", "Lcom/obric/oui/privacy/OPrivacySheet;", "showPrivacySheet", "clickPrivacyLink", "linkUrl", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPrivacyAgreeActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int n = 0;
    public int g;
    public String h;
    public Intent i;
    public ObricActivityPrivacyAgreementBinding j;
    public boolean k;
    public boolean l;
    public com.obric.oui.privacy.c m;

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

    /* JADX WARN: Multi-variable type inference failed */
    public final void P1() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(this, HomeServiceV2.a.a()));
        r0.setFlags(335544320);
        startActivity(r0);
        if (this.l == false) goto L6;
        Process.killProcess(Process.myPid());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q1() {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        com.obric.oui.privacy.c r0 = this.m;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        ISecPrivacyService.a r1 = ISecPrivacyService.a;
        r1.getClass();
        ISecPrivacyService r2 = ISecPrivacyService.a.a();
        if (r2 == null) goto L10;
        r2.b(this);
    L10:
        HomeService.a.Y(this, true);
        r1.getClass();
        ISecPrivacyService r3 = ISecPrivacyService.a.a();
        if (r3 == null) goto L13;
        r3.e();
    L13:
        Uri r4 = ObricPrivacyProvider.a;
        ObricPrivacyProvider.a.a(this);
        IAgentAppIntentIDL r5 = com.obric.aiagent.assistant.idl.a.a(Reflection.getOrCreateKotlinClass(IAgentAppIntentIDL.class));
        if (r5 == null) goto L16;
        r5.notifyUserAgreePrivacy();
    L16:
        t0.d(new f(this), 300);
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricPrivacyAgreeActivity.class.getName()));
    L5:
        super.onDestroy();
        this.j = null;
    }

    public ObricPrivacyAgreeActivity() {
        this.l = true;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ObricPrivacyAgreeActivity.class.getName()));
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

    public final void onResume() {
        super.onResume();
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r0 = ISecPrivacyService.a.a();
        if (r0 == null) goto L5;
        boolean r1 = r0.h();
    L6:
        if (r1 == false) goto L9;
        Q1();
        return;
    L9:
        return;
    L5:
        r1 = false;
        goto L6
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final void O1(ObricPrivacyAgreeActivity r10) {
        r10.getClass();
        HomeService.a.Y(r10, false);
        if (r10.k == true) goto L5;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new ObricPrivacyAgreeActivity$onPrivacyRefuse$1(r10, null), 3, null);
        r10.finishAndRemoveTask();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        com.obric.oui.privacy.c r0 = r10.m;
        if (r0 == null) goto L14;
        OSheet r1 = r0.c;     // Catch: Exception -> L17
        if (r1 == null) goto L14;
        r1.s = null;     // Catch: Exception -> L17
        r1.setOnDismissListener(null);     // Catch: Exception -> L17
        if (r1.isShowing() == false) goto L14;
        OSheet.t(r1);     // Catch: Exception -> L17
    L14:
        FLogger.a.i("ObricPrivacyActivity", "External request, return cancel result");
        r10.setResult(0);
        r10.overridePendingTransition(0, 0);
        r10.finishAndRemoveTask();
    }

    public final void attachBaseContext(Context r3) {
        super.attachBaseContext(r3);
        FLogger.a.i("ObricPrivacyActivity", "attachBaseContext");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r22) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L7;
        v19.f.a(getTheme());     // Catch: Throwable -> L10
    L7:
        if (v19.f.f(this) == false) goto L11;
        v19.f.c(getTheme());     // Catch: Throwable -> L10
    L11:
        super.onCreate(r22);
        FLogger r1 = FLogger.a;
        r1.i("ObricPrivacyActivity", "onCreate");
        if (DeviceUtil.INSTANCE.isHorizontalFoldable() == true) goto L14;
    L16:
        boolean r3 = false;
    L17:
        HomeService r6 = HomeService.a;
        if (r6.isPad() == true) goto L22;
        if (r3 == true) goto L22;
        int r7 = 1;
    L23:
        r1.i("ObricPrivacyActivity", "adaptScreenOrientation orientation: " + r7 + ", isUnfolded: " + r3);
        setRequestedOrientation(r7);
        overridePendingTransition(0, 0);
        View r2 = getLayoutInflater().inflate(2131563921, null, false);
        OPageStatus r4 = ViewBindings.findChildViewById(r2, 2131381237);
        if (r4 == null) goto L45;
        FrameLayout r5 = (FrameLayout) r2;
        this.j = new ObricActivityPrivacyAgreementBinding(r5, r4);
        setContentView(r5);
        ObricActivityPrivacyAgreementBinding r8 = this.j;
        if (r8 == null) goto L30;
        OPageStatus r9 = r8.b;
        if (r9 == null) goto L30;
        r9.setType(1);
        r9.setLoadingResult(getString(2131912347));
        r9.b(true);
    L30:
        Uri r10 = getIntent().getData();
        if (r10 == null) goto L40;
        ILuckyDogService r11 = (ILuckyDogService) ServiceManager.get().getService(ILuckyDogService.class);
        if (r11 != null) goto L35;
    L37:
        boolean r12 = false;
    L38:
        if (r12 == false) goto L40;
        this.h = r10.toString();
        goto L40
    L35:
        if (r11.d(r10) != true) goto L37;
        r12 = true;
    L40:
        this.i = (Intent) getIntent().getParcelableExtra("privacy_next_intent");
        this.k = getIntent().getBooleanExtra("is_set_result", false);
        this.l = getIntent().getBooleanExtra("is_kill_privacy_process", true);
        r6.Q(this);
        r6.x(new JSONObject());
        if (Build.VERSION.SDK_INT < 23) goto L48;
        com.obric.oui.privacy.c r13 = new com.obric.oui.privacy.c(this, new com.obric.oui.privacy.h(AppHost.a.getApplication().getPackageName(), getString(2131896110), getString(2131912344), CollectionsKt.listOf(new com.obric.oui.privacy.j[]{new com.obric.oui.privacy.j.b(getString(2131912087), ObricUpdateSettingDelegate.a.a(), new d()), new com.obric.oui.privacy.j.b(getString(2131912083), t1.a.g0(), new e(this)), new com.obric.oui.privacy.j.a(getString(2131912373), CollectionsKt.listOf(new String[]{getString(2131912355), getString(2131912360), getString(2131912364), getString(2131912361), getString(2131912358), getString(2131912367), getString(2131912354), getString(2131912359), getString(2131912372), getString(2131912368), getString(2131912370), getString(2131912371), getString(2131912366), getString(2131912356), getString(2131912353), getString(2131912369), getString(2131912357), getString(2131912365), getString(2131912363), getString(2131912362)}))}), getString(2131912375), CollectionsKt.listOf(new String[]{getString(2131912376), getString(2131912345), getString(2131912346)}), getString(2131911955), getString(2131912275), true, true, true));
        h r14 = new h(this);
        Intrinsics.checkNotNullParameter(r14, "listener");
        r13.e = r14;
        r13.d();
        this.m = r13;
        return;
    L48:
        return;
    L45:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(2131381237)));
    L22:
        r7 = 13;
        goto L23
    L14:
        if (getResources().getConfiguration().smallestScreenWidthDp < 600) goto L16;
        r3 = true;
        goto L17
    }

    public static final void N1(final ObricPrivacyAgreeActivity r3, final String r4) {
        r3.getClass();
        SecurityService r0 = (SecurityService) ServiceManager.get().getService(SecurityService.class);
        if (r0 == null) goto L6;
        r0.x(r3.getSupportFragmentManager(), new g(r4, r3));
        return;
    }
}
