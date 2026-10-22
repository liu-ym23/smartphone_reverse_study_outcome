package com.obric.miniapp.view;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.capabilitykit.common.UiType;
import com.obric.miniapp.databinding.MiniAppActivityUserGuideBinding;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/miniapp/view/MiniAppUserGuideActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/obric/miniapp/databinding/MiniAppActivityUserGuideBinding;", "appletId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "needAdaptNavigationBarPadding", "", "needAdaptStatusBarPadding", "getBackgroundResource", "", "finish", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MiniAppUserGuideActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int i = 0;
    public MiniAppActivityUserGuideBinding g;
    public String h;

    public static final class a implements Animation.AnimationListener {
        public final /* synthetic */ MiniAppUserGuideActivity a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public a(MiniAppUserGuideActivity r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r2) {
            MiniAppUserGuideActivity.O1(this.a);
            this.a.overridePendingTransition(0, 0);
        }
    }

    public final int C1() {
        return 2131103628;
    }

    public final boolean H1() {
        return false;
    }

    public final boolean K1() {
        return false;
    }

    public final void onBackPressed() {
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(MiniAppUserGuideActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0121 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        MiniAppActivityUserGuideBinding r2 = this.g;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L5:
        RoundLinearLayout r3 = r2.d;
        Animation r4 = AnimationUtils.loadAnimation(this, 2130772476);
        r4.setAnimationListener(new a(this));
        r3.startAnimation(r4);
        if ((this instanceof ChatWindowActivity) == true) goto L47;
        FLogger r5 = FLogger.a;
        r5.i("ActivityLancet", "finish ".concat(MiniAppUserGuideActivity.class.getName()));
        long r6 = SystemClock.uptimeMillis();
        Map<Activity, Long> r7 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r7);
        Long r8 = r7.get(this);     // Catch: Throwable -> L48
        if (r8 != null) goto L13;
    L16:
        r7.put(this, Long.valueOf(r6));     // Catch: Throwable -> L48
        monitor-exit(r7);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r5.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r5.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r5.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r5.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r5.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(UiType.FLAG_REMOTE_CARD);     // Catch: Throwable -> L45
        r5.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r6 - r8.longValue()) >= 800) goto L16;
        monitor-exit(r7);     // Catch: Throwable -> L48
    L48:
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

    public MiniAppUserGuideActivity() {
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

    public static final /* synthetic */ void O1(MiniAppUserGuideActivity r0) {
        super.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r9);
        Intent r10 = getIntent();
        if (r10 == null) goto L14;
        String r11 = r10.getStringExtra("appletId");
        if (r11 == null) goto L14;
    L15:
        this.h = r11;
        MiniAppActivityUserGuideBinding r1 = null;
        ConstraintLayout r12 = getLayoutInflater().inflate(2131563652, null, false);
        ConstraintLayout r0 = r12;
        int r2 = 2131380125;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131380125)) == null) goto L60;
        r2 = 2131380126;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131380126);
        if (r4 == null) goto L60;
        r2 = 2131380127;
        if (((LinearLayout) ViewBindings.findChildViewById(r12, 2131380127)) == null) goto L60;
        r2 = 2131380128;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131380128);
        if (r5 == null) goto L60;
        r2 = 2131380129;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131380129)) == null) goto L60;
        r2 = 2131380130;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131380130)) == null) goto L60;
        r2 = 2131380131;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131380131)) == null) goto L60;
        r2 = 2131380132;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131380132)) == null) goto L60;
        r2 = 2131380133;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131380133)) == null) goto L60;
        r2 = 2131380138;
        RoundLinearLayout r6 = ViewBindings.findChildViewById(r12, 2131380138);
        if (r6 == null) goto L60;
        r2 = 2131380139;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r12, 2131380139);
        if (r7 == null) goto L60;
        this.g = new MiniAppActivityUserGuideBinding(r0, r4, r5, r6, r7);
        setContentView(r0);
        MiniAppActivityUserGuideBinding r13 = this.g;
        if (r13 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L40:
        r13.d.startAnimation(AnimationUtils.loadAnimation(this, 2130772475));
        Window r14 = getWindow();
        if (r14 == null) goto L43;
        View r15 = N1(r14);
    L44:
        setRootView(r15);
        View r16 = ((FlowCommonAppCompatActivity) this).b;
        if (r16 == null) goto L47;
        r16.setBackgroundColor(getResources().getColor(2131106784));
    L47:
        Window r17 = getWindow();
        if (r17 == null) goto L50;
        r17.setBackgroundDrawableResource(2131106784);
    L50:
        MiniAppActivityUserGuideBinding r18 = this.g;
        if (r18 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L53:
        r18.b.setOnClickListener(new f0(this));
        MiniAppActivityUserGuideBinding r19 = this.g;
        if (r19 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L57:
        r1.c.setOnClickListener(new g0(this));
        return;
    L56:
        r1 = r19;
        goto L57
    L43:
        r15 = null;
    L60:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r2)));
    L14:
        r11 = "";
        goto L15
    }
}
