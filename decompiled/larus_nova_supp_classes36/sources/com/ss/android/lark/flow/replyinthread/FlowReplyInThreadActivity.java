package com.ss.android.lark.flow.replyinthread;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
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
import com.ss.android.lark.chat.core.extension.a;
import com.ss.android.lark.chat.utils.t0;
import com.ss.android.lark.chatwindow.IllegalUserSessionException;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.entity.Notice;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d0c.b;
import d0c.c;
import dagger.Lazy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;
import zsb.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0018H\u0014J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0018H\u0002R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/ss/android/lark/flow/replyinthread/FlowReplyInThreadActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "Lcom/ss/android/lark/notification/export/IPushNotifyStrategy;", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "mFragmentLazy", "Ldagger/Lazy;", "Lcom/ss/android/lark/flow/replyinthread/FlowReplyInThreadContainerFragment;", "getMFragmentLazy", "()Ldagger/Lazy;", "setMFragmentLazy", "(Ldagger/Lazy;)V", "mFragment", "getMFragment", "()Lcom/ss/android/lark/flow/replyinthread/FlowReplyInThreadContainerFragment;", "threadId", "activityHookManager", "Lcom/ss/android/lark/chat/core/extension/ActivityHookManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "shouldNotifyPush", "", "notice", "Lcom/ss/android/lark/notification/export/entity/Notice;", "setupActivityHookOnBackPressed", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowReplyInThreadActivity extends Hilt_FlowReplyInThreadActivity implements c, d {

    @Inject
    public Lazy<FlowReplyInThreadContainerFragment> b;
    public String c;
    public final a d;

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return b.b(this);
    }

    public final FlowReplyInThreadContainerFragment A1() {
        Lazy<FlowReplyInThreadContainerFragment> r0 = this.b;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentLazy");
        r0 = null;
    L7:
        return (FlowReplyInThreadContainerFragment) r0.get();
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.flow.replyinthread.Hilt_FlowReplyInThreadActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowReplyInThreadActivity.class.getName()));
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
    @Override // com.ss.android.lark.flow.replyinthread.Hilt_FlowReplyInThreadActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowReplyInThreadActivity.class.getName()));
    L5:
        super.onDestroy();
        ((itb.c) LarkContext.spiByDwarf(itb.c.class)).V(this);
    }

    public FlowReplyInThreadActivity() {
        this.d = new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final UserSession e9() {
        Intent r0 = getIntent();
        if (r0 != null) goto L5;
    L14:
        StringBuilder r2 = new StringBuilder("invalid intent, intent:");
        if (r0 != null) goto L17;
        boolean r1 = true;
    L18:
        r2.append(r1);
        Log.e(((BaseFragmentActivity) this).PARENT_TAG, new IllegalUserSessionException(r2.toString()), true);
        finish();
        return PassportcConvention.a(getApplication());
    L17:
        r1 = false;
        goto L18
    L5:
        if (r0.getExtras() == null) goto L14;
        if (r0.hasExtra("iji.convention.user_id") == true) goto L10;
    L11:
        Log.e(((BaseFragmentActivity) this).PARENT_TAG, new IllegalUserSessionException("provideUserSession invalid extra, id:" + r0.hasExtra("iji.convention.user_id") + ", key:" + r0.hasExtra("iji.convention.session_key")), true);
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
    public final /* bridge */ /* synthetic */ Object m477provideComponent() {
        return provideComponent();
    }

    public static final String z1(FlowReplyInThreadActivity r0) {
        return ((BaseFragmentActivity) r0).PARENT_TAG;
    }

    @Override // zsb.d
    public final boolean Cy(Notice r2) {
        String r0 = this.c;
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        return t0.b(r2, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        ((BaseFragmentActivity) this).PARENT_TAG = "FlowReplyInThreadActivity";
        super.onCreate(r5);
        zfb.a.a(this);
        ImSdk r6 = ImSdk.a;
        boolean r7 = ImSdk.c;
        boolean r0 = OfficeSDKManager.isAvailable();
        if (r0 == false) goto L23;
        if (r7 == false) goto L23;
        final OnBackPressedDispatcher r8 = getOnBackPressedDispatcher();
        r8.addCallback(this, new FlowReplyInThreadActivity$setupActivityHookOnBackPressed$1(this, r8));
        A1().setArguments(getIntent().getExtras());
        Bundle r9 = getIntent().getExtras();
        if (r9 == null) goto L17;
        String r10 = r9.getString("key_params_thread_id");
    L18:
        this.c = r10;
        FragmentTransaction r11 = getSupportFragmentManager().beginTransaction();
        FlowReplyInThreadContainerFragment r1 = A1();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L22;
        r11.add(R.id.content, r1, null);
    L22:
        r11.commitAllowingStateLoss();
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.d(this);
        WindowInsetsUtils.e(this);
        WindowInsetsUtils.c(this).b(UIUtils.getColor(this, 2131102022));
        return;
    L17:
        r10 = null;
    L23:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r0 + ", im sdk ready: " + r7 + ", finish. " + FlowReplyInThreadActivity.class.getName());
        finish();
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r2, r3, r4);
        FlowReplyInThreadContainerFragment r0 = A1();
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }
}
