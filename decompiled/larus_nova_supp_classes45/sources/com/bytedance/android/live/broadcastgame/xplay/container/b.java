package com.bytedance.android.live.broadcastgame.xplay.container;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.g;
import com.bytedance.android.live.broadcastgame.xplay.g0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.qz0;
import com.bytedance.android.livesdk.event.i;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements o, com.bytedance.android.live.broadcastgame.xplay.container.a {
    public final CompositeDisposable a;
    public e b;
    public FrameLayout c;
    public ViewGroup d;
    public boolean e;
    public final PublishSubject<Boolean> f;
    public final p g;
    public final g h;
    public final XplayInternalContext i;
    public final g0 j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final ViewGroup a() {
        FrameLayout r0 = this.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("floatingWindowContainer");
    L5:
        return r0;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final ViewGroup c() {
        e r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L6:
        return r0.getXplayContainer();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final void d() {
        this.i.getCurrentScene().setValue(XplayScene.Video);
        j();
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final ViewGroup g() {
        e r0 = this.b;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L6:
        return r0.getAnchorPreviewContainer();
    }

    public final void j() {
        XplayLog.c("InteractPlayContainerService", "starting");
        ViewGroup r0 = this.d;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        FrameLayout.LayoutParams r1 = new FrameLayout.LayoutParams(-1, -1);
        r1.height = s1.w() - s1.f(52);
        ViewGroup r2 = this.d;
        if (r2 == null) goto L8;
        r2.setLayoutParams(r1);
    L8:
        e r3 = this.b;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L11:
        ViewParent r4 = r3.getParent();
        ViewParent r5 = null;
        if ((r4 instanceof ViewGroup) == true) goto L14;
        r4 = null;
    L14:
        ViewGroup r6 = (ViewGroup) r4;
        if (r6 == null) goto L17;
        r6.removeView(r3);
    L17:
        ViewGroup r7 = this.d;
        if (r7 == null) goto L20;
        r7.addView(r3);
    L20:
        FrameLayout r8 = this.c;
        if (r8 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("floatingWindowContainer");
    L23:
        ViewParent r9 = r8.getParent();
        if ((r9 instanceof ViewGroup) == false) goto L27;
        r5 = r9;
    L27:
        ViewGroup r11 = (ViewGroup) r5;
        if (r11 == null) goto L30;
        r11.removeView(r8);
    L30:
        ViewGroup r12 = this.d;
        if (r12 == null) goto L34;
        r12.addView(r8);
        return;
    }

    public final void k() {
        XplayLog.c("InteractPlayContainerService", "move to top");
        if (((XplayScene) this.i.getCurrentScene().getValue()) != XplayScene.Video) goto L8;
        xs2.b.a().post(new i(true));
        DataCenter r0 = this.g.i;
        if (r0 == null) goto L8;
        r0.put("cmd_notify_live_game_play_toolbar_show_bubble", Boolean.TRUE);
    L8:
        if (((XplayScene) this.i.getCurrentScene().getValue()) == XplayScene.RevenueLink) goto L15;
        e r1 = this.b;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L12:
        r1.getClass();
        this.h.a(true);
        if (true == this.e) goto L15;
        this.e = true;
        this.f.onNext(Boolean.TRUE);
    L15:
        e r2 = this.b;
        if (r2 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L18:
        r2.setBlockTouchEvents(false);
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final e n() {
        e r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L5:
        return r0;
    }

    public final void onStart() {
        this.b = new e(this.g.getContext(), this.h, this.j, this.i, this.g);
        this.c = new FrameLayout(this.g.getContext());
        XplayExternalContext.a r0 = XplayExternalContext.Companion;
        XplayExternalContext r1 = r0.getContext();
        if (r1 == null) goto L7;
        n<ViewGroup> r2 = r1.getInteractPlayContainer();
        if (r2 == null) goto L7;
        ViewGroup r3 = (ViewGroup) r2.getValue();
    L8:
        this.d = r3;
        XplayExternalContext r4 = r0.getContext();
        if (r4 == null) goto L14;
        m<Boolean> r5 = r4.getClearScreen();
        if (r5 == null) goto L14;
        RxUtilKt.c(this.f.subscribe(new c(r5)), this.a);
        RxUtilKt.c(r5.a().subscribe(new d(this)), this.a);
    L14:
        if (this.g.d == true) goto L20;
        e r6 = this.b;
        if (r6 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mInteractPlayView");
    L18:
        r6.setParentDisallowInterceptTouchEvent(((Boolean) qz0.a.getValue()).booleanValue());
        return;
    L20:
        return;
    L7:
        r3 = null;
        goto L8
    }

    public final void onStop() {
        xs2.b.a().post(new i(false));
        this.a.clear();
        ViewGroup r0 = this.d;
        if (r0 == null) goto L5;
        r0.removeAllViews();
    L5:
        this.d = null;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final PublishSubject h() {
        return this.f;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final boolean i() {
        return this.e;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.container.a
    public final void f(boolean r2) {
        if (r2 == this.e) goto L6;
        this.e = r2;
        this.f.onNext(Boolean.valueOf(r2));
        return;
    }

    public b(p r2, g r3, XplayInternalContext r4, g0 r5) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayToolbarService");
        Intrinsics.checkNotNullParameter(r4, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r5, "xplayLogService");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.a = new CompositeDisposable();
        this.f = PublishSubject.create();
    }
}
