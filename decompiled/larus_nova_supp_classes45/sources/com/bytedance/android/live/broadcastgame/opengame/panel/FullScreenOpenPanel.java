package com.bytedance.android.live.broadcastgame.opengame.panel;

import android.R;
import android.animation.ValueAnimator;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel$initPanelAndHide$3;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.s;
import com.bytedance.android.live.broadcastgame.opengame.runtime.t;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.broadcastgame.opengame.view.PanelTopRightButtonView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.statusbar.IESStatusBarUtil;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.t8;
import com.bytedance.android.livesdk.widget.roundcorner.RoundCornerConstraintLayout;
import com.bytedance.android.livesdkapi.model.InnerContextEntity;
import com.bytedance.android.livesdkapi.service.ILiveVideoFloatWindowService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.subjects.PublishSubject;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zg1.h1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/panel/FullScreenOpenPanel;", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bytedance/android/live/broadcastgame/opengame/panel/g;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/s;", "Lcom/bytedance/android/live/broadcastgame/opengame/panel/i;", "Landroid/content/Intent;", "intent", "", "requestCode", "Landroid/os/Bundle;", "options", "", "startActivityForResult", "Landroid/view/View;", "view", "addTopRightBtnView", "addTopMessageView", "<init>", "()V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FullScreenOpenPanel extends FragmentActivity implements g, s<i> {
    public static final AtomicInteger E = null;
    public static final HashMap<Integer, WeakReference<FullScreenOpenPanel>> F = null;
    public static final HashSet<Integer> G = null;
    public static final PublishSubject H = null;
    public boolean A;
    public View.OnClickListener B;
    public PanelType C;
    public final /* synthetic */ t<i> D;
    public Map<Integer, View> a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public RoundCornerConstraintLayout e;
    public ViewGroup f;
    public ViewGroup g;
    public LiveDoubleColorBallAnimationView h;
    public ViewGroup i;
    public TextView j;
    public ViewGroup k;
    public PanelTopRightButtonView l;
    public ViewGroup m;
    public boolean n;
    public boolean o;
    public boolean p;
    public long q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public PluginContext w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    public static final class a {
    }

    public static final class b implements Animation.AnimationListener {
        public final /* synthetic */ Function0 a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public b(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r1) {
            this.a.invoke();
        }
    }

    public static final class c implements Animation.AnimationListener {
        public final /* synthetic */ Function0 a;

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationStart(Animation r1) {
        }

        public c(Function0 r1) {
            this.a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public final void onAnimationEnd(Animation r1) {
            this.a.invoke();
        }
    }

    public final long B1() {
        return ((Number) this.c.getValue()).longValue();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void F() {
    }

    public final boolean F1() {
        return ((Boolean) this.d.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Context J() {
        return this;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void hide() {
        D1(true);
    }

    public final void onBackPressed() {
        this.n = true;
        i r0 = A1();
        if (r0 == null) goto L6;
        r0.onBackPressed();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void u0(Bitmap r2) {
        Intrinsics.checkNotNullParameter(r2, KtvSubElement.BACKGROUND);
    }

    static {
        E = new AtomicInteger(0);
        F = new HashMap();
        G = new HashSet();
        H = PublishSubject.create();
    }

    public final i A1() {
        return this.D.b;
    }

    /* JADX INFO: Removed unreachable split cross block B:51:0x0104 */
    /* JADX WARN: Multi-variable type inference failed */
    public final void finish() {
        super.finish();
        if ((this instanceof ChatWindowActivity) == true) goto L44;
        FLogger r2 = FLogger.a;
        r2.i("ActivityLancet", "finish ".concat(FullScreenOpenPanel.class.getName()));
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
    L48:
        return;
    L16:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L19;
        r2.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L42
        goto L48
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

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final List<i> getListeners() {
        return this.D.a;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final PanelType getPanelType() {
        PanelType r0 = this.C;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return PanelType.PANEL_TYPE_X_SCREEN;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void h() {
        UtilityKotlinExtentionsKt.s(0, false, false, new FullScreenOpenPanel$showDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup h0() {
        ViewGroup r0 = this.k;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i() {
        UtilityKotlinExtentionsKt.s(0, false, false, new FullScreenOpenPanel$hideDoubleBallLoading$1(this), 7);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void init() {
        int r0 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"init, do nothing"});
    }

    public final void onDestroy() {
        int r0 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"onDestroy, remove record"});
        int r1 = ((Number) this.b.getValue()).intValue();
        G.add(Integer.valueOf(r1));
        F.remove(Integer.valueOf(r1));
        i r2 = A1();
        if (r2 == null) goto L5;
        r2.b();
    L5:
        RoundCornerConstraintLayout r3 = this.e;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L8:
        r3.clearAnimation();
        C1(false);
        super.onDestroy();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onStop() {
        int r0 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"onStop, isShowing: " + this.n});
        boolean r1 = this.n;
        Function0<Unit> r2 = new C03051(this);
        if (r1 != true) goto L5;
        r2.invoke();
    L5:
        this.n = false;
        this.A = false;
        if (isFinishing() == true) goto L10;
        InteractGameContext r3 = InteractGameContext.Companion.getContext();
        if (r3 == null) goto L10;
        r3.setGameFullPanelIsShowing(false);
    L10:
        super.onStop();
        if (isFinishing() == false) goto L16;
        InteractGameContext r4 = InteractGameContext.Companion.getContext();
        if (r4 == null) goto L16;
        r4.setGameFullPanelIsShowing(false);
    L16:
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L22;
        y1(getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L19
        return;
    L23:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void show() {
        boolean r0 = this.n;
        Function0<Unit> r1 = new C03061(this);
        if (r0 == true) goto L5;
        r1.invoke();
        Boolean r2 = Boolean.FALSE;
    L6:
        if (r2 == null) goto L17;
        r2.booleanValue();
        if (isDestroyed() == false) goto L10;
        return;
    L10:
        if (getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L19;
        InteractGameContext r3 = InteractGameContext.Companion.getContext();
        if (r3 == null) goto L15;
        r3.setGameFullPanelIsShowing(true);
    L15:
        int r4 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"move activity to front"});
        Application r5 = jc1.a.b();
        Function1<Intent, Unit> r6 = new AnonymousClass2(this);
        Intent r7 = new Intent(r5, FullScreenOpenPanel.class);
        r7.addFlags(268435456);
        r6.invoke(r7);
        Unit r8 = Unit.INSTANCE;
        r5.startActivity(r7);
        ((ShowTipsHelper) this.z.getValue()).b();
        return;
    L19:
        return;
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    public FullScreenOpenPanel() {
        this.D = new t();
        this.a = new LinkedHashMap();
        this.b = LazyKt.lazy(new FullScreenOpenPanel$token$2(this));
        this.c = LazyKt.lazy(new FullScreenOpenPanel$roomId$2(this));
        this.d = LazyKt.lazy(new FullScreenOpenPanel$isAnchor$2(this));
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.x = LazyKt.lazy(new FullScreenOpenPanel$enterAnimation$2(this));
        this.y = LazyKt.lazy(new FullScreenOpenPanel$outAnimation$2(this));
        this.z = LazyKt.lazy(new FullScreenOpenPanel$showTipsHelper$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G1() {
        if (F1() == false) goto L5;
        return;
    L5:
        if (this.o == true) goto L10;
        this.o = true;
        ILiveVideoFloatWindowService r0 = jc1.k.n(ILiveVideoFloatWindowService.class);
        InnerContextEntity.InnerFloatExtra r1 = new InnerContextEntity.InnerFloatExtra();
        r1.setRequestPage("open_game_page");
        r1.setEnterRoomId(Long.valueOf(B1()));
        r1.setFinishOnClick(false);
        r1.setOnClickListener(new FullScreenOpenPanel$showFloatWindow$$inlined$apply$lambda$1(this));
        Unit r2 = Unit.INSTANCE;
        r0.startShowFloat(this, r1);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void L0() {
        i();
        ViewGroup r0 = this.g;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("retryLayout");
    L5:
        UtilityKotlinExtentionsKt.w(r0);
        TextView r1 = this.j;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L8:
        UtilityKotlinExtentionsKt.w(r1);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final ViewGroup getContentView() {
        return (ViewGroup) _$_findCachedViewById(2131374647);
    }

    public final void onPause() {
        super.onPause();
        int r0 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"onPause"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onResume() {
        super.onResume();
        int r0 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"onResume"});
        RoundCornerConstraintLayout r1 = this.e;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        UtilityKotlinExtentionsKt.z(r1, true);
        PanelType r2 = this.C;
        PanelType r6 = PanelType.PANEL_TYPE_LANDSCAPE;
        if (r2 != r6) goto L11;
        if (getRequestedOrientation() == 0) goto L11;
        H1(r6, true);
    L17:
        z1(this.C);
        this.p = false;
        final Ref.BooleanRef r3 = new Ref.BooleanRef();
        r3.element = true;
        boolean r4 = this.n;
        Function0<Unit> r7 = new AnonymousClass1(this, r3);
        if (r4 == true) goto L20;
        r7.invoke();
    L20:
        Function0<Unit> r5 = new FullScreenOpenPanel$onResume$checkFloatWindowShow$1(this);
        if (r3.element == true) goto L23;
        return;
    L23:
        this.n = true;
        q.g("onResume", "FullScreenOpenPanel");
        if (((Animation) this.x.getValue()).hasStarted() == true) goto L26;
    L28:
        ((Animation) this.x.getValue()).reset();
        Animation r8 = (Animation) this.x.getValue();
        if (r8 == null) goto L31;
        r8.setAnimationListener(new c(r5));
    L31:
        RoundCornerConstraintLayout r9 = this.e;
        if (r9 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L34:
        r9.startAnimation((Animation) this.x.getValue());
        return;
    L26:
        if (((Animation) this.x.getValue()).hasEnded() == true) goto L28;
        return;
    L11:
        if (this.C == r6) goto L17;
        if (getRequestedOrientation() == 1) goto L17;
        PanelType r11 = this.C;
        if (r11 == null) goto L17;
        H1(r11, true);
        goto L17
    }

    public final void onStart() {
        super.onStart();
        int r0 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"onStart"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final Window v0() {
        return getWindow();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final OpenPanelType c() {
        return OpenPanelType.FULL_SCREEN_OPEN_PANEL;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void dismiss() {
        finish();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final boolean isShowing() {
        return this.n;
    }

    public static View y1(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.bytedance.android.live.broadcastgame.opengame.panel.i, java.lang.Object] */
    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void C(i r2) {
        i r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "delegate");
        this.D.b = r3;
    }

    public final void C1(boolean r5) {
        if (F1() == false) goto L5;
        return;
    L5:
        if (this.o == false) goto L17;
        jc1.k.n(ILiveVideoFloatWindowService.class).stopShowFloat();
        if (r5 == false) goto L14;
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, null, B1(), 1);
        if (r6 == null) goto L14;
        if (r6.isCleared() == true) goto L14;
        xs2.b.a().post(new h1(42));
    L14:
        this.o = false;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D1(boolean r4) {
        boolean r0 = this.n;
        Function0<Unit> r1 = new FullScreenOpenPanel$hidePanel$1(this);
        boolean r2 = true;
        if (r0 != true) goto L5;
        r1.invoke();
        Boolean r3 = Boolean.FALSE;
    L6:
        if (r3 == null) goto L33;
        r3.booleanValue();
        if (this.C != PanelType.PANEL_TYPE_LANDSCAPE) goto L10;
        setRequestedOrientation(1);
    L10:
        K1(false);
        if (isFinishing() == false) goto L13;
    L15:
        r2 = false;
    L16:
        C1(r2);
        Function0<Unit> r5 = new FullScreenOpenPanel$hidePanel$moveToBack$1(this);
        if (r4 == true) goto L21;
        r5.invoke();
        return;
    L21:
        if (((Animation) this.y.getValue()).hasStarted() == true) goto L23;
    L25:
        ((Animation) this.y.getValue()).reset();
        ((Animation) this.y.getValue()).setAnimationListener(new b(r5));
        RoundCornerConstraintLayout r6 = this.e;
        if (r6 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L28:
        r6.clearAnimation();
        RoundCornerConstraintLayout r7 = this.e;
        if (r7 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L31:
        r7.startAnimation((Animation) this.y.getValue());
        ((ShowTipsHelper) this.z.getValue()).a();
        return;
    L23:
        if (((Animation) this.y.getValue()).hasEnded() == true) goto L25;
        return;
    L13:
        if (isDestroyed() == true) goto L15;
    L33:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void K(boolean r2) {
        PanelTopRightButtonView r0 = this.l;
        if (r0 == null) goto L6;
        r0.setTopRightTheme(r2);
        return;
    }

    public final void K1(boolean r13) {
        if (r13 == true) goto L7;
        PanelType r14 = this.C;
        if (r14 == PanelType.PANEL_TYPE_LANDSCAPE) goto L7;
        if (r14 == PanelType.PANEL_TYPE_PORTRAIT) goto L7;
        return;
    L7:
        TrackMiniGameService.a r15 = TrackMiniGameService.g;
        String r7 = String.valueOf(B1());
        boolean r0 = F1();
        String r2 = this.r;
        String r3 = this.s;
        String r4 = this.t;
        String r5 = this.u;
        String r6 = this.v;
        String r1 = String.valueOf((System.currentTimeMillis() - this.q) / ((long) 1000));
        r15.getClass();
        Intrinsics.checkNotNullParameter(r7, "roomId");
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r5, "gameName");
        Intrinsics.checkNotNullParameter(r6, "gameCategory");
        Intrinsics.checkNotNullParameter(r1, "duration");
        com.bytedance.android.livesdk.log.g r11 = u.l();
        Map r8 = TrackMiniGameService.a.b(r2, r3, r4, r5, r6, r7, Boolean.valueOf(r0), 896);
        r8.put("duration", r1);
        Unit r16 = Unit.INSTANCE;
        r11.sendLog("livesdk_game_full_screen_duration", r8, new Object[0]);
    }

    public final void L1(PanelType r11) {
        int r12 = com.bytedance.android.live.broadcastgame.opengame.panel.c.c[r11.ordinal()];
        if (r12 != 1) goto L5;
    L18:
        this.q = System.currentTimeMillis();
        TrackMiniGameService.a r13 = TrackMiniGameService.g;
        String r7 = String.valueOf(B1());
        boolean r0 = F1();
        String r2 = this.r;
        String r3 = this.s;
        String r4 = this.t;
        String r5 = this.u;
        String r6 = this.v;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r7, "roomId");
        Intrinsics.checkNotNullParameter(r2, "anchorId");
        Intrinsics.checkNotNullParameter(r3, "userId");
        Intrinsics.checkNotNullParameter(r4, "gameId");
        Intrinsics.checkNotNullParameter(r5, "gameName");
        Intrinsics.checkNotNullParameter(r6, "gameCategory");
        u.l().sendLog("livesdk_game_full_screen_show", TrackMiniGameService.a.b(r2, r3, r4, r5, r6, r7, Boolean.valueOf(r0), 896), new Object[0]);
        return;
    L5:
        if (r12 == 2) goto L18;
        if (r12 != 3) goto L9;
    L11:
        TrackMiniGameService.a r14 = TrackMiniGameService.g;
        String r8 = String.valueOf(B1());
        boolean r9 = F1();
        String r15 = this.r;
        String r16 = this.s;
        String r17 = this.t;
        String r18 = this.u;
        String r19 = this.v;
        PluginContext r1 = this.w;
        if (r1 == null) goto L16;
        com.bytedance.android.live.broadcastgame.opengame.t r21 = r1.m;
        if (r21 == null) goto L16;
        String r22 = r21.i;
    L17:
        r14.getClass();
        TrackMiniGameService.a.c(r8, r9, r15, r16, r17, r18, r19, r22);
        return;
    L16:
        r22 = null;
        goto L17
    L9:
        if (r12 == 4) goto L11;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void M(int r2) {
        if (r2 != 0) goto L8;
        ViewGroup r3 = this.m;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L7:
        UIUtils.setViewVisibility(r3, 0);
        return;
    L8:
        ViewGroup r4 = this.m;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L11:
        UIUtils.setViewVisibility(r4, 8);
    }

    public final void M1(PanelType r7) {
        int r1 = UtilityKotlinExtentionsKt.i(12);
        ViewGroup r2 = this.k;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L5:
        int r8 = com.bytedance.android.live.broadcastgame.opengame.panel.c.b[r7.ordinal()];
        if (r8 != 1) goto L8;
        RoundCornerConstraintLayout r9 = this.e;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L26:
        r9.J(0, 0, 0, 0);
        r1 = r1 + s1.A();
    L27:
        a1.o(r2, r1);
        return;
    L8:
        if (r8 != 2) goto L10;
    L19:
        RoundCornerConstraintLayout r11 = this.e;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L22:
        r11.J(UtilityKotlinExtentionsKt.i(12), 0, UtilityKotlinExtentionsKt.i(12), 0);
        goto L27
    L10:
        if (r8 == 3) goto L19;
        if (r8 != 4) goto L18;
        RoundCornerConstraintLayout r12 = this.e;
        if (r12 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L16:
        r12.J(0, 0, 0, 0);
        goto L27
    L18:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void V(boolean r3) {
        if (r3 == false) goto L8;
        RoundCornerConstraintLayout r4 = this.e;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L7:
        r4.setBackground(new ColorDrawable(ColorProtector.parseColor("#161616")));
        return;
    L8:
        RoundCornerConstraintLayout r5 = this.e;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r5.setBackground(new ColorDrawable(-16777216));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View _$_findCachedViewById(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public void addTopMessageView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        ViewGroup r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L5:
        r0.addView(r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public void addTopRightBtnView(View r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if ((r3 instanceof PanelTopRightButtonView) == true) goto L5;
        View r0 = null;
    L6:
        PanelTopRightButtonView r1 = (PanelTopRightButtonView) r0;
        if (r1 == null) goto L9;
        this.l = r1;
    L9:
        ViewGroup r2 = this.k;
        if (r2 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L12:
        r2.addView(r3);
        return;
    L5:
        r0 = r3;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void i1(boolean r2) {
        int r3 = q.a;
        q.g("FullScreenOpenPanel", "全屏的面板不需要处理圆角的变化 -- 因为圆角要一直展示");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r6) {
        Intrinsics.checkNotNullParameter(r6, "newConfig");
        super.onConfigurationChanged(r6);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (dc9.d.a() == true) goto L19;
        int r1 = getRequestedOrientation();     // Catch: Throwable -> L17
        if (r6 == null) goto L8;
        Integer r2 = Integer.valueOf(r6.orientation);     // Catch: Throwable -> L17
    L9:
        if (r2 != null) goto L12;
    L14:
        if (r1 != 3) goto L19;
        setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.a.i("PadLancet", "onConfigurationChanged, phone reset page:FullScreenOpenPanel portrait");     // Catch: Throwable -> L17
        goto L19
    L12:
        if (r2.intValue() == r1) goto L19;
    L8:
        r2 = null;
    L19:
        PanelType.a r0 = PanelType.Companion;
        PanelType r3 = this.C;
        r0.getClass();
        if (PanelType.a.a(r3) == true) goto L22;
        return;
    L22:
        if (r6.orientation != 2) goto L28;
        G1();
        return;
    L28:
        return;
    L17:
        th = move-exception;
        FLogger.a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r4) {
        if (z2.a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        super.onCreate(r4);
        int r5 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"onCreate, init view and notify panel created"});
        com.bytedance.android.live.broadcastgame.opengame.runtime.u.a(this, i.class);
        overridePendingTransition(0, 0);
        setContentView(2131567101);
        getWindow().setGravity(80);
        getWindow().setLayout(-1, -1);
        getWindow().setDimAmount(0.0f);
        if (Build.VERSION.SDK_INT < 28) goto L13;
        WindowManager.LayoutParams r0 = getWindow().getAttributes();
        r0.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(r0);
    L13:
        y1(getWindow()).post(new f(this));
        IESStatusBarUtil.transparencyBar(this);
        this.e = _$_findCachedViewById(2131373452);
        this.f = (ViewGroup) _$_findCachedViewById(2131374647);
        TextView r6 = (TextView) _$_findCachedViewById(2131387280);
        this.g = (ViewGroup) _$_findCachedViewById(2131379079);
        this.h = _$_findCachedViewById(2131370107);
        ViewGroup r7 = (ViewGroup) _$_findCachedViewById(2131370108);
        this.i = r7;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("doubleBallLoadingLayoutBg");
    L16:
        r7.setOnClickListener(d.a);
        TextView r8 = (TextView) _$_findCachedViewById(2131384465);
        this.j = r8;
        if (r8 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("retryBtn");
    L19:
        r8.setOnClickListener(new e(this));
        ViewGroup r9 = (ViewGroup) _$_findCachedViewById(2131389207);
        this.k = r9;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L22:
        a1.e(r9);
        ViewGroup r11 = this.k;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L25:
        r11.setVisibility(8);
        ViewGroup r12 = (ViewGroup) _$_findCachedViewById(2131389187);
        this.m = r12;
        if (r12 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("topMessageContainer");
    L28:
        r12.setVisibility(8);
        ((LinearLayout) _$_findCachedViewById(2131372802)).setOnClickListener(new FullScreenOpenPanel$initView$3(this));
        r(PanelType.PANEL_TYPE_X_SCREEN);
        int r13 = ((Number) this.b.getValue()).intValue();
        F.put(Integer.valueOf(r13), new WeakReference(this));
        H.onNext(TuplesKt.to(Integer.valueOf(r13), this));
        h();
        i r14 = A1();
        if (r14 == null) goto L34;
        r14.a();
        return;
    }

    public final void onNewIntent(Intent r3) {
        super.onNewIntent(r3);
        int r4 = q.a;
        q.f("FullScreenOpenPanel", new Object[]{"onNewIntent"});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onWindowFocusChanged(boolean r1) {
        super/*android.app.Activity*/.onWindowFocusChanged(r1);
        if (r1 == false) goto L6;
        z1(this.C);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void p(int r2) {
        if (r2 != 0) goto L8;
        ViewGroup r3 = this.k;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L7:
        UIUtils.setViewVisibility(r3, 0);
        return;
    L8:
        ViewGroup r4 = this.k;
        if (r4 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("topRightBtnContainer");
    L11:
        UIUtils.setViewVisibility(r4, 8);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void r(PanelType r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        b0(r2, null);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.s
    public final void registerListener(i r2) {
        i r3 = r2;
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.D.registerListener(r3);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.h
    public final void z(LiveBasePluginWithPanel$initPanelAndHide$3.a r2) {
        Intrinsics.checkNotNullParameter(r2, "clickListener");
        this.B = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void z1(PanelType r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2 != PanelType.PANEL_TYPE_LANDSCAPE) goto L7;
    L10:
        t8.d(getWindow());
        return;
    L7:
        if (r2 == PanelType.PANEL_TYPE_PORTRAIT) goto L10;
        t8.e(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H1(PanelType r5, boolean r6) {
        PanelType r0 = PanelType.PANEL_TYPE_LANDSCAPE;
        if (r5 != r0) goto L5;
        int r2 = 0;
    L6:
        setRequestedOrientation(r2);
        if (r5 != r0) goto L14;
        M1(r5);
        z1(r5);
        RoundCornerConstraintLayout r1 = this.e;
        if (r1 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L11:
        r1.setLayoutParams(new LinearLayout.LayoutParams(r0.getWidth(), r0.getHeight()));
        if (r6 == true) goto L18;
        L1(r5);
        return;
    L18:
        return;
    L14:
        if (r5 == r0) goto L16;
        K1(true);
    L16:
        z1(r5);
        M1(r5);
        return;
    L5:
        r2 = 1;
        goto L6
    }

    public final void I1(final PanelType r7, final PanelType r8) {
        Intrinsics.checkNotNullParameter(r8, "toPanelType");
        if (r7 != r8) goto L6;
        return;
    L6:
        if (r7 == PanelType.PANEL_TYPE_LANDSCAPE) goto L8;
        z1(r8);
        h();
        int r0 = com.bytedance.android.live.broadcastgame.opengame.utils.b.a;
        RoundCornerConstraintLayout r1 = this.e;
        if (r1 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L18:
        PanelType r3 = this.C;
        if (r3 == null) goto L21;
        int r4 = r3.getHeight();
    L22:
        int r5 = r8.getHeight();
        Intrinsics.checkNotNullParameter(r1, "targetView");
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{r4, r5}).setDuration(500);
        r2.addUpdateListener(new com.bytedance.android.live.broadcastgame.opengame.utils.a(r1));
        r2.start();
        com.bytedance.android.live.core.utils.h.a(r2, new FullScreenOpenPanel$switchPortraitScreen$1(this, r8, r7));
        return;
    L21:
        r4 = r8.getHeight();
        goto L22
    L8:
        if (r8 == PanelType.PANEL_TYPE_PORTRAIT) goto L10;
        C1(true);
    L10:
        L1(r8);
        z1(r8);
        H1(r8, false);
        RoundCornerConstraintLayout r9 = this.e;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L13:
        r9.setLayoutParams(new LinearLayout.LayoutParams(r8.getWidth(), r8.getHeight()));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.g
    public final void b0(PanelType r5, Function1<? super PanelType, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "toType");
        PanelType r0 = this.C;
        if (r0 != r5) goto L7;
        if (r6 == null) goto L27;
        Unit r7 = (Unit) r6.invoke(r5);
        return;
    L27:
        return;
    L7:
        xs2.b r1 = xs2.b.a();
        if (r0 != null) goto L10;
        PanelType r3 = getPanelType();
    L11:
        r1.post(new q10.a(r3, r5));
        int r2 = com.bytedance.android.live.broadcastgame.opengame.panel.c.a[r5.ordinal()];
        if (r2 != 1) goto L14;
        I1(r0, r5);
    L23:
        this.C = r5;
        if (r6 == null) goto L28;
        Unit r8 = (Unit) r6.invoke(r5);
        return;
    L28:
        return;
    L14:
        if (r2 != 2) goto L16;
    L21:
        I1(r0, r5);
        goto L23
    L16:
        if (r2 == 3) goto L21;
        if (r2 != 4) goto L23;
        H1(r5, false);
        goto L23
    L10:
        r3 = r0;
        goto L11
    }

    public void startActivityForResult(Intent r2, int r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "intent");
        this.A = true;
        super/*androidx.activity.ComponentActivity*/.startActivityForResult(r2, r3, r4);
    }
}
