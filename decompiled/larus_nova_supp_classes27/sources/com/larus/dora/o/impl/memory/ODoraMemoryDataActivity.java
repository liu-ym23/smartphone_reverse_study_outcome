package com.larus.dora.o.impl.memory;

import android.R;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.dora.o.impl.databinding.DoraOActivityMemoryDataBinding;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.tab.OTabLayoutBase;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/larus/dora/o/impl/memory/ODoraMemoryDataActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/dora/o/impl/databinding/DoraOActivityMemoryDataBinding;", "suppressTabEvent", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupTitleBar", "setupTabAndPager", "needAdaptStatusBarPadding", "getBackgroundResource", "", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODoraMemoryDataActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int i = 0;
    public DoraOActivityMemoryDataBinding g;
    public boolean h;

    public static final class a {
    }

    static {
    }

    public final int C1() {
        return 2131101351;
    }

    public final boolean K1() {
        return false;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ODoraMemoryDataActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ODoraMemoryDataActivity.class.getName()));
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

    public ODoraMemoryDataActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r10);
        u69.a.a(this);
        FrameLayout.LayoutParams r1 = null;
        ConstraintLayout r11 = getLayoutInflater().inflate(2131560139, null, false);
        int r0 = 2131379889;
        FrameLayout r3 = (FrameLayout) ViewBindings.findChildViewById(r11, 2131379889);
        if (r3 == null) goto L41;
        r0 = 2131379890;
        OFloatingTitleBar r4 = ViewBindings.findChildViewById(r11, 2131379890);
        if (r4 == null) goto L41;
        r0 = 2131379891;
        ViewPager2 r5 = ViewBindings.findChildViewById(r11, 2131379891);
        if (r5 == null) goto L41;
        ConstraintLayout r12 = r11;
        this.g = new DoraOActivityMemoryDataBinding(r12, r3, r4, r5);
        setContentView(r12);
        DoraOActivityMemoryDataBinding r13 = this.g;
        if (r13 == null) goto L21;
        OFloatingTitleBar r14 = r13.c;
        if (r14 == null) goto L21;
        OFloatingTitleBar.k(r14, new com.larus.dora.o.impl.memory.a(this), 2);
        r14.setCenterTitle(getString(2131903062));
    L21:
        DoraOActivityMemoryDataBinding r15 = this.g;
        if (r15 == null) goto L44;
        final List r2 = CollectionsKt.listOf(new Fragment[]{new OMemoryEventFragment(), new OMemoryPersonalFragment()});
        r15.d.setAdapter(new ODoraMemoryDataActivity$setupTabAndPager$1(this, r2));
        OTabLayout r6 = LayoutInflater.from(this).inflate(2131560164, r15.b, false);
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.obric.oui.tab.OTabLayout");
        final OTabLayout r7 = r6;
        Resources r8 = getResources();
        int r9 = (int) ((12 * WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density) + 0.5f);
        Resources r16 = getResources();
        r7.setTabMaxWidth((int) ((160 * WindowDisplayMetricsOverride.apply(r16, r16.getDisplayMetrics()).density) + 0.5f));
        r7.setTabMode(1);
        r7.setTabGravity(0);
        r7.setTabPaddingStart(r9);
        r7.setTabPaddingEnd(r9);
        OTabLayoutBase.i r17 = r7.s(0);
        r17.a(2131902517);
        r7.h(r17);
        OTabLayoutBase.i r18 = r7.s(0);
        r18.a(2131902532);
        r7.h(r18);
        r7.setOnTabSelectedListener(new c(this, r15));
        Resources r20 = getResources();
        int r21 = (int) ((20 * WindowDisplayMetricsOverride.apply(r20, r20.getDisplayMetrics()).density) + 0.5f);
        com.obric.oui.common.style.b r22 = r7.getTabContainer();
        if (r22 != null) goto L27;
    L33:
        Resources r23 = getResources();
        final int r24 = (int) ((56 * WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()).density) + 0.5f);
        ViewCompat.setOnApplyWindowInsetsListener(r15.b, new b(r24));
        ViewGroup.LayoutParams r25 = r7.getLayoutParams();
        if ((r25 instanceof FrameLayout.LayoutParams) == false) goto L36;
        r1 = (FrameLayout.LayoutParams) r25;
    L36:
        if (r1 == null) goto L38;
        r1.gravity = 17;
    L38:
        r15.b.addView(r7);
        r15.d.registerOnPageChangeCallback(new ODoraMemoryDataActivity$setupTabAndPager$5(this, r7));
        return;
    L27:
        if ((r22 instanceof com.obric.oui.common.style.b) == false) goto L29;
        com.obric.oui.common.style.b r26 = r22;
    L30:
        if (r26 == null) goto L32;
        r26.setShadowCornerRadius(r21);
    L32:
        r22.invalidate();
        goto L33
    L29:
        r26 = null;
        goto L30
    L44:
        return;
    L41:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
