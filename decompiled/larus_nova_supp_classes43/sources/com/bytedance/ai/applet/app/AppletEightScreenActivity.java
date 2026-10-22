package com.bytedance.ai.applet.app;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.ai.applet.app.view.AppletActionSheetDialog;
import com.bytedance.ai.applet.app.view.AppletAppActionBar;
import com.bytedance.ai.applet.app.view.AppletDragHandleBottomSheetBehavior;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.facebook.drawee.view.DraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000©\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001%\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020#H\u0014J\b\u0010+\u001a\u00020#H\u0014J\b\u0010,\u001a\u00020#H\u0014J\n\u0010-\u001a\u0004\u0018\u00010.H\u0003J\u0010\u0010/\u001a\u00020#2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020#H\u0014J\u0015\u00103\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0010¢\u0006\u0002\b6J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020\u001dH\u0002J\b\u00109\u001a\u00020#H\u0002J\u001a\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010<H\u0002J\b\u0010>\u001a\u00020#H\u0002J\u001b\u0010?\u001a\r\u0012\t\u0012\u00070A¢\u0006\u0002\bB0@2\u0006\u0010C\u001a\u00020DH\u0002J\u0018\u0010E\u001a\u00020#2\u0006\u0010C\u001a\u00020D2\u0006\u0010F\u001a\u00020\u0019H\u0002J\u001f\u0010G\u001a\u00020#2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\"H\u0000¢\u0006\u0002\bIJ\b\u0010J\u001a\u00020#H\u0002J\n\u0010K\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010L\u001a\u00020MH\u0016J\b\u0010N\u001a\u00020#H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006P"}, d2 = {"Lcom/bytedance/ai/applet/app/AppletEightScreenActivity;", "Lcom/bytedance/ai/applet/app/AppletAppActivity;", "<init>", "()V", "showMode", "Lcom/bytedance/ai/applet/app/AppletShowMode;", "getShowMode$ai_sdk_release", "()Lcom/bytedance/ai/applet/app/AppletShowMode;", "rootView", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "scrimView", "Landroid/view/View;", "sheetView", "panelView", "pageStateView", "pageErrorView", "appIconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "appNameView", "Landroid/widget/TextView;", "actionBarView", "Lcom/bytedance/ai/applet/app/view/AppletAppActionBar;", "bottomSheetBehavior", "Lcom/bytedance/ai/applet/app/view/AppletDragHandleBottomSheetBehavior;", "actionSheetDialog", "Lcom/bytedance/ai/applet/app/view/AppletActionSheetDialog;", "pinStatusSyncJob", "Lkotlinx/coroutines/Job;", "hasOpenedActionSheet", "", "isDismissing", "isWindowBlurApplied", "dismissCompletions", "", "Lkotlin/Function0;", "", "bottomSheetCallback", "com/bytedance/ai/applet/app/AppletEightScreenActivity$bottomSheetCallback$1", "Lcom/bytedance/ai/applet/app/AppletEightScreenActivity$bottomSheetCallback$1;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupHostContent", "handleRootBackPressed", "onStop", "findTaskTopComponent", "Landroid/content/ComponentName;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onHostThemeChanged", "onCurrentPageContentStateChanged", "state", "Lcom/bytedance/ai/applet/app/AppletPageContentState;", "onCurrentPageContentStateChanged$ai_sdk_release", "showEightScreenPanel", "updateSheetSize", "bindAppletIdentity", "updateAppletIdentity", com.bytedance.android.ec.core.event.a.KEY_SHOPPING_GUIDE_NAME, "", "iconUrl", "showOptionsMenu", "getEightScreenSecondRowMenuItems", "", "Lcom/bytedance/ai/applet/app/view/MenuItem;", "Lkotlin/jvm/internal/EnhancedNullability;", "app", "Lcom/bytedance/ai/applet/app/AppletApplication;", "observePinMenuStatus", "dialog", "dismissWithAnimation", "onDismissed", "dismissWithAnimation$ai_sdk_release", "finishImmediately", "getMenuButton", "getMenuButtonBoundingClientRect", "Landroid/graphics/Rect;", "onDestroy", "Companion", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppletEightScreenActivity extends AppletAppActivity {
    public static final /* synthetic */ int C = 0;
    public final List<Function0<Unit>> A;
    public final b B;
    public final AppletShowMode k;
    public CoordinatorLayout l;
    public View m;
    public View n;
    public View o;
    public View p;
    public View q;
    public SimpleDraweeView r;
    public TextView s;
    public AppletAppActionBar t;
    public AppletDragHandleBottomSheetBehavior u;
    public AppletActionSheetDialog v;
    public Job w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b extends BottomSheetBehavior.b {
        public final /* synthetic */ AppletEightScreenActivity a;

        @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
        public final void a(View r1, float r10) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }

        public b(AppletEightScreenActivity r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ai.view.popup.anim.BottomSheetBehavior.b
        public final void b(View r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "bottomSheet");
            com.bytedance.ai.utils.g r12 = com.bytedance.ai.utils.g.a;
            r12.d("AppletEightScreenActivity", "onBottomSheetStateChanged: state=" + r11);
            if (r11 != 5) goto L5;
        L8:
            r12.i("AppletEightScreenActivity", "Panel dismissed, state=" + r11);
            AppletEightScreenActivity r13 = this.a;
            int r14 = AppletEightScreenActivity.C;
            r13.e2();
            return;
        L5:
            if (r11 == 4) goto L7;
            return;
        L7:
            if (this.a.y == true) goto L8;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void N1() {
        d2(null);
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final View I1() {
        AppletAppActionBar r0 = this.t;
        if (r0 == null) goto L8;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
        r0 = null;
    L7:
        return r0;
    L8:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void T1() {
        AppletAppActionBar r0 = this.t;
        if (r0 == null) goto L5;
        int r1 = AppletAppActionBar.v;
        r0.a(false);
    L5:
        View r10 = this.p;
        if (r10 == null) goto L8;
        r10.setBackgroundColor(getColor(2131100405));
    L8:
        AppletActionSheetDialog r11 = this.v;
        if (r11 == null) goto L12;
        r11.L0();
        return;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r10 = FLogger.a;
        r10.i("ActivityLancet", "finish ".concat(AppletEightScreenActivity.class.getName()));
        long r11 = SystemClock.uptimeMillis();
        Map r12 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r12);
        Long r13 = (Long) r12.get(this);     // Catch: Throwable -> L45
        if (r13 != null) goto L10;
    L13:
        r12.put(this, Long.valueOf(r11));     // Catch: Throwable -> L45
        monitor-exit(r12);     // Catch: Throwable -> L45
    L42:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r10.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
    L19:
        if (isFinishing() == true) goto L22;
        r10.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L42
        goto L48
    L22:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L25;
        r10.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L42
        goto L48
    L25:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L28;
        r10.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L42
        goto L48
    L28:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L31;
        r10.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L42
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
        r10.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L42
        startActivity(r1);     // Catch: Throwable -> L39
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L42
        goto L48
    L10:
        if ((r11 - r13.longValue()) >= 800) goto L13;
        monitor-exit(r12);     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public final boolean h2() {
        ViewGroup r0 = this.l;
        CoordinatorLayout r10 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r0 = null;
    L6:
        if (r0.getHeight() > 0) goto L13;
        com.bytedance.ai.utils.g r1 = com.bytedance.ai.utils.g.a;
        StringBuilder r11 = new StringBuilder("Skip sheet sizing because root height is ");
        CoordinatorLayout r12 = this.l;
        if (r12 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r11.append(r10.getHeight());
        r1.w("AppletEightScreenActivity", r11.toString());
        return false;
    L10:
        r10 = r12;
        goto L11
    L13:
        ViewGroup r13 = this.l;
        if (r13 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r13 = null;
    L16:
        int r14 = MathKt.roundToInt(r13.getHeight() * 0.65f);
        int r15 = n2.a.a(29);
        View r16 = this.o;
        if (r16 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("panelView");
        r16 = null;
    L19:
        View r17 = this.o;
        if (r17 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("panelView");
        r17 = null;
    L22:
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        r18.height = r14;
        r16.setLayoutParams(r18);
        View r19 = this.n;
        if (r19 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("sheetView");
        r19 = null;
    L25:
        View r20 = this.n;
        if (r20 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("sheetView");
        r20 = null;
    L28:
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        r21.height = r15 + r14;
        r19.setLayoutParams(r21);
        com.bytedance.ai.utils.g r22 = com.bytedance.ai.utils.g.a;
        StringBuilder r23 = new StringBuilder("updateSheetSize: rootHeight=");
        ViewGroup r24 = this.l;
        if (r24 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r24 = null;
    L31:
        r23.append(r24.getHeight());
        r23.append(", panelHeight=");
        r23.append(r14);
        r23.append(", sheetHeight=");
        CoordinatorLayout r25 = this.n;
        if (r25 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("sheetView");
    L35:
        r23.append(r10.getLayoutParams().height);
        r22.i("AppletEightScreenActivity", r23.toString());
        return true;
    L34:
        r10 = r25;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(AppletEightScreenActivity.class.getName()));
    L5:
        Job r0 = this.w;
        if (r0 == null) goto L8;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L8:
        this.w = null;
        AppCompatDialog r1 = this.v;
        if (r1 == null) goto L27;
        Handler r10 = DialogLancet.resolveDialogHandler(r1);
        if (r10 != null) goto L13;
    L15:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L18 Exception -> L20
    L24:
        DialogLancet.afterDialogDismiss(r1);
        goto L27
    L20:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L18
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L18
        if (r11 == null) goto L24;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L13:
        if (Looper.myLooper() == r10.getLooper()) goto L15;
        r10.post(DialogLancet.createDismissRunnable(r1));
    L27:
        this.v = null;
        AppletDragHandleBottomSheetBehavior r12 = this.u;
        if (r12 == null) goto L30;
        b r13 = this.B;
        r12.M.remove(r13);
    L30:
        AppletAppActionBar r14 = this.t;
        if (r14 == null) goto L34;
        r14.a = null;
        r14.b = null;
    L34:
        if (this.z == false) goto L36;
        getWindow().setBackgroundBlurRadius(0);
        this.z = false;
    L36:
        super.onDestroy();
        List r15 = CollectionsKt.toList(this.A);
        ((ArrayList) this.A).clear();
        Iterator r16 = r15.iterator();
    L38:
        if (r16.hasNext() == false) goto L40;
        ((Function0) r16.next()).invoke();
        goto L38
    }

    public AppletEightScreenActivity() {
        this.k = AppletShowMode.EIGHT_SCREEN;
        this.A = new ArrayList();
        this.B = new b(this);
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final Rect K1() {
        Resources r0 = getResources();
        int r1 = WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).widthPixels - n2.a.a(12);
        return new Rect((int) n2.a.c(Integer.valueOf(r1 - n2.a.a(84))), 18, (int) n2.a.c(Integer.valueOf(r1)), 54);
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void Y1() {
        setContentView(2131558446);
        this.l = findViewById(2131363162);
        this.m = findViewById(2131363163);
        this.n = findViewById(2131363164);
        this.o = findViewById(2131363161);
        View r0 = findViewById(2131363156);
        this.p = findViewById(2131363160);
        this.q = findViewById(2131363159);
        this.r = findViewById(2131363154);
        this.s = (TextView) findViewById(2131363155);
        this.t = (AppletAppActionBar) findViewById(2131363132);
        View r1 = this.n;
        ViewGroup r10 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("sheetView");
        r1 = null;
    L5:
        CoordinatorLayout.LayoutParams r11 = r1.getLayoutParams();
        boolean r12 = r11 instanceof CoordinatorLayout.LayoutParams;
        CoordinatorLayout.Behavior r13 = r11.getBehavior();
        boolean r14 = r13 instanceof BottomSheetBehavior;
        BottomSheetBehavior r15 = (BottomSheetBehavior) r13;
        Intrinsics.checkNotNull(r15, "null cannot be cast to non-null type com.bytedance.ai.applet.app.view.AppletDragHandleBottomSheetBehavior");
        AppletDragHandleBottomSheetBehavior r16 = (AppletDragHandleBottomSheetBehavior) r15;
        r16.setPeekHeight(0);
        r16.setFitToContents(true);
        r16.s = true;
        r16.setHideable(true);
        r16.r = true;
        r16.A = com.bytedance.ai.view.popup.o.d;
        if (r0 == null) goto L8;
        WeakReference<View> r17 = new WeakReference(r0);
    L9:
        r16.W = r17;
        r16.b(4, false);
        b r18 = this.B;
        if (r16.M.contains(r18) == true) goto L12;
        r16.M.add(r18);
    L12:
        this.u = r16;
        AppletApplication r19 = this.e;
        if (r19 != null) goto L15;
        com.bytedance.ai.utils.g.a.e("AppletEightScreenActivity", "bindAppletIdentity: application is null");
    L22:
        AppletAppActionBar r20 = this.t;
        if (r20 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
        r20 = null;
    L25:
        r20.setOnOpenListener(new AppletEightScreenActivity$setupHostContent$2(this));
        AppletAppActionBar r21 = this.t;
        if (r21 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
        r21 = null;
    L28:
        r21.setOnCloseListener(new j(this));
        AppletApplication r22 = this.e;
        if (r22 == null) goto L36;
        Applet r23 = r22.j();
        if (r23 == null) goto L36;
        AppletAppActionBar r24 = this.t;
        if (r24 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("actionBarView");
        r24 = null;
    L35:
        r24.setApplet(r23);
    L36:
        View r25 = this.m;
        if (r25 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("scrimView");
        r25 = null;
    L39:
        r25.setOnClickListener(new k(this));
        ViewGroup r26 = this.l;
        if (r26 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L43:
        r10.post(new m(this));
        return;
    L42:
        r10 = r26;
        goto L43
    L15:
        DraweeView r27 = this.r;
        if (r27 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("appIconView");
        r27 = null;
    L18:
        r27.getHierarchy().setPlaceholderImage(2131235790);
        DraweeView r28 = this.r;
        if (r28 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("appIconView");
        r28 = null;
    L21:
        r28.getHierarchy().setFailureImage(2131235790);
        g2(r19.j().a, r19.j().b());
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AppletEightScreenActivity$bindAppletIdentity$1(this, r19, null), 3, null);
        goto L22
    L8:
        r17 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e2() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void onStop() {
        super.onStop();
        if (isFinishing() == true) goto L70;
        if (isDestroyed() == true) goto L70;
        if (this.y == true) goto L70;
        if (isChangingConfigurations() == true) goto L70;
        boolean r1 = false;
        Activity r10 = null;
        if (Build.VERSION.SDK_INT < 23) goto L29;
        Object r0 = getSystemService(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<T> r11 = ((ActivityManager) r0).getAppTasks().iterator();
    L16:
        if (r11.hasNext() == false) goto L23;
        Object r12 = r11.next();
        if (((ActivityManager.AppTask) r12).getTaskInfo().id != getTaskId()) goto L20;
        boolean r13 = true;
    L21:
        if (r13 == false) goto L16;
    L24:
        ActivityManager.AppTask r14 = (ActivityManager.AppTask) r12;
        if (r14 == null) goto L29;
        ActivityManager.RecentTaskInfo r15 = r14.getTaskInfo();
        if (r15 == null) goto L29;
        ComponentName r16 = r15.topActivity;
    L30:
        if (r16 == null) goto L70;
        if (Intrinsics.areEqual(r16, getComponentName()) == true) goto L70;
        z4.a r17 = z4.a.a;
        monitor-enter(r17);
        LinkedList<Activity> r18 = z4.a.b;     // Catch: Throwable -> L66
        Activity[] r19 = (Activity[]) r18.toArray(new Activity[r18.size()]);     // Catch: Throwable -> L66
        monitor-exit(r17);
        int r20 = r19.length - 1;
        if (r20 < 0) goto L56;
    L41:
        int r21 = r20 - 1;
        Activity r22 = r19[r20];
        if (r22.getTaskId() == getTaskId()) goto L44;
    L50:
        boolean r23 = false;
    L51:
        if (r23 == true) goto L52;
        if (r21 < 0) goto L56;
        r20 = r21;
        goto L41
    L52:
        r10 = r22;
        goto L56
    L44:
        if (Intrinsics.areEqual(r22.getComponentName(), r16) == false) goto L50;
        if (r22.isFinishing() == true) goto L50;
        if (r22.isDestroyed() == true) goto L50;
        r23 = true;
    L56:
        if (r10 != null) goto L58;
        com.bytedance.ai.utils.g.a.w("AppletEightScreenActivity", "Keep eight-screen because task top instance was not found: taskTop=" + r16.getClassName() + ", taskId=" + getTaskId());
        goto L70
    L58:
        AppletRuntimeManager.INSTANCE.getClass();
        g2.b r24 = AppletRuntimeManager.d;
        if (r24 != null) goto L61;
    L63:
        com.bytedance.ai.utils.g.a.i("AppletEightScreenActivity", "Check task top after eight-screen stopped: taskTop=" + r10.getClass().getSimpleName() + ", isBaseHost=" + r1);
        if (r1 == false) goto L70;
        e2();
        goto L70
    L61:
        if (r24.x(r10) != true) goto L63;
        r1 = true;
    L66:
        th = move-exception;
        throw th;
    L20:
        r13 = false;
        goto L21
    L23:
        r12 = null;
    L29:
        r16 = null;
    L70:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L90;
        View r25 = getWindow().getDecorView();     // Catch: Throwable -> L78
        if (com.larus.home.impl.utils.c.e == false) goto L76;
        FLogger.a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L78
        Thread r26 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L78
        if (r26 == com.larus.home.impl.utils.c.a) goto L76;
        com.larus.home.impl.utils.c.a(r26, "getDecorView");     // Catch: Throwable -> L78
    L76:
        r25.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L78
        return;
    L91:
        return;
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final AppletShowMode L1() {
        return this.k;
    }

    @Override // com.bytedance.ai.applet.app.AppletAppActivity
    public final void S1(t r10) {
        Intrinsics.checkNotNullParameter(r10, "state");
        View r0 = this.p;
        if (r0 != null) goto L6;
        com.bytedance.ai.utils.g.a.w("AppletEightScreenActivity", "Skip page state update because views are not initialized");
        return;
    L6:
        int r11 = 0;
        if ((r10 instanceof t.a) == false) goto L9;
        int r12 = 8;
    L10:
        r0.setVisibility(r12);
        View r1 = this.q;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pageErrorView");
        r1 = null;
    L14:
        if ((r10 instanceof t.b) == true) goto L17;
        r11 = 8;
    L17:
        r1.setVisibility(r11);
        com.bytedance.ai.utils.g.a.i("AppletEightScreenActivity", "page content state changed: ".concat(r10.getClass().getSimpleName()));
        return;
    L9:
        r12 = 0;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d2(Function0<Unit> r10) {
        if (isDestroyed() == false) goto L7;
        if (r10 == null) goto L31;
        r10.invoke();
        return;
    L31:
        return;
    L7:
        if (r10 == null) goto L10;
        ((ArrayList) this.A).add(r10);
    L10:
        if (this.y == false) goto L12;
        return;
    L12:
        this.y = true;
        View r0 = this.m;
        AppletDragHandleBottomSheetBehavior r1 = null;
        if (r0 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("scrimView");
        r0 = null;
    L15:
        r0.setClickable(false);
        com.bytedance.ai.utils.g r11 = com.bytedance.ai.utils.g.a;
        StringBuilder r12 = new StringBuilder("dismissWithAnimation: state=");
        AppletDragHandleBottomSheetBehavior r13 = this.u;
        if (r13 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r13 = null;
    L18:
        r12.append(r13.D);
        r11.i("AppletEightScreenActivity", r12.toString());
        AppletDragHandleBottomSheetBehavior r14 = this.u;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
        r14 = null;
    L22:
        if (r14.D != 4) goto L25;
        e2();
        return;
    L25:
        AppletDragHandleBottomSheetBehavior r15 = this.u;
        if (r15 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetBehavior");
    L29:
        r1.b(4, true);
        return;
    L28:
        r1 = r15;
        goto L29
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void onConfigurationChanged(Configuration r10) {
        Intrinsics.checkNotNullParameter(r10, "newConfig");
        super.onConfigurationChanged(r10);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L14
        if (dc9.d.a() == true) goto L16;
        int r1 = getRequestedOrientation();     // Catch: Throwable -> L14
        Integer r11 = Integer.valueOf(r10.orientation);     // Catch: Throwable -> L14
        if (r11 != null) goto L9;
    L11:
        if (r1 != 3) goto L16;
        setRequestedOrientation(1);     // Catch: Throwable -> L14
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:AppletEightScreenActivity portrait");     // Catch: Throwable -> L14
        goto L16
    L9:
        if (r11.intValue() != r1) goto L11;
    L16:
        CoordinatorLayout r12 = this.l;
        if (r12 != null) goto L19;
    L23:
        com.bytedance.ai.utils.g.a.w("AppletEightScreenActivity", "Skip configuration update because sheet views are not initialized");
        return;
    L19:
        if (this.n == null) goto L23;
        r12.post(new i(this));
        return;
    L14:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ai.applet.app.AppletAppActivity, com.bytedance.ai.applet.app.base.BaseActivity
    public final void onCreate(Bundle r10) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r10);
        if (isFinishing() == false) goto L13;
        com.bytedance.ai.utils.g.a.w("AppletEightScreenActivity", "Skip window setup because applet host creation failed");
        return;
    L13:
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 31) goto L16;
        int r12 = n2.a.a(12);
        getWindow().setBackgroundBlurRadius(r12);
        this.z = true;
        com.bytedance.ai.utils.g.a.i("AppletEightScreenActivity", "Window blur enabled, radius=" + r12);
    L17:
        overridePendingTransition(0, 0);
        return;
    L16:
        com.bytedance.ai.utils.g.a.w("AppletEightScreenActivity", "Window blur requires API 31+, fallback to scrim only, sdk=" + r11);
        goto L17
    }

    public static final List c2(AppletEightScreenActivity r10, AppletApplication r11) {
        r10.getClass();
        Collection<com.bytedance.ai.applet.app.view.m> r12 = r11.n.b.values();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L14;
        Object r0 = r14.next();
        int r1 = ((com.bytedance.ai.applet.app.view.m) r0).a;
        if (r1 != 3) goto L8;
    L11:
        boolean r15 = true;
    L12:
        if (r15 == true) goto L4;
        r13.add(r0);
        goto L4
    L8:
        if (r1 == 6) goto L11;
        r15 = false;
        goto L12
    L14:
        return r13;
    }

    public final void g2(String r10, String r11) {
        TextView r0 = this.s;
        SimpleDraweeView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("appNameView");
        r0 = null;
    L5:
        r0.setText(r10);
        if (r11 != null) goto L8;
    L11:
        boolean r12 = true;
    L13:
        if (r12 == false) goto L19;
        SimpleDraweeView r13 = this.r;
        if (r13 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("appIconView");
    L18:
        r1.setActualImageResource(2131235790);
        return;
    L17:
        r1 = r13;
        goto L18
    L19:
        SimpleDraweeView r14 = this.r;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("appIconView");
    L23:
        r1.setImageURI(r11);
        return;
    L22:
        r1 = r14;
        goto L23
    L8:
        if (StringsKt.isBlank(r11) == true) goto L11;
        r12 = false;
        goto L13
    }
}
