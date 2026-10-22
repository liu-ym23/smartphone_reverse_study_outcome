package com.ss.android.lark.flow.mergeforward;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
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
import com.ss.android.lark.audio.f;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import com.ss.android.lark.chatwindow.IllegalUserSessionException;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.light.layout.TextLayoutBuilder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dagger.Lazy;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\"\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u0019H\u0002J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110*R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lcom/ss/android/lark/flow/mergeforward/FlowMergeForwardActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "mFragmentLazy", "Ldagger/Lazy;", "Lcom/ss/android/lark/flow/mergeforward/FlowMergeForwardContainerFragment;", "getMFragmentLazy", "()Ldagger/Lazy;", "setMFragmentLazy", "(Ldagger/Lazy;)V", "mFragment", "getMFragment", "()Lcom/ss/android/lark/flow/mergeforward/FlowMergeForwardContainerFragment;", "msgIdPath", "", "", "messageContent", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "translatedMessageContent", "TAG", "getTAG", "()Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onWindowFocusChanged", "hasFocus", "", "initMsgIdPath", "getMsgIdPathList", "", "Companion", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowMergeForwardActivity extends Hilt_FlowMergeForwardActivity implements d0c.c {

    @Inject
    public Lazy<FlowMergeForwardContainerFragment> b;
    public List<String> c;
    public MergeForwardContent d;

    public static final class a {
    }

    static {
    }

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
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ss.android.lark.flow.mergeforward.Hilt_FlowMergeForwardActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FlowMergeForwardActivity.class.getName()));
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
    @Override // com.ss.android.lark.flow.mergeforward.Hilt_FlowMergeForwardActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(FlowMergeForwardActivity.class.getName()));
    L5:
        super.onDestroy();
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        ((itb.c) LarkContext.spiByDwarf(itb.c.class)).V(this);     // Catch: Throwable -> L11
        Map r1 = f.e;     // Catch: Throwable -> L11
        f r2 = f.b.a(this);     // Catch: Throwable -> L11
        r2.d();     // Catch: Throwable -> L11
        ((ConcurrentHashMap) r2.b).clear();     // Catch: Throwable -> L11
        ((ConcurrentHashMap) f.e).remove(r2.a);     // Catch: Throwable -> L11
        TextLayoutBuilder.b();     // Catch: Throwable -> L11
        int r3 = com.ss.android.lark.mergeforward.b.d - 1;     // Catch: Throwable -> L11
        com.ss.android.lark.mergeforward.b.d = r3;     // Catch: Throwable -> L11
        if (r3 != 0) goto L9;
        com.ss.android.lark.mergeforward.b.b = null;     // Catch: Throwable -> L11
        com.ss.android.lark.mergeforward.b.c = null;     // Catch: Throwable -> L11
    L9:
        ChatCoreModule.a().getChatDependency().r();     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public final FlowMergeForwardContainerFragment z1() {
        Lazy<FlowMergeForwardContainerFragment> r0 = this.b;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mFragmentLazy");
        r0 = null;
    L7:
        return (FlowMergeForwardContainerFragment) r0.get();
    }

    public FlowMergeForwardActivity() {
        this.c = new ArrayList();
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
    public final /* bridge */ /* synthetic */ Object m448provideComponent() {
        return provideComponent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r6) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        ((BaseFragmentActivity) this).PARENT_TAG = "FlowMergeForwardActivity";
        fsb.f.c("FlowMergeForwardActivity").j();
        fsb.f.b().i("onCreate");
        getTheme().setTo(getApplicationContext().getTheme());
        getTheme().applyStyle(2131952385, true);
        super.onCreate(r6);
        zfb.a.a(this);
        ImSdk r7 = ImSdk.a;
        boolean r8 = ImSdk.c;
        boolean r0 = OfficeSDKManager.isAvailable();
        if (r0 == false) goto L33;
        if (r8 == false) goto L33;
        z1().setArguments(getIntent().getExtras());
        FragmentTransaction r9 = getSupportFragmentManager().beginTransaction();
        FlowMergeForwardContainerFragment r1 = z1();
        MergeForwardContent r3 = null;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r9, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, null, R.id.content) == true) goto L18;
        r9.add(R.id.content, r1, null);
    L18:
        r9.commitAllowingStateLoss();
        WindowInsetsUtils.f(this);
        WindowInsetsUtils.d(this);
        WindowInsetsUtils.e(this);
        WindowInsetsUtils.c(this).b(UIUtils.getColor(this, 2131102022));
        com.ss.android.lark.mergeforward.b.a r10 = com.ss.android.lark.mergeforward.b.a;
        if (r10 == null) goto L21;
        r3 = r10.a;
    L21:
        this.d = r3;
        Bundle r11 = getIntent().getExtras();
        if (r11 == null) goto L26;
        ArrayList<String> r12 = r11.getStringArrayList("key_msg_id_path_list");
        if (r12 == null) goto L26;
    L27:
        this.c = r12;
        MergeForwardContent r13 = this.d;
        if (r13 == null) goto L32;
        String r14 = r13.getMessageId();
        if (r14 == null) goto L32;
        this.c.add(r14);
    L32:
        fsb.f.b().h("onCreate");
        return;
    L26:
        r12 = new ArrayList();
    L33:
        Log.w("OfficeSDKInitGuard", "office sdk available: " + r0 + ", im sdk ready: " + r8 + ", finish. " + FlowMergeForwardActivity.class.getName());
        finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r1) {
        super/*android.app.Activity*/.onWindowFocusChanged(r1);
        fsb.f.b().g();
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super/*androidx.fragment.app.FragmentActivity*/.onActivityResult(r2, r3, r4);
        FlowMergeForwardContainerFragment r0 = z1();
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        return;
    }
}
