package com.ss.android.lark.lynxkit.host;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.http.model.http.HttpHeaders;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.h;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tqb.c;
import tqb.d;
import tqb.e;
import tqb.f;
import tqb.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 &2\u00020\u00012\u00020\u0002:\u0001&B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\b\u0010\u0014\u001a\u00020\u0010H\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0014J \u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0018\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\bH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/lynxkit/host/LarkLynxPageActivity;", "Landroid/app/Activity;", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostController;", "<init>", "()V", "hostId", "", "entry", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostEntry;", "container", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "loadingView", "Landroid/view/View;", "closeNotified", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onPause", "onBackPressed", "onDestroy", "attachContainer", "rootView", "Landroid/widget/FrameLayout;", "lynxContainer", "params", "Lcom/ss/android/lark/lynxkit/host/LarkLynxHostParams;", "applySystemBars", "hostEntry", "showLoading", "hideLoading", HttpHeaders.HEAD_VALUE_CONNECTION_CLOSE, "source", "Lcom/ss/android/lark/lynxkit/host/LarkLynxCloseSource;", "notifyClose", "shouldRenderOnCreate", "Companion", "lark-lynx-kit_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class LarkLynxPageActivity extends Activity implements c {
    public static final /* synthetic */ int f = 0;
    public String a;
    public d b;
    public ILarkLynxContainer c;
    public View d;
    public boolean e;

    public static final class a {
    }

    public static final class b implements e {
        public final /* synthetic */ LarkLynxPageActivity a;
        public final /* synthetic */ FrameLayout b;
        public final /* synthetic */ d c;

        @Override // tqb.e
        public final void a() {
            LarkLynxPageActivity r0 = this.a;
            View r1 = r0.d;
            if (r1 == null) goto L10;
            ViewParent r3 = r1.getParent();
            if ((r3 instanceof ViewGroup) == false) goto L7;
            ViewGroup r4 = (ViewGroup) r3;
        L8:
            if (r4 == null) goto L10;
            r4.removeView(r1);
            goto L10
        L7:
            r4 = null;
        L10:
            r0.d = null;
        }

        @Override // tqb.e
        public final void onLoadStart() {
            LarkLynxPageActivity r0 = this.a;
            FrameLayout r1 = this.b;
            LarkLynxHostParams r2 = this.c.a;
            int r3 = LarkLynxPageActivity.f;
            r0.a(r1, r2);
        }

        public b(LarkLynxPageActivity r1, FrameLayout r2, d r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    static {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context r1) {
        super.attachBaseContext(r1);
        NewMiraResourcesManager.getInstance().installActivity(this);
    }

    /* JADX INFO: Removed unreachable split cross block B:54:0x0110 */
    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        if ((this instanceof FragmentActivity) == true) goto L6;
        return;
    L6:
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(LarkLynxPageActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L48
        if (r6 != null) goto L13;
    L16:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L48
        monitor-exit(r5);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L51:
        return;
    L19:
        if (((FragmentActivity) this).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r2.i("ActivityLancet", "quit !resume, current state = " + ((FragmentActivity) this).getLifecycle().getCurrentState());     // Catch: Throwable -> L45
        goto L51
    L22:
        if (isFinishing() == true) goto L25;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r1 == null) goto L51;
        r1.addFlags(268435456);     // Catch: Throwable -> L45
        r1.addFlags(2097152);     // Catch: Throwable -> L45
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r1);     // Catch: Throwable -> L42
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r3 - r6.longValue()) >= 800) goto L16;
        monitor-exit(r5);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ILarkLynxContainer r0 = this.c;
        boolean r1 = false;
        if (r0 == null) goto L16;
        d r2 = this.b;
        if (r2 == null) goto L13;
        LarkLynxHostOptions r3 = r2.b;
        if (r3 == null) goto L13;
        LarkLynxBackPressedHandler r4 = r3.getBackPressedHandler();
        if (r4 == null) goto L13;
        if (r4.onBackPressed(r0) != true) goto L13;
        boolean r5 = true;
    L14:
        if (r5 == false) goto L16;
        r1 = true;
    L13:
        r5 = false;
    L16:
        if (r1 == false) goto L18;
        return;
    L18:
        K40(LarkLynxCloseSource.BACK);
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        ILarkLynxContainer r0 = this.c;
        boolean r1 = isChangingConfigurations();
        if (r1 == true) goto L16;
        boolean r2 = this.e;
        if (r2 == true) goto L16;
        LarkLynxCloseSource r3 = LarkLynxCloseSource.PROGRAMMATIC;
        if (r2 == true) goto L16;
        this.e = true;
        d r4 = this.b;
        if (r4 == null) goto L16;
        LarkLynxHostOptions r5 = r4.b;
        if (r5 == null) goto L16;
        LarkLynxHostCloseCallback r6 = r5.getCloseCallback();
        if (r6 == null) goto L16;
        r6.onClose(r3);
    L16:
        if (r0 == null) goto L30;
        d r7 = this.b;
        if (r7 == null) goto L22;
        g r8 = r7.d;
        if (r8 == null) goto L22;
        r8.a(r0);
    L22:
        d r9 = this.b;
        if (r9 == null) goto L29;
        LarkLynxHostOptions r10 = r9.b;
        if (r10 == null) goto L29;
        LarkLynxHostLifecycleCallback r11 = r10.getLifecycleCallback();
        if (r11 == null) goto L29;
        r11.onDestroy(r0);
    L29:
        r0.destroy();
    L30:
        this.c = null;
        d r12 = this.b;
        if (r12 == null) goto L35;
        g r13 = r12.d;
        if (r13 == null) goto L35;
        r13.b(this);
    L35:
        if (r1 == true) goto L41;
        ConcurrentHashMap<String, d> r14 = f.a;
        f.c(this.a);
        d r15 = this.b;
        if (r15 == null) goto L41;
        g r16 = r15.d;
        if (r16 == null) goto L41;
        r16.d();
    L41:
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        ILarkLynxContainer r0 = this.c;
        if (r0 == null) goto L11;
        r0.hide();
        d r1 = this.b;
        if (r1 == null) goto L11;
        LarkLynxHostOptions r2 = r1.b;
        if (r2 == null) goto L11;
        LarkLynxHostLifecycleCallback r3 = r2.getLifecycleCallback();
        if (r3 == null) goto L11;
        r3.onHide(r0);
    L11:
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
        ILarkLynxContainer r0 = this.c;
        if (r0 == null) goto L12;
        r0.show();
        d r1 = this.b;
        if (r1 == null) goto L13;
        LarkLynxHostOptions r2 = r1.b;
        if (r2 == null) goto L14;
        LarkLynxHostLifecycleCallback r3 = r2.getLifecycleCallback();
        if (r3 == null) goto L15;
        r3.onShow(r0);
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // android.app.Activity
    public final void onStop() {
        super.onStop();
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

    public LarkLynxPageActivity() {
    }

    @Override // tqb.c
    public final void K40(LarkLynxCloseSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
        if (this.e == true) goto L12;
        this.e = true;
        d r0 = this.b;
        if (r0 == null) goto L12;
        LarkLynxHostOptions r1 = r0.b;
        if (r1 == null) goto L12;
        LarkLynxHostCloseCallback r3 = r1.getCloseCallback();
        if (r3 == null) goto L12;
        r3.onClose(r2);
    L12:
        finish();
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle r9) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r9);
        Intent r10 = getIntent();
        ViewGroup r0 = null;
        if (r10 == null) goto L13;
        String r11 = r10.getStringExtra("extra_lynx_host_id");
    L14:
        this.a = r11;
        ConcurrentHashMap<String, d> r1 = f.a;
        d r12 = f.a(r11);
        this.b = r12;
        if (r12 != null) goto L17;
        Log.e("LynxPageActivity", "onCreate failed, host entry not found");
        finish();
        return;
    L17:
        g r2 = r12.d;
        if (r2 == null) goto L20;
        r2.c(this);
    L20:
        getWindow().setSoftInputMode(r12.b.getSoftInputMode());
        FrameLayout r3 = new FrameLayout(this);
        Integer r4 = r12.a.getContainerBackgroundColor();
        if (r4 == null) goto L23;
        int r5 = r4.intValue();
    L24:
        r3.setBackgroundColor(r5);
        setContentView(r3);
        LarkLynxSystemBarOptions r6 = r12.b.getPageSystemBarOptions();
        Integer r7 = r12.a.getContainerBackgroundColor();
        if (r7 == null) goto L27;
        int r8 = r7.intValue();
    L28:
        h r13 = WindowInsetsUtils.c(this);
        Integer r14 = r6.getStatusBarColor();
        if (r14 == null) goto L31;
        int r15 = r14.intValue();
    L32:
        r13.b(r15);
        r13.c(r6.getConsumeStatusBar());
        r13.h(r6.getConsumeDisplayCutout());
        Boolean r16 = r6.isAppearanceLightStatusBars();
        if (r16 == null) goto L35;
        boolean r17 = r16.booleanValue();
        r13.k(false);
        r13.v(r17);
    L36:
        Integer r18 = r6.getNavigationBarColor();
        if (r18 == null) goto L39;
        r8 = r18.intValue();
    L39:
        r13.i(r8);
        r13.o(r6.getConsumeNavigationBar());
        Boolean r19 = r6.isAppearanceLightNavigationBars();
        if (r19 == null) goto L42;
        boolean r20 = r19.booleanValue();
        r13.r(false);
        r13.p(r20);
    L43:
        b r21 = new b(this, r3, r12);
        int r22 = tqb.b.a;     // Catch: Throwable -> L66
        ILarkLynxContainer r23 = tqb.b.a(this, r12.a, r12.b, r21);     // Catch: Throwable -> L66
        this.c = r23;     // Catch: Throwable -> L66
        g r24 = r12.d;     // Catch: Throwable -> L66
        if (r24 == null) goto L47;
        r24.e(r23);     // Catch: Throwable -> L66
    L47:
        LarkLynxHostParams r25 = r12.a;     // Catch: Throwable -> L66
        View r26 = r23.getLynxView();     // Catch: Throwable -> L66
        ViewParent r27 = r26.getParent();     // Catch: Throwable -> L66
        if ((r27 instanceof ViewGroup) == false) goto L50;
        r0 = (ViewGroup) r27;     // Catch: Throwable -> L66
    L50:
        if (r0 == null) goto L52;
        r0.removeView(r26);     // Catch: Throwable -> L66
    L52:
        ViewGroup.LayoutParams r28 = r25.getLayoutParams();     // Catch: Throwable -> L66
        if (r28 != null) goto L55;
        r28 = new FrameLayout.LayoutParams(-1, -1);     // Catch: Throwable -> L66
    L55:
        r3.addView(r26, r28);     // Catch: Throwable -> L66
        g r29 = r12.d;     // Catch: Throwable -> L66
        if (r29 == null) goto L58;
        boolean r30 = r29.f();     // Catch: Throwable -> L66
    L60:
        if (r12.a.getShowLoading() == false) goto L63;
        if (r30 == false) goto L63;
        a(r3, r12.a);     // Catch: Throwable -> L66
    L63:
        if (r30 == false) goto L74;
        tqb.b.c(r23, r12.a);     // Catch: Throwable -> L66
        return;
    L74:
        return;
    L58:
        r30 = r12.c;     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        Log.e("LynxPageActivity", "create lynx page host failed", th);
        finish();
        return;
    L42:
        r13.r(r6.isAutoCalculateLightNavigationBars());
        goto L43
    L35:
        r13.k(r6.isAutoCalculateLightStatusBars());
        goto L36
    L31:
        r15 = r8;
        goto L32
    L27:
        r8 = 0;
        goto L28
    L23:
        r5 = 0;
        goto L24
    L13:
        r11 = null;
        goto L14
    }

    public final void a(FrameLayout r4, LarkLynxHostParams r5) {
        if (r5.getShowLoading() == true) goto L5;
        return;
    L5:
        if (this.d != null) goto L10;
        ProgressBar r6 = new ProgressBar(this);
        r4.addView(r6, new FrameLayout.LayoutParams(-2, -2, 17));
        this.d = r6;
        return;
    }
}
