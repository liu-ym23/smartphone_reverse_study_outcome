package com.obric.assistant.settings.voiceprint;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.crash.Npth;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.settings.ObricSettingBaseActivity;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 12\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0014J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\u0018\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010(\u001a\u00020\u0017H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u0017H\u0002J\u0016\u0010+\u001a\u00020\u00172\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00170-H\u0002J\n\u0010.\u001a\u0004\u0018\u00010/H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementActivity;", "Lcom/obric/assistant/settings/ObricSettingBaseActivity;", "<init>", "()V", "adaptSettingNavigationBarPadding", "", "getAdaptSettingNavigationBarPadding", "()Z", "authState", "Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementActivity$AuthState;", "pendingReAuthOnResume", "screenOffReceiver", "Landroid/content/BroadcastReceiver;", "requestAuthenticationJob", "Lkotlinx/coroutines/Job;", "waitDeviceUnlockJob", "currentAuthRequestId", "", "isStarted", "foregroundScope", "Lkotlinx/coroutines/CoroutineScope;", "hasLaunchedDeviceCredential", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onResume", "onDestroy", "startAuthentication", "showManagementContent", "hideSensitiveContent", "clearSensitiveContent", "removeFragment", "registerScreenOffReceiver", "unregisterScreenOffReceiver", "finishForAuthenticationExit", "resetAuthenticationState", "requireReAuth", "waitForDeviceUnlockThenStartAuthentication", "cancelWaitDeviceUnlockJob", "finishSafely", "runOnMainThread", "block", "Lkotlin/Function0;", "fragmentContainer", "Landroid/view/View;", "AuthState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricVoicePrintManagementActivity extends ObricSettingBaseActivity {
    public static final /* synthetic */ int q = 0;
    public AuthState h;
    public boolean i;
    public ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1 j;
    public Job k;
    public Job l;
    public long m;
    public boolean n;
    public CoroutineScope o;
    public boolean p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/settings/voiceprint/ObricVoicePrintManagementActivity$AuthState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "AUTHENTICATING", "PASSED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AuthState extends Enum<AuthState> {
        public static final AuthState AUTHENTICATING = null;
        public static final AuthState IDLE = null;
        public static final AuthState PASSED = null;
        public static final /* synthetic */ AuthState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AuthState> getEntries() {
            return b;
        }

        static {
            AuthState r0 = new AuthState("IDLE", 0);
            IDLE = r0;
            AuthState r1 = new AuthState("AUTHENTICATING", 1);
            AUTHENTICATING = r1;
            AuthState r3 = new AuthState("PASSED", 2);
            PASSED = r3;
            AuthState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static AuthState[] values() {
            return (AuthState[]) a.clone();
        }

        public static AuthState valueOf(String r1) {
            return (AuthState) r27.a.a(AuthState.class, r1);
        }

        public AuthState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.settings.ObricSettingBaseActivity
    public final boolean O1() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        this.n = false;
        Job r0 = this.l;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.l = null;
        CoroutineScope r1 = this.o;
        if (r1 == null) goto L8;
        CoroutineScopeKt.cancel$default(r1, null, 1, null);
    L8:
        this.o = null;
        super/*androidx.appcompat.app.AppCompatActivity*/.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L20;
        View r2 = getWindow().getDecorView();     // Catch: Throwable -> L17
        if (com.larus.home.impl.utils.c.e == false) goto L15;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L17
        Thread r3 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L17
        if (r3 == com.larus.home.impl.utils.c.a) goto L15;
        com.larus.home.impl.utils.c.a(r3, "getDecorView");     // Catch: Throwable -> L17
    L15:
        r2.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L17
        return;
    L21:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X1() {
        AuthState r0 = this.h;
        AuthState r1 = AuthState.AUTHENTICATING;
        if (r0 != r1) goto L5;
        return;
    L5:
        if (isFinishing() == false) goto L7;
        return;
    L7:
        if (isDestroyed() == false) goto L10;
        return;
    L10:
        if (this.n == true) goto L14;
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: skip, activity is not started (in background)");
        this.i = true;
        return;
    L14:
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == true) goto L18;
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: device is not secure, show content directly");
        this.h = AuthState.PASSED;
        this.i = false;
        W1();
        return;
    L18:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L21;
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "startAuthentication: device still locked, wait for unlock");
        U1(true, false);
        Y1();
        return;
    L21:
        long r5 = SystemClock.elapsedRealtimeNanos();
        this.m = r5;
        this.h = r1;
        S1(false);
        Job r2 = this.k;
        if (r2 == null) goto L24;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L24:
        this.k = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new ObricVoicePrintManagementActivity$startAuthentication$1(this, r5, null), 2, null);
    }

    public final void Y1() {
        Job r0 = this.l;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        CoroutineScope r2 = this.o;
        if (this.n == false) goto L15;
        if (r2 == null) goto L15;
        this.l = BuildersKt.launch$default(r2, null, null, new ObricVoicePrintManagementActivity$waitForDeviceUnlockThenStartAuthentication$1(this, null), 3, null);
        return;
    L15:
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "waitForDeviceUnlockThenStartAuthentication: skip because activity is not started");
        return;
    L5:
        if (r0.isActive() != true) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.settings.ObricSettingBaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricVoicePrintManagementActivity.class.getName()));
    L5:
        Job r0 = this.k;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        Job r1 = this.l;
        if (r1 == null) goto L11;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L11:
        this.l = null;
        ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1 r2 = this.j;
        if (r2 != null) goto L34;
    L30:
        super.onDestroy();
        return;
    L34:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L24
        ReceiverRegisterLancet.loge(r2, false);     // Catch: Throwable -> L24
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L32;
        unregisterReceiver(r2);     // Catch: Throwable -> L24
    L22:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L24
    L26:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L29;
        FLogger.a.w("[ObricVoicePrintManagementActivity]", "unregisterScreenOffReceiver failed", r5);
    L29:
        this.j = null;
        goto L30
    L32:
    L19:
        e = move-exception;
        Npth.addTag("unregisterReceiver", r2.toString());     // Catch: Throwable -> L24
        e.printStackTrace();     // Catch: Throwable -> L24
        goto L22
    L16:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r2, this) == false) goto L22;
        unregisterReceiver(r2);     // Catch: Exception -> L19 Throwable -> L24
    L24:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }

    public ObricVoicePrintManagementActivity() {
        this.h = AuthState.IDLE;
    }

    public final void T1() {
        View r0 = findViewById(2131373275);
        if (r0 == null) goto L6;
        r0.setVisibility(4);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W1() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L20;
        View r1 = findViewById(2131373275);
        if (r1 == null) goto L11;
        r1.setVisibility(0);
    L11:
        if (getSupportFragmentManager().findFragmentByTag("obric_voice_print_management_fragment") != null) goto L19;
        ObricVoicePrintManagementMainFragment r2 = new ObricVoicePrintManagementMainFragment();
        r2.setArguments(getIntent().getExtras());
        FragmentTransaction r3 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "obric_voice_print_management_fragment", 2131373275) == true) goto L16;
        r3 = r3.replace(2131373275, r2, "obric_voice_print_management_fragment");
    L16:
        r3.commitAllowingStateLoss();
        return;
    L19:
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.settings.ObricSettingBaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ObricVoicePrintManagementActivity.class.getName()));
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
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == true) goto L6;
        this.h = AuthState.PASSED;
        this.i = false;
        W1();
        return;
    L6:
        AuthState r0 = this.h;
        AuthState r2 = AuthState.AUTHENTICATING;
        if (r0 != r2) goto L13;
        if (this.p == false) goto L13;
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "onResume: device credential UI already launched, wait for its callback");
        T1();
        return;
    L13:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L16;
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "onResume: device still locked, wait for device unlock before re-auth");
        U1(true, false);
        T1();
        Y1();
        return;
    L16:
        Job r1 = this.l;
        if (r1 == null) goto L19;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L19:
        this.l = null;
        AuthState r3 = this.h;
        AuthState r4 = AuthState.PASSED;
        if (r3 == r4) goto L22;
        T1();
    L22:
        AuthState r5 = this.h;
        if (r5 == r2) goto L29;
        if (r5 == r4) goto L26;
    L27:
        this.i = false;
        X1();
        return;
    L26:
        if (this.i == true) goto L27;
        return;
    }

    public final void onStart() {
        super/*androidx.appcompat.app.AppCompatActivity*/.onStart();
        this.n = true;
        if (this.o != null) goto L6;
        this.o = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        return;
    }

    public final void S1(boolean r2) {
        T1();
        if (r2 == true) goto L5;
        return;
    L5:
        Fragment r3 = getSupportFragmentManager().findFragmentByTag("obric_voice_print_management_fragment");
        if (r3 != null) goto L8;
        return;
    L8:
        getSupportFragmentManager().beginTransaction().remove(r3).commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.obric.assistant.settings.voiceprint.ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1] */
    @Override // com.obric.assistant.settings.ObricSettingBaseActivity
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r4);
        setContentView(2131561787);
        ObricSettingBaseActivity.N1(this);
        S1(true);
        if (this.j != null) goto L30;
        ?? r5 = new ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1(this);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        IntentFilter r1 = new IntentFilter();     // Catch: Throwable -> L16
        r1.addAction("android.intent.action.SCREEN_OFF");     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
        Object r3 = Result.constructor-impl(R1(this, r5, r1));     // Catch: Throwable -> L16
    L19:
        if (Result.isSuccess-impl(r3) == false) goto L21;
        Intent r6 = (Intent) r3;
        this.j = r5;
    L21:
        Throwable r7 = Result.exceptionOrNull-impl(r3);
        if (r7 == null) goto L29;
        FLogger.a.w("[ObricVoicePrintManagementActivity]", "registerScreenOffReceiver failed", r7);
        return;
    L29:
        return;
    L16:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }

    public final void U1(boolean r4, boolean r5) {
        FLogger.a.i("[ObricVoicePrintManagementActivity]", "resetAuthenticationState, " + r4 + ", " + r5);
        this.m = 0;
        Job r0 = this.k;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.k = null;
        this.p = false;
        this.h = AuthState.IDLE;
        this.i = r4;
        if (r5 == false) goto L9;
        S1(true);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent R1(ObricVoicePrintManagementActivity r9, ObricVoicePrintManagementActivity$registerScreenOffReceiver$receiver$1 r10, IntentFilter r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, "android.permission.WRITE_SETTINGS", null);
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r11) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r10, r11, 0, "android.permission.WRITE_SETTINGS", null, 4, r9);     // Catch: Exception -> L26
        int r1 = r0.result;     // Catch: Exception -> L26
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r9.registerReceiver(r10, r11, "android.permission.WRITE_SETTINGS", null);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r9.registerReceiver(r10, r11, "android.permission.WRITE_SETTINGS", null);
    L25:
        return r9.registerReceiver(r10, r11, "android.permission.WRITE_SETTINGS", null);
    }
}
