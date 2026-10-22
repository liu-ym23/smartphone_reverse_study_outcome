package com.larus.avlink.env.event;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.material.tabs.TabLayout;
import com.larus.avlink.impl.databinding.LarusActivityDoraMemoryDataBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/larus/avlink/env/event/DoraEnvObserveMemoryDataActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "binding", "Lcom/larus/avlink/impl/databinding/LarusActivityDoraMemoryDataBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "getBackgroundResource", "", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DoraEnvObserveMemoryDataActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int h = 0;
    public LarusActivityDoraMemoryDataBinding g;

    public final int C1() {
        return 2131102535;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DoraEnvObserveMemoryDataActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DoraEnvObserveMemoryDataActivity.class.getName()));
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

    public DoraEnvObserveMemoryDataActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r11) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r11);
        LarusActivityDoraMemoryDataBinding r2 = null;
        View r12 = getLayoutInflater().inflate(2131561782, null, false);
        int r0 = 2131388030;
        TabLayout r1 = ViewBindings.findChildViewById(r12, 2131388030);
        if (r1 == null) goto L44;
        r0 = 2131388772;
        NovaTitleBarEx r3 = ViewBindings.findChildViewById(r12, 2131388772);
        if (r3 == null) goto L44;
        r0 = 2131392567;
        ViewPager2 r4 = ViewBindings.findChildViewById(r12, 2131392567);
        if (r4 == null) goto L44;
        LinearLayout r13 = (LinearLayout) r12;
        this.g = new LarusActivityDoraMemoryDataBinding(r13, r1, r3, r4);
        setContentView(r13);
        LarusActivityDoraMemoryDataBinding r14 = this.g;
        if (r14 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L19:
        NovaTitleBarEx r5 = r14.c;
        NovaTitleBarEx.Y5(r5, getString(2131903340), 2131103136, null, 4);
        r5.getBinding().j.setTextSize(2, 17.0f);
        r5.getBinding().j.setTypeface(null, 1);
        NovaTitleBarEx.b6(r5, 2131241477, false, null, null, new n(this), 14);
        LarusActivityDoraMemoryDataBinding r15 = this.g;
        if (r15 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L22:
        r15.d.setAdapter(new DoraEnvObserveMemoryDataActivity$setupView$2(this));
        LarusActivityDoraMemoryDataBinding r16 = this.g;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L25:
        TabLayout r17 = r16.b;
        LarusActivityDoraMemoryDataBinding r6 = this.g;
        if (r6 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L28:
        TabLayout.Tab r7 = r6.b.newTab();
        int r8 = com.larus.utils.j0.a;
        r17.addTab(r7.setText(com.larus.utils.j0.d(2131902517)));
        LarusActivityDoraMemoryDataBinding r18 = this.g;
        if (r18 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L31:
        TabLayout r19 = r18.b;
        LarusActivityDoraMemoryDataBinding r9 = this.g;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L34:
        r19.addTab(r9.b.newTab().setText(com.larus.utils.j0.d(2131902532)));
        LarusActivityDoraMemoryDataBinding r110 = this.g;
        if (r110 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L37:
        r110.b.addOnTabSelectedListener(new o(this));
        LarusActivityDoraMemoryDataBinding r111 = this.g;
        if (r111 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L41:
        r2.d.registerOnPageChangeCallback(new DoraEnvObserveMemoryDataActivity$setupView$4(this));
        return;
    L40:
        r2 = r111;
    L44:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
