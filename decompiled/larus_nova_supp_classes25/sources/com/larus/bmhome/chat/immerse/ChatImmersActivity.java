package com.larus.bmhome.chat.immerse;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.i4;
import com.larus.bmhome.chat.l4;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\nJ\"\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0016H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/larus/bmhome/chat/immerse/ChatImmersActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/bmhome/chat/IChatActivity;", "Lcom/larus/bmhome/chat/IImmersiveChatActivity;", "Lcom/larus/bmhome/chat/ITraceActivity;", "<init>", "()V", "TAG", "", "fg", "Lcom/larus/bmhome/chat/immerse/ChatImmersFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "needAdaptStatusBarPadding", "", "needAdaptNavigationBarPadding", "bindChatImmersFragment", "chatImmersFragment", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getCurrentFragment", "Lcom/larus/bmhome/chat/ChatFragment;", "scene", "getBackgroundResource", "getVContext", "Lcom/larus/ui/arch/context/external/VContext;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatImmersActivity extends FlowCommonAppCompatActivity implements d4, i4, l4 {
    public final String g;
    public ChatImmersFragment h;

    public final int C1() {
        return 2131103292;
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final String scene() {
        return "CHAT_MESSAGE_LIST_IMMERSE";
    }

    @Override // com.larus.bmhome.chat.i4
    public final Fragment getCurrentFragment() {
        return this.h.Z90();
    }

    public final t1a.b getVContext() {
        ChatFragment r0 = this.h.Z90();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.WF();
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ChatImmersActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public ChatImmersActivity() {
        this.g = "ChatImmersActivity";
        this.h = new ChatImmersFragment();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ChatImmersActivity.class.getName()));
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
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        N1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View N1(Window r3) {
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
    public final void onCreate(Bundle r5) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r5);
        if (z2.a.a0() == false) goto L13;
        FLogger.a.d(this.g, "skip recreate");
    L30:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L16
        setContentView(2131561787);     // Catch: Throwable -> L16
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Window r1 = getWindow();
        if (r1 == null) goto L21;
        View r2 = N1(r1);
    L22:
        setRootView(r2);
        L1();
        if (r5 != null) goto L34;
        this.h.setArguments(getIntent().getExtras());
        FLogger.a.d(this.g, "Router arguments: " + this.h.getArguments());
        FragmentTransaction r6 = getSupportFragmentManager().beginTransaction();
        ChatImmersFragment r3 = this.h;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r6, r3, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L28;
        r6 = r6.replace(2131373275, r3);
    L28:
        r6.commitAllowingStateLoss();
        return;
    L34:
        return;
    L21:
        r2 = null;
    L16:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L13:
        getDelegate().setLocalNightMode(2);
        goto L30
    }

    public final void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        this.h.onActivityResult(r2, r3, r4);
    }
}
