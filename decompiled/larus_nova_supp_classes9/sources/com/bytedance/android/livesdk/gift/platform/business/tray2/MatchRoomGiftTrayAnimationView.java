package com.bytedance.android.livesdk.gift.platform.business.tray2;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.android.livesdk.gift.platform.business.normal.model.NormalGiftMessage;
import com.bytedance.android.livesdk.gift.platform.business.tray.GiftTrayWidget;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.android.livesdk.gift.platform.core.utils.w;
import com.bytedance.android.livesdk.gift.platform.core.y;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.room.RevPadOrientation;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.live.datacontext.m;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010#\u001a\u00020\"\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010&\u001a\u00020\u0003¢\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002R(\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u001a8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\b\u001a\u00020\u001a8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u001e¨\u0006)"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/tray2/MatchRoomGiftTrayAnimationView;", "Lcom/bytedance/android/livesdk/gift/platform/business/tray2/BaseGiftTrayAnimationView;", "Lcom/bytedance/android/livesdk/gift/platform/core/y;", BuildConfig.FLAVOR, "getOriginalTopMargin", "getGatherHeight", "getGiftToHotMsgTrayMargin", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "value", "k", "Lcom/bytedance/android/live/base/model/user/IBaseUser;", "setMAnchor", "(Lcom/bytedance/android/live/base/model/user/IBaseUser;)V", "mAnchor", "Ls02/d;", "l", "Ls02/d;", "getOnGiftTrayIdleStateListener", "()Ls02/d;", "setOnGiftTrayIdleStateListener", "(Ls02/d;)V", "onGiftTrayIdleStateListener", "Lcom/bytedance/android/livesdk/revenue/service/interactivity/b;", "getInteractivityService", "()Lcom/bytedance/android/livesdk/revenue/service/interactivity/b;", "interactivityService", BuildConfig.FLAVOR, "isAnchor", "Z", "setAnchor", "(Z)V", "isPortrait", "()Z", "setPortrait", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MatchRoomGiftTrayAnimationView extends BaseGiftTrayAnimationView implements y {
    public static final /* synthetic */ int o = 0;
    public final String e;
    public final n12.f f;
    public s02.c g;
    public final CompositeDisposable h;
    public ViewGroup.MarginLayoutParams i;
    public ValueAnimator j;
    public IBaseUser k;
    public s02.d l;
    public final r02.b m;
    public final a n;

    public static final class a implements s02.b {
        public final /* synthetic */ MatchRoomGiftTrayAnimationView a;

        @Override // s02.b
        public final void onPlay() {
            MatchRoomGiftTrayAnimationView.r(this.a);
            MatchRoomGiftTrayAnimationView r0 = this.a;
            r0.getClass();
            GiftTrayMessageManager r1 = GiftTrayMessageManager.r;
            GiftTrayMessageManager r2 = GiftTrayMessageManager.a.a();
            r2.j = r0.m.b;
            s02.d r3 = this.a.getOnGiftTrayIdleStateListener();
            if (r3 == null) goto L5;
            r3.e();
        L5:
            BaseGiftTrayAnimationView.n(this.a, 50, false, 2);
        }

        public a(MatchRoomGiftTrayAnimationView r1) {
            this.a = r1;
        }

        @Override // s02.b
        public final void a(NormalGiftMessage r6) {
            Intrinsics.checkNotNullParameter(r6, "normalGiftMessage");
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
            com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.f(Long.valueOf(r6.a), "play onFinish " + r6.b);
            MatchRoomGiftTrayAnimationView r0 = this.a;
            int r1 = MatchRoomGiftTrayAnimationView.o;
            r0.getClass();
            GiftTrayMessageManager r2 = GiftTrayMessageManager.r;
            GiftTrayMessageManager.a.a().j = r0.m.b;
            this.a.m.c();
            MatchRoomGiftTrayAnimationView r3 = this.a;
            if (r3.m.b == false) goto L7;
            s02.d r4 = r3.getOnGiftTrayIdleStateListener();
            if (r4 == null) goto L7;
            r4.onIdle();
        L7:
            GiftTrayMessageManager.a.a().j(r6);
            GiftTrayMessageManager.a.a().m();
            this.a.m(300, true);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ MatchRoomGiftTrayAnimationView a;

        public b(MatchRoomGiftTrayAnimationView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L6;
            this.a.m.c();
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.e, "hide tray due to needShowGiftEffectSwitch is off");
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ MatchRoomGiftTrayAnimationView a;

        public c(MatchRoomGiftTrayAnimationView r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == true) goto L6;
            this.a.m.c();
            com.bytedance.android.livesdk.gift.platform.core.utils.c.a(this.a.e, "hide tray due to needShowGiftTraySwitch is off");
            return;
        }
    }

    public MatchRoomGiftTrayAnimationView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public MatchRoomGiftTrayAnimationView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    private final int getGiftToHotMsgTrayMargin() {
        return s1.f(16.0f);
    }

    private final com.bytedance.android.livesdk.revenue.service.interactivity.b getInteractivityService() {
        return vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void c() {
        GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().c();
        this.m.h();
        BaseGiftTrayAnimationView.n(this, 0, true, 1);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final boolean e() {
        return this.m.b;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void g() {
        r02.b r0 = this.m;
        if (r0.b == true) goto L6;
        r0.e.g();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void h() {
        r02.b r0 = this.m;
        if (r0.b == true) goto L6;
        r0.e.l();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void i() {
        r02.b r0 = this.m;
        r0.j = this.n;
        r0.k = this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        BaseGiftTrayAnimationView.n(this, 0, true, 1);
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e.b.c();
        GiftTrayMessageManager r0 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().c();
        GiftTrayMessageManager r1 = GiftTrayMessageManager.a.a();
        r1.k = null;
        r1.c();
        r02.b r2 = this.m;
        if (r2.j == null) goto L6;
        r2.j = null;
    L6:
        if (r2.k == null) goto L8;
        r2.k = null;
    L8:
        r2.h();
        ValueAnimator r3 = this.j;
        if (r3 == null) goto L11;
        r3.removeAllUpdateListeners();
    L11:
        ValueAnimator r4 = this.j;
        if (r4 == null) goto L14;
        r4.cancel();
    L14:
        this.h.clear();
        GiftContext r5 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r5 == null) goto L19;
        m<Boolean> r6 = r5.getCancelComboForDegradeInMatch();
        if (r6 == null) goto L19;
        r6.setValue(Boolean.FALSE);
    L19:
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
    }

    private final int getGatherHeight() {
        m r0 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r0 == null) goto L21;
        hq2.c r1 = (hq2.c) r0.getValue();
        if (r1 == null) goto L21;
        if (r1.b != true) goto L21;
        m r2 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r2 == null) goto L13;
        hq2.c r3 = (hq2.c) r2.getValue();
        if (r3 == null) goto L13;
        int r4 = r3.a;
    L14:
        if (r4 <= 0) goto L21;
        m r5 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r5 == null) goto L29;
        hq2.c r6 = (hq2.c) r5.getValue();
        if (r6 != null) goto L20;
        return 0;
    L20:
        return r6.a;
    L29:
        return 0;
    L13:
        r4 = 0;
    L21:
        m r7 = getInteractivityService().getHotMsgTrayPos();
        if (r7 == null) goto L31;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L32;
        int r9 = r8.intValue();
        if (r9 > 0) goto L28;
        return 0;
    L28:
        return r9 + getGiftToHotMsgTrayMargin();
    L32:
        return 0;
    L31:
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int getOriginalTopMargin() {
        if (PadConfigUtils.a() == false) goto L17;
        yz0.k r0 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), yz0.k.class);
        if (r0 == null) goto L7;
        RevPadOrientation r1 = r0.getPadOrientationData();
    L9:
        if (r1 != RevPadOrientation.LANDSCAPE) goto L15;
        Object r2 = getParent();
        if (r2 == null) goto L14;
        return ((((View) r2).getHeight() - getPublicScreenHeight()) - getPublicScreenMarginBottom()) - getHeight();
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L15:
        return 0;
    L7:
        r1 = null;
        goto L9
    L17:
        return s1.f(8.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void b() {
        RTLUtil.isAppRTL(getContext());
        this.m.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        m r0 = getInteractivityService().getMatchRoomMsgTrayPos();
        if (r0 == null) goto L9;
        Observable r1 = r0.a();
        if (r1 == null) goto L9;
        Disposable r2 = r1.subscribe(new j(this));
        if (r2 == null) goto L9;
        RxUtilKt.c(r2, this.h);
    L9:
        m r3 = getInteractivityService().getHotMsgTrayPos();
        if (r3 == null) goto L16;
        Observable r4 = r3.a();
        if (r4 == null) goto L16;
        Disposable r5 = r4.subscribe(new i(this));
        if (r5 == null) goto L16;
        RxUtilKt.c(r5, this.h);
    L16:
        ViewGroup.LayoutParams r6 = getLayoutParams();
        if (r6 == null) goto L45;
        ViewGroup.MarginLayoutParams r7 = (ViewGroup.MarginLayoutParams) r6;
        if (PadConfigUtils.a() == false) goto L21;
        float r8 = 20.0f;
    L22:
        r7.leftMargin = s1.f(r8);
        setLayoutParams(r7);
        GiftContext r9 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r9 == null) goto L31;
        m<Boolean> r10 = r9.getNeedShowGiftEffectSwitch();
        if (r10 == null) goto L31;
        Observable r11 = r10.a();
        if (r11 == null) goto L31;
        Disposable r13 = r11.subscribe(new b(this));
        if (r13 == null) goto L31;
        RxUtilKt.c(r13, this.h);
    L31:
        GiftContext r14 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r14 == null) goto L40;
        m<Boolean> r15 = r14.getNeedShowGiftTraySwitch();
        if (r15 == null) goto L40;
        Observable r16 = r15.a();
        if (r16 == null) goto L40;
        Disposable r17 = r16.subscribe(new c(this));
        if (r17 == null) goto L40;
        RxUtilKt.c(r17, this.h);
    L40:
        GiftTrayMessageManager r18 = GiftTrayMessageManager.r;
        GiftTrayMessageManager r19 = GiftTrayMessageManager.a.a();
        r19.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        r19.k = this;
        r02.b r20 = this.m;
        r20.j = this.n;
        r20.k = this.g;
        GiftTrayMessageManager r21 = GiftTrayMessageManager.a.a();
        r21.i = this.g;
        if (((ys1.a) com.bytedance.android.livesdk.gift.platform.business.b.w.getValue(null, com.bytedance.android.livesdk.gift.platform.business.b.a[21])).c() == false) goto L46;
        RxUtilKt.c(w.a("EVENT_WEB_SHOW", AnonymousClass4.INSTANCE), this.h);
        RxUtilKt.c(w.a("EVENT_WEB_CLOSE", AnonymousClass5.INSTANCE), this.h);
        return;
    L46:
        return;
    L21:
        r8 = 12.0f;
        goto L22
    L45:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public s02.d getOnGiftTrayIdleStateListener() {
        return this.l;
    }

    public static final /* synthetic */ int p(MatchRoomGiftTrayAnimationView r0) {
        return r0.getGiftToHotMsgTrayMargin();
    }

    public static final /* synthetic */ int q(MatchRoomGiftTrayAnimationView r0) {
        return r0.getOriginalTopMargin();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(MatchRoomGiftTrayAnimationView r3) {
        if (r3.i != null) goto L9;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L8;
        r3.i = (ViewGroup.MarginLayoutParams) r0;
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ViewGroup.MarginLayoutParams r1 = r3.i;
        if (r1 == null) goto L19;
        int r2 = r3.getGatherHeight();
        if (r2 > 0) goto L16;
        r2 = r3.getOriginalTopMargin();
    L16:
        if (r1.topMargin == r2) goto L20;
        r1.topMargin = r2;
        r3.setLayoutParams(r1);
        return;
    L20:
        return;
    }

    private final void setAnchor(boolean r1) {
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L6;
        ((k) r2.getMessageDispatcher().getValue()).getClass();
        return;
    }

    private final void setMAnchor(IBaseUser r2) {
        this.k = r2;
        GiftContext r0 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r0 == null) goto L6;
        ((k) r0.getMessageDispatcher().getValue()).a = r2;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.y
    public final boolean Lc(NormalGiftMessage r8) {
        StringBuilder r0 = new StringBuilder();
        if (r8 == null) goto L18;
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.d.getClass();
        com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a r2 = com.bytedance.android.livesdk.gift.platform.core.utils.recorder.e.a.C0075a.e;
        r2.b.d(Long.valueOf(r8.a), "onConsumeMessage");
        r0.append("audioGiftTray;");
        if ((r8 instanceof com.bytedance.android.livesdk.gift.platform.business.tray.a) == false) goto L9;
        if (b02.a.b(r8) == true) goto L9;
    L13:
        r02.b r3 = this.m;
        if (r3.b == false) goto L17;
        r3.c();
        GiftTrayMessageManager r1 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r8, false);
        GiftTrayMessageManager.a.a().g = r8;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r8);
        this.m.f(r8);
        return true;
    L17:
        r0.append("mTop idle false ");
        r2.b.d(Long.valueOf(r8.a), r8.b + " not consume this time");
    L9:
        if (this.m.i(r8) == false) goto L12;
        GiftTrayMessageManager r4 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i(r8, false);
        GiftTrayMessageManager.a.a().g = r8;
        GiftTrayMessageManager.a.a().getClass();
        GiftTrayMessageManager.k(r8);
        return true;
    L12:
        r0.append("mTop continue false;");
    L18:
        com.bytedance.android.livesdk.gift.platform.core.utils.c.c(this.e, "Consume failed " + r8 + ' ' + r0);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void l(boolean r4) {
        if (getChildCount() > 0) goto L6;
        return;
    L6:
        if (r4 == false) goto L8;
        BaseGiftTrayAnimationView.n(this, 0, false, 2);
        return;
    L8:
        BaseGiftTrayAnimationView.n(this, 0, true, 1);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setOnGiftTrayIdleStateListener(s02.d r1) {
        this.l = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public void setPortrait(boolean r1) {
        GiftContext r2 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r2 == null) goto L6;
        ((k) r2.getMessageDispatcher().getValue()).getClass();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void o(MatchRoomGiftTrayAnimationView r3, int r4) {
        if (r3.i != null) goto L9;
        ViewGroup.LayoutParams r0 = r3.getLayoutParams();
        if (r0 == null) goto L8;
        r3.i = (ViewGroup.MarginLayoutParams) r0;
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L9:
        ViewGroup.MarginLayoutParams r1 = r3.i;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.topMargin == r4) goto L23;
        ValueAnimator r2 = r3.j;
        if (r2 == null) goto L17;
        r2.removeAllUpdateListeners();
    L17:
        ValueAnimator r5 = r3.j;
        if (r5 == null) goto L20;
        r5.cancel();
    L20:
        ValueAnimator r6 = ValueAnimator.ofInt(new int[]{r1.topMargin, r4});
        r6.setDuration(100);
        r6.addUpdateListener(new h(r3));
        r6.start();
        Unit r7 = Unit.INSTANCE;
        r3.j = r6;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void k(GiftTrayWidget.c r2, GiftTrayWidget.b r3) {
        Intrinsics.checkNotNullParameter(r2, "topListener");
        Intrinsics.checkNotNullParameter(r3, "bottomListener");
        this.g = r2;
        this.m.k = r2;
        GiftTrayMessageManager r4 = GiftTrayMessageManager.r;
        GiftTrayMessageManager.a.a().i = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MatchRoomGiftTrayAnimationView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = "MatchRoomGiftTrayAnimationView";
        this.f = n12.e.a();
        this.h = new CompositeDisposable();
        r02.b r5 = new r02.b(r2, this, 2);
        this.m = r5;
        a r6 = new a(this);
        this.n = r6;
        r5.j = r6;
    }

    public /* synthetic */ MatchRoomGiftTrayAnimationView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.tray2.BaseGiftTrayAnimationView
    public final void j(int r2, boolean r3, boolean r4, User r5) {
        r02.b r0 = this.m;
        r0.l = r2;
        r0.r = r3;
        r0.t = r4;
        r0.j(r0.i);
        setMAnchor(r5);
    }
}
