package com.obric.assistant.onelogin;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.guide.IObricUserGuide;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.login.f0;
import com.obric.assistant.onelogin.impl.databinding.ActivityObricOneLoginBinding;
import com.obric.capabilitykit.common.UiType;
import com.obric.oui.status.OPageStatus;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 '2\u00020\u0001:\u0002'(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0014J\b\u0010$\u001a\u00020\u0016H\u0002J\u000e\u0010%\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/obric/assistant/onelogin/impl/databinding/ActivityObricOneLoginBinding;", "lastRetryClick", "", "emptyFragment", "Lcom/obric/assistant/onelogin/ObricEmptyOneLoginFragment;", "uiStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/onelogin/ObricOneLoginActivity$LoginViewState;", "settingsDisableRetryTime", "", "launchDouBaoMainBot", "", "loginForResult", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "hasRegisteredLoginTask", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "initUiStateObserver", "addFragmentIfNotExist", "onBackPressed", "checkOLoginOrRoute", "launchOAccountLogin", "invokeOneLogin", "onDestroy", "invokeReLogin", "awaitForSettingsReady", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "LoginViewState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricOneLoginActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int o = 0;
    public ActivityObricOneLoginBinding g;
    public long h;
    public final ObricEmptyOneLoginFragment i;
    public final StateFlowImpl j;
    public int k;
    public boolean l;
    public ActivityResultLauncher<Intent> m;
    public boolean n;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/onelogin/ObricOneLoginActivity$LoginViewState;", "", "<init>", "(Ljava/lang/String;I)V", "LOADING", "RETRY", "RELOGIN", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoginViewState extends Enum<LoginViewState> {
        public static final LoginViewState LOADING = null;
        public static final LoginViewState RELOGIN = null;
        public static final LoginViewState RETRY = null;
        public static final /* synthetic */ LoginViewState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoginViewState> getEntries() {
            return b;
        }

        static {
            LoginViewState r0 = new LoginViewState("LOADING", 0);
            LOADING = r0;
            LoginViewState r1 = new LoginViewState("RETRY", 1);
            RETRY = r1;
            LoginViewState r3 = new LoginViewState("RELOGIN", 2);
            RELOGIN = r3;
            LoginViewState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static LoginViewState[] values() {
            return (LoginViewState[]) a.clone();
        }

        public static LoginViewState valueOf(String r1) {
            return (LoginViewState) r27.a.a(LoginViewState.class, r1);
        }

        public LoginViewState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBackPressed() {
        setResult(0);
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.assistant.onelogin.d] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.obric.assistant.onelogin.e] */
    public final void P1() {
        final WeakReference r0 = new WeakReference(this);
        f0.d(f0.a, "login_activity", this, new d(r0), new e(r0), 48);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ObricOneLoginActivity.class.getName()));
    L5:
        super.onDestroy();
        IObricUserGuide r0 = (IObricUserGuide) ServiceManager.get().getService(IObricUserGuide.class);
        if (r0 == null) goto L8;
        r0.c();
    L8:
        if (r0 == null) goto L12;
        MutableLiveData r1 = r0.f();
        if (r1 == null) goto L12;
        r1.removeObservers(this);
    L12:
        FLogger r2 = FLogger.a;
        r2.d("ObricOneLoginActivity", this + " onDestroy()");
        if (this.n == false) goto L16;
        r2.i("ObricOneLoginActivity", "onDestroy, setLoggingIn false");
        ConcurrentHashMap<String, Boolean> r3 = b.a;
        b.a(getTaskId(), ObricOneLoginActivity.class.getName(), false);
        return;
    }

    public ObricOneLoginActivity() {
        this.h = System.currentTimeMillis();
        this.i = new ObricEmptyOneLoginFragment();
        this.j = j1.a(LoginViewState.LOADING);
        this.l = true;
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ObricOneLoginActivity.class.getName()));
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final void O1(ObricOneLoginActivity r4) {
        ActivityObricOneLoginBinding r0 = r4.g;
        ActivityResultLauncher<Intent> r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L5:
        r0.c.setVisibility(4);
        ActivityResultLauncher<Intent> r2 = r4.m;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loginForResult");
    L9:
        Intent r3 = new Intent("com.obric.account.action.OBRIC_ACCOUNT_LOGIN");
        r3.setPackage("com.obric.account");
        r3.putExtra("enter_from", r4.getPackageName());
        r1.launch(r3);
        r4.overridePendingTransition(2130772521, 0);
        return;
    L8:
        r1 = r2;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L32
    L6:
        if (v19.f.f(this) == false) goto L8;
        v19.f.c(getTheme());     // Catch: Throwable -> L32
    L8:
        super.onCreate(r10);
        FLogger r11 = FLogger.a;
        r11.d("ObricOneLoginActivity", this + "  onCreate() ");
        ConcurrentHashMap<String, Boolean> r0 = b.a;
        int r1 = getTaskId();
        String r2 = ObricOneLoginActivity.class.getName();
        Intrinsics.checkNotNullParameter(r2, "tag");
        if (Intrinsics.areEqual(b.a.get(r1 + ':' + r2), Boolean.TRUE) == false) goto L11;
        r11.i("ObricOneLoginActivity", "Task " + getTaskId() + " is already logging in. Finishing duplicate ObricOneLoginActivity.");
        finish();
        return;
    L11:
        b.a(getTaskId(), ObricOneLoginActivity.class.getName(), true);
        this.n = true;
        boolean r3 = false;
        View r12 = getLayoutInflater().inflate(2131558496, null, false);
        int r4 = 2131373275;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131373275);
        if (r5 == null) goto L31;
        OPageStatus r6 = ViewBindings.findChildViewById(r12, 2131381472);
        if (r6 == null) goto L29;
        FrameLayout r13 = (FrameLayout) r12;
        this.g = new ActivityObricOneLoginBinding(r13, r5, r6);
        setContentView(r13);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, 2131104374));
        Intent r14 = getIntent();
        if (r14 != null) goto L18;
    L20:
        this.l = !r3;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricOneLoginActivity$initUiStateObserver$1(this, null), 3, null);
        if (getSupportFragmentManager().findFragmentById(2131373275) != null) goto L27;
        FragmentTransaction r15 = getSupportFragmentManager().beginTransaction();
        ObricEmptyOneLoginFragment r7 = this.i;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r15, r7, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, 2131373275) == true) goto L26;
        r15 = r15.add(2131373275, r7);
    L26:
        r15.commitAllowingStateLoss();
    L27:
        this.m = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new c(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricOneLoginActivity$checkOLoginOrRoute$1(this, null), 3, null);
        return;
    L18:
        if (r14.getBooleanExtra("launch_dou_bao_main_bot", true) == true) goto L20;
        r3 = true;
        goto L20
    L29:
        r4 = 2131381472;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r4)));
    }

    public static final Object N1(ObricOneLoginActivity r5, Continuation r6) {
        r5.getClass();
        if ((r6 instanceof ObricOneLoginActivity$awaitForSettingsReady$1) == false) goto L7;
        ObricOneLoginActivity$awaitForSettingsReady$1 r0 = (ObricOneLoginActivity$awaitForSettingsReady$1) r6;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r7 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
    L19:
        StateFlowImpl r9 = c0.a;
        com.bytedance.sdk.account.ticketguard.f.a();
        if (com.bytedance.sdk.account.ticketguard.f.i == true) goto L25;
        r0.label = 2;
        if (DelayKt.delay(300, r0) != r8) goto L19;
        return r8;
    L25:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        if (DelayKt.delay(1000, r0) != r8) goto L19;
        return r8;
    L7:
        r0 = new ObricOneLoginActivity$awaitForSettingsReady$1(r5, r6);
        goto L8
    }

    public final void onActivityResult(int r5, int r6, Intent r7) {
        super.onActivityResult(r5, r6, r7);
        FLogger.a.i("ObricOneLoginActivity", this + " onActivityResult resultCode=" + r6);
        int r0 = com.ss.android.account.group_onekey.c.a;
        tb7.a.d("AccountGroupAuthService", "onActivityResult, requestCode=" + r5 + ", resultCode=" + r6);
        if (r7 == null) goto L7;
        String r1 = r7.getStringExtra("challenge");
        if (r1 == null) goto L7;
    L9:
        if (TextUtils.isEmpty(r1) == false) goto L17;
        Iterator r2 = com.ss.android.account.group_onekey.c.b.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L17;
        Map.Entry r3 = (Map.Entry) r2.next();
        if (r5 != ((Number) r3.getValue()).intValue()) goto L12;
        r1 = (String) r3.getKey();
    L17:
        if (TextUtils.isEmpty(r1) == true) goto L31;
        if (r7 != null) goto L23;
        r7 = new Intent();
    L23:
        if (r6 == (-1)) goto L25;
        boolean r8 = true;
    L26:
        com.ss.android.account.group_onekey.c.a(r1, r7, r8);
        return;
    L25:
        r8 = false;
        goto L26
    L31:
        return;
    L7:
        r1 = "";
        goto L9
    }
}
