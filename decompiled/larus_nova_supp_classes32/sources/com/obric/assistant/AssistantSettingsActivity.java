package com.obric.assistant;

import android.R;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.router.SmartRouter;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.home.api.main.HomeService;
import com.larus.home.api.main.HomeServiceV2;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.AccountService;
import com.larus.setting.api.ISettingApi;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.common.utils.m;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.oauto.IOAutoApi;
import com.obric.assistant.onelogin.IObricOneLogin;
import com.obric.assistant.privacy.IObricPrivacyService;
import com.obric.assistant.settings.IObricSettingRouteService;
import com.obric.assistant.settings.ObricSettingsSubPageType;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/AssistantSettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "checkPreconditionsAndJumpSubPage", "jump2SubPage", "subPage", NameKeys.UnloadStrategy_No_Strategy, "checkIsDefaultAssistant", NameKeys.UnloadStrategy_No_Strategy, "requestPortraitSafely", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantSettingsActivity extends AppCompatActivity {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AssistantSettingsActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(AssistantSettingsActivity.class.getName()));
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
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public AssistantSettingsActivity() {
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r12) {
        if (com.larus.platform.service.z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        v19.f.a(getTheme());
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(r12);
        if (Build.VERSION.SDK_INT != 26) goto L13;
        FLogger.a.i("AssistantSettingsActivity", "skip request portrait for translucent activity on Android O");
    L15:
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L17;
        boolean r13 = true;
    L18:
        com.larus.utils.u.f(this, !r13);
        Bundle r14 = getIntent().getExtras();
        final String r1 = null;
        if (r14 == null) goto L21;
        String r15 = r14.getString("sub_page");
    L22:
        m.a.getClass();
        if (m.a() == false) goto L38;
        ObricSettingsSubPageType.Companion.getClass();
        ObricSettingsSubPageType[] r5 = ObricSettingsSubPageType.values();
        int r6 = r5.length;
        int r7 = 0;
    L25:
        if (r7 >= r6) goto L35;
        ObricSettingsSubPageType r8 = r5[r7];
        if (Intrinsics.areEqual(r8.getPath(), r15) == true) goto L29;
    L31:
        boolean r9 = false;
    L32:
        if (r9 == true) goto L33;
        r7 = r7 + 1;
        goto L25
    L33:
        boolean r10 = true;
    L36:
        if (r10 == false) goto L38;
        FLogger.a.i("AssistantSettingsActivity", "checkIsDefaultAssistant bypassed for subPage = " + r15);
        boolean r11 = true;
    L45:
        if (r11 == true) goto L47;
        finish();
        return;
    L47:
        com.obric.assistant.reporter.b.a("doubao_settings", null, 6);
        long r16 = SystemClock.elapsedRealtime();
        IObricLaunchService r17 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r17 == null) goto L50;
        String r18 = r17.getBackgroundAppPkgName();
    L51:
        FLogger r19 = FLogger.a;
        r19.i("AssistantSettingsActivity", "backgroundAppPkgName = " + r18 + ", used time " + (SystemClock.elapsedRealtime() - r16));
        if (r18 != null) goto L54;
    L57:
        boolean r20 = true;
    L58:
        if (r20 == true) goto L60;
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(r18, "settingsAct onCreate");
    L60:
        IOAutoApi r110 = (IOAutoApi) ServiceManager.get().getService(IOAutoApi.class);
        if (r110 != null) goto L63;
    L65:
        boolean r111 = false;
    L66:
        if (r111 == false) goto L70;
        r19.i("AssistantSettingsActivity", "exitVirtualDisplay");
        IAssistantChatWindow r112 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r112 == null) goto L70;
        IAssistantChatWindow.DefaultImpls.exitVirtualDisplay$default(r112, 0, 1, null);
    L70:
        HomeService.a.C(false);
        Bundle r113 = getIntent().getExtras();
        if (r113 == null) goto L73;
        r1 = r113.getString("sub_page");
    L73:
        Bundle r114 = getIntent().getExtras();
        if (r114 != null) goto L76;
    L78:
        boolean r115 = false;
    L79:
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r21 = ISecPrivacyService.a.a();
        if (r21 == null) goto L82;
        boolean r22 = r21.h();
    L83:
        if (r22 == true) goto L87;
        if (r115 == true) goto L87;
        boolean r116 = false;
    L88:
        r19.i("AssistantSettingsActivity", "onCreate, subPage: " + r1 + ", intent: " + getIntent());
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L118
        if (r116 == false) goto L95;
        if (AccountService.a.isLogin().booleanValue() == false) goto L95;
        r19.i("AssistantSettingsActivity", "checkPreconditionsAndJumpSubPage jump2SubPage");     // Catch: Throwable -> L118
        z1(r1);     // Catch: Throwable -> L118
        finish();     // Catch: Throwable -> L118
        return;
    L95:
        if (t9a.b.a().b() == true) goto L97;
        r19.i("AssistantSettingsActivity", "checkPreconditionsAndJumpSubPage not ObricOS, jump to MainActivity");     // Catch: Throwable -> L118
        Intent r117 = new Intent();     // Catch: Throwable -> L118
        r117.setComponent(new ComponentName(this, HomeServiceV2.a.a()));     // Catch: Throwable -> L118
        r117.setFlags(335544320);     // Catch: Throwable -> L118
        startActivity(r117);     // Catch: Throwable -> L118
        finish();     // Catch: Throwable -> L118
        return;
    L97:
        if (r116 == true) goto L99;
    L106:
        if (r116 == true) goto L116;
        r19.i("AssistantSettingsActivity", "checkPreconditionsAndJumpSubPage getObricPrivacyIntent");     // Catch: Throwable -> L118
        IObricPrivacyService r118 = (IObricPrivacyService) ServiceManager.get().getService(IObricPrivacyService.class);     // Catch: Throwable -> L118
        if (r118 == null) goto L115;
        Intent r119 = r118.a(this);     // Catch: Throwable -> L118
        if (r119 == null) goto L115;
        Intent r3 = new Intent(this, AssistantSettingsActivity.class);     // Catch: Throwable -> L118
        r3.putExtra("from_privacy_agreed", true);     // Catch: Throwable -> L118
        Bundle r0 = getIntent().getExtras();     // Catch: Throwable -> L118
        if (r0 == null) goto L114;
        r3.putExtras(r0);     // Catch: Throwable -> L118
    L114:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L118
        r119.putExtra("privacy_next_intent", r3);     // Catch: Throwable -> L118
        startActivity(r119);     // Catch: Throwable -> L118
    L115:
        finish();     // Catch: Throwable -> L118
    L116:
        Object r120 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L118
    L120:
        Throwable r121 = Result.exceptionOrNull-impl(r120);
        if (r121 == null) goto L133;
        FLogger.a.i("AssistantSettingsActivity", "checkPreconditionsAndJumpSubPage error: " + r121);
        finish();
        return;
    L133:
        return;
    L99:
        if (AccountService.a.isLogin().booleanValue() == true) goto L106;
        r19.i("AssistantSettingsActivity", "checkPreconditionsAndJumpSubPage startObricOneLoginActivity");     // Catch: Throwable -> L118
        Intent r122 = new Intent();     // Catch: Throwable -> L118
        IObricOneLogin r4 = (IObricOneLogin) ServiceManager.get().getService(IObricOneLogin.class);     // Catch: Throwable -> L118
        if (r4 == null) goto L104;
        String r24 = r4.c();     // Catch: Throwable -> L118
        if (r24 == null) goto L104;
    L105:
        r122.setComponent(new ComponentName(this, r24));     // Catch: Throwable -> L118
        r122.putExtra("launch_dou_bao_main_bot", false);     // Catch: Throwable -> L118
        registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new com.obric.assistant.a(this, r1)).launch(r122);     // Catch: Throwable -> L118
        return;
    L104:
        r24 = "com.obric.assistant.onelogin.ObricOneLoginActivity";
    L118:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r120 = Result.constructor-impl(ResultKt.createFailure(th));
    L87:
        r116 = true;
        goto L88
    L82:
        r22 = false;
        goto L83
    L76:
        if (r114.getBoolean("from_privacy_agreed", false) != true) goto L78;
        r115 = true;
        goto L79
    L63:
        if (r110.b() != true) goto L65;
        r111 = true;
        goto L66
    L54:
        if (r18.length() == 0) goto L57;
        r20 = false;
        goto L58
    L50:
        r18 = null;
        goto L51
    L29:
        if (r8.getAllowNonDefaultAssistantEntry() == false) goto L31;
        r9 = true;
        goto L32
    L35:
        r10 = false;
    L38:
        IObricAvailableManager r26 = (IObricAvailableManager) ServiceManager.get().getService(IObricAvailableManager.class);
        if (r26 != null) goto L41;
    L43:
        r11 = false;
    L44:
        FLogger.a.i("AssistantSettingsActivity", "checkIsDefaultAssistant, subPage = " + r15 + ", isDefaultAssistant = " + r11);
        goto L45
    L41:
        if (r26.a() != true) goto L43;
        r11 = true;
        goto L44
    L21:
        r15 = null;
        goto L22
    L17:
        r13 = false;
        goto L18
    L13:
        setRequestedOrientation(1);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1(String r4) {
        FLogger.a.i("AssistantSettingsActivity", "jump2SubPage subPage:" + r4);
        String r1 = null;
        if (Intrinsics.areEqual(r4, ObricSettingsSubPageType.ACCESSARY_SETTINGS.getPath()) == false) goto L10;
        IFlowSdkDepend r5 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r5 == null) goto L34;
        com.larus.home.impl.sdk.s r6 = r5.s0();
        if (r6 == null) goto L35;
        r6.M(this, null);
        return;
    L35:
        return;
    L34:
        return;
    L10:
        if (Intrinsics.areEqual(r4, ObricSettingsSubPageType.MEMORY_SETTINGS.getPath()) == false) goto L15;
        IObricSettingRouteService r7 = (IObricSettingRouteService) ServiceManager.get().getService(IObricSettingRouteService.class);
        if (r7 == null) goto L37;
        r7.b(this);
        return;
    L37:
        return;
    L15:
        if (Intrinsics.areEqual(r4, ObricSettingsSubPageType.PRIVACY_MODEL_TRAINING.getPath()) == false) goto L20;
        ISettingApi r8 = (ISettingApi) ServiceManager.get().getService(ISettingApi.class);
        if (r8 == null) goto L39;
        r8.j(this);
        return;
    L39:
        return;
    L20:
        if (Intrinsics.areEqual(r4, ObricSettingsSubPageType.VOICE_PRINT_MANAGEMENT.getPath()) == false) goto L28;
        Bundle r9 = getIntent().getExtras();
        if (r9 == null) goto L24;
        r1 = r9.getString("previous_page");
    L24:
        IObricSettingRouteService r10 = (IObricSettingRouteService) ServiceManager.get().getService(IObricSettingRouteService.class);
        if (r10 == null) goto L41;
        r10.a(this, r1);
        return;
    L41:
        return;
    L28:
        if (Intrinsics.areEqual(r4, ObricSettingsSubPageType.OBRIC_ABOUT_APP.getPath()) == false) goto L30;
        com.bytedance.router.i r11 = SmartRouter.buildRoute(this, "//flow/about_app");
        r11.c.putExtras(getIntent().getExtras());
        r11.d();
        return;
    L30:
        IObricSettingRouteService r12 = (IObricSettingRouteService) ServiceManager.get().getService(IObricSettingRouteService.class);
        if (r12 == null) goto L44;
        r12.c(this);
        return;
    }
}
