package com.obric.assistant.authenticationsession;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AuthenticationType;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.IKeyguardState;
import com.obric.assistant.interaction.api.OnKeyguardLockStateChangedListener;
import com.obric.assistant.interaction.base.interact.IObserveToken;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0002GL\u0018\u0000 ]2\u00020\u00012\u00020\u0002:\u0001]B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\b\u0010?\u001a\u00020@H\u0014J\b\u0010A\u001a\u00020@H\u0014J\b\u0010B\u001a\u00020@H\u0002J\b\u0010C\u001a\u00020@H\u0002J\b\u0010N\u001a\u00020@H\u0002J\u0018\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u0002062\u0006\u0010Q\u001a\u000202H\u0002J\b\u0010R\u001a\u00020@H\u0002J\"\u0010S\u001a\u00020@2\u0006\u0010T\u001a\u0002022\u0006\u0010U\u001a\u0002022\b\b\u0002\u0010V\u001a\u000202H\u0002J \u0010W\u001a\u00020;2\u0006\u0010X\u001a\u00020\u001d2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010[\u001a\u00020ZH\u0002J\f\u0010\\\u001a\u000202*\u000206H\u0002R\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u001c\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\u001f\u0010 R#\u0010\"\u001a\n \u001e*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b$\u0010%R#\u0010'\u001a\n \u001e*\u0004\u0018\u00010\u001d0\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b(\u0010 R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0012\u001a\u0004\b,\u0010-R\u000e\u0010/\u001a\u000200X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00107\u001a\u0002062\u0006\u00105\u001a\u000206@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020@0EX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u00020G8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010\u0012\u001a\u0004\bH\u0010IR\u0010\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0004\n\u0002\u0010M¨\u0006^"}, d2 = {"Lcom/obric/assistant/authenticationsession/SessionAuthenticationStateView;", "Landroid/widget/RelativeLayout;", "Lcom/obric/assistant/interaction/base/interact/IObserveToken;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", NameKeys.UnloadStrategy_No_Strategy, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "keyguardState", "Lcom/obric/assistant/interaction/api/IKeyguardState;", "getKeyguardState", "()Lcom/obric/assistant/interaction/api/IKeyguardState;", "keyguardState$delegate", "Lkotlin/Lazy;", "sessionAuthenticationService", "Lcom/obric/assistant/ISessionAuthenticationService;", "getSessionAuthenticationService", "()Lcom/obric/assistant/ISessionAuthenticationService;", "sessionAuthenticationService$delegate", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "delayHideTextJob", "Lkotlinx/coroutines/Job;", "iconView", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getIconView", "()Landroid/view/View;", "iconView$delegate", "animView", "Lcom/airbnb/lottie/LottieAnimationView;", "getAnimView", "()Lcom/airbnb/lottie/LottieAnimationView;", "animView$delegate", "blockClickLayout", "getBlockClickLayout", "blockClickLayout$delegate", "emptyClickListener", "Landroid/view/View$OnClickListener;", "getEmptyClickListener", "()Landroid/view/View$OnClickListener;", "emptyClickListener$delegate", "windowState", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "isKeyguardLockedState", NameKeys.UnloadStrategy_No_Strategy, "isFullAnimationPlaying", "hasShowFullAnimation", "value", "Lcom/obric/assistant/AuthenticationType;", "showAuthType", "setShowAuthType", "(Lcom/obric/assistant/AuthenticationType;)V", "transitionAnimator", "Landroid/animation/Animator;", "monitorAuthJob", "resetFullAnimationStateRunnable", "Ljava/lang/Runnable;", "onAttachedToWindow", NameKeys.UnloadStrategy_No_Strategy, "onDetachedFromWindow", "registerListener", "unregisterListener", "chatWindowStateCallback", "Lkotlin/Function1;", "onKeyguardLockStateChangedListener", "com/obric/assistant/authenticationsession/SessionAuthenticationStateView$onKeyguardLockStateChangedListener$2$1", "getOnKeyguardLockStateChangedListener", "()Lcom/obric/assistant/authenticationsession/SessionAuthenticationStateView$onKeyguardLockStateChangedListener$2$1;", "onKeyguardLockStateChangedListener$delegate", "appBackGroundListener", "com/obric/assistant/authenticationsession/SessionAuthenticationStateView$appBackGroundListener$1", "Lcom/obric/assistant/authenticationsession/SessionAuthenticationStateView$appBackGroundListener$1;", "computeAuthenticationUIState", "changeToShow", "authType", "withFullAnimation", "changeToHide", "setAnimViewVisibility", "isVisible", "withAnimation", "delayHide", "animatorViewAlpha", "targetView", "fromAlpha", NameKeys.UnloadStrategy_No_Strategy, "toAlpha", "isSystemAuthentication", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SessionAuthenticationStateView extends RelativeLayout implements IObserveToken {
    public static final /* synthetic */ int t = 0;
    public final Lazy a;
    public final Lazy b;
    public final CoroutineScope c;
    public volatile Job d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public volatile AssistantActivityExpandState i;
    public volatile boolean j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile AuthenticationType m;
    public Animator n;
    public Job o;
    public final Runnable p;
    public final Function1<AssistantActivityExpandState, Unit> q;
    public final Lazy r;
    public final d s;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ SessionAuthenticationStateView a;

        public a(SessionAuthenticationStateView r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animator");
            FLogger.a.i("SessionAuthenticationStateView", "onAnimationCancel");
            this.a.k = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animator");
            FLogger.a.i("SessionAuthenticationStateView", "onAnimationEnd");
            if (this.a.k == false) goto L5;
            this.a.l = true;
            this.a.k = false;
        L5:
            this.a.i(false, true, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animator");
            FLogger.a.i("SessionAuthenticationStateView", "onAnimationRepeat");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animator");
            FLogger.a.i("SessionAuthenticationStateView", "onAnimationStart");
        }
    }

    public static final class b {
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AuthenticationType.values().length];
            r0[AuthenticationType.Biometric.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[AuthenticationType.UnLocked.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[AuthenticationType.VoicePrint.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class d implements gd9.b {
        public final /* synthetic */ SessionAuthenticationStateView a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
            FLogger.a.i("SessionAuthenticationStateView", "onAppBackground");
            Handler r0 = t0.a;
            r0.removeCallbacks(this.a.p);
            r0.postDelayed(this.a.p, 600);
        }

        public final void onAppForeground() {
            FLogger.a.i("SessionAuthenticationStateView", "onAppForeground");
            t0.a.removeCallbacks(this.a.p);
            this.a.h();
        }

        public d(SessionAuthenticationStateView r1) {
            this.a = r1;
        }
    }

    public static final class e implements OnKeyguardLockStateChangedListener {
        public final /* synthetic */ SessionAuthenticationStateView a;

        public e(SessionAuthenticationStateView r1) {
            this.a = r1;
        }

        public final void onKeyguardLockStateChanged(boolean r2) {
            this.a.j = r2;
            this.a.h();
        }
    }

    static {
    }

    private final LottieAnimationView getAnimView() {
        return (LottieAnimationView) this.f.getValue();
    }

    private final View getBlockClickLayout() {
        return (View) this.g.getValue();
    }

    private final View.OnClickListener getEmptyClickListener() {
        return (View.OnClickListener) this.h.getValue();
    }

    private final View getIconView() {
        return (View) this.e.getValue();
    }

    private final IKeyguardState getKeyguardState() {
        return (IKeyguardState) this.a.getValue();
    }

    private final e getOnKeyguardLockStateChangedListener() {
        return (e) this.r.getValue();
    }

    private final ISessionAuthenticationService getSessionAuthenticationService() {
        return (ISessionAuthenticationService) this.b.getValue();
    }

    public final void f() {
        FLogger.a.i("SessionAuthenticationStateView", "changeToHide");
        Job r0 = this.d;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        BuildersKt.launch$default(this.c, null, null, new SessionAuthenticationStateView$changeToHide$1(this, null), 3, null);
    }

    public final void h() {
        ISessionAuthenticationService r0 = getSessionAuthenticationService();
        boolean r1 = true;
        if (r0 == null) goto L9;
        i1 r2 = r0.o();
        if (r2 == null) goto L9;
        if (((Boolean) r2.getValue()).booleanValue() != true) goto L9;
        boolean r3 = true;
    L10:
        ISessionAuthenticationService r4 = getSessionAuthenticationService();
        if (r4 == null) goto L17;
        i1 r5 = r4.k();
        if (r5 == null) goto L17;
        if (((Boolean) r5.getValue()).booleanValue() != true) goto L17;
        boolean r6 = true;
    L19:
        if (this.j == false) goto L35;
        IKeyguardState r7 = getKeyguardState();
        if (r7 != null) goto L23;
    L25:
        boolean r8 = false;
    L26:
        if (r8 == false) goto L35;
        IKeyguardState r9 = getKeyguardState();
        if (r9 != null) goto L30;
    L32:
        boolean r10 = false;
    L33:
        if (r10 == false) goto L35;
    L36:
        FLogger.a.i("SessionAuthenticationStateView", "computeAuthenticationUIState: windowState = " + this.i + ", isKeyguardLockedState = " + this.j + ", isBiometricPass = " + r3 + ", isVoicePrintPass = " + r6 + ", isDeviceAuthenticatedOnKeyguard = " + r1);
        if (this.i == AssistantActivityExpandState.HALF_WINDOW) goto L39;
    L47:
        AuthenticationType r11 = AuthenticationType.INVALID;
    L48:
        setShowAuthType(r11);
        return;
    L39:
        if (this.j == false) goto L47;
        if (r3 == false) goto L42;
        r11 = AuthenticationType.Biometric;
        goto L48
    L42:
        if (r1 == false) goto L44;
        r11 = AuthenticationType.UnLocked;
        goto L48
    L44:
        if (r6 == false) goto L46;
        r11 = AuthenticationType.VoicePrint;
        goto L48
    L46:
        r11 = AuthenticationType.INVALID;
        goto L48
    L30:
        if (r9.isDeviceSecure() != true) goto L32;
        r10 = true;
        goto L33
    L23:
        if (r7.isDeviceLocked() == true) goto L25;
        r8 = true;
    L35:
        r1 = false;
    L17:
        r6 = false;
    L9:
        r3 = false;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        IAssistantInteractionServiceKt.getInteractionStateService().observeInteractionActivityExpandState(this, this.q);
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        r0.a().b(this.s);
        if (Build.VERSION.SDK_INT < 33) goto L7;
        IKeyguardState r1 = getKeyguardState();
        if (r1 == null) goto L7;
        r1.registerKeyguardLockStateChangedListener(getOnKeyguardLockStateChangedListener());
    L7:
        Job r2 = this.o;
        boolean r3 = true;
        if (r2 == null) goto L10;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L10:
        this.o = BuildersKt.launch$default(this.c, null, null, new SessionAuthenticationStateView$registerListener$1(this, null), 3, null);
        this.i = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState();
        IKeyguardState r4 = getKeyguardState();
        if (r4 != null) goto L13;
    L15:
        r3 = false;
    L16:
        this.j = r3;
        h();
        getIconView().setOnClickListener(new r(this));
        return;
    L13:
        if (r4.isKeyguardLocked() != true) goto L15;
        goto L15
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IAssistantInteractionServiceKt.getInteractionStateService().unObserveInteractionActivityExpandState(this);
        gd9.i r0 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r0);
        r0.a().f(this.s);
        IKeyguardState r1 = getKeyguardState();
        if (r1 == null) goto L5;
        r1.unregisterKeyguardLockStateChangedListener(getOnKeyguardLockStateChangedListener());
    L5:
        Job r2 = this.o;
        if (r2 == null) goto L8;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L8:
        this.o = null;
        gd9.i r3 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r3);
        if (r3.a().e == false) goto L11;
        Handler r4 = t0.a;
        r4.removeCallbacks(this.p);
        r4.postDelayed(this.p, 600);
    L12:
        AuthenticationType r5 = this.m;
        AuthenticationType r6 = AuthenticationType.INVALID;
        if (r5 != r6) goto L15;
        f();
        return;
    L15:
        setShowAuthType(r6);
        return;
    L11:
        t0.a.removeCallbacks(this.p);
        goto L12
    }

    public SessionAuthenticationStateView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.a = LazyKt.lazy(new p());
        this.b = LazyKt.lazy(new v());
        this.c = CoroutineScopeKt.MainScope();
        this.e = LazyKt.lazy(new w(this));
        this.f = LazyKt.lazy(new x(this));
        this.g = LazyKt.lazy(new y(this));
        this.h = LazyKt.lazy(new z());
        this.i = AssistantActivityExpandState.NA;
        this.m = AuthenticationType.INVALID;
        this.p = new a0(this);
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(-1, -2);
        r4.addRule(12);
        r4.bottomMargin = -getContext().getResources().getDimensionPixelSize(2131166231);
        setLayoutParams(r4);
        LayoutInflater.from(getContext()).inflate(2131564050, this, true);
        e1.o(this);
        getAnimView().addAnimatorListener(new a(this));
        this.q = new b0(this);
        this.r = LazyKt.lazy(new c0(this));
        this.s = new d(this);
    }

    public static void a(SessionAuthenticationStateView r3) {
        FLogger r0 = FLogger.a;
        r0.i("SessionAuthenticationStateView", "resetFullAnimationStateRunnable run");
        gd9.i r1 = com.larus.im.b.a;
        Intrinsics.checkNotNull(r1);
        if (r1.a().e == true) goto L5;
        r0.i("SessionAuthenticationStateView", "resetFullAnimationStateRunnable skip, app is foreground");
        return;
    L5:
        r3.l = false;
        r3.k = false;
        r3.setShowAuthType(AuthenticationType.INVALID);
    }

    public static final /* synthetic */ LottieAnimationView c(SessionAuthenticationStateView r0) {
        return r0.getAnimView();
    }

    public static final /* synthetic */ ISessionAuthenticationService d(SessionAuthenticationStateView r0) {
        return r0.getSessionAuthenticationService();
    }

    private final void setShowAuthType(AuthenticationType r6) {
        AuthenticationType r0 = this.m;
        if (r0 == r6) goto L28;
        this.m = r6;
        AuthenticationType r1 = AuthenticationType.Biometric;
        boolean r2 = false;
        if (r0 != r1) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L18;
        if (r6 != r1) goto L14;
    L15:
        r2 = true;
    L16:
        if (r2 == false) goto L18;
        return;
    L14:
        if (r6 != AuthenticationType.UnLocked) goto L16;
    L18:
        int r4 = c.a[r6.ordinal()];
        if (r4 != 1) goto L21;
    L26:
        g(r6, !this.l);
        return;
    L21:
        if (r4 == 2) goto L26;
        if (r4 == 3) goto L25;
        f();
        return;
    L25:
        g(r6, !this.l);
        return;
    L7:
        if (r0 == AuthenticationType.UnLocked) goto L10;
        r3 = false;
        goto L11
    }

    public SessionAuthenticationStateView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = LazyKt.lazy(new p());
        this.b = LazyKt.lazy(new v());
        this.c = CoroutineScopeKt.MainScope();
        this.e = LazyKt.lazy(new w(this));
        this.f = LazyKt.lazy(new x(this));
        this.g = LazyKt.lazy(new y(this));
        this.h = LazyKt.lazy(new z());
        this.i = AssistantActivityExpandState.NA;
        this.m = AuthenticationType.INVALID;
        this.p = new a0(this);
        RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(-1, -2);
        r4.addRule(12);
        r4.bottomMargin = -getContext().getResources().getDimensionPixelSize(2131166231);
        setLayoutParams(r4);
        LayoutInflater.from(getContext()).inflate(2131564050, this, true);
        e1.o(this);
        getAnimView().addAnimatorListener(new a(this));
        this.q = new b0(this);
        this.r = LazyKt.lazy(new c0(this));
        this.s = new d(this);
    }

    public final void g(AuthenticationType r10, boolean r11) {
        FLogger.a.i("SessionAuthenticationStateView", "changeToShow: authType = " + r10 + ", withFullAnimation = " + r11);
        Job r0 = this.d;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        BuildersKt.launch$default(this.c, null, null, new SessionAuthenticationStateView$changeToShow$1(this, r11, r10, null), 3, null);
    }

    public SessionAuthenticationStateView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.a = LazyKt.lazy(new p());
        this.b = LazyKt.lazy(new v());
        this.c = CoroutineScopeKt.MainScope();
        this.e = LazyKt.lazy(new w(this));
        this.f = LazyKt.lazy(new x(this));
        this.g = LazyKt.lazy(new y(this));
        this.h = LazyKt.lazy(new z());
        this.i = AssistantActivityExpandState.NA;
        this.m = AuthenticationType.INVALID;
        this.p = new a0(this);
        RelativeLayout.LayoutParams r5 = new RelativeLayout.LayoutParams(-1, -2);
        r5.addRule(12);
        r5.bottomMargin = -getContext().getResources().getDimensionPixelSize(2131166231);
        setLayoutParams(r5);
        LayoutInflater.from(getContext()).inflate(2131564050, this, true);
        e1.o(this);
        getAnimView().addAnimatorListener(new a(this));
        this.q = new b0(this);
        this.r = LazyKt.lazy(new c0(this));
        this.s = new d(this);
    }

    public static Animator e(final View r2, float r3, float r4) {
        r2.setAlpha(r3);
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{r3, r4});
        r5.setInterpolator(new DecelerateInterpolator());
        r5.setDuration(200);
        r5.addUpdateListener(new s(r2));
        return r5;
    }

    public final void i(final boolean r8, boolean r9, final boolean r10) {
        FLogger.a.i("SessionAuthenticationStateView", "setAnimViewVisibility: isVisible = " + r8 + ", withAnimation = " + r9 + ", delayHide = " + r10);
        Animator r0 = this.n;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        Job r1 = this.d;
        if (r1 == null) goto L8;
        Job.DefaultImpls.cancel$default(r1, null, 1, null);
    L8:
        this.n = null;
        this.d = null;
        if (r9 == false) goto L15;
        final AnimatorSet r11 = new AnimatorSet();
        e1.x(getAnimView());
        e1.x(getIconView());
        if (r8 == false) goto L13;
        r11.playSequentially(new Animator[]{e(getIconView(), 1.0f, 0.0f), e(getAnimView(), 0.0f, 1.0f)});
    L14:
        Function1 r2 = new d0(r8);
        d2a.e r3 = d2a.g.a;
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r2, "callback");
        d2a.g.b(r11, r2, null, null, 14);
        d2a.g.c(r11, new q(r8, this, r11, r10));
        r11.start();
        this.n = r11;
        return;
    L13:
        r11.playSequentially(new Animator[]{e(getAnimView(), 1.0f, 0.0f), e(getIconView(), 0.0f, 1.0f)});
        goto L14
    L15:
        getAnimView().setAlpha(1.0f);
        getIconView().setAlpha(1.0f);
        if (r8 == false) goto L18;
        e1.x(getAnimView());
        e1.q(getIconView());
        getBlockClickLayout().setOnClickListener(getEmptyClickListener());
        return;
    L18:
        e1.q(getAnimView());
        e1.x(getIconView());
        getBlockClickLayout().setOnClickListener(null);
    }

    public static Unit b(boolean r6, final SessionAuthenticationStateView r7, AnimatorSet r8, boolean r9, Animator r10) {
        Intrinsics.checkNotNullParameter(r10, "it");
        FLogger.a.i("SessionAuthenticationStateView", "onAnimationEnd: isVisible = " + r6);
        if (Intrinsics.areEqual(r7.n, r8) == false) goto L5;
        r7.n = null;
    L5:
        if (r6 == false) goto L7;
        e1.x(r7.getAnimView());
        e1.q(r7.getIconView());
    L8:
        if (r6 == false) goto L12;
        if (r9 == false) goto L12;
        final Job r11 = BuildersKt.launch$default(r7.c, null, null, new SessionAuthenticationStateView$setAnimViewVisibility$1$2$1(r7, null), 3, null);
        r11.invokeOnCompletion(new t(r11, r7));
        r7.d = r11;
    L12:
        return Unit.INSTANCE;
    L7:
        e1.q(r7.getAnimView());
        e1.x(r7.getIconView());
        goto L8
    }
}
