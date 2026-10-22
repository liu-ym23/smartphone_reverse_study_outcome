package com.larus.business.debug.base;

import android.R;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import aw8.c;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.business.debug.api.IDebugService;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import v19.f;
import zv8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/business/debug/base/DevelopActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "title", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setUpTitle", "setupFragment", "getBackgroundResource", "", "onDestroy", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DevelopActivity extends FlowCommonAppCompatActivity {
    public static final /* synthetic */ int g = 0;

    public final int C1() {
        return 2131102535;
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(DevelopActivity.class.getName()));
    L5:
        super.onDestroy();
        k.a.getClass();
        k.g = "";
        k.h = "";
        ((ArrayList) k.j).clear();
        ((EnumMap) k.i).clear();
        c.d = "";
        ((ArrayList) c.e).clear();
    }

    /* JADX INFO: Removed unreachable split cross block B:53:0x0106 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(DevelopActivity.class.getName()));
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

    public DevelopActivity() {
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
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (f.f(this) == false) goto L10;
        f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r9);
        setContentView(2131561781);
        Window r10 = getWindow();
        if (r10 == null) goto L13;
        View r11 = N1(r10);
    L14:
        setRootView(r11);
        L1();
        NovaTitleBarEx r1 = (NovaTitleBarEx) findViewById(2131388772);
        if (r1 == null) goto L17;
        NovaTitleBarEx.Y5(r1, AppHost.a.getAppStringName(), null, null, 6);
        NovaTitleBarEx.b6(r1, 2131241477, false, null, null, new rv8.c(this), 14);
    L17:
        IDebugService r12 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r12 == null) goto L20;
        r12.w();
    L20:
        FragmentTransaction r13 = getSupportFragmentManager().beginTransaction();
        if (AppHost.a.isTestChannel() == true) goto L29;
        SetsKt.setOf("auto_test").contains("obric_pacific");
        if (AuthModelDelegate.b.s() == false) goto L28;
        c.a();
        DevelopCommonFragmentNew r2 = new DevelopCommonFragmentNew();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r2, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131381797) == true) goto L69;
        r13.replace(2131381797, r2);
    L69:
        boolean r0 = false;
    L70:
        r13.commitAllowingStateLoss();
        if (r0 == false) goto L76;
        finish();
        return;
    L76:
        return;
    L28:
        r0 = true;
        goto L70
    L29:
        Bundle r3 = getIntent().getExtras();
        if (r3 == null) goto L32;
        UserCreation r4 = (UserCreation) r3.getParcelable("key_debug_user_creation");
    L34:
        if ((r4 instanceof UserCreation) == true) goto L37;
        r4 = null;
    L37:
        if (r4 == null) goto L44;
        IDebugService r5 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r5 == null) goto L41;
        Fragment r6 = r5.y();
    L42:
        if (r6 == null) goto L64;
        r6.setArguments(getIntent().getExtras());
    L64:
        if (r6 == null) goto L69;
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r13, r6, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131381798) == true) goto L69;
        r13.replace(2131381798, r6);
        goto L69
    L41:
        r6 = null;
        goto L42
    L44:
        Bundle r7 = getIntent().getExtras();
        if (r7 == null) goto L47;
        Serializable r8 = r7.getSerializable("key_debug_canvas");
    L49:
        if ((r8 instanceof CanvasBlock) == false) goto L51;
        CanvasBlock r14 = (CanvasBlock) r8;
    L52:
        if (r14 == null) goto L59;
        IDebugService r15 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r15 == null) goto L56;
        r6 = r15.q();
    L57:
        if (r6 == null) goto L64;
        r6.setArguments(getIntent().getExtras());
        goto L64
    L56:
        r6 = null;
        goto L57
    L59:
        IDebugService r16 = (IDebugService) ServiceManager.get().getService(IDebugService.class);
        if (r16 == null) goto L62;
        r6 = r16.E();
    L63:
        c.a();
        goto L64
    L62:
        r6 = null;
        goto L63
    L51:
        r14 = null;
        goto L52
    L47:
        r8 = null;
        goto L49
    L32:
        r4 = null;
        goto L34
    L13:
        r11 = null;
        goto L14
    }
}
