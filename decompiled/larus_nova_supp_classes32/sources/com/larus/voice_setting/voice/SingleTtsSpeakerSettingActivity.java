package com.larus.voice_setting.voice;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/voice_setting/voice/SingleTtsSpeakerSettingActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "Lcom/larus/voice_setting/voice/ISingleTtsSpeakerSettingActivity;", "<init>", "()V", "onCreate", NameKeys.UnloadStrategy_No_Strategy, "savedInstanceState", "Landroid/os/Bundle;", "onKeyDown", NameKeys.UnloadStrategy_No_Strategy, "keyCode", NameKeys.UnloadStrategy_No_Strategy, "event", "Landroid/view/KeyEvent;", "getBackgroundResource", "useNewStyle", "showDebugEntryToast", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SingleTtsSpeakerSettingActivity extends FlowCommonAppCompatActivity implements k0 {
    public static boolean O1() {
        z2 r0 = z2.a;
        if (r0.I2() == true) goto L12;
        com.larus.voice_setting.voice.utils.f r1 = com.larus.voice_setting.voice.utils.f.a;
        if (r1.c().a == true) goto L12;
        if (r1.g() == true) goto L12;
        if (r0.o3().a == true) goto L12;
        return false;
    L12:
        return true;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(SingleTtsSpeakerSettingActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int C1() {
        if (O1() == false) goto L6;
        return v19.c.b(2130970529, this, 2131102529);
    L6:
        return v19.c.b(2130970531, this, 2131102535);
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(SingleTtsSpeakerSettingActivity.class.getName()));
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

    public SingleTtsSpeakerSettingActivity() {
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
        if (r6 == null) goto L13;
        View r7 = N1(r6);
    L14:
        setRootView(r7);
        L1();
        if (O1() == false) goto L17;
        Fragment r8 = new DoubleTabTtsSpeakerSettingFragment();
    L18:
        r8.setArguments(getIntent().getExtras());
        Bundle r1 = getIntent().getExtras();
        if (r1 == null) goto L21;
        String r2 = r1.getString("key_language_code", NameKeys.UnloadStrategy_No_Strategy);
    L23:
        if (O1() == false) goto L35;
        lq9.f0 r3 = z2.a.o3();
        int r4 = r3.b(r2);
        if (r3.a == true) goto L27;
    L30:
        boolean r9 = false;
    L31:
        if (r9 == false) goto L35;
        Bundle r10 = r8.getArguments();
        if (r10 == null) goto L35;
        r10.putBoolean("key_ui_mode", true);
        goto L35
    L27:
        if (r4 == 2) goto L29;
        if (r4 != 1) goto L30;
    L29:
        r9 = true;
    L35:
        FragmentTransaction r11 = getSupportFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r11, r8, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L39;
        r11 = r11.replace(2131373275, r8);
    L39:
        r11.commitAllowingStateLoss();
        return;
    L21:
        r2 = null;
        goto L23
    L17:
        r8 = new SingleTtsSpeakerSettingFragment();
        goto L18
    L13:
        r7 = null;
        goto L14
    }

    public final boolean onKeyDown(int r3, KeyEvent r4) {
        if (O1() == false) goto L15;
        if (r3 != 4) goto L15;
        DoubleTabTtsSpeakerSettingFragment r0 = getSupportFragmentManager().findFragmentById(2131373275);
        if ((r0 instanceof DoubleTabTtsSpeakerSettingFragment) == false) goto L9;
        DoubleTabTtsSpeakerSettingFragment r1 = r0;
    L10:
        if (r1 == null) goto L15;
        if (r1.X90().getShowSelectedVoiceOnTop() == false) goto L15;
        r1.y = "click_cancel";
        r1.da0(true);
        r1.X90().saveVoicePitchAndRate();
        goto L15
    L9:
        r1 = null;
    L15:
        return super/*androidx.appcompat.app.AppCompatActivity*/.onKeyDown(r3, r4);
    }
}
