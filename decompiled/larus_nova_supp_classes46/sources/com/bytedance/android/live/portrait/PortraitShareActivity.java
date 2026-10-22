package com.bytedance.android.live.portrait;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ShareBaseActivity;
import com.bytedance.android.livehostapi.business.IAssignUiModeDelegate;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.android.livehostapi.business.depend.share.LiveResourcesOwner;
import com.bytedance.android.livehostapi.business.depend.share.MatchShareViewModel;
import com.bytedance.android.livehostapi.business.depend.share.ShareScreenOrientation;
import com.bytedance.android.livesdk.config.z1;
import com.bytedance.android.livesdk.t8;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.home.impl.utils.c;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/portrait/PortraitShareActivity;", "Lcom/bytedance/android/live/ShareBaseActivity;", "Lcom/bytedance/android/livehostapi/business/depend/share/LiveResourcesOwner;", "<init>", "()V", "a", "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class PortraitShareActivity extends ShareBaseActivity implements LiveResourcesOwner {
    public IAssignUiModeDelegate e;

    public static final class a {
    }

    static {
    }

    public final boolean ignoreHook() {
        return true;
    }

    public final IAssignUiModeDelegate B1() {
        IHostBusiness r0 = k.f(IHostBusiness.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAssignUiModeDelegate(this, 32, ((Integer) z1.a.getValue()).intValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        overridePendingTransition(0, 2130772778);
        if ((this instanceof ChatWindowActivity) == true) goto L56;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(getClass().getName()));
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
    L53:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
    L48:
        goto L53
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

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(getClass().getName()));
    L5:
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final MatchShareViewModel z1() {
        MatchShareViewModel r0 = MatchShareViewModel.Companion.get(this);
        MutableLiveData r1 = new MutableLiveData();
        r1.setValue(Integer.valueOf(ShareScreenOrientation.Portrait.getStatus()));
        if (r0 == null) goto L5;
        r0.setScreenOrientationChange(r1);
    L5:
        if (r0 == null) goto L9;
        MutableLiveData r2 = r0.getSetScreenOrientationVertical();
        if (r2 == null) goto L9;
        r2.observe(this, new PortraitShareActivity$createViewModel$1(this));
    L9:
        return r0;
    }

    public PortraitShareActivity() {
        this.e = B1();
    }

    public final void onResume() {
        super/*androidx.fragment.app.FragmentActivity*/.onResume();
        int r0 = PortraitShareFragment.i;
        PortraitShareFragment r1 = PortraitShareFragment.a.a(((ShareBaseActivity) this).d);
        ((ShareBaseActivity) this).a = r1;
        y1(Boolean.TRUE, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L9;
        A1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public static View A1(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void attachBaseContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "newBase");
        IAssignUiModeDelegate r0 = this.e;
        if (r0 == null) goto L5;
        r0.beforeAttachBaseContext(r2);
    L5:
        IAssignUiModeDelegate r1 = this.e;
        if (r1 == null) goto L9;
        Context r3 = r1.createContextWithAssignUiModeForActivity(r2);
        if (r3 == null) goto L9;
    L10:
        super/*androidx.appcompat.app.AppCompatActivity*/.attachBaseContext(r3);
        IAssignUiModeDelegate r4 = this.e;
        if (r4 == null) goto L14;
        r4.afterAttachBaseContext(r2);
        return;
    L14:
        return;
    L9:
        r3 = r2;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
        super.onConfigurationChanged(r5);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L19;
        int r2 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r5 == null) goto L8;
        Integer r6 = Integer.valueOf(r5.orientation);     // Catch: Throwable -> L17
    L9:
        if (r6 != null) goto L12;
    L14:
        if (r2 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:" + getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r6.intValue() == r2) goto L19;
    L8:
        r6 = null;
    L19:
        int r7 = PortraitShareFragment.i;
        PortraitShareFragment r8 = PortraitShareFragment.a.a(((ShareBaseActivity) this).d);
        ((ShareBaseActivity) this).a = r8;
        y1(Boolean.TRUE, r8);
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        f.a(getTheme());     // Catch: Throwable -> L20
    L6:
        if (f.f(this) == false) goto L8;
        f.c(getTheme());     // Catch: Throwable -> L20
    L8:
        super.onCreate(r4);
        getWindow().addFlags(1024);
        t8.b(getWindow());
        Window r5 = getWindow();
        if (r5 == null) goto L12;
        t8.c(r5, t8.a(r5), 0);
    L12:
        View r6 = A1(getWindow());
        com.bytedance.android.live.core.utils.statusbar.a.b.a();
        r6.setSystemUiVisibility(1024);
        if (this.e != null) goto L21;
        this.e = B1();
    L21:
        setContentView(2131567981);     // Catch: Exception -> L18
        return;
    L18:
        finish();
    }
}
