package com.suite.lark.platform.feature.forward.doubao;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larksuite.framework.utils.KeyboardUtils;
import com.larksuite.framework.utils.UIUtils;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.base.activity.ActivityAnimationManager;
import com.ss.android.lark.base.fragment.BaseFragmentActivity;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.forwardv3.configuration.ForwardTemplateNew;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u0011H\u0002J\u0012\u0010%\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0003J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020*H\u0002J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\u0014\u0010-\u001a\u00020\u001e2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/J\u0006\u00101\u001a\u00020\u001eJ\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u000203H\u0016J\b\u00105\u001a\u00020\u001eH\u0016J8\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\u000e\b\u0002\u00109\u001a\b\u0012\u0004\u0012\u00020\u001e0:2\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001e0:H\u0002J\b\u0010<\u001a\u00020\u001eH\u0002JX\u0010=\u001a\u00020\u00072\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?0/2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2%\b\u0002\u0010A\u001a\u001f\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u001e\u0018\u00010B2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010C¢\u0006\u0002\u0010HJZ\u0010I\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020C2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2\u0006\u0010K\u001a\u00020C2%\b\u0002\u0010A\u001a\u001f\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u001e\u0018\u00010B2\b\b\u0002\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010MJh\u0010N\u001a\u00020\u001e2\u0006\u0010J\u001a\u00020C2\b\u0010O\u001a\u0004\u0018\u00010P2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010C2%\b\u0002\u0010A\u001a\u001f\u0012\u0013\u0012\u00110C¢\u0006\f\bD\u0012\b\bE\u0012\u0004\b\b(F\u0012\u0004\u0012\u00020\u001e\u0018\u00010B2\b\b\u0002\u0010L\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010QR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/ForwardDoubaoActivity;", "Lcom/ss/android/lark/base/fragment/BaseFragmentActivity;", "<init>", "()V", "mFragment", "Lcom/suite/lark/platform/feature/forward/doubao/DoubaoForwardFragment;", "isFinishingAnim", "", "hasShownSheet", "velocityTracker", "Landroid/view/VelocityTracker;", "downRawY", "", "downTranslationY", "isDragHandleTouched", "hasDraggedSheetDown", "touchSlop", "", "dragStartThresholdPx", "dragDismissMinDistancePx", "dismissTranslationY", "bgMask", "Landroid/view/View;", "bottomSheetContainer", "dragHandleHeightPx", "dragHeaderHeightPx", "dragButtonSafeInsetPx", "isShowingSendToBanner", "confirmModeActive", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "ensureTransparentActivityBackground", "initBottomSheetLayout", "applySheetHeight", "pickerSheetHeightPx", "dropRestoredConfirmFragmentIfNeeded", "initEnterAnimation", "initDragToDismiss", "isInDragHandleArea", "event", "Landroid/view/MotionEvent;", "initDismissBehavior", "handleBackOrFinish", "openConfirmFragment", "items", "", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "closeFromPicker", "getEnterAnimationConfig", "Lcom/ss/android/lark/base/activity/ActivityAnimationManager$AnimationConfig;", "getExitAnimationConfig", "finish", "animateTo", "translationY", "maskAlpha", "endAction", "Lkotlin/Function0;", "cancelAction", "superFinishNoAnim", "showSendToBannerAndDismissSheet", "targets", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "bottomOffsetDp", "onOpenChat", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "chatId", "sourceChatId", "(Ljava/util/List;Ljava/lang/Float;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)Z", "loadDoubaoForwardDrawable", "bannerText", "chatIdForJump", "enableJump", "(Ljava/lang/String;Ljava/lang/Float;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Z)V", "showFlowToast", "drawable", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/Float;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Z)V", "Companion", "forward-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardDoubaoActivity extends BaseFragmentActivity {
    public static final /* synthetic */ int p = 0;
    public DoubaoForwardFragment a;
    public boolean b;
    public VelocityTracker c;
    public float d;
    public float e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public float j;
    public View k;
    public View l;
    public int m;
    public int n;
    public boolean o;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ Function0<Unit> b;
        public final /* synthetic */ Function0<Unit> c;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a = true;
            this.b.invoke();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            if (this.a == true) goto L6;
            this.c.invoke();
            return;
        }

        public b(Function0<Unit> r1, Function0<Unit> r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    public static final class c implements FlowToast.c {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Function1<String, Unit> c;

        public final void a(com.ss.android.lark.compose.foundation.toast.b r3) {
            Intrinsics.checkNotNullParameter(r3, "toast");
            if (this.a == false) goto L11;
            String r0 = this.b;
            if (r0 != null) goto L7;
            return;
        L7:
            Function1<String, Unit> r1 = this.c;
            if (r1 == null) goto L11;
            r1.invoke(r0);
        L11:
            if (r3.isShowing() == false) goto L14;
            r3.cancel();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(boolean r1, String r2, Function1<? super String, Unit> r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class d implements FlowToast.d {
        public final /* synthetic */ ForwardDoubaoActivity a;

        public final void a() {
            this.a.finish();
        }

        public d(ForwardDoubaoActivity r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final void B1() {
        if (this.o == false) goto L5;
        int r0 = -2;
    L6:
        View r1 = this.l;
        Integer r3 = null;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r1 = null;
    L9:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L12;
        FrameLayout.LayoutParams r4 = (FrameLayout.LayoutParams) r2;
    L13:
        r2.height = r0;
        boolean r5 = false;
        if (r4 == null) goto L16;
        r4.topMargin = 0;
        r4.gravity = 80;
    L16:
        View r6 = this.l;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r6 = null;
    L19:
        r6.setLayoutParams(r2);
        if (this.o == false) goto L32;
        View r7 = this.l;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r7 = null;
    L24:
        Integer r8 = Integer.valueOf(r7.getMeasuredHeight());
        if (r8.intValue() <= 0) goto L27;
        r5 = true;
    L27:
        if (r5 == false) goto L29;
        r3 = r8;
    L29:
        if (r3 == null) goto L31;
        int r9 = r3.intValue();
    L33:
        this.j = r9;
        return;
    L31:
        r9 = C1();
        goto L33
    L32:
        r9 = C1();
        goto L33
    L12:
        r4 = null;
        goto L13
    L5:
        r0 = C1();
        goto L6
    }

    /* JADX INFO: Removed unreachable split cross block B:60:0x0127 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        if (this.l != null) goto L5;
        super.finish();
    L10:
        if ((this instanceof ChatWindowActivity) == true) goto L51;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(ForwardDoubaoActivity.class.getName()));
        long r3 = SystemClock.uptimeMillis();
        Map r5 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r5);
        Long r6 = (Long) r5.get(this);     // Catch: Throwable -> L52
        if (r6 != null) goto L17;
    L20:
        r5.put(this, Long.valueOf(r3));     // Catch: Throwable -> L52
        monitor-exit(r5);     // Catch: Throwable -> L52
    L49:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L57:
        return;
    L23:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L26;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L49
        goto L57
    L26:
        if (isFinishing() == true) goto L29;
        r2.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L49
        goto L57
    L29:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L32;
        r2.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L49
        goto L57
    L32:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L35;
        r2.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L49
        goto L57
    L35:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L38;
        r2.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L49
        goto L57
    L38:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L40;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L49
        goto L57
    L40:
        Intent r1 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L49
        if (r1 == null) goto L57;
        r1.addFlags(268435456);     // Catch: Throwable -> L49
        r1.addFlags(2097152);     // Catch: Throwable -> L49
        r2.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L49
        startActivity(r1);     // Catch: Throwable -> L46
        overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L46
    L46:
        th = move-exception;
        FLogger.a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L49
        goto L57
    L17:
        if ((r3 - r6.longValue()) >= 800) goto L20;
        monitor-exit(r5);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        throw th;
    L51:
        return;
    L5:
        KeyboardUtils.hideKeyboard(this);
        if (this.b == false) goto L8;
        F1();
        goto L10
    L8:
        this.b = true;
        z1(this.j, 0.0f, new AnonymousClass1(this), new AnonymousClass2(this));
        goto L10
    }

    public final ActivityAnimationManager.AnimationConfig getEnterAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    public final ActivityAnimationManager.AnimationConfig getExitAnimationConfig() {
        return new ActivityAnimationManager.AnimationConfig(0, 0);
    }

    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(ForwardDoubaoActivity.class.getName()));
    L5:
        super.onDestroy();
    }

    public final int C1() {
        int r0 = UIHelper.dp2px(785.0f);
        View r1 = findViewById(R.id.content);
        if (r1 == null) goto L5;
        int r2 = r1.getHeight();
    L6:
        Integer r3 = Integer.valueOf(r2);
        if (r3.intValue() <= 0) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L15;
        int r5 = r3.intValue();
    L17:
        return RangesKt.coerceAtMost(r0, RangesKt.coerceAtLeast(r5 - UIHelper.dp2px(getIntent().getFloatExtra("extra_top_spacing_dp", 50.0f)), 0));
    L15:
        Resources r6 = getResources();
        r5 = WindowDisplayMetricsOverride.apply(r6, r6.getDisplayMetrics()).heightPixels;
        goto L17
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void F1() {
        KeyboardUtils.hideKeyboard(this);
        super.finish();
        overridePendingTransition(0, 0);
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

    public ForwardDoubaoActivity() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r7) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r7);
        Intent r0 = getIntent();
        if (r0 == null) goto L13;
        Bundle r1 = r0.getExtras();
    L14:
        if (r1 == null) goto L16;
        ForwardTemplateNew r2 = (ForwardTemplateNew) r1.getParcelable("key_intent_forward_template_new");
    L17:
        if (r2 != null) goto L19;
        Log.e("ForwardDoubaoActivity", "ForwardTemplateNew is null, finish");
        finish();
        return;
    L19:
        setContentView(2131558482);
        UIUtils.setStatusBarTransparent(this);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        getWindow().clearFlags(2);
        View r3 = findViewById(R.id.content);
        if (r3 == null) goto L22;
        r3.setBackgroundResource(R.color.transparent);
    L22:
        View r4 = findViewById(2131373235);
        if (r4 == null) goto L25;
        r4.setBackgroundResource(R.color.transparent);
    L25:
        this.k = findViewById(2131364145);
        this.l = findViewById(2131364514);
        this.m = UIHelper.dp2px(18.0f) + UIHelper.dp2px(44.0f);
        this.n = UIHelper.dp2px(72.0f);
        this.h = Math.max(ViewConfiguration.get(this).getScaledTouchSlop(), UIHelper.dp2px(12.0f));
        this.i = UIHelper.dp2px(72.0f);
        if (r7 == null) goto L34;
        Fragment r8 = getSupportFragmentManager().findFragmentByTag("DoubaoForwardConfirmFragment");
        if (r8 == null) goto L34;
        getSupportFragmentManager().popBackStackImmediate("DoubaoForwardConfirmFragment", 1);
        if (r8.isAdded() == false) goto L34;
        getSupportFragmentManager().beginTransaction().remove(r8).commitNowAllowingStateLoss();
    L34:
        List r9 = getSupportFragmentManager().getFragments();
        ArrayList r5 = new ArrayList();
        Iterator r10 = r9.iterator();
    L36:
        if (r10.hasNext() == false) goto L40;
        Object r6 = r10.next();
        if ((r6 instanceof DoubaoForwardFragment) == false) goto L36;
        r5.add(r6);
        goto L36
    L40:
        this.a = (DoubaoForwardFragment) CollectionsKt.firstOrNull(r5);
        this.o = false;
        getWindow().setSoftInputMode(48);
        View r11 = this.k;
        if (r11 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
        r11 = null;
    L43:
        r11.setAlpha(0.0f);
        View r12 = this.l;
        if (r12 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r12 = null;
    L46:
        r12.setClickable(true);
        View r13 = this.l;
        if (r13 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r13 = null;
    L49:
        r13.setFocusable(true);
        B1();
        View r14 = this.l;
        if (r14 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r14 = null;
    L52:
        r14.setTranslationY(this.j);
        View r15 = this.l;
        if (r15 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r15 = null;
    L55:
        r15.addOnLayoutChangeListener(new y(this));
        View r16 = this.l;
        if (r16 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r16 = null;
    L58:
        r16.setOnTouchListener(new a0(this));
        View r17 = this.l;
        if (r17 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r17 = null;
    L61:
        r17.post(new b0(this));
        View r18 = this.k;
        if (r18 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
        r18 = null;
    L64:
        r18.setOnClickListener(new z(this));
        getOnBackPressedDispatcher().addCallback(this, new ForwardDoubaoActivity$initDismissBehavior$2(this));
        if (this.a != null) goto L84;
        DoubaoForwardFragment r19 = new DoubaoForwardFragment();
        if (r1 == null) goto L69;
        Bundle r20 = new Bundle(r1);
    L70:
        r19.setArguments(r20);
        this.a = r19;
        FragmentTransaction r21 = getSupportFragmentManager().beginTransaction();
        DoubaoForwardFragment r22 = this.a;
        Intrinsics.checkNotNull(r22);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r21, r22, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, 2131373275) == true) goto L74;
        r21 = r21.replace(2131373275, r22);
    L74:
        r21.commitAllowingStateLoss();
        return;
    L69:
        r20 = null;
        goto L70
    L84:
        return;
    L16:
        r2 = null;
        goto L17
    L13:
        r1 = null;
        goto L14
    }

    public final void z1(float r5, float r6, Function0<Unit> r7, Function0<Unit> r8) {
        View r0 = this.l;
        View r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");
        r0 = null;
    L5:
        ViewPropertyAnimator r9 = r0.animate().translationY(r5).setDuration(300);
        r9.setListener(new b(r8, r7));
        r9.start();
        View r10 = this.k;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("bgMask");
    L9:
        r1.animate().alpha(r6).setDuration(300).start();
        return;
    L8:
        r1 = r10;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void A1(ForwardDoubaoActivity r1, float r2, float r3, Function0 r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r4 = ForwardDoubaoActivity$animateTo$1.INSTANCE;
    L6:
        if ((r5 & 8) == 0) goto L8;
        ForwardDoubaoActivity$animateTo$2 r6 = ForwardDoubaoActivity$animateTo$2.INSTANCE;
    L9:
        r1.z1(r2, r3, r4, r6);
        return;
    L8:
        r6 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1(String r3, Drawable r4, Float r5, String r6, Function1<? super String, Unit> r7, boolean r8) {
        FlowToast.a r0 = FlowToast.a(this);
        Intrinsics.checkNotNullParameter(r3, "value");
        r0.b = r3;
        if (r5 == null) goto L5;
        float r9 = r5.floatValue();
    L6:
        r0.c(0, 0, UIHelper.dp2px(r9));
        d r10 = new d(this);
        Intrinsics.checkNotNullParameter(r10, "dismiss");
        r0.g = r10;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNullParameter(r4, "value");
        r0.c = r4;
    L9:
        if (r6 == null) goto L11;
        r0.b(2131890162, new c(r8, r6, r7));
    L11:
        r0.a().show();
        return;
    L5:
        r9 = 100.0f;
        goto L6
    }
}
