package com.larus.setting.impl.iconchanger;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
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
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\"\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larus/setting/impl/iconchanger/ChangeAppIconActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "enableBack", "", "fg", "Lcom/larus/setting/impl/iconchanger/ChangeAppIconFragment;", "getFg", "()Lcom/larus/setting/impl/iconchanger/ChangeAppIconFragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getBackgroundResource", "", "onBackPressed", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class ChangeAppIconActivity extends FlowCommonAppCompatActivity {
    public boolean g;
    public final ChangeAppIconFragment h;

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131102535;
    }

    public final void onBackPressed() {
        if (this.g == false) goto L6;
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
        return;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ChangeAppIconActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public ChangeAppIconActivity() {
        this.g = true;
        this.h = new ChangeAppIconFragment();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ChangeAppIconActivity.class.getName()));
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
        setContentView(2131561787);
        Window r6 = getWindow();
        String r0 = null;
        if (r6 == null) goto L13;
        View r7 = N1(r6);
    L14:
        setRootView(r7);
        L1();
        this.h.setArguments(getIntent().getExtras());
        FragmentTransaction r8 = getSupportFragmentManager().beginTransaction();
        ChangeAppIconFragment r1 = this.h;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r8, r1, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L18;
        r8 = r8.replace(2131373275, r1);
    L18:
        r8.commitAllowingStateLoss();
        Bundle r9 = getIntent().getExtras();
        if (r9 == null) goto L21;
        r0 = r9.getString("enter_method");
    L21:
        this.g = !Intrinsics.areEqual(r0, "registration_process");
        return;
    L13:
        r7 = null;
        goto L14
    }

    public final void onActivityResult(int r73, int r74, Intent r75) {
        super.onActivityResult(r73, r74, r75);
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("Router onActivityResult: requestCode -> ");
        r1.append(r73);
        r1.append(" , resultCode -> ");
        r1.append(r74);
        r1.append(" , data: ");
        if (r75 == null) goto L5;
        Bundle r3 = r75.getExtras();
    L6:
        r1.append(r3);
        r0.i("ChangeAppIconActivity", r1.toString());
        if (r75 == null) goto L41;
        Bundle r2 = r75.getExtras();
        if (r2 == null) goto L41;
        ChangeAppIconFragment r4 = this.h;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "bundle");
        if (z2.a.o3().a == false) goto L20;
        w2a.f r5 = w2a.h.a(r2);
        if (r5 == null) goto L42;
        BotModel r6 = r4.r;
        if (r6 == null) goto L19;
        SpeakerVoice r7 = r6.getVoiceType();
        if (r7 == null) goto L19;
        r7.getId();
    L19:
        r4.v = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new ChangeAppIconFragment$setupSelectSpeakerResult$1$1(r4, r5, null), 3, null);
        return;
    L42:
        return;
    L20:
        SpeakerVoice r8 = r2.getSerializable("select_speaker_result");
        if ((r8 instanceof SpeakerVoice) == false) goto L23;
        SpeakerVoice r23 = r8;
    L24:
        if (r23 != null) goto L26;
        return;
    L26:
        if (Intrinsics.areEqual(r23.getId(), "none") == false) goto L33;
        BotModel r9 = r4.r;
        if (r9 == null) goto L39;
        BotModel r10 = BotModel.copy$default(r9, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r23, null, true, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null);
        if (r10 == null) goto L39;
        r4.r = r10;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new ChangeAppIconFragment$updateBotInfo$1(r10, r4, null), 3, null);
    L39:
        r4.v = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new ChangeAppIconFragment$setupSelectSpeakerResult$2$1(r4, null), 3, null);
        return;
    L33:
        BotModel r11 = r4.r;
        if (r11 == null) goto L39;
        BotModel r12 = BotModel.copy$default(r11, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, r23, null, false, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -655361, Integer.MAX_VALUE, null);
        if (r12 == null) goto L39;
        r4.r = r12;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r4), null, null, new ChangeAppIconFragment$updateBotInfo$1(r12, r4, null), 3, null);
        goto L39
    L23:
        r23 = null;
    L41:
        return;
    L5:
        r3 = null;
        goto L6
    }
}
