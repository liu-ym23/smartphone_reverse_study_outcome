package com.ss.android.lark.flow.threadwindow;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.UIUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.columns.ColumnsUtils;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textprocess.table.TableUtils;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chatwindow.IllegalUserSessionException;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.codeblock.theme.CodeBlockV2ThemeManager;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 %2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001%B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0014J\"\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0014J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010$\u001a\u0004\u0018\u00010\rH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/flow/threadwindow/FlowThreadWindowActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "chatId", "", "activityHookManager", "Lcom/ss/android/lark/chat/core/extension/ActivityHookManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "Landroid/content/Intent;", "setupFragment", "replaceFragment", "args", "setFlowSystemBars", "onDestroy", "onActivityResult", "requestCode", "", "resultCode", "data", "isSlideEnable", "", "shouldNotifyPush", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "setupActivityHookOnBackPressed", "getChatId", "bundle", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowThreadWindowActivity extends Hilt_FlowThreadWindowActivity implements d0c.c, zsb.d {
    public String b;
    public final com.ss.android.lark.chat.core.extension.a c;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final boolean isSlideEnable() {
        return false;
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.flow.threadwindow.Hilt_FlowThreadWindowActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowThreadWindowActivity.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
        goto L48
    L31:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L33;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L42
        goto L48
    L33:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L42
        if (r1 == null) goto L48;
        r1.addFlags(268435456);     // Catch: Throwable -> L42
        r1.addFlags(2097152);     // Catch: Throwable -> L42
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r3 - r6.longValue()) >= 800) goto L13;
        monitor-exit(r5);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.flow.threadwindow.Hilt_FlowThreadWindowActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowThreadWindowActivity.class.getName()));
    L5:
        super.onDestroy();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        ((itb.c) LarkContext.spiByDwarf(itb.c.class)).V(this);     // Catch: Throwable -> L8
        com.larksuite.framework.utils.t.c(this);     // Catch: Throwable -> L8
        com.larksuite.framework.utils.t.b(this);     // Catch: Throwable -> L8
        com.ss.android.lark.chat.utils.j.a.clear();     // Catch: Throwable -> L8
        CodeBlockV2ThemeManager.a();     // Catch: Throwable -> L8
        TableUtils.a = null;     // Catch: Throwable -> L8
        ColumnsUtils.a = null;     // Catch: Throwable -> L8
        TextLayoutBuilder.b();     // Catch: Throwable -> L8
        this.c.d();     // Catch: Throwable -> L8
        z6b.a.a = false;     // Catch: Throwable -> L8
        ChatCoreModule.a().getChatDependency().r();     // Catch: Throwable -> L8
        com.ss.android.lark.chat.utils.u.a.a.a();     // Catch: Throwable -> L8
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L16;
        Log.w("FlowThreadWindowActivity", "FlowThreadWindowActivity cleanup failed", r2);
        return;
    L16:
        return;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public FlowThreadWindowActivity() {
        this.c = new com.ss.android.lark.chat.core.extension.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UserSession e9() {
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
    L14:
        StringBuilder r3 = new StringBuilder("invalid intent, intent:");
        if (r0 != null) goto L17;
        boolean r1 = true;
    L18:
        r3.append(r1);
        Log.e("FlowThreadWindowActivity", new IllegalUserSessionException(r3.toString()), true);
        finish();
        return PassportcConvention.a(getApplication());
    L17:
        r1 = false;
        goto L18
    L5:
        if (r0.getExtras() == null) goto L14;
        if (r0.hasExtra("iji.convention.user_id") == true) goto L10;
    L11:
        Log.e("FlowThreadWindowActivity", new IllegalUserSessionException("provideUserSession invalid extra, id:" + r0.hasExtra("iji.convention.user_id") + ", key:" + r0.hasExtra("iji.convention.session_key")), true);
        PassportcConvention.e(r0, getApplication());
    L13:
        return PassportcConvention.c(this);
    L10:
        if (r0.hasExtra("iji.convention.session_key") == true) goto L13;
        goto L11
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

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m512provideComponent() {
        return provideComponent();
    }

    @Override // zsb.d
    public final boolean Cy(Notice r2) {
        String r0 = this.b;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return t0.c(r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        ((BaseFragmentActivity) this).PARENT_TAG = "FlowThreadWindowActivity";
        super.onCreate(r5);
        zfb.a.a(this);
        ImSdk r6 = ImSdk.a;
        boolean r7 = ImSdk.c;
        boolean r0 = OfficeSDKManager.isAvailable();
        if (r0 == false) goto L26;
        if (r7 == false) goto L26;
        final OnBackPressedDispatcher r8 = getOnBackPressedDispatcher();
        r8.addCallback(this, new FlowThreadWindowActivity$setupActivityHookOnBackPressed$1(this, r8));
        FlowThreadWindowContainerFragment r9 = new FlowThreadWindowContainerFragment();
        r9.setArguments(getIntent().getExtras());
        Bundle r1 = getIntent().getExtras();
        if (r1 == null) goto L18;
        String r2 = r1.getString("chatID");
        if (r2 == null) goto L18;
    L21:
        this.b = r2;
        FragmentTransaction r3 = getSupportFragmentManager().beginTransaction();
        String r4 = FlowThreadWindowContainerFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r9, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, R.id.content) == true) goto L25;
        r3.add(R.id.content, r9, r4);
    L25:
        r3.commitAllowingStateLoss();
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.d(this);
        WindowInsetsUtils.e(this);
        WindowInsetsUtils.c(this).b(UIUtils.getColor(this, 2131102022));
        return;
    L18:
        if (r1 == null) goto L20;
        r2 = r1.getString("chatID");
        goto L21
    L20:
        r2 = null;
    L26:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r0 + ", im sdk ready: " + r7 + ", finish. " + FlowThreadWindowActivity.class.getName());
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onNewIntent(Intent r6) {
        super/*androidx.fragment.app.FragmentActivity*/.onNewIntent(r6);
        if (r6 == null) goto L28;
        Bundle r0 = r6.getExtras();
        if (r0 == null) goto L29;
        String r2 = r0.getString("chatID");
        if (r2 != null) goto L10;
        r2 = r0.getString("chatID");
    L10:
        if (r2 != null) goto L12;
    L15:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L18;
        return;
    L18:
        setIntent(r6);
        this.b = r2;
        FlowThreadWindowContainerFragment r3 = getSupportFragmentManager().findFragmentById(R.id.content);
        if ((r3 instanceof FlowThreadWindowContainerFragment) == false) goto L21;
        r3.A0(r6);
    L26:
        this.c.e(r6);
        return;
    L21:
        FlowThreadWindowContainerFragment r4 = new FlowThreadWindowContainerFragment();
        r4.setArguments(r0);
        FragmentTransaction r5 = getSupportFragmentManager().beginTransaction();
        String r7 = FlowThreadWindowContainerFragment.class.getName();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, r4, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, r7, R.id.content) == true) goto L25;
        r5.replace(R.id.content, r4, r7);
    L25:
        r5.commitAllowingStateLoss();
        goto L26
    L12:
        if (r2.length() == 0) goto L15;
        r1 = false;
        goto L16
    L29:
        return;
    }

    public final void onActivityResult(int r3, int r4, Intent r5) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r3, r4, r5);
        Fragment r0 = getSupportFragmentManager().findFragmentById(R.id.content);
        if (r0 == null) goto L5;
        r0.onActivityResult(r3, r4, r5);
    L5:
        this.c.a(r3, r4, r5);
    }
}
